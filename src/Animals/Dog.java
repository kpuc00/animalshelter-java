package Animals;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

public class Dog extends Animal{
    private LocalDate lastWalk;

    public LocalDate getLastWalk(){
        return this.lastWalk;
    }

    public boolean NeedsWalk(){
        Period period = Period.between(LocalDate.now(), this.getLastWalk());
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
        return super.toString() + ", last walk: " + this.getLastWalk().format(DateTimeFormatter.ofLocalizedDate(FormatStyle.LONG));
    }
}
