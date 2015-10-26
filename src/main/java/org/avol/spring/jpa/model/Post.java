package org.avol.spring.jpa.model;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * Created by Durga on 10/26/2015.
 */

@Setter @Getter
public class Post {

    private String msg;
    private long id;
    private List<Comment> comments;

}
