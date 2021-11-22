package Animals;

import Animals.Animal;

public class Turtle extends Animal {


    public Turtle(String name ) {

        super(name, "Turtle", "Seeweed", "Climbing");
    }
    public String toString() {
        return "Name [ "+ name +   " ] Favorite Food [ " + favoriteFood + " ] Favorite activity [" + favoriteActivity + "] ";
    }
}
