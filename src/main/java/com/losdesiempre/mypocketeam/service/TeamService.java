package com.losdesiempre.mypocketeam.service;

import com.losdesiempre.mypocketeam.domain.Movement;
import com.losdesiempre.mypocketeam.domain.Team;

public interface TeamService {

    Team findByName(String name);
}
