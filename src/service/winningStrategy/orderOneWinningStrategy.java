package service.winningStrategy;

import model.Board;
import model.Move;
import model.Player;
import model.PlayerType;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class orderOneWinningStrategy implements WinningStrategy{

    private int dimension;
    private List<HashMap<Character, Integer>> rowHashMaps;
    private List<HashMap<Character, Integer>> colHashMaps;
    private HashMap<Character, Integer> rightDiagonalHashMap;
    private HashMap<Character, Integer> leftDiagonalHashMap;
    private HashMap<Character, Integer> cornerHashMap;

    public orderOneWinningStrategy(int dimension) {
        this.dimension = dimension;
        this.rowHashMaps = new ArrayList<>();
        this.colHashMaps = new ArrayList<>();
        this.cornerHashMap = new HashMap<>();
        this.rightDiagonalHashMap = new HashMap<>();
        this.leftDiagonalHashMap = new HashMap<>();
        for(int i = 0; i < dimension; i++)
        {
            rowHashMaps.add(new HashMap<>());
            colHashMaps.add(new HashMap<>());
        }
    }

    @Override
    public Player checkWinner(Board board, Move lastMove) {
        int row = lastMove.getCell().getRow();
        int col = lastMove.getCell().getCol();
        char symbol = lastMove.getPlayer().getSymbol();
        Player player = lastMove.getPlayer();

        if(checkWinner(symbol, row, col))
            return player;

        return null;
    }
    private boolean checkWinner(char symbol, int row, int col) {
        return (checkCorner(row, col) && updateAndCheckWinnerForCorner(symbol))
                || (updateAndCheckWinnerForCol(col, symbol))
                || (updateAndCheckWinnerForRow(row, symbol))
                || (checkLeftDiagonal(row, col) && updateAndCheckWinnerForLeftDiagonal(symbol))
                || (checkRightDiagonal(row, col) && updateAndCheckWinnerForRightDiagonal(symbol));
    }
    private boolean updateAndCheckWinnerForRow(int row, char symbol)
    {
        HashMap<Character, Integer> rowHashmap = this.rowHashMaps.get(row);

        rowHashmap.put(symbol, rowHashmap.getOrDefault(symbol, 0) + 1);

        return rowHashmap.get(symbol) == dimension;
    }

    private boolean updateAndCheckWinnerForCol(int col, char symbol)
    {
        HashMap<Character, Integer> colHashmap = this.colHashMaps.get(col);

        colHashmap.put(symbol, colHashmap.getOrDefault(symbol, 0) + 1);

        return colHashmap.get(symbol) == dimension;
    }
    private boolean checkLeftDiagonal(int row, int col)
    {
        return row == col;
    }
    private boolean checkRightDiagonal(int row, int col)
    {
        return row + col == dimension;
    }
    private boolean updateAndCheckWinnerForLeftDiagonal(char symbol)
    {
        leftDiagonalHashMap.put(symbol, leftDiagonalHashMap.getOrDefault(symbol, 0) + 1);
        return leftDiagonalHashMap.get(symbol) == dimension;
    }
    private boolean updateAndCheckWinnerForRightDiagonal(char symbol)
    {
        rightDiagonalHashMap.put(symbol, rightDiagonalHashMap.getOrDefault(symbol, 0) + 1);
        return rightDiagonalHashMap.get(symbol) == dimension;
    }

    private boolean checkCorner(int row, int col)
    {
        return (row == col && col == 0)
                || (row == 0 && col == (dimension - 1))
                || (((dimension - 1) == row) && (col == 0))
                || (row == col && col == (dimension - 1));
        //return b;
    }
    private boolean updateAndCheckWinnerForCorner(char symbol)
    {
        cornerHashMap.put(symbol, cornerHashMap.getOrDefault(symbol, 0)+ 1);
        return cornerHashMap.get(symbol) == 4;
    }

}
