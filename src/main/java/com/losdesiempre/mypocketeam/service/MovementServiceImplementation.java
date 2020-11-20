package com.losdesiempre.mypocketeam.service;

import com.losdesiempre.mypocketeam.domain.Movement;
import com.losdesiempre.mypocketeam.repository.MovementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovementServiceImplementation {
    @Autowired
    private MovementRepository movementRepository;

    public List<Movement> listAll() {
        return movementRepository.findAll();
    }
}
