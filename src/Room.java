public class Room {
    public  String roomType;
    public float roomSize;
    public String roomView;

    public Room(String roomType, float roomSize, String roomView) {
        this.roomType = roomType;
        this.roomSize = roomSize;
        this.roomView = roomView;
    }
    public void describe (){
        System.out.println("A comfort well organized room that makes you feel at home. Thick well-isolated walls. TV, Wifi, private pathroom ");
    }

    Studio smallStudio = new Studio("Small Studio", 100, "parktingArea");
}
