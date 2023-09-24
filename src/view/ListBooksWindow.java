
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ListBooksWindow extends JFrame {

    public ListBooksWindow() {
        setTitle("List Books");
        setSize(650, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setContentPane(new JLabel(new ImageIcon("img/2.jpg"))); // Reemplaza "ruta_de_la_imagen" con la ruta de tu imagen de fondo
        setLayout(new FlowLayout());

        initComponents();
    }

    private void initComponents() {
        JButton listAllButton = createStyledButton("Toda la lista");
        JButton listByBranchButton = createStyledButton("Lista por Sede");
        JButton backButton = createStyledButton("Regresar");

        JPanel panel = new JPanel(new FlowLayout());
        panel.add(listAllButton);
        panel.add(listByBranchButton);
        panel.add(backButton);

        add(panel, BorderLayout.CENTER);

        listAllButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Lógica para listar todos los libros
            }
        });

        listByBranchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            // Lógica para listar libros por sede
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
