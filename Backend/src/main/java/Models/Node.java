package Models;

public class Node {
    public Transaction[] keys;
    public Node[] children;

    public Transaction[] getKeys() {
        return keys;
    }

    public void setKeys(Transaction[] keys) {
        this.keys = keys;
    }

    public Node[] getChildren() {
        return children;
    }

    public void setChildren(Node[] children) {
        this.children = children;
    }
}
