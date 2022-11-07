import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.Objects;

public class GUIDesign extends JFrame {

    //Declare textfields
    private JTextField txtGetName;
    private JTextField txtGetPhone;

    //Combobox
    private JComboBox cmbGetRelationship;

    //Declare extra components
    private JTable myDataTable;
    private JScrollPane myScrollPane;
    DefaultTableModel tableModel;
    Contacts contactsManager;

    public GUIDesign(){
        this.setLayout(null);
        this.initComponents();
        this.setBounds(0,0,500,500);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setVisible(true);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    private void initComponents(){
        this.LoadLabels();
        this.LoadTextFields();
        this.LoadComboBox();
        this.LoadButtons();
        this.LoadTable();
    }

    private void LoadLabels(){
        JLabel lblWelcome = new JLabel("Agregar un nuevo contacto");
        lblWelcome.setBounds(200, 25, 200, 30);
        lblWelcome.setFont(new Font("Arial", 1, 12));
        add(lblWelcome);

        //################################################################//
        JLabel lblRequestName = new JLabel("Nombre: ");
        lblRequestName.setBounds(20, 75, 75, 30);
        lblRequestName.setFont(new Font("Arial", 1, 12));
        add(lblRequestName);

        JLabel lblRequestPhone = new JLabel("Telefono: ");
        lblRequestPhone.setBounds(225, 75, 75, 30);
        lblRequestPhone.setFont(new Font("Arial", 1, 12));
        add(lblRequestPhone);

        JLabel lblRequestRelationship = new JLabel("Relacion: ");
        lblRequestRelationship.setBounds(20, 150, 100, 30);
        lblRequestRelationship.setFont(new Font("Arial", 1, 12));
        add(lblRequestRelationship);
    }

    private void LoadTextFields(){
        txtGetName = new JTextField();
        txtGetName.setBounds(100, 75, 100, 30);
        txtGetName.setFont(new Font("Arial", 1, 12));
        add(txtGetName);

        txtGetPhone = new JTextField();
        txtGetPhone.setBounds(300, 75, 100, 30);
        txtGetPhone.setFont(new Font("Arial", 1, 12));
        add(txtGetPhone);
    }

    private void LoadComboBox(){
        cmbGetRelationship = new JComboBox();
        cmbGetRelationship.setBounds(100, 150, 100, 30);
        cmbGetRelationship.setFont(new Font("Arial", 1, 12));
        cmbGetRelationship.addItem("Seleccionar");
        cmbGetRelationship.addItem("Familia");
        cmbGetRelationship.addItem("Colegio/Universidad");
        cmbGetRelationship.addItem("Trabajo");
        cmbGetRelationship.addItem("Vecindario");
        cmbGetRelationship.addItem("Amigos");
        cmbGetRelationship.addItem("Otros");
        add(cmbGetRelationship);
    }

    private void LoadButtons(){
        JButton btnAddContact = new JButton("Agregar");
        btnAddContact.setBounds(125, 200, 100, 25);
        btnAddContact.setFocusPainted(false);
        btnAddContact.setFont(new Font("Arial", 1, 12));
        btnAddContact.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int id = 0;
                String name;
                String phone;
                String relationship;

                if(txtGetName.getText().trim().equals("") || txtGetPhone.getText().trim().equals("") || Objects.equals(cmbGetRelationship.getSelectedItem(), "Seleccionar")){
                    JOptionPane.showMessageDialog(null, "Faltan campos por rellenar");
                }else{
                    id++;
                    name = txtGetName.getText().trim();
                    phone = txtGetPhone.getText().trim();
                    relationship = Objects.requireNonNull(cmbGetRelationship.getSelectedItem()).toString();

                    contactsManager = new Contacts(id, name, phone, relationship);
                    try {
                        SaveContacts.SaveData(id, name, phone, relationship);
                    } catch (SQLException ex) {
                        JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
                    }

                }
            }
        });
        add(btnAddContact);

        JButton btnDeleteContact = new JButton("Eliminar");
        btnDeleteContact.setBounds(300, 200, 100, 25);
        btnDeleteContact.setFocusPainted(false);
        btnDeleteContact.setFont(new Font("Arial", 1, 12));
        btnDeleteContact.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //
            }
        });
        add(btnDeleteContact);
    }

    private void LoadTable(){
        myDataTable = new JTable();
        tableModel = new DefaultTableModel();
        tableModel.addColumn("ID");
        tableModel.addColumn("Nombre");
        tableModel.addColumn("Telefono");
        tableModel.addColumn("Relacion");
        myDataTable.setModel(tableModel);

        //


        myScrollPane = new JScrollPane(myDataTable);
        myScrollPane.setBounds(20, 250, 450, 150);
        add(myScrollPane);
    }

    private void LoadContentsToTable(){

        contactsManager = new Contacts();

        tableModel.addRow(new Object[]{
                contactsManager.getContactID(),
                contactsManager.getContactName(),
                contactsManager.getContactPhone(),
                contactsManager.getContactRelationship()
        });
    }

}
