import java.awt.*;

public class BackGround {
    public static int totalS;  // total score
    public static int boostN;  // number of boost left
    Image backGround = Toolkit.getDefaultToolkit().getImage("PoroImg/background.png");        //get image in
    Image sky = Toolkit.getDefaultToolkit().getImage("PoroImg/sky.png");
    Image player = Toolkit.getDefaultToolkit().getImage("PoroImg/arcadeporo_20.png");

    Image boost = Toolkit.getDefaultToolkit().getImage("PoroImg/boost.png");

    void painSelf(Graphics g){
        g.drawImage(backGround , 0, 0, null);
        g.drawImage(sky ,0,0 , null);                              //draw picture
        g.drawImage(player, 280,50, null);

        drawW(g,30,Color.BLACK,"Total Score :" + totalS, 30, 150);

        g.drawImage(boost, 425, 74, null);
        drawW(g,30,Color.BLACK,"x " + boostN, 510, 150);
    }

    public static void drawW(Graphics g,int size, Color color, String s, int x, int y){
        g.setColor(color);
        g.setFont(new Font("Serif", Font.ITALIC, size));                         //print string
        g.drawString(s, x, y);
    }
}
