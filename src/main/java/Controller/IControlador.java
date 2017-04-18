package Controller;

import Model.Etakemon;
import Model.Users;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Gurkeerat Singh on 17/04/2017.
 */
public interface IControlador {
    void addUser(Users u);
    void addEtakemon(Users u, Etakemon p);
    void updateUser(String name,String newName);
   // void updateUser(Users u,String newName);
    String infoUser(String nombre);
    List<Etakemon> returnEtakemon(Users u);
    ArrayList<Users> listUsers();
}
