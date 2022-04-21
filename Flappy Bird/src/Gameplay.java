import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Gameplay extends JPanel implements KeyListener, ActionListener {

    private int x = 150;
    private int y = 300;

    private int VelY = -20;

    public Gameplay(){
        addKeyListener(this);
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);

        int delay = 8;
        Timer timer = new Timer(delay, this);
        timer.start();
    }

    public void paint(Graphics g){
        g.setColor(new Color(2, 126, 124));
        g.fillRect(0, 0, 400, 700);
        g.setColor(Color.yellow);
        g.fillRect(x, y, 20, 20);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        repaint();
        VelY += 1;
        y += VelY;
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_SPACE){
            VelY = -20;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
