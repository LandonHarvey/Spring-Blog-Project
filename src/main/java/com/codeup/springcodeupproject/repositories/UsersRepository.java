package com.codeup.springcodeupproject.repositories;

import com.codeup.springcodeupproject.models.User;
import org.springframework.data.repository.CrudRepository;

public interface UsersRepository extends CrudRepository<User, Long> {
    User findByUsername(String username);
}