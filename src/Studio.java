public class Studio extends Room {

    public Studio(String roomType, float roomSize, String roomView) {
        super(roomType, roomSize, roomView);
    }

    public void describe (){
        System.out.println("A room with a studio bed – a couch that can be converted into a bed. May also have an additional bed ");
    }
}
