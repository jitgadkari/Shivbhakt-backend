package com.shivbhakt.shivbhakt.serviceImpl;

import com.shivbhakt.shivbhakt.entity.Comment;
import com.shivbhakt.shivbhakt.entity.Product;
import com.shivbhakt.shivbhakt.payload.CommentDto;
import com.shivbhakt.shivbhakt.payload.ProductDto;
import com.shivbhakt.shivbhakt.repository.CommentRepository;
import com.shivbhakt.shivbhakt.repository.ProductRepository;
import com.shivbhakt.shivbhakt.service.CommentService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
@Service
public class CommentServiceImpl implements CommentService {
    @Autowired
    private CommentRepository commentRepository;
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private ProductRepository productRepository;

    @Override
    public CommentDto createComment(Integer productId,CommentDto commentDto) {
        Product product=this.productRepository.findById(productId).orElseThrow(()->new RuntimeException("product not found with Id"+productId));
        Comment comment = this.modelMapper.map(commentDto, Comment.class);
        comment.setProduct(product);
        Comment comment1=this.commentRepository.save(comment);
        CommentDto commentDto1= this.modelMapper.map(comment1,CommentDto.class);
        return commentDto1;
    }

//    @Override
//    public List<CommentDto> getAllComment() {
//        List<Comment> comments= this.commentRepository.findAll();
//        List<CommentDto> commentDtos=comments.stream().map((com)->this.modelMapper.map(com,CommentDto.class)).collect(Collectors.toList());
//        return commentDtos;
//    }

//    @Override
//    public CommentDto getSingleComment(Integer commentId) {
//       Comment comment= this.commentRepository.findById(commentId).orElseThrow(()->new RuntimeException("comment not found with this Id"+commentId));
//       CommentDto commentDto=this.modelMapper.map(comment,CommentDto.class);
//       return commentDto;
//    }

    @Override
    public List<CommentDto> getCommentByProduct(Integer productId) {
        Product product= this.productRepository.findById(productId).orElseThrow(()->new RuntimeException("product not found with id"+ productId));
        List<Comment> comments=this.commentRepository.findByProduct(product);
        List<CommentDto> commentDtos=comments.stream().map((com)->this.modelMapper.map(com,CommentDto.class)).collect(Collectors.toList());
        return commentDtos;
    }

    @Override
    public CommentDto updateComment(CommentDto commentDto,Integer commentId) {
    Comment  comment=this.commentRepository.findById(commentId).orElseThrow(()->new RuntimeException("comment not found with Id"+commentId));
    comment.setComment(commentDto.getComment());
    CommentDto commentDto1= this.modelMapper.map(comment,CommentDto.class);
        return commentDto1;
    }

    @Override
    public void deleteComment(Integer commentId) {
        Comment comment=this.commentRepository.findById(commentId).orElseThrow(()->new RuntimeException( "comment not found with this Id "+commentId));
        this.commentRepository.delete(comment);
    }



}
