package view;

import java.util.List;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import model.Book;

public class SearchResultWindow extends JFrame {
    private JTextArea resultArea;
    private JTextArea window;

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

    public void displayResults(List<Book> foundBooks) {
        StringBuilder sb = new StringBuilder();
        for (Book book : foundBooks) {
            sb.append(book.toString()).append("\n");
        }
        resultArea.setText(sb.toString());
    }  
    public void window(JTextArea window){
        this.window = window;
    }
}
