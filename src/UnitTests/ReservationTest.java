package UnitTests;

import Animals.Gender;
import Shelter.Reservation;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ReservationTest {
    private Reservation reservation;

    @BeforeEach
    public void TestInitialize()
    {
        this.reservation = new Reservation();
    }

    @Test
    public void TestNewCat()
    {
        assertEquals(0, this.reservation.getAnimals().stream().count());
        this.reservation.NewCat("Ms. Meow", Gender.Female, "Scratches couch");
        assertEquals(1, this.reservation.getAnimals().stream().count());
    }

    @Test
    public void TestNewDog()
    {
        assertEquals(0, this.reservation.getAnimals().stream().count());
        this.reservation.NewDog("Sgt. Woof", Gender.Male);
        assertEquals(1, this.reservation.getAnimals().stream().count());
    }
}