package com.losdesiempre.mypocketeam.controller;

import com.losdesiempre.mypocketeam.domain.Movement;
import com.losdesiempre.mypocketeam.exception.MovementNotFoundException;
import com.losdesiempre.mypocketeam.service.MovementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pocketo/moves")
public class MovimientoController {

    @Autowired
    private MovementService movementService;

    @GetMapping(value = "/{name}")
    public ResponseEntity<Movement> getMovementByName(@PathVariable("name") String name) throws MovementNotFoundException {
        name = name.toLowerCase();
        name = name.substring(0,1).toUpperCase() + name.substring(1);
        Movement move = movementService.findByName(name);
        if(move != null){
            return new ResponseEntity<>(move, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
