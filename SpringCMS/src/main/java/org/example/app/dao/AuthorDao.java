package org.example.app.dao;
import org.example.app.model.Author;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
@Transactional
public class AuthorDao {

    @PersistenceContext
    EntityManager entityManager;

    public void create(Author author) {
        this.entityManager.merge(author);
    }

    public void delete(Author author) {
        this.entityManager.remove(this.entityManager.contains(author) ?
                author : this.entityManager.merge(author));
    }

    public void update(Author author) {
        this.entityManager.merge(author);
    }

    public List<Author> findAll() {
        Query query = entityManager.createQuery("SELECT a FROM Author a");
        return query.getResultList();
    }

    public Author findById(Integer id) {
        return entityManager.find(Author.class, id);
    }
}