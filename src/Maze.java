import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
public class Maze {
    private Node[][] maze;
    private Node[][] dungeon;

    public Maze(int rows,int cols){
        maze = new Node[rows][cols];
        setMaze();
    }
    public void setMaze(){
        for (int i = 0; i < maze.length; i++) {
            for (int j = 0; j < maze[0].length; j++) {
                maze[i][j] = new Node(0,"empty");
            }
        }
//        maze[maze.length - 1][maze[0].length - 1].content = "end";
        maze[4][9].content = "Heart Stone1";
        maze[4][9].item = "heart piece";
        maze[2][1].content = "Heart Stone2";
        maze[2][1].item = "heart piece";
        maze[2][7].content = "shop1";
        maze[2][7].item = "shop";
        maze[4][3].content = "shop2";
        maze[4][3].item = "shop";
        maze[0][9].content = "200-money";
        maze[0][9].item = "money";
        maze[9][0].content = "400-money";
        maze[9][0].item = "money";
        maze[7][3].content = "checkpoint1";
        maze[7][3].item = "checkpoint";
        maze[4][6].content = "checkpoint2";
        maze[4][6].item = "checkpoint";
        maze[6][1].content = "dungeon";
        maze[6][1].item = "dungeon";
        maze[7][6].content = "dungeon";
        maze[7][6].item = "dungeon";
        maze[9][3].content = "White Sword";
        maze[9][3].item = "WS";
        maze[4][6].content = "Legendary Sword";
        maze[4][6].item = "LS";
        // Set start and end points
//        start = maze[0][0];
//        end = maze[maze.length - 1][maze[0].length - 1];

        // Connect neighboring nodes (assuming a simple grid)
        for (int i = 0; i < maze.length; i++) {
            for (int j = 0; j < maze[0].length; j++) {
                if (i > 0) maze[i][j].neighbors[0] = maze[i - 1][j]; // Up
                if (i < maze.length - 1) maze[i][j].neighbors[1] = maze[i + 1][j]; // Down
                if (j > 0) maze[i][j].neighbors[2] = maze[i][j - 1]; // Left
                if (j < maze[0].length - 1) maze[i][j].neighbors[3] = maze[i][j + 1]; // Right
            }
        }
    }
    public Node[][] Dungeon(int type){

        if(type == 1){
            dungeon = new Node[4][4];

            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < 4; j++) {
                    dungeon[i][j] = new Node(0, "empty");
                }
            }
            dungeon[0][2].content = "zombie";
            dungeon[0][2].item = "hit";
            dungeon[dungeon.length - 2][dungeon[0].length - 2].content = "Boss1";
            dungeon[dungeon.length - 2][dungeon[0].length - 2].item = "Boss1";

        }
        else{
            dungeon = new Node[5][5];

            for (int i = 0; i < 5; i++) {
                for (int j = 0; j < 5; j++) {
                    dungeon[i][j] = new Node(0, "empty");
                }
            }
            dungeon[3][4].content = "falcon";
            dungeon[1][2].content = "spear";
            dungeon[3][4].item = "hit";
            dungeon[1][2].item = "hit";
            dungeon[dungeon.length - 1][dungeon[0].length - 2].item = "Boss2";

        }
        // Set start and end points
//        start = maze[0][0];
//        end = maze[maze.length - 1][maze[0].length - 1];

        // Connect neighboring nodes (assuming a simple grid)
        for (int i = 0; i < dungeon.length; i++) {
            for (int j = 0; j < dungeon[0].length; j++) {
                if (i > 0) dungeon[i][j].neighbors[0] = dungeon[i - 1][j]; // Up
                if (i < dungeon.length - 1) dungeon[i][j].neighbors[1] = dungeon[i + 1][j]; // Down
                if (j > 0) dungeon[i][j].neighbors[2] = dungeon[i][j - 1]; // Left
                if (j < dungeon[0].length - 1) dungeon[i][j].neighbors[3] = dungeon[i][j + 1]; // Right
            }
        }
        return dungeon;
    }
    public void fight(ArrayList<String> bag,int type){
        if(type==1){
            if(bag.contains("WS")){
                System.out.println("Defeated the boss!! have a good day!!");
                System.exit(0);
            }
        }
        else{
            if(bag.contains("LS")){
                System.out.println("Defeated the boss!! have a good day!!");
                System.exit(0);
            }
        }
    }

    public Node[][] getMaze() {
        return maze;
    }

}
