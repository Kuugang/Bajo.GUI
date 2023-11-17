import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.AbstractMap;
import java.util.HashMap;

public class FoodOrderingSystem extends JFrame {
    private JPanel jPanel;
    private JCheckBox cPizza;
    private JCheckBox cBurger;
    private JCheckBox cFries;
    private JCheckBox cSoftDrinks;
    private JCheckBox cTea;
    private JCheckBox cSundae;
    private JRadioButton rbNone;
    private JRadioButton rb5;
    private JRadioButton rb10;
    private JRadioButton rb15;
    private JButton btnOrder;
    private JCheckBox[] cItems = {cPizza, cBurger, cFries, cSoftDrinks, cTea, cSundae};
    private JRadioButton[] rDiscount = {rbNone, rb5, rb10, rb15};
    AbstractMap<String, Integer> menu;
    AbstractMap<String, Integer> discounts;
    public FoodOrderingSystem(){
        this.setContentPane(this.jPanel);
        this.setSize(1000, 600);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setTitle("Food Ordering System");
        this.setVisible(true);

        menu = new HashMap<String, Integer>();
        menu.put("Pizza", 100);
        menu.put("Burger",80);
        menu.put("Fries", 65);
        menu.put("Soft Drinks", 55);
        menu.put("Tea", 50);
        menu.put("Sundae", 40);


        discounts = new HashMap<String, Integer>();
        discounts.put("None", 0);
        discounts.put("5% Off", 5);
        discounts.put("10% Off", 10);
        discounts.put("15% Off", 15);

        btnOrder.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                order();
            }
        });
    }


    void order(){
        double total = 0;
        double discount = 0;
        for (JCheckBox item : cItems){
            if(item.isSelected()){
                total += menu.get(item.getText());
            }
        }

        for(JRadioButton d: rDiscount){
            if(d.isSelected()){
                System.out.println(d.getText());
                discount = discounts.get(d.getText());
            }
        }

//        System.out.println("Total is " + total);
//        System.out.println("Discount is " + discount);
//
//        total = total - (total * (discount / 100));
//
//        System.out.println("Discounted Total is: " + total);

        JOptionPane.showMessageDialog(jPanel, "The total price is Php " + total);
    }

}
