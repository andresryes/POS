package Main;

import Collections.Collections;
import Models.*;
import Structures.PlacesGraph;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        initializedProgram();
        SpringApplication.run(Application.class, args);
    }

    public static void initializedProgram(){
        //Products
        for(int i = 1; i<11; i++){
            Collections.getProducts().insert(new Product(i, i+10, i*50, new Category(1, "technology"), "resources/image.png", "iPhone" + i, "this is an iPhone"));
        }

        //Categories
        Collections.getCategories().add(new Category(1, "technology"));
        Collections.getCategories().add(new Category(2, "home"));

        //Customers
        Collections.getCustomers().insert(new Customer(1, "Andres Bolanos", "City", "94761795"));
        Collections.getCustomers().insert(new Customer(2, "Gabryela Hernandez", "City", "1745972"));

        //Users
        Collections.getUsers().add(new User(1, "admin", "andresryes", "12345"));
        Collections.getUsers().add(new User(2, "cashier", "cashier1", "12345"));

        //Transactions
        Transaction transaction = new Transaction();
        Product product = Collections.getProducts().searchByID("1");
        TransactionDetail transactionDetail = new TransactionDetail(1, 1, product, product.getPrice());
        transaction.setCustomer(Collections.getCustomers().searchByID("1"));
        transaction.setUser(Collections.getUsers().get(1));
        transaction.setIdTransaction(1);
        transaction.setTotal(transactionDetail.getSubtotal());

        TransactionDetail[] transactionDetails = new TransactionDetail[1];
        transactionDetails[0] = transactionDetail;
        transaction.setTransactions(transactionDetails);

        Collections.getTransactions().insert(transaction);

        //Places
        List<Vertex> nodes = Collections.getInstance().getNodes();
        List<Edge> edges = Collections.getInstance().getEdges();

        for (int i = 0; i < 11; i++) {
            Vertex location = new Vertex("Node_" + i, "Node_" + i);
            nodes.add(location);
        }

        Collections.getInstance().setNodes(nodes);

        Collections.getInstance().addLane("Edge_0", 0, 1, 85);
        Collections.getInstance().addLane("Edge_1", 0, 2, 217);
        Collections.getInstance().addLane("Edge_2", 0, 4, 173);
        Collections.getInstance().addLane("Edge_3", 2, 6, 186);
        Collections.getInstance().addLane("Edge_4", 2, 7, 103);
        Collections.getInstance().addLane("Edge_5", 3, 7, 183);
        Collections.getInstance().addLane("Edge_6", 5, 8, 250);
        Collections.getInstance().addLane("Edge_7", 8, 9, 84);
        Collections.getInstance().addLane("Edge_8", 7, 9, 167);
        Collections.getInstance().addLane("Edge_9", 4, 9, 502);
        Collections.getInstance().addLane("Edge_10", 9, 10, 40);
        Collections.getInstance().addLane("Edge_11", 1, 10, 600);

        Graph graph = new Graph(Collections.getInstance().getNodes(), Collections.getInstance().getEdges());
        Collections.getInstance().setGraph(graph);
        PlacesGraph placesGraph = new PlacesGraph(Collections.getInstance().getGraph());
        Collections.getInstance().setPlacesGraph(placesGraph);

        Collections.getInstance().getPlacesGraph().execute(Collections.getInstance().getNodes().get(0));
        LinkedList<Vertex> path = Collections.getInstance().getPlacesGraph().getPath(Collections.getInstance().getNodes().get(10));

        for (Vertex vertex : path) {
            System.out.println(vertex);
        }
    }
}
