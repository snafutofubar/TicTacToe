package service.botPlayingStragy;

import exceptions.gameOverException;
import model.*;

import java.util.List;

public class sequentialPlayingStrategy implements botPlayingStrategy{

    @Override
    public Move makeMove(Board board, Player player) {
        List<List<Cell>> matrix = board.getMatrix();
        for (int i = 0; i < matrix.size(); i++)
        {
            for (int j = 0; j < matrix.size(); j++)
            {
                Cell cell = matrix.get(i).get(j);
                if(cell.getCellState().equals(CellState.FILLED))
                {
                    continue;
                }
                else
                {
                    cell.setPlayer(player);
                    cell.setCellState(CellState.FILLED);
                    return new Move(cell, player);
                }
            }
        }

        throw new gameOverException("No cell to play, Game's over");
    }
}
