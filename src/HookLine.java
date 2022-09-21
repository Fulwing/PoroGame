import java.awt.*;

public class HookLine {
    int x =380;
    int y = 200;          //starter point

    int xf = 500;
    int yf = 500;         //end point

    void painSelf(Graphics g){
        g.setColor(Color.red);
        g.drawLine(x,y,xf,yf);
    }
}
