package org.example.app.controller;
import org.example.app.dao.CategoryDao;
import org.example.app.model.Category;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class CategoryController {

    public final CategoryDao categoryDao;


    public CategoryController(CategoryDao categoryDao) {
        this.categoryDao = categoryDao;
    }

    @RequestMapping(value = "/category/all", method = RequestMethod.GET)
    public String findAll() {
        return "category";
    }

    @RequestMapping(value = "/category/form/add", method = RequestMethod.GET)
    public String add(Model model) {
        model.addAttribute("category", new Category());
        return "addcategory";
    }

    @RequestMapping(value = "/category/add", method = RequestMethod.POST)
    public String addHandle(Category category) {
        categoryDao.create(category);
        return "success";
    }

    @RequestMapping(value = "/category/form/del", method = RequestMethod.GET)
    public String del(Model model) {
        model.addAttribute("category", new Category());
        return "delcategory";
    }

    @RequestMapping(value = "/category/del", method = RequestMethod.POST)
    public String delHandle(Integer id) {
        Category category = categoryDao.findById(id);
        categoryDao.delete(category);
        return "success";
    }

    @RequestMapping(value = "/category/form/edit", method = RequestMethod.GET)
    public String edit(Model model) {
        model.addAttribute("category", new Category());
        return "editcategory";
    }

    @RequestMapping(value = "/category/edit", method = RequestMethod.POST)
    public String editHandle(Integer id, String name, String description) {
        Category category = categoryDao.findById(id);
        category.setName(name);
        category.setDescription(description);
        categoryDao.update(category);
        return "success";
    }

    @ModelAttribute("categories")
    public List<Category> categories() {
        return categoryDao.findAll();
    }

}