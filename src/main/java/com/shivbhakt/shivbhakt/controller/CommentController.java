package com.shivbhakt.shivbhakt.controller;

import com.shivbhakt.shivbhakt.payload.CommentDto;
import com.shivbhakt.shivbhakt.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class CommentController {
    @Autowired
    private CommentService commentService;

    @PostMapping("/comment/{productId}")
    public ResponseEntity<CommentDto> createComment(@RequestBody CommentDto commentDto,@PathVariable Integer productId ){
        CommentDto commentDto1=this.commentService.createComment(productId,commentDto);
        return  new ResponseEntity<>(commentDto1, HttpStatus.CREATED);
    }

    @GetMapping("/comment/{productId}")
    public  ResponseEntity<List<CommentDto>>getCommentByProduct(@PathVariable Integer productId){
     List<CommentDto> commentDtos= this.commentService.getCommentByProduct(productId);
    return  new ResponseEntity<>(commentDtos,HttpStatus.OK);
    }
    @PutMapping("/comment/{commentId}")
    public ResponseEntity<CommentDto> updateComment(@RequestBody CommentDto commentDto,@PathVariable Integer commentId){
    CommentDto commentDto1 = this.commentService.updateComment(commentDto,commentId);
    return new ResponseEntity<>(commentDto1,HttpStatus.OK);
    }

    @DeleteMapping("/comment/{commentId}")
    public void deleteComment(@PathVariable Integer commentId){
        this.commentService.deleteComment(commentId);
    }

}
