package com.carl.resale.ui.ctrl.welcome;

import com.carl.resale.ui.ctrl.BaseCtrl;
import com.carl.resale.ui.repositories.HotAdvantageRepository;
import com.carl.resale.ui.service.impl.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.concurrent.Callable;

/**
 * 首页控制器
 *
 * @author Carl
 * @date 2016/3/18
 * @modify 版权所有.(c)2008-2016.广州市森锐电子科技有限公司
 */
@Controller
@RequestMapping("/")
public class HomePageCtrl extends BaseCtrl {

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private HotAdvantageRepository hotAdvantageRepository;


    @RequestMapping("")
    public String index() {
        return "jsp/index";
    }

    /**
     * 首页品牌
     *
     * @param model
     * @return
     */
    @RequestMapping("index/brand")
    public String indexBrand(Model model) {
        model.addAttribute("brands", categoryService.getHomeCategory(12));
        return FREEMARKER + getWarpModuleName() + "brand";
    }

    @RequestMapping("/response-body")
    public @ResponseBody
    Callable<String> callable() {

        return new Callable<String>() {
            @Override
            public String call() throws Exception {
                Thread.sleep(5000);
                return "Callable result";
            }
        };
    }

    /**
     * 热门广告
     * @param model
     * @return
     */
    @RequestMapping("index/hotAdv")
    public String hotAdv(Model model) {
        model.addAttribute("hotAdv", hotAdvantageRepository.getHomePageHotAdv());
        return FREEMARKER + getWarpModuleName() + "hotAdv";
    }

    /**
     * 底部
     *
     * @return
     */
    @RequestMapping("index/footer")
    public String indexFooter() {
        return JSP + getWarpModuleName() + "footer";
    }

    /**
     * 头部
     *
     * @return
     */
    @RequestMapping("index/header")
    public String indexHeader() {
        return JSP + getWarpModuleName() + "header";
    }

    /**
     * 头部
     *
     * @return
     */
    @RequestMapping("index/main")
    public String indexMain() {
        return JSP + getWarpModuleName() + "main";
    }

    @Override
    protected String getModuleName() {
        return "home";
    }

    /**
     * 基础用于导入
     *
     * @return
     */
    @RequestMapping("/base")
    public String base() {
        return JSP + SEPARATOR + "base";
    }
}
