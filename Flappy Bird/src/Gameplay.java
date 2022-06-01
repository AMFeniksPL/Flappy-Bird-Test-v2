import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.LinkedList;
import java.util.Random;

public class Gameplay extends JPanel implements KeyListener, ActionListener {
    //TEST
    //Zmienne przechowujące współrzędne Birda
    Timer timer;
    private Bird bird;


    //Zmienna sterującąca mechanizmem pauzy w grze;
    private boolean isPlaying;

    private LinkedList<Pipe> pipeList;

    private Stopwatch pipeSpawnDelayer;
    private int limit;

    Random random;

    //Konstruktor klasy Gameplay
    public Gameplay(){
        addKeyListener(this);
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);

        random = new Random();
        int delay = 8;
        this.timer = new Timer(delay, this);

        bird = new Bird(150, 300);
        isPlaying = false;
        pipeList = new LinkedList<>();

        pipeSpawnDelayer = new Stopwatch();
        limit = 2;

        timer.start();
        pipeSpawnDelayer.start();
    }

    //Funkcja rysująca grafikę;
    public void paint(Graphics g){

        g.setColor(new Color(2, 126, 124));
        g.fillRect(0, 0, 400, 700);

        if (!isPlaying) {
            g.setColor(Color.red);
            g.fillRect(100, 100, 200, 200);
        }

        for (Pipe pipe: pipeList){
            pipe.draw(g);
        }

        bird.draw(g);


    }

    //Główna pętla gry
    @Override
    public void actionPerformed(ActionEvent e) {
        if (isPlaying){
            bird.move();

            if ((int)pipeSpawnDelayer.getElapsedTimeSeconds() >= limit){
                int randomHeight = random.nextInt(300);
                pipeList.add(new Pipe(500, randomHeight - 250));
                pipeList.add(new Pipe(500, randomHeight + 250));
                pipeSpawnDelayer.start();
            }

            for (Pipe pipe: pipeList){
                pipe.move();
                if (bird.getRect().intersects(pipe.getRect())){
                    bird = new Bird(150, 300);
                    isPlaying = false;
                    pipeList = new LinkedList<>();

                    pipeSpawnDelayer = new Stopwatch();
                    limit = 2;
                }
            }

            //COLLISIONS:

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
