package Main;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicLong;
import Collections.Collections;
import Models.Product;
import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    //@RequestParam(value="name", defaultValue="World") String name

    @CrossOrigin(origins = "http://localhost:4200")
    @RequestMapping("/products")
    public ArrayList<Product> products(@RequestParam(value="filter", defaultValue="") String filter) {
        ArrayList<Product> list;

        Collections.getInstance().getProducts().cleanList();

        list = Collections.getInstance().getProducts().getListFiltered(filter);

        return list;
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @RequestMapping("/product")
    public Product productByID(@RequestParam(value="id", defaultValue="1") String id) {
        Product toReturn = new Product();
        try{
            toReturn = Collections.getInstance().getProducts().searchByID(id);
        }catch (Exception e){
            System.out.println(e.toString());
        }

        if(toReturn!=null){
            return  toReturn;
        }else{
            return null;
        }
    }




}
