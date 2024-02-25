public class Node {
    private Player player;
    private Node next;

    public Node(Player player) {
        this.player = player;
        this.next = null;
    }

    public Player getPlayer() {
        return player;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return player.toString();
    }
}
