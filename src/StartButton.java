import javax.swing.*;

public class StartButton extends MyButtons {
    public StartButton(Game game) {
        super(game);
        setText("Press to start");
        setInputToAction(KeyStroke.getKeyStroke("SPACE"));

    }
    @Override
    public void performedActionOnPress(Game game) {
        game.startGame();
    }



}

