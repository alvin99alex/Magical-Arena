import java.util.Random;
import java.util.Scanner;

public class Main {
    static String winner;

    public static class Player{

        //Optional name of Player
        String name;

        // Attributes of player in the game;
        int health;
        int strength;
        int attack;

        Player(String name,int h,int d,int a){
            this.name = name;

            health = h;
            strength = d;
            attack = a;
        }


    }
    static Random rd ;
    static Scanner sc;

    static Player player1;
    static Player player2;
    ///Main Function
    public static void main(String[] args) {
        sc = new Scanner(System.in);
        rd = new Random();

        winner = "";



        System.out.println("Enter the First Player's Name:");
        String Player1_name = sc.next();


        System.out.println("Enter the Second Player's Name:");

        String Player2_name = sc.next();
        System.out.println("Press 1 : To enter attributes manually \n Press 2 : To randomly assign attributes");
        System.out.println();
        int choice = sc.nextInt();
        // Local Variable for player 1
        int Player1_health ;
        int Player1_strength;
        int Player1_attack ;


        // Local Variable for player 2
        int Player2_health ;
        int Player2_strength ;
        int Player2_attack ;


        if(choice == 1){
            System.out.println("Enter Health for " + Player1_name);
            Player1_health = Math.max(Math.min(sc.nextInt(),100),1);  // Greater than 0 and less than 100
            System.out.println("Enter Strength for " + Player1_name);
            Player1_strength = Math.max(Math.min(sc.nextInt(),20),1);// Greater than 0 and less than 20
            System.out.println("Enter Attack for " + Player1_name);
            Player1_attack = Math.max(Math.min(sc.nextInt(),20),1);// Greater than 0 and less than 20

            System.out.println("Enter Health for " + Player2_name);
            Player2_health = Math.max(Math.min(sc.nextInt(),100),1);
            System.out.println("Enter Strength for " + Player2_name);
            Player2_strength = Math.max(Math.min(sc.nextInt(),20),1);
            System.out.println("Enter Attack for " + Player2_name);
            Player2_attack = Math.max(Math.min(sc.nextInt(),20),1);
        }
        else if(choice == 2){

             Player1_health = rd.nextInt(100) + 1;
             Player1_strength = rd.nextInt(20) + 1;
             Player1_attack = rd.nextInt(50) + 1;



             Player2_health = rd.nextInt(100) + 1;
             Player2_strength = rd.nextInt(20) + 1;
             Player2_attack = rd.nextInt(50) + 1;


        }
        else{
            return;
        }
        player1 = new Player(Player1_name,Player1_health,Player1_strength,Player1_attack);
        player2 = new Player(Player2_name,Player2_health,Player2_strength,Player2_attack);

        displayResults();
        if(player1.health < player2.health){
            gamePlay(player1,player2);
        }
        else{
            gamePlay(player2,player1);
        }

        System.out.println("Winner : " + winner);
    }

    public  static void displayResults() {
        System.out.println();
        System.out.println("Name\tH\tS\tA");
        System.out.println(player1.name + "\t" + player1.health + "\t" + player1.strength + " \t" + player1.attack);
        System.out.println(player2.name + "\t" + player2.health + " \t" + player2.strength + " \t" + player2.attack);
    }

    public static void gamePlay(Player attacker,Player defender) {
        if(attacker.health <= 0){

            winner = defender.name;
            return ;
        }
        if(defender.health <= 0){

            winner = attacker.name;
            return;
        }

        System.out.println();
        System.out.println(attacker.name + " is the attacker");
        printdescription(attacker);
        int dieValue_Attacker = rd.nextInt(6) + 1;

        System.out.println(defender.name + " is the defender");
        printdescription(defender);
        int dieValue_Defender = rd.nextInt(6) + 1;

        ScoreAfterfight(attacker,dieValue_Attacker,defender,dieValue_Defender);
        gamePlay(defender,attacker);
    }

    public static void ScoreAfterfight(Player attacker, int dieValue_attacker, Player defender, int dieValue_defender) {
        System.out.println();
        System.out.println("Attackers Die:" + dieValue_attacker);
        System.out.println("Defenders Die:" + dieValue_defender);
        int attack_power = attacker.attack*dieValue_attacker;
        int defend_power = defender.strength*dieValue_defender;
        if(attack_power > defend_power){
            int diff = Math.min(defender.health,attack_power - defend_power);

            defender.health -= diff;
            System.out.println("........."+ defender.name + " health decreased by " +diff+ " to " + defender.health + ".........");
            displayResults();
        }
        else{
            System.out.println(".............Nothing happened....................");
        }

    }

    public static void printdescription(Player p){

        System.out.println(p.name + " Press 1 to throw the Die.........");
        while (sc.nextInt() != 1){
            System.out.println("You Pressed other number!!!!!");
            System.out.println("Press 1 to throw the Die.........");
        }
    }
}