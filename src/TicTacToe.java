
import controller.GameController;
import model.*;
import service.winningStrategy.WinningStrategy;
import service.winningStrategy.orderOneWinningStrategy;
import service.winningStrategy.winningStrategyName;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class TicTacToe {
    public static void main(String[] args) {
        GameController gameController = new GameController();
        Scanner sc = new Scanner(System.in);
        int id = 1;
        System.out.println("Hi!! Welcome to game");
        System.out.println("Please provide Board size");
        int dimension = sc.nextInt();
        System.out.println("Will you need Bot?(Y/N)");

        List<Player> players = new ArrayList();
        if(sc.next().equalsIgnoreCase("Y"))
        {
            players.add(gameController.getBot(id++, '$', BotDifficultyLevel.HARD));
        }
        sc.nextLine();

        while (id < dimension)
        {
            System.out.println("Please Enter New Player Name");
            String name = sc.nextLine();
            System.out.println("Please Enter New Player Symbol");
            char symbol = sc.next().charAt(0);
            players.add(gameController.getPlayer(id++, symbol, name));
        }
        Collections.shuffle(players);


        Game game = gameController.createGame(dimension, players, winningStrategyName.ORDERONEWINNINGSTATERGY);
        int playerIndex = -1;
        while (gameController.getGameState(game).equals(GameState.IN_PROGRESS)) {
            System.out.println("Current Board");
            gameController.displayBoard(game.getCurrentBoard());

            playerIndex++;
            playerIndex = playerIndex % players.size();
            Player currPlayer = players.get(playerIndex);

            Move movePlayed = gameController.makeMove(game.getCurrentBoard(), currPlayer);
            Player winner = gameController.checkWinner(game, movePlayed);
            if (winner != null) {
                System.out.println("WINNER IS : " + winner.getName());
                break;
            }



        }

    }
}
