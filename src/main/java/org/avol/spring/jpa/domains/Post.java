package org.avol.spring.jpa.domains;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

/**
 * Created by Durga on 10/26/2015.
 */

@Setter @Getter
@Entity
@Table(name = "POSTS")
public class Post {

    @Id
    @Column(name = "POST_ID")
    @GenericGenerator(name = "increment",  strategy = "increment")
    @GeneratedValue(generator = "increment")
    private Long id;

    @Column(name = "POST_MSG")
    private String post;


    @OneToMany(cascade = CascadeType.ALL, mappedBy = "post", targetEntity = Comment.class)
    private List<Comment> comments;
}
