package View;

import Controller.Controller;
import Model.Etakemon;
import Model.Users;

/**
 * Created by Gurkeerat Singh on 18/04/2017.
 */
public class Main {
    public static void main(String[] args) throws Exception {

        Controller Controll = Controller.getInstance();
        Users u = new Users("Alberto");
        Etakemon p=new Etakemon ("eetac");
        Controll.addUser(u);
        Controll.addEtakemon(u,p);

    }
}
