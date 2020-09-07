import Animals.Animal;
import Animals.Gender;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class MainForm
{
    private JComboBox cbSpecies;
    private JRadioButton rbMale;
    private JRadioButton rbFemale;
    private JTextField tbxBadHabits;
    private JButton btnAddAnimal;
    private JList lbxAnimals;
    private JTextField tbxReserveName;
    private JButton btnReserve;
    private JPanel panel1;
    private JTextField tbxName;

    public MainForm()
    {
        cbSpecies.addItem("Cat");
        cbSpecies.addItem("Dog");

        btnAddAnimal.addActionListener(actionEvent -> addAnimal());
        btnReserve.addActionListener(actionEvent -> reserveAnimal());
        lbxAnimals.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent listSelectionEvent) {
                btnReserve.setEnabled(lbxAnimals.getSelectedValue() != null);
            }
        });
    }

    private Reservation reservations = new Reservation();

    public static void main(String[] args)
    {
        JFrame frame = new JFrame("Animal Shelter");
        frame.setContentPane(new MainForm().panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    private void refreshControls()
    {
        lbxAnimals.removeAll();
        DefaultListModel lbAnimals = new DefaultListModel();
        lbxAnimals.setModel(lbAnimals);
        for ( Animal animal : reservations.getAnimals())
        {
            lbAnimals.addElement(animal);
        }
    }

    private void addAnimal()
    {
        Gender gender = rbMale.isSelected() ? Gender.Male : Gender.Female;

        if (this.cbSpecies.getSelectedItem().toString() == "Cat")
        {
            this.reservations.NewCat(tbxName.getText(), gender, tbxBadHabits.getText());
        }
        else if (this.cbSpecies.getSelectedItem().toString() == "Dog")
        {
            this.reservations.NewDog(tbxName.getText(), gender);
        }
        this.refreshControls();
    }

    private void reserveAnimal()
    {
        Animal animal = (Animal) lbxAnimals.getSelectedValue();
        if (animal != null)
        {
            animal.Reserve(tbxReserveName.getText());
            this.refreshControls();
        }
    }
}
