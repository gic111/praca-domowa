package org.example.app.controller;

import org.example.app.dao.ArticleDao;
import org.example.app.model.Article;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@Controller
public class HomePageController {

    public final ArticleDao articleDao;

    public HomePageController(ArticleDao articleDao) {
        this.articleDao = articleDao;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String home() {
        return "limit5";
    }

    @ModelAttribute("limit")
    public List<Article> articles() {
        return articleDao.findLastFive();
    }

}