package com.losdesiempre.mypocketeam.service;

import com.losdesiempre.mypocketeam.domain.Movement;
import com.losdesiempre.mypocketeam.exception.MovementNotFoundException;

import java.util.List;

public interface MovementService {

    List<Movement> listAll();

    Movement findById(int id) throws MovementNotFoundException;

    Movement findByName(String name);
}
