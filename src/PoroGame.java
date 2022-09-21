import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

public class PoroGame extends JFrame {

    List<Poro> poroList = new ArrayList<>();     //save poros

    BackGround backGround = new BackGround();
    HookLine hookLine = new HookLine(this);


    //add good poro
    {
        boolean notBlocked = true;    // is the block has blocked

        for (int i = 0; i < 8; i++) {
            double random = Math.random();
            GoodPoro goodPoro;
            if(random < 0.3)
                goodPoro = new DiamPoro();     // create random good poro
            else if(random < 0.7)
               goodPoro = new GoodPoro();
            else
                goodPoro = new GoodPoroMini();

            for(Poro p : poroList){
                if(goodPoro.getRec().intersects(p.getRec())){   // test if blocked
                    notBlocked = false;
                }
            }

            if(notBlocked)
                poroList.add(goodPoro);
            else {                                       // if not blocked return true
                notBlocked = true;
                i--;
            }

        }

        //add bad poro

        for (int i = 0; i < 3; i++) {
            BadPoro badPoro;
            badPoro = new BadPoro();

            for(Poro p : poroList){
                if(badPoro.getRec().intersects(p.getRec())){   // test if blocked
                    notBlocked = false;
                }
            }

            if(notBlocked)
                poroList.add(badPoro);
            else {                                       // if not blocked return true
                notBlocked = true;
                i--;
            }
        }
    }


    Image osImage;    //double buffer background
    void launch(){
        this.setVisible(true);
        this.setSize(768,1000);
        this.setLocationRelativeTo(null);            // window set up
        this.setTitle("Poro Game");
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                if(e.getButton() == 1)
                    hookLine.state = 1;
            }
        });

        while (true){
            repaint();    //make the line move
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    @Override
    public void paint(Graphics g) {
        osImage = this.createImage(768, 1000); //double buffer
        Graphics gImage = osImage.getGraphics();

        backGround.painSelf(gImage);                 // draw all the element

        for(Poro x : poroList){
            x.paintSelf(gImage);               // draw good poro
        }

        hookLine.painSelf(gImage);
        g.drawImage(osImage,0,0,null);
    }




    public static void main(String[] args){
        PoroGame poroGame = new PoroGame();
        poroGame.launch();
    }
}
