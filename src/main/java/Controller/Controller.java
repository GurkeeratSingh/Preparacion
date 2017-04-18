package Controller;

import Model.Etakemon;
import Model.Users;
import org.apache.log4j.Logger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Gurkeerat Singh on 17/04/2017.
 */
public class Controller implements IControlador {
    private static Controller instance;
    private HashMap<String, Users> usersHashMap;
    final static Logger logger = Logger.getLogger(Controller.class);


    private Controller(){//Privado para forzar Singleton

        usersHashMap=new HashMap<String,Users>();//nos interesa que solo haya 1 hashmap global
        logger.info("se crea hashmap usuarios");

    }
    public  static  Controller getInstance(){//Singleton
        if (instance==null) instance=new Controller();
        return instance;
    }


    public void addUser(Users u) {
        String nombre = u.getName();
        usersHashMap.put(nombre,u);//conseguimos el nombre y lo introduciomos como key y pasamos el user
        logger.info("se añade usuario: "+nombre);
    }

    public void addEtakemon(Users u, Etakemon p) {
        usersHashMap.get(u.getName()).addEtakemon(p);
        /*Users f = usersHashMap.get(u.getName());
        f.addEtakemon(p);*/
        /*u.addEtakemon(p);*/
        logger.info("se añade etakemon: "+ p.getName()+" al usuario: "+u.getName());
    }

    public void updateUser(String name, String newname) {

        Users u=usersHashMap.get(name);
        u.setName(newname);
        usersHashMap.remove(name);
        usersHashMap.put(newname,u);
        logger.info("nombre del usuario: "+name+" cambiado a: "+newname);
    }
    /*public void updateUser(Users f, String newname) {
        String name = f.getName();
        f.setName(newname);
        usersHashMap.remove(name);// hashmap, actualiza los datos? y la lista?
        usersHashMap.put(newname, f);
        logger.info("nombre del usuario: " + name + " cambiado a: " + newname);
    }*/

    public String infoUser(String nombre) {

        int i=usersHashMap.get(nombre).numEtakemon();
        String sol= "El usuarion "+nombre+" tiene "+i+" pokemon";
        logger.info(sol);
        return sol;

    }

    public List<Etakemon> returnEtakemon(Users u) {
        logger.info("Se devuelve la lista de pokemon del usuario: "+u.getName());
        return usersHashMap.get(u.getName()).returnEtakemon() ;//usersHashMap.get(u.getName()) devuelve un usuario(clase User)
    }
    public ArrayList<Users> listUsers(){
        ArrayList<Users> us=new ArrayList<Users>();
        int i=0;
        for (String key: usersHashMap.keySet()) {
            us.add(usersHashMap.get(key));
            i++;
        }
        logger.info("Se devuelven "+i+ " usuarios");
        return us;
    }
}
