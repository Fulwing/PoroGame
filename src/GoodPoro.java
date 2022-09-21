import java.awt.*;

public class GoodPoro extends Poro{

    GoodPoro(){
        this.x = (int)(Math.random()*650);
        this.y = (int)(Math.random()*550 + 300);
        this.w = 105;
        this.h = 105;
        this.start = false;
        this.m = 30;
        this.score = 4;
        this.img = Toolkit.getDefaultToolkit().getImage("PoroImg/Poro_Render.png");
    }
}

class GoodPoroMini extends GoodPoro{
    GoodPoroMini(){
        this.x = (int)(Math.random()*700);
        this.w = 52;
        this.h = 52;
        this.m = 15;
        this.score = 8;
        this.img = Toolkit.getDefaultToolkit().getImage("PoroImg/queenporo.png");
    }
}

class DiamPoro extends GoodPoro{
    DiamPoro(){
        this.x = (int)(Math.random()*700);
        this.w = 32;
        this.h = 23;
        this.m = 3;
        this.score = 12;
        this.img = Toolkit.getDefaultToolkit().getImage("PoroImg/DiamPoro.jpg");
    }
}
