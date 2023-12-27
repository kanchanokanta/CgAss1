import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;

public class PointPixel extends JPanel {
    private Image backgroundImage;

    public PointPixel() {
        try {
            // อ่านไฟล์ภาพจากไฟล์
            backgroundImage = ImageIO.read(new File(
                    "/Users/nattawadeekwankao/Desktop/SecondYear/CG/assignment1/CgAss1/Assignment1/รูป/6.jpg"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        PointPixel n = new PointPixel();

        n.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                int x = e.getX();
                int y = e.getY();
                System.out.println("x: " + x + " y: " + y);
            }
        });
        JFrame f = new JFrame();
        f.add(n);
        f.setTitle("New Year");
        f.setResizable(false);
        f.setSize(600, 600);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        if (backgroundImage != null) {
            int panelWidth = getWidth();
            int panelHeight = getHeight();

            // ปรับขนาดรูปภาพ
            Image scaledImage = backgroundImage.getScaledInstance(panelWidth, panelHeight, Image.SCALE_SMOOTH);

            // คำนวณตำแหน่ง
            int x = (panelWidth - scaledImage.getWidth(this)) / 2;
            int y = (panelHeight - scaledImage.getHeight(this)) / 2;

            g.drawImage(scaledImage, x, y, this);
        }
    }
}
