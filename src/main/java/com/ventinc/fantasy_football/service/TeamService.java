package com.ventinc.fantasy_football.service;

import com.ventinc.fantasy_football.model.Team;
import com.ventinc.fantasy_football.repo.TeamRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeamService {

    private final TeamRepo teamRepo;

    public TeamService(TeamRepo teamRepo) {
        this.teamRepo = teamRepo;
    }

    // Retrieve all teams
    public List<Team> getAllTeams(){
        return teamRepo.findAll();
    }

    // retrieve teams by name
    public List<Team> getTeamsByName(String name){
        if (name == null || name.trim().isEmpty()) {
            return List.of();
        }
        return teamRepo.findByNameContainingIgnoreCase(name);
    }

    // Sort teams by wins descending
    public List<Team> getAllTeamsSortedByWins(){
        return teamRepo.findAllByOrderByWinsDesc();
    }
}
