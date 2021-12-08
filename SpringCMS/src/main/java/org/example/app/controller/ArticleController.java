package org.example.app.controller;
import org.example.app.dao.ArticleDao;
import org.example.app.dao.AuthorDao;
import org.example.app.dao.CategoryDao;
import org.example.app.model.Article;
import org.example.app.model.Author;
import org.example.app.model.Category;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import java.util.List;

@Controller
public class ArticleController {

    public final ArticleDao articleDao;
    public final AuthorDao authorDao;

    public final CategoryDao categoryDao;

    public ArticleController(ArticleDao articleDao, AuthorDao authorDao, CategoryDao categoryDao) {
        this.articleDao = articleDao;
        this.authorDao = authorDao;
        this.categoryDao = categoryDao;
    }

    @RequestMapping(value = "/article/all", method = RequestMethod.GET)
    public String findAll() {
        return "article";
    }

    @RequestMapping(value = "/article/form/add", method = RequestMethod.GET)
    public String add(Model model) {
        model.addAttribute("article", new Article());
        return "addarticle";
    }

    @RequestMapping(value = "/article/add", method = RequestMethod.POST)
    public String addHandle(Article article) {
        article.setCreated();
        article.setUpdated();
        articleDao.create(article);
        return "success";
    }

    @RequestMapping(value = "/article/form/del", method = RequestMethod.GET)
    public String del(Model model) {
        model.addAttribute("article", new Article());
        return "delarticle";
    }

    @RequestMapping(value = "/article/del", method = RequestMethod.POST)
    public String delHandle(Integer id) {
        Article article = articleDao.findById(id);
        articleDao.delete(article);
        return "success";
    }

    @RequestMapping(value = "/article/form/edit", method = RequestMethod.GET)
    public String edit(Model model) {
        model.addAttribute("article", new Article());
        return "editarticle";
    }

    @RequestMapping(value = "/article/edit", method = RequestMethod.POST)
    public String editHandle(Integer id, String title, String content) {
        Article article = articleDao.findById(id);
        article.setTitle(title);
        article.setContent(content);
        article.setUpdated();
        articleDao.update(article);
        return "success";
    }

    @ModelAttribute("articles")
    public List<Article> articles() {
        return articleDao.findAll();
    }

    @ModelAttribute("authors")
    public List<Author> authors() {
        return authorDao.findAll();
    }

    @ModelAttribute("category")
    public List<Category> categories() {
        return categoryDao.findAll();
    }


    @RequestMapping("/article/add")
    public String add() {
        Author author = new Author();
        author.setFirstName("James ");
        author.setLastName("Clayton");
        Category category1 = new Category();
        category1.setName("main");
        List<Category> categories = List.of(category1);
        Article article = new Article();
        article.setTitle("Tesla shares slide could put Musk's");
        article.setAuthor(author);
        article.setCategories(categories);
        article.setContent("Tesla shares have fallen after investor concerns that boss Elon Musk may have to sell shares in the electric car maker to help pay for the takeover of Twitter.");
        article.setCreated();
        article.setUpdated();
        articleDao.create(article);
        return "success";
    }
}