import java.awt.*;

public class HookLine {
    int x =380;
    int y = 200;          //starter point

    int xf = 500;
    int yf = 500;         //end point

    double length = 100.0;      //line length
    double n = 0.5;

    int direction = 1;        // direction of the line

    int state = 0;            // 0 == wave   1 == grab  2 == pull

    Image hook = Toolkit.getDefaultToolkit().getImage("PoroImg/hook.png");

    PoroGame frame;


    HookLine(PoroGame frame){
        this.frame = frame;
    }

    void collisionD(){
        for(Poro p : this.frame.poroList){
            if(xf > p.x && xf < p.x + p.w
                    && yf > p.y && yf < p.y + p.h) {   //detect collision between hook and poro
                state = 3;
                p.start = true;
            }
        }

    }


    void drawLines(Graphics g){
        xf = (int) (x + length*Math.cos(n *Math.PI));
        yf = (int)(y + length*Math.sin(n *Math.PI));        // draw lines and make line has angle
                                                            // a == (0,pi)   set n = (0,1)  npi == (0,pi)

        g.setColor(Color.red);
        g.drawLine(x-1,y,xf-1,yf);
        g.drawLine(x,y,xf,yf);
        g.drawLine(x+1,y,xf+1,yf);
        g.drawImage(hook,xf - 18, yf - 8,null);              //draw hook
    }

    void painSelf(Graphics g){
        collisionD();    //use this detection in graph

        switch (state){
            case 0:            // wave the line
                if(n < 0.1)
                    direction = 1;
                else if(n > 0.9)             // make the line wave
                    direction = -1;

                n = n +0.005 * direction;

                drawLines(g);
                break;

            case 1:            // make the line go grab poro
                if(length < 800) {
                    length = length + 10;

                    drawLines(g);
                }else state = 2;
                break;

            case 2:                              // pull back the line when reach the end
                if(length > 100) {
                    length = length - 10;
                    drawLines(g);
                }else state = 0;
                break;

            case 3:
                int m = 1;
                if(length > 100) {                // pullback when collision happens
                    length = length - 10;
                    drawLines(g);
                    for(Poro p : this.frame.poroList){
                        if(p.start) {
                            m = p.m;
                            p.x = xf - p.getW() / 2;
                            p.y = yf;
                            if (length <= 100) {
                                p.x = -150;
                                p.y = -150;
                                p.start = false;
                                BackGround.totalS += p.score; // add points
                                BackGround.isBoost = false;  // initialize boost
                                state = 0;
                            }
                            if(BackGround.isBoost){
                                if(p.poroT == 1)
                                    m = 1;
                                if(p.poroT == 2) {
                                    p.x = -150;
                                    p.y = -150;
                                    p.start = false;
                                    state = 2;
                                    BackGround.isBoost = false;
                                }
                            }
                        }
                    }
                }
                try {
                    Thread.sleep(m);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                break;


            default:
        }


    }
}
