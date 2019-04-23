package Main;

import Collections.Collections;
import Models.Vertex;
import org.springframework.web.bind.annotation.*;
import Models.Place;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@RestController
public class PlaceController {
    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping(Collections.route+"places")
    public List<Vertex> places(@RequestParam(value="filter", defaultValue="") String filter) {
        ArrayList<Place> list;

        //list = Collections.getInstance().getPlaces().getListFiltered(filter);

        return Collections.getInstance().getNodes();
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping(Collections.route+"place/{id}")
    public Place placeByID(@PathVariable String id) {
        Place toReturn = new Place();
        try{
            //toReturn = Collections.getInstance().getPlaces().searchByID(id);
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
    @PostMapping(Collections.route+"shortestPath")
    public LinkedList<Vertex> shortestPath(@RequestParam(value="source") int source,
                          @RequestParam(value="destination") int destination){
        Collections.getInstance().getPlacesGraph().execute(Collections.getInstance().getNodes().get(source));
        LinkedList<Vertex> path = Collections.getInstance().getPlacesGraph().getPath(Collections.getInstance().getNodes().get(destination));

        if(path!=null){
            return path;
        }
        else{
            return new LinkedList<Vertex>();
        }
    }

    /*@CrossOrigin(origins = "http://localhost:4200")
    @PostMapping(Collections.route+"places")
    public Place addPlace(@RequestParam(value="stock") int stock){
        Place Place = new Place();

        //Collections.getInstance().getPlaces().insert(Place);

        //return Collections.getInstance().getPlaces().searchByID(Place.getIdPlace()+"");
       /* return null*/
    //}


    @CrossOrigin(origins = "http://localhost:4200")
    @DeleteMapping(Collections.route+"Place/{id}")
    public boolean deletePlace(@PathVariable String id) {
        /*Place toDelete = new Place();
        try{
            //toDelete = Collections.getInstance().getPlaces().searchByID(id);
        }catch (Exception e){
            toDelete = null;
            System.out.println(e.toString());
        }
        if(toDelete.getIdPlace()!=0){
            // Collections.getInstance().getPlaces().deleteKey(toDelete);
            return true;
        }else{
            return false;
        }*/
        return false;
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @PutMapping(Collections.route+"Place/{id}")
    public boolean editPlace(@PathVariable String id,
                                   @RequestParam(value="stock") int stock,
                                   @RequestParam(value="price") double price,
                                   @RequestParam(value="idCategory") int idCategory,
                                   @RequestParam(value="image") String image,
                                   @RequestParam(value="name") String name,
                                   @RequestParam(value="description") String description) {
        Place toEdit = new Place();

        try{
            //toEdit = Collections.getInstance().getPlaces().searchByID(id);
        }catch (Exception e){
            toEdit = null;
            System.out.println(e.toString());
        }
        /*if(toEdit.getIdPlace()!=0){
            /*toEdit.setCategory(Collections.getInstance().getCategories().get(idCategory-1));
            toEdit.setPrice(price);
            toEdit.setDescription(description);
            toEdit.setImage(image);
            toEdit.setStock(stock);*/
            /*if(toEdit.getName().equals(name)){
                Collections.getInstance().getPlaces().edit(toEdit);
            }else{
                Collections.getInstance().getPlaces().deleteKey(toEdit);
                toEdit.setName(name);
                Collections.getInstance().getPlaces().insert(toEdit);
            }*/
            /*return true;
        }else{
            return false;
        }*/
            return false;
    }

}
