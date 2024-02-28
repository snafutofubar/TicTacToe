package model;

import service.botPlayingStragy.bolPlayingStrategyFactory;
import service.botPlayingStragy.botPlayingStrategy;
import service.botPlayingStragy.botStrategy;

public class Bot extends Player{
    private BotDifficultyLevel botDifficultyLevel;

    public Bot(int id, char symbol, BotDifficultyLevel botDifficultyLevel)
    {
        super(id, symbol, "R2D2", PlayerType.BOT);
        this.botDifficultyLevel = botDifficultyLevel;
    }

    @Override
    public Move makeMove(Board board) {

        return bolPlayingStrategyFactory.getBotPlayingStrategy(botStrategy.SEQUENTIAL).makeMove(board, this);
    }
}
