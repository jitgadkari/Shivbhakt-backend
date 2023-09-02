package com.shivbhakt.shivbhakt.service;

import com.shivbhakt.shivbhakt.entity.Comment;
import com.shivbhakt.shivbhakt.payload.ReplyDto;

import java.util.List;

public interface ReplyService {

    ReplyDto createReply(ReplyDto replyDto,Integer commentId);
    ReplyDto editReply(Integer replyId, ReplyDto replyDto);
    void  deleteReply(Integer replyId);

    ReplyDto getSingleReply(Integer replyId);
    List<ReplyDto> getAllReply();

    List<ReplyDto> getReplyByComment(Integer commentId);
}
