package com.codeup.springcodeupproject.repositories;

import com.codeup.springcodeupproject.models.AdventureLog;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AdventureLogRepository extends CrudRepository<AdventureLog, Long> {

    // get full adventure from adventure log id
    @Query(value = "SELECT\n" +
            "  a.id as id, a.postion as postion, adv.id as advid, adv.body as body, adv.imgurl as advimage, adv.title as title, adv.adventurelog_id as adid,\n" +
            "  advr.id as advrid, advr.arrows as advrarrows, advr.healing as advrhealing, advr.health as advrhealth, advr.imgurl as advrimage,\n" +
            "  advr.level as advrlvl, advr.name as advrname, advr.user_id as advruser\n" +
            "FROM adventure_log AS a\n" +
            "JOIN adventurer as advr on advr.adventurelog_id = a.id\n" +
            "JOIN adventure adv on a.id = adv.adventurelog_id\n" +
            "WHERE a.id = :id", nativeQuery = true)

    List<AdventureLog> getFullAdventureById(@Param("id") long id);


}
