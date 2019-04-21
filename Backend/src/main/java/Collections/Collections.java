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

    private static List<Vertex> nodes;

    private static List<Edge> edges;

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

    public static void setGraph(Graph graph) {
        Collections.graph = graph;
    }

    public static void setNodes(List<Vertex> nodes) {
        Collections.nodes = nodes;
    }

    public static void setEdges(List<Edge> edges) {
        Collections.edges = edges;
    }

    public static void setPlacesGraph(PlacesGraph placesGraph) {
        Collections.placesGraph = placesGraph;
    }

    public static void addLane(String laneId, int sourceLocNo, int destLocNo,
                               int duration) {
        Edge lane = new Edge(laneId,nodes.get(sourceLocNo), nodes.get(destLocNo), duration );
        edges.add(lane);
    }
}
