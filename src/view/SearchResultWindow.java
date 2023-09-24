package view;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

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
    public void displayResults(List<Book> foundBooks) {
}
}
