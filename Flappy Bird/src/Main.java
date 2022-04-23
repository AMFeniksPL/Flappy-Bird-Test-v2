import javax.swing.*;

public class Main {
    public static void main(String[] args){
        // GŁÓWNE OKNO GRY
        JFrame obj = new JFrame();
        Gameplay gamePlay = new Gameplay();
        obj.setBounds(10, 10, 400, 700);
        obj.setTitle("Flappy Bird");
        obj.setResizable(false);
        obj.setVisible(true);
        obj.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        obj.add(gamePlay);
    }
}
