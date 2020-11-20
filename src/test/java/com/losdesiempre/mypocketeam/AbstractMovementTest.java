package com.losdesiempre.mypocketeam;

import com.losdesiempre.mypocketeam.domain.Movement;
import com.losdesiempre.mypocketeam.repository.MovementRepository;
import com.losdesiempre.mypocketeam.service.MovementServiceImplementation;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@SpringBootTest
public class AbstractMovementTest {

    @Autowired
    MovementServiceImplementation movementServiceImplementation;

    @MockBean
    MovementRepository movementRepository;

    List<Movement> movements;

    @BeforeEach
    public void init(){
        movements= new ArrayList<>();

        Movement move= new Movement();
        move.setId(1);
        move.setName("Absorb");
        move.setType("Grass");
        move.setCategory("Special");
        move.setPower(20);
        move.setAccuracy(100);
        move.setPp(25);
        move.setEffect("User recovers half the HP inflicted on opponent.");

        movements.add(move);

        move= new Movement();
        move.setId(76);
        move.setName("Light Screen");
        move.setType("Psychic");
        move.setCategory("Status");
        move.setPower(null);
        move.setAccuracy(null);
        move.setPp(30);
        move.setEffect("Halves damage from Special attacks for 5 turns.");

        movements.add(move);

        move= new Movement();
        move.setId(165);
        move.setName("Wrap");
        move.setType("Normal");
        move.setCategory("Physical");
        move.setPower(15);
        move.setAccuracy(90);
        move.setPp(20);
        move.setEffect("Traps opponent, damaging them for 4-5 turns.");

        movements.add(move);
    }

    @Test
    public void shouldFindAllMovements(){
        //Arrange
        when(this.movementRepository.findAll()).thenReturn(movements);

        //Act
        List<Movement> all= movementServiceImplementation.listAll();

        //Assert
        assertNotNull(all);
        assertEquals(movements.size(), all.size());
        assertAll(
                () -> assertEquals(1,all.get(0).getId()),
                () -> assertEquals("Absorb",all.get(0).getName()),
                () -> assertEquals("Grass",all.get(0).getType()),
                () -> assertEquals("Special",all.get(0).getCategory()),
                () -> assertEquals(20,all.get(0).getPower()),
                () -> assertEquals(100,all.get(0).getAccuracy()),
                () -> assertEquals(25,all.get(0).getPp()),
                () -> assertEquals("User recovers half the HP inflicted on opponent.",all.get(0).getEffect()),

                () -> assertEquals(76,all.get(1).getId()),
                () -> assertEquals("Light Screen",all.get(1).getName()),
                () -> assertEquals("Psychic",all.get(1).getType()),
                () -> assertEquals("Status",all.get(1).getCategory()),
                () -> assertNull(all.get(1).getPower()),
                () -> assertNull(all.get(1).getAccuracy()),
                () -> assertEquals(30,all.get(1).getPp()),
                () -> assertEquals("Halves damage from Special attacks for 5 turns.",all.get(1).getEffect()),

                () -> assertEquals(165,all.get(2).getId()),
                () -> assertEquals("Wrap",all.get(2).getName()),
                () -> assertEquals("Normal",all.get(2).getType()),
                () -> assertEquals("Physical",all.get(2).getCategory()),
                () -> assertEquals(15,all.get(2).getPower()),
                () -> assertEquals(90,all.get(2).getAccuracy()),
                () -> assertEquals(20,all.get(2).getPp()),
                () -> assertEquals("Traps opponent, damaging them for 4-5 turns.",all.get(2).getEffect())

                );

    }

    @Test
    void GivenMovementIdAndMovementExistsThenReturnTheMovement() {
        //Arrange
        when(this.movementRepository.findAll()).thenReturn(movements);

        //Act
        Movement check = movementServiceImplementation.findById(1);

        //Assert
        assertNotNull(check);
        assertAll(
                () -> assertEquals(1,check.getId()),
                () -> assertEquals("Absorb",check.getName()),
                () -> assertEquals("Grass",check.getType()),
                () -> assertEquals("Special",check.getCategory()),
                () -> assertEquals(20,check.getPower()),
                () -> assertEquals(100,check.getAccuracy()),
                () -> assertEquals(25,check.getPp()),
                () -> assertEquals("User recovers half the HP inflicted on opponent.",check.getEffect())

        );
    }
}
