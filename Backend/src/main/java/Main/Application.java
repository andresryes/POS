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
        Collections.getInstance().getProducts().insert(new Product(1, 100, 10.50, new Category(2, "beverage"), "../assets/americano.jpg", "American", "coffee"));
        Collections.getInstance().getProducts().insert(new Product(2, 210, 8.60, new Category(1, "food"), "./assets/bacon-gouda.jpg", "Bacon", "sandwich with bacon"));
        Collections.getInstance().getProducts().insert(new Product(3, 310, 9.70, new Category(1, "food"), "../assets/bagel.jpg", "Bagel", "this is a bagel"));
        Collections.getInstance().getProducts().insert(new Product(4, 410, 13.50, new Category(1, "food"), "../assets/blueberry-oatmeal.jpg", "Blueberry", "this is a blueberry oatmeal"));
        Collections.getInstance().getProducts().insert(new Product(5, 500, 21.90, new Category(2, "beverage"), "../assets/cappuccino.jpg", "Cappuccino", "this is a cappuccino"));
        Collections.getInstance().getProducts().insert(new Product(6, 800, 14.50, new Category(1, "food"), "../assets/chocolate-croissant.jpg", "Chocolate", "this is a croissant"));
        Collections.getInstance().getProducts().insert(new Product(7, 410, 13.50, new Category(1, "food"), "../assets/chorizo.jpg", "Sandwich", "this is a sandwich"));
        Collections.getInstance().getProducts().insert(new Product(8, 510, 7.50, new Category(2, "beverage"), "../assets/cortado.jpg", "Cortado", "this is a coffee"));
        Collections.getInstance().getProducts().insert(new Product(9, 410, 13.50, new Category(1, "food"), "../assets/croissant.jpg", "Croissant", "this is a sandwich"));
        Collections.getInstance().getProducts().insert(new Product(10, 510, 7.50, new Category(2, "beverage"), "../assets/drip-coffee.jpg", "Drip Coffee", "this is a coffee"));
        Collections.getInstance().getProducts().insert(new Product(11, 510, 9.50, new Category(2, "beverage"), "../assets/latte.jpg", "Latte", "this is a coffee"));
        Collections.getInstance().getProducts().insert(new Product(12, 510, 10.50, new Category(2, "beverage"), "../assets/matcha-latte.jpg", "Matcha Latte", "this is a coffee"));
        Collections.getInstance().getProducts().insert(new Product(13, 410, 12.50, new Category(1, "food"), "../assets/pumpkin-scone.jpg", "Pumpkin Scone", "this is a Scone"));
        Collections.getInstance().getProducts().insert(new Product(14, 510, 12.50, new Category(2, "beverage"), "../assets/tea.jpg", "Tea", "this is a tea"));
        Collections.getInstance().getProducts().insert(new Product(15, 410, 22.50, new Category(1, "food"), "../assets/sausage-egg.jpg", "Sausage egg", "this is a sausage egg"));
        Collections.getInstance().getProducts().insert(new Product(16, 510, 16.50, new Category(2, "beverage"), "../assets/tea-latte.jpg", "Tea Latte", "this is a tea latte"));



        //Categories
        Collections.getInstance().getCategories().add(new Category(1, "food"));
        Collections.getInstance().getCategories().add(new Category(2, "beverage"));

        //Customers
        Collections.getInstance().getCustomers().insert(new Customer(1, "Andres Bolanos", "City", "94761795"));
        Collections.getInstance().getCustomers().insert(new Customer(2, "Jon Snow", "City", "1745972"));

        //Users
        Collections.getInstance().getUsers().add(new User(1, "admin", "andresryes", "12345"));
        Collections.getInstance().getUsers().add(new User(2, "cashier", "cashier1", "12345"));

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

        Collections.getInstance().getTransactions().insert(transaction);

        //Places
        List<Vertex> nodes = Collections.getInstance().getNodes();
        List<Edge> edges = Collections.getInstance().getEdges();

        for (int i = 0; i < 11; i++) {
            Vertex location = new Vertex(""+i, "Place#" + i);
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
