package org.example.strategy;

import org.example.model.Player;
import org.example.strategy.interfaces.PlayerPickingStartegy;

import java.util.List;

public class CircularPlayerPickingStrategy implements PlayerPickingStartegy {

    private List<Player> players;

    public CircularPlayerPickingStrategy( List<Player> players){
        this.players = players;
    }

    @Override
    public Player getPlayer() {

        Player player = players.get(0);
        players.remove(0);
        players.add(player);
        return player;

    }
}
