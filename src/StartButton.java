public class StartButton extends MyButtons {
    public StartButton(Game game) {
        super(game);
        setText("Press to start");
    }

    @Override
    public void performedActionOnPress(Game game) {
        game.startGame();
    }



}

