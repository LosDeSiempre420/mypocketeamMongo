package com.losdesiempre.mypocketeam.service;

import com.losdesiempre.mypocketeam.domain.Movement;
import com.losdesiempre.mypocketeam.repository.MovementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovementServiceImplementation implements MovementService{
    @Autowired
    private MovementRepository movementRepository;

    @Override
    public List<Movement> listAll() {
        return movementRepository.findAll();
    }

    @Override
    public Movement findById(int i) {
        return null;
    }
}
