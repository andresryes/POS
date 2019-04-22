package Main;

import Collections.Collections;
import org.springframework.web.bind.annotation.*;
import Models.Category;

import java.util.ArrayList;

@RestController
public class CategoryContoller {
    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping(Collections.route+"categories")
    public ArrayList<Category> Categorys(@RequestParam(value="filter", defaultValue="") String filter) {
        ArrayList<Category> list;

        list = Collections.getInstance().getCategories();

        return list;
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping(Collections.route+"category/{id}")
    public Category categoryByID(@PathVariable String id) {
        Category toReturn = new Category();
        try{
            toReturn = Collections.getInstance().getCategories().get(Integer.parseInt(id)-1);
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
    @PostMapping(Collections.route+"categories")
    public Category addCategory(@RequestParam(value="name") String name){
        Category category = new Category();
        category.setName(name);
        category.setIdCategory(Collections.getInstance().getCategories().size()+1);

        Collections.getInstance().getCategories().add(category);

        return Collections.getInstance().getCategories().get(category.getIdCategory()-1);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @DeleteMapping(Collections.route+"category/{id}")
    public boolean deleteCategory(@PathVariable String id) {
        Category toReturn = new Category();
        try{
            toReturn = Collections.getInstance().getCategories().get(Integer.parseInt(id)-1);
        }catch (Exception e){
            System.out.println(e.toString());
        }

        if(toReturn.getIdCategory() != 0){
            Collections.getInstance().getCategories().remove(toReturn);
            return  true;
        }else{
            return false;
        }
    }

}
