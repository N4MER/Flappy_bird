
public class StartButton extends MyButtons {

    public StartButton(Game game) {
        super(game);
        this.setText("Press to start");
    }

    @Override
    public void performedActionOnPress(Game game) {
        super.performedActionOnPress(game);
        game.remove(this);
        game.startGame();

    }



}

