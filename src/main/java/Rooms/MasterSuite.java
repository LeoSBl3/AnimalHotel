package Rooms;

public class MasterSuite extends Room {

    public MasterSuite() {
    }
    public MasterSuite(final int roomNumber) {
        super(roomNumber, "Master Suite", 5000);

    }

    public String toString() {
        return "Room number [ " + roomNumber + "] Room type [ " +roomType + " ] Price [ " + nightPrice + " Kr ]" ;
    }

    public void describe (){
        System.out.println("Master suite: A parlour or living room connected to one or more bedrooms." +"\n");
    }
}

