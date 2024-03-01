package hw_oop_sem4.Units;

import java.util.ArrayList;

public class UnitMage extends UnitBase {
    public UnitMage(int x, int y, String name, int health, int stamina, int weapon, int lead) {
        super(x, y, name, health, stamina, weapon, lead);
    }

    @Override
    public boolean step(ArrayList<UnitBase> team, ArrayList<UnitBase> frteam) {
        return true;
    }
}
