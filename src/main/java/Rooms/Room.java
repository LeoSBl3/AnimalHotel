package Rooms;
import Animals.Animal;
import Animals.Dinosaur;
import Animals.Dragon;
import Animals.Turtle;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Room implements Serializable {

    public int roomNumber;
    public  String roomType;
    public float nightPrice;
    public int numberOfNights;
    public Animal animal;

    //Overloading of different constructors
    public Room() {
    }

    public Room(int roomNumber, String roomType, float nightPrice) {
        this.roomNumber = roomNumber;
        this.roomType = roomType;
        this.nightPrice = nightPrice;
    }


    //General room description
    public void describe (){
        System.out.println("We offer comfort well-organized rooms that meets different preferences and make our guests feel at home. well-isolated walls. TV, Wifi, private bathroom.");
    }

    public static void setNewFavoriteActivity(String newFavoriteActivity) {
        Room.newFavoriteActivity = newFavoriteActivity;
    }

    public static String getNewFavoriteActivity() {
        return newFavoriteActivity;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    public void setNumberOfNights(int numberOfNights) {
        this.numberOfNights = numberOfNights;
    }

    public void setAnimal(Animal animal) {
        this.animal = animal;
    }

    //Check if the room has animal
    public boolean hasAnimal() {

        return animal != null; // Returns true if the room does  have animal
    }

    // string to print when need to print object initiated from this class
    public String toString() {
        return "Room Number [ " + roomNumber + " ] Number of nigths [ " + enteredNumberOfNights +  " ] " + animal ;
    }


    //Code and methods

    //Array list of rooms , but also can include the checked in animal
    public static ArrayList<Room> roomsList = new ArrayList<Room>();

    static Scanner myScanner = new Scanner(System.in);


    //Static variables that can be used across the different methods
    static String animalName;
    static String newFavoriteActivity;
    static int searchForRoom;
    static int enteredNumberOfNights = 0;


    public void createRoom() throws FileNotFoundException {
        //create studios
        Studio studio1 = new Studio(300);
        roomsList.add(studio1);
        Studio studio2 = new Studio(301);
        roomsList.add(studio2);

        //Create mini suites
        MiniSuite miniSuite1 = new MiniSuite(400);
        roomsList.add(miniSuite1);
        MiniSuite miniSuite2 = new MiniSuite(401);
        roomsList.add(miniSuite2);

        //Create master suites
        MasterSuite masterSuite1= new MasterSuite(500);
        roomsList.add(masterSuite1);
        MasterSuite masterSuite2 = new MasterSuite(501);
        roomsList.add(masterSuite2);

        //Rooms' descriptions using one of the objects to get the description from the room
        studio1.describe();
        miniSuite1.describe();
        masterSuite1.describe();
        readRoomFile("roomsList.txt");
        deleteRoomFile("roomsList.txt");

    }


    public static void printMenu() throws IOException {


        boolean runProgram = true;
        while (runProgram){
            System.out.println("\n" + "What would you like to do?" );
            System.out.println(" 1. New Booking");
            System.out.println(" 2. Search for animal and change favorite activity");
            System.out.println(" 3. Show list of booked rooms and checkedIn animals");  //need to provide the booking number and name
            System.out.println(" 4. Show details af a booking");
            System.out.println(" 5. Check-out an animal");
            System.out.println(" 6. Exit the hotel and save any current bookings to file");
            int menu = getUserInt("> ");


            switch (menu) {
                case 1 -> { availableRooms();  newBooking();} // check available rooms and start new booking
                case 2 -> changeFavoriteActivity();
                case 3 -> showListOfBookings();
                case 4 -> showDetailsOfABooking();
                case 5 -> CheckOutAnAnimal();
                case 6 -> { saveToFile(); runProgram = false;}
                default -> System.out.println("wrong choice!" +"\n" + "> ");
            }
        }


    }


    public static void availableRooms(){

        //check for available rooms
        for ( int i = 0; i < roomsList.size(); i++) {
            boolean roomListHasAnimal = roomsList.get(i).hasAnimal();
            if (!roomListHasAnimal) {
                System.out.println(roomsList.get(i));
            }
        }

    }
    public static void newBooking(){

        boolean runNewBooking = true;

        while (runNewBooking){

            //get the room number, check if the room exist , if available
            int selectedroomNumber = getUserInt("Enter the room number to select: ");
            int i ;
            for ( i = 0; i < roomsList.size(); i++) {
                boolean roomListHasAnimal = roomsList.get(i).hasAnimal();
                if(selectedroomNumber == roomsList.get(i).roomNumber) {
                    if (roomListHasAnimal) {
                        System.out.println("The room is not available");
                        newBooking();
                    } else {
                        System.out.println("The room is available, please fill the below info to Check-In >>");
                    }
                    break;
                }
            }
            //if the loop ended without finding the room, the room in not on the list, then go back to the start of newBooking
            if(i == roomsList.size()) {
                System.out.println("The room number is not on the list of available room, please try again");
                newBooking();
            }

            //get animal name and number of nights
            animalName = getUserString("Animal's name: ");
            enteredNumberOfNights = getUserInt("Welcome " + animalName + "! " + "Hom many night do you want to stay?");
            int myInteger = getUserInt("Type of animals ? 1- Dinasour, 2- Dragon , 3- Turtle, 4- Exit new booking");

            switch (myInteger){
                case 1 -> {

                    Animal newAnimal = new Dinosaur(animalName );
                    //Get the room and add the number of nights and the Animal
                    for ( i = 0; i < roomsList.size(); i++) {
                        if (selectedroomNumber == roomsList.get(i).roomNumber ){
                            int confirmCheckin = getUserInt("1. Confirm checkIn 2. Exit new booking ");
                            if(confirmCheckin == 2 ){
                                break;
                            }
                            roomsList.get(i).setNumberOfNights(enteredNumberOfNights);
                            roomsList.get(i).setAnimal(newAnimal);
                            System.out.println("The booking details:");
                            System.out.println("Room number: " + roomsList.get(i).roomNumber
                                    + " | No. of nights: " + roomsList.get(i).numberOfNights
                                    + " | " +  roomsList.get(i).animal);
                            break;
                        }
                    }

                    runNewBooking = false;
                }
                case 2 -> {
                    Animal newAnimal = new Dragon(animalName );
                    //Get the room and add the number of nights and the Animal
                    for ( i = 0; i < roomsList.size(); i++) {
                        if (selectedroomNumber == roomsList.get(i).roomNumber ){
                            int confirmCheckin = getUserInt("1. Confirm checkIn 2. Exist new booking ");
                            if(confirmCheckin == 2 ){
                                break;
                            }
                            roomsList.get(i).setNumberOfNights(enteredNumberOfNights);
                            roomsList.get(i).setAnimal(newAnimal);
                            System.out.println("The booking details:");
                            System.out.println("Room number: " + roomsList.get(i).roomNumber
                                    + " | No. of nights: " + roomsList.get(i).numberOfNights
                                    + " | " +  roomsList.get(i).animal);
                            break;
                        }
                    }
                    runNewBooking = false;
                }
                case 3 -> {
                    Animal newAnimal = new Turtle(animalName );
                    //Get the room and add the number of nights and the Animal
                    for ( i = 0; i < roomsList.size(); i++) {
                        if (selectedroomNumber == roomsList.get(i).roomNumber ){
                            int confirmCheckin = getUserInt("1. Confirm checkIn 2. Exist new booking ");
                            if(confirmCheckin == 2 ){
                                break;
                            }
                            roomsList.get(i).setNumberOfNights(enteredNumberOfNights);
                            roomsList.get(i).setAnimal(newAnimal);
                            System.out.println("The booking details:");
                            System.out.println("Room number: " + roomsList.get(i).roomNumber
                                    + " | No. of nights: " + roomsList.get(i).numberOfNights
                                    + " | " +  roomsList.get(i).animal);
                            break;
                        }
                    }
                    runNewBooking = false;
                }
                case 4 -> runNewBooking = false;
                default -> {System.out.println("Wrong entry of animal type, please start the booking again!");
                    newBooking();}
            }

        }


    }


    //Get the animal name , get the booked rooms, search for the name in booked room and change the favorite activity
    private static String changeFavoriteActivity() throws IOException {
        animalName = getUserString("Animal's name to change favorite activity: ");
        int i ;
        for ( i = 0; i < roomsList.size(); i++) {

            boolean roomListHasAnimal = roomsList.get(i).hasAnimal();
            if (roomListHasAnimal) {
                if (animalName.equals(roomsList.get(i).animal.name)){
                    newFavoriteActivity = getUserString("New favorite activity: ");

                    roomsList.get(i).animal.setFavoriteActivity(newFavoriteActivity);
                    System.out.println("Favorite activity of " + animalName + " is now updated!");
                    printMenu();
                    break;
                }
            }

        }
        if(i == roomsList.size()){
            System.out.println("Animal not found, please try again!");
            changeFavoriteActivity();
        }
        return newFavoriteActivity;
    }

    //Show list of booking in rooms list
    private static void showListOfBookings() {

        System.out.println("List of booked rooms and guests:");
        int i ;
        for ( i = 0; i < roomsList.size(); i++) {

            boolean roomListHasAnimal = roomsList.get(i).hasAnimal();
            if (roomListHasAnimal) {
                System.out.println("Animal Name : " + roomsList.get(i).animal.getName()
                        + " | Room number: " + roomsList.get(i).roomNumber + "|");
            }

        }

    }

    //Get room number to show details of a booking
    private static void showDetailsOfABooking() throws IOException {
        searchForRoom = getUserInt("Provide the room number to see the booking details: ");
        Room studio = new Studio();
        Room miniSuite = new MiniSuite();
        Room masterSuite = new MasterSuite();

        int i ;
        for ( i = 0; i < roomsList.size(); i++) {

            boolean roomListHasAnimal = roomsList.get(i).hasAnimal();
            if (roomListHasAnimal) {
                if (searchForRoom == roomsList.get(i).roomNumber){
                    System.out.println(
                            "Room number: " + roomsList.get(i).roomNumber
                                    + " | Animal Name : " + roomsList.get(i).animal.getName()
                                    + " | Animal favorite food : " + roomsList.get(i).animal.getFavoriteFood()
                                    + " | Animal favorite activity : " + roomsList.get(i).animal.getFavoriteActivity()

                    );
                    switch (searchForRoom){
                        case 300 -> studio.describe();
                        case 301 -> studio.describe();
                        case 400 -> miniSuite.describe();
                        case 401 -> miniSuite.describe();
                        case 500 -> masterSuite.describe();
                        case 501 -> masterSuite.describe();

                    }

                    printMenu();
                    break;
                }
            }

        }
        if(i == roomsList.size()){
            System.out.println("Booking not found, please try again!");
            showDetailsOfABooking();
        }
    }

    //Get animal name to check it out and show the total invoice
    private static void CheckOutAnAnimal() throws IOException {
        animalName = getUserString("Animal's name to check-out: ");
        int i ;
        for ( i = 0; i < roomsList.size(); i++) {

            boolean roomListHasAnimal = roomsList.get(i).hasAnimal();
            if (roomListHasAnimal) {
                if (animalName.equals(roomsList.get(i).animal.name)){
                    double oneNightPrice= roomsList.get(i).nightPrice;
                    int numberOfNightsStayed = roomsList.get(i).numberOfNights;
                    double totalInvoice = multiply(oneNightPrice, numberOfNightsStayed);
                    //remove the animal from the room
                    roomsList.get(i).setAnimal(null);
                    System.out.println("Check out completed!. Your Total Invoice is \n "
                            + "Night Price ( " + oneNightPrice + " ) * No. of nights stayed ( " + numberOfNightsStayed
                    + " ) = Total Invoice ( " + totalInvoice + " Kr )");
                    break;
                }
            }

        }
        if(i == roomsList.size()){
            System.out.println("Animal not found, please try again!");
            CheckOutAnAnimal();
        }
    }
    public static double multiply (double x , int y){
        double result = x * y;
        return result;
    }

    public static void saveToFile() throws IOException {
//        System.out.println("><<<<<<<save room file");
        //Turn the roomList into text to be writted to the file
        String outputText = null;
        for (int i = 0 ; i < roomsList.size();i++){
            boolean roomListHasAnimal = roomsList.get(i).hasAnimal();
            if (roomListHasAnimal) {
                outputText = roomsList.get(i).roomNumber
                        + "|" + roomsList.get(i).roomType
                        + "|" + roomsList.get(i).nightPrice
                        + "|"+ roomsList.get(i).numberOfNights
                        + "|"+ roomsList.get(i).animal.getName()
                        + "|"+ roomsList.get(i).animal.getAnimalType()
                        + "|"+ roomsList.get(i).animal.getFavoriteFood()
                        + "|"+ roomsList.get(i).animal.getFavoriteActivity();
                //create a file
                File file1 = new File ("roomsList.txt");

                //create a file writer class
                FileWriter fileWriter = new FileWriter(file1, true);
                //create a print writer class
                PrintWriter printWriter = new PrintWriter(fileWriter);
                printWriter.println(outputText);

                printWriter.close();

            }
        }

        if(outputText != null){
            //create a file
            File file1 = new File ("roomsList.txt");

            //create a file writer class
            FileWriter fileWriter = new FileWriter(file1, true);
            //create a print writer class
            PrintWriter printWriter = new PrintWriter(fileWriter);
            printWriter.println(outputText);

            printWriter.close();

        }


    }

    public static void readRoomFile (String fileName) throws FileNotFoundException {
//        System.out.println("><<<<<<<Read room file");

        File file = new File(fileName);


        if (file.exists()){
            Scanner myScanner = new Scanner(file);
            while (myScanner.hasNextLine()){
                String line = myScanner.nextLine();

                String [] items = line.split("\\|");

                //Put all the item into a Animal object and added it to the existed rooms to make them unavailable
                int roomNumber = Integer.parseInt(items[0]);//used to find the room
                //No need to get the roomType or room price , they already exist
                int numberOfNights = Integer.parseInt(items[3]);// need to update the number of night in the existing room
                String animalName = items[4];
                String animalType = items[5];
                String animalFood = items[6];
                String animalActivity = items[7];

                //create the object including the checked animal details
                Animal checkedInAnimal = new Animal(animalName, animalType, animalFood, animalActivity);
                //Get the booked room from the roomslist and add the number of nights and the Animal object to make it unavailable
                for ( int i = 0; i < roomsList.size(); i++) {
                    if (roomNumber == roomsList.get(i).roomNumber ){

                        roomsList.get(i).setNumberOfNights(numberOfNights);
                        roomsList.get(i).setAnimal(checkedInAnimal);
                        break;
                    }
                }

            }
            myScanner.close();
        }
    }
    public static void deleteRoomFile (String fileName) throws FileNotFoundException {

//        System.out.println("><<<<<<<Delete room file " + fileName);
        File file = new File(fileName);
        if(file.exists()){
            if (file.delete()){
                System.out.println("Booked room list is uploaded and the file successfully deleted");
            } else {
                System.out.println("Problem deleting file");
            }
        }



    }

    private static int getUserInt(String question) {
        System.out.println(question);
        int myInteger;
        while (true) {
            try {
                myInteger = Integer.parseInt(myScanner.nextLine());
                break;
            } catch (Exception e) {
                System.out.println("Felaktig indata, try again!" +"\n" + "> ");
            }
        }
        return myInteger;

    }
    private static String getUserString(String question) {

        System.out.println(question);

        Scanner myScanner = new Scanner(System.in);
        String myString;
        myString = myScanner.nextLine();

        return myString;
    }
}
