
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class AgendaForm extends JFrame {

    DatosAgenda agenda;
    ArrayList<DatosAgenda> arrLstDatos = new ArrayList<>();
    //
    private JLabel labelMessage;
    private JLabel lblContactName;
    private JLabel lblContactPhoneNumber;
    private JLabel lblcontactEmail;
    private JLabel lblContactGroup;
    private JTextField txtContactName;
    private JTextField txtContactPhoneNumber;
    private JTextField txtContactEmail;
    private JComboBox cmbSelectGroup;
    private JButton btnAddContact;
    private JButton btnDeleteContact;
    private JTable tableDataViewer;
    private DefaultTableModel myDefaultTableModel;
    private JScrollPane myScrollPane;

    public AgendaForm(){
        this.InitComponents();
        this.setLayout(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);
        this.setSize(500, 500);
        this.setTitle("Lista de contactos");
        this.setResizable(false);
        this.setLocationRelativeTo(null);
    }

    private void InitComponents(){
        this.InitLabels();
        this.InitTextFields();
        this.InitComboBox();
        this.InitButtons();
        this.InitTable();
    }

    private void InitLabels(){
        labelMessage = new JLabel("Contactos");
        labelMessage.setBounds(210, 20, 200, 30);
        labelMessage.setFont(new Font("Arial", 0, 16));
        add(labelMessage);

        lblContactName = new JLabel("Nombre: ");
        lblContactName.setBounds(25, 70, 100, 30);
        lblContactName.setFont(new Font("Arial", 0, 12));
        add(lblContactName);

        lblContactPhoneNumber = new JLabel("Telefono: ");
        lblContactPhoneNumber.setBounds(25, 120, 100, 30);
        lblContactPhoneNumber.setFont(new Font("Arial", 0, 12));
        add(lblContactPhoneNumber);

        lblcontactEmail = new JLabel("Correo: ");
        lblcontactEmail.setBounds(250, 70, 100, 30);
        lblcontactEmail.setFont(new Font("Arial", 0, 12));
        add(lblcontactEmail);

        lblContactGroup = new JLabel("Grupo: ");
        lblContactGroup.setBounds(250, 120, 100, 30);
        lblContactGroup.setFont(new Font("Arial", 0, 12));
        add(lblContactGroup);
    }

    private void InitTextFields(){
        txtContactName = new JTextField();
        txtContactName.setBounds(85, 70, 150, 30);
        txtContactName.setFont(new Font("Arial", 0, 12));
        add(txtContactName);

        txtContactPhoneNumber = new JTextField();
        txtContactPhoneNumber.setBounds(85, 120, 150, 30);
        txtContactPhoneNumber.setFont(new Font("Arial", 0, 12));
        add(txtContactPhoneNumber);

        txtContactEmail = new JTextField();
        txtContactEmail.setBounds(300, 70, 150, 30);
        txtContactEmail.setFont(new Font("Arial", 0, 12));
        add(txtContactEmail);
    }

    private void InitComboBox(){
        cmbSelectGroup = new JComboBox();
        cmbSelectGroup.addItem("Familiar");
        cmbSelectGroup.addItem("Amigos");
        cmbSelectGroup.addItem("Trabajo");
        cmbSelectGroup.addItem("Vecinos");
        cmbSelectGroup.addItem("Colegio/Universidad");
        cmbSelectGroup.addItem("Otros");
        cmbSelectGroup.setBounds(300, 120, 150, 30);
        cmbSelectGroup.setFont(new Font("Arial", 0, 12));
        cmbSelectGroup.setEditable(false);
        add(cmbSelectGroup);
    }

    private void InitButtons(){
        btnAddContact = new JButton("Agregar");
        btnAddContact.setBounds(100, 200, 100, 30);
        btnAddContact.setFont(new Font("Arial", 0, 12));
        btnAddContact.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = txtContactName.getText().trim();
                String phoneNumber = txtContactPhoneNumber.getText().trim();
                String email = txtContactEmail.getText().trim();
                String group = (String)cmbSelectGroup.getSelectedItem();

                if(name.equals("") || phoneNumber.equals("") || email.equals("")){
                    JOptionPane.showMessageDialog(null,
                            "Error: ingrese los valores",
                            "Atencion",
                            JOptionPane.WARNING_MESSAGE);
                }else{
                    agenda = new DatosAgenda(name, phoneNumber, email, group);
                    arrLstDatos.add(agenda);
                    LoadContactsToTable(name, phoneNumber, email, group);
                    ClearItems();
                }
            }
        });
        btnAddContact.setFocusPainted(false);
        add(btnAddContact);
    }

    private void InitTable(){
        tableDataViewer = new JTable();
        myDefaultTableModel = new DefaultTableModel();
        //Set table columns:
        myDefaultTableModel.addColumn("Nombre");
        myDefaultTableModel.addColumn("Telefono");
        myDefaultTableModel.addColumn("Correo");
        myDefaultTableModel.addColumn("Grupo");

        tableDataViewer.setModel(myDefaultTableModel);

        myScrollPane = new JScrollPane(tableDataViewer);
        myScrollPane.setBounds(20, 250, 450, 200);
        add(myScrollPane);
    }

    private void LoadContactsToTable(String name, String phoneNumber, String email, String group){
        myDefaultTableModel.addRow(new Object[]{
                name,
                phoneNumber,
                email,
                group
            }
        );
    }

    private void ClearItems(){
        txtContactName.setText("");
        txtContactPhoneNumber.setText("");
        txtContactEmail.setText("");
    }

}
