package login;

import admin.AdminView;
import user.UserView;

import java.util.Scanner;

public class LoginView {
    AdminView adminView=new AdminView();
    UserView userView=new UserView();
    static Scanner sc=new Scanner(System.in);


    public void startMenu() {
        System.out.println(" 1. Admin   \n 2. User \n 3. Exit");
        System.out.println("Enter your choice");
        int choice=sc.nextInt();
        sc.nextLine();
        switch (choice){
            case 1:
                adminView.init();
                break;
            case 2:
                userView.init();
                break;
            case 3:
                System.out.println("Thank for Using ");
                break;
            default:
                System.out.println("Invalid input");
                startMenu();
        }
    }
}
