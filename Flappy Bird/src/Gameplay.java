import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Gameplay extends JPanel implements KeyListener, ActionListener {

    //Zmienne przechowujące współrzędne Birda
    private Bird bird = new Bird(150, 300);

    private Pipe testPipe = new Pipe(600, 300);

    //Zmienna sterującąca mechanizmem pauzy w grze;
    private boolean isPlaying = false;

    //Konstruktor klasy Gameplay
    public Gameplay(){
        addKeyListener(this);
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);

        int delay = 8;
        Timer timer = new Timer(delay, this);
        timer.start();
    }

    //Funkcja rysująca grafikę;
    public void paint(Graphics g){

        g.setColor(new Color(2, 126, 124));
        g.fillRect(0, 0, 400, 700);

        if (!isPlaying) {
            g.setColor(Color.red);
            g.fillRect(100, 100, 200, 200);
        }
        bird.draw(g);
        testPipe.draw(g);

    }

    //Główna pętla gry
    //aaaaa
    @Override
    public void actionPerformed(ActionEvent e) {
        if (isPlaying){
            bird.move();
            testPipe.move();
        }
        repaint();
    }
    //FUNKCJE STERUJĄCE KLAWISZAMI.
    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_SPACE){
            if (!isPlaying){
                isPlaying = true;
            }
            else{
                bird.jump();
            }

        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
