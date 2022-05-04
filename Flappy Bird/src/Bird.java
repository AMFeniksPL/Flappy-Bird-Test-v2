import java.awt.*;

public class Bird {

    private int x;
    private int y;

    private int velY;

    public Bird(int x, int y) {
        this.x = x;
        this.y = y;
        this.velY = -20;
    }

    public void jump(){
        velY = -20;
    }

    public void move(){
        velY += 1;
        if (velY > 15){
            velY = 15;
        }
        y += velY;
    }

    public void draw(Graphics g){
        g.setColor(Color.green);
        g.fillRect(x, y, 20, 20);

        g.drawRoundRect(x-10, y - 10, 40, 40, 10, 10);
        int[] pointsX = new int[]{x - 10, x + 10, x + 30, x + 10};
        int[] pointsY = new int[]{y + 10, y + 30, y + 30, y + 40};
        g.setColor(Color.blue);
        g.drawPolygon(pointsX, pointsY, 4);
        g.clipRect(x, y, 300, 300);
        
    }
}

