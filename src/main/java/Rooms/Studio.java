package Rooms;

import Rooms.Room;

public class Studio extends Room {

    public Studio() {
    }

    public Studio(final int roomNumber)
    {
        super(roomNumber, "Studio", 2000);
    }

    public String toString() {

        return "Room number [ " + roomNumber + "] Room type [ " + roomType + " ] Price [ " + nightPrice + " Kr ] " ;
    }

    //overwrite describe method
    public void describe (){
        System.out.println( "Studio: A room with a couch that can be converted into a bed. May also have an additional bed ");
    }
}
