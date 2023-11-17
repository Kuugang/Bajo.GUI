import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SimpleCalculator extends JFrame {

    private JPanel panel;
    private JTextField tfNumber1;
    private JComboBox cbOperations;
    private JTextField tfNumber2;
    private JLabel lblResult;
    private JButton btnCompute;

    public SimpleCalculator(){
        this.setContentPane(this.panel);
        this.setSize(1000, 600);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setTitle("Simple Calculator");
        this.setVisible(true);

        btnCompute.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    compute();
                } catch (Exception ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
    }

    void compute() throws Exception {


        String op = (String) cbOperations.getSelectedItem();

        String num1Text = tfNumber1.getText();
        String num2Text = tfNumber2.getText();
        if(num1Text.length() == 0 || num2Text.length() == 0) {
            JOptionPane.showMessageDialog(panel, "Please input all fields");
            return;
        }
        double num1 = 0;
        double num2 = 0;
        double result = 0;
        try{
            num1 = Double.parseDouble(tfNumber1.getText());
            num2 = Double.parseDouble(tfNumber2.getText());
        }catch (Exception e){
            JOptionPane.showMessageDialog(panel, "Invalid input");
            return;
        }

        switch (op){
            case "+":
                result = num1 + num2;
                break;
            case "-":
                result = num1 - num2;
                break;
            case "*":
                result = num1 * num2;
                break;
            case "/":
                if(num2 == 0){
                    JOptionPane.showMessageDialog(panel, "Invalid divisor cannot divide by 0");
                    return;
                }
                result = num1 / num2;
                break;
            default:
                JOptionPane.showMessageDialog(panel, "Invalid operation");
                break;
        }
        lblResult.setText(String.valueOf(result));
    }
}
