package Animals;

public class Animal {
    public String name;
    public String animalType;
    public String favoriteFood;
    public String favoriteActivity;


    //Animal constructor

    public Animal() {
    }

    public Animal(String name, String animalType, String favoriteFood, String favoriteActivity) {
        this.name = name;
        this.animalType = animalType;
        this.favoriteFood = favoriteFood;
        this.favoriteActivity = favoriteActivity;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String getFavoriteFood() {
        return favoriteFood;
    }

    public String getAnimalType() { return animalType; }

    public String getFavoriteActivity() {
        return favoriteActivity;
    }

    public void setFavoriteActivity(String favoriteActivity) {
        this.favoriteActivity = favoriteActivity;
    }

    public String toString() {
        return "Name: " + name + " | Animal Type: "+ animalType + " | Favoriten Food : " + favoriteFood + " | Favorite activity: " + favoriteActivity + " |";
    }

}