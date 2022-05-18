package game;

import exeption.NotRegisteredException;
import players.Player;
import java.util.ArrayList;
import java.util.Collection;

public class Game {

    private Collection<Player> players = new ArrayList<>();

    //конструкторы

    public Game() {
    }

    public Game(Collection<Player> players) {
        this.players = players;
    }

    //геттеры и сеттеры


    public Collection<Player> getPlayers() {
        return players;
    }

    public void setPlayers(Collection<Player> players) {
        this.players = players;
    }

    // решистрация игроков

    public void register(Player player) {
        players.add(player);
    }

    //соревнование между двумя игроками

    public int round(String playerName1, String playerName2) {

        int strengthPLayer1 = strengthFind(playerName1);
        int strengthPLayer2 = strengthFind(playerName2);

        if (strengthPLayer1 == 0) {
            throw new NotRegisteredException("Первый игрок не зарегистрирован");
        }
        if (strengthPLayer2 == 0) {
            throw new NotRegisteredException("Второй игрок не зарегистрирован");
        }

        if (strengthPLayer1 > strengthPLayer2) {
            return 1;
        }
        if (strengthPLayer2 > strengthPLayer1) {
            return 2;
        }
        return 0;
    }

    //определение силы по имени игрока

    public int strengthFind (String playerName){
        for (Player player : players) {
            if (player.getName() == playerName) {
                int strengthPlayer = player.getStrength();
                return strengthPlayer;
            }
        }
        return 0;
    }
}
