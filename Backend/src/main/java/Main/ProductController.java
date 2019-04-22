package Main;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicLong;
import Collections.Collections;
import Models.Category;
import Models.Product;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
//import org.springframework.web.bind.annotation.RequestParam;


@RestController
public class ProductController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    //@RequestParam(value="name", defaultValue="World") String name

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping(Collections.route+"products")
    public ArrayList<Product> products(@RequestParam(value="filter", defaultValue="") String filter) {
        ArrayList<Product> list;

        Collections.getInstance().getProducts().cleanList();

        list = Collections.getInstance().getProducts().getListFiltered(filter);

        return list;
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping(Collections.route+"product/{id}")
    public Product productByID(@PathVariable String id) {
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

    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping(Collections.route+"products")
    public Product addProduct(@RequestParam(value="stock") int stock,
                              @RequestParam(value="price") double price,
                              @RequestParam(value="idCategory") int idCategory,
                              @RequestParam(value="image") String image,
                              @RequestParam(value="name") String name,
                              @RequestParam(value="description") String description){
        Product product = new Product();
        product.setCategory(Collections.getInstance().getCategories().get(idCategory-1));
        product.setName(name);
        product.setPrice(price);
        product.setDescription(description);
        product.setIdProduct(Collections.getInstance().getProducts().getLength()+1);
        product.setImage(image);
        product.setStock(stock);

        Collections.getInstance().getProducts().insert(product);

        return Collections.getInstance().getProducts().searchByID(product.getIdProduct()+"");

    }


    @CrossOrigin(origins = "http://localhost:4200")
    @DeleteMapping(Collections.route+"product/{id}")
    public boolean deleteProduct(@PathVariable String id) {
        Product toDelete = new Product();
        try{
            toDelete = Collections.getInstance().getProducts().searchByID(id);
        }catch (Exception e){
            toDelete = null;
            System.out.println(e.toString());
        }
        if(toDelete.getIdProduct()!=0){
            Collections.getInstance().getProducts().deleteKey(toDelete);
            return true;
        }else{
            return false;
        }
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @PutMapping(Collections.route+"product/{id}")
    public boolean editProduct(@PathVariable String id,
                                      @RequestParam(value="stock") int stock,
                                      @RequestParam(value="price") double price,
                                      @RequestParam(value="idCategory") int idCategory,
                                      @RequestParam(value="image") String image,
                                      @RequestParam(value="name") String name,
                                      @RequestParam(value="description") String description) {
        Product toEdit = new Product();

        try{
            toEdit = Collections.getInstance().getProducts().searchByID(id);
        }catch (Exception e){
            toEdit = null;
            System.out.println(e.toString());
        }
        if(toEdit.getIdProduct()!=0){
            toEdit.setCategory(Collections.getInstance().getCategories().get(idCategory-1));
            toEdit.setPrice(price);
            toEdit.setDescription(description);
            toEdit.setImage(image);
            toEdit.setStock(stock);
            if(toEdit.getName().equals(name)){
                Collections.getInstance().getProducts().edit(toEdit);
            }else{
                Collections.getInstance().getProducts().deleteKey(toEdit);
                toEdit.setName(name);
                Collections.getInstance().getProducts().insert(toEdit);
            }
            return true;
        }else{
            return false;
        }
    }
}
