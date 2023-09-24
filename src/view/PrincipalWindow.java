package view;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionListener;

public class PrincipalWindow extends JFrame {

    private JPanel contentPane;
    private JComboBox<String> comboBox;
    private JLabel lblNewLabel_1;

    private JButton btnBuscar;
    private JButton btnAgregar;
    private JButton btnEliminar;
    private JButton btnListar;

    public PrincipalWindow(ActionListener listener) {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 600, 600);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
       setContentPane(new JLabel(new ImageIcon("img/Fondo.jpg"))); 


        ModifyPanel panel = new ModifyPanel();
        panel.setDirectionImg("/resources/Biblioteca.jpg");
        panel.setBounds(10, 11, 600, 600);
        contentPane.add(panel);
        panel.setLayout(null);

        JLabel lblNewLabel = new JLabel("Biblioteca");
        lblNewLabel.setForeground(new Color(255, 255, 255));
        lblNewLabel.setBounds(10, 0, 242, 39);
        panel.add(lblNewLabel);
        lblNewLabel.setFont(new Font("Yu Gothic UI Semilight", Font.PLAIN, 22));
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);

        JLabel lblComboBoxTitle = new JLabel("Selecciona la sede:");
        lblComboBoxTitle.setForeground(new Color(255, 255, 255));
        lblComboBoxTitle.setBounds(130, 40, 242, 30);
        panel.add(lblComboBoxTitle);

        comboBox = new JComboBox<>();
        comboBox.setBounds(130, 80, 242, 30);
        comboBox.setBackground(Color.GRAY);
        comboBox.addItem("Tunja");
        comboBox.addItem("Duitama");
        contentPane.add(comboBox);

        btnBuscar = new JButton("Buscar Libro");
        btnBuscar.setBounds(30, 150, 200, 75);
        btnBuscar.setBackground(Color.gray);
        btnBuscar.addActionListener(listener);
        contentPane.add(btnBuscar);

        btnAgregar = new JButton("Agregar Libro");
        btnAgregar.setBounds(300, 150, 200, 75);
        btnAgregar.setBackground(Color.gray);
        btnAgregar.addActionListener(listener);
        contentPane.add(btnAgregar);

        btnEliminar = new JButton("Eliminar Libro");
        btnEliminar.setBounds(30, 250, 200, 75);
        btnEliminar.setBackground(Color.gray);
        btnEliminar.addActionListener(listener);
        contentPane.add(btnEliminar);

        btnListar = new JButton("Listar Libros por Sede");
        btnListar.setBounds(300, 250, 200, 75);
        btnListar.setBackground(Color.gray);
        btnListar.addActionListener(listener);
        contentPane.add(btnListar);

        lblNewLabel_1 = new JLabel("");
        lblNewLabel_1.setFont(new Font("Yu Gothic UI", Font.PLAIN, 11));
        lblNewLabel_1.setBounds(24, 25, 110, 139);
        lblNewLabel_1.setVerticalAlignment(SwingConstants.TOP);
        lblNewLabel_1.setHorizontalAlignment(SwingConstants.LEFT);

        this.setResizable(false);
        this.setVisible(true);
    }

    public void obtainResults(String name) {
        StringBuilder sb = new StringBuilder();
    }

    public JButton getBtnBuscar() {
        return btnBuscar;
    }

    public JButton getBtnAgregar() {
        return btnAgregar;
    }

    public JButton getBtnEliminar() {
        return btnEliminar;
    }

    public JButton getBtnListar() {
        return btnListar;
    }

    public JComboBox<String> getComboBox() {
        return comboBox;
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

    public void updateLabelText(String text) {
        int aux = lblNewLabel_1.getWidth() - 40;
        lblNewLabel_1.setText("<html><body style='width: " + aux + "px'>" + text + "</body></html>");
        this.repaint();
    }
}
