package UnitTests;

import Animals.Reservor;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class ReservorTest {
    @Test
    public void TestConstructor()
    {
        LocalDate reservedAt = LocalDate.now();
        Reservor reservor = new Reservor("John Doe", reservedAt);
        assertEquals("John Doe", reservor.getName());
        assertEquals(reservedAt, reservor.getReservedAt());
    }
}