package org.example.nbastatszone.player;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="playerstats")
public class Player {
    @Id
    @Column(name="player",unique = true)
    private String player;

    private String position;

    private Integer age;

    private String team;

    private Integer games_played;

    private Integer minutes_played;

    private Integer points;

    private Integer rebounds;

    private Integer assists;

    private Integer steals;

    private Integer blocks;

    private Integer field_goal_percentage;

    private Integer three_point_percentage;

    private Integer free_throw_percentage;


    public Player() {
    }

    public Player(String player, String position, Integer age, String team, Integer games_played, Integer minutes_played, Integer points, Integer rebounds, Integer assists, Integer steals, Integer blocks, Integer field_goal_percentage, Integer three_point_percentage, Integer free_throw_percentage) {
        this.player = player;
        this.position = position;
        this.age = age;
        this.team = team;
        this.games_played = games_played;
        this.minutes_played = minutes_played;
        this.points = points;
        this.rebounds = rebounds;
        this.assists = assists;
        this.steals = steals;
        this.blocks = blocks;
        this.field_goal_percentage = field_goal_percentage;
        this.three_point_percentage = three_point_percentage;
        this.free_throw_percentage = free_throw_percentage;
    }


    public Player(String player) {
        this.player = player;
    }

    public String getPlayer() {
        return player;
    }

    public void setPlayer(String player) {
        this.player = player;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    public Integer getGames_played() {
        return games_played;
    }

    public void setGames_played(Integer games_played) {
        this.games_played = games_played;
    }

    public Integer getMinutes_played() {
        return minutes_played;
    }

    public void setMinutes_played(Integer minutes_played) {
        this.minutes_played = minutes_played;
    }

    public Integer getPoints() {
        return points;
    }

    public void setPoints(Integer points) {
        this.points = points;
    }

    public Integer getRebounds() {
        return rebounds;
    }

    public void setRebounds(Integer rebounds) {
        this.rebounds = rebounds;
    }

    public Integer getAssists() {
        return assists;
    }

    public void setAssists(Integer assists) {
        this.assists = assists;
    }

    public Integer getSteals() {
        return steals;
    }

    public void setSteals(Integer steals) {
        this.steals = steals;
    }

    public Integer getBlocks() {
        return blocks;
    }

    public void setBlocks(Integer blocks) {
        this.blocks = blocks;
    }

    public Integer getField_goal_percentage() {
        return field_goal_percentage;
    }

    public void setField_goal_percentage(Integer field_goal_percentage) {
        this.field_goal_percentage = field_goal_percentage;
    }

    public Integer getThree_point_percentage() {
        return three_point_percentage;
    }

    public void setThree_point_percentage(Integer three_point_percentage) {
        this.three_point_percentage = three_point_percentage;
    }

    public Integer getFree_throw_percentage() {
        return free_throw_percentage;
    }

    public void setFree_throw_percentage(Integer free_throw_percentage) {
        this.free_throw_percentage = free_throw_percentage;
    }
}
