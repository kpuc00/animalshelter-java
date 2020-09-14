package UnitTests;

import Animals.Dog;
import Animals.Gender;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class DogTest {
    private Dog dog;

    @BeforeEach
    public void TestInitialize()
    {
        this.dog = new Dog("Sgt. Woof", Gender.Male);
    }

    @Test
    public void TestConstructor()
    {
        assertEquals("Sgt. Woof", this.dog.getName());
        assertEquals(Gender.Male, this.dog.getGender());
        assertNull(this.dog.getReservedBy());
        assertEquals(LocalDate.now(), this.dog.getLastWalk());
        assertFalse(this.dog.NeedsWalk());
    }

    @Test
    public void TestReservation()
    {
        assertNull(this.dog.getReservedBy());
        assertTrue(this.dog.Reserve("John Doe"));
        assertNotNull(this.dog.getReservedBy());
        assertEquals("John Doe", this.dog.getReservedBy().getName());
        assertFalse(this.dog.Reserve("Jane Doe"));
    }
}