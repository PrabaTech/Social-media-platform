package com.socialmedia.Social_Media_App.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String content;

    //one post can have many comments
    @ManyToOne
    @JoinColumn(name = "post_id",nullable = false)
    private Post post;

}
