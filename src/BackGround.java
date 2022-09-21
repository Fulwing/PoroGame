import java.awt.*;

public class BackGround {
    Image backGround = Toolkit.getDefaultToolkit().getImage("PoroImg/background.png");        //get image in
    Image sky = Toolkit.getDefaultToolkit().getImage("PoroImg/sky.png");
    Image player = Toolkit.getDefaultToolkit().getImage("PoroImg/arcadeporo_20.png");

    void painSelf(Graphics g){
        g.drawImage(backGround , 0, 0, null);
        g.drawImage(sky ,0,0 , null);                              //draw picture
        g.drawImage(player, 280,50, null);
    }
}
