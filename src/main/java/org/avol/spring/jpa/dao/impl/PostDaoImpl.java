package org.avol.spring.jpa.dao.impl;

import org.avol.spring.jpa.dao.PostDao;
import org.avol.spring.jpa.domains.Post;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Durga on 10/26/2015.
 */
@Repository
public class PostDaoImpl implements PostDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public Serializable post(Post post) {
        return sessionFactory.getCurrentSession().save(post);
    }

    @Override
    public Post getPost(Long id) {
        return (Post) sessionFactory.getCurrentSession().get(Post.class, id);
    }

    @Override
    public List<Post> findAll() {
        return sessionFactory.getCurrentSession().createQuery("FROM Post").list();
    }
}
