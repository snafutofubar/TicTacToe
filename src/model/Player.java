package model;

import java.util.Scanner;

public class Player {

    private int id;
    private char symbol;
    private String name;
    private PlayerType playerType;

    public Move makeMove(Board board)
    {
        Scanner obj = new Scanner(System.in);
        System.out.println("Row of next Move");
        int row = obj.nextInt();
        System.out.println("Col of next Move");
        int col = obj.nextInt();
        if(!board.validateCellInbound(row, col))
        {
            System.out.println("Invalid row or column, Please try again");
            makeMove(board);
        }
        Cell cell = board.getMatrix().get(row).get(col);
        if(cell.getCellState().equals(CellState.FILLED))
        {
            System.out.println("Cell already filled, Please try again");
            makeMove(board);
        }
        cell.setPlayer(this);
        cell.setCellState(CellState.FILLED);


        return new Move(cell, this);
    }

    public Player(int id, char symbol, String name, PlayerType playerType) {
        this.id = id;
        this.symbol = symbol;
        this.name = name;
        this.playerType = playerType;
    }

    public Player() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public PlayerType getPlayerType() {
        return playerType;
    }

    public void setPlayerType(PlayerType playerType) {
        this.playerType = playerType;
    }
    public char getSymbol() {
        return symbol;
    }

    public void setSymbol(char symbol) {
        this.symbol = symbol;
    }


}
