import java.awt.*;

public class BadPoro extends Poro{
    BadPoro(){
        this.x = (int)(Math.random()*700);
        this.y = (int)(Math.random()*550 + 300);
        this.w = 72;
        this.h = 72;
        this.start = false;
        this.m = 60;
        this.score = 1;
        this.poroT = 2;
        this.img = Toolkit.getDefaultToolkit().getImage("PoroImg/badporo.png");
    }
}
