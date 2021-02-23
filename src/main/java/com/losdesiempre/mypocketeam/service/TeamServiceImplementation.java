package com.losdesiempre.mypocketeam.service;


import com.losdesiempre.mypocketeam.domain.Team;
import com.losdesiempre.mypocketeam.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TeamServiceImplementation implements TeamService{
    @Autowired
    private TeamRepository teamRepository;

    @Override
    public Team findByName(String name) {
        Team aux = teamRepository.findByName(name);

        return aux;
    }
}
