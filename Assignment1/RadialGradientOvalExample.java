import javax.swing.*;
import java.awt.*;
import java.awt.geom.Ellipse2D;

public class RadialGradientOvalExample extends JPanel {

    private RadialGradientPaint gradientPaint;

    public RadialGradientOvalExample() {
        gradientPaint = new RadialGradientPaint(195, 345, 25, new float[]{0.0f, 1.0f},
                new Color[]{Color.decode("#A12B2D"), Color.decode("#721F1D")});
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D) g;

        // ใช้ RadialGradientPaint ในการวาดวงกลม
        g2.setPaint(gradientPaint);

        // กำหนดพื้นที่ที่จะวาดวงกลม (ในที่นี้ใช้ Ellipse2D)
        Ellipse2D ellipse = new Ellipse2D.Float(170, 320, 50, 50);

        // วาดวงกลม
        g2.fill(ellipse);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Radial Gradient Oval Example");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(400, 400);
            frame.setContentPane(new RadialGradientOvalExample());
            frame.setVisible(true);
        });
    }
}
