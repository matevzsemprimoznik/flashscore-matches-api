package com.flashscore.flashscorematchesapi.team;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ActiveProfiles;

import java.util.Optional;

@SpringBootTest
@ActiveProfiles("test")
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
public class TeamTests {

    @Autowired
    private TeamService teamService;

    @Autowired
    private TeamRepository teamRepository;

    @BeforeEach
    void beforeEach() {
        teamService.addTeam(new Team("Inter", "Italy", "Milano", "San Siro",  "Simone Inzaghi"));
        teamService.addTeam(new Team("Team 2", "Italy", "Milano", "San Siro",  "Simone Inzaghi"));
        teamService.addTeam(new Team("Team 3", "Italy", "Milano", "San Siro",  "Simone Inzaghi"));
    }

    @AfterEach
    void afterEach() {
        teamRepository.deleteAll();
    }

    @Test
    public void teamsExists() {
        assert teamService.getTeams().size() == 3;
    }

    @Test
    void teamsDoNotExist() {
        teamRepository.deleteAll();
        assert teamService.getTeams().isEmpty();
    }

    @Test
    public void teamExists() {
        System.out.println(teamService.getTeams());
        assert teamService.getTeam(1L).isPresent();
    }

    @Test
    public void teamDoesNotExist() {
        Optional<Team> team = teamService.getTeam(4L);
        assert team.isEmpty();
    }

    @Test
    public void canAddTeam(){
        teamService.addTeam(new Team("Team 4", "Italy", "Milano", "San Siro",  "Simone Inzaghi"));
        assert teamService.getTeam(4L).isPresent();
    }

    @Test
    public void canUpdateTeamName(){
        Optional<Team> optionalTeam = teamService.getTeam(1L);
        assert optionalTeam.isPresent();
        Team team = optionalTeam.get();
        assert !team.getName().equals("Juventus");
        team.setName("Juventus");
        teamService.updateTeam(1L, team);
        Optional<Team> optionalUpdatedTeam = teamService.getTeam(1L);
        assert optionalUpdatedTeam.isPresent();
        assert optionalUpdatedTeam.get().getName().equals("Juventus");
    }

    @Test
    public void canUpdateTeamCountry(){
        Optional<Team> optionalTeam = teamService.getTeam(1L);
        assert optionalTeam.isPresent();
        Team team = optionalTeam.get();
        assert !team.getCountry().equals("Germany");
        team.setCountry("Germany");
        teamService.updateTeam(1L, team);
        Optional<Team> optionalUpdatedTeam = teamService.getTeam(1L);
        assert optionalUpdatedTeam.isPresent();
        assert optionalUpdatedTeam.get().getCountry().equals("Germany");
    }

    @Test
    public void canDeleteTeam(){
        teamService.deleteTeam(1L);
        assert teamService.getTeam(1L).isEmpty();
    }
}
