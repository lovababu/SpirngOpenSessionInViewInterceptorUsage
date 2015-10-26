package org.avol.spring.jpa;

import org.avol.spring.jpa.config.PostAppConfig;
import org.avol.spring.jpa.domains.Comment;
import org.avol.spring.jpa.domains.Post;
import org.avol.spring.jpa.service.PostService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.Serializable;
import java.util.Arrays;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

/**
 * Created by Durga on 10/26/2015.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = PostAppConfig.class)
public class SpringOSIVInterceptorTest {


    @Autowired
    private PostService postService;

    @Test
    public void testPost() {
        Serializable id = postService.post(post("My first post here."));
        System.out.println("SpringOSIVInterceptorTest.testPost :" + id);
        assertNotNull(id);
    }

    @Test
    public void getPost() {
        Post post = postService.getPost(1L);
        assertNotNull(post);
        assertTrue(post.getComments().size() > 0);
        assertTrue(post.getComments().get(0).getComment().equalsIgnoreCase("this is comment."));
    }

    private Post post(String msg) {
        Post post = new Post();
        post.setPost(msg);
        Comment comment = new Comment();
        comment.setComment("this is comment.");
        comment.setPost(post);
        post.setComments(Arrays.asList(comment));
        return post;
    }
}
