package com.losdesiempre.mypocketeam.service;

import com.losdesiempre.mypocketeam.domain.Movement;
import com.losdesiempre.mypocketeam.exception.MovementNotFoundException;
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
    public Movement findById(int id) throws MovementNotFoundException {
        Movement aux =  movementRepository.findById(id);
        if(aux!=null){
            return aux;
        }
        throw new MovementNotFoundException("Movement Not Found");
    }

    @Override
    public Movement findByName(String name) throws MovementNotFoundException {
        Movement aux = movementRepository.findByName(name);
        if(aux!=null){
            return aux;
        }
        throw new MovementNotFoundException("Movement Not Found");
    }
}
