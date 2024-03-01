package hw_oop_sem4.Units;

import java.util.ArrayList;

/*
поля данных
- сила - strength
- ловкость - agility
 поля поведения
 - work
 */
public class Peasant extends UnitBase {
 int strength;//сила
 int agility;//ловкость

 public Peasant(int x,int y,String name, int health, int stamina, int weapon, int strength, int agility) {
  super(x,y,name, health, stamina, weapon,0);
  this.strength = strength;
  this.agility = agility;
 }
 public Peasant(int x,int y,String name) {
  super(x,y,name, 10, 4, 3,0);
  this.strength = 5;
  this.agility = 3;
 }
 @Override
 protected void attack(UnitBase target) {
  int damage = UnitBase.r.nextInt(1,5)*strength*agility;
  target.GetDamage(damage);
 }
 public void work(int hour){
  stamina-= hour /4;
 }

 @Override
 public String toString() {
  return "Peasant '" +
          name + '\'' +
          position.toString()+", health "+this.health;
 }

 @Override
 public boolean step(ArrayList<UnitBase> team, ArrayList<UnitBase> frteam) {
  return true;
 }
}
