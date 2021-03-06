package com.carl.resale.ui.ctrl.file;

import com.carl.resale.ui.ctrl.BaseCtrl;
import com.carl.resale.ui.service.impl.FileService;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * 常量类
 *
 * @author Carl
 * @date 2016/3/28
 * @modify 版权所有.(c)2008-2016.广州市森锐电子科技有限公司
 */
@Controller
@RequestMapping("file")
public class FileCtrl extends BaseCtrl {
    @Autowired
    private FileService fileService;

    @RequestMapping("img/{id}.{type}")
    @ResponseBody
    public void getImage(@PathVariable String id, @PathVariable String type, HttpServletRequest request, HttpServletResponse res) {
        try {
           /* File file = fileService.getFileByIdAndType(id, type);
            res.setContentType("image/" + type);
            //写出去还是，转发过去
            write(res, file);*/

            //直接转发回去
            String filePath = fileService.getFilePathByIdAndType(id, type);
            RequestDispatcher dispatcher = request.getRequestDispatcher("~/" + filePath);
            dispatcher.forward(request, res);
        } catch (Exception e) {
            logger.error(e);
        }
    }

    /**
     * 写出文件
     *
     * @param res
     * @param file
     * @throws IOException
     */
    private void write(HttpServletResponse res, File file) throws IOException {
        OutputStream os = res.getOutputStream();
        try {
            res.reset();
            //下载时需要
//            res.setHeader("Content-Disposition", "attachment; filename=" + file.getName());
            res.setHeader("Last-Modified", formatModifyDate(com.carl.resale.util.FileUtils.fileLastModifyDate(file)));
            res.setCharacterEncoding("UTF-8");
//            res.setContentType("application/octet-stream; charset=utf-8");
            os.write(FileUtils.readFileToByteArray(file));
            os.flush();
        } finally {
            if (os != null) {
                os.close();
            }
        }
    }

    @Override
    protected String getModuleName() {
        return "file";
    }

    /**
     * 获取文件最后修改时间
     *
     * @param date
     * @return
     */
    private String formatModifyDate(Date date) {
        Format simpleFormat = new SimpleDateFormat("E, dd MMM yyyy hh:mm:ss", Locale.ENGLISH);
        String dateString = simpleFormat.format(date);
        return dateString + " GMT";
    }
}
