package com.codeup.springcodeupproject.repositories;

import com.codeup.springcodeupproject.models.Adventure;
import org.springframework.data.repository.CrudRepository;

public interface AdventureRepository extends CrudRepository<Adventure, Long> {
}
