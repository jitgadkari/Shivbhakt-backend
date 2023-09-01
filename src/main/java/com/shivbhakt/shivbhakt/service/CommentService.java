package com.shivbhakt.shivbhakt.service;

import com.shivbhakt.shivbhakt.payload.CommentDto;
import com.shivbhakt.shivbhakt.payload.ProductDto;

import java.util.List;


public interface CommentService {
    CommentDto createComment(Integer productId ,CommentDto commentDto);

//    List<CommentDto> getAllComment();

//    CommentDto getSingleComment(Integer commentId);

    List<CommentDto> getCommentByProduct(Integer productId);

    CommentDto updateComment(CommentDto commentDto,Integer commentId);

    void deleteComment(Integer commentId);

}
