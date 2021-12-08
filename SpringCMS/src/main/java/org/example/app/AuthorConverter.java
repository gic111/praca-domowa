package org.example.app;
import org.example.app.dao.AuthorDao;
import org.example.app.model.Author;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;


public class AuthorConverter implements Converter<String, Author> {

    @Autowired
    private AuthorDao authorDao;

    @Override
    public Author convert(String source) {
        return authorDao.findById(Integer.parseInt(source));
    }
}