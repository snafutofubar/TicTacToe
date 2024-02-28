package model;

public class Cell {
    private int row;
    private int col;



    private Player player;

    public void setPlayer(Player player) {
        this.player = player;
    }

    public void setCellState(CellState cellState) {
        this.cellState = cellState;
    }

    public CellState getCellState() {
        return cellState;
    }

    private CellState cellState;

    public Cell(int row, int col) {
        this.row = row;
        this.col = col;
        this.player =null;
        this.cellState = CellState.EMPTY;
    }

    public void displayCell()
    {
        if(this.player == null)
        {
            System.out.print("| |");
        }
        else
        {
            System.out.print("|"+ this.player.getSymbol() +"|");
        }
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }

    public Player getPlayer() {
        return player;
    }
}
