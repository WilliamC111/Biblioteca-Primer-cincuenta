
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SearchBookWindow extends JFrame {

    public SearchBookWindow() {
        setTitle("Search Book");
        setSize(650, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setContentPane(new JLabel(new ImageIcon("img/1.jpg"))); // Reemplaza "ruta_de_la_imagen" con la ruta de tu imagen de fondo
        setLayout(new FlowLayout());


        initComponents();
    }

    private void initComponents() {
        JLabel label = new JLabel("Nombre o ISBN:");
        JTextField textField = new JTextField(20);
        JButton searchButton = createStyledButton("Buscar");
        JButton backButton = createStyledButton("Salir");

        JPanel panel = new JPanel(new FlowLayout());
        panel.add(label);
        panel.add(textField);
        panel.add(searchButton);
        panel.add(backButton);

        add(panel, BorderLayout.CENTER);

        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            // Lógica para buscar el libro según el título ingresado o ISBN
            }
        });

        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
    }

    private JButton createStyledButton(String text) {
        JButton button = new JButton(text);
        button.setFont(new Font("Arial", Font.PLAIN, 16));
        button.setFocusPainted(false);
        button.setBackground(new Color(51, 102, 153));
        button.setForeground(Color.WHITE);
        button.setPreferredSize(new Dimension(150, 40));
        return button;
    }
}
