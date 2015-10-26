package org.avol.spring.jpa.domains;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Created by Durga on 10/26/2015.
 */

@Setter @Getter
@Entity
@Table(name = "COMMENTS")
public class Comment {

    @Id
    @Column(name = "COMMENT_ID")
    @GenericGenerator(name = "increment",  strategy = "increment")
    @GeneratedValue(generator = "increment")
    private Long id;

    @Column(name = "COMMENT_MSG")
    private String comment;

    @ManyToOne(cascade = CascadeType.ALL, targetEntity = Post.class)
    @JoinColumn(name = "POST_ID", nullable = false)
    private Post post;
}
