package view;

import java.util.List;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import model.Book;

public class SearchResultWindow extends JFrame {
    private JTextArea resultArea;

    public SearchResultWindow(String title) {
        setTitle(title);
        setSize(400, 300);
        setLayout(null);

        resultArea = new JTextArea();
        resultArea.setEditable(false);

        JScrollPane scrollPane = new JScrollPane(resultArea);
        scrollPane.setBounds(10, 10, 380, 250);

        add(scrollPane);
        setVisible(true);
    }

    public void displayResults(String results) {
        resultArea.setText(results);
    }
<<<<<<< HEAD

    public void displayResults(List<Book> foundBooks) {
        StringBuilder sb = new StringBuilder();
        for (Book book : foundBooks) {
            sb.append(book.toString()).append("\n");
        }
        resultArea.setText(sb.toString());
    }    
=======
    public void displayResults(List<Book> foundBooks) {
}
>>>>>>> 57f6715a3b56b98422ea5ed839e42af4fe9f3b88
}
