

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LibraryApp extends JFrame {

    public LibraryApp() {

        setTitle("Library");
        setSize(500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setContentPane(new JLabel(new ImageIcon("img/Fondo.jpg"))); // Reemplaza "ruta_de_la_imagen" con la ruta de tu imagen de fondo
        setLayout(new FlowLayout());


        initComponents();
    }

    private void initComponents() {
        JPanel buttonPanel = new JPanel(new FlowLayout());

        JButton searchButton = createStyledButton("Buscar Book");
        JButton listButton = createStyledButton("Lista Books");
        JButton deleteButton = createStyledButton("Eliminar Book");

        buttonPanel.add(searchButton);
        buttonPanel.add(listButton);
        buttonPanel.add(deleteButton);

        add(buttonPanel, BorderLayout.NORTH);

        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                openSearchBookWindow();
            }
        });

        listButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                openListBooksWindow();
            }
        });

        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                openDeleteBookWindow();
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

    private void openSearchBookWindow() {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                SearchBookWindow searchWindow = new SearchBookWindow();
                searchWindow.setVisible(true);
            }
        });
    }

    private void openListBooksWindow() {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                ListBooksWindow listWindow = new ListBooksWindow();
                listWindow.setVisible(true);
            }
        });
    }

    private void openDeleteBookWindow() {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                DeleteBookWindow deleteWindow = new DeleteBookWindow();
                deleteWindow.setVisible(true);
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                LibraryApp app = new LibraryApp();
                app.setVisible(true);
            }
        });
    }
}
