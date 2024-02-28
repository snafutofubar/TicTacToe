package model;

import java.util.ArrayList;
import java.util.List;

public class Board {
    public int getDimension() {
        return dimension;
    }

    public List<List<Cell>> getMatrix() {
        return matrix;
    }

    private int dimension;
    private List<List<Cell>> matrix;

    public Board(int dimension)
    {
        this.dimension = dimension;
        this.matrix = new ArrayList<>();

        for(int i = 0; i < dimension; i++)
        {
            this.matrix.add(new ArrayList<>());
            for(int j = 0; j < this.dimension; j++)
            {
                this.matrix.get(i).add(new Cell(i, j));
            }
        }

    }

    public void displayBoard()
    {
        for(int i = 0; i < this.dimension; i++) {
            List<Cell> cells = this.matrix.get(i);
            for (Cell cell : cells) {
                cell.displayCell();
            }
            System.out.println();
        }
    }

    public boolean validateCellInbound(int row, int col)
    {
        if(row >= this.dimension || row < 0 || col >= this.dimension || col < 0)
        {
            return false;
        }
        return true;
    }


}
