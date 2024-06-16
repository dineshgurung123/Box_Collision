import javax.swing.*;
import java.awt.*;

public class Main {

    public static void main(String[] args) {
        
  
        JFrame f = new JFrame("Box Collision");
        GamePanel game = new GamePanel();
        f.add(game);

        game.startGame();
        
        f.setSize(500,500);
        f.setVisible(true);

    }
}