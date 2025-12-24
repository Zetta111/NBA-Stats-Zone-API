package org.example.nbastatszone.player;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class PlayerService {
    private final PlayerRepository playerRepository;

    @Autowired
    public PlayerService(PlayerRepository playerRepository){
        this.playerRepository = playerRepository;
    }

    public List<Player> getPlayers(){
        return playerRepository.findAll();
    }

    public List<Player> getPlayersFromTeam(String team){
        return playerRepository.findAll().stream()
                .filter(player ->team.equals(player.getTeam()))
                .collect(Collectors.toList());
    }

    public List<Player> getPlayersByName(String searchText){
        return playerRepository.findAll().stream()
                .filter(player->player.getPlayer().toLowerCase().contains(searchText.toLowerCase()))
                .collect(Collectors.toList());
    }

    public List<Player> getPlayersByPos(String searchText){
        return playerRepository.findAll().stream()
                .filter(player->
                        player.getPosition().toLowerCase().contains(searchText.toLowerCase()))
                .collect(Collectors.toList());

    }

    public List<Player> getPlayersByTeamAndPos(String team,String position){
        return playerRepository.findAll().stream()
                .filter(player->team.equals(player.getTeam()) && position.equals(player.getPosition()))
                .collect(Collectors.toList());

    }

    public Player addPLayer(Player player){
        playerRepository.save(player);
        return player;
    }

    public Player changePlayerStats(Player updatedPlayer){
        Optional<Player> existingPlayer=playerRepository.findByPlayer(updatedPlayer.getPlayer());

        if(existingPlayer.isPresent()){
            Player PlayerToChange= existingPlayer.get();

            PlayerToChange.setPlayer(updatedPlayer.getPlayer());
            PlayerToChange.setPosition(updatedPlayer.getPosition());
            PlayerToChange.setTeam(updatedPlayer.getTeam());
            PlayerToChange.setAge(updatedPlayer.getAge());

            playerRepository.save(PlayerToChange);
            return PlayerToChange;
        }
        return null;
    }

    @Transactional
    public void deletePlayer(Player playerName){
        playerRepository.delete(playerName);
    }


}
