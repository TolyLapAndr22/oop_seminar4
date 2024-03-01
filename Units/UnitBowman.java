package hw_oop_sem4.Units;

import java.util.ArrayList;

public class UnitBowman extends UnitBase{

    protected int amounOfarrows=10; //кол стрел
    public UnitBowman(int x, int y, String name, int health, int stamina, int weapon, int lead) {
        super(x, y, name, health, stamina, weapon, lead);
    }

    @Override
    public boolean step(ArrayList<UnitBase> team, ArrayList<UnitBase> frteam) {

        if(death(UnitBowman.this )&& this.amounOfarrows>0){
            findТearУnemy(team);
            if(this.teamIndex == -1)return false;
            team.get(this.teamIndex).GetDamage(1);
            this.amounOfarrows-=1;
            System.out.println(this+" > attacks "+team.get(this.teamIndex));
        }

        return true;
    }
}
