package com.shivbhakt.shivbhakt.serviceImpl;

import com.shivbhakt.shivbhakt.entity.Comment;
import com.shivbhakt.shivbhakt.entity.Reply;
import com.shivbhakt.shivbhakt.payload.ReplyDto;
import com.shivbhakt.shivbhakt.repository.CommentRepository;
import com.shivbhakt.shivbhakt.repository.ReplyRepository;
import com.shivbhakt.shivbhakt.service.ReplyService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
@Service
public class ReplyServiceImpl implements ReplyService {
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private ReplyRepository replyRepository;
    @Autowired
    private CommentRepository commentRepository;
    @Override
    public ReplyDto createReply(ReplyDto replyDto, Integer commentId) {
        Comment comment= this.commentRepository.findById(commentId).orElseThrow(()->new RuntimeException("Comment Not found with this id"));
        Reply reply=this.modelMapper.map(replyDto,Reply.class);
        reply.setComment(comment);
        Reply saveReply= this.replyRepository.save(reply);
        ReplyDto replyDto1=this.modelMapper.map(saveReply,ReplyDto.class);
        return replyDto1;
    }

    @Override
    public ReplyDto editReply(Integer replyId, ReplyDto replyDto) {
        Reply reply= this.replyRepository.findById(replyId).orElseThrow(()->new RuntimeException("reply not found with this Id"));
        reply.setReply(replyDto.getReply());
        Reply saveReply=this.replyRepository.save(reply);
        ReplyDto replyDto1=this.modelMapper.map(saveReply,ReplyDto.class);
        return replyDto1;
    }

    @Override
    public void deleteReply(Integer replyId) {
        Reply reply= this.replyRepository.findById(replyId).orElseThrow(()->new RuntimeException("reply not found with this Id"));
        this.replyRepository.delete(reply);
    }

    @Override
    public ReplyDto getSingleReply(Integer replyId) {
        Reply reply= this.replyRepository.findById(replyId).orElseThrow(()->new RuntimeException("reply not found with this Id"));
        ReplyDto replyDto= this.modelMapper.map(reply,ReplyDto.class);
        return replyDto;
    }

    @Override
    public List<ReplyDto> getAllReply() {
        List<Reply> replys=this.replyRepository.findAll();
        List<ReplyDto> replyDtos1=replys.stream().map(reply -> this.modelMapper.map(reply,ReplyDto.class)).collect(Collectors.toList());
        return replyDtos1;
    }

    @Override
    public List<ReplyDto> getReplyByComment(Integer commentId) {
        Comment comment= this.commentRepository.findById(commentId).orElseThrow(()->new RuntimeException("Comment Not found with this id"));
        List<Reply> replies= this.replyRepository.findByComment(comment);
        List<ReplyDto> replyDtos=replies.stream().map(reply -> this.modelMapper.map(reply,ReplyDto.class)).collect(Collectors.toList());
        return replyDtos;
    }
}
