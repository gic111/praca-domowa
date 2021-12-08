package org.example.app;
import org.example.app.dao.CategoryDao;
import org.example.app.model.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;


public class CategoryConverter implements Converter<String, Category> {

    @Autowired
    private CategoryDao categoryDao;

    @Override
    public Category convert(String source) {
        return categoryDao.findById(Integer.parseInt(source));
    }
}

