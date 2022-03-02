/*
Approach:
1.First, we need to create a frame using JFrame.
2.Then, create two labels, two text fields and three buttons(the first button for rupees and the second button is for the dollar) using JLabel,
JTextField and JButton.
3.Name these components accordingly and set their bounds.
4.Now, in order to perform the conversion on button click, we need to add Event Handlers. In this case, we will add ActionListener
to perform an action method known as actionPerformed in which 
5.first we need to get the values from the text fields which is default as a “string”.
6.So, in order to perform mathematical operations, we need to convert them into double data type using Double.parseDouble(Object.getText())
7.and again converting from double to string to place the final value in the other text field using String.valueOf(object).
8.Finally, for changing the values, we use Object.setText(object), the second object is for selecting which field we want to replace.
*/

/*
 1. javax.swing.* It is used to create window-based applications which makes it suitable for developing lightweight desktop applications.
 Java Swing is built on top of an abstract windowing toolkit API purely written in Java programming language

 2. java.awt.event.* Contains all the classes for creating user interfaces and for painting graphics and images.

 */

import javax.swing.*;
import java.awt.event.*;
public class CodeXam {
    public static void converter() //converter function
    {
        // Creating a new frame using JFrame

        /*JFrame is a top-level container that provides a window on the screen.
          A frame is actually a base window on which other components rely,
          namely the menu bar, panels, labels, text fields, buttons, etc.
          Almost every other Swing application starts with the JFrame window.*/

        JFrame f = new JFrame("CONVERTER");

        // Creating two labels
        JLabel label_1,label_2;

        // Creating two text fields.
        // One for rupee and one for the dollar
        JTextField t1_text, t2_text;

        // Creating three buttons
        JButton b1_Inr, b1_Dlr, b3_Close; //inr dollar and close 

        // Naming the labels and setting
        // the bounds for the labels

        label_1 = new JLabel("Rupees:");//Parameter text as Rupees
        label_1.setBounds(20, 40, 60, 30); //The setBounds() method is used in such a situation to set the position and size
        label_2 = new JLabel("Dollars:");//Parameter text as Dollar
        label_2.setBounds(170, 40, 60, 30);

        // Initializing the text fields with
        // 0 by default and setting the
        // bounds for the text fields
        t1_text = new JTextField("0");
        t1_text.setBounds(80, 40, 50, 30);
        t2_text = new JTextField("0");
        t2_text.setBounds(240, 40, 50, 30);

        // Creating a button for INR,
        // one button for the dollar
        // and one button to close
        // and setting the bounds
        b1_Inr = new JButton("INR");//Parameter text as INR
        b1_Inr.setBounds(50, 80, 60, 15);
        b1_Dlr = new JButton("Dollar");//Parameter text as Dollar
        b1_Dlr.setBounds(190, 80, 60, 15);
        b3_Close = new JButton("close");
        b3_Close.setBounds(150, 150, 60, 30);//Parameter text as close

        // Adding action listener

        /* ActionListener in Java is a class that is responsible for handling all action events such as when the user clicks on a component.
        Mostly, action listeners are used for JButtons. An ActionListener can be used by the implements' keyword to the class definition.*/

        b1_Inr.addActionListener(new ActionListener() { //new ActionListener() can be replaced with lambda like this b1_Inr.addActionListener(e -> {
            public void actionPerformed(ActionEvent e)
            {
                // Converting to double
                double d = Double.parseDouble(t1_text.getText()); //GetText returns the text from the single-line text field

                // Converting rupees to dollars
                double d1 = (d/75.08); // Now 1 United States Dollar equal 75.08 Indian Rupee ( 2:50 am Sunday, 27 February 2022 (IST) )

                // Getting the string value of the
                // calculated value
                String str1 = String.valueOf(d1);

                // Placing it in the text box
                t2_text.setText(str1);
            }
        });

        // Adding action listener
        b1_Dlr.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e)
            {
                // Converting to double
                double d2 = Double.parseDouble(t2_text.getText());//parseDouble() returns a primitive double value Text to value

                // converting Dollars to rupees
                double d3 = (d2 * 75.08);// Now 1 United States Dollar equal 75.08 Indian Rupee ( 2:50 am Sunday, 27 February 2022 (IST) )

                // Getting the string value of the
                // calculated value
                String str2 = String.valueOf(d3);

                // Placing it in the text box
                t1_text.setText(str2);
            }
        });

        // Action listener to close the form
        b3_Close.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e)
            {
                /*JFrame.dispose(); causes the JFrame window to be destroyed and cleaned up by the operating system.
                 According to the documentation, this can cause the Java VM to terminate if there are no other Windows available, 
                 but this should really just be seen as a side effect rather than the norm.*/
                f.dispose();
            }
        });

        // Default method for closing the frame
        f.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e)
            {
                System.exit(0);
            }
        });

        // Adding the created objects
        // to the form
        f.add(label_1);
        f.add(t1_text);
        f.add(label_2);
        f.add(t2_text);
        f.add(b1_Inr);
        f.add(b1_Dlr);
        f.add(b3_Close);

        f.setLayout(null);
        f.setSize(400, 300);
        f.setVisible(true);
    }

    // Driver code
    public static void main(String args[])
    {
        converter();
    }
}