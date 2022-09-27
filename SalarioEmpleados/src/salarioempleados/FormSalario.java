package salarioempleados;

import javax.imageio.metadata.IIOMetadataFormatImpl;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FormSalario extends JFrame {

    //Declare labels
    private JLabel lblEmployeeName, lblEmployeeAge, lblEmployeeCivilState, lblEmployeeSex, lblEmployeeAmount;
    //Declare input boxes
    private JTextField txtEmployeeName, txtEmployeeAmount;
    //Declare JComboBox
    private JComboBox cmbEmployeeAge, cmbEmployeeCivilState, cmbEmployeeSex;
    private JButton btnCalculateIncrement;
    //Declare table
    private JTable tableDataViewer;
    private JScrollPane scrollPane;
    private DefaultTableModel defaultTableModel;
    public FormSalario() {
        this.setLayout(null); //Lo asigno a null para que no me de problemas de ubicacion de componentes
        this.InitComponents();
        this.setSize(520, 500);
        this.setTitle("Calcular salario del empleado");
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        this.setResizable(false);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    private void InitComponents(){
        this.initLabels(); //Cargar el "generador" de labels
        this.initTextFields(); //Cargar el generador de text fields
        this.initComboBoxes(); //Cargar el generador de JComboBox
        this.initButtons();
        this.initTable();
    }

    private void initLabels(){
        //Label que sirve de guia para los datos del empleado:
        lblEmployeeName = new JLabel("Nombre: ");
        lblEmployeeName.setBounds(20, 10, 100, 30);
        add(lblEmployeeName);

        //Label para la edad del empleado
        lblEmployeeAge = new JLabel("Edad: ");
        lblEmployeeAge.setBounds(20, 60, 100, 30);
        add(lblEmployeeAge);

        //Label para el estado civil del empleado
        lblEmployeeCivilState = new JLabel("Estado civil: ");
        lblEmployeeCivilState.setBounds(250, 10, 100, 30);
        add(lblEmployeeCivilState);

        //Label para el sexo del empleado
        lblEmployeeSex = new JLabel("Sexo: ");
        lblEmployeeSex.setBounds(250, 60, 100, 30);
        add(lblEmployeeSex);

        //Para el sueldo
        lblEmployeeAmount = new JLabel("Salario: ");
        lblEmployeeAmount.setBounds(20, 150, 100, 30);
        add(lblEmployeeAmount);
    }

    private void initTextFields(){
        //Nombre del empleado
        txtEmployeeName = new JTextField();
        txtEmployeeName.setBounds(100, 10, 100, 30);
        add(txtEmployeeName);

        //Salari devengado
        txtEmployeeAmount = new JTextField();
        txtEmployeeAmount.setBounds(150, 150, 100, 30);
        add(txtEmployeeAmount);
    }

    private void initComboBoxes(){
        //Edades
        cmbEmployeeAge = new JComboBox();
        loadAgesToComboBox();
        cmbEmployeeAge.setBounds(100, 60, 100, 30);
        add(cmbEmployeeAge);

        //Estado civil
        cmbEmployeeCivilState = new JComboBox();
        loadCivilStatus();
        cmbEmployeeCivilState.setBounds(350, 10, 100, 30);
        add(cmbEmployeeCivilState);

        //Sexo
        cmbEmployeeSex = new JComboBox();
        loadSex();
        cmbEmployeeSex.setBounds(350, 60, 100, 30);
        add(cmbEmployeeSex);
    }

    private void initButtons(){
        btnCalculateIncrement = new JButton("Calcular");
        btnCalculateIncrement.setBounds(200, 200, 100, 30);
        btnCalculateIncrement.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(txtEmployeeName.getText().equals("") || txtEmployeeAmount.getText().equals("")){
                    JOptionPane.showMessageDialog(null,
                            "Error: ingrese los campos requeridos",
                            "Advertencia",
                            JOptionPane.WARNING_MESSAGE
                    );
                }else{
                    String employeeName = txtEmployeeName.getText().trim();
                    String employeeAge = cmbEmployeeAge.getSelectedItem().toString();
                    String employeeCivilState = cmbEmployeeCivilState.getSelectedItem().toString();
                    String employeeSex = cmbEmployeeSex.getSelectedItem().toString();
                    String employeeAmount = txtEmployeeAmount.getText().trim();
                    double employeeAmountDouble = Double.parseDouble(employeeAmount);
                    double newAmount = 0;
                    double increment = 0;

                    if(employeeAmountDouble > 0 && employeeAmountDouble < 1000){
                        increment = employeeAmountDouble*0.15;
                        newAmount = increment + employeeAmountDouble;
                        addNewRow(employeeName, employeeAge, employeeCivilState, employeeSex, employeeAmountDouble, increment, newAmount);
                    }else if(employeeAmountDouble >= 1000){
                        increment = employeeAmountDouble*0.12;
                        newAmount = increment + employeeAmountDouble;
                        addNewRow(employeeName, employeeAge, employeeCivilState, employeeSex, employeeAmountDouble, increment, newAmount);
                    }else{
                        JOptionPane.showMessageDialog(null, "Ingrese un valor valido");
                    }
                }
            }
        });
        btnCalculateIncrement.setFocusPainted(false);
        add(btnCalculateIncrement);
    }

    private void loadAgesToComboBox(){
        for (int i = 20; i < 61; i++) {
            //Agregar las edades al JComboBox
            cmbEmployeeAge.addItem(i);
        }
    }

    private void loadCivilStatus(){
        cmbEmployeeCivilState.addItem("Soltero/a");
        cmbEmployeeCivilState.addItem("Casado/a");
        cmbEmployeeCivilState.addItem("Divorciado/a");
        cmbEmployeeCivilState.addItem("Viudo/a");
    }

    private void loadSex(){
        cmbEmployeeSex.addItem("Hombre");
        cmbEmployeeSex.addItem("Mujer");
    }

    private void initTable(){
        tableDataViewer = new JTable();
        defaultTableModel = new DefaultTableModel();
        defaultTableModel.addColumn("Nombre");
        defaultTableModel.addColumn("Edad");
        defaultTableModel.addColumn("Estado civil");
        defaultTableModel.addColumn("Sexo");
        defaultTableModel.addColumn("Salario");
        defaultTableModel.addColumn("Aumento");
        defaultTableModel.addColumn("Nuevo salario");
        tableDataViewer.setModel(defaultTableModel);
        scrollPane = new JScrollPane(tableDataViewer);
        scrollPane.setBounds(10, 250, 480, 200);
        add(scrollPane);
    }

    private void addNewRow(String name, String age, String civilStatus, String sex, double amount, double increment, double newAmount){
        defaultTableModel.addRow(new Object[]{
                name,
                age,
                civilStatus,
                sex,
                amount,
                increment,
                newAmount
            }
        );
    }
}
