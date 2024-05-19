
import javax.swing.*;
import java.awt.event.ActionEvent;

public abstract class MyButtons extends JButton {
    private InputMap inputMap;
    private ActionMap actionMap;
    private KeyStroke key;
    private Game game;
    private Action buttonAction = new AbstractAction() {
        @Override
        public void actionPerformed(ActionEvent e) {
            performedActionOnPress(game);
        }
    };


    public MyButtons(Game game) {
        this.game = game;
        setBounds(0, 0, game.getBackgroundWidth(), game.getBackgroundHeight());
        setOpaque(false);
        setContentAreaFilled(false);
        setBorderPainted(false);
        setFocusable(false);
        myAddActionListener(game);
        setInputToAction(KeyStroke.getKeyStroke("SPACE"));
    }
    public void setInputToAction(KeyStroke keyStroke){
        key = keyStroke;
        inputMap = getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
        actionMap = getActionMap();
        inputMap.put(key, "pressed space");
        actionMap.put("pressed space", buttonAction );

    }


    public void myAddActionListener(Game game) {
        this.addActionListener(e -> {
            if (e.getSource() == this) {
                performedActionOnPress(game);
            }
        });
    }

    public void performedActionOnPress(Game game) {

    }


}
