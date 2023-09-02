package com.shivbhakt.shivbhakt.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Comment")
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "commentId")
    private Integer commentId;
    private String comment;
    @ManyToOne
    private Product product;

    @OneToMany(mappedBy = "comment",cascade = CascadeType.ALL)
//    @JoinColumn(name = "fk_comment_Id",referencedColumnName = "commentId")
    private List<Reply> reply;

}
