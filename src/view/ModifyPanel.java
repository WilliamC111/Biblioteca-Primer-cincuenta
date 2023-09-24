package view;

import javax.swing.*;
import java.awt.*;

public class ModifyPanel extends JPanel {
    private String directionImg = null;

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Dimension dimension = this.getSize();
        ImageIcon icon = new ImageIcon(getClass().getResource(directionImg));
        g.drawImage(icon.getImage(), 0, 0, dimension.width, dimension.height, null);
    }

    public String getDirectionImg() {
        return directionImg;
    }

    public void setDirectionImg(String directionImg) {
        this.directionImg = directionImg;
    }
}
