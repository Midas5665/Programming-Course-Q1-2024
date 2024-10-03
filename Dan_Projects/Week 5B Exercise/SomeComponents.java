import java.awt.*;
import javax.swing.*;

public class SomeComponents {
    JFrame frame;
    JLabel label;
    JButton button;
    JPanel panel;
    JButton button2;
    JTextField text;
    ImageIcon icon;

    public SomeComponents() {
        frame = new JFrame("Some Components");

        ImageIcon icon = createImageIcon("monke.jpg", "monke mode");
        label = new JLabel("", icon, JLabel.CENTER);
        button = new JButton("Ok");
        panel = new JPanel();
        button2 = new JButton("Not Ok");
        text = new JTextField("Don't press these buttons");
        
    }

    void setupGui(){
        frame.add(panel);

        frame.add(button, BorderLayout.SOUTH);
        frame.add(button2, BorderLayout.WEST);

        Color yellow = new Color(255, 255, 0);
        panel.setBackground(yellow);


        label.setBackground(Color.PINK);
        label.setOpaque(true);
        frame.add(label, BorderLayout.CENTER);

         frame.add(text, BorderLayout.NORTH);

        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);



        frame.setVisible(true);
    }

    private ImageIcon createImageIcon(String path, String description) {
        java.net.URL imgURL = getClass().getResource(path);
        if (imgURL != null) {
            return new ImageIcon(imgURL, description);
        } else {
            System.err.println("Couldn't find file: " + path);
            return null;
        }
    }

    public static void main(String[] args) {
        new SomeComponents().setupGui();
    }

    
}