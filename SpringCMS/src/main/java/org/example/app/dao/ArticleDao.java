package org.example.app.dao;
import org.example.app.model.Article;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
@Transactional
public class ArticleDao {

    @PersistenceContext
    EntityManager entityManager;

    public void create(Article article) {
        this.entityManager.merge(article);
    }

    public void delete(Article article) {
        this.entityManager.remove(this.entityManager.contains(article) ?
                article : this.entityManager.merge(article));
    }

    public void update(Article article) {
        this.entityManager.merge(article);
    }

    public List<Article> findAll() {
        Query query = entityManager.createQuery("SELECT a FROM Article a");
        return query.getResultList();
    }

    public List<Article> findLastFive() {
        Query query = entityManager.createQuery("SELECT a FROM Article a ORDER BY a.created DESC");
        query.setMaxResults(5);
        return query.getResultList();
    }

    public Article findById(Integer id) {
        return entityManager.find(Article.class, id);
    }
}