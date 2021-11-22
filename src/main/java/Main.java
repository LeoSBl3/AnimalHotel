import Animals.Animal;
import Rooms.Room;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static Room rooms = new Room();

    public static void main (String[] args) throws IOException {


        //Run printMenu method to show the options for the user
        System.out.println("Welcome to our hotel we offer: " );
        rooms.describe();
        System.out.println("We have three types of rooms:");
        rooms.createRoom();//create rooms and run the describe method in each of the room classes
        Room.printMenu();
//        Room.deleteRoomFile("roomsList.txt");

    }

}
