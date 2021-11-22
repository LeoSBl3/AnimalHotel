package Rooms;

import Animals.Animal;
import Animals.Dinosaur;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RoomTest {


    @Test
    //method used in calculating the total cost of stay , number of nights * night price
    void multiply() {
        assertEquals(25,Room.multiply(5,5));

    }


    @Test
    void setGetNumberofNights() {

        Room testRoom = new Room();
        testRoom.setNumberOfNights(3);
        assertEquals(3, testRoom.numberOfNights);
    }

    @Test
    void setGetAnimalName() {

        Animal animalName = new Animal();
        animalName.setName("T-Rex");
        assertEquals("T-Rex", animalName.getName());
    }
    @Test
    void setGetRoomNumber() {

        Room testRoom = new Room();
        testRoom.setRoomNumber(900);
        assertEquals(900, testRoom.getRoomNumber());
    }
}