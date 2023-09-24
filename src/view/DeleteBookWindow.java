
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DeleteBookWindow extends JFrame {

    public DeleteBookWindow() {
        setTitle("Delete Book");
        setSize(650, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setContentPane(new JLabel(new ImageIcon("img/3.jpg"))); // Reemplaza "ruta_de_la_imagen" con la ruta de tu imagen de fondo
        setLayout(new FlowLayout());
        initComponents();
    }

    private void initComponents() {
        JLabel label = new JLabel("Nombre o ISBN Eliminar:");
        JTextField textField = new JTextField(20);
        JButton deleteButton = createStyledButton("Eliminar");
        JButton backButton = createStyledButton("Regresar");

        JPanel panel = new JPanel(new FlowLayout());
        panel.add(label);
        panel.add(textField);
        panel.add(deleteButton);
        panel.add(backButton);

        add(panel, BorderLayout.CENTER);

        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Lógica para eliminar el libro según el ISBN ingresado
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
