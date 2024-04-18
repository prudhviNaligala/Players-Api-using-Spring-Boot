package com.example.player;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.*;
import com.example.player.PlayerService;

@RestController
class PlayerController {

  PlayerService playerService = new PlayerService();

  @GetMapping("/players")
  public ArrayList<Player> getPlayers() {
    return playerService.getPlayers();
  }

  @GetMapping("/players/{playerId}")
  public Player getPlayerById(@PathVariable("playerId") int playerId) {

    return playerService.getPlayerById(playerId);
  }

  // post means add a new put means update

  @PostMapping("/players")
  public Player addPlayer(@RequestBody Player player) {
    return playerService.addPlayer(player);
  }

  @PutMapping("/players/{playerId}")
  public Player updatePlayer(@PathVariable("playerId") int playerId, @RequestBody Player player) {
    return playerService.updatePlayer(playerId, player);
  }

  @DeleteMapping("/players/{playerId}")
  public Player deletePlayer(@PathVariable("playerId") int playerId){
    return playerService.deletePlayer(playerId);
  }
  













}