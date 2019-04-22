package Main;

import Collections.Collections;
import org.springframework.web.bind.annotation.*;
import Models.Customer;
import java.util.ArrayList;

@RestController
public class CustomerController {

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping(Collections.route+"customers")
    public ArrayList<Customer> customers(@RequestParam(value="filter", defaultValue="") String filter) {
        ArrayList<Customer> list;

        Collections.getInstance().getCustomers().cleanList();

        list = Collections.getInstance().getCustomers().getListFiltered(filter);

        return list;
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping(Collections.route+"customer/{id}")
    public Customer customerByID(@PathVariable String id) {
        Customer toReturn = new Customer();
        try{
            toReturn = Collections.getInstance().getCustomers().searchByID(id);
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
    @PostMapping(Collections.route+"customers")
    public Customer addCustomer(@RequestParam(value="name") String name,
                              @RequestParam(value="address") String address,
                              @RequestParam(value="nit") String nit){
        Customer customer = new Customer();
        customer.setName(name);
        customer.setIdCustomer(Collections.getInstance().getCustomers().getLength()+1);
        customer.setAddress(address);
        customer.setNit(nit);

        Collections.getInstance().getCustomers().insert(customer);

        return Collections.getInstance().getCustomers().searchByID(customer.getIdCustomer()+"");

    }


    @CrossOrigin(origins = "http://localhost:4200")
    @DeleteMapping(Collections.route+"customer/{id}")
    public boolean deleteCustomer(@PathVariable String id) {
        Customer toDelete = new Customer();
        try{
            toDelete = Collections.getInstance().getCustomers().searchByID(id);
        }catch (Exception e){
            toDelete = null;
            System.out.println(e.toString());
        }
        if(toDelete.getIdCustomer()!=0){
            Collections.getInstance().getCustomers().deleteKey(toDelete);
            return true;
        }else{
            return false;
        }
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @PutMapping(Collections.route+"customer/{id}")
    public boolean editCustomer(@PathVariable String id,
                                @RequestParam(value="name") String name,
                                @RequestParam(value="address") String address,
                                @RequestParam(value="nit") String nit) {
        Customer toEdit = new Customer();

        try{
            toEdit = Collections.getInstance().getCustomers().searchByID(id);
        }catch (Exception e){
            toEdit = null;
            System.out.println(e.toString());
        }
        if(toEdit.getIdCustomer()!=0){
            toEdit.setName(name);
            toEdit.setAddress(address);

            if(toEdit.getNit().equals(nit)){
                Collections.getInstance().getCustomers().edit(toEdit);
            }else{
                Collections.getInstance().getCustomers().deleteKey(toEdit);
                toEdit.setNit(nit);
                Collections.getInstance().getCustomers().insert(toEdit);
            }
            return true;
        }else{
            return false;
        }
    }
}
