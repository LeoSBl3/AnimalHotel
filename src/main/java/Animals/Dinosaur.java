package Animals;

public class Dinosaur extends Animal {


    public Dinosaur(String name) {

        super(name, "Dinasoaur", "Meat", "Screaming");
    }


    public String toString() {
        return "Name [ "+ name +   " ] Favorite Food [ " + favoriteFood + " ] Favorite activity [" + favoriteActivity + "] ";
    }
}
