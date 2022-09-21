import java.awt.*;

public class Poro {
    int x;
    int y;      // axis

    int w;
    int h;       // width and height

    int m;    // mass of the poro

    int score;

    int poroT; // 1 == good poro   2 == bad poro

    Image img;

    boolean start = false;  // could the block move  true == yes  false == no

    void paintSelf(Graphics g){
        g.drawImage(img, x, y, null);
    }

    public int getW() {
        return w;
    }

    public Rectangle getRec(){
        return new Rectangle(x , y , w , h);  // square detect
    }
}
