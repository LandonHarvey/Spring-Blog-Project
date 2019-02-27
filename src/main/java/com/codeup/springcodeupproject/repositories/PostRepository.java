package com.codeup.springcodeupproject.repositories;

import com.codeup.springcodeupproject.models.Post;
import org.springframework.data.repository.CrudRepository;

public interface PostRepository extends CrudRepository<Post, Long> {
}
