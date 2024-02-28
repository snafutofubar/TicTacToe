package service.winningStrategy;

public class winningStrategyFactory {

    public static WinningStrategy getWinningStrategy(winningStrategyName winningStrategyName, int diamention)
    {
        switch (winningStrategyName)
        {
            case ORDERONEWINNINGSTATERGY -> {
            return new orderOneWinningStrategy(diamention);
        }
            default -> {
            return null;
        }
        }
    }
}
