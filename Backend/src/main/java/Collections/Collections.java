package Collections;

import Models.*;
import Structures.CustomersBST;
import Structures.PlacesGraph;
import Structures.ProductsBST;
import Structures.TransactionsBTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Collections {

    private static Collections ourInstance = new Collections();

    public static Collections getInstance() {
        return ourInstance;
    }

    private List<Vertex> nodes;

    private List<Edge> edges;

    public static final ProductsBST products = new ProductsBST();

    public static final ArrayList<Category> categories = new ArrayList<>();

    public static final CustomersBST customers = new CustomersBST();

    public static final ArrayList<User> users = new ArrayList<>();

    public static final TransactionsBTree transactions = new TransactionsBTree();

    public static PlacesGraph placesGraph;

    public static Graph graph;

    private Collections() {
        nodes = new ArrayList<Vertex>();
        edges = new ArrayList<Edge>();
        for (int i = 0; i < 11; i++) {
            Vertex location = new Vertex("Node_" + i, "Node_" + i);
            nodes.add(location);
        }

        addLane("Edge_0", 0, 1, 85);
        addLane("Edge_1", 0, 2, 217);
        addLane("Edge_2", 0, 4, 173);
        addLane("Edge_3", 2, 6, 186);
        addLane("Edge_4", 2, 7, 103);
        addLane("Edge_5", 3, 7, 183);
        addLane("Edge_6", 5, 8, 250);
        addLane("Edge_7", 8, 9, 84);
        addLane("Edge_8", 7, 9, 167);
        addLane("Edge_9", 4, 9, 502);
        addLane("Edge_10", 9, 10, 40);
        addLane("Edge_11", 1, 10, 600);

        Graph graph = new Graph(nodes, edges);
        placesGraph = new PlacesGraph(graph);
        placesGraph.execute(nodes.get(0));
        LinkedList<Vertex> path = placesGraph.getPath(nodes.get(10));

        for (Vertex vertex : path) {
            System.out.println(vertex);
        }

    }

    public static ProductsBST getProducts(){
        return products;
    }

    public static ArrayList<Category> getCategories(){
        return categories;
    }

    public static CustomersBST getCustomers(){
        return  customers;
    }

    public static ArrayList<User> getUsers(){
        return users;
    }

    public static TransactionsBTree getTransactions() {
        return transactions;
    }

    public List<Vertex> getNodes() {
        return nodes;
    }

    public List<Edge> getEdges() {
        return edges;
    }

    public static PlacesGraph getPlacesGraph() {
        return placesGraph;
    }

    public static Graph getGraph() {
        return graph;
    }

    public void addLane(String laneId, int sourceLocNo, int destLocNo,
                        int duration) {
        Edge lane = new Edge(laneId,nodes.get(sourceLocNo), nodes.get(destLocNo), duration );
        edges.add(lane);
    }
}
