package org.avol.spring.jpa.dao;

import org.avol.spring.jpa.domains.Post;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Durga on 10/26/2015.
 */
public interface PostDao {

    Serializable post(Post post);

    Post getPost(Long id);

    List<Post> findAll();
}
