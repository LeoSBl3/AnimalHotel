public class Turtle extends Animal{

    public int turtleAge; //

    public Turtle(String name, float height, String favoriteFood, String favoriteActivity, int turtleType) {
        super(name, height, favoriteFood, favoriteActivity);
        this.turtleAge = turtleType;
    }
}
