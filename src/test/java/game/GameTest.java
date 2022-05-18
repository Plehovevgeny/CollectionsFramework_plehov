package game;

import exeption.NotRegisteredException;
import org.junit.jupiter.api.Test;
import players.Player;
import static org.junit.jupiter.api.Assertions.*;

class GameTest {

    Game game = new Game();

    @Test
    void shouldFindMoreStrengthPlayer2() {

        Player player1 = new Player(1, "Евген", 100);
        Player player2 = new Player(2, "Димон", 200);

        game.register(player1);
        game.register(player2);

        int expected = 2;
        int actual = game.round("Евген", "Димон");
        assertEquals(expected, actual);
    }

    @Test
    void shouldFindMoreStrengthPlayer1() {

        Player player1 = new Player(1, "Евген", 100);
        Player player2 = new Player(2, "Димон", 50);

        game.register(player1);
        game.register(player2);

        int expected = 1;
        int actual = game.round("Евген", "Димон");
        assertEquals(expected, actual);
    }

    @Test
    void shouldFindEqualStrength() {

        Player player1 = new Player(1, "Евген", 50);
        Player player2 = new Player(2, "Димон", 50);

        game.register(player1);
        game.register(player2);

        int expected = 0;
        int actual = game.round("Евген", "Димон");
        assertEquals(expected, actual);
    }

    @Test
    void shouldFindMoreStrengthWhenStrengthPlayer1Zero() {

        Player player1 = new Player(1, "Евген", 0);
        Player player2 = new Player(2, "Димон", 50);

        game.register(player1);
        game.register(player2);

        assertThrows(NotRegisteredException.class, () ->  {
            game.round("Евген", "Димон");
        });
    }

    @Test
    void shouldFindMoreStrengthWhenStrengthPlayer2Zero() {

        Player player1 = new Player(1, "Евген", 50);
        Player player2 = new Player(2, "Димон", 0);

        game.register(player1);
        game.register(player2);

        assertThrows(NotRegisteredException.class, () ->  {
            game.round("Евген", "Димон");
        });
    }



    @Test
    void shouldFindNotNameOfPlayers() {

        Player player1 = new Player(1, "Евген", 50);
        Player player2 = new Player(2, "Димон", 50);

        game.register(player1);
        game.register(player2);

        assertThrows(NotRegisteredException.class, () ->  {
            game.round("собака", "Димон");
        });
    }

}