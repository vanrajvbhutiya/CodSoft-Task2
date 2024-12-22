import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StudentGradeCalculator {

    public static void main(String[] args) {
        // Create and set up the window (JFrame)
        JFrame frame = new JFrame("Student Grade Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 400);
        frame.setLayout(new GridLayout(7, 2, 10, 10));

        // Create input fields for marks in each subject
        JLabel labelSubject1 = new JLabel("Subject 1 Marks:");
        JTextField subject1Field = new JTextField(5);
        
        JLabel labelSubject2 = new JLabel("Subject 2 Marks:");
        JTextField subject2Field = new JTextField(5);
        
        JLabel labelSubject3 = new JLabel("Subject 3 Marks:");
        JTextField subject3Field = new JTextField(5);
        
        JLabel labelSubject4 = new JLabel("Subject 4 Marks:");
        JTextField subject4Field = new JTextField(5);
        
        JLabel labelSubject5 = new JLabel("Subject 5 Marks:");
        JTextField subject5Field = new JTextField(5);

        // Create a button to trigger the calculation
        JButton calculateButton = new JButton("Calculate Grade");
        
        // Labels to display total marks, average percentage, and grade
        JLabel totalMarksLabel = new JLabel("Total Marks: ");
        JTextField totalMarksField = new JTextField(10);
        totalMarksField.setEditable(false);
        
        JLabel avgPercentageLabel = new JLabel("Average Percentage: ");
        JTextField avgPercentageField = new JTextField(10);
        avgPercentageField.setEditable(false);
        
        JLabel gradeLabel = new JLabel("Grade: ");
        JTextField gradeField = new JTextField(10);
        gradeField.setEditable(false);

        // Add components to the frame
        frame.add(labelSubject1);
        frame.add(subject1Field);
        
        frame.add(labelSubject2);
        frame.add(subject2Field);
        
        frame.add(labelSubject3);
        frame.add(subject3Field);
        
        frame.add(labelSubject4);
        frame.add(subject4Field);
        
        frame.add(labelSubject5);
        frame.add(subject5Field);
        
        frame.add(calculateButton);
        
        frame.add(totalMarksLabel);
        frame.add(totalMarksField);
        
        frame.add(avgPercentageLabel);
        frame.add(avgPercentageField);
        
        frame.add(gradeLabel);
        frame.add(gradeField);
        
        // Make the frame visible
        frame.setVisible(true);

        // Add action listener to the calculate button
        calculateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    // Get the marks from the text fields
                    int subject1 = Integer.parseInt(subject1Field.getText());
                    int subject2 = Integer.parseInt(subject2Field.getText());
                    int subject3 = Integer.parseInt(subject3Field.getText());
                    int subject4 = Integer.parseInt(subject4Field.getText());
                    int subject5 = Integer.parseInt(subject5Field.getText());

                    // Calculate total marks and average percentage
                    int totalMarks = subject1 + subject2 + subject3 + subject4 + subject5;
                    double averagePercentage = (double) totalMarks / 5;

                    // Calculate grade
                    String grade = "";
                    if (averagePercentage >= 90) {
                        grade = "A";
                    } else if (averagePercentage >= 80) {
                        grade = "B";
                    } else if (averagePercentage >= 70) {
                        grade = "C";
                    } else if (averagePercentage >= 60) {
                        grade = "D";
                    } else {
                        grade = "F";
                    }

                    // Display the results
                    totalMarksField.setText(String.valueOf(totalMarks));
                    avgPercentageField.setText(String.format("%.2f", averagePercentage));
                    gradeField.setText(grade);

                } catch (NumberFormatException ex) {
                    // Show an error message if input is not a valid integer
                    JOptionPane.showMessageDialog(frame, "Please enter valid marks (0-100).", 
                                                  "Input Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }
}
