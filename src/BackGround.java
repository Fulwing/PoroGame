import java.awt.*;

public class BackGround {
    public static int totalS;  // total score

    public static int level = 1;   // which level

    public int goalS = level*10;           // point needed to reach next level
    public static int boostN = 3;  // number of boost left

    public static boolean isBoost = false;   // false is not using, true is using boost

    public long startTime;

    public long endTime;

    public int boostPrice = (int) (Math.random()*10);   // boost price

    public boolean buy = false;    // true == buy  false == I don't wanna buy this
    Image backGround = Toolkit.getDefaultToolkit().getImage("PoroImg/background.png");        //get image in
    Image sky = Toolkit.getDefaultToolkit().getImage("PoroImg/sky.png");
    Image player = Toolkit.getDefaultToolkit().getImage("PoroImg/arcadeporo_20.png");

    Image boost = Toolkit.getDefaultToolkit().getImage("PoroImg/boost.png");

    void painSelf(Graphics g){
        g.drawImage(backGround , 0, 0, null);
        g.drawImage(sky ,0,0 , null);                              //draw picture
        switch (PoroGame.gameState){
            case 0:
                drawW(g,60,Color.WHITE,"Right click to start the game!", 30, 400);
                break;
            case 1:
                g.drawImage(player, 280,50, null);

                drawW(g,30,Color.BLACK,"Total Score : " + totalS, 30, 190);

                g.drawImage(boost, 425, 74, null);
                drawW(g,30,Color.BLACK,"x " + boostN, 510, 150);              // draw number of boost

                drawW(g, 22, Color.BLACK,"Level: " + level, 30, 100);         // level right now

                drawW(g, 25, Color.RED,"Goal Score: " + goalS, 30, 160);      // goal to next level

                endTime = System.currentTimeMillis();
                long timeL = 20 - (endTime-startTime)/1000;                                  //Timer
                drawW(g, 25, Color.RED,"Time left: " + (timeL > 0 ? timeL:0), 550, 90);
                break;
            case 2:
                g.drawImage(boost, 300, 400, null);
                drawW(g,40,Color.WHITE,"Boost Price: " + boostPrice, 200, 550);
                drawW(g,40,Color.WHITE,"Wanna buy? ", 200, 600);
                if(buy){
                    totalS -= boostPrice;
                    boostN++;
                    buy = false;
                    PoroGame.gameState = 1;
                    startTime = System.currentTimeMillis();
                }
                break;
            case 3:
                drawW(g,60,Color.WHITE,"Oh no you lose TvT", 130, 400);
                drawW(g,40,Color.WHITE,"You just need " + (goalS - totalS) + " more score", 130, 600);
                break;
            case 4:
                drawW(g,60,Color.WHITE,"You won!!!", 250, 550);
                break;
        }

    }

    boolean gamePass(){   //true == no time left   false == still has time
        long timeL = (endTime-startTime)/1000;
        if(timeL > 20)
            return true;
        return false;
    }

    void reStart(){
        totalS = 0;
        level = 1;
        goalS = level*10;   //initialize
        boostN = 3;
        isBoost = false;
    }

    public static void drawW(Graphics g,int size, Color color, String s, int x, int y){
        g.setColor(color);
        g.setFont(new Font("Serif", Font.ITALIC, size));                         //print string
        g.drawString(s, x, y);
    }

}
