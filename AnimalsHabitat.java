/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zoomonitor;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.*;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class AnimalsHabitat {
    //private String filePath;
    final private Scanner scnr;

    public AnimalsHabitat() {
       //did not use file path, put the .txt files next to my .java files
        //filePath = "";
        scnr = new Scanner(System.in);
    }

    public void askForWhichDetails(String fileName) throws IOException {
        FileInputStream fileByteStream = null; // File input stream
        Scanner inFS = null;                   // Scanner object

        String textLine = null;
        ArrayList aList1 = new ArrayList();

        int i = 0;
        int option = 0;

        boolean bailOut = false;

        // Try to open file the has the "animal" or "habitat" options
        fileByteStream = new FileInputStream(fileName + ".txt");
        inFS = new Scanner(fileByteStream);

        while (inFS.hasNextLine() && bailOut == false) {
            textLine = inFS.nextLine();
            //if a line contained detiails, add to list
            if (textLine.contains("Details")) {
                i += 1;
                System.out.println(i + ". " + textLine);

                ArrayList aList2 = new ArrayList();

                for (String retval : textLine.split(" ")) {
                    aList2.add(retval);
                }

                String str = aList2.remove(2).toString();
                aList1.add(str);
            } else {
                System.out.print("Enter selection: ");
                option = scnr.nextInt();

                System.out.println("");

                if (option <= i) {
                    String detailOption = aList1.remove(option - 1).toString();
                    showData(fileName, detailOption);

                    bailOut = true;
                }

                break;
            }
        }

        // Done with file, so try to close it
        fileByteStream.close(); // close() may throw IOException if fails  
    }

    public void showData(String fileName, String detailOption) throws IOException {
        FileInputStream fileByteStream = null; // File input stream
        Scanner inFS = null;                   // Scanner object      

        String textLine = null;
        String lcTextLine = null;
        String alertMessage = "*****";

        int lcStr1Len = fileName.length();
        String lcStr1 = fileName.toLowerCase().substring(0, lcStr1Len - 1);

        int lcStr2Len = detailOption.length();
        String lcStr2 = detailOption.toLowerCase().substring(0, lcStr2Len - 1);

        boolean bailOut = false;

        // Try to open file 
        fileByteStream = new FileInputStream(fileName + ".txt");
        inFS = new Scanner(fileByteStream);

        while (inFS.hasNextLine() && bailOut == false) {
            textLine = inFS.nextLine();
            lcTextLine = textLine.toLowerCase();

            if (lcTextLine.contains(lcStr1) && lcTextLine.contains(lcStr2)) {
                do {
                    System.out.println(textLine);

                    textLine = inFS.nextLine();
                    if (textLine.isEmpty()) {
                        bailOut = true;
                    }
                   //area for the alert message. If a line had the alert message,
                   //('*****'), display a message to the user 
                    if (textLine.contains(alertMessage)) {
                        System.out.println(textLine.substring(5));
                        //alertMessage = textLine.substring(5);
                        //textLine = inFS.nextLine();
                        //System.out.println(textLine);
                        //System.out.println();
                        JFrame popUP = new JFrame();
                        popUP.setAlwaysOnTop(true);
                        //JOptionPane.showMessageDialog(popUP, alertMessage, "WARNING", JOptionPane.WARNING_MESSAGE);
                        JOptionPane.showMessageDialog(popUP,textLine.substring(5));                      
                        bailOut= true;
                        break;
                    }

                } while (inFS.hasNextLine() && bailOut == false);
            }
        }

        // Done with file, so try to close it
        fileByteStream.close(); // close() may throw IOException if fails      
    }
}
