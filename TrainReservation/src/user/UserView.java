package user;

import admin.AdminView;
import datalayer.DataBase;
import login.LoginView;
import model.Credential;
import model.Train;
import model.User;

import java.util.List;
import java.util.Scanner;

public class UserView {
    static Scanner sc = new Scanner(System.in);
    UserModel userModel;
    AdminView adminView;

    public UserView() {
        userModel = new UserModel(this);
    }

    public void init() {
        System.out.println("\n----------------------User Page--------------------------");
        System.out.println("\n 1.Sign Up \n 2.Sign in \n 3.Exit");
        System.out.println("\nEnter your choice");
        int choice = sc.nextInt();
        sc.nextLine();
        switch (choice) {
            case 1:
                signUp();
                init();
                break;
            case 2:
                String username = signIn();
                if (username != null) {
                    startMenu(username);
                } else {
                    init();
                }
                break;
            case 3:
                System.out.println(
                        "\n------ Thanks you for Using  IRTCT----");
                new LoginView().startMenu();
                break;
            default:
                System.out.println("InValid Input");
                init();
        }
    }

    private void startMenu(String username) {
        System.out.println(" 1. Booking \n 2. Get PNR status \n 3. Booked Tickets \n 4. Cancel Ticket  \n 5. List train  6. Search Train \n 7. Exit");
        System.out.println("Enter your choice");
        int choice = sc.nextInt();
        sc.nextLine();
        switch (choice) {
            case 1:
                booking(username);
                startMenu(username);
                break;
            case 2:
                getPnrStatus();
                startMenu(username);
                break;
            case 3:
                viewBookedTickets();
                startMenu(username);
                break;
            case 4:
                cancelTicket();
                startMenu(username);
                break;
            case 5:
                viewTrainRoutes();
                startMenu(username);
                break;
            case 6:
                searchTrainInit(username);
                startMenu(username);
            case 7:
                System.out.println("Thank you for using IRTCT");
                break;
            default:
                System.out.println("Invalid input");
                init();
        }
    }

    private void searchTrainInit(String username) {
        System.out.println(" 1. Search By departure Location \n 2. Search by Arrival Location \n 3. Exit");
        System.out.println("Enter your choice");
        int choice = sc.nextInt();
        sc.nextLine();
        switch (choice) {
            case 1:
                searchBydeparture();
                searchTrainInit(username);
                break;
            case 2:
                searchByArrival();
                searchTrainInit(username);
                break;
            case 3:
                startMenu(username);
                break;
        }
    }

    private void searchBydeparture() {
        System.out.println("Enter your Starting location");
        String startLocation=sc.nextLine();
        List<Train> trains=DataBase.getInstance().gettrain();
        for(Train t:trains){
          if(t.getDeparturelocation().equals(startLocation)){
                System.out.println(t.toString());
            }
        }
    }
    private void searchByArrival(){
        System.out.println("Enter your destination location");
        String desLocation=sc.nextLine();
        List<Train> trains=DataBase.getInstance().gettrain();
        for(Train t:trains){
            if(t.getArrivallocation().equals(desLocation)){
                System.out.println(t.toString());
            }
        }
    }


    private void getPnrStatus() {
    }

    private void booking(String email) {

    }
    private void getTrainRoutes() {

    }
    private void cancelTicket() {

    }
    private void viewBookedTickets() {

    }
    private void viewTrainRoutes() {

    }

        private void signUp () {
            User user = new User();
            System.out.println("Enter your username");
            String username = sc.nextLine();
            user.setName(username);
            System.out.println("Enter your password");
            String password = sc.nextLine();
            user.setPassword(password);
            System.out.println("Enter your Phone Number");
            String phoneNumber = sc.nextLine();
            user.setPhoneNumber(phoneNumber);
            System.out.println("Enter your email");
            String email = sc.nextLine();
            user.setEmail(email);
            Credential credential = new Credential();
            credential.setEmail(email);
            credential.setPassword(password);
            userModel.createCredentials(credential);
            userModel.storeUser(user);
            System.out.println("--------------User Sign Up Successfully--------------");
        }

        public String signIn () {
            System.out.println("Enter your Email Id");
            String email = sc.nextLine();
            System.out.println("Enter your password");
            String password = sc.nextLine();
            if (userModel.isValidUser(email, password)) {
                System.out.println("-------------Login Successful----------------");
                return email;
            } else {
                System.out.println("Invalid User Name or Password");
            }
            return null;
        }
    }

