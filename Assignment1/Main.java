import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseAdapter;
import java.awt.*;
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
        Color firework = Color.decode("#ffb753");
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
        g.drawImage(buffer, 0, 0, null);

        //ลายดวงจันทร์
        g2.setColor(moonInside);
        bezierCurve(g2, 76, 243, 204, 110, 340, 168, 336, 23);
        bezierCurve(g2, 76, 243, 73, 262, 79, 296, 90, 323);
        bezierCurve(g2, 336, 23, 343, 25, 352, 27, 354, 28);
        bezierCurve(g2, 90, 323, 136, 297, 191, 254, 213, 222);
        bezierCurve(g2, 213, 222, 231, 195, 266, 170, 294, 151);
        bezierCurve(g2, 294, 151, 325, 135, 356, 80, 354, 28);
        buffer = floodFill(buffer, 144, 229, moon, moonInside);
        g.drawImage(buffer, 0, 0, null);

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
        g.drawImage(buffer, 0, 0, null);

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
        g.drawImage(buffer, 0, 0, null);
        buffer = floodFill(buffer, 270, 233, moonInside, fur);
        g.drawImage(buffer, 0, 0, null);

        // หูใน
        g2.setColor(upperDragon);
        bezierCurve(g2, 344, 228, 332, 236, 318, 241, 300, 243);
        bresenhamLine(g2, 300, 243, 305, 235);
        bezierCurve(g2, 305, 235, 296, 240, 281, 244, 276, 241);
        bezierCurve(g2, 305, 235, 296, 240, 281, 244, 276, 241);
        bresenhamLine(g2, 276, 241, 303, 217);
        bezierCurve(g2, 303, 217, 312, 210, 327, 206, 347, 209);
        buffer = floodFill(buffer, 315, 226, fur, upperDragon);
        g.drawImage(buffer, 0, 0, null);
        // เขา
        g2.setColor(Color.decode("#383F50"));
        bezierCurve(g2, 279, 209, 268, 204, 255, 194, 251, 183);
        bezierCurve(g2, 251, 183, 265, 179, 288, 184, 316, 195);
        buffer = floodFill(buffer, 284, 194, moonInside, Color.decode("#383F50"));
        g.drawImage(buffer, 0, 0, null);
        buffer = floodFill(buffer, 264, 190, moon, Color.decode("#383F50"));
        g.drawImage(buffer, 0, 0, null);

        g2.setColor(Color.decode("#232933"));
        bezierCurve(g2, 289, 187, 281, 179, 275, 172, 274, 160);
        bezierCurve(g2, 274, 160, 298, 166, 319, 176, 339, 193);
        buffer = floodFill(buffer, 299, 180, moonInside, Color.decode("#232933"));
        g.drawImage(buffer, 0, 0, null);
        buffer = floodFill(buffer, 285, 171, moon, Color.decode("#232933"));
        g.drawImage(buffer, 0, 0, null);
        buffer = floodFill(buffer, 329, 190, moon, Color.decode("#232933"));
        g.drawImage(buffer, 0, 0, null);
        buffer = floodFill(buffer, 276, 163, moonInside, Color.decode("#232933"));
        g.drawImage(buffer, 0, 0, null);

        // ไฟกระพริบ
        g2.setColor(firework);
        bezierCurve(g2, 203, 185, 215, 183, 218, 177, 217, 167);
        bezierCurve(g2, 217, 167, 219, 177, 221, 183, 233, 186);
        bezierCurve(g2, 203, 185, 215, 186, 219, 191, 218, 202);
        bezierCurve(g2, 218, 202, 219, 192, 223, 186, 233, 186);
        buffer = floodFill(buffer, 218, 188, moonInside, firework);
        g.drawImage(buffer, 0, 0, null);

        
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
        bezierCurve(g2, 130, 297, 130, 306, 148, 322, 176, 331);
        bezierCurve(g2, 130, 297, 128, 290, 130, 281, 142, 281);
        bezierCurve(g2, 142, 281, 150, 280, 174, 286, 196, 300);
        bezierCurve(g2, 176, 331, 183, 357, 198, 372, 228, 376);
        bezierCurve(g2, 228, 376, 265, 371, 284, 365, 290, 332);//
        bezierCurve(g2, 196, 300, 215, 290, 235, 285, 263, 311);
        bezierCurve(g2, 263, 311, 259, 310, 269, 317, 290, 332);//
        buffer = floodFill(buffer, 209, 320, moonInside, bodyRabbit);
        g.drawImage(buffer, 0, 0, null);
        buffer = floodFill(buffer, 218, 356, moon, bodyRabbit);
        g.drawImage(buffer, 0, 0, null);
        buffer = floodFill(buffer, 143, 303, moon, bodyRabbit);
        g.drawImage(buffer, 0, 0, null);
        buffer = floodFill(buffer, 137, 286, moonInside, bodyRabbit);
        g.drawImage(buffer, 0, 0, null);

        g2.setColor(Color.decode("#C9A686"));
        bezierCurve(g2, 160, 283, 156, 268, 159, 260, 174, 259);
        bezierCurve(g2, 174, 259, 192, 270, 205, 279, 216, 292);
        buffer = floodFill(buffer, 180, 277, moon, Color.decode("#C9A686"));
        g.drawImage(buffer, 0, 0, null);
        buffer = floodFill(buffer, 164, 268, moonInside, Color.decode("#C9A686"));
        g.drawImage(buffer, 0, 0, null);
        buffer = floodFill(buffer, 207, 292, moonInside, Color.decode("#C9A686"));
        g.drawImage(buffer, 0, 0, null);

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
        g.drawImage(buffer, 0, 0, null);

        //คิ้ว
        g2.setColor(Color.white);
        bezierCurve(g2, 243, 316, 239, 320, 232, 314, 238, 310);
        bezierCurve(g2, 238, 310, 248, 302, 255, 312, 243, 316);
        buffer = floodFill(buffer, 243, 314, bodyRabbit, Color.WHITE);
        g.drawImage(buffer, 0, 0, null);

        // จมูก 
        g2.setColor(Color.BLACK);
        bezierCurve(g2, 290, 332, 288, 335, 279, 332, 279, 327);
        bezierCurve(g2, 279, 327, 285, 323, 293, 325, 290, 332);
        buffer = floodFill(buffer, 283, 331, Color.decode("#E4CBBA"), Color.BLACK);
        g.drawImage(buffer, 0, 0, null);
        buffer = floodFill(buffer, 288, 329, moon, Color.BLACK);
        g.drawImage(buffer, 0, 0, null);

        // หูข้างในกระต่าย
        g2.setColor(Color.decode("#C9A686"));
        bezierCurve(g2, 180, 319, 175, 313, 179, 308, 187, 307);
        bezierCurve(g2, 180, 319, 163, 317, 150, 308, 148, 298);
        bezierCurve(g2, 148, 298, 157, 293, 170, 297, 187, 307);
        buffer = floodFill(buffer, 165, 308, bodyRabbit, Color.decode("#C9A686"));
        g.drawImage(buffer, 0, 0, null);

        // ตัวกระต่าย
        g2.setColor(Color.decode("#A12B2D"));
        bresenhamLine(g2, 267, 431, 265, 445);
        bezierCurve(g2, 151, 437, 158, 404, 171, 379, 188, 358);
        bezierCurve(g2, 285, 432, 264, 434, 242, 429, 226, 409);
        bresenhamLine(g2, 275, 378, 268, 380);
        bresenhamLine(g2, 268, 380, 267, 366);
        bezierCurve(g2, 156, 420, 186, 428, 221, 432, 266, 437);
        buffer = floodFill(buffer, 207, 398, moon, Color.decode("#A12B2D"));
        g.drawImage(buffer, 0, 0, null);
        buffer = floodFill(buffer, 186, 367, moonInside, Color.decode("#A12B2D"));
        g.drawImage(buffer, 0, 0, null);
        int[] xPoly = { 155, 268, 266, 151 };
        int[] yPoly = { 418, 435, 447, 437 };
        int nPoints = xPoly.length;
        Polygon polygon = new Polygon(xPoly, yPoly, nPoints);
        gradientPaint = new GradientPaint(208, 431, Color.decode("#A12B2D"), 205, 445, Color.decode("#721F1D"));
        g2.setPaint(gradientPaint);
        g2.fillPolygon(polygon);

        g2.setColor(Color.decode("#721F1D"));
        bresenhamLine(g2, 152, 437, 266, 445);
        bezierCurve(g2, 152, 437, 172, 449, 219, 460, 266, 445);
        buffer = floodFill(buffer, 216, 449, moon, Color.decode("#721F1D"));
        g.drawImage(buffer, 0, 0, null);
        buffer = floodFill(buffer, 187, 445, background, Color.decode("#721F1D"));
        g.drawImage(buffer, 0, 0, null);


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
        g.drawImage(buffer, 0, 0, null);
        buffer = floodFill(buffer, 159, 452, background, Color.decode("#C18543"));
        g.drawImage(buffer, 0, 0, null);

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
        g.drawImage(buffer, 0, 0, null);
        buffer = floodFill(buffer, 199, 492, background, bodyRabbit);
        g.drawImage(buffer, 0, 0, null);

        // ตัวมังกร
        g2.setColor(upperDragon); //รั่ว งง
        bezierCurve(g2, 304, 300, 316, 306, 337, 312, 363, 312);
        bezierCurve(g2, 0, 348, 72, 381, 136, 453, 153, 454);
        bezierCurve(g2, 287, 376, 296, 351, 304, 317, 304, 300);
        // buffer = floodFill(buffer, 95, 448, background, upperDragon);
        g.drawImage(buffer, 0, 0, null);
        g2.setColor(lowerdragon);
        bezierCurve(g2, 363, 312, 371, 314, 401, 324, 423, 317);
        bezierCurve(g2, 423, 317, 388, 462, 350, 543, 250, 575);
        bezierCurve(g2, 250, 575, 136, 595, 73, 541, 0, 482);
        bezierCurve(g2, 363, 312, 361, 367, 325, 491, 235, 535);
        bezierCurve(g2, 215, 545, 70, 519, 101, 519, 0, 442);
        buffer = floodFill(buffer, 145, 548, background, lowerdragon);
        buffer = floodFill(buffer, 366, 384, moon, lowerdragon);
        g.drawImage(buffer, 0, 0, null);
        

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
        g.drawImage(buffer, 0, 0, null);

        //E
        bezierCurve(g2, 65, 76, 65, 59, 88, 59, 88, 76);
        bezierCurve(g2, 65, 76, 65, 89, 82, 92, 86, 85);
        bresenhamLine(g2, 70, 76, 88, 76);
        bezierCurve(g2, 70, 76, 70, 88, 86, 83, 86, 82);
        bresenhamLine(g2, 86, 82, 86, 85);
        bezierCurve(g2, 70, 72, 70, 65, 84, 65, 84, 72);
        bresenhamLine(g2, 70, 72, 84, 72);
        buffer = floodFill(buffer, 68, 78, background, Color.WHITE);
        g.drawImage(buffer, 0, 0, null);

        buffer = floodFill(buffer, 219, 182, background, upperDragon);
        g.drawImage(buffer, 0, 0, null);

        g2.setColor(firework); // ดาวใต้คางมังกร
        bezierCurve(g2, 447, 347, 444, 357, 441, 365, 433, 366);
        bezierCurve(g2, 447, 347, 444, 357, 450, 365, 462, 366);
        bezierCurve(g2, 462, 366, 451, 363, 444, 374, 445, 380);
        bezierCurve(g2, 433, 366, 443, 360, 448, 380, 445, 380);
        buffer = floodFill(buffer, 444, 364, moon, firework);
        g.drawImage(buffer, 0, 0, null);

        g2.setColor(Cloud); // เมฆ
        bezierCurve(g2, 366, 453, 389, 446, 406, 472, 444, 477);
        bezierCurve(g2, 444, 477, 475, 478, 484, 471, 490, 458);
        bezierCurve(g2, 490, 458, 498, 437, 507, 422, 542, 423);
        bezierCurve(g2, 542, 423, 538, 416, 557, 411, 557, 414);
        bezierCurve(g2, 557, 414, 555, 399, 573, 389, 600, 399);
        bezierCurve(g2, 366, 453, 392, 451, 387, 481, 414, 494);
        bezierCurve(g2, 414, 494, 429, 504, 452, 512, 479, 506);
        bezierCurve(g2, 479, 506, 486, 523, 499, 527, 526, 523);
        bezierCurve(g2, 526, 523, 536, 542, 562, 560, 600, 537);
        buffer = floodFill(buffer, 527, 456, background, Cloud);
        buffer = floodFill(buffer, 375, 452, moon, Cloud);
        buffer = floodFill(buffer, 381, 454, moon, Cloud);
        buffer = floodFill(buffer, 379, 454, lowerdragon, Cloud);
        g.drawImage(buffer, 0, 0, null);

        g2.setColor(Color.BLACK); // เส้นเมฆ
        bezierCurve(g2, 542, 423, 529, 436, 547, 449, 557, 440);
        bezierCurve(g2, 600, 412, 588, 414, 575, 414, 571, 443);
        bezierCurve(g2, 526, 523, 516, 507, 520, 487, 533, 482);
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