/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package marquee;

import java.awt.BorderLayout;
import java.awt.event.ActionListener;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.Timer;

/**
 *
 * @author Dan
 */
public class Marquee extends JFrame implements Runnable {

    Thread th;
    private boolean IsStoped = false;
    JLabel label = new JLabel();
    JLabel labell = new JLabel();
    private final String s;

    public Marquee() {
        this.setTitle("Date & Time Frame Application");
        label.setHorizontalAlignment(JLabel.LEFT);

        this.add(label, BorderLayout.EAST);

        th = new Thread(this);
        th.start();
        s = "nour";
        label.setText(s); //labell.setText(s);
        this.add(label);
        //this.add(labell);

    }

    public static void main(String[] args) {
            System.out.println("Classloader of this class:"+Marquee.class.getClassLoader()); 
        Marquee app = new Marquee();
        app.setBounds(50, 50, 600, 400);
        app.setVisible(true);
    }

    /* @Override
    public void run() {
        while (true) {
          
            label.setText(s);
         
            try {
                Thread.sleep(50);
            } catch (Exception ex) {
                Logger.getLogger(Test.class.getName()).log(Level.SEVERE, null, ex);
            }
            label.setLocation(label.getLocation().x+3, 0);
            labell.setLocation(label.getLocation().x+3, MAXIMIZED_VERT);
         
            
                    
        }
    }
}
     */
    @Override
    public void run() {
        //Marqueue
        label.setLocation(this.getSize().width, 0);
        while (!IsStoped) {
            if (label.getLocation().x < 0) {
                int x = this.getSize().width-100;
                int y = 0;
                label.setLocation(x, y);
            } else {
                int x = label.getLocation().x - 1;
                int y = 0;
                label.setLocation(x, y);
            }
            try {
                Thread.sleep(30);
            } catch (Exception exc) {
            }
        }

    }
}
