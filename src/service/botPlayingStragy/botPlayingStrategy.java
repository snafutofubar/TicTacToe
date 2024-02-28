package service.botPlayingStragy;

import model.Board;
import model.Move;
import model.Player;

public interface botPlayingStrategy {
    public Move makeMove(Board board, Player player);
}
