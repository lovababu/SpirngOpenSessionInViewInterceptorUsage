package org.avol.spring.jpa;

import org.avol.spring.jpa.domains.Comment;
import org.avol.spring.jpa.domains.Post;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Durga on 10/26/2015.
 */
public final class DataUtil {

    public static Post postDomain(org.avol.spring.jpa.model.Post post){
        Post postDomain = new Post();
        postDomain.setPost(post.getMsg());
        postDomain.setComments(commentDomains(post.getComments(), postDomain));
        return postDomain;
    }

    private static List<Comment> commentDomains(List<org.avol.spring.jpa.model.Comment> comments, Post post) {
        List<Comment> commentDomains = new ArrayList<Comment>();
        for (org.avol.spring.jpa.model.Comment c: comments) {
            Comment com = new Comment();
            com.setComment(c.getComment());
            com.setPost(post);
            commentDomains.add(com);
        }
        return commentDomains;
    }

    public static org.avol.spring.jpa.model.Post postModel(Post post) {
        org.avol.spring.jpa.model.Post model = new org.avol.spring.jpa.model.Post();
        model.setId(post.getId());
        model.setMsg(post.getPost());
        model.setComments(commentModels(post.getComments()));
        return model;
    }

    private static List<org.avol.spring.jpa.model.Comment> commentModels(List<Comment> comments) {
        List<org.avol.spring.jpa.model.Comment> commentModels = new ArrayList<>();
        for (Comment c: comments) {
            org.avol.spring.jpa.model.Comment com = new org.avol.spring.jpa.model.Comment();
            com.setId(c.getId());
            com.setComment(c.getComment());
            commentModels.add(com);
        }
        return commentModels;
    }
}
