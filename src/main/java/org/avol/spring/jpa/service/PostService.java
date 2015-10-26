package org.avol.spring.jpa.service;

import org.avol.spring.jpa.domains.Post;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Durga on 10/26/2015.
 */
public interface PostService {

    Serializable post(Post post);

    Post getPost(Long id);

    List<Post> findAll();
}
