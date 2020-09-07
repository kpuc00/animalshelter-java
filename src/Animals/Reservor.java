package Animals;

import java.time.LocalDate;

public class Reservor {
    private String name;
    private LocalDate reservedAt;

    public String getName(){
        return this.name;
    }

    public LocalDate getReservedAt(){
        return this.reservedAt;
    }

    public Reservor(String name, LocalDate reservedAt)
    {
        this.name = name;
        this.reservedAt = reservedAt;
    }
}
