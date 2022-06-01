import java.awt.*;

public class Pipe {
    private int x;
    private int y;

    private Rectangle rect;

    public Pipe(int x, int y) {
        this.x = x;
        this.y = y;

        rect = new Rectangle(this.x, this.y, 50, 300);
    }

    public Rectangle getRect() {
        return rect;
    }

    public void move(){
        x -= 2;
        rect = new Rectangle(this.x, this.y, 50, 300);
    }

    public void draw(Graphics g){
        g.setColor(Color.green);
        g.fillRect(x, y, 50, 300);
    }
}
