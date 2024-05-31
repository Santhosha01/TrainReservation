package admin;

public class AdminModel {
    AdminView adminView;
    public AdminModel(AdminView adminView) {
    this.adminView=adminView;
    }

    public boolean isValid(String password) {
        if(password.equals("admin")) {
            return true;
        }
        return false;
    }

}
