package hw_oop_sem4;

import hw_oop_sem4.Units.*;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static ArrayList<UnitBase> team1 = new ArrayList<>();
    public static ArrayList<UnitBase> team2 = new ArrayList<>();
    public static ArrayList<UnitBase> teamAll = new ArrayList<>();
    public static int HealIndex = -1;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int step = 0;
        int winner = 0;
        init();
        teamAll.addAll(team1);
        teamAll.addAll(team2);
        teamAll.sort(new LeadComp());
        System.out.println("команда 1");
        for (UnitBase team : team1) {
            System.out.println(team.toString());
        }
        System.out.println("команда 2");
        for (UnitBase team : team2) {
            System.out.println(team.toString());
        }
        System.out.println("все, отсортированые");
        for (UnitBase team : teamAll) {
            System.out.println(team.toString());
        }
        System.out.println("ataca");

        while (true) {
            System.out.println("step " + ++step);

            for (UnitBase unit : teamAll) {
                if (team1.contains(unit)) {
                    if (!unit.step(team2, team1)) {
                        winner=1;
                        break;
                    }
                } else {
                    if (!unit.step(team1, team2)) {
                        winner=2;

                        break;
                    }
                }

            }
            System.out.println("");

            //scan.nextLine();
            if(findHealNNull(team1)) {
                winner=2;
                break;
            }
            if(findHealNNull(team2)){
                winner=1;
                break;
            }
            if (winner > 0) break;
            scan.nextLine();
            //System.out.println("ПОБЕДИЛА КОМАНДА "+ winner);
        }

        System.out.println("ПОБЕДИЛА КОМАНДА " + winner);
        for (UnitBase team : team1) {
             System.out.println(team.toString());
        }
        System.out.println();
        for (UnitBase team : team2) {
            System.out.println(team.toString());
        }

    }

    private static String getName() {
        return String.valueOf(Name.values()[new Random().nextInt(Name.values().length - 1)]);
    }

    private static void init() {

        for (int i = 0; i < 10; i++) {

            switch (new Random().nextInt(7)) {
                case 0:
                    team1.add(new Crossbowman(i, 0, getName()));
                    break;
                case 1:
                    team1.add(new Magician(i, 0, getName()));
                    break;
                case 2:
                    team1.add(new Monk(i, 0, getName()));
                    break;
                case 3:
                    team1.add(new Outlaw(i, 0, getName()));
                    break;
                case 4:
                    team1.add(new Peasant(i, 0, getName()));
                    break;
                case 5:
                    team1.add(new Sniper(i, 0, getName()));
                    break;
                case 6:
                    team1.add(new Spearman(i, 0, getName()));
                    break;

            }
            switch (new Random().nextInt(7)) {
                case 0:
                    team2.add(new Crossbowman(i, 9, getName()));
                    break;
                case 1:
                    team2.add(new Magician(i, 9, getName()));
                    break;
                case 2:
                    team2.add(new Monk(i, 9, getName()));
                    break;
                case 3:
                    team2.add(new Outlaw(i, 9, getName()));
                    break;
                case 4:
                    team2.add(new Peasant(i, 9, getName()));
                    break;
                case 5:
                    team2.add(new Sniper(i, 9, getName()));
                    break;
                case 6:
                    team2.add(new Spearman(i, 9, getName()));
                    break;

            }

        }


    }

    private static boolean findHealNNull(ArrayList<UnitBase> team) {
        HealIndex = -1;
        //double minDist=Double.MAX_VALUE;
        for (UnitBase team2 : team) {
            if (team2.GetHealth() > 0) {

                HealIndex = 1;
            }
        }
        return HealIndex<0;
    }
}