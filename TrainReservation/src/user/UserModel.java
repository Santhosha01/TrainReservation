package user;

import model.Credential;
import model.User;
import datalayer.DataBase;
import java.util.List;

public class UserModel {
    private UserView userView;
    public UserModel(UserView userView) {
        this.userView = userView;
    }
    public void createCredentials(Credential credentials) {
        DataBase.getInstance().insertCredentials(credentials);
    }
    public void storeUser(User user){
        DataBase.getInstance().storeUser(user);
    }
    public boolean isValidUser(String email, String password) {
        List<Credential> credentials =DataBase.getInstance().getCredentials();
        for (Credential c:credentials){
            if((c.getEmail()).equals(email)){
                if(c.getPassword().equals(password)){
                    return true;
                }

            }
        }
        return false;
    }
}
