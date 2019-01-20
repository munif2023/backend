package com.munifbadr.Service.ServiceImp;

import com.munifbadr.Dtos.CommentDto;
import com.munifbadr.Entity.Comment;
import com.munifbadr.Entity.Event;
import com.munifbadr.Entity.Users;
import com.munifbadr.mapping.ObjectMapperUtils;
import com.munifbadr.Repositories.CommentRepository;
import com.munifbadr.Repositories.EventRepository;
import com.munifbadr.Repositories.UsersRepository;
import com.munifbadr.Service.CommentService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class CommentServiceImp implements CommentService {
    @Autowired
    private UsersRepository usersRepository;
    @Autowired
    private EventRepository eventRepository;
    @Autowired
    private CommentRepository commentRepository;
     @Autowired
     private ModelMapper modelMapper;

    @Override
    public ResponseEntity<Comment> Create(Long userid, Long eventid, Comment comment) {
    if(usersRepository.findById(userid).isPresent()&&eventRepository.findById(eventid).isPresent()){
        Event event=eventRepository.findById(eventid).get();
        Users users=usersRepository.findById(userid).get();
        LocalDateTime dateTime=LocalDateTime.now().minusSeconds(20);
        long counter=commentRepository.countByEventAndUsersAndLocalDateTimeIsAfter(event,users,dateTime);
        if (counter==0){
            comment.setUsers(users);
            comment.setEvent(event);
            comment.setLocalDateTime(LocalDateTime.now());
            commentRepository.save(comment);
            return ResponseEntity.ok(comment);
        }
        return new ResponseEntity("you should wait 20 seconds to comment again", HttpStatus.BAD_REQUEST);
    }
        return new ResponseEntity("user id or event id not found ", HttpStatus.NOT_FOUND);
    }

    @Override
    public ResponseEntity Delete(Long id) {

        if (commentRepository.findById(id).isPresent()){
            commentRepository.findById(id).get().setDflag(true);
            return ResponseEntity.ok().build();
        }

      return   ResponseEntity.notFound().build();

    }

    @Override
    public ResponseEntity update(CommentDto commentDto, Long id) {
        Comment comment=modelMapper.map(commentDto,Comment.class);
        if (commentRepository.findById(id).isPresent()){
            comment.setId(id);
            commentRepository.save(comment);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }

    @Override
    public List<CommentDto> findall()  {
        List<Comment> comments= (List<Comment>) commentRepository.findAll();
         List<CommentDto> commentDtos=ObjectMapperUtils.mapAll(comments,CommentDto.class);
         return commentDtos;
    }

    @Override
    public List<Comment> getComment(Long id) {
        Event event = eventRepository.findById(id).get();
        List<Comment> comments = commentRepository.findByEventAndDflagIsFalse(event);
        return comments;


    }
}
