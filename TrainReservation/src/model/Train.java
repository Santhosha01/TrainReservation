package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import model.Seat;

public class Train {
    private int id;
    private String name;
    private String departurelocation;
    private String arrivallocation;
    private String departuretime;
    private String arrivaltime;
    private List<String> routes =new ArrayList<>();
    private int numberofseats;
    private int fare;
    private List<Seat> seats=new ArrayList<>();
  static Scanner sc=new Scanner(System.in);
    public Train(int numberofseats, int id, String name, String departurelocation, String arrivallocation, String departuretime, String arrivaltime, int fare) {
        this.numberofseats = numberofseats;
        this.id = id;
        this.name = name;
        this.departurelocation = departurelocation;
        this.arrivallocation = arrivallocation;
        this.departuretime = departuretime;
        this.arrivaltime = arrivaltime;
        this.fare = fare;
        setSeats(numberofseats);
        setRoutes();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDeparturelocation() {
        return departurelocation;
    }

    public void setDeparturelocation(String departurelocation) {
        this.departurelocation = departurelocation;
    }

    public String getArrivallocation() {
        return arrivallocation;
    }

    public void setArrivallocation(String arrivallocation) {
        this.arrivallocation = arrivallocation;
    }

    public String getDeparturetime() {
        return departuretime;
    }

    public void setDeparturetime(String departuretime) {
        this.departuretime = departuretime;
    }

    public String getArrivaltime() {
        return arrivaltime;
    }

    public void setArrivaltime(String arrivaltime) {
        this.arrivaltime = arrivaltime;
    }

    public void setRoutes(){
        boolean flag=false;
        do {
            System.out.println("Enter train route");
            String route=sc.nextLine();
            routes.add(route);
            System.out.println("Do you want to add another? (y/n)");
            String chance=sc.nextLine();
            if(chance.equals("y")){
                flag=true;
            }
            else{
                flag=false;
            }
        }while(flag);
    }

    public void setSeats(int numberofseats){
        for(int i=1;i<=numberofseats;i++) {
            Seat s = new Seat(i, true);
            seats.add(s);
        }
    }

    @Override
    public String toString() {
        return "Train{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", departurelocation='" + departurelocation + '\'' +
                ", arrivallocation='" + arrivallocation + '\'' +
                ", departuretime='" + departuretime + '\'' +
                ", arrivaltime='" + arrivaltime + '\'' +
                ", routes=" + routes +
                ", numberofseats=" + numberofseats +
                ", fare=" + fare +
                ", seats=" + seats +
                '}';
    }
}
