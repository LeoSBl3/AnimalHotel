public class Animal {
    public  String name;
    public float height;
    public String favoriteFood;
    public String favoriteActivity;

    public Animal(String name, float height, String favoriteFood, String favoriteActivity) {
        this.name = name;
        this.height = height;
        this.favoriteFood = favoriteFood;
        this.favoriteActivity = favoriteActivity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getHeight() {
        return height;
    }

    public void setHeight(float height) {
        this.height = height;
    }

    public String getFavoriteFood() {
        return favoriteFood;
    }

    public void setFavoriteFood(String favoriteFood) {
        this.favoriteFood = favoriteFood;
    }

    public String getFavoriteActivity() {
        return favoriteActivity;
    }

    public void setFavoriteActivity(String favoriteActivity) {
        this.favoriteActivity = favoriteActivity;
    }
}
