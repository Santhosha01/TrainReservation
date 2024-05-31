package admin;

import datalayer.DataBase;
import login.LoginView;
import model.Train;

import java.util.Scanner;

public class AdminView {
    static Scanner sc=new Scanner(System.in);
    AdminModel adminModel;
    public AdminView() {
        adminModel = new AdminModel(this);
    }



    public void init() {
       System.out.println("Enter the password");
       String password=sc.nextLine();
       if(adminModel.isValid(password)){
          startMenu();
       }
       else{
           System.out.println("Invalid Password");
           new LoginView().startMenu();
       }
    }

    private void startMenu() {
        System.out.println("Welcome to Admin Page\n");
        System.out.println(" 1.Add Train \n 2.Search passenger \n 3.change Ticket status \n 4.Add train routes \n 5.Exit");
        int choice=sc.nextInt();
        sc.nextLine();
        switch(choice) {
            case 1:
               addTrain();
               startMenu();
               break;
            case 2:
                break;
               case 5:
                   new LoginView().startMenu();
                   break;
            default:
                System.out.println("invalid input");
                startMenu();
        }
    }

    private void addTrain() {
        System.out.println("Enter train Id");
        int trainId=sc.nextInt();
        sc.nextLine();
        System.out.println("Enter train Name");
        String trainName=sc.nextLine();
        System.out.println("Enter the departure Location");
        String departureLocation=sc.nextLine();
        System.out.println("Enter the arrival Location");
        String arrivalLocation=sc.nextLine();
        System.out.println("Enter the departure time");
        String departureTime=sc.nextLine();
        System.out.println("Enter the arrival time");
        String arrivalTime=sc.nextLine();
        System.out.println("Enter Number of seats in the train");
        int seats=sc.nextInt();
        sc.nextLine();
        System.out.println("Enter the fare of the train");
        int fareOfTrain=sc.nextInt();
        sc.nextLine();
        Train train=new Train(seats,trainId, trainName, departureLocation,arrivalLocation,departureTime,arrivalTime,fareOfTrain);
        DataBase.getInstance().storeTrain(train);
        System.out.println("Train has been Added Successfully");
        System.out.println(train);
    }

}
