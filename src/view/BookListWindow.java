package view;

import model.Book;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.List;
import javax.imageio.ImageIO;

class ImagePanel extends JPanel {
    private BufferedImage backgroundImage;

    public ImagePanel(String imagePath) {
        try {
            backgroundImage = ImageIO.read(getClass().getResource(imagePath));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (backgroundImage != null) {
            g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
        }
    }
}

public class BookListWindow extends JFrame {

    public BookListWindow(List<Book> books) {
        setTitle("List of Books");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);


        JPanel panel = new ImagePanel("/resources/Lista.jpg");
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        for (Book book : books) {
            JLabel label = new JLabel(book.toString());
            panel.add(label);
        }
        getContentPane().add(new JScrollPane(panel));
        setLocationRelativeTo(null);
        setVisible(true);
    }
}
