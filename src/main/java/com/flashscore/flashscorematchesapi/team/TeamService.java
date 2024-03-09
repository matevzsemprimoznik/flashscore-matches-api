package com.flashscore.flashscorematchesapi.team;

import com.flashscore.flashscorematchesapi.errors.ApplicationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.server.ResponseStatusException;

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

    public Team addTeam(Team team) {
        return teamRepository.save(team);
    }

    public void deleteTeam(Long teamId) {
        boolean exists = teamRepository.existsById(teamId);
        if (!exists) {
            throw new ApplicationException("TEAM_NOT_FOUND", "Team with id " + teamId + " does not exist", HttpStatus.BAD_REQUEST);
        }
        teamRepository.deleteById(teamId);
    }

    public Team updateTeam(Long teamId, Team team) {
        boolean exists = teamRepository.existsById(teamId);
        if (!exists) {
            throw new ApplicationException("TEAM_NOT_FOUND", "Team with id " + teamId + " does not exist", HttpStatus.BAD_REQUEST);
        }
        team.setId(teamId);
        teamRepository.save(team);
        return team;
    }

}
