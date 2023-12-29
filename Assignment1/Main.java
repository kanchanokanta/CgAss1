import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseAdapter;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.*;
import java.util.Queue;

public class Main extends JPanel {

    private BufferedImage buffer;
    private int[] xPoly, yPoly;


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
        f.setLocationRelativeTo(null);
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
        Color lowerdragon = Color.decode("#a82731");
        Color upperDragon = Color.decode("#ec563e");
        Color fur = Color.decode("#F3E7DD");
        Color moon = Color.decode("#526681");
        Color moonInside = Color.decode("#627697");
        Color bodyRabbit = Color.decode("#E4CBBA");
        Color Cloud = Color.decode("#45556c");

        g2.setColor(background);
        g2.fillRect(0, 0, 600, 600);
        // ดวงจันทร์
        drawCircleBorder(g2, 300, 245, 225, moon);
        buffer = floodFill(buffer, 297, 125, background, moon);

        //ลายดวงจันทร์
        g2.setColor(moonInside);
        bezierCurve(g2, 76, 243, 204, 110, 340, 168, 336, 23);
        bezierCurve(g2, 76, 243, 73, 262, 79, 296, 90, 323);
        bezierCurve(g2, 336, 23, 343, 25, 352, 27, 354, 28);
        bezierCurve(g2, 90, 323, 136, 297, 191, 254, 213, 222);
        bezierCurve(g2, 213, 222, 231, 195, 266, 170, 294, 151);
        bezierCurve(g2, 294, 151, 325, 135, 356, 80, 354, 28);
        buffer = floodFill(buffer, 144, 229, moon, moonInside);

        bezierCurve(g2, 99, 344, 134, 337, 211, 293, 219, 265);
        bezierCurve(g2, 219, 265, 222, 270, 235, 220, 255, 206);
        bezierCurve(g2, 255, 206, 289, 181, 320, 147, 336, 122);
        bezierCurve(g2, 336, 122, 357, 97, 372, 67, 377, 34);
        bezierCurve(g2, 99, 344, 111, 365, 127, 387, 137, 400);
        bezierCurve(g2, 137, 400, 190, 374, 239, 333, 246, 305);
        bezierCurve(g2, 246, 305, 253, 286, 278, 247, 301, 217);
        bresenhamLine(g2, 301, 217, 410, 49);
        bezierCurve(g2, 377, 34, 387, 36, 401, 43, 410, 49);
        buffer = floodFill(buffer, 238, 274, moon, moonInside);

        // bezierCurve(g2, 398, 420, 433, 372, 464, 362, 509, 328);
        // bresenhamLine(g2, 398, 420, 379, 457);
        // bezierCurve(g2, 379, 455, 416, 445, 483, 395, 509, 328);
        // buffer = floodFill(buffer, 405, 436, moon, moonInside);
        // g.drawImage(buffer, 0, 0, null);

        // ช่อง1
        // หูนอก
        g2.setColor(fur);
        bezierCurve(g2, 301, 199, 280, 203, 253, 228, 242, 252);
        bezierCurve(g2, 301, 199, 306, 195, 322, 192, 347, 194);
        bezierCurve(g2, 242, 252, 258, 259, 284, 258, 301, 257);
        bezierCurve(g2, 301, 257, 320, 255, 337, 250, 344, 228);
        bresenhamLine(g2, 347, 194, 347, 209);
        bezierCurve(g2, 347, 209, 348, 218, 348, 224, 344, 228);
        buffer = floodFill(buffer, 330, 200, moon, fur);
        buffer = floodFill(buffer, 270, 233, moonInside, fur);

        // หูใน
        g2.setColor(upperDragon);
        bezierCurve(g2, 344, 228, 332, 236, 318, 241, 300, 243);
        bresenhamLine(g2, 300, 243, 305, 235);
        bezierCurve(g2, 305, 235, 296, 240, 281, 244, 276, 241);
        bezierCurve(g2, 305, 235, 296, 240, 281, 244, 276, 241);
        bresenhamLine(g2, 276, 241, 303, 217);
        bezierCurve(g2, 303, 217, 312, 210, 327, 206, 347, 209);
        buffer = floodFill(buffer, 315, 226, fur, upperDragon);
        // เขา
        g2.setColor(Color.decode("#383F50"));
        bezierCurve(g2, 279, 209, 268, 204, 255, 194, 251, 183);
        bezierCurve(g2, 251, 183, 265, 179, 288, 184, 316, 195);
        buffer = floodFill(buffer, 284, 194, moonInside, Color.decode("#383F50"));
        buffer = floodFill(buffer, 264, 190, moon, Color.decode("#383F50"));

        g2.setColor(Color.decode("#232933"));
        bezierCurve(g2, 289, 187, 281, 179, 275, 172, 274, 160);
        bezierCurve(g2, 274, 160, 298, 166, 319, 176, 339, 193);
        buffer = floodFill(buffer, 299, 180, moonInside, Color.decode("#232933"));
        buffer = floodFill(buffer, 285, 171, moon, Color.decode("#232933"));
        buffer = floodFill(buffer, 329, 190, moon, Color.decode("#232933"));
        buffer = floodFill(buffer, 276, 163, moonInside, Color.decode("#232933"));

        // ไฟกระพริบ
        g2.setColor(firework);
        bezierCurve(g2, 203, 185, 215, 183, 218, 177, 217, 167);
        bezierCurve(g2, 217, 167, 219, 177, 221, 183, 233, 186);
        bezierCurve(g2, 203, 185, 215, 186, 219, 191, 218, 202);
        bezierCurve(g2, 218, 202, 219, 192, 223, 186, 233, 186);
        buffer = floodFill(buffer, 218, 188, moonInside, firework);

        // ช่อง2


        // ช่อง3
        // แขนเสื้อกระต่าย
        g2.setColor(Color.decode("#C18543"));
        bresenhamLine(g2, 287, 377, 301, 432);
        bresenhamLine(g2, 287, 377, 275, 378);
        bresenhamLine(g2, 275, 378, 285, 432);
        bresenhamLine(g2, 285, 432, 301, 432);
        buffer = floodFill(buffer, 284, 404, moon, Color.decode("#C18543"));
        g2.setColor(bodyRabbit);
        bezierCurve(g2, 290, 384, 312, 387, 308, 411, 296, 411);
        buffer = floodFill(buffer, 297, 397, moon, bodyRabbit);
        // หัวกระต่าย
        bezierCurve(g2, 130, 297, 130, 306, 148, 322, 176, 331);
        bezierCurve(g2, 130, 297, 128, 290, 130, 281, 142, 281);
        bezierCurve(g2, 142, 281, 150, 280, 174, 286, 196, 300);
        bezierCurve(g2, 176, 331, 183, 357, 198, 372, 228, 376);
        bezierCurve(g2, 228, 376, 265, 371, 284, 365, 290, 332);//
        bezierCurve(g2, 196, 300, 215, 290, 235, 285, 263, 311);
        bezierCurve(g2, 263, 311, 259, 310, 269, 317, 290, 332);//
        buffer = floodFill(buffer, 209, 320, moonInside, bodyRabbit);
        buffer = floodFill(buffer, 218, 356, moon, bodyRabbit);
        buffer = floodFill(buffer, 143, 303, moon, bodyRabbit);
        buffer = floodFill(buffer, 137, 286, moonInside, bodyRabbit);

        g2.setColor(Color.decode("#C9A686"));
        bezierCurve(g2, 160, 283, 156, 268, 159, 260, 174, 259);
        bezierCurve(g2, 174, 259, 192, 270, 205, 279, 216, 292);
        buffer = floodFill(buffer, 180, 277, moon, Color.decode("#C9A686"));
        buffer = floodFill(buffer, 164, 268, moonInside, Color.decode("#C9A686"));
        buffer = floodFill(buffer, 207, 292, moonInside, Color.decode("#C9A686"));

        // หน้ากระต่าย
        g2.setColor(Color.BLACK);
        bresenhamLine(g2, 286, 333, 286, 339);
        bezierCurve(g2, 286, 339, 287, 341, 282, 341, 278, 338);
        bezierCurve(g2, 268, 327, 267, 322, 261, 321, 255, 324);
        bezierCurve(g2, 271, 335, 262, 333, 254, 334, 247, 337);
        bezierCurve(g2, 271, 337, 264, 337, 259, 338, 254, 342);
        bresenhamLine(g2, 282, 327, 295, 317);
        bresenhamLine(g2, 289, 328, 295, 324);
        drawCircleBorder(g2, 236, 342, 14, upperDragon);
        buffer = floodFill(buffer, 231, 340, bodyRabbit, upperDragon);

        //คิ้ว
        g2.setColor(Color.white);
        bezierCurve(g2, 243, 316, 239, 320, 232, 314, 238, 310);
        bezierCurve(g2, 238, 310, 248, 302, 255, 312, 243, 316);
        buffer = floodFill(buffer, 243, 314, bodyRabbit, Color.WHITE);

        // จมูก 
        g2.setColor(Color.BLACK);
        bezierCurve(g2, 290, 332, 288, 335, 279, 332, 279, 327);
        bezierCurve(g2, 279, 327, 285, 323, 293, 325, 290, 332);
        buffer = floodFill(buffer, 283, 331, Color.decode("#E4CBBA"), Color.BLACK);
        buffer = floodFill(buffer, 288, 329, moon, Color.BLACK);

        // หูข้างในกระต่าย
        g2.setColor(Color.decode("#C9A686"));
        bezierCurve(g2, 180, 319, 175, 313, 179, 308, 187, 307);
        bezierCurve(g2, 180, 319, 163, 317, 150, 308, 148, 298);
        bezierCurve(g2, 148, 298, 157, 293, 170, 297, 187, 307);
        buffer = floodFill(buffer, 165, 308, bodyRabbit, Color.decode("#C9A686"));

        // ตัวกระต่าย
        g2.setColor(Color.decode("#A12B2D"));
        bresenhamLine(g2, 267, 431, 265, 445);
        bezierCurve(g2, 151, 437, 158, 404, 171, 379, 188, 358);
        bezierCurve(g2, 285, 432, 264, 434, 242, 429, 226, 409);
        bresenhamLine(g2, 275, 378, 268, 380);
        bresenhamLine(g2, 268, 380, 267, 366);
        bezierCurve(g2, 156, 420, 186, 428, 221, 432, 266, 437);
        buffer = floodFill(buffer, 207, 398, moon, Color.decode("#A12B2D"));
        buffer = floodFill(buffer, 186, 367, moonInside, Color.decode("#A12B2D"));

        xPoly = new int[] { 155, 268, 266, 151 };
        yPoly = new int[] { 418, 435, 447, 437 };
        int nPoints = xPoly.length;
        Polygon polygon = new Polygon(xPoly, yPoly, nPoints);
        gradientPaint = new GradientPaint(208, 431, Color.decode("#A12B2D"), 205, 445, Color.decode("#721F1D"));
        g2.setPaint(gradientPaint);
        g2.fillPolygon(polygon);

        g2.setColor(Color.decode("#721F1D"));
        bresenhamLine(g2, 152, 437, 266, 445);
        bezierCurve(g2, 152, 437, 172, 449, 219, 460, 266, 445);
        buffer = floodFill(buffer, 216, 449, moon, Color.decode("#721F1D"));
        buffer = floodFill(buffer, 187, 445, background, Color.decode("#721F1D"));


        g2.setColor(Color.BLACK);
        bezierCurve(g2, 285, 432, 264, 434, 242, 429, 226, 409);
        bresenhamLine(g2, 242, 408, 252, 407);
        bresenhamLine(g2, 246, 402, 248, 407);

        g2.setColor(Color.decode("#C18543"));
        bezierCurve(g2, 265, 445, 235, 458, 187, 453, 151, 437);
        bresenhamLine(g2, 265, 445, 260, 460);
        bresenhamLine(g2, 151, 437, 148, 450);
        bezierCurve(g2, 148, 450, 166, 459, 223, 474, 260, 460);
        buffer = floodFill(buffer, 250, 457, moon, Color.decode("#C18543"));
        buffer = floodFill(buffer, 159, 452, background, Color.decode("#C18543"));

        // ขากระต่าย
        g2.setColor(bodyRabbit);
        bezierCurve(g2, 156, 453, 145, 459, 145, 468, 151, 474);
        bezierCurve(g2, 151, 474, 159, 479, 166, 479, 169, 470);
        bresenhamLine(g2, 169, 470, 176, 478);
        bezierCurve(g2, 176, 478, 177, 488, 190, 498, 205, 501);
        bezierCurve(g2, 205, 501, 215, 502, 215, 507, 212, 513);
        bezierCurve(g2, 212, 513, 204, 528, 206, 538, 218, 545);
        bezierCurve(g2, 218, 545, 230, 553, 244, 552, 241, 542);
        bezierCurve(g2, 241, 542, 229, 532, 229, 531, 225, 527);
        bezierCurve(g2, 225, 527, 225, 525, 225, 521, 231, 516);
        bezierCurve(g2, 231, 516, 251, 505, 264, 485, 258, 461);
        buffer = floodFill(buffer, 256, 464, moon, bodyRabbit);
        buffer = floodFill(buffer, 199, 492, background, bodyRabbit);

        //ตูดกระต่าย
        
        g2.setColor(lowerdragon);
        bezierCurve(g2, 166, 476, 174, 487, 187, 504, 211, 512);
        buffer = floodFill(buffer, 206, 508, background, lowerdragon);
        
        // ช่อง4
        //text
        g2.setColor(Color.WHITE);
        //H
        bresenhamLine(g2, 29, 33, 29, 42);
        bresenhamLine(g2, 29, 37, 35, 37);
        bresenhamLine(g2, 35, 33, 35, 42);
        //A
        bresenhamLine(g2, 41, 41, 45, 32);
        bresenhamLine(g2, 45, 32, 49, 42);
        bresenhamLine(g2, 44, 38, 48, 38);
        //P 
        bresenhamLine(g2, 55, 33, 55, 42);
        bezierCurve(g2, 55, 33, 65, 30, 63, 40, 55, 37);
        bresenhamLine(g2, 67, 33, 67, 42);
        bezierCurve(g2, 67, 33, 77, 30, 75, 40, 67, 37);
        //Y
        bresenhamLine(g2, 78, 32, 82, 37);
        bresenhamLine(g2, 82, 37, 88, 31);
        bresenhamLine(g2, 82, 37, 82, 42);
        //N
        bresenhamLine(g2, 29, 55, 29, 86);
        bresenhamLine(g2, 29, 55, 31, 55);
        bresenhamLine(g2, 31, 55, 49, 77);
        bresenhamLine(g2, 49, 77, 49, 56);
        bresenhamLine(g2, 49, 56, 54, 56);
        bresenhamLine(g2, 54, 56, 54, 86);
        bresenhamLine(g2, 54, 86, 51, 86);
        bresenhamLine(g2, 51, 86, 34, 67);
        bresenhamLine(g2, 34, 67, 34, 86);
        bresenhamLine(g2, 34, 86, 29, 86);
        buffer = floodFill(buffer, 52, 82, background, Color.WHITE);

        //E
        bezierCurve(g2, 60, 76, 60, 59, 83, 59, 83, 76);
        bezierCurve(g2, 60, 76, 60, 89, 77, 92, 81, 85);
        bresenhamLine(g2, 65, 76, 83, 76);
        bezierCurve(g2, 65, 76, 65, 88, 81, 83, 81, 82);
        bresenhamLine(g2, 81, 82, 81, 85);
        bezierCurve(g2, 65, 72, 67, 66, 79, 66, 79, 72);
        bresenhamLine(g2, 65, 72, 79, 72);
        buffer = floodFill(buffer, 63, 76, background, Color.WHITE);

        //W
        bresenhamLine(g2, 86, 64, 91, 64);
        bresenhamLine(g2, 86, 64, 94, 86);
        bresenhamLine(g2, 94, 86, 98, 86);
        bresenhamLine(g2, 98, 86, 104, 72);
        bresenhamLine(g2, 104, 72, 110, 86);
        bresenhamLine(g2, 110, 86, 113, 86);
        bresenhamLine(g2, 113, 86, 120, 64);
        bresenhamLine(g2, 120, 64, 116, 64);
        bresenhamLine(g2, 116, 64, 111, 78);
        bresenhamLine(g2, 111, 78, 105, 67);
        bresenhamLine(g2, 105, 67, 102, 67);
        bresenhamLine(g2, 102, 67, 95, 78);
        bresenhamLine(g2, 95, 78, 91, 64);
        buffer = floodFill(buffer, 97, 84, background, Color.WHITE);

        //Y
        bresenhamLine(g2, 135, 55, 142, 55);
        bresenhamLine(g2, 135, 55, 147, 71);
        bresenhamLine(g2, 147, 71, 147, 86);
        bresenhamLine(g2, 147, 86, 153, 86);
        bresenhamLine(g2, 153, 86, 153, 71);
        bresenhamLine(g2, 153, 71, 164, 55);
        bresenhamLine(g2, 164, 55, 159, 55);
        bresenhamLine(g2, 159, 55, 150, 67);
        bresenhamLine(g2, 150, 67, 141, 54);
        buffer = floodFill(buffer, 151, 75, background, Color.WHITE);
        buffer = floodFill(buffer, 151, 85, moon, Color.WHITE);

        //e
        bezierCurve(g2, 163, 76, 163, 59, 186, 59, 186, 76);
        bezierCurve(g2, 163, 76, 163, 89, 180, 92, 184, 85);
        bresenhamLine(g2, 168, 76, 186, 76);
        bezierCurve(g2, 168, 76, 169, 88, 184, 83, 184, 82);
        bresenhamLine(g2, 184, 82, 184, 85);
        bezierCurve(g2, 168, 72, 170, 66, 182, 66, 182, 72);
        bresenhamLine(g2, 168, 72, 182, 72);
        buffer = floodFill(buffer, 166, 78, moon, Color.WHITE);

        //a
        bezierCurve(g2, 211, 67, 203, 57, 191, 68, 192, 75);
        bezierCurve(g2, 192, 75, 192, 87, 204, 92, 211, 85);
        bresenhamLine(g2, 211, 67, 211, 63);
        bresenhamLine(g2, 211, 63, 216, 63);
        bresenhamLine(g2, 216, 63, 216, 88);
        bresenhamLine(g2, 216, 88, 211, 88);
        bresenhamLine(g2, 211, 88, 211, 85);
        bezierCurve(g2, 197, 75, 197, 64, 211, 64, 211, 75);
        bezierCurve(g2, 197, 75, 197, 87, 211, 87, 211, 75);
        buffer = floodFill(buffer, 215, 82, moon, Color.WHITE);

        //r
        bresenhamLine(g2, 222, 63, 222, 88);
        bresenhamLine(g2, 222, 88, 228, 88);
        bresenhamLine(g2, 228, 88, 228, 72);
        bezierCurve(g2, 228, 75, 228, 68, 235, 67, 237, 69);
        bresenhamLine(g2, 237, 69, 237, 63);
        bezierCurve(g2, 237, 63, 230, 63, 228, 65, 228, 67);
        bresenhamLine(g2, 228, 63, 221, 63);
        buffer = floodFill(buffer, 226, 85, moon, Color.WHITE);

        //2
        bezierCurve(g2, 21, 116, 36, 89, 72, 111, 37, 141);
        bresenhamLine(g2, 37, 141, 54, 141);
        bresenhamLine(g2, 54, 141, 54, 149);
        bresenhamLine(g2, 54, 149, 25, 149);
        bresenhamLine(g2, 25, 149, 21, 145);
        bezierCurve(g2, 21, 145, 62, 110, 34, 106, 29, 120);
        bresenhamLine(g2, 29, 120, 21, 116);
        buffer = floodFill(buffer, 31, 147, background, Color.WHITE);

        //0
        bezierCurve(g2, 77, 103, 52, 103, 52, 151, 77, 151);
        bezierCurve(g2, 77, 151, 102, 151, 102, 103, 77, 103);
        bezierCurve(g2, 77, 112, 63, 113, 67, 146, 77, 142);
        bezierCurve(g2, 77, 142, 86, 147, 92, 112, 77, 112);
        
        buffer = floodFill(buffer, 63, 127, background, Color.WHITE);

        //2
        bezierCurve(g2, 101, 116, 116, 89, 152, 111, 117, 141);
        bresenhamLine(g2, 117, 141, 134, 141);
        bresenhamLine(g2, 134, 141, 134, 149);
        bresenhamLine(g2, 134, 149, 105, 149);
        bresenhamLine(g2, 105, 149, 101, 145);
        bezierCurve(g2, 101, 145, 142, 110, 114, 106, 109, 120);
        bresenhamLine(g2, 109, 120, 101, 116);
        buffer = floodFill(buffer, 120, 147, moon, Color.WHITE);
        buffer = floodFill(buffer, 112, 113, background, Color.WHITE);

        //4
        bresenhamLine(g2, 159, 105, 137, 134);// /
        bresenhamLine(g2, 159, 105, 166, 105);// _
        bresenhamLine(g2, 166, 105, 166, 128); // |
        bresenhamLine(g2, 166, 128, 177, 128);//_
        bresenhamLine(g2, 177, 128, 177, 134);// |
        bresenhamLine(g2, 177, 134, 166, 134);//_
        bresenhamLine(g2, 166, 134, 166, 150);//|
        bresenhamLine(g2, 166, 150, 159, 150);// _
        bresenhamLine(g2, 159, 150, 159, 134); //|
        bresenhamLine(g2, 159, 134, 137, 134);

        bresenhamLine(g2, 160, 129, 160, 113);
        bresenhamLine(g2, 160, 129, 148, 129);
        bresenhamLine(g2, 148, 129, 160, 113);
        
        buffer = floodFill(buffer, 164, 133, moon, Color.WHITE);

        g2.setColor(firework); // ดาวใต้คางมังกร
        bezierCurve(g2, 414, 375, 423, 374, 427, 367, 427, 358);
        bezierCurve(g2, 427, 358, 427, 369, 433, 373, 441, 375); 
        bezierCurve(g2, 441, 375, 433, 377, 429, 383, 428, 394);
        bezierCurve(g2, 428, 394, 429, 383, 426, 378, 414, 375);
        buffer = floodFill(buffer, 429, 380, moon, firework);
        //ดาวซ้ายล่าง
        bezierCurve(g2, 14, 548, 24, 546, 28, 542, 28, 526);
        bezierCurve(g2, 28, 526, 32, 542, 35, 545, 45, 548);
        bezierCurve(g2, 45, 548, 28, 552, 32, 557, 28, 568);
        bezierCurve(g2, 28, 568, 24, 555, 27, 552, 14, 548);
        buffer = floodFill(buffer, 30, 548, background, firework);
        // ตัวมังกร
        g2.setColor(upperDragon);
        //ส่วนบน
        bezierCurve(g2, 0, 348, 72, 381, 136, 453, 153, 452);
        //กลาง
        // bazierCurve(g2, 0, 439, 190, 599, 317, 596, 361, 329);
        bezierCurve(g2, 0, 440, 84, 478, 92, 549, 222, 549);
        bezierCurve(g2, 241, 546, 326, 513, 362, 360, 361, 329);
        //ส่วนล่าง
        g2.setColor(lowerdragon);
        bezierCurve(g2, 423, 317, 388, 462, 350, 543, 250, 575);
        bezierCurve(g2, 250, 575, 136, 595, 73, 541, 0, 482);
        
        // คอมังกร
        g2.setColor(upperDragon);
        bezierCurve(g2, 287, 377, 296, 351, 304, 317, 304, 300);
        bezierCurve(g2, 304, 300, 323, 315, 340, 323, 361, 329);
        g2.setColor(lowerdragon);
        bezierCurve(g2, 361, 329, 382, 329, 400, 325, 423, 317);
        buffer = floodFill(buffer, 329, 344, moon, upperDragon);
        buffer = floodFill(buffer, 271, 505, background, upperDragon);
        buffer = floodFill(buffer, 104, 471, background, upperDragon);
        buffer = floodFill(buffer, 257, 554, background, lowerdragon);
        buffer = floodFill(buffer, 364, 386, moon, lowerdragon);

        //เกล็ดมังกร ซ้าย -> ขวา
        g2.setColor(Color.BLACK);
        bezierCurve(g2, 0, 362, 0, 357, 13, 361, 13, 366); //แถว1
        bezierCurve(g2, 42, 383, 28, 368, 21, 387, 27, 391);//แถว2
        bezierCurve(g2, 27, 391, 13, 378, 7, 399, 14, 402);
        bezierCurve(g2, 14, 402, 6, 399, 3, 400, 0, 404);
        bresenhamLine(g2, 0, 413, 4, 418);
        bezierCurve(g2, 68, 402, 60, 386, 44, 403, 53, 410);//แถว3
        bezierCurve(g2, 53, 410, 43, 396, 31, 414, 39, 421);
        bezierCurve(g2, 39, 421, 25, 410, 19, 430, 28, 432);
        bezierCurve(g2, 28, 432, 18, 426, 10, 444, 21, 448);
        bezierCurve(g2, 21, 448, 8, 444, 5, 463, 16, 465);
        bezierCurve(g2, 16, 465, 4, 462, 4, 483, 15, 480);
        bezierCurve(g2, 90, 419, 80, 406, 70, 423, 77, 428);//แถว4
        bezierCurve(g2, 77, 428, 69, 417, 54, 428, 63, 438);
        bezierCurve(g2, 63, 438, 54, 428, 41, 444, 52, 450);
        bezierCurve(g2, 52, 450, 42, 444, 31, 459, 43, 465);
        bezierCurve(g2, 43, 465, 28, 461, 28, 482, 38, 482);
        bezierCurve(g2, 38, 482, 28, 479, 24, 497, 37, 499);
        bezierCurve(g2, 113, 437, 114, 431, 93, 426, 98, 445);//แถว5
        bezierCurve(g2, 98, 445, 89, 433, 76, 450, 85, 455);
        bezierCurve(g2, 85, 455, 73, 447, 67, 462, 73, 468);
        bezierCurve(g2, 73, 468, 64, 463, 54, 475, 65, 482);
        bezierCurve(g2, 65, 482, 53, 481, 49, 497, 61, 500);
        bezierCurve(g2, 61, 500, 50, 498, 47, 515, 61, 518);
        bezierCurve(g2, 134, 452, 133, 446, 115, 443, 120, 461); //แถว6
        bezierCurve(g2, 120, 461, 109, 451, 99, 469, 107, 472);
        bezierCurve(g2, 107, 472, 99, 465, 85, 478, 98, 487);
        bezierCurve(g2, 98, 487, 84, 480, 78, 495, 89, 503);
        bezierCurve(g2, 89, 503, 77, 495, 72, 516, 86, 518);
        bezierCurve(g2, 86, 518, 73, 517, 76, 537, 89, 536);
        bezierCurve(g2, 147, 460, 145, 459, 136, 467, 141, 475); //แถว7
        bezierCurve(g2, 141, 475, 132, 465, 123, 480, 129, 486);
        bezierCurve(g2, 129, 486, 122, 482, 109, 494, 121, 502);
        bezierCurve(g2, 121, 502, 104, 498, 106, 515, 114, 518);
        bezierCurve(g2, 114, 518, 106, 513, 96, 531, 115, 535);
        bezierCurve(g2, 115, 535, 99, 534, 107, 556, 119, 552);
        bezierCurve(g2, 161, 478, 160, 478, 160, 483, 163, 484);//แถว8
        bezierCurve(g2, 163, 484, 158, 479, 143, 487, 154, 499);
        bezierCurve(g2, 154, 499, 142, 491, 137, 514, 147, 515);
        bezierCurve(g2, 147, 515, 137, 510, 129, 525, 143, 531);
        bezierCurve(g2, 143, 531, 131, 528, 131, 552, 147, 549);
        bezierCurve(g2, 147, 549, 129, 551, 142, 572, 154, 564);
        bezierCurve(g2, 178, 490, 173, 495, 172, 501, 179, 506);//แถว9
        bezierCurve(g2, 179, 506, 172, 500, 160, 519, 175, 522);
        bezierCurve(g2, 175, 522, 159, 521, 162, 543, 178, 541);
        bezierCurve(g2, 178, 541, 160, 538, 162, 559, 181, 556);
        bezierCurve(g2, 181, 556, 167, 559, 179, 580, 193, 570);
        bezierCurve(g2, 201, 507, 187, 517, 199, 527, 204, 524);//แถว10
        bezierCurve(g2, 204, 524, 187, 530, 199, 544, 207, 542);
        bezierCurve(g2, 207, 542, 197, 544, 198, 563, 217, 556);
        bezierCurve(g2, 217, 556, 203, 564, 220, 579, 231, 568);
        bezierCurve(g2, 251, 549, 244, 544, 254, 574, 268, 557);//แถว11
        bezierCurve(g2, 240, 552, 244, 553, 246, 553, 251, 549);
        bresenhamLine(g2, 228, 526, 233, 521);
        bresenhamLine(g2, 233, 521, 227, 520);
        bresenhamLine(g2, 239, 538, 241, 536);
        bresenhamLine(g2, 241, 536, 237, 536);
        bezierCurve(g2, 248, 505, 251, 512, 253, 514, 260, 511);//แถว12
        bezierCurve(g2, 260, 511, 251, 513, 253, 533, 270, 526);
        bezierCurve(g2, 270, 526, 258, 535, 279, 548, 284, 535);
        bezierCurve(g2, 284, 535, 278, 549, 296, 552, 304, 539);
        bezierCurve(g2, 258, 462, 257, 465, 259, 468, 265, 468);//แถว13
        bezierCurve(g2, 265, 468, 258, 469, 263, 487, 274, 481);
        bezierCurve(g2, 274, 481, 265, 487, 273, 504, 284, 496);
        bezierCurve(g2, 284, 496, 275, 504, 290, 519, 298, 505);
        bezierCurve(g2, 298, 505, 287, 519, 308, 527, 314, 512);
        bezierCurve(g2, 314, 512, 309, 527, 331, 527, 333, 512);
        bezierCurve(g2, 270, 437, 259, 445, 275, 456, 281, 450);//แถว14
        bezierCurve(g2, 281, 450, 273, 452, 277, 473, 291, 463);
        bezierCurve(g2, 291, 463, 282, 473, 300, 486, 305, 473);
        bezierCurve(g2, 305, 473, 296, 485, 312, 495, 319, 483);
        bezierCurve(g2, 319, 483, 318, 489, 319, 493, 326, 494);
        bezierCurve(g2, 338, 492, 350, 497, 357, 489, 354, 482);
        bezierCurve(g2, 290, 433, 289, 437, 292, 449, 306, 440);//แถว15
        bezierCurve(g2, 306, 440, 297, 448, 314, 463, 321, 448);
        bezierCurve(g2, 321, 448, 314, 464, 330, 465, 336, 458);
        bezierCurve(g2, 355, 462, 358, 467, 375, 462, 370, 450);
        bezierCurve(g2, 301, 410, 298, 414, 307, 426, 316, 416);//แถว16
        bezierCurve(g2, 316, 416, 311, 421, 321, 438, 336, 424);
        bezierCurve(g2, 336, 424, 332, 429, 339, 435, 344, 432);
        bezierCurve(g2, 368, 428, 378, 443, 388, 422, 382, 421);
        bezierCurve(g2, 299, 371, 288, 373, 302, 394, 311, 380);//แถว17
        bezierCurve(g2, 311, 380, 305, 393, 319, 399, 326, 392);
        bezierCurve(g2, 326, 392, 322, 400, 335, 407, 341, 398);
        bezierCurve(g2, 370, 407, 374, 406, 377, 403, 376, 396);
        bezierCurve(g2, 376, 396, 374, 407, 397, 408, 392, 389);
        bezierCurve(g2, 305, 344, 298, 350, 306, 365, 319, 355);//แถว18
        bezierCurve(g2, 319, 355, 311, 369, 334, 373, 334, 363);
        bezierCurve(g2, 334, 363, 332, 377, 345, 380, 350, 371);
        bezierCurve(g2, 367, 370, 367, 382, 387, 380, 384, 367);
        bezierCurve(g2, 384, 367, 390, 381, 405, 370, 400, 361);
        bezierCurve(g2, 309, 322, 306, 327, 317, 340, 325, 328);//แถว19
        bezierCurve(g2, 325, 328, 318, 340, 336, 347, 341, 336);
        bezierCurve(g2, 341, 336, 337, 348, 353, 353, 357, 341);
        bezierCurve(g2, 357, 341, 356, 354, 375, 354, 374, 342);
        bezierCurve(g2, 374, 342, 375, 357, 396, 349, 390, 338);
        bezierCurve(g2, 390, 338, 395, 352, 414, 340, 406, 330);

        g2.setColor(moon);
        bezierCurve(g2, 600, 582, 568, 587, 546, 557, 540, 546);
        bezierCurve(g2, 540, 546, 511, 549, 502, 538, 496, 528);
        bezierCurve(g2, 496, 528, 373, 541, 429, 499, 356, 471);
        bezierCurve(g2, 356, 471, 385, 451, 431, 540, 487, 477);
        bezierCurve(g2, 487, 477, 490, 462, 503, 441, 538, 443);
        bezierCurve(g2, 538, 443, 542, 433, 546, 433, 552, 433);
        bezierCurve(g2, 552, 433, 562, 408, 593, 409, 600, 415);
        g2.setColor(Color.BLACK);
        bezierCurve(g2, 540, 546, 537, 540, 540, 506, 549, 503);
        bezierCurve(g2, 538, 443, 527, 452, 548, 473, 562, 459);
        bezierCurve(g2, 600, 431, 591, 435, 590, 479, 589, 465);
        
        g.drawImage(buffer, 0, 0, null);
    }

    private void drawCircleBorder(Graphics g, int xc, int yc, int r, Color color) {
        g.setColor(color);
        int x = 0;
        int y = r;
        int Dx = 2 * x;
        int Dy = 2 * y;
        int D = 1 - r;

        while (x <= y) {
            g.fillRect(xc + x, yc + y, 1, 1);
            g.fillRect(xc - x, yc + y, 1, 1);
            g.fillRect(xc + x, yc - y, 1, 1);
            g.fillRect(xc - x, yc - y, 1, 1);

            g.fillRect(xc + y, yc + x, 1, 1);
            g.fillRect(xc - y, yc + x, 1, 1);
            g.fillRect(xc + y, yc - x, 1, 1);
            g.fillRect(xc - y, yc - x, 1, 1);

            x += 1;
            Dx += 2;
            D += Dx + 1;

            if (D >= 0) {
                y = y - 1;
                Dy -= 2;
                D -= Dy;
            }
        }

    }

    private void bezierCurve(Graphics g, int x1, int y1, int x2, int y2, int x3, int y3, int x4, int y4) {
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