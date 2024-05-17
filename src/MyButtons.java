import javax.swing.*;
public abstract class MyButtons extends JButton{
    public MyButtons(Game game) {
        setBounds(0, 0, game.getBackgroundWidth(), game.getBackgroundHeight());
        setOpaque(false);
        setContentAreaFilled(false);
        setBorderPainted(false);
        setFocusable(false);
        myAddActionListener(game);
    }

    public void myAddActionListener(Game game) {
        this.addActionListener(e -> {
            if (e.getSource() == this) {
                performedActionOnPress(game);
            }
        });
    }

    public void performedActionOnPress( Game game) {

    }


}
