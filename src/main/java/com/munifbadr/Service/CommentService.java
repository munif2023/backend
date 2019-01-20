package com.munifbadr.Service;


import com.munifbadr.Dtos.CommentDto;
import com.munifbadr.Entity.Comment;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CommentService {

    ResponseEntity<Comment> Create(Long userid, Long eventid, Comment comment);

    public ResponseEntity Delete(Long id);

    ResponseEntity update(CommentDto commentDto,Long id);

    List<CommentDto> findall();

    List<Comment> getComment(Long id);

}
