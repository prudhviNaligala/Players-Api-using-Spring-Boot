package com.example.player;

import com.example.player.Player;
import com.example.player.PlayerRepository;

import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

public class PlayerService implements PlayerRepository {

    private static HashMap<Integer, Player> team = new HashMap<>();

    public PlayerService() {
        team.put(1, new Player(1, "Alexander", 5, "All-rounder"));
        team.put(2, new Player(2, "Benjamin", 3, "All-rounder"));
        team.put(3, new Player(3, "Michael", 18, "Batsman"));
        team.put(4, new Player(4, "William", 45, "Batsman"));
        team.put(5, new Player(5, "Joshua", 19, "Batsman"));
        team.put(6, new Player(6, "Daniel", 10, "Bowler"));
        team.put(7, new Player(7, "Matthew", 34, "Bowler"));
        team.put(8, new Player(8, "Samuel", 17, "Batsman"));
        team.put(9, new Player(9, "John", 1, "Bowler"));
        team.put(10, new Player(10, "Earnest", 2, "All-rounder"));
        team.put(11, new Player(11, "Bob", 25, "Batsman"));

    }

    int size = team.size();

    @Override
    public ArrayList<Player> getPlayers() {
        Collection<Player> playerCollection = team.values();
        ArrayList<Player> players = new ArrayList<>(playerCollection);
        return players;
    }

    @Override
    public Player getPlayerById(int playerId) {
        Player player = team.get(playerId);
        if (player == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        return player;
    }

    @Override
    public Player addPlayer(Player player) {
        int size = team.size() + 1;
        player.setPlayerId(size);
        team.put(size, player);
        System.out.println(size);
        size += 1;
        return player;
    }

    @Override
    public Player updatePlayer(int playerId, Player player) {
        Player currentPlayer = team.get(playerId);
        if (currentPlayer == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        if (player.getPlayerName() != null) {
            currentPlayer.setPlayerName(player.getPlayerName());
        }
        if (player.getJerseyNumber() != 0) {
            currentPlayer.setJerseyNumber(player.getJerseyNumber());
        }
        if (player.getRole() != null) {
            currentPlayer.setRole(player.getRole());
        }

        return currentPlayer;

    }

    @Override
    public Player deletePlayer(int playerId) {
        Player currentPlayer = team.get(playerId);

        if (currentPlayer == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        } else {
            team.remove(playerId);
            throw new ResponseStatusException(HttpStatus.NO_CONTENT);
        }

    }

}
