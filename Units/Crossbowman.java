package hw_oop_sem4.Units;

import java.util.ArrayList;

public class Crossbowman extends UnitBowman {
    protected int accuracy; // точность


    public Crossbowman(int x,int y,String name  ) {
        super(x,y,name, 10, 5, 6,3);
        this.accuracy = 6;
        //this.amounOfarrows = 7;
    }
    public String toString() {
        return "Crossbowman '" +
                name + '\'' +
                position.toString()+". arrows "+this.amounOfarrows+", health "+this.health
                ;
    }




}
