package com.shivbhakt.shivbhakt.repository;

import com.shivbhakt.shivbhakt.entity.Comment;
import com.shivbhakt.shivbhakt.entity.Reply;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReplyRepository extends JpaRepository<Reply,Integer> {
    List<Reply> findByComment(Comment comment);
}
