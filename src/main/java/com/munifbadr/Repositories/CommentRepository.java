package com.munifbadr.Repositories;

import com.munifbadr.Entity.Comment;
import com.munifbadr.Entity.Event;
import com.munifbadr.Entity.Users;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;


@Repository
public interface CommentRepository extends CrudRepository<Comment,Long> {

         List<Comment> findByUsers(Users users);
         long countByEventAndUsersAndLocalDateTimeIsAfter(Event event, Users users, LocalDateTime dateTime);

         List<Comment> findByEventAndDflagIsFalse(Event event);
}
