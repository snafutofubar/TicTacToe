package controller;

import model.*;
import service.winningStrategy.WinningStrategy;
import service.winningStrategy.winningStrategyFactory;
import service.winningStrategy.winningStrategyName;

import java.util.List;
import java.util.SimpleTimeZone;

public class GameController {

    public Game createGame(int dimensions, List<Player> Players, winningStrategyName winningStrategyName)
    {
        return Game.builder().
                players(Players)
                .dimension(dimensions)
                .winningStrategy(winningStrategyFactory.getWinningStrategy(winningStrategyName, dimensions))
                .build();

    }
    public Move makeMove(Board board, Player player)
    {
        return player.makeMove(board);
    }

    public void displayBoard(Board board)
    {
        board.displayBoard();
    }

    public Player checkWinner(Game game, Move lastMove)
    {
        return game.getWinningStrategy().checkWinner(game.getCurrentBoard(), lastMove);
    }
    public GameState getGameState(Game game)
    {
        return game.getGameState();
    }
    public Player getBot(int id, char symbol, BotDifficultyLevel botDifficultyLevel)
    {
        return new Bot(id, symbol, botDifficultyLevel);
    }
    public Player getPlayer(int id, char symbol, String name)
    {
        return new Player(id, symbol, name, PlayerType.HUMAN);
    }

}
