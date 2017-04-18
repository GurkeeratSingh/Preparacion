package Model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Gurkeerat Singh on 17/04/2017.
 */
public class Users {
    private String name;
    ArrayList<Etakemon> etakemons =new ArrayList<Etakemon>();
    public Users(String name){

        this.name=name;
    }
    public void addEtakemon(Etakemon p){
        etakemons.add(p);
    }
    public List<Etakemon> returnEtakemon(){
        return this.etakemons;
    }
    public String getName(){return this.name;}
    public void setName(String name){this.name=name;}
    public int numEtakemon(){return etakemons.size();}
}
