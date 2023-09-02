package com.shivbhakt.shivbhakt.controller;

import com.shivbhakt.shivbhakt.payload.ReplyDto;
import com.shivbhakt.shivbhakt.service.ReplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class ReplyController {
    @Autowired
    private ReplyService replyService;

    @PostMapping("/reply/{commentId}")
    public ResponseEntity<ReplyDto> createReply(@RequestBody ReplyDto replyDto,@PathVariable Integer commentId){
    ReplyDto replyDto1=this.replyService.createReply(replyDto,commentId);
    return  new ResponseEntity<>(replyDto1, HttpStatus.CREATED);
    }
    @PutMapping("/reply/{replyId}")
    public ResponseEntity<ReplyDto> editReply(@RequestBody ReplyDto replyDto,@PathVariable Integer replyId){
        ReplyDto replyDto1=this.replyService.editReply(replyId,replyDto);
        return  new ResponseEntity<>(replyDto1, HttpStatus.CREATED);
    }
    @DeleteMapping("/reply/{replyId}")
    public void deleteComment(@PathVariable Integer replyId){
        this.replyService.deleteReply(replyId);
    }

    @GetMapping("/reply/{commentId}")
    public  ResponseEntity<List<ReplyDto>> getReplyByComment(@PathVariable Integer commentId){
        List<ReplyDto> replyDtos = this.replyService.getReplyByComment(commentId);
        return  new ResponseEntity<>(replyDtos,HttpStatus.OK);
    }

}
