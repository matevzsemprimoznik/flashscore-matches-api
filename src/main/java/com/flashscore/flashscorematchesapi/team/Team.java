package com.flashscore.flashscorematchesapi.team;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table
public class Team {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String country;
    private String city;
    private String stadium;
    private String coach;

    public Team() {
    }

    public Team(String name, String country, String city, String stadium, String coach) {
        this.name = name;
        this.country = country;
        this.city = city;
        this.stadium = stadium;
        this.coach = coach;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStadium() {
        return stadium;
    }

    public void setStadium(String stadium) {
        this.stadium = stadium;
    }

    public String getCoach() {
        return coach;
    }

    public void setCoach(String coach) {
        this.coach = coach;
    }

    @Override
    public String toString() {
        return "Team{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", country='" + country + '\'' +
                ", city='" + city + '\'' +
                ", stadium='" + stadium + '\'' +
                ", coach='" + coach + '\'' +
                '}';
    }
}
