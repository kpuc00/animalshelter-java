package Animals;

import java.time.LocalDate;

public abstract class Animal {
    private String name;
    private Gender gender;
    private Reservor reservedBy;

    public String getName(){
        return this.name;
    }

    public Gender getGender(){
        return this.gender;
    }

    public Reservor getReservedBy(){
        return this.reservedBy;
    }

    public Animal(String name, Gender gender)
    {
        this.name = name;
        this.gender = gender;
    }

    public boolean Reserve(String reservedBy)
    {
        if (this.getReservedBy() == null)
        {
            this.reservedBy = new Reservor(reservedBy, LocalDate.now());
            return true;
        }
        return false;
    }

    @Override
    public String toString()
    {
        String reserved = "Not reserved";
        if (this.getReservedBy() != null)
        {
            reserved = "Reserved by: " + this.getReservedBy().getName();
        }
        return "Name: " + this.getName() + ", Gender: " + this.getGender() + ", " + reserved;
    }
}
