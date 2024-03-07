package com.flashscore.flashscorematchesapi.team;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/teams")
public class TeamController {

    private final TeamService teamService;

    @Autowired
    public TeamController(TeamService teamService) {
        this.teamService = teamService;
    }

    @GetMapping
    public List<Team> getTeams() {
        return teamService.getTeams();
    }

    @GetMapping(path = "{id}")
    public Optional<Team> getTeam(@PathVariable Long id) {
        return teamService.getTeam(id);
    }

    @PostMapping
    public void addTeam(@RequestBody Team team) {
        teamService.addTeam(team);
    }

    @PutMapping(path = "{id}")
    public void updateTeam(@PathVariable Long id, @RequestBody Team team) {
        teamService.updateTeam(id, team);
    }
    @DeleteMapping
    public void deleteTeam(@PathVariable Long id) {
        teamService.deleteTeam(id);
    }

}
