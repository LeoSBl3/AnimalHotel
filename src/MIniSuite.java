public class MIniSuite extends Room {

    public MIniSuite(String roomType, float roomSize, String roomView) {
        super(roomType, roomSize, roomView);
    }

    public void describe (){
        System.out.println("A single room with a bed and sitting area. Sometimes the sleeping area is in a bedroom separate from the parlour or living room");
    }
}
