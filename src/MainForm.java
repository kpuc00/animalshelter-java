import Animals.Animal;
import Animals.Gender;
import Shelter.Reservation;

import javax.swing.*;
import java.awt.*;

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
    private JPanel panel;
    private JTextField tbxName;
    private Dialog dialog;

    public MainForm()
    {
        cbSpecies.addItem("Cat");
        cbSpecies.addItem("Dog");

        btnAddAnimal.addActionListener(actionEvent -> addAnimal());
        btnReserve.addActionListener(actionEvent -> reserveAnimal());
        cbSpecies.addActionListener(actionEvent -> toggleBadHabits());
        lbxAnimals.addListSelectionListener(listSelectionEvent -> toggleReserve());
    }

    private Reservation reservations = new Reservation();

    public static void main(String[] args)
    {
        JFrame frame = new JFrame("Animal Shelter");
        frame.setContentPane(new MainForm().panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
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

    private void toggleBadHabits()
    {
        if (this.cbSpecies.getSelectedItem().toString() == "Dog")
            tbxBadHabits.setEnabled(false);
        else
            tbxBadHabits.setEnabled(true);
    }

    private void toggleReserve()
    {
        tbxReserveName.setEnabled(lbxAnimals.getSelectedValue() != null);
        btnReserve.setEnabled(lbxAnimals.getSelectedValue() != null);
    }

    private void addAnimal()
    {
        Gender gender = rbMale.isSelected() ? Gender.Male : Gender.Female;

        if (tbxName.getText().isEmpty())
            JOptionPane.showMessageDialog(panel, "Please enter your name!");

        else
        if (this.cbSpecies.getSelectedItem().toString() == "Cat")
        {
            String badHabits = tbxBadHabits.getText();
            if (badHabits.isEmpty()) badHabits = "No";
            this.reservations.NewCat(tbxName.getText(), gender, badHabits);
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
        if (tbxReserveName.getText().isEmpty())
            JOptionPane.showMessageDialog(panel, "Please enter your name!");

        else
        if (animal != null)
        {
            animal.Reserve(tbxReserveName.getText());
            this.refreshControls();
        }
    }
}
