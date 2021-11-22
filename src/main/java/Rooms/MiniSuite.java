package Rooms;

import Rooms.Room;

public class MiniSuite extends Room {

    public MiniSuite() {
    }
    public MiniSuite(final int roomNumber) {
        super(roomNumber, "Mini suite", 3000);
    }

    public String toString() {
        return "Room number [ " + roomNumber + "] Room type [ " + roomType + " ] Price [ " + nightPrice + " Kr ] " ;

    }

    public void describe (){
        System.out.println("Mini Suite : A single room with a bed and sitting area. Sometimes the sleeping area is in a bedroom separate from the parlour or living room");
    }
}
