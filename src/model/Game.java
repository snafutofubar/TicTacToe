package model;
import service.winningStrategy.WinningStrategy;

import java.util.*;
import java.util.stream.Collectors;

import exceptions.InvalidSymbolSetupException;
import exceptions.InvalidPlayerSizeException;
import exceptions.InvalidBotCountException;
import service.winningStrategy.winningStrategyName;


public class Game {
    private Board currentBoard;
    private List<Player> players;
    private Player currentPlayer;
    private List<Move> Moves;
    private List<Board> boards;
    private WinningStrategy winningStrategy;
    private int numberOfSymbols;

    public GameState getGameState() {
        return gameState;
    }

    public void setGameState(GameState gameState) {
        this.gameState = gameState;
    }

    private GameState gameState;

    public Game(Board currentBoard, List<Player> players, WinningStrategy winningStrategy) {
        this.currentBoard = currentBoard;
        this.players = players;
        this.currentPlayer = null;
        Moves = new ArrayList<>();
        this.boards = new ArrayList<>();
        this.winningStrategy = winningStrategy;
        this.numberOfSymbols = players.size();
        this.gameState = GameState.IN_PROGRESS;
    }

    public static Builder builder()
    {
        return new Builder();
    }

    public Board getCurrentBoard() {
        return currentBoard;
    }

    public void setCurrentBoard(Board currentBoard) {
        this.currentBoard = currentBoard;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }

    public Player getCurrentPlayer() {
        return currentPlayer;
    }

    public void setCurrentPlayer(Player currentPlayer) {
        this.currentPlayer = currentPlayer;
    }

    public List<Move> getMoves() {
        return Moves;
    }

    public void setMoves(List<Move> moves) {
        Moves = moves;
    }

    public List<Board> getBoards() {
        return boards;
    }

    public void setBoards(List<Board> boards) {
        this.boards = boards;
    }

    public WinningStrategy getWinningStrategy() {
        return winningStrategy;
    }

    public void setWinningStrategy(WinningStrategy winningStrategy) {
        this.winningStrategy = winningStrategy;
    }

    public int getNumberOfSymbols() {
        return numberOfSymbols;
    }

    public void setNumberOfSymbols(int numberOfSymbols) {
        this.numberOfSymbols = numberOfSymbols;
    }


    public static class Builder
    {
        private int dimension;
        private Board currentBoard;
        private List<Player> players;
        private WinningStrategy winningStrategy;

        public Builder()
        {

        }

        private void validateNumberOfPlayers()
        {
            if(!(players.size() < dimension - 2 || players.size() >= dimension - 1))
                throw new InvalidPlayerSizeException("Player size should be N-2 or N-1 as per board size");
        }

        private void validatePlayerSymbols(){
            HashSet<Character> symbols = (HashSet<Character>) players.stream().map(Player::getSymbol)
                    .collect(
                    Collectors.toSet());
            if(symbols.size() != players.size()){
                throw new InvalidSymbolSetupException("There should be unique symbols for all the players");
            }
        }

        private void validateBotCount(){
            int botCount = players.stream().map(Player::getPlayerType)
                    .filter(playerType -> playerType.equals(PlayerType.BOT))
                    .toList().size();

            if(botCount > 1 || botCount < 0){
                throw new InvalidBotCountException("We can have maximum 1 bot per game");
            }
        }

        private void validate(){
            validateBotCount();
            validateNumberOfPlayers();
            validatePlayerSymbols();
        }

        public Game build(){
            validate();
            return new Game(new Board(dimension), players, winningStrategy);
        }

        public int getDimension() {
            return dimension;
        }

        public Builder dimension(int dimension) {
            this.dimension = dimension;
            return this;
        }

        public Board getCurrentBoard() {
            return currentBoard;
        }

        public Builder currentBoard(Board currentBoard) {
            this.currentBoard = currentBoard;
            return this;
        }

        public List<Player> getPlayers() {
            return players;
        }

        public Builder players(List<Player> players) {
            this.players = players;
            return this;
        }

        public WinningStrategy getWinningStrategy() {
            return winningStrategy;
        }

        public Builder winningStrategy(WinningStrategy winningStrategy) {
            this.winningStrategy = winningStrategy;
            return this;
        }
    }
}
