package com.losdesiempre.mypocketeam.controller;
import com.losdesiempre.mypocketeam.domain.Movement;
import com.losdesiempre.mypocketeam.domain.Team;
import com.losdesiempre.mypocketeam.exception.MovementNotFoundException;
import com.losdesiempre.mypocketeam.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pocketo/teams")
public class TeamController {

    @Autowired
    private TeamService teamService;

    @GetMapping(value = "/{name}")
    public ResponseEntity<Team> getTeamByName(@PathVariable("name") String name) {
        name = name.toLowerCase();
        name = name.substring(0,1).toUpperCase() + name.substring(1);
        Team team = teamService.findByName(name);
        if(team != null){
            return new ResponseEntity<>(team, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
