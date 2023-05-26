import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import java.util.ArrayList;

import java.awt.Dimension;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JList;
import javax.swing.BorderFactory;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.border.Border;

public class W04Practical extends JFrame implements KeyListener{
    String line = "";
    static Autocomplete autocomplete;
    JFrame frame;
    JPanel firstPanel;
    JTextField textField;
    JList<String> list = new JList<String>();
    Border border = BorderFactory.createTitledBorder("Words");
    JScrollPane scroll = new JScrollPane();
    JButton btn = new JButton("Select Term");
    int number;

    public W04Practical(String fileName, String number) {

        this.number = Integer.parseInt(number);

        scroll.setViewportView(list);
        scroll.setBorder(border);
        scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

        firstPanel = new JPanel();

        frame = new JFrame();
        frame.setSize(300,300);

        textField = new JTextField(20);

        frame.add(textField,"North");
        Border empty = BorderFactory.createEmptyBorder();
        textField.setBorder(empty);
        textField.setSize(300,20);
        textField.setPreferredSize(new Dimension(200,25));
        textField.addKeyListener(this);


        list.setSize(300,280);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(scroll, BorderLayout.CENTER);

        frame.setVisible(true);

        try{
            BufferedReader reader = new BufferedReader(new FileReader(fileName));

            ArrayList<Term> terms = new ArrayList<Term>();
            reader.readLine(); //skip the first line

            //Saving all information in the array
            while(reader.ready()) {
                line = reader.readLine();
                String newLine = line.trim();
                String[] data = newLine.split("\t");

                Long weight = Long.parseLong(data[0]);
                String query = data[1];

                Term term = new Term(query, weight);

                terms.add(term);
            }

            Term[] array = new Term[terms.size()];
            array = terms.toArray(array);

            autocomplete = new Autocomplete(array);

            reader.close();
        } catch (FileNotFoundException e) {
            System.out.println("file not found");
        } catch (IOException e) {
            System.out.println();
        }
    }

    @Override
    public void keyTyped(KeyEvent a) {

    }

    @Override
    public void keyPressed(KeyEvent a) {

    }

    @Override
    public void keyReleased(KeyEvent a) {


        String inputString = textField.getText();

        btn.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                textField.setText(list.getSelectedValue());
            }

        });

        frame.add(btn,BorderLayout.SOUTH);
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        try {
            Term[] term = autocomplete.allMatches(inputString);
            ArrayList<String> temp = new ArrayList<>();
            if(number > 0) {

                //If the user input is larger then term.length
                //It would show the all words
                if(number > term.length) {
                    temp.add(autocomplete.numberOfMatches(inputString) + " words found ");

                    for (int x = 0; x < term.length; x++) {
                        temp.add(term[x].getQuery());
                    }
                    String[] newTemp = new String[0];
                    newTemp = temp.toArray(newTemp);

                    list.setListData(newTemp);
                } else {
                    temp.add(autocomplete.numberOfMatches(inputString) + " words found");

                    for (int x = 0; x < number; x++) {
                        temp.add(term[x].getQuery());
                    }
                    String[] newTemp = new String[0];
                    newTemp = temp.toArray(newTemp);

                    list.setListData(newTemp);
                }
            } else {
                //If the user input is less than zero (unexpected value)
                //It would show the all words
                temp.add(autocomplete.numberOfMatches(inputString) + " words found");

                for (int x = 0; x < term.length; x++) {
                    temp.add(term[x].getQuery());
                }

                String[] newTemp = new String[0];
                newTemp = temp.toArray(newTemp);

                list.setListData(newTemp);
            }

        } catch (NegativeArraySizeException e){
            String[] temp = new String[1];
            temp[0] = "None Found";
            list.setListData(temp);
        } catch (ArrayIndexOutOfBoundsException e){
            String[] temp = new String[1];
            temp[0] = "None Found";
            list.setListData(temp);
        } catch (NullPointerException e) {
            System.exit(0);
        }



    }

    public static void main(String[] args) {
        try {

            W04Practical practical = new W04Practical(args[0], args[1]);

        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Usage: <input_file.txt> <Integer>");
        } catch (NumberFormatException e) {
            System.out.println("Usage: <input_file.txt> <Integer>");
            System.out.println("Please input the Integer");
        }
    }

}
