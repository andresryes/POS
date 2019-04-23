package Main;

import Collections.Collections;
import com.fasterxml.jackson.databind.util.JSONPObject;
import org.springframework.web.bind.annotation.*;
import Models.Transaction;
import java.util.ArrayList;

@RestController
public class TransactionController {
    //@RequestParam(value="name", defaultValue="World") String name

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping(Collections.route+"transactions")
    public ArrayList<Transaction> Transactions(@RequestParam(value="filter", defaultValue="") String filter) {
        ArrayList<Transaction> list;

        Collections.getInstance().getTransactions().cleanList();

        list = Collections.getInstance().getTransactions().getFilteredList(filter);

        return list;
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping(Collections.route+"transaction/{id}")
    public Transaction TransactionByID(@PathVariable String id) {
        Transaction toReturn = new Transaction();
        try{
            toReturn = Collections.getInstance().getTransactions().search(id);
        }catch (Exception e){
            System.out.println(e.toString());
        }

        if(toReturn!=null){
            return  toReturn;
        }else{
            return new Transaction();
        }
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping(Collections.route+"transactions")
    public Transaction addTransaction(@RequestParam(value="idCustomer") int idCustomer,
                              @RequestParam(value="idUser") int idUser,
                              @RequestParam(value="total") double total,
                              @RequestParam(value="transactions") String transactions){
        Transaction Transaction = new Transaction();

        System.out.println(Collections.getInstance().getCustomers().searchByID(idCustomer+"").getName());
        System.out.println(Collections.getInstance().getUsers().get(idUser-1).getUsername());
        System.out.println(total);
        System.out.println(transactions);
        String[] details =transactions.split(",");
        for(int i = 0; i <details.length-1;i=i+2){
            System.out.println("Producto: " + Collections.getInstance().getProducts().searchByID(details[i]).getName());
            System.out.println("Cantidad: " + details[i+1]);
            System.out.println("Subtotal: "+(Collections.getInstance().getProducts().searchByID(details[i]).getPrice()*Integer.parseInt(details[i+1])));
        }

        /*Transaction.setCategory(Collections.getInstance().getCategories().get(idCategory-1));
        Transaction.setName(name);
        Transaction.setPrice(price);
        Transaction.setDescription(description);
        Transaction.setIdTransaction(Collections.getInstance().getTransactions().getLength()+1);
        Transaction.setImage(image);
        Transaction.setStock(stock);*/

        //Collections.getInstance().getTransactions().insert(Transaction);

        //return Collections.getInstance().getTransactions().searchByID(Transaction.getIdTransaction()+"");
        return null;
    }


    @CrossOrigin(origins = "http://localhost:4200")
    @DeleteMapping(Collections.route+"transactions/{id}")
    public boolean deleteTransaction(@PathVariable String id) {
        /*Transaction toDelete = new Transaction();
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
        }*/
        return false;
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @PutMapping(Collections.route+"transactions/{id}")
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
