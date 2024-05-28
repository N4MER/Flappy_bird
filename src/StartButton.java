import javax.swing.*;
import java.awt.*;

public class StartButton extends MyButtons {
    public StartButton(Game game) {
        super(game);
        setText("Press to start");
        setFont(new Font("Arial",Font.PLAIN,50));
        setInputToAction(KeyStroke.getKeyStroke("SPACE"));

    }
    @Override
    public void performedActionOnPress(Game game) {
        game.startGame();
    }



}

