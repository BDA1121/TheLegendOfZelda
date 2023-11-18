import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class player {
    private int i;

    private int heart;
    private int j;
    private int amount;
    private ArrayList<String> bag;
    public player(int i, int j){
        this.i =i;
        this.j=j;
        this.amount=0;
        this.heart=0;
    }

    public void setcheckpoint(int i,int j){
        this.i =i;
        this.j=j;
    }
    public int getcheckpointi(){
        return this.i;
    }
    public int getcheckpointj(){
        return this.j;
    }

    public void setAmount(int amount) {
        this.amount = this.amount + amount;
    }

    public void updateHeart(){
        this.heart++;
    }
    public void hitHeart(){
        this.heart--;
    }
    public int getHeart(){
        return this.heart;
    }
    public boolean fightSmall(ArrayList<String> bag,int type){
        if(type==0||type==3){
            if(bag.contains("guns")){
                return true;
            }
        }
        else{
            if(bag.contains("shield")){
                return true;
            }
        }
        return false;
    }
    public ArrayList<String> interact(String item,ArrayList<String> bag){
        bag.add(item);
        return bag;
    }
    public ArrayList<String> shop(int type, ArrayList<String> bag){
        Scanner input = new Scanner(System.in);
        if (type==1){
            System.out.println("Do you want to buy shield- yes/no");
            String answer = input.nextLine();
            if (answer.equals("yes")) {
                if (this.amount >= 200) {
                    bag.add("shield");
                    this.amount = this.amount - 200;
                } else {
                    System.out.println("Insufficient funds");
                }
            }
        } else if (type==2){
            System.out.println("Do you want to buy guns- yes/no");
            String answer = input.nextLine();
            if (answer.equals("yes")) {
                if (this.amount >= 400) {
                    bag.add("guns");
                    this.amount = this.amount - 400;
                } else {
                    System.out.println("Insufficient funds");
                }
            }
        }
        return bag;
    }
}
