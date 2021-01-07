package com.losdesiempre.mypocketeam.repository;

import com.losdesiempre.mypocketeam.domain.Movement;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface MovementRepository extends MongoRepository<Movement, Integer> {

    Movement findById(@Param("id") int id);

    Movement findByName(@Param("name") String name);
}
