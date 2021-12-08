package org.example.app.controller;

import org.example.app.dao.AuthorDao;
import org.example.app.model.Author;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import java.util.List;

@Controller
public class AuthorController {

    public final AuthorDao authorDao;


    public AuthorController(AuthorDao authorDao) {
        this.authorDao = authorDao;
    }

    @RequestMapping(value = "/author/all", method = RequestMethod.GET)
    public String findAll() {
        return "author";
    }

    @RequestMapping(value = "/author/form/add", method = RequestMethod.GET)
    public String add(Model model) {
        model.addAttribute("author", new Author());
        return "addauthor";
    }

    @RequestMapping(value = "/author/add", method = RequestMethod.POST)
    public String addHandle(Author author) {
        authorDao.create(author);
        return "success";
    }

    @RequestMapping(value = "/author/form/del", method = RequestMethod.GET)
    public String del(Model model) {
        model.addAttribute("author", new Author());
        return "delauthor";
    }

    @RequestMapping(value = "/author/del", method = RequestMethod.POST)
    public String delHandle(Integer id) {
        Author author = authorDao.findById(id);
        authorDao.delete(author);
        return "success";
    }

    @RequestMapping(value = "/author/form/edit", method = RequestMethod.GET)
    public String edit(Model model) {
        model.addAttribute("author", new Author());
        return "editauthor";
    }

    @RequestMapping(value = "/author/edit", method = RequestMethod.POST)
    public String editHandle(Integer id, String firstName, String lastName) {
        Author author = authorDao.findById(id);
        author.setFirstName(firstName);
        author.setLastName(lastName);
        authorDao.update(author);
        return "success";
    }

    @ModelAttribute("authors")
    public List<Author> authors() {
        return authorDao.findAll();
    }

}