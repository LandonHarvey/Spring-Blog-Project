package com.codeup.springcodeupproject.repositories;

import com.codeup.springcodeupproject.Entities.Adventurer;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AdventurerRepository extends CrudRepository<Adventurer, Long> {

    @Query(value = "SELECT * " +
            "FROM adventurer " +
            "WHERE adventurelog_id = :id"
            , nativeQuery = true)
    List<Adventurer> getAllAdventurerById(@Param("id") long id);
}
