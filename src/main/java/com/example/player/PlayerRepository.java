package com.example.player;

import java.util.ArrayList;

public interface PlayerRepository {
    ArrayList<Player> getPlayers();

    Player getPlayerById(int playerId);

    Player addPlayer(Player player);

    Player updatePlayer(int playerId, Player player);

    Player deletePlayer(int playerId);

}