package com.losdesiempre.mypocketeam.repository;

import com.losdesiempre.mypocketeam.domain.Team;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface TeamRepository extends MongoRepository<Team, Integer> {

    Team findByName(@Param("name") String name);
}
