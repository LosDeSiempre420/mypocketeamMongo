package com.losdesiempre.mypocketeam;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.losdesiempre.mypocketeam.controller.MovimientoController;
import com.losdesiempre.mypocketeam.domain.Movement;
import com.losdesiempre.mypocketeam.service.MovementService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
public class AbstractMovementControllerTest {

    private MockMvc mockMvc;

    @Mock
    private MovementService movementService;

    private JacksonTester<Movement> jsonMovement;

    @InjectMocks
    MovimientoController movimientoController;

    @BeforeEach
    void setup(){
        JacksonTester.initFields(this,new ObjectMapper());
        mockMvc = MockMvcBuilders.standaloneSetup(movimientoController).build();
    }

    @Test
    void getByNombreSeEjecutaYNombreExisteDebeRetornarMovimiento() throws Exception {
        //given
        Movement move= new Movement();
        move.setId(1);
        move.setName("Absorb");
        move.setType("Grass");
        move.setCategory("Special");
        move.setPower(20);
        move.setAccuracy(100);
        move.setPp(25);
        move.setEffect("User recovers half the HP inflicted on opponent.");
        given(movementService.findByName("Absorb")).willReturn(move);

        //when
        MockHttpServletResponse response = mockMvc.perform(get("/api/pocketo/moves/Absorb")
                .accept(MediaType.APPLICATION_JSON))
                .andReturn()
                .getResponse();

        //Then
        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
        assertThat(response.getContentAsString()).isEqualTo(
                jsonMovement.write(move).getJson()
        );

    }

}
