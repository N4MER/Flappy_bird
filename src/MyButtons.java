import javax.swing.*;
public abstract class MyButtons extends JButton{
    public MyButtons(Game game) {
        this.setOpaque(false);
        this.setContentAreaFilled(false);
        this.setBorderPainted(false);
        this.setFocusable(false);
        this.myAddActionListener(game);
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
