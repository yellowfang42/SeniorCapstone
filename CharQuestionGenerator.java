package charquestiongenerator;
/**
 *
 * @author Lindsie Olsen
 */
import java.awt.event.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


public class CharQuestionGenerator extends JButton implements ActionListener{
    
    private JRadioButton r1,r2,r3;
    public void init() {
        // load interface
        JFrame frame = new JFrame("Character Question Generator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 400);
        JPanel panel = new JPanel();
        frame.getContentPane();
        //create buttons
        r1 = new JRadioButton("1");
        r2 = new JRadioButton("5");
        r3 = new JRadioButton("10");
        Dimension size1 = r1.getPreferredSize();
        Dimension size2 = r2.getPreferredSize();
        Dimension size3 = r3.getPreferredSize();
        //place buttons
        r1.setBounds(75,50,size1.width,size1.height);
        r2.setBounds(75,100,size2.width,size2.height);
        r3.setBounds(75,150,size3.width,size3.height);
        //button to initiate generator//
        JButton gen = new JButton("Generate Questions!");
        Dimension size4 = gen.getPreferredSize();
        gen.setBounds(100, 200, size4.width, size4.height);
        gen.addActionListener(this);
        panel.setLayout(null);
        panel.add(r1);
        panel.add(r2);
        panel.add(r3);
        panel.add(gen);
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        //make this visible
        frame.add(panel);
        frame.setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent e){
        if(r1.isSelected()){
            r2.setSelected(false);
            r3.setSelected(false);
            JOptionPane.showMessageDialog(r1, callUp(1));
        }
        
        if(r2.isSelected()){
            r1.setSelected(false);
            r3.setSelected(false);
            JOptionPane.showMessageDialog(r2, callUp(5));
        }
        
        if(r3.isSelected()){
            r2.setSelected(false);
            r1.setSelected(false);
            JOptionPane.showMessageDialog(r3, callUp(10));
        }
    }
    
    //god has forsaken me i tried to make this pretty but nooooo
    public String callUp(int numberOfElements){
        charQuestData obj = new charQuestData();
        java.util.List<String> quotes = obj.randomOne(getQuestions2(), numberOfElements);
        String strquotes = "";
        for (String quote : quotes){
            strquotes = strquotes + quote + "\n";
        }
        return strquotes;
    }
    
    public java.util.List<String> getQuestions2(){
        java.util.List<String> quests = new ArrayList<>();
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(
                    "/Users/Lindsie/Documents/questionfile.txt"));
            String line = reader.readLine();
            while (line != null){
                quests.add(line);
                line = reader.readLine();
            }
            reader.close();
        } catch (IOException e){
            e.printStackTrace();
        }
        
        return quests;
    }
    
    public void randomOne(java.util.List<String> quests, int totalItems) {
        Random rand = new Random();
        //java.util.List<String> newList = new ArrayList<>();
        for (int i=0; i<totalItems; i++){
            int randomIndex = rand.nextInt(quests.size());
            System.out.println(quests.get(randomIndex));
            //newList.add(quests.get(randomIndex));
            //quests.remove(randomIndex);
        }
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // run
        new CharQuestionGenerator().init();    
    }
    
}
