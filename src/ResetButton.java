public class ResetButton extends MyButtons{

    public ResetButton(Game game) {
        super(game);
        setText("press to restart game");
    }

    @Override
    public void performedActionOnPress(Game game) {
        super.performedActionOnPress(game);
        //game.remove(this);
        game.resetGame();



    }

}
