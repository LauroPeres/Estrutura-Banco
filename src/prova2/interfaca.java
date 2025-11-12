import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.*;

public class interfaca {
    JFrame janela = new JFrame("MiniCalc");
    JTextField casa11 = new JTextField(10);
    JTextField casa12 = new JTextField(10);
    JTextField casa21 = new JTextField(10);
    JTextField casa22 = new JTextField(10);
    JLabel label1 = new JLabel("*");
    JLabel label2 = new JLabel("+");
    JButton button1 = new JButton("=");
    JButton button2 = new JButton("=");
    JTextField resultado1 = new JTextField(10);
    JTextField resultado2 = new JTextField(10);
    
    public interfaca(){
        janela.setSize(600, 300);
        Container contentPane = janela.getContentPane();
        contentPane.setLayout(new GridLayout(2, 1));
        JPanel flow1 = new JPanel(new FlowLayout());
        JPanel flow2 = new JPanel(new FlowLayout());
        
        flow1.add(casa11);
        flow1.add(label1);
        flow1.add(casa12);
        flow1.add(button1);
        flow1.add(resultado1);

        flow2.add(casa21);
        flow2.add(label2);
        flow2.add(casa22);
        flow2.add(button2);
        flow2.add(resultado2);

        contentPane.add(flow1);
        contentPane.add(flow2);
        double num1 = Double.parseDouble(casa21.getText());
        double num2 = Double.parseDouble(casa22.getText());
        double resultado = num1 * num2;
        //button1.addActionListener(e -> resultado1.setText(String.valueOf(resultado)));
        button2.addActionListener(e -> resultado2.setText(String.valueOf("Memama")));

        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        janela.setVisible(true);
    }
    
    public static void main(String[] args) {
        interfaca i = new interfaca();
    }
}
