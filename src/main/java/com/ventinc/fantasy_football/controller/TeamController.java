package com.ventinc.fantasy_football.controller;

import com.ventinc.fantasy_football.model.Team;
import com.ventinc.fantasy_football.service.TeamService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/team")
public class TeamController {

    private final TeamService teamService;

    public TeamController(TeamService teamService) {
        this.teamService = teamService;
    }

    // Retrieve all teams
    @GetMapping
    public ResponseEntity<List<Team>> getAllTeams(){
        return ResponseEntity.ok(teamService.getAllTeams());
    }

    // Retrieve teams by name
    @GetMapping("/name/{name}")
    public ResponseEntity<List<Team>> getTeamsByName(@PathVariable String name){
        return ResponseEntity.ok(teamService.getTeamsByName(name));
    }

    // Retrieve all teams sorted by wins descending
    @GetMapping("/sorted/wins")
    public ResponseEntity<List<Team>> getAllTeamsSortedByWins(){
        return ResponseEntity.ok(teamService.getAllTeamsSortedByWins());
    }
}
