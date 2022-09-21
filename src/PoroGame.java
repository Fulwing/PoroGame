import javax.swing.*;
import java.awt.*;

public class PoroGame extends JFrame {

    BackGround backGround = new BackGround();
    HookLine hookLine = new HookLine();
    void launch(){
        this.setVisible(true);
        this.setSize(750,1000);
        this.setLocationRelativeTo(null);            // window set up
        this.setTitle("Poro Game");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    @Override
    public void paint(Graphics g) {
        backGround.painSelf(g);                 // use draw all the background
        hookLine.painSelf(g);
    }




    public static void main(String[] args){
        PoroGame poroGame = new PoroGame();
        poroGame.launch();
    }
}
