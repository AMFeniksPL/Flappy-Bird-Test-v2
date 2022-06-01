import java.awt.*;

public class Bird {

    private int x;
    private int y;

    private int velY;

    private Rectangle rect;

    public Bird(int x, int y) {
        this.x = x;
        this.y = y;
        this.velY = -25;

        rect = new Rectangle(this.x, this.y, 20, 20);
    }

    public Rectangle getRect() {
        return rect;
    }

    public void jump(){
        velY = -25;
    }

    public void move(){
        velY += 2;
        if (velY > 15){
            velY = 15;
        }
        y += velY;

        rect = new Rectangle(x, y, 20, 20);
    }

    public void draw(Graphics g){
        g.setColor(Color.green);
        g.fillRect(x, y, 20, 20);
    }
}

