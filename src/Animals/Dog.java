package Animals;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

public class Dog extends Animal{
    private LocalDate lastWalk;

    public LocalDate GetLastWalk(){
        return this.lastWalk;
    }

    public boolean NeedsWalk(){
        Period period = Period.between(LocalDate.now(), this.GetLastWalk());
        int diff = period.getDays();
        return diff > 0;
    }

    public Dog(String name, Gender gender)
    {
        super(name, gender);
        this.lastWalk = LocalDate.now();
    }

    @Override
    public String toString()
    {
        return super.toString() + ", last walk: " + this.GetLastWalk().format(DateTimeFormatter.ofLocalizedDate(FormatStyle.LONG));
    }
}
