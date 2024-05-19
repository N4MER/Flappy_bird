
public class ResetButton extends MyButtons {
    public ResetButton(Game game) {
        super(game);
        setText("press to restart game");
    }

    @Override
    public void performedActionOnPress(Game game) {
        game.resetGame();
    }
}
