package Main;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicLong;
import Collections.Collections;
import Models.Product;
import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    //@RequestParam(value="name", defaultValue="World") String name

    @CrossOrigin(origins = "http://localhost:4200")
    @RequestMapping("/products")
    public ArrayList<Product> products() {
        return Collections.getInstance().getProducts().getList();
    }


}
