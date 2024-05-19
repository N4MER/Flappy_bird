import javax.swing.*;
import java.awt.event.ActionEvent;

public class CloseButton extends MyButtons {
    private InputMap inputMap;
    private ActionMap actionMap;
    private KeyStroke key;
    private Game game;


    public CloseButton(Game game) {
        super(game);
        this.game = game;
        setBounds(game.getBackgroundWidth() - 150, 0, 150, 150);
        setText("Press Esc to close");
        setInputToAction(KeyStroke.getKeyStroke("ESCAPE"));
    }

    private Action buttonAction = new AbstractAction() {
        @Override
        public void actionPerformed(ActionEvent e) {
            performedActionOnPress(game);
        }
    };

    @Override
    public void setInputToAction(KeyStroke keyStroke) {
        key = keyStroke;
        inputMap = getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
        actionMap = getActionMap();
        inputMap.put(key, "pressed escape");
        actionMap.put("pressed escape", buttonAction);
    }

    @Override
    public void performedActionOnPress(Game game) {
        System.exit(0);
    }
}
