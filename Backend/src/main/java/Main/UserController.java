package Main;

import Collections.Collections;
import org.springframework.web.bind.annotation.*;
import Models.User;

import java.util.ArrayList;

@RestController
public class UserController {
    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping(Collections.route+"users")
    public ArrayList<User> Users(@RequestParam(value="filter", defaultValue="") String filter) {
        ArrayList<User> list;

        list = Collections.getInstance().getUsers();

        return list;
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping(Collections.route+"user/{id}")
    public User UserByID(@PathVariable String id) {
        User toReturn = new User();
        try{
            toReturn = Collections.getInstance().getUsers().get(Integer.parseInt(id)-1);
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
    @PostMapping(Collections.route+"users")
    public User addUser(@RequestParam(value="role") String role,
                              @RequestParam(value="username") String username,
                              @RequestParam(value="password") String password){
        User user = new User();
        user.setRole(role);
        user.setUsername(username);
        user.setPassword(password);
        user.setIdUser(Collections.getInstance().getUsers().size());

        for(User i:Collections.getInstance().getUsers()){
            if(i.getUsername().equals(username)){
                return new User();
            }
            else{
                Collections.getInstance().getUsers().add(user);
            }
        }
        return Collections.getInstance().getUsers().get(user.getIdUser());
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping(Collections.route+"login")
    public User login(@RequestParam(value="username") String username,
                        @RequestParam(value="password") String password){

        User loggedUser = new User();
        for(User user:Collections.getInstance().getUsers()){
            if(user.getUsername().equals(username) && user.getPassword().equals(password)){
                loggedUser = user;
            }
        }

        return loggedUser;
    }

}
