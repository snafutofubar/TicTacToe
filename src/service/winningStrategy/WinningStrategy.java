package service.winningStrategy;

import model.*;

public interface WinningStrategy {
    Player checkWinner(Board board, Move lastMove);
}
