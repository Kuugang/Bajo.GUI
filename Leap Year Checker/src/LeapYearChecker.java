import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
