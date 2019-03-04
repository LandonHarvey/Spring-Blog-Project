package com.codeup.springcodeupproject.repositories;

import com.codeup.springcodeupproject.models.Adventure;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface AdventureRepository extends CrudRepository<Adventure, Long> {

    @Query(value = "SELECT *\n" +
            "FROM adventure\n" +
            "WHERE adventurelog_id = :id"
            , nativeQuery = true)
   Adventure getAdventureBy(@Param("id") long id);
}
