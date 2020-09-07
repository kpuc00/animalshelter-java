import Animals.Animal;
import Animals.Cat;
import Animals.Dog;
import Animals.Gender;

import java.util.ArrayList;
import java.util.List;

public class Reservation {
    private List<Animal> Animals = new ArrayList<>();

    public List<Animal> getAnimals() {
        return Animals;
    }

    public void NewCat(String name, Gender gender, String badHabits)
    {
        this.Animals.add(new Cat(name, gender, badHabits));
    }

    public void NewDog(String name, Gender gender)
    {
        this.Animals.add(new Dog(name, gender));
    }
}
