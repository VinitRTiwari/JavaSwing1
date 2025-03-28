import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;


import javax.swing.*;

public class Hotel{
    
    public Hotel(){
        JFrame frame1 = new JFrame();
        frame1.setSize(800,600);
        frame1.setResizable(false);
        frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        frame1.setLayout(new GridBagLayout());

        GridBagConstraints gc = new GridBagConstraints();
        gc.insets = new Insets(10,10,10,10);

        JLabel label1 = new JLabel("Welcome to my interface design........");
        label1.setFont(new Font("Times Of India",Font.BOLD,25));
        gc.gridx = 0;
        gc.gridy = 0;
        gc.anchor = GridBagConstraints.CENTER;
        frame1.add(label1,gc);

        JTextField txt1 = new JTextField();
        gc.gridx = 0;
        gc.gridy = 1;
        gc.anchor = GridBagConstraints.CENTER;
        gc.fill = GridBagConstraints.HORIZONTAL;
        txt1.setFont(new Font("Times Of India",Font.BOLD,25));
        txt1.addKeyListener(new KeyAdapter() {
            public void keyReleased(KeyEvent e){
                label1.setText("I'm writing something....! ");
            }
            
        });
        txt1.addKeyListener(new KeyAdapter() {
            
            public void keyPressed(KeyEvent e){
                label1.setText(label1.getText() + "I'm writing something....! ");
            }
            
        });
        //txt1.setVisible(true);
        frame1.add(txt1,gc);
        
        JButton btn1 = new JButton("Submit....");
        btn1.setFont(new Font("Arial", Font.BOLD, 25));
        gc.gridx = 0;
        gc.gridy = 3;
        gc.anchor = GridBagConstraints.CENTER;
        gc.fill = GridBagConstraints.HORIZONTAL;
        btn1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                JOptionPane.showMessageDialog(btn1, txt1.getText());
            }
        }
        );
        frame1.add(btn1,gc);



        frame1.setVisible(true);
    }





    public static void main(String[] args) {
        new Hotel();
    }
}