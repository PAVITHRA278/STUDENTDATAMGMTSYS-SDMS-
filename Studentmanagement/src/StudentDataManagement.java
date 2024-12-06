
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.JTextComponent;

import net.proteanit.sql.DbUtils;

 

import javax.swing.border.MatteBorder;

import java.awt.print.PrinterException;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import java.sql.ResultSet;

import java.sql.SQLException;

import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;

import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

 

public class StudentDataManagement extends JFrame {
      private static JTextField[] semesterFields = new JTextField[8];
    

	// Label to display the photo
        private JLabel photoLabel;
        private JTextArea transcriptArea;
        

private JPanel contentPane;

private JTextField tf1;

private JTextField tf2;

private JTextField tf3;

private JTextField tf5;

private JTextField tf6;

private JTextField tf7;

private JTextField tf8;

private JTextField tf9;

private JTextField tf4;

private JTable table;

Connection conn;

JRadioButton r4,r5;

JComboBox comboBox;
//Declare idTextField at the class level
JTextField idTextField;



JButton btnShowTranscript; 

private JTextField tf10;

private JTextField tf11;

private JTextField tf12;
private DefaultTableModel model;


private Connection connection;

 

/**

 * Launch the application.

 */
//Inside the storeArrearsInDatabase method:
//Method to update arrear counts



public static void main(String[] args) {

EventQueue.invokeLater(new Runnable() {

public void run() {

try {

StudentDataManagement frame = new StudentDataManagement();

frame.setVisible(true);

} catch (Exception e) {

e.printStackTrace();

}

}

});

}


//Add Combo Box

void addItemToComboBox()throws SQLException{

String query = "SELECT * from studentdatamgmt";

Statement stmt = conn.createStatement();

ResultSet rs = stmt.executeQuery(query);


while(rs.next()) {

comboBox.addItem(rs.getString("FirstName"));

}

}


      

/**

 * Create the frame.
 * @return 

 */

public StudentDataManagement() {
	
	
	

conn = DataBaseConnection.dbConn();


setFont(new Font("Dialog", Font.BOLD, 18));

setBackground(SystemColor.activeCaption);

setTitle("Student Data Management");

setIconImage(Toolkit.getDefaultToolkit().getImage("\"C:\\Users\\Pavithra\\OneDrive\\Pictures\\calm.jpg\""));

setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

setBounds(100, 100, 1273, 680);

contentPane = new JPanel();

contentPane.setBackground(new Color(255, 255, 255));


contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

setContentPane(contentPane);

contentPane.setLayout(null);

//Add a label to display the photo (where the red box is drawn)
/*photoLabel = new JLabel();
photoLabel.setBounds(10, 10, 100, 100); // Position and size of  the image display area
photoLabel.setBorder(BorderFactory.createLineBorder(Color.BLACK)); // Border for clarity
add(photoLabel);

photoLabel.addMouseListener(new MouseAdapter() {
   @Override
   public void mouseClicked(MouseEvent e) {
       JFileChooser fileChooser = new JFileChooser();
       int result = fileChooser.showOpenDialog(null);

       if (result == JFileChooser.APPROVE_OPTION) {
           File selectedFile = fileChooser.getSelectedFile();
           try {
               BufferedImage img = ImageIO.read(selectedFile);
               ImageIcon imageIcon = new ImageIcon(img.getScaledInstance(photoLabel.getWidth(), photoLabel.getHeight(), Image.SCALE_SMOOTH));
               photoLabel.setIcon(imageIcon);
           } catch (Exception ex) {
               ex.printStackTrace();
               JOptionPane.showMessageDialog(null, "Failed to load image!");
           }
       }
   }
});*/


JLabel lblNewLabel = new JLabel("STUDENT    DATA    MANAGEMENT");

lblNewLabel.setForeground(new Color(95, 100, 160));

lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 36));

lblNewLabel.setBounds(400, 28, 642, 44);

contentPane.add(lblNewLabel);





JLabel lblNewLabel_1 = new JLabel("First Name");

lblNewLabel_1.setForeground(new Color(0, 128, 128));

lblNewLabel_1.setBackground(new Color(0, 128, 128));

lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 18));

lblNewLabel_1.setBounds(10, 110, 111, 27);

contentPane.add(lblNewLabel_1);


JLabel lblNewLabel_1_1 = new JLabel("Surname");

lblNewLabel_1_1.setForeground(new Color(0, 128, 128));

lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 18));

lblNewLabel_1_1.setBounds(10, 145, 123, 27);

contentPane.add(lblNewLabel_1_1);


JLabel lblNewLabel_1_2 = new JLabel("Age");

lblNewLabel_1_2.setForeground(new Color(0, 128, 128));

lblNewLabel_1_2.setFont(new Font("Tahoma", Font.BOLD, 18));

lblNewLabel_1_2.setBounds(10, 191, 95, 27);

contentPane.add(lblNewLabel_1_2);


JLabel lblNewLabel_1_3 = new JLabel("Contact No.");

lblNewLabel_1_3.setForeground(new Color(0, 128, 128));

lblNewLabel_1_3.setFont(new Font("Tahoma", Font.BOLD, 18));

lblNewLabel_1_3.setBounds(10, 329, 111, 27);

contentPane.add(lblNewLabel_1_3);


JLabel lblNewLabel_1_2_1 = new JLabel("Gender");

lblNewLabel_1_2_1.setForeground(new Color(0, 128, 128));

lblNewLabel_1_2_1.setFont(new Font("Tahoma", Font.BOLD, 18));

lblNewLabel_1_2_1.setBounds(10, 291, 95, 27);

contentPane.add(lblNewLabel_1_2_1);


JLabel lblNewLabel_1_3_1 = new JLabel("Year Of Join");

lblNewLabel_1_3_1.setForeground(new Color(0, 128, 128));

lblNewLabel_1_3_1.setFont(new Font("Tahoma", Font.BOLD, 18));

lblNewLabel_1_3_1.setBounds(10, 367, 123, 27);

contentPane.add(lblNewLabel_1_3_1);


JLabel lblNewLabel_1_3_1_1 = new JLabel("Department");

lblNewLabel_1_3_1_1.setForeground(new Color(0, 128, 128));

lblNewLabel_1_3_1_1.setFont(new Font("Tahoma", Font.BOLD, 18));

lblNewLabel_1_3_1_1.setBounds(10, 443, 123, 27);

contentPane.add(lblNewLabel_1_3_1_1);


JLabel lblNewLabel_1_3_1_2 = new JLabel("Class");

lblNewLabel_1_3_1_2.setForeground(new Color(0, 128, 128));

lblNewLabel_1_3_1_2.setFont(new Font("Tahoma", Font.BOLD, 18));

lblNewLabel_1_3_1_2.setBounds(10, 481, 123, 27);

contentPane.add(lblNewLabel_1_3_1_2);


JLabel lblNewLabel_1_3_1_3 = new JLabel("Id");

lblNewLabel_1_3_1_3.setForeground(new Color(0, 128, 128));

lblNewLabel_1_3_1_3.setFont(new Font("Tahoma", Font.BOLD, 18));

lblNewLabel_1_3_1_3.setBounds(10, 405, 123, 27);

contentPane.add(lblNewLabel_1_3_1_3);


JLabel lblNewLabel_1_3_1_4 = new JLabel("Father Name");

lblNewLabel_1_3_1_4.setForeground(new Color(0, 128, 128));

lblNewLabel_1_3_1_4.setFont(new Font("Tahoma", Font.BOLD, 18));

lblNewLabel_1_3_1_4.setBounds(10, 519, 123, 27);

contentPane.add(lblNewLabel_1_3_1_4);


JLabel lblNewLabel_1_3_1_4_1 = new JLabel("Mother Name\r\n");

lblNewLabel_1_3_1_4_1.setForeground(new Color(0, 128, 128));

lblNewLabel_1_3_1_4_1.setFont(new Font("Tahoma", Font.BOLD, 18));

lblNewLabel_1_3_1_4_1.setBounds(10, 557, 123, 27);

contentPane.add(lblNewLabel_1_3_1_4_1);


JLabel lblNewLabel_1_3_1_4_2 = new JLabel("DateOfBirth");

lblNewLabel_1_3_1_4_2.setForeground(new Color(0, 128, 128));

lblNewLabel_1_3_1_4_2.setFont(new Font("Tahoma", Font.BOLD, 18));

lblNewLabel_1_3_1_4_2.setBounds(10, 253, 123, 27);

contentPane.add(lblNewLabel_1_3_1_4_2);
//Sem 1 to Sem 8 TextFields
JLabel lblSem1 = new JLabel("Sem 1");
lblSem1.setForeground(new Color(0, 128, 128));
lblSem1.setFont(new Font("Tahoma", Font.BOLD, 18));
lblSem1.setBounds(350, 150, 111, 27); // Adjust y-coordinate as needed
contentPane.add(lblSem1);
//Sem 1
JTextField sem1Field = new JTextField();
sem1Field.setBackground(new Color(224, 255, 255));
sem1Field.setColumns(10);
sem1Field.setBounds(450, 150, 50, 32); // Adjust y-coordinate as needed
contentPane.add(sem1Field);

//Sem 2 Label and TextField
JLabel lblSem2 = new JLabel("Sem 2");
lblSem2.setForeground(new Color(0, 128, 128));
lblSem2.setFont(new Font("Tahoma", Font.BOLD, 18));
lblSem2.setBounds(350, 200, 111, 27); // Adjust y-coordinate as needed
contentPane.add(lblSem2);
//Sem 2
JTextField sem2Field = new JTextField();
sem2Field.setBackground(new Color(224, 255, 255));
sem2Field.setColumns(10);
sem2Field.setBounds(450, 200, 50, 32); // Adjust y-coordinate as needed
contentPane.add(sem2Field);


//Sem 3 Label and TextField
JLabel lblSem3 = new JLabel("Sem 3");
lblSem3.setForeground(new Color(0, 128, 128));
lblSem3.setFont(new Font("Tahoma", Font.BOLD, 18));
lblSem3.setBounds(350, 250, 111, 27); // Adjust y-coordinate as needed
contentPane.add(lblSem3);

//Sem 3
JTextField sem3Field = new JTextField();
sem3Field.setBackground(new Color(224, 255, 255));
sem3Field.setColumns(10);
sem3Field.setBounds(450, 250, 50, 32); // Adjust y-coordinate as needed
contentPane.add(sem3Field);


//Sem 4 Label and TextField
JLabel lblSem4 = new JLabel("Sem 4");
lblSem4.setForeground(new Color(0, 128, 128));
lblSem4.setFont(new Font("Tahoma", Font.BOLD, 18));
lblSem4.setBounds(350, 300, 111, 27); // Adjust y-coordinate as needed
contentPane.add(lblSem4);
//Sem 4
JTextField sem4Field = new JTextField();
sem4Field.setBackground(new Color(224, 255, 255));
sem4Field.setColumns(10);
sem4Field.setBounds(450, 300, 50, 32); // Adjust y-coordinate as needed
contentPane.add(sem4Field);


JLabel lblSem5 = new JLabel("Sem 5");
lblSem5.setForeground(new Color(0, 128, 128));
lblSem5.setFont(new Font("Tahoma", Font.BOLD, 18));
lblSem5.setBounds(530, 150, 111, 27);
contentPane.add(lblSem5);

//Sem 5
JTextField sem5Field = new JTextField();
sem5Field.setBackground(new Color(224, 255, 255));
sem5Field.setColumns(10);
sem5Field.setBounds(600, 150, 50, 32); // Adjust y-coordinate as needed
contentPane.add(sem5Field);

JLabel lblSem6 = new JLabel("Sem 6");
lblSem6.setForeground(new Color(0, 128, 128));
lblSem6.setFont(new Font("Tahoma", Font.BOLD, 18));
lblSem6.setBounds(530, 200, 111, 27);
contentPane.add(lblSem6);
//Sem 6
JTextField sem6Field = new JTextField();
sem6Field.setBackground(new Color(224, 255, 255));
sem6Field.setColumns(10);
sem6Field.setBounds(600, 200, 50, 32); // Adjust y-coordinate as needed
contentPane.add(sem6Field);

JLabel lblSem7 = new JLabel("Sem 7");
lblSem7.setForeground(new Color(0, 128, 128));
lblSem7.setFont(new Font("Tahoma", Font.BOLD, 18));
lblSem7.setBounds(530, 250, 111, 27);
contentPane.add(lblSem7);
//Sem 7
JTextField sem7Field = new JTextField();
sem7Field.setBackground(new Color(224, 255, 255));
sem7Field.setColumns(10);
sem7Field.setBounds(600, 250, 50, 32); // Adjust y-coordinate as needed
contentPane.add(sem7Field);

JLabel lblSem8 = new JLabel("Sem 8");
lblSem8.setForeground(new Color(0, 128, 128));
lblSem8.setFont(new Font("Tahoma", Font.BOLD, 18));
lblSem8.setBounds(530, 300, 111, 27);
contentPane.add(lblSem8);
//Sem 8
JTextField sem8Field = new JTextField();
sem8Field.setBackground(new Color(224, 255, 255));
sem8Field.setColumns(10);
sem8Field.setBounds(600, 300, 50, 32); // Adjust y-coordinate as needed
contentPane.add(sem8Field);




tf1 = new JTextField();

tf1.setBackground(new Color(224, 255, 255));

tf1.setForeground(new Color(0, 0, 0));

tf1.setBounds(166, 110, 134, 20);

contentPane.add(tf1);

tf1.setColumns(10);


tf2 = new JTextField();

tf2.setBackground(new Color(224, 255, 255));

tf2.setColumns(10);

tf2.setBounds(166, 140, 134, 32);

contentPane.add(tf2);


tf3 = new JTextField();

tf3.setBackground(new Color(224, 255, 255));

tf3.setColumns(10);

tf3.setBounds(166, 191, 134, 32);

contentPane.add(tf3);


tf5 = new JTextField();

tf5.setBackground(new Color(224, 255, 255));

tf5.setColumns(10);

tf5.setBounds(166, 329, 134, 32);

contentPane.add(tf5);

// Add KeyListener to restrict input to 9 digits
tf5.addKeyListener(new KeyAdapter() {
    @Override
    public void keyTyped(KeyEvent e) {
        if (tf5.getText().length() >= 11 || !Character.isDigit(e.getKeyChar())) {
            e.consume(); // Ignore the event if the length is greater than 9 or the character is not a digit
        }
    }
});

tf6 = new JTextField();

tf6.setBackground(new Color(224, 255, 255));

tf6.setColumns(10);

tf6.setBounds(166, 367, 134, 32);

contentPane.add(tf6);


tf7 = new JTextField();

tf7.setBackground(new Color(224, 255, 255));

tf7.setColumns(10);

tf7.setBounds(166, 405, 134, 32);

contentPane.add(tf7);


tf8 = new JTextField();

tf8.setBackground(new Color(224, 255, 255));

tf8.setColumns(10);

tf8.setBounds(166, 519, 134, 32);

contentPane.add(tf8);


tf9 = new JTextField();

tf9.setBackground(new Color(224, 255, 255));

tf9.setColumns(10);

tf9.setBounds(166, 557, 134, 32);

contentPane.add(tf9);


JComboBox comboBox_1 = new JComboBox();

comboBox_1.setForeground(new Color(0, 128, 0));

comboBox_1.setBackground(new Color(224, 255, 255));

comboBox_1.setFont(new Font("Tahoma", Font.BOLD, 18));

comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"Select Class", "First Year", "Second Year", "Third Year","Fourth Year"}));

comboBox_1.setBounds(166, 481, 134, 27);

contentPane.add(comboBox_1);


tf4 = new JTextField();

tf4.setBackground(new Color(224, 255, 255));

tf4.setColumns(10);

tf4.setBounds(166, 248, 134, 32);

contentPane.add(tf4);

//Arrear Section Label
JLabel arrearLabel = new JLabel("Arrear Management");
arrearLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
arrearLabel.setForeground(new Color(0, 128, 128));
arrearLabel.setBounds(900, 150, 200, 30);
contentPane.add(arrearLabel);

//Semester Input
JLabel semesterLabel = new JLabel("Semester:");
semesterLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
semesterLabel.setBounds(680, 150, 100, 20);
contentPane.add(semesterLabel);

JTextField semesterField = new JTextField();
semesterField.setBounds(750, 150, 100, 25);
contentPane.add(semesterField);

//Panel for Subject Codes
JPanel subjectPanel = new JPanel();
subjectPanel.setLayout(new BoxLayout(subjectPanel, BoxLayout.Y_AXIS));

//Adding JScrollPane to make the subject panel scrollable
JScrollPane subjectScrollPane = new JScrollPane(subjectPanel);
subjectScrollPane.setBounds(700, 190, 280, 150);  // Adjust bounds as needed
subjectScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
contentPane.add(subjectScrollPane);

//Dynamic List for Subject Fields and Grade Fields
ArrayList<JTextField> subjectCodeFields = new ArrayList<>();


//"Add Subject" Button
JButton addSubjectButton = new JButton("Add Subject");
addSubjectButton.setBounds(660, 350, 120, 20);
contentPane.add(addSubjectButton);

//Add new subject code fields dynamically
addSubjectButton.addActionListener(e -> {
    JTextField subjectField = new JTextField(20);
    subjectCodeFields.add(subjectField);
    subjectPanel.add(subjectField);
    subjectPanel.revalidate();
    subjectPanel.repaint();
});


//Summary Box for Arrears
JTextArea arrearSummary = new JTextArea();
arrearSummary.setEditable(false);
arrearSummary.setBorder(BorderFactory.createTitledBorder("Arrear Summary"));
arrearSummary.setBounds(1000, 200, 200, 150);

//Wrap the JTextArea in a JScrollPane to make it scrollable
JScrollPane arrearSummaryScrollPane = new JScrollPane(arrearSummary);
arrearSummaryScrollPane.setBounds(1000, 200, 200, 150); // Set the position and size of the scroll pane
arrearSummaryScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS); // Always show vertical scroll bar
arrearSummaryScrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED); // Show horizontal scroll bar if needed

//Add the scroll pane to the content pane instead of directly adding the JTextArea
contentPane.add(arrearSummaryScrollPane);


//Store arrear counts in an array
int[] arrearCounts = new int[8];  // For Sem1Arr to Sem8Arr

//"Save Arrear" Button
JButton saveArrearButton = new JButton("Save Arrear");
saveArrearButton.setBounds(800, 350, 120, 20);
contentPane.add(saveArrearButton);

//"Save Arrear" Button Action Listener
saveArrearButton.addActionListener(e -> {
 String semesterText = semesterField.getText().trim();

 // Validate semester input
 if (semesterText.isEmpty() || !semesterText.matches("\\d") || Integer.parseInt(semesterText) < 1 || Integer.parseInt(semesterText) > 8) {
     JOptionPane.showMessageDialog(this, "Enter a valid semester number (1-8)!", "Error", JOptionPane.ERROR_MESSAGE);
     return;
 }

 int semester = Integer.parseInt(semesterText);
 int arrearCount = 0;

 // Loop through subject fields to calculate arrear count
 for (JTextField subjectField : subjectCodeFields) {
     String grade = JOptionPane.showInputDialog(this, "Enter grade for " + subjectField.getText().trim() + " (O, A, B, U):");
     if ("U".equalsIgnoreCase(grade)) {
         arrearCount++;
     }
 }

 // Update arrear summary
 arrearCounts[semester - 1] = arrearCount;
 arrearSummary.append("Semester " + semester + ": " + arrearCount + " arrears\n");

 // Calculate total arrears dynamically
 int totalArrears = 0;
 for (int count : arrearCounts) {
     totalArrears += count;
 }

 // Display the total arrears in the summary box
 arrearSummary.append("\nTotal Arrears: " + totalArrears + "\n");

 // Clear fields for the next entry
 semesterField.setText("");
 subjectCodeFields.clear();
 subjectPanel.removeAll();
 subjectPanel.revalidate();
 subjectPanel.repaint();
});



JButton btnNewButton = new JButton("Load\r\n");

btnNewButton.setForeground(new Color(0, 0, 205));

btnNewButton.setBackground(new Color(100, 149, 237));

btnNewButton.addActionListener(new ActionListener() {

public void actionPerformed(ActionEvent e) {

showData();

}

});

btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 18));

btnNewButton.setBounds(450, 680, 105, 32);

contentPane.add(btnNewButton);





JButton btnInsert = new JButton("Insert");

//Set button appearance
btnInsert.setForeground(new Color(0, 0, 205));
btnInsert.setBackground(new Color(100, 149, 237));

//JLabel to display the photo
JLabel photoLabel = new JLabel();
photoLabel.setBounds(10, 10, 100, 100); // Position and size of the image display area
photoLabel.setBorder(BorderFactory.createLineBorder(Color.BLACK)); // Adjust position and size as needed
contentPane.add(photoLabel);

btnInsert.addActionListener(new ActionListener() {
 public void actionPerformed(ActionEvent e) {
     // SQL query to insert data into the database
     String query = "INSERT INTO studentdatamgmt (FirstName, Surname, Age, DateOfBirth, Gender, ContactNo, YearOfJoin, Id, Department, Class, FatherName, MotherName, Sem1, Sem2, Sem3, Sem4, Sem5, Sem6, Sem7, Sem8, TotArr, Photo) " +
             "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

     try {
         // Prepare the SQL statement
         PreparedStatement ps = conn.prepareStatement(query);

         // Set values for other fields
         ps.setString(1, tf1.getText()); // First Name
         ps.setString(2, tf2.getText()); // Surname
         ps.setInt(3, Integer.parseInt(tf3.getText())); // Age
         ps.setInt(4, Integer.parseInt(tf4.getText())); // DateOfBirth
         ps.setString(5, tf11.getText()); // Gender
         String contactNo = tf5.getText();
         if (!contactNo.matches("\\d{10}")) { // Ensure valid 10-digit number
             JOptionPane.showMessageDialog(null, "Please enter a valid numeric Contact Number!");
             return;
         }
         ps.setString(6, contactNo); // ContactNo
         ps.setInt(7, Integer.parseInt(tf6.getText())); // YearOfJoin

         // Validate and set Student ID
         String studentId = tf7.getText().trim(); // Get the text and remove extra spaces
         if (studentId.isEmpty()) {
             JOptionPane.showMessageDialog(null, "Please enter a valid 12-digit ID!");
             return;
         }
         if (!studentId.matches("\\d{12}")) { // Ensure it's exactly 12 numeric digits
             JOptionPane.showMessageDialog(null, "ID must be a valid 12-digit number!");
             return;
         }
         ps.setString(8, studentId); // ID

         ps.setString(9, tf12.getText()); // Department
         ps.setString(10, String.valueOf(comboBox_1.getSelectedItem())); // Class selection
         ps.setString(11, tf8.getText()); // Father's Name
         ps.setString(12, tf9.getText()); // Mother's Name

         // Set semester grades
         ps.setInt(13, Integer.parseInt(sem1Field.getText())); // Sem1
         ps.setInt(14, Integer.parseInt(sem2Field.getText())); // Sem2
         ps.setInt(15, Integer.parseInt(sem3Field.getText())); // Sem3
         ps.setInt(16, Integer.parseInt(sem4Field.getText())); // Sem4
         ps.setInt(17, Integer.parseInt(sem5Field.getText())); // Sem5
         ps.setInt(18, Integer.parseInt(sem6Field.getText())); // Sem6
         ps.setInt(19, Integer.parseInt(sem7Field.getText())); // Sem7
         ps.setInt(20, Integer.parseInt(sem8Field.getText())); // Sem8

         // Calculate total arrears (TotArr)
         int totalArrears = 0;
         // Assume arrear counts are already calculated for each semester and stored in arrearCounts[]
         for (int arrearCount : arrearCounts) {
             totalArrears += arrearCount;
         }
         ps.setInt(21, totalArrears); // TotArr

         // Handle photo upload
         JFileChooser fileChooser = new JFileChooser();
         fileChooser.setDialogTitle("Select Photo");
         int result = fileChooser.showOpenDialog(null);

         if (result == JFileChooser.APPROVE_OPTION) {
             File photoFile = fileChooser.getSelectedFile();
             FileInputStream fis = new FileInputStream(photoFile);
             // Set the photo in the prepared statement
             ps.setBinaryStream(22, fis, (int) photoFile.length());

             // Display the selected photo in the photo box
             ImageIcon imageIcon = new ImageIcon(photoFile.getAbsolutePath());
             Image img = imageIcon.getImage().getScaledInstance(photoLabel.getWidth(), photoLabel.getHeight(), Image.SCALE_SMOOTH);
             photoLabel.setIcon(new ImageIcon(img));
         } else {
             ps.setNull(22, java.sql.Types.BLOB); // Set NULL if no photo is selected
         }

         // Execute the query
         int rowsAffected = ps.executeUpdate();

         if (rowsAffected > 0) {
             JOptionPane.showMessageDialog(null, "Data Insertion Successful!");
             showData(); // Refresh the table data
         } else {
             JOptionPane.showMessageDialog(null, "Data Insertion Failed. No rows were affected.");
         }

     } catch (SQLException ex) {
         JOptionPane.showMessageDialog(null, "Data Insertion Failed: " + ex.getMessage());
         ex.printStackTrace();
     } catch (NumberFormatException ex) {
         JOptionPane.showMessageDialog(null, "Please enter valid numeric values where required.");
     } catch (IOException ex) {
         JOptionPane.showMessageDialog(null, "Error reading photo file: " + ex.getMessage());
     }
 }
});

//Set button appearance and position
btnInsert.setFont(new Font("Tahoma", Font.BOLD, 18));
btnInsert.setBounds(300, 680, 105, 32);
contentPane.add(btnInsert);




JButton btnUpdate = new JButton("Update");

btnUpdate.addActionListener(new ActionListener() {
    private Object selectedPhotoPath;

    public void actionPerformed(ActionEvent e) {
        // Corrected SQL query
        String q = "UPDATE studentdatamgmt SET FirstName=?, Surname=?, Age=?, DateOfBirth=?, Gender=?, contactNo=?, YearOfJoin=?, Department=?, class=?, FatherName=?, MotherName=?, sem1=?, sem2=?, sem3=?, sem4=?, sem5=?, sem6=?, sem7=?, sem8=?, Photo=? WHERE Id=?";
        
        try {
            // Check database connection
            if (conn == null || conn.isClosed()) {
                JOptionPane.showMessageDialog(null, "Database connection is not established!");
                return;
            }

            PreparedStatement ps = conn.prepareStatement(q);

            // Bind all text fields except for 'Id'
            ps.setString(1, tf1.getText()); // FirstName
            ps.setString(2, tf2.getText()); // Surname
            ps.setInt(3, Integer.parseInt(tf3.getText())); // Age
            ps.setInt(4, Integer.parseInt(tf4.getText())); // DateOfBirth

            ps.setString(5, tf11.getText()); // Gender

            // Validate and bind ContactNo
            String contactNo = tf5.getText();
            if (!contactNo.matches("\\d{10}")) { // Ensure 10-digit Contact Number
                JOptionPane.showMessageDialog(null, "Contact Number must be a valid 10-digit number!");
                return;
            }
            ps.setString(6, contactNo); // contactNo

            ps.setInt(7, Integer.parseInt(tf6.getText())); // YearOfJoin
            ps.setString(8, tf12.getText()); // Department
            ps.setString(9, String.valueOf(comboBox_1.getSelectedItem())); // Class
            ps.setString(10, tf8.getText()); // FatherName
            ps.setString(11, tf9.getText()); // MotherName

            // Bind semester marks
            ps.setInt(12, Integer.parseInt(sem1Field.getText()));
            ps.setInt(13, Integer.parseInt(sem2Field.getText()));
            ps.setInt(14, Integer.parseInt(sem3Field.getText()));
            ps.setInt(15, Integer.parseInt(sem4Field.getText()));
            ps.setInt(16, Integer.parseInt(sem5Field.getText()));
            ps.setInt(17, Integer.parseInt(sem6Field.getText()));
            ps.setInt(18, Integer.parseInt(sem7Field.getText()));
            ps.setInt(19, Integer.parseInt(sem8Field.getText()));

            // Bind photoPath (if selected)
            if (selectedPhotoPath != null) {
                ps.setString(20, (String) selectedPhotoPath); // Bind Photo Path
            } else {
                ps.setNull(20, java.sql.Types.VARCHAR); // Set NULL if no photo
            }

            // Get the student ID from the text field
            String studentId = tf7.getText(); // ID from tf7
            if (!studentId.matches("\\d{12}")) { // Validate 12-digit format
                JOptionPane.showMessageDialog(null, "ID must be a valid 12-digit number!");
                return;
            }
            ps.setString(21, studentId); // Bind the ID for the WHERE clause

            // Execute the query
            int rowsAffected = ps.executeUpdate();

            if (rowsAffected > 0) {
                JOptionPane.showMessageDialog(null, "Data Updated Successfully!");
                showData(); // Refresh the data
            } else {
                JOptionPane.showMessageDialog(null, "No record found for the given ID.");
            }
        } catch (SQLException e1) {
            JOptionPane.showMessageDialog(null, "Data Update Failed! " + e1.getMessage());
            e1.printStackTrace();
        } catch (NumberFormatException e2) {
            JOptionPane.showMessageDialog(null, "Invalid input in number fields: " + e2.getMessage());
        }
    }
});

// Set button appearance and position
btnUpdate.setForeground(new Color(0, 0, 205));
btnUpdate.setBackground(new Color(100, 149, 237));
btnUpdate.setFont(new Font("Tahoma", Font.BOLD, 18));
btnUpdate.setBounds(742, 680, 105, 32);
contentPane.add(btnUpdate);


JButton btnPrint = new JButton("Print");

btnPrint.addActionListener(new ActionListener() {

public void actionPerformed(ActionEvent e) {

try {

if(table.print()) {

JOptionPane.showMessageDialog(null, "Printing Successfully!","Printer", JOptionPane.INFORMATION_MESSAGE);

}else {

JOptionPane.showMessageDialog(null,"Printing Failed!","Printer",JOptionPane.ERROR_MESSAGE);

}

}catch(PrinterException e1) {

e1.printStackTrace();

}

}

});

btnPrint.setForeground(new Color(0, 0, 205));

btnPrint.setBackground(new Color(100, 149, 237));

btnPrint.setFont(new Font("Tahoma", Font.BOLD, 18));

btnPrint.setBounds(913, 680, 105, 32);

contentPane.add(btnPrint);


//Add this code where you have other buttons defined

JButton btnReset = new JButton("Reset");
btnReset.setForeground(new Color(255, 0, 0)); // Set button color (optional)
btnReset.setBackground(new Color(255, 182, 193)); // Set button color (optional)
btnReset.addActionListener(new ActionListener() {
 public void actionPerformed(ActionEvent e) {
     // Clear all text fields
     tf1.setText("");
     tf2.setText("");
     tf3.setText("");
     tf4.setText("");
     tf5.setText("");
     tf6.setText("");
     tf7.setText("");
     tf8.setText("");
     tf9.setText("");
     tf11.setText("");
     tf12.setText("");
     sem1Field.setText("");
     sem2Field.setText("");
     sem3Field.setText("");
     sem4Field.setText("");
     sem5Field.setText("");
     sem6Field.setText("");
     sem7Field.setText("");
     sem8Field.setText("");
      // Reset idTextField

     // Clear the arrear summary box
     arrearSummary.setText(""); // Clear the JTextArea content

     // Clear subject fields and reset subject panel
     subjectCodeFields.clear();
     subjectPanel.removeAll();
     subjectPanel.revalidate();
     subjectPanel.repaint();

     // Reset other necessary fields
     semesterField.setText("");
     
     comboBox_1.setSelectedIndex(0);// Reset combo box to "Select Class"
 
     photoLabel.setIcon(null);
    
 }
});

btnReset.setForeground(new Color(0, 0, 205));

btnReset.setBackground(new Color(100, 149, 237));
btnReset.setFont(new Font("Tahoma", Font.BOLD, 18));
btnReset.setBounds(600, 680, 105, 32); // Set the position of the button
contentPane.add(btnReset); // Add the button to the content pane



JButton btnDelete = new JButton("Delete");

btnDelete.addActionListener(new ActionListener() {

public void actionPerformed(ActionEvent e) {

String query = "DELETE from studentdatamgmt where Id=?";

try {

PreparedStatement ps = conn.prepareStatement(query);

ps.setInt(1, Integer.parseInt(tf7.getText()));

ps.execute();

JOptionPane.showMessageDialog(null, "Data Deleted Successfully!");

showData();


} catch (SQLException e1) {

JOptionPane.showMessageDialog(null, "Data Deleted Failed!");

// TODO Auto-generated catch block

e1.printStackTrace();

}

}

});


btnDelete.setForeground(new Color(0, 0, 205));

btnDelete.setBackground(new Color(100, 149, 237));

btnDelete.setFont(new Font("Tahoma", Font.BOLD, 18));

btnDelete.setBounds(1084, 680, 105, 32);

contentPane.add(btnDelete);


JLabel lblNewLabel_2 = new JLabel("STUDENT'S DATA:-");

lblNewLabel_2.setForeground(new Color(46, 139, 87));

lblNewLabel_2.setBackground(new Color(51, 204, 204));

lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 22));

lblNewLabel_2.setBounds(362, 106, 221, 32);

contentPane.add(lblNewLabel_2);




/*JTextField box2 = new JTextField();
box2.setBorder(BorderFactory.createTitledBorder("Transcript"));
box2.setBounds(800, 150, 400, 220);
box2.setEditable(false);


contentPane.add(box2);*/





table = new JTable();
table.setBackground(new Color(255, 255, 255));
table.setForeground(new Color(0, 0, 0));
table.setFont(new Font("Tahoma", Font.PLAIN, 12));

table.setModel(new DefaultTableModel(
    new Object[][] {
        
        {null, null, null, null, null, null, null, null, null, null, null, null},
        {null, null, null, null, null, null, null, null, null, null, null, null},
        {null, null, null, null, null, null, null, null, null, null, null, null},
    },
    new String[] {
        "First Name", "Surname", "Age", "DateOfBirth", "Gender", "Contact No", "YearOfjoin", "Id", "Department", "Class", "Father Name", "Mother Name",
        "Sem 1 GPA", "Sem 2 GPA", "Sem 3 GPA", "Sem 4 GPA",
        "Sem 5 GPA", "Sem 6 GPA", "Sem 7 GPA", "Sem 8 GPA"
    }
));

table.setBorder(new MatteBorder(0, 0, 0, 0, new Color(0, 0, 0)));

// Disable auto-resizing
table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

// Set custom column widths
table.getColumnModel().getColumn(0).setPreferredWidth(150);  // First Name
table.getColumnModel().getColumn(1).setPreferredWidth(150);  // Surname
table.getColumnModel().getColumn(2).setPreferredWidth(50);// Age
table.getColumnModel().getColumn(3).setPreferredWidth(50);//GENDER
table.getColumnModel().getColumn(4).setPreferredWidth(50);//CONTNO
table.getColumnModel().getColumn(5).setPreferredWidth(50);//YOJ
table.getColumnModel().getColumn(6).setPreferredWidth(50);//ID
table.getColumnModel().getColumn(7).setPreferredWidth(150);//DEPT
table.getColumnModel().getColumn(8).setPreferredWidth(50);//CLASS
table.getColumnModel().getColumn(9).setPreferredWidth(50);//FATHNO
table.getColumnModel().getColumn(10).setPreferredWidth(50);//MOTHNO
table.getColumnModel().getColumn(11).setPreferredWidth(50);//SEM1
table.getColumnModel().getColumn(12).setPreferredWidth(50);//SEM2
table.getColumnModel().getColumn(13).setPreferredWidth(50);//SEM3
table.getColumnModel().getColumn(14).setPreferredWidth(50);//SEM4
table.getColumnModel().getColumn(15).setPreferredWidth(50);//SEM5
table.getColumnModel().getColumn(16).setPreferredWidth(50);//SEM6
table.getColumnModel().getColumn(17).setPreferredWidth(50);//SEM7
table.getColumnModel().getColumn(18).setPreferredWidth(50);//SEM8
table.getColumnModel().getColumn(19).setPreferredWidth(50);//DOB

// Set the rest of the columns accordingly

// Wrap the table in a JScrollPane
JScrollPane scrollPane = new JScrollPane(table);
scrollPane.setBounds(349, 380, 900, 250); // Adjust this size as needed
scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

// Add the scroll pane (with the table inside it) to the content pane
contentPane.add(scrollPane);

/*comboBox = new JComboBox();

comboBox.setBackground(new Color(224, 255, 255));

comboBox.addActionListener(new ActionListener() {

public void actionPerformed(ActionEvent e) {

String query = "SELECT * from studentdatamgmt where FirstName=?";

try {

PreparedStatement ps = conn.prepareStatement(query);

ps.setString(1, String.valueOf(comboBox.getSelectedItem()));

ResultSet rs = ps.executeQuery();


if(rs.next()) {

tf1.setText(rs.getString("FirstName"));

tf2.setText(rs.getString("Surname"));

tf3.setText(rs.getString("Age"));

tf4.setText(rs.getString("DateOfBirth"));

tf5.setText(rs.getString("contactNo"));

tf6.setText(rs.getString("YearOfJoin"));

tf7.setText(rs.getString("Id"));

tf8.setText(rs.getString("FatherName"));

tf9.setText(rs.getString("MotherName"));

sem1Field.setText(rs.getString("Sem 1"));

sem2Field.setText(rs.getString("Sem 2"));

sem3Field.setText(rs.getString("Sem 3"));

sem4Field.setText(rs.getString("Sem 4"));

sem5Field.setText(rs.getString("Sem 5"));

sem6Field.setText(rs.getString("Sem 6"));

sem7Field.setText(rs.getString("Sem 7"));

sem8Field.setText(rs.getString("Sem 8"));

}

} catch (SQLException e1) {

// TODO Auto-generated catch block

e1.printStackTrace();

}

}

});

comboBox.setBounds(597, 105, 237, 33);

contentPane.add(comboBox);*/
JTextField idTextField = new JTextField();
idTextField.setBackground(new Color(224, 255, 255));

// Add ActionListener to the text field to fetch data when an ID is entered
idTextField.addActionListener(new ActionListener() {
    private String totalArrears;

	public void actionPerformed(ActionEvent e) {
        String studentID = idTextField.getText(); // Get the ID from the text field
        if (studentID.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please enter a valid ID");
            return;
        }

        String query = "SELECT * FROM studentdatamgmt WHERE Id=?";
        try {
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, studentID); // Set the ID parameter
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
            	// Fetch total arrear data
                int totalArrears = rs.getInt("TotArr");

                // Display total arrears in the JTextArea (Arrear Summary Box)
                arrearSummary.setText("Arrear Summary for Student ID: " + studentID + "\n");
                arrearSummary.append("Total Arrears: " + totalArrears);
                // Populate fields with database data
                tf1.setText(rs.getString("FirstName"));
                tf2.setText(rs.getString("Surname"));
                tf3.setText(rs.getString("Age"));
                tf4.setText(rs.getString("DateOfBirth"));
                tf5.setText(rs.getString("ContactNo"));
                tf6.setText(rs.getString("YearOfJoin"));
                tf7.setText(rs.getString("Id"));
                tf8.setText(rs.getString("FatherName"));
                tf9.setText(rs.getString("MotherName"));
                

                sem1Field.setText(rs.getString("Sem1"));
                sem2Field.setText(rs.getString("Sem2"));
                sem3Field.setText(rs.getString("Sem3"));
                sem4Field.setText(rs.getString("Sem4"));
                sem5Field.setText(rs.getString("Sem5"));
                sem6Field.setText(rs.getString("Sem6"));
                sem7Field.setText(rs.getString("Sem7"));
                sem8Field.setText(rs.getString("Sem8"));

                tf11.setText(rs.getString("Gender"));
                tf12.setText(rs.getString("Department"));

             // Handle photo retrieval from BLOB column
                Blob photoBlob = rs.getBlob("Photo");
                if (photoBlob != null) {
                    InputStream inputStream = photoBlob.getBinaryStream();
                    BufferedImage img = ImageIO.read(inputStream); // Read the image
                    if (img != null) {
                        ImageIcon photoIcon = new ImageIcon(img.getScaledInstance(photoLabel.getWidth(), photoLabel.getHeight(), Image.SCALE_SMOOTH));
                        photoLabel.setIcon(photoIcon);  // Display the image in the photoLabel
                    } else {
                        photoLabel.setIcon(null); // If image reading failed, clear the photo label
                    }
                } else {
                    photoLabel.setIcon(null); // If no photo is available, clear the photo label
                }
           
      
            
            } else {
                JOptionPane.showMessageDialog(null, "No record found for the given ID");
            }
        } catch (SQLException | IOException e1) {
            e1.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error fetching data: " + e1.getMessage());
        }
    }
});

// Set bounds for the JTextField
idTextField.setBounds(597, 105, 237, 33);
contentPane.add(idTextField);


tf10 = new JTextField();

tf10.setBackground(new Color(224, 255, 255));

tf10.setToolTipText("Search Here");

tf10.addKeyListener(new KeyAdapter() {

@Override

public void keyReleased(KeyEvent e) {

String q ="Select * from studentdatamgmt where FirstName =?";

try {

PreparedStatement ps = conn.prepareStatement(q);

ps.setString(1, tf10.getText());

ResultSet rs = ps.executeQuery();

table.setModel(DbUtils.resultSetToTableModel(rs));

} catch (SQLException e1) {

// TODO Auto-generated catch block

e1.printStackTrace();

}

}

});

tf10.setBounds(869, 106, 380, 31);

contentPane.add(tf10);

tf10.setColumns(10);


tf11 = new JTextField();

tf11.setBackground(new Color(224, 255, 255));

tf11.setBounds(166, 291, 49, 26);

contentPane.add(tf11);

tf11.setColumns(10);


JLabel lblNewLabel_3 = new JLabel("M/F/O");

lblNewLabel_3.setForeground(new Color(34, 139, 34));

lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 16));

lblNewLabel_3.setBounds(218, 289, 64, 33);

contentPane.add(lblNewLabel_3);


tf12 = new JTextField();

tf12.setBackground(new Color(224, 255, 255));

tf12.setForeground(new Color(0, 0, 0));

tf12.setBounds(166, 443, 57, 26);

contentPane.add(tf12);

tf12.setColumns(10);


JLabel lblNewLabel_4 = new JLabel("CS / IT");

lblNewLabel_4.setForeground(new Color(0, 128, 128));

lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 18));

lblNewLabel_4.setBounds(233, 443, 67, 23);

contentPane.add(lblNewLabel_4);

}



 

private void storeArrearsInDatabase(String semester, int arrearCount) {
	// TODO Auto-generated method stub
	
}


/*protected void saveStudentData() {
    String uploadedPhotoPath;
	// Check if the photo has been selected
    if (uploadedPhotoPath != null && !uploadedPhotoPath.isEmpty()) {
        try {
            // Convert the image file to byte[] for storage in the database
            File imageFile = new File(uploadedPhotoPath);
            FileInputStream fis = new FileInputStream(imageFile);
            byte[] photoBytes = new byte[(int) imageFile.length()];
            fis.read(photoBytes);
            fis.close();
            
            // Get other student details from input fields
            String firstName = tf1.getText();
            String surname = tf2.getText();
            int age = Integer.parseInt(tf3.getText());
            String dob = tf4.getText(); // Assuming DateOfBirth is a string in your input
            String gender = tf11.getText();
            String contactNo = tf6.getText();
            int yearOfJoin = Integer.parseInt(tf7.getText());
            String department = tf12.getText();
            String className = String.valueOf(comboBox_1.getSelectedItem());
            String fatherName = tf8.getText();
            String motherName = tf9.getText();
            
            // Get semester details
            int sem1 = Integer.parseInt(sem1Field.getText());
            int sem2 = Integer.parseInt(sem2Field.getText());
            int sem3 = Integer.parseInt(sem3Field.getText());
            int sem4 = Integer.parseInt(sem4Field.getText());
            int sem5 = Integer.parseInt(sem5Field.getText());
            int sem6 = Integer.parseInt(sem6Field.getText());
            int sem7 = Integer.parseInt(sem7Field.getText());
            int sem8 = Integer.parseInt(sem8Field.getText());

            // SQL query to insert data into the database
            String query = "INSERT INTO studentdatamgmt (FirstName, Surname, Age, DateOfBirth, Gender, ContactNo, YearOfJoin, Department, Class, FatherName, MotherName, Sem1, Sem2, Sem3, Sem4, Sem5, Sem6, Sem7, Sem8, Photo) "
                    + "VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

            // Prepare the statement
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setString(1, firstName);
            pstmt.setString(2, surname);
            pstmt.setInt(3, age);
            pstmt.setString(4, dob);
            pstmt.setString(5, gender);
            pstmt.setString(6, contactNo);
            pstmt.setInt(7, yearOfJoin);
            pstmt.setString(8, department);
            pstmt.setString(9, className);
            pstmt.setString(10, fatherName);
            pstmt.setString(11, motherName);
            pstmt.setInt(12, sem1);
            pstmt.setInt(13, sem2);
            pstmt.setInt(14, sem3);
            pstmt.setInt(15, sem4);
            pstmt.setInt(16, sem5);
            pstmt.setInt(17, sem6);
            pstmt.setInt(18, sem7);
            pstmt.setInt(19, sem8);
            pstmt.setBytes(20, photoBytes); // Add photo bytes to the query
            
            // Execute the insert
            int rowsInserted = pstmt.executeUpdate();
            
            if (rowsInserted > 0) {
                JOptionPane.showMessageDialog(null, "Student Data Saved Successfully");
            } else {
                JOptionPane.showMessageDialog(null, "Failed to Save Student Data");
            }
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error saving student data: " + e.getMessage());
        }
    } else {
        JOptionPane.showMessageDialog(null, "Please select a photo!");
    }
}*/


protected void showData() {

// TODO Auto-generated method stub

String query = "Select * from studentdatamgmt";

try {

Statement stmt = conn.createStatement();

ResultSet rs = stmt.executeQuery(query);


table.setModel(DbUtils.resultSetToTableModel(rs));

} catch (SQLException e1) {

// TODO Auto-generated catch block

e1.printStackTrace();

}


}


protected String getDepartment() {

// TODO Auto-generated method stub

if(r4.isSelected())

return"CS";

else if(r5.isSelected())

return"IT";

else

return"NULL";

}

}