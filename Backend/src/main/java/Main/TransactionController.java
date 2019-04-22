package Main;

import Collections.Collections;
import org.springframework.web.bind.annotation.*;
import Models.Transaction;
import java.util.ArrayList;

@RestController
public class TransactionController {
    //@RequestParam(value="name", defaultValue="World") String name

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping(Collections.route+"Transactions")
    public ArrayList<Transaction> Transactions(@RequestParam(value="filter", defaultValue="") String filter) {
        ArrayList<Transaction> list;

        //Collections.getInstance().getTransactions().cleanList();

        //list = Collections.getInstance().getTransactions().getListFiltered(filter);

        return null;
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping(Collections.route+"Transaction/{id}")
    public Transaction TransactionByID(@PathVariable String id) {
        Transaction toReturn = new Transaction();
        try{
            //toReturn = Collections.getInstance().getTransactions().searchByID(id);
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
    @PostMapping(Collections.route+"Transactions")
    public Transaction addTransaction(@RequestParam(value="stock") int stock,
                              @RequestParam(value="price") double price,
                              @RequestParam(value="idCategory") int idCategory,
                              @RequestParam(value="image") String image,
                              @RequestParam(value="name") String name,
                              @RequestParam(value="description") String description){
        Transaction Transaction = new Transaction();
        /*Transaction.setCategory(Collections.getInstance().getCategories().get(idCategory-1));
        Transaction.setName(name);
        Transaction.setPrice(price);
        Transaction.setDescription(description);
        Transaction.setIdTransaction(Collections.getInstance().getTransactions().getLength()+1);
        Transaction.setImage(image);
        Transaction.setStock(stock);*/

        Collections.getInstance().getTransactions().insert(Transaction);

        //return Collections.getInstance().getTransactions().searchByID(Transaction.getIdTransaction()+"");
        return null;
    }


    @CrossOrigin(origins = "http://localhost:4200")
    @DeleteMapping(Collections.route+"Transaction/{id}")
    public boolean deleteTransaction(@PathVariable String id) {
        Transaction toDelete = new Transaction();
        try{
            //toDelete = Collections.getInstance().getTransactions().searchByID(id);
        }catch (Exception e){
            toDelete = null;
            System.out.println(e.toString());
        }
        if(toDelete.getIdTransaction()!=0){
           // Collections.getInstance().getTransactions().deleteKey(toDelete);
            return true;
        }else{
            return false;
        }
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @PutMapping(Collections.route+"Transaction/{id}")
    public boolean editTransaction(@PathVariable String id,
                               @RequestParam(value="stock") int stock,
                               @RequestParam(value="price") double price,
                               @RequestParam(value="idCategory") int idCategory,
                               @RequestParam(value="image") String image,
                               @RequestParam(value="name") String name,
                               @RequestParam(value="description") String description) {
        Transaction toEdit = new Transaction();

        try{
            //toEdit = Collections.getInstance().getTransactions().searchByID(id);
        }catch (Exception e){
            toEdit = null;
            System.out.println(e.toString());
        }
        if(toEdit.getIdTransaction()!=0){
            /*toEdit.setCategory(Collections.getInstance().getCategories().get(idCategory-1));
            toEdit.setPrice(price);
            toEdit.setDescription(description);
            toEdit.setImage(image);
            toEdit.setStock(stock);*/
            /*if(toEdit.getName().equals(name)){
                Collections.getInstance().getTransactions().edit(toEdit);
            }else{
                Collections.getInstance().getTransactions().deleteKey(toEdit);
                toEdit.setName(name);
                Collections.getInstance().getTransactions().insert(toEdit);
            }*/
            return true;
        }else{
            return false;
        }
    }
}
