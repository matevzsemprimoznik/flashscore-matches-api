package com.flashscore.flashscorematchesapi.team;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TeamService {

    private final TeamRepository teamRepository;

    @Autowired
    public TeamService(TeamRepository teamRepository) {
        this.teamRepository = teamRepository;
    }

    public List<Team> getTeams() {
        return teamRepository.findAll();
    }

    public Optional<Team> getTeam(Long teamId) {
        return teamRepository.findById(teamId);
    }

    public void addTeam(Team team) {
        teamRepository.save(team);
    }

    public void deleteTeam(Long teamId) {
        boolean exists = teamRepository.existsById(teamId);
        if (!exists) {
            throw new IllegalStateException("Team with id " + teamId + " does not exist");
        }
        teamRepository.deleteById(teamId);
    }

    public void updateTeam(Long teamId, Team team) {
        boolean exists = teamRepository.existsById(teamId);
        if (!exists) {
            throw new IllegalStateException("Team with id " + teamId + " does not exist");
        }
        team.setId(teamId);
        teamRepository.save(team);
    }

}
