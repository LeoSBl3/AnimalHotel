public class MasterSuite extends Room{

    public MasterSuite(String roomType, float roomSize, String roomView) {
        super(roomType, roomSize, roomView);
    }

    public void describe (){
        System.out.println("A parlour or living room connected to one or more bedrooms.");
    }
}

