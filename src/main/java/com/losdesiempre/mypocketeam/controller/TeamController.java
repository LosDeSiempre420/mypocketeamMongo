package com.losdesiempre.mypocketeam.controller;
import com.losdesiempre.mypocketeam.domain.Movement;
import com.losdesiempre.mypocketeam.domain.PokemonBase;
import com.losdesiempre.mypocketeam.domain.Team;
import com.losdesiempre.mypocketeam.exception.MovementNotFoundException;
import com.losdesiempre.mypocketeam.service.TeamService;
import net.minidev.json.JSONArray;
import net.minidev.json.JSONObject;
import net.minidev.json.parser.JSONParser;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Arrays;

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

    @PostMapping("/insert")
    public void insert(@RequestBody String doc) {
        try {
            JSONObject jsonObject = (JSONObject) new JSONParser().parse(doc);
            JSONArray array = (JSONArray) jsonObject.get("pokemon");
            LinkedList pokemon = new LinkedList(Arrays.asList(array));
            Team team = new Team(
                    Integer.parseInt(jsonObject.get("_id").toString()), jsonObject.get("nombre").toString(), pokemon);
            // do something using getters and setters
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
