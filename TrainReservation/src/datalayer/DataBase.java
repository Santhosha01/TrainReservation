package datalayer;

import model.Credential;
import model.Train;
import model.User;

import java.util.ArrayList;
import java.util.List;

public class DataBase {

        private static DataBase dataBase;
        private List<Credential> credentials=new ArrayList<>();
        private List<User> users=new ArrayList<>();
        private List<Train> trains=new ArrayList<>();
        private DataBase() {

        }

        public static DataBase getInstance() {
            if (dataBase == null) {
                dataBase = new DataBase();
            }
            return dataBase;
        }

        public void insertCredentials(Credential credential) {
            credentials.add(credential);
        }

        public List<Credential> getCredentials() {
            return credentials;
        }

        public void storeUser(User user) {
            users.add(user);
        }
        public List<User> getUsers() {
            return users;
        }

        public void storeTrain(Train b) {
            trains.add(b);
        }
        public List<Train> gettrain() {
            return trains;
        }

}
