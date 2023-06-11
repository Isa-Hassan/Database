package za.ac.cput.dentistappointment;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;


public class GUI extends JFrame implements ActionListener {
    DefaultTableModel tableModel;
    JTable table;
    JTextField name, surname, contactNO;
    JButton button;
    JLabel patient, tlabel, dlabel, dclabel, phone, header, header1, lnName;
    JComboBox<String> time, date, doctor;
    JPanel south, north;
    JButton submit, appointments;
    JPanel buttonPanel;
     JScrollPane space;

    public GUI() {
        super("Dentist Appointment");
        this.setLayout(new BorderLayout());
        tableModel = new DefaultTableModel();
        table = new JTable(tableModel);
        buttonPanel = new JPanel();
        south = new JPanel();
        north = new JPanel();
     JScrollPane tableScrollPane = new JScrollPane(table);
    }

    public void setGUI(){
        north.setLayout(new BorderLayout());
        header = new JLabel("Book your Appointments");
        header.setForeground(Color.BLACK);
        north.add(header, BorderLayout.NORTH);
   this.add(north, BorderLayout.NORTH);
        JPanel centerPanel = new JPanel(new GridLayout(8, 2));
        patient = new JLabel("Name");
        lnName = new JLabel("Surname");
        tlabel = new JLabel("Time");
        phone = new JLabel("Cell Number");
        time = new JComboBox<>();
        dlabel = new JLabel("Date");
        date = new JComboBox<>();
        dclabel = new JLabel("Dentist");
        doctor = new JComboBox<>();
        name = new JTextField();
        surname = new JTextField();
        contactNO = new JTextField();

        centerPanel.add(patient);
        centerPanel.add(name);
        centerPanel.add(lnName);
        centerPanel.add(surname);
        centerPanel.add(phone);
        centerPanel.add(contactNO);
        centerPanel.add(dclabel);
        centerPanel.add(doctor);
        centerPanel.add(dlabel);
        centerPanel.add(date);
        centerPanel.add(tlabel);
        centerPanel.add(time);

        // ComboBox
        doctor.addItem("Dr Smith");
        doctor.addItem("Dr Jones");
        doctor.addItem("Dr Adams");
        doctor.addItem("Dr Brown");
        doctor.addItem("Dr Lee");

        date.addItem("05-11-2023");
        date.addItem("06-11-2023");
        date.addItem("08-11-2023");
        date.addItem("10-11-2023");
        date.addItem("11-11-2023");

        time.addItem("9:00 AM");
        time.addItem("11:00 AM");
        time.addItem("14:00 PM");
        time.addItem("16:00 PM");

   

        submit = new JButton("Submit");
        buttonPanel.add(submit);
        appointments = new JButton("View Appointments");
        buttonPanel.add(appointments);
        this.add(centerPanel, BorderLayout.WEST);

       
   

        table.setModel(tableModel);
        JScrollPane tableScrollPane = new JScrollPane(table);
        tableScrollPane.setPreferredSize(new Dimension(400, 200));
        int space = 10;
        tableScrollPane.setBorder(BorderFactory.createEmptyBorder(space, space, space, space));
        add(tableScrollPane, BorderLayout.CENTER);

 
       
        
        JPanel southPanel = new JPanel(new BorderLayout());
        southPanel.add(buttonPanel, BorderLayout.CENTER);
        this.add(southPanel, BorderLayout.SOUTH);

        submit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
      
            Patients pat = new Patients (name.getText(), surname.getText(), contactNO.getText(), doctor.getSelectedItem().toString(), date.getSelectedItem().toString(), time.getSelectedItem().toString());	
             try {
			pat.writeToFile();
                         JOptionPane.showMessageDialog(GUI.this, "You have successfully booked your appointment, see you on "+ date.getSelectedItem().toString()+ " at " + time.getSelectedItem().toString());            
                        } catch (IOException ewe) {
			System.out.println(ewe);
			System.out.println("Cant run");
			} 
            }    
        });
  appointments.addActionListener(new ActionListener() { 
@Override
public void actionPerformed(ActionEvent e) {
     
        
    if (e.getSource() == appointments) {
        JFrame tableFrame = new JFrame("Appointments");
        
        DefaultTableModel tableModel = new DefaultTableModel();
        JTable appointmentTable = new JTable(tableModel);

       
        tableModel.addColumn("Name");
        tableModel.addColumn("Surname");
        tableModel.addColumn("Cell Number");
        tableModel.addColumn("Dentist");
        tableModel.addColumn("Date");
        tableModel.addColumn("Time");
        
        
    
        JScrollPane scrollPane = new JScrollPane(appointmentTable);
        tableFrame.setLayout(new BorderLayout());
        tableFrame.add(scrollPane, BorderLayout.CENTER);
        tableFrame.setSize(600, 400);
        tableFrame.setVisible(true);
        
  
    
      try {
     File document = new File("Appointments.txt");
     Scanner scanner = new Scanner(document);
     tableModel.setRowCount(0);
     tableModel.addRow(new Object[] {"Jason", "Lemon", "082 464 2343", "Dr. Smith", "01-11-2023", "9:00 AM"});
      tableModel.addRow( new Object[] {"Chloe", "Smith", "082 942 2343", "Dr. Lee", "02-11-2023", "14:00 PM"});
      tableModel.addRow(new Object[] {"Andrew", "Jones", "082 987 6543", "Dr. Jones", "01-11-2023", "16:00 PM"});
      tableModel.addRow( new Object[] {"Ben", "Hassem", "074 123 4567", "Dr. Lee", "02-11-2023", "16:00 PM"});
       tableModel.addRow(new Object[] {"Cassidy", "Rose", "074 999 0000", "Dr. Smith", "01-11-2023", "9:00 AM"});
      tableModel.addRow( new Object[] {"Chloe", "Smith", "082 942 2343", "Dr. Lee", "17-11-2023", "16:00 PM"});
      tableModel.addRow(new Object[] {"Andy", "Biscuit", "082 777 8888", "Dr. Brown ", "29-10-2023", "11:00 AM"});
      tableModel.addRow( new Object[] {"Lily", "Space", "074 324 4534", "Dr. Adam", "01-11-2023", "11:00 PM"});
    
                while (scanner.hasNextLine()) {
                    String line = scanner.nextLine();
                    String[] fields = line.split("#");
                    tableModel.addRow(fields);
                }
              scanner.close();
            }
            catch (FileNotFoundException fnfe) {
            	System.out.println(fnfe);
                System.out.println("Cannot read file");
            }
    
    
} 
} });
    }
    
   
    
    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }}

