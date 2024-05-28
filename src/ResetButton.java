import javax.swing.*;
import java.awt.*;

public class ResetButton extends MyButtons {
    public ResetButton(Game game) {
        super(game);
        setText("Press to restart");
        setFont(new Font("Arial",Font.PLAIN,50));
        setInputToAction(KeyStroke.getKeyStroke("SPACE"));
    }

    @Override
    public void performedActionOnPress(Game game) {
        game.resetGame();
    }
}
