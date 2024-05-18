
import javax.swing.*;
import java.awt.event.ActionEvent;

public abstract class MyButtons extends JButton {
    private InputMap inputMap;
    private ActionMap actionMap;
    private KeyStroke spaceKey = KeyStroke.getKeyStroke("SPACE");
    private Game game;


    public MyButtons(Game game) {
        this.game = game;
        setBounds(0, 0, game.getBackgroundWidth(), game.getBackgroundHeight());
        setOpaque(false);
        setContentAreaFilled(false);
        setBorderPainted(false);
        setFocusable(false);
        myAddActionListener(game);
        inputMap = getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
        actionMap = getActionMap();
        inputMap.put(spaceKey, "pressed space");
        actionMap.put("pressed space", buttonAction );
    }

    private Action buttonAction = new AbstractAction() {
        @Override
        public void actionPerformed(ActionEvent e) {
            performedActionOnPress(game);
        }
    };

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
