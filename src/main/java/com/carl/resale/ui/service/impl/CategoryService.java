package com.carl.resale.ui.service.impl;

import com.carl.resale.ui.bean.Category;
import com.carl.resale.ui.dao.ICategoryDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Carl
 * @date 2016/3/27
 * @modify 版权所有.(c)2008-2016.广州市森锐电子科技有限公司
 */
@Service("categoryService")
public class CategoryService implements ICategoryDao {
    @Autowired
    private ICategoryDao categoryDao;

    @Override
    public List<Category> getHomePageCategory(int size) {
        return categoryDao.getHomePageCategory(size);
    }
}
