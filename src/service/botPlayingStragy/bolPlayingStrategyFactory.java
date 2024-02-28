package service.botPlayingStragy;

import model.Board;
import model.Bot;
import model.Player;



public class bolPlayingStrategyFactory {
    public static botPlayingStrategy getBotPlayingStrategy(botStrategy botStrategy)
    {
        switch (botStrategy)
        {
            case SEQUENTIAL ->
            {
                return new sequentialPlayingStrategy();
            }
            default -> {return null;}
        }

    }
}
