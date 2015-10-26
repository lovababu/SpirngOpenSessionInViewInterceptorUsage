package org.avol.spring.jpa.service.impl;

import org.avol.spring.jpa.dao.PostDao;
import org.avol.spring.jpa.domains.Post;
import org.avol.spring.jpa.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Durga on 10/26/2015.
 */
@Service
public class PostServiceImpl implements PostService {

    @Autowired
    private PostDao postDao;

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public Serializable post(Post post) {
        return postDao.post(post);
    }

    @Override
    @Transactional(readOnly = true)
    public Post getPost(Long id) {
        return postDao.getPost(id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Post> findAll() {
        return postDao.findAll();
    }
}
