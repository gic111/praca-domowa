package org.example.app.dao;

import org.example.app.model.Category;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
@Transactional
public class CategoryDao {

    @PersistenceContext
    EntityManager entityManager;

    public void create(Category category) {
        this.entityManager.merge(category);
    }

    public void delete(Category category) {
        this.entityManager.remove(this.entityManager.contains(category) ?
                category : this.entityManager.merge(category));
    }

    public void update(Category category) {
        this.entityManager.merge(category);
    }

    public List<Category> findAll() {
        Query query = entityManager.createQuery("SELECT c FROM Category c");
        return query.getResultList();
    }

    public Category findById(Integer id) {
        return entityManager.find(Category.class, id);
    }
}