package swing;

import Model.Image;
import ui.ImageDisplay;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.ByteArrayInputStream;
import java.io.IOException;

public class SwingImageDisplay extends JPanel implements ImageDisplay {

    private Image image;

    public SwingImageDisplay() {
        super(new BorderLayout());
    }

    @Override
    public Image currentImage() {
        return image;
    }

    @Override
    public void display(Image image) {
        this.image = image;
        this.removeAll();
        this.add(imagePanel());
        this.updateUI();
    }

    private Component imagePanel() {
        return new JPanel(){
            @Override
            public void paint(Graphics g) {
                g.drawImage(bitmap(), 0, 0, this.getWidth(), this.getHeight(), null);
            }

            private java.awt.Image bitmap() {
                try {
                    return ImageIO.read(new ByteArrayInputStream(image.bitmap()));
                } catch (IOException e) {
                    return null;
                }
            }
        };
    }
}
