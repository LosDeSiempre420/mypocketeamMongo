package com.losdesiempre.mypocketeam.service;

import com.losdesiempre.mypocketeam.domain.Movement;

import java.util.List;

public interface MovementService {

    List<Movement> listAll();

    Movement findById(int i);
}
