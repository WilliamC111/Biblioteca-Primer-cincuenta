import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class View extends JFrame {
    private Map<String, List<Libro>> sedeLibros;

    public View() {
        sedeLibros = new HashMap<>();

        setTitle("Biblioteca");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JButton buscarButton = new JButton("Buscar Libro");
        JButton listarButton = new JButton("Listar Libros");
        JButton eliminarButton = new JButton("Eliminar Libro");

        JPanel panelBotones = new JPanel(new FlowLayout());
        panelBotones.add(buscarButton);
        panelBotones.add(listarButton);
        panelBotones.add(eliminarButton);

        add(panelBotones, BorderLayout.NORTH);

        buscarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Lógica para buscar libros
                // Puede abrir una nueva ventana de búsqueda aquí
            }
        });

        listarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Lógica para listar libros
                // Puede abrir una nueva ventana de lista aquí
            }
        });

        eliminarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Lógica para eliminar libros
                // Puede abrir una nueva ventana de eliminación aquí
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                BibliotecaApp app = new BibliotecaApp();
                app.setVisible(true);
            }
        });
    }
}
