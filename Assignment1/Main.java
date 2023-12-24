import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseAdapter;
import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.GeneralPath;
import java.awt.image.BufferedImage;
import java.util.*;
import java.util.Queue;

public class Main extends JPanel {

    private BufferedImage buffer;

    public static void main(String[] args) {
        Main m = new Main();
        m.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                int x = e.getX();
                int y = e.getY();
                System.out.println("x: " + x + " y: " + y);
            }
        });

        JFrame f = new JFrame();
        f.add(m);
        f.setTitle("Assignment 1");
        f.setSize(600, 600);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
    }

    public void paintComponent(Graphics g) {
        buffer = new BufferedImage(600, 600, BufferedImage.TYPE_INT_ARGB);
        Point startPoint = new Point(50, 50);
        Point endPoint = new Point(250, 250);

        // กำหนดสีเริ่มต้นและสีสิ้นสุด
        Color startColor = Color.RED;
        Color endColor = Color.YELLOW;
        GradientPaint gradientPaint = new GradientPaint(startPoint, startColor, endPoint, endColor);
        Graphics2D g2 = buffer.createGraphics();

        Color background = Color.decode("#354052");
        Color firework = Color.decode("#F2BD65");
        Color dragon = Color.decode("#E34C27");
        Color fur = Color.decode("#F3E7DD");
        Color moon = Color.decode("#526581");
        Color bodyRabbit = Color.decode("#E4CBBA");
        g2.setColor(background);
        g2.fillRect(0, 0, 600, 600);
        // ดวงจันทร์
        drawCircleBorder(g2, 300, 265, 225, moon);
        // ช่อง1
        // หูนอก
        g2.setColor(fur);
        bazierCurve(g2, 301, 199, 280, 203, 253, 228, 242, 252);
        bazierCurve(g2, 301, 199, 306, 195, 322, 192, 347, 194);
        bazierCurve(g2, 242, 252, 258, 259, 284, 258, 301, 257);
        bazierCurve(g2, 301, 257, 320, 255, 337, 250, 344, 228);
        bresenhamLine(g2, 347, 194, 347, 209);
        bazierCurve(g2, 347, 209, 348, 218, 348, 224, 344, 228);
        buffer = floodFill(buffer, 271, 234, moon, fur);
        g.drawImage(buffer, 0, 0, null);
        // หูใน
        g2.setColor(dragon);
        bazierCurve(g2, 344, 228, 332, 236, 318, 241, 300, 243);
        bresenhamLine(g2, 300, 243, 305, 235);
        bazierCurve(g2, 305, 235, 296, 240, 281, 244, 276, 241);
        bazierCurve(g2, 305, 235, 296, 240, 281, 244, 276, 241);
        bresenhamLine(g2, 276, 241, 303, 217);
        bazierCurve(g2, 303, 217, 312, 210, 327, 206, 347, 209);
        buffer = floodFill(buffer, 315, 226, fur, dragon);
        g.drawImage(buffer, 0, 0, null);
        // เขา
        g2.setColor(Color.decode("#383F50"));
        bazierCurve(g2, 279, 209, 268, 204, 255, 194, 251, 183);
        bazierCurve(g2, 251, 183, 265, 179, 288, 184, 316, 195);
        buffer = floodFill(buffer, 279, 195, moon, Color.decode("#383F50"));
        g.drawImage(buffer, 0, 0, null);
        g2.setColor(Color.decode("#232933"));
        bazierCurve(g2, 289, 187, 281, 179, 275, 172, 274, 160);
        bazierCurve(g2, 274, 160, 298, 166, 319, 176, 339, 193);
        buffer = floodFill(buffer, 299, 180, moon, Color.decode("#232933"));
        g.drawImage(buffer, 0, 0, null);

        // ไฟกระพริบ
        g2.setColor(firework);
        bazierCurve(g2, 203, 185, 215, 183, 218, 177, 217, 167);
        bazierCurve(g2, 217, 167, 219, 177, 221, 183, 233, 186);
        bazierCurve(g2, 203, 185, 215, 186, 219, 191, 218, 202);
        bazierCurve(g2, 218, 202, 219, 192, 223, 186, 233, 186);
        buffer = floodFill(buffer, 218, 188, moon, firework);
        g.drawImage(buffer, 0, 0, null);

        // ช่อง2
        // คอมังกร
        g2.setColor(Color.BLACK);
        bazierCurve(g2, 307, 258, 310, 273, 310, 294, 304, 312);
        bresenhamLine(g2, 304, 312, 287, 377);
        // ช่อง3
        // แขนเสื้อกระต่าย
        g2.setColor(Color.decode("#C18543"));
        bresenhamLine(g2, 287, 377, 301, 432);
        bresenhamLine(g2, 287, 377, 275, 378);
        bresenhamLine(g2, 275, 378, 285, 432);
        bresenhamLine(g2, 285, 432, 301, 432);
        buffer = floodFill(buffer, 284, 404, moon, Color.decode("#C18543"));
        g.drawImage(buffer, 0, 0, null);
        // หัวกระต่าย
        g2.setColor(bodyRabbit);
        bazierCurve(g2, 130, 297, 130, 306, 148, 322, 176, 331);
        bazierCurve(g2, 130, 297, 128, 290, 130, 281, 142, 281);
        bazierCurve(g2, 142, 281, 150, 280, 174, 286, 196, 300);
        bazierCurve(g2, 176, 331, 183, 357, 198, 372, 228, 376);
        bazierCurve(g2, 228, 376, 265, 371, 284, 365, 290, 332);//
        bazierCurve(g2, 196, 300, 215, 290, 235, 285, 263, 311);
        bazierCurve(g2, 263, 311, 259, 310, 269, 317, 290, 332);//
        buffer = floodFill(buffer, 208, 321, moon, bodyRabbit);
        g.drawImage(buffer, 0, 0, null);

        g2.setColor(Color.decode("#C9A686"));
        bazierCurve(g2, 160, 283, 156, 268, 159, 260, 174, 259);
        bazierCurve(g2, 174, 259, 192, 270, 205, 279, 216, 292);
        buffer = floodFill(buffer, 180, 277, moon, Color.decode("#C9A686"));
        g.drawImage(buffer, 0, 0, null);

        // หน้ากระต่าย
        g2.setColor(Color.BLACK);
        bresenhamLine(g2, 286, 333, 286, 339);
        bazierCurve(g2, 286, 339, 287, 341, 282, 341, 278, 338);
        bazierCurve(g2, 268, 327, 267, 322, 261, 321, 255, 324);
        bazierCurve(g2, 271, 335, 262, 333, 254, 334, 247, 337);
        bazierCurve(g2, 271, 337, 264, 337, 259, 338, 254, 342);

        // จมูก คิดว่า fill วงรีจะดีกว่ามั้ย
        bazierCurve(g2, 290, 332, 288, 335, 279, 332, 279, 327);
        bazierCurve(g2, 279, 327, 285, 323, 293, 325, 290, 332);

        // ตัวกระต่าย
        g2.setColor(Color.decode("#A12B2D"));
        bresenhamLine(g2, 267, 431, 265, 445);
        bazierCurve(g2, 151, 437, 158, 404, 171, 379, 188, 358);
        bazierCurve(g2, 285, 432, 264, 434, 242, 429, 226, 409);
        bresenhamLine(g2, 275, 378, 268, 380);
        bresenhamLine(g2, 268, 380, 267, 366);
        bazierCurve(g2, 156, 420, 186, 428, 221, 432, 266, 437);
        buffer = floodFill(buffer, 207, 398, moon, Color.decode("#A12B2D"));
        g.drawImage(buffer, 0, 0, null);
        int[] xPoly = { 155, 150, 267, 267 };
        int[] yPoly = { 420, 439, 446, 435 };
        int nPoints = xPoly.length;
        Polygon polygon = new Polygon(xPoly, yPoly, nPoints);
        gradientPaint = new GradientPaint(208, 431, Color.decode("#A12B2D"), 205, 445, Color.decode("#721F1D"));
        g2.setPaint(gradientPaint);
        g2.fillPolygon(polygon);

        g2.setColor(Color.decode("#721F1D"));
        bresenhamLine(g2, 155, 439, 266, 445);
        bazierCurve(g2, 155, 439, 180, 451, 229, 458, 266, 445);
        buffer = floodFill(buffer, 216, 449, moon, Color.decode("#721F1D"));
        g.drawImage(buffer, 0, 0, null);


        g2.setColor(Color.BLACK);
        bazierCurve(g2, 285, 432, 264, 434, 242, 429, 226, 409);
        bresenhamLine(g2, 242, 408, 252, 407);
        bresenhamLine(g2, 246, 402, 248, 407);

        g2.setColor(Color.decode("#C18543"));
        bazierCurve(g2, 265, 445, 235, 458, 187, 453, 151, 437);
        bresenhamLine(g2, 265, 445, 260, 460);
        bresenhamLine(g2, 151, 437, 148, 450);
        bazierCurve(g2, 148, 450, 166, 459, 223, 474, 260, 460);
        buffer = floodFill(buffer, 200, 462, moon, Color.decode("#C18543"));
        g.drawImage(buffer, 0, 0, null);
        buffer = floodFill(buffer, 159, 452, background, Color.decode("#C18543"));
        g.drawImage(buffer, 0, 0, null);

        // ขากระต่าย
        g2.setColor(bodyRabbit);
        bazierCurve(g2, 156, 453, 145, 459, 145, 468, 151, 474);
        bazierCurve(g2, 151, 474, 159, 479, 166, 479, 169, 470);
        bresenhamLine(g2, 169, 470, 176, 478);
        bazierCurve(g2, 176, 478, 177, 488, 190, 498, 205, 501);
        bazierCurve(g2, 205, 501, 215, 502, 215, 507, 212, 513);
        bazierCurve(g2, 212, 513, 204, 528, 206, 538, 218, 545);
        bazierCurve(g2, 218, 545, 230, 553, 244, 552, 241, 542);
        bazierCurve(g2, 241, 542, 229, 532, 229, 531, 225, 527);
        bazierCurve(g2, 225, 527, 225, 525, 225, 521, 231, 516);
        bazierCurve(g2, 231, 516, 251, 505, 264, 485, 258, 461);
        buffer = floodFill(buffer, 239, 474, moon, bodyRabbit);
        g.drawImage(buffer, 0, 0, null);
        buffer = floodFill(buffer, 199, 492, background, bodyRabbit);
        g.drawImage(buffer, 0, 0, null);

        // ตัวมังกร
        g2.setColor(Color.BLACK);
        bazierCurve(g2, 152, 455, 121, 436, 91, 412, 62, 386);
        bazierCurve(g2, 62, 386, 42, 371, 20, 355, 0, 347);
        bazierCurve(g2, 0, 485, 14, 487, 103, 584, 206, 580);
        bazierCurve(g2, 206, 580, 365, 575, 408, 396, 425, 314);
        // bazierCurve(g2, 327, 520, 374, 470, 408, 382, 424, 306);
        // ช่อง4

        buffer = floodFill(buffer, 219, 182, background, dragon);
        g.drawImage(buffer, 0, 0, null);
    }

    private void drawCircleBorder(Graphics g, int centerX, int centerY, int radius, Color color) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(color);

        Ellipse2D.Double circle = new Ellipse2D.Double(centerX - radius, centerY - radius, 2 * radius, 2 * radius);
        g2d.fill(circle);
    }

    private void bazierCurve(Graphics g, int x1, int y1, int x2, int y2, int x3, int y3, int x4, int y4) {
        for (int i = 0; i <= 1000; i++) {
            double t = i / 1000.0;

            int x = (int) (Math.pow((1 - t), 3) * x1 +
                    3 * t * Math.pow((1 - t), 2) * x2 +
                    3 * t * t * (1 - t) * x3 +
                    Math.pow(t, 3) * x4);

            int y = (int) (Math.pow((1 - t), 3) * y1 +
                    3 * t * Math.pow((1 - t), 2) * y2 +
                    3 * t * t * (1 - t) * y3 +
                    Math.pow(t, 3) * y4);

            plot(g, x, y, 1);
        }
    }

    private void bresenhamLine(Graphics g, int x1, int y1, int x2, int y2) {
        int dx = Math.abs(x2 - x1);
        int dy = Math.abs(y2 - y1);
        int D;

        int sx = (x1 < x2) ? 1 : -1;
        int sy = (y1 < y2) ? 1 : -1;

        boolean isSwap = false;
        if (dy > dx) {
            int temp = dx;
            dx = dy;
            dy = temp;

            isSwap = true;
        }

        D = 2 * dy - dx;

        int x = x1;
        int y = y1;

        for (int i = 0; i < dx; i++) {
            plot(g, x, y, 1);

            if (D >= 0) {
                if (isSwap)
                    x += sx;
                else
                    y += sy;
                D -= 2 * dx;
            }

            if (isSwap)
                y += sy;
            else
                x += sx;

            D += 2 * dy;
        }
    }

    private void plot(Graphics g, int x, int y, int size) {
        g.fillRect(x, y, size, size);
    }

    public BufferedImage floodFill(BufferedImage m, int x, int y, Color target_colour, Color replacement_colour) {
        Queue<Node> Q = new LinkedList<>();
        Q.add(new Node(x, y));

        while (!Q.isEmpty()) {
            Node current_node = Q.poll();

            if (isValid(current_node, m.getWidth(), m.getHeight())
                    && getColor(m, current_node.getX(), current_node.getY()).equals(target_colour)) {
                paint(m, current_node.getX(), current_node.getY(), replacement_colour);

                Q.add(new Node(current_node.getX(), current_node.getY() + 1));
                Q.add(new Node(current_node.getX(), current_node.getY() - 1));
                Q.add(new Node(current_node.getX() + 1, current_node.getY()));
                Q.add(new Node(current_node.getX() - 1, current_node.getY()));
            }
        }
        return m;
    }

    private boolean isValid(Node node, int width, int height) {
        return node.getX() >= 0 && node.getX() < width && node.getY() >= 0 && node.getY() < height;
    }

    private Color getColor(BufferedImage m, int x, int y) {
        return new Color(m.getRGB(x, y));
    }

    private void paint(BufferedImage m, int x, int y, Color replacement_colour) {
        m.setRGB(x, y, replacement_colour.getRGB());
    }

    class Node {
        private int x;
        private int y;

        Node(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }
    }

}