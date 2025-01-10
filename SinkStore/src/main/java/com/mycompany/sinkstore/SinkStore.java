/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.sinkstore;

/**
 *
 * @author User
 */
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import java.util.ArrayList;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.text.DecimalFormat;
//import java.util.InputMismatchException;

/**
 * Template database GUI with three labels, fields and save btn
 */
public class SinkStore extends JFrame implements ActionListener {

    public static void main(String[] args) {
        new SinkStore(); //Runs the GUI
    } // end main method 
    //idk java anymore

    private JLabel title, ad, label1, label2, label3, label4, inventory, sorts; //Jlabels for Text or Images
    private JTextArea display;
    private JTextField textField1, textField2, textField3, textField4; //for user input
    private JButton saveBtn, sortByBrand, sortByModel, sortByMat, sortByPrice; //button to click after user input, to save info
    private Font f = new Font("SansSerif", Font.BOLD, 36);
    private Font iF = new Font("SansSerif", Font.BOLD, 15);
    private ArrayList<Sink> sinks = new ArrayList<>();
    //private Book[] books = new Book[50]; //make an array of your objects for your database
    private String test = "Kindred, 3-Hole double bowl, Stainless Steel, $139.00";
    private static final DecimalFormat df = new DecimalFormat("#.##");

    public SinkStore() {
        {
        setSize(1600, 1000);
        setLayout(null);
        Container c = getContentPane(); //instead of a JPanel - easier to set coordinated of labels, textFields and buttons
        c.setBackground(new Color(0, 0, 0, 20));

        title = new JLabel("The Sink Store");
        title.setFont(f);
        title.setBounds(660, 40, 300, 60);
        c.add(title);

        ad = new JLabel("Add a New sink:");
        ad.setFont(f);
        ad.setBounds(10, 150, 300, 45);
        c.add(ad);

        label1 = new JLabel("Brand: ");
        label1.setFont(f);
        label1.setBounds(10, 200, 300, 40);
        c.add(label1);
        textField1 = new JTextField("Enter text");
        textField1.setFont(f);
        //titleField.setText("type");
        textField1.setBounds(200, 200, 200, 40);
        c.add(textField1);

        label2 = new JLabel("Model: ");
        label2.setBounds(10, 300, 300, 40);
        label2.setFont(f);
        c.add(label2);
        textField2 = new JTextField("Enter text:");
        textField2.setFont(f);
        textField2.setBounds(200, 300, 200, 40);
        c.add(textField2);

        label3 = new JLabel("Material: ");
        label3.setBounds(10, 400, 300, 40);
        label3.setFont(f);
        c.add(label3);
        textField3 = new JTextField("那天");
        textField3.setFont(f);
        textField3.setBounds(200, 400, 200, 40);
        c.add(textField3);

        label4 = new JLabel("Price: ");
        label4.setBounds(10, 500, 200, 40);
        label4.setFont(f);
        c.add(label4);
        textField4 = new JTextField("加吃嗯");
        textField4.setFont(f);
        textField4.setBounds(200, 500, 200, 40);
        c.add(textField4);

//        为了 (整数 i = 0; 整数 < 大批.长度; i++){
//        系统.出.打印(大批[i]);
//    }
        saveBtn = new JButton("SAVE");
        saveBtn.setBounds(200, 600, 200, 50);
        saveBtn.setFont(f);
        //saveBtn.setBackground(new Color(0, 0, 200, 60));
        saveBtn.addActionListener(this);
        c.add(saveBtn);

        inventory = new JLabel("What we have:");
        inventory.setBounds(665, 150, 400, 45);
        inventory.setFont(f);
        c.add(inventory);

//        String test = "Kindred, 3-Hole double bowl, Stainless Steel, $139.00"; 
        display = new JTextArea("");
        display.setLineWrap(true);
        display.setEditable(false);
        display.setBounds(450, 200, 700, 600);
        display.setFont(iF);
        freakyFunction();
        c.add(display);

        sorts = new JLabel("Sort Sinks By:");
        sorts.setBounds(1190, 150, 250, 45);
        sorts.setFont(f);
        c.add(sorts);

        sortByBrand = new JButton("Brand");
        sortByBrand.setBounds(1200, 200, 200, 40);
        sortByBrand.setFont(f);
        sortByBrand.addActionListener(this);
        c.add(sortByBrand);

        sortByModel = new JButton("Model");
        sortByModel.setBounds(1200, 300, 200, 40);
        sortByModel.setFont(f);
        sortByModel.addActionListener(this);
        c.add(sortByModel);

        sortByMat = new JButton("Material");
        sortByMat.setBounds(1200, 400, 200, 40);
        sortByMat.setFont(f);
        sortByMat.addActionListener(this);
        c.add(sortByMat);

        sortByPrice = new JButton("Price");
        sortByPrice.setBounds(1200, 500, 200, 40);
        sortByPrice.setFont(f);
        sortByPrice.addActionListener(this);
        c.add(sortByPrice);

        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
}
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        double p = 0;
//        int count = 0;
        if (e.getSource() == saveBtn) {
            //  String t = textField1.getText();
            System.out.println("brand field: " + textField1.getText()); 
//temporary - to check if we got the info from the textField
            System.out.println("model field: " + textField2.getText());
            System.out.println("material field: " + textField3.getText());

            try {
                p = Double.valueOf(textField4.getText());
                if (p < 0) {
                    p = 10.0;
                }
                p = Double.parseDouble(df.format(p));
//stole this from https://mkyong.com/java/how-to-round-double-float-value-to-2-decimal-points-in-java/
                System.out.println("price field: " + p);
            } catch (NumberFormatException er) {
                System.out.println("ERROR FOR PRICE INPUT. DEFAULT PRICE: $10");
                p = 10.0;
            }
            {
//            sinks.add(new Sink(textField1.getText(), textField2.getText(), textField3.getText(), p) );  
                //this gets cleared because afterwards, the writeToSinks() function is called
                //, which calls the readFromSinks() function which clears the arrayList

//use a try-catch to only consider valid inputs//next, call the Sink constructor and pass these through
            }//random comments
            readFromSinks();
            //MAKE THIS INTO A WRITING FUNCITON, AND ALSO MAKE A SEPERATE READING FUNCTION
            sinks.add(new Sink(textField1.getText(), textField2.getText(), textField3.getText(), (p)));
            writeToSinks();
            {
                //add this to textfile
                //first read what's already in there, store that in array, 
                //add this to array, then write whole array to textfile
                //then close the textfile, read it, and write it to display JTextArea

                //String a = textField2.getText();
                //int c = Integer.parseInt(textField3.getText());
                //make object
                //check object with System.out.print
                //Write to textfiles
            }    //random comments

        } else if (e.getSource() == sortByBrand) {
//            test = "加吃嗯";
//            display.setText(test);
//display.append("\nTest");
//readFromSinks();
sortBrand(sinks);
        }
        else if (e.getSource() == sortByModel){
        sortModel(sinks);
        }
        else if (e.getSource() == sortByMat){
            sortMaterial(sinks);
        }

        else if (e.getSource() == sortByPrice) {
            sortPrice(sinks);
        }

        System.out.println("A button has been pressed. Do file shit.");
        freakyFunction();
    }

    public void writeToSinks() {

//        readFromSinks();
        //add the new sinks to the arraylist populated in readFromSinks()
        //before writing to file
        try {
            FileWriter fw = new FileWriter("sinks.txt");
            PrintWriter pw = new PrintWriter(fw);

            int size = sinks.size();
            for (int i = 0; i < size; i++) {
                pw.print(sinks.get(i));
                if (i < size - 1) {
                    pw.println(); // Print a newline character
                }
            }

            pw.close();
        } catch (IOException err) {
            System.out.println("Error writing to file. Boohoo.");
        }
    }

    public void readFromSinks() {

        sinks.clear();      //this was causing issues
        Sink.setNumSinks(0);

        try {
            String line;
            FileReader fr = new FileReader("sinks.txt");
            BufferedReader br = new BufferedReader(fr);
            line = br.readLine();
            while (line != null) {
                String[] parts = line.split(",");
                if (parts.length == 5) { // Ensure the line has all required parts
                    String brand = parts[0];
                    String model = parts[1];
                    String material = parts[2];
                    double price = Double.parseDouble(parts[3]);
                    int serialNumber = Integer.parseInt(parts[4]);

                    // Create a new Sink object using the extracted parts
                    Sink sink = new Sink(brand, model, material, price);

                    //   System.out.println(sink);
                    sinks.add(sink);
                } else {
                    System.err.println("Invalid line format: " + line);
                }
                line = br.readLine();
            }
        } catch (IOException err) {
            System.out.println("Error reading from file. Boohoo.");
        }
    }

    public void freakyFunction() {   //display stuff on JTextArea
        display.selectAll();
        display.replaceSelection("");

        readFromSinks();

        for (int i = 0; i < sinks.size(); i++) {
            display.append(sinks.get(i) + "\n");
        }
    }

    public void sortPrice(ArrayList<Sink> s) {
        Sink temp;

        for (int i = 0; i < s.size(); i++) {
            for (int j = 0; j < s.size() - i - 1; j++) {
                if (s.get(j + 1).getPrice() < s.get(j).getPrice()) {
                    temp = s.get(j + 1);
                    s.set((j + 1), s.get(j));
                    s.set(j, temp);
                }
            }
        }
        writeToSinks();//this rearranges shit in my file as well. that's alright. 
        //nothing matters, but maybe that's a good thing :).
    }
    
    public void sortBrand(ArrayList<Sink> s){
        Sink temp;
        for (int i = 0; i < s.size(); i++) {
            for (int j = 0; j < s.size() - i - 1; j++) {
                if ( (s.get(j + 1).getBrand()).compareToIgnoreCase(s.get(j).getBrand()) < 0) {
                    temp = s.get(j + 1);
                    s.set((j + 1), s.get(j));
                    s.set(j, temp);
                }
            }
        }
        
        writeToSinks();
        
    }
    
    public void sortModel(ArrayList<Sink> s){
        Sink temp;
        for (int i = 0; i < s.size(); i++) {
            for (int j = 0; j < s.size() - i - 1; j++) {
                if ( (s.get(j + 1).getModel()).compareToIgnoreCase(s.get(j).getModel()) < 0) {
                    temp = s.get(j + 1);
                    s.set((j + 1), s.get(j));
                    s.set(j, temp);
                }
            }
        }
        
        writeToSinks();
        
    }
    
    public void sortMaterial(ArrayList<Sink> s){
        Sink temp;
        for (int i = 0; i < s.size(); i++) {
            for (int j = 0; j < s.size() - i - 1; j++) {
                if ( (s.get(j + 1).getMaterial()).compareToIgnoreCase(s.get(j).getMaterial()) < 0) {
                    temp = s.get(j + 1);
                    s.set((j + 1), s.get(j));
                    s.set(j, temp);
                }
            }
        }
        
        writeToSinks();
        
    }
    
    
//    public void freakySort(ArrayList<Sink> s){
//       
//    }

}
