public class Dragon extends Animal{

    public String dragonOrigin; //China , Europe, Australia , America
    public Dragon(String name, float height, String favoriteFood, String favoriteActivity, String dragonOrigin) {
        super(name, height, favoriteFood, favoriteActivity);
        this.dragonOrigin = dragonOrigin;
    }
}
