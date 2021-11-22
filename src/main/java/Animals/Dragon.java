package Animals;

import Animals.Animal;

public class Dragon extends Animal {



    public Dragon (String name) {

        super(name, "Dragon", "Dragon Fruit", "Smoking");
    }
    public String toString() {
        return "Name [ "+ name +   " ] Favorite Food [ " + favoriteFood + " ] Favorite activity [" + favoriteActivity + "] ";
    }
}
