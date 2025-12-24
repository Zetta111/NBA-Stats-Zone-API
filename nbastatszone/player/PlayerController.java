package org.example.nbastatszone.player;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="api/v1/player")

public class PlayerController {
    private final PlayerService playerService;


    @Autowired
    public PlayerController(PlayerService playerService){
        this.playerService = playerService;
    }


    @GetMapping
    public List<Player> getPlayers(
            @RequestParam(required = false) String team,
            @RequestParam(required = false) String position,
            @RequestParam(required = false) String player){
        if(team!=null && position!=null) {
            return playerService.getPlayersByTeamAndPos(team, position);
        }else if(team!=null){
            return playerService.getPlayersFromTeam(team);
        }else if(position!=null){
            return playerService.getPlayersByPos(position);
        }else if(player!=null){
            return playerService.getPlayersByName(player);
        }else{
            return playerService.getPlayers();
        }

    }


    @PostMapping
    public ResponseEntity<Player> addPlayer(@RequestBody Player player){
        Player createdPlayer=playerService.addPLayer(player);
        return new ResponseEntity<>(createdPlayer, HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<Player> changePlayerStats(@RequestBody Player player){
        Player resultPlayer= playerService.changePlayerStats(player);
        if(resultPlayer!=null){
            return new ResponseEntity<>(resultPlayer, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }

    @DeleteMapping("/{playerName}")
    public ResponseEntity<String> deletePlayer(@PathVariable Player playerName){
        playerService.deletePlayer(playerName);
        return new ResponseEntity<>("Player deleted Successfully",HttpStatus.OK);
    }
}
