package com.munifbadr.Controllers;


import com.munifbadr.Dtos.CommentDto;
import com.munifbadr.Entity.Comment;
import com.munifbadr.Service.ServiceImp.CommentServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
public class CommentController {

    @Autowired
    private CommentServiceImp commentServiceImp;

    @GetMapping("/all")
    @PreAuthorize( "hasAnyRole('ROLE_ADMIN','ROLE_USER','ROLE_ORGANIZER')" )
     List<CommentDto> findalll() {
        return commentServiceImp.findall();
    }

    @GetMapping("/event/comment/{id}")
    List<Comment> getComment(@PathVariable  Long id) {
        return commentServiceImp.getComment(id);
    }

    @PostMapping("/comment/{userid}/{eventid}")
    @PreAuthorize( "hasAnyRole('ROLE_ADMIN','ROLE_USER','ROLE_ORGANIZER')" )
     ResponseEntity create(@Valid @PathVariable Long userid, @Valid @PathVariable Long eventid, @RequestBody Comment comment) {
        return commentServiceImp.Create(userid, eventid, comment);
    }

    @PutMapping("/update")
    @PreAuthorize( "hasAnyRole('ROLE_ADMIN','ROLE_USER','ROLE_ORGANIZER')" )
     ResponseEntity update(CommentDto commentDto, Long id) {
       return commentServiceImp.update(commentDto, id);

    }
}
