import org.w3c.dom.css.RGBColor;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class LeapYearChecker extends JFrame{
    JPanel jPanel;
    private JTextField tfYear;
    private JButton btnCheckYear;

    public LeapYearChecker(){
        this.setContentPane(this.jPanel);
        this.setSize(1000, 600);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setTitle("Leap Year Checker");
        this.setVisible(true);


        btnCheckYear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showLeapYear();
            }
        });

        btnCheckYear.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
            }

            @Override
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                super.mouseReleased(e);
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                btnCheckYear.setBackground(Color.BLACK);
                btnCheckYear.setForeground(Color.WHITE);
                super.mouseEntered(e);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                btnCheckYear.setBackground(Color.WHITE);
                btnCheckYear.setForeground(Color.BLACK);
                super.mouseExited(e);
            }

            @Override
            public void mouseWheelMoved(MouseWheelEvent e) {
                super.mouseWheelMoved(e);
            }

            @Override
            public void mouseDragged(MouseEvent e) {
                super.mouseDragged(e);
            }

            @Override
            public void mouseMoved(MouseEvent e) {
                super.mouseMoved(e);
            }
        });
    }

    private void showLeapYear(){
        String yearText = tfYear.getText();
        if(yearText.length() == 0){
            JOptionPane.showMessageDialog(jPanel, "Please input year");
            return;
        }
        int year;
        try{
            year = Integer.parseInt(yearText);
        }catch (Exception e){
            JOptionPane.showMessageDialog(jPanel, "Invalid input");
            return;
        }
        if(isLeap(year)){
           JOptionPane.showMessageDialog(jPanel, "Leap year");
        }else{
           JOptionPane.showMessageDialog(jPanel, "Not a leap year");
        }
    }


    private boolean isLeap(int y){
        if((y % 400 == 0) ||
            (y % 100 != 0) && (y % 4 == 0)) {
                return true;
        }
        else{
            return false;
        }
    }
}
