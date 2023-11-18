public class Node {
    int value;
    String content;
    Node[] neighbors;
    String item;

    public Node(int value,String content) {
        this.value = value;
        this.content = content;
        this.neighbors = new Node[4];
    }

}
