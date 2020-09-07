import Animals.Animal;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

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
    private JTextField tbName;

    public MainForm()
    {
        cbSpecies.addItem("Cat");
        cbSpecies.addItem("Dog");

        btnAddAnimal.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
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

    /*private void cmbSpecies_SelectedIndexChanged(object sender, EventArgs e)
    {
        this.txtBadHabits.Enabled = this.cmbSpecies.Text == "Cat";
    }*/

    private void refreshControls()
    {
        lbxAnimals.removeAll();
        DefaultListModel lbAnimals = new DefaultListModel();
        for ( Animal animal : reservations.getAnimals())
        {
            lbAnimals.addElement(animal);
        }

        lbxAnimals = new JList(lbAnimals);

        //btnReserveAnimal.Enabled = lstAnimals.SelectedItem != null;
    }

    /*private void btnAddAnimal_Click(object sender, EventArgs e)
    {
        Gender gender = radMale.Checked ? Gender.Male : Gender.Female;

        if (this.cmbSpecies.Text == "Cat")
        {
            this.reservations.NewCat(
                    txtName.Text, gender, txtBadHabits.Text);
        }
        else if (this.cmbSpecies.Text == "Dog")
        {
            this.reservations.NewDog(txtName.Text, gender);
        }

        this.RefreshControls();
    }*/

    /*private void btnReserveAnimal_Click(object sender, EventArgs e)
    {
        Animal animal = lstAnimals.SelectedItem as Animal;

        if (animal != null)
        {
            animal.Reserve(txtReservor.Text);
            this.RefreshControls();
        }
    }*/

    /*private void lstAnimals_SelectedIndexChanged(object sender, EventArgs e)
    {
        btnReserveAnimal.Enabled = lstAnimals.SelectedItem != null;
    }*/
}
