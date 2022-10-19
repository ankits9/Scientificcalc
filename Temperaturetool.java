import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextPane;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import javax.swing.JLabel;
import javax.swing.UIManager;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ButtonGroup;

public class Temperaturetool extends JFrame {

private JPanel contentPane;
private final ButtonGroup buttonGroup = new ButtonGroup();
    
public static void main(String[] args) {
    EventQueue.invokeLater(new Runnable() {
        public void run() {
            try {
                Temperaturetool frame = new Temperaturetool();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    });
}

// Frame
public Temperaturetool() {

    setTitle("Temperature Converter");
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setBounds(0, -33, 385, 272);
    contentPane = new JPanel();
    contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
    setContentPane(contentPane);
    contentPane.setLayout(null);

    JTextPane txtTempIn = new JTextPane();
    txtTempIn.setBounds(12, 46, 124, 26);
    contentPane.add(txtTempIn);

    JRadioButton celRadio = new JRadioButton("Celcius");
    buttonGroup.add(celRadio);
    celRadio.setBounds(215, 35, 70, 25);
    contentPane.add(celRadio);

    JRadioButton fahrenRadio = new JRadioButton("Fahrenheit");
    buttonGroup.add(fahrenRadio);
    fahrenRadio.setBounds(210, 60, 85, 25);
    contentPane.add(fahrenRadio);

    JLabel lblTem = new JLabel("Degrees");
    lblTem.setBounds(155, 50, 80, 20);
    contentPane.add(lblTem);

    JTextPane tempOutput = new JTextPane();
    tempOutput.setBackground(UIManager.getColor("Button.background"));
    tempOutput.setEditable(false);
    tempOutput.setBounds(15, 140, 270, 25);
    contentPane.add(tempOutput);

    JButton btnNewButton = new JButton("Convert");
    btnNewButton.setBounds(12, 84, 98, 26);
    contentPane.add(btnNewButton);
    btnNewButton.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent arg0) {

            if(celRadio.isSelected()){
                try{
                    double temp=Double.parseDouble(txtTempIn.getText());
                    temp = temp * 1.8 + 32;
                    tempOutput.setText(Double.toString(temp));
                }catch(Exception e){
                    tempOutput.setText("Enter valid temperature.");
                }
            }else{
                try{
                    double temp=Double.parseDouble(txtTempIn.getText());
                    temp = (temp - 32) * (5.0/9.0);
                    tempOutput.setText(Double.toString(temp));
                }catch(Exception e){
                    tempOutput.setText("Enter valid temperature.");
                }
            }
        }
    });
}
}