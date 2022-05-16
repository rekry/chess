package chess_game;

import javax.swing.*;
import java.awt.*;

public class GameFrame extends JFrame {
    JFrame frame = new JFrame("Chess");
    protected JPanel panel = new GamePannel().panel();
    GameFrame() {buildFrame();}

    public void buildFrame() {
        Container contentPane = frame.getContentPane();
        contentPane.setLayout(new FlowLayout(FlowLayout.CENTER, 180,150));
        frame.setBounds(10,10,1000,1000);
        frame.setLocationRelativeTo(null);
        frame.add(this.panel);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
