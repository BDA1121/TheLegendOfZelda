import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;
// the game initiates a graph which has certain objects or places to interact with
// the maze class instantiates the maze(graph/Node[][]) and has functions to instantiate the dungeons and other objects
// the graph node is under the node class
// there is a player class with the interaction functions and specific attributes
// the player can traverse using left,right,up,down commands
// the collectibles can be stored in a bag to use later
//  just to move around and test the game, I didn't add system.exit for out of bounds. it can be added with one extra line

public class Main {
    private Maze Maze;
    private player player;

    public static void main(String args[]){
        Scanner input = new Scanner(System.in);
        Maze maze = new Maze(10,10);
        player player1 = new player(0,4);
        Node[][] Game = maze.getMaze();
        Node start = Game[0][4];
        int i=0,j=4;
        Node current = start;
        ArrayList<String> bag = new ArrayList<>();
        System.out.println("Game Started");
        label:
        while(current.content!="end"){
            System.out.println("Where do you wanna go");
            String move = input.nextLine();
            boolean truth = true;
            switch (move) {
                case "up":
                    if (i == 0) {
                        System.out.println("Out of bounds of Maze");
                    } else {
                        i--;
                        current = Game[i][j];
                        System.out.println(current.content);

                    }
                    break;
                case "down":
                    if (i == Game.length - 1) {
                        System.out.println("Out of bounds of Maze");
                    } else {
                        i++;
                        current = Game[i][j];
                        System.out.println(current.content);
                    }
                    break;
                case "left":
                    if (j == 0) {
                        System.out.println("Out of bounds of Maze");
                    } else {
                        j--;
                        current = Game[i][j];
                        System.out.println(current.content);
                    }
                    break;
                case "right":
                    if (j == Game[0].length - 1) {
                        System.out.println("Out of bounds of Maze");
                    } else {
                        j++;
                        current = Game[i][j];
                        System.out.println(current.content);
                    }
                    break;
                case "exit":
                    break label;
                default:
                    truth = false;
                    System.out.println("Invalid direction");
                    break;
            }
            if(truth&&current.item!=null){
                switch (current.item){
                    case "heart piece":
                        System.out.println("Lucky you!! You stumbled on a heart piece!! Added more lives woohooo!!");
                        player1.updateHeart();
                        break;
                    case "hit":
                        if(!player1.fightSmall(bag,i)) {
                            System.out.println("you didn't have the right equipments to fight "+current.content+"!! thus you take a hit");
                            if(player1.getHeart()>0){
                                player1.hitHeart();
                                Game = maze.getMaze();
                                i=player1.getcheckpointi();
                                j=player1.getcheckpointj();
                                System.out.println("getting redirected to checkpoint");
                            }else{
                                System.out.println("No life left!! Game Over!!");
                                System.exit(0);
                            }
                        }
                        else{
                            System.out.println("you killed the "+current.content);
                        }
                        break;
                    case "checkpoint":
                        System.out.println("New Checkpoint!! updated checkpoint to make life easier woohooo!!");
                        player1.setcheckpoint(i,j);
                        break;
                    case "money":
                        System.out.println("Lucky you!! You stumbled on moeny!! ");
                        if(i==0){player1.setAmount(200); System.out.println("Added 200 gold coins woohooo!!");}
                        else{player1.setAmount(400);System.out.println("Added 400 gold coins woohooo!!");}
                        break;
                    case "Boss1":
                        maze.fight(bag,1);
                        if(player1.getHeart()>0){
                            System.out.println("you didn't have the right equipments to fight "+current.content+"!! thus you take a hit");
                            player1.hitHeart();
                            Game = maze.getMaze();
                            i=player1.getcheckpointi();
                            j=player1.getcheckpointj();
                        }else{
                            System.out.println("No life left!! Game Over!!");
                            System.exit(0);
                        }
                        break;
                    case "Boss2":
                        maze.fight(bag,2);
                        if(player1.getHeart()>0){
                            System.out.println("you didn't have the right equipments to fight "+current.content+"!! thus you take a hit");
                            player1.hitHeart();
                            Game = maze.getMaze();
                            i=player1.getcheckpointi();
                            j=player1.getcheckpointj();
                        }else{
                            System.out.println("No life left!! Game Over!!");
                            System.exit(0);
                        }
                        break;
                    case "dungeon":
                        System.out.println("entered a dungeon ooooh!! lookout");
                        if(i==6){Game = maze.Dungeon(1);}
                        else {Game = maze.Dungeon(2);}
                        i=0;j=0;
                        break;
                    case "shop":
                        System.out.println("you have entered a shop!!");
                        if(i==2){bag = player1.shop(1,bag);}
                        else {bag = player1.shop(2,bag);}
                        break;
                    default:
                        System.out.println("Do you want to grab"+current.item);
                        String interact = input.nextLine();
                        if(Objects.equals(interact, "yes")){
                            bag = player1.interact(current.item,bag);
                            System.out.println("you grabbed the "+current.item + "!! you have evolved, mighty warrior!!");
                        }
                        break;
                }

            }

        }
        System.out.println("Game Over");
    }
}