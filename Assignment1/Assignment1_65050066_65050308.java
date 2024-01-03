import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.*;
import java.util.Queue;

public class Assignment1_65050066_65050308 extends JPanel {

    private BufferedImage buffer;
    private int[] xPoly, yPoly;

    public static void main(String[] args) {
        Assignment1_65050066_65050308 m = new Assignment1_65050066_65050308();

        JFrame f = new JFrame();
        f.add(m);
        f.setTitle("Assignment1_65050066_65050308");
        f.setSize(600, 600);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
        f.setLocationRelativeTo(null);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        buffer = new BufferedImage(600, 600, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2 = buffer.createGraphics();

        Color background = Color.decode("#354052");
        // ใส่สีพื้นหลัง
        g2.setColor(background);
        g2.fillRect(0, 0, 600, 600);
        g.drawImage(buffer, 0, 0, null);

        // กำหนดสี
        Color star = Color.decode("#f0bf5f");
        Color lowerdragon = Color.decode("#a12b2b");
        Color upperDragon = Color.decode("#ed563d");
        Color moon = Color.decode("#526681");
        Color moonInside = Color.decode("#627697");
        Color bodyRabbit = Color.decode("#E4CBBA");

        Point startPoint = new Point(50, 50);
        Point endPoint = new Point(250, 250);
        Color startColor = Color.RED;
        Color endColor = Color.YELLOW;
        GradientPaint gradientPaint = new GradientPaint(startPoint, startColor, endPoint, endColor);
        int nPoints;
        Polygon polygon;

        // มังกร
        //หัวมังกร
        //กรอบหัว
        g2.setColor(upperDragon);
        bezierCurve(g2, 500, 214, 504, 208, 510, 191, 512, 198);
        bresenhamLine(g2, 512, 198, 500, 189);
        bezierCurve(g2, 500, 189, 486, 204, 475, 193, 475, 193);
        bresenhamLine(g2, 434, 175, 475, 193);
        bresenhamLine(g2, 341, 188, 434, 175);
        bresenhamLine(g2, 341, 188, 272, 237);
        bresenhamLine(g2, 272, 237, 306, 254);
        bresenhamLine(g2, 306, 254, 307, 312);
        bezierCurve(g2, 307, 312, 324, 338, 419, 328, 449, 304);
        bresenhamLine(g2, 449, 304, 450, 267);
        bresenhamLine(g2, 450, 267, 447,261);
        bresenhamLine(g2, 447, 261, 454,265);
        bresenhamLine(g2, 454, 265, 500,214);
        buffer = floodFill(buffer, 488, 212, background, upperDragon);
        //ครีบนอกมังกร
        g2.setColor(Color.decode("#f2e8df"));
        bezierCurve(g2, 301, 297, 306, 300, 330, 258, 330,258);
        bezierCurve(g2, 330, 258, 338, 251, 356, 237, 377, 236);
        bezierCurve(g2, 377, 236, 386, 263, 405, 272, 424, 280);
        bezierCurve(g2, 424, 280, 446, 309, 409, 312, 400, 325);
        bezierCurve(g2, 400, 325, 400, 325, 422, 305, 416, 294);
        bezierCurve(g2, 416, 294, 407, 316, 383, 294, 350, 321);
        bezierCurve(g2, 350, 321, 347, 303, 364, 292, 366, 279);
        bezierCurve(g2, 366, 279, 360, 298, 344, 311, 301, 297);
        buffer = floodFill(buffer, 362, 256, upperDragon, Color.decode("#f2e8df"));
        buffer = floodFill(buffer, 306, 296, background, Color.decode("#f2e8df"));
        //ครีบในมังกร
        g2.setColor(Color.decode("#c9a687"));
        bezierCurve(g2, 370, 246, 383, 271, 415, 283, 424, 283);
        bresenhamLine(g2, 424, 283, 419,303);
        bezierCurve(g2, 419, 303, 418, 273, 401, 310, 362, 301);
        bezierCurve(g2, 362, 301, 371, 298, 388, 247, 327, 286);
        bezierCurve(g2, 327, 286, 339, 278, 345, 246,370, 246);
        buffer = floodFill(buffer, 383, 284, Color.decode("#f2e8df"), Color.decode("#c9a687"));
        //ปากล่าง
        g2.setColor(Color.decode("#f2e8df"));
        bresenhamLine(g2, 424, 280, 450,267);
        bezierCurve(g2, 450, 267, 484, 293, 508, 249, 509, 239);
        bezierCurve(g2, 509, 239, 518, 181, 552, 216, 553, 193);
        bezierCurve(g2, 553, 193, 579, 225, 561, 252, 556, 259);
        bezierCurve(g2, 556, 259, 484, 289, 535, 309, 424, 280);
        buffer = floodFill(buffer, 524, 252, background, Color.decode("#f2e8df"));
        buffer = floodFill(buffer, 441, 279, upperDragon, Color.decode("#f2e8df"));
        //เครา
        g2.setColor(Color.decode("#f2e8df"));
        bresenhamLine(g2, 451, 284, 427,320);
        bezierCurve(g2, 427, 320, 437, 325, 452, 317, 455, 310);
        bezierCurve(g2, 455, 310, 463, 321, 501, 314, 509, 311);
        bezierCurve(g2, 509, 311, 523, 332, 555, 316, 546, 355);
        bezierCurve(g2, 546, 355, 564, 338, 555, 329, 557, 323);
        bresenhamLine(g2, 557, 323, 562,324);
        bezierCurve(g2, 562, 324, 569, 308, 563, 288, 554, 284);
        bezierCurve(g2, 554, 284, 558, 274, 584, 255, 556, 259);
        buffer = floodFill(buffer, 532, 300, background, Color.decode("#f2e8df"));
        buffer = floodFill(buffer, 446, 304, upperDragon, Color.decode("#f2e8df"));
        // เส้นคั่นปากกับเครา
        g2.setColor(background);
        bezierCurve(g2, 448, 287, 526, 313, 507, 265, 556, 259);
        //ปากบน
        g2.setColor(Color.decode("#f2e8df"));
        bresenhamLine(g2, 454, 265, 500,214);
        bezierCurve(g2, 454, 265, 502, 276, 493, 232, 500, 214);
        buffer = floodFill(buffer, 480, 256, background, Color.decode("#f2e8df"));
        
        //จมูกมังกร
        g2.setColor(Color.BLACK);
        bresenhamLine(g2, 500, 189, 505,186);
        bresenhamLine(g2, 512, 198, 518,191);
        bresenhamLine(g2, 505, 186, 518,191);
        buffer = floodFill(buffer, 510, 193, background, Color.BLACK);

        g2.setColor(upperDragon);
        bresenhamLine(g2, 505, 186, 502,181);
        bresenhamLine(g2, 502, 181, 505,178);
        bresenhamLine(g2, 518, 191, 527,186);
        bezierCurve(g2, 505, 178, 527, 192, 534, 183, 527,186);
        buffer = floodFill(buffer, 513, 186, background, upperDragon);

        g2.setColor(upperDragon);
        bezierCurve(g2, 530, 185, 550, 174, 532, 155, 512, 167);
        bezierCurve(g2, 505, 178, 497, 156, 558, 176, 527,186);
        buffer = floodFill(buffer, 531, 167, background, upperDragon);

        g2.setColor(Color.decode("#f2e8df"));
        bezierCurve(g2, 505, 178, 497, 156, 558, 176, 527,186);
        bezierCurve(g2, 505, 178, 527, 192, 534, 183, 527,186);
        buffer = floodFill(buffer, 523, 176, background, Color.decode("#f2e8df"));

        g2.setColor(star);
        bezierCurve(g2, 475, 193, 462, 166, 447, 178, 447, 178);
        bezierCurve(g2, 475, 193, 459, 209, 447, 178, 447, 178);
        buffer = floodFill(buffer, 461, 184, background, star);
        buffer = floodFill(buffer, 466, 193, upperDragon, star);

        //ตามังกร
        g2.setColor(Color.decode("#a22c2b"));
        bezierCurve(g2, 394, 231, 278, 174, 464, 153, 458, 217);
        bezierCurve(g2, 394, 231, 349, 271, 475, 257, 458, 217);
        buffer = floodFill(buffer, 386, 217, upperDragon, Color.decode("#a22c2b"));

        g2.setColor(Color.white);
        bezierCurve(g2, 399, 196, 399, 196, 418, 181, 446, 191);
        bezierCurve(g2, 399, 196, 368, 256, 491, 258, 446, 191);
        buffer = floodFill(buffer, 436, 210, Color.decode("#a22c2b"), Color.white);

        g2.setColor(Color.BLACK);
        bezierCurve(g2, 408, 208, 407, 198, 434, 177, 445, 211);
        bezierCurve(g2, 408, 208, 412, 254, 450, 225, 445, 211);
        buffer = floodFill(buffer, 436, 210, Color.white, Color.black);

        g2.setColor(Color.decode("#c9a687"));
        bezierCurve(g2, 447, 192, 422, 148, 421, 173, 350, 178);
        bezierCurve(g2, 350, 178, 338, 192, 420, 174, 370, 201);
        bezierCurve(g2, 370, 201, 406, 201, 405, 176, 447, 192);
        buffer = floodFill(buffer, 398, 188, Color.decode("#a22c2b"), Color.decode("#c9a687"));
        buffer = floodFill(buffer, 433, 177, upperDragon, Color.decode("#c9a687"));
        buffer = floodFill(buffer, 412, 172, background, Color.decode("#c9a687"));
        buffer = floodFill(buffer, 387, 180, background, Color.decode("#c9a687"));
        buffer = floodFill(buffer, 439, 188, Color.white, Color.decode("#c9a687"));

        //หูมังกร
        g2.setColor(Color.decode("#f2e8df"));
        bresenhamLine(g2, 347, 191, 345, 229);
        bezierCurve(g2,347, 191, 300, 176, 249, 229, 245, 256);
        bezierCurve(g2,245, 256, 245, 256, 345, 258, 345, 229);
        buffer = floodFill(buffer, 255, 247, background, Color.decode("#f2e8df"));
        buffer = floodFill(buffer, 293, 204, Color.decode("#383f50"), Color.decode("#f2e8df"));
        buffer = floodFill(buffer, 324, 191, Color.decode("#303436"), Color.decode("#f2e8df"));
        buffer = floodFill(buffer, 339, 197, upperDragon, Color.decode("#f2e8df"));
        buffer = floodFill(buffer, 295, 208, background, Color.decode("#f2e8df"));
        buffer = floodFill(buffer, 283, 211, Color.decode("#383f50"), Color.decode("#f2e8df"));
        buffer = floodFill(buffer, 311, 194, Color.decode("#383f50"), Color.decode("#f2e8df"));

        g2.setColor(upperDragon);
        bresenhamLine(g2, 350, 205, 346, 226);
        bezierCurve(g2,350, 205, 301, 209, 288, 226, 275, 234);
        bezierCurve(g2,275, 234,267, 245, 299, 229, 308, 233);
        bresenhamLine(g2, 308, 233, 298, 240);
        bezierCurve(g2,298, 240, 298, 240, 337, 234, 346, 226);
        buffer = floodFill(buffer, 310, 225, Color.decode("#f2e8df"),upperDragon);
        g.drawImage(buffer, 0, 0, null);

        //เขามังกร
        g2.setColor(Color.decode("#383f50"));
        bezierCurve(g2, 318, 189, 194, 150, 272, 206, 279, 207);
        // bezierCurve(g2, 279, 210, 281, 207, 303, 192, 318, 191);
        buffer = floodFill(buffer, 280, 193, background, Color.decode("#383f50"));

        g2.setColor(Color.decode("#303436"));
        bezierCurve(g2, 283, 175, 294, 200, 227, 104, 339, 188);
        buffer = floodFill(buffer, 309, 176, background, Color.decode("#303436"));

        //ตัวมังกร
        g2.setColor(lowerdragon);
        bezierCurve(g2, 423, 315, 388, 462, 350, 543, 250, 575);
        bezierCurve(g2, 250, 575, 136, 595, 73, 541, 0, 482);
        bezierCurve(g2, 361, 329, 382, 329, 400, 325, 423, 317);
        g.drawImage(buffer, 0, 0, null);

        g2.setColor(upperDragon);
        bezierCurve(g2, 0, 348, 72, 381, 136, 453, 153, 452);
        bresenhamLine(g2, 153, 452, 287, 377);
        bezierCurve(g2, 287, 377, 296, 351, 304, 317, 315, 300);
        bezierCurve(g2, 0, 440, 84, 478, 92, 549, 222, 549);
        bresenhamLine(g2, 222, 549, 241, 546);
        bezierCurve(g2, 241, 546, 326, 513, 362, 360, 361, 329);
        buffer = floodFill(buffer, 86, 432, background,upperDragon);
        g.drawImage(buffer, 0, 0, null);

        xPoly = new int[] {338, 395, 327, 275};
        yPoly = new int[] {326, 325, 509, 502};
        nPoints = xPoly.length;
        polygon = new Polygon(xPoly, yPoly, nPoints);
        gradientPaint = new GradientPaint(318, 396, upperDragon, 359, 412, lowerdragon);
        g2.setPaint(gradientPaint);
        g2.fillPolygon(polygon);

        xPoly = new int[] {0, 206, 197, 0};
        yPoly = new int[] {408, 521, 576, 468};
        polygon = new Polygon(xPoly, yPoly, nPoints);
        gradientPaint = new GradientPaint(106, 469, upperDragon, 90, 507, lowerdragon);
        g2.setPaint(gradientPaint);
        g2.fillPolygon(polygon);

        xPoly = new int[] {327, 275,  238, 255,};
        yPoly = new int[] {509, 502, 535, 557};
        polygon = new Polygon(xPoly, yPoly, nPoints);
        gradientPaint = new GradientPaint(267, 511, upperDragon, 287, 534, lowerdragon);
        g2.setPaint(gradientPaint);
        g2.fillPolygon(polygon);

        xPoly = new int[] {206, 197, 262, 207};
        yPoly = new int[] {521, 576, 566, 540};
        polygon = new Polygon(xPoly, yPoly, nPoints);
        gradientPaint = new GradientPaint(206, 521, upperDragon, 207, 548, lowerdragon);
        g2.setPaint(gradientPaint);
        g2.fillPolygon(polygon);


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
        g.drawImage(buffer, 0, 0, null);

        //Cloud
        g2.setColor(Color.decode("#45556c"));
        bezierCurve(g2,358, 468,387, 452, 380, 545, 493, 524);
        bezierCurve(g2,493, 524,514, 530, 508, 554, 544, 544);
        bezierCurve(g2,544, 544,542, 560, 575, 585, 600, 579);
        bezierCurve(g2,358, 468,380, 455, 433, 530, 485, 477);
        bezierCurve(g2,485, 477,479, 467, 518, 425, 538, 440);
        bezierCurve(g2,538, 440,534, 430, 550, 425, 554, 428);
        bezierCurve(g2,554, 428,561, 402, 600, 407, 600, 415);
        buffer = floodFill(buffer, 520, 499, background, Color.decode("#45556c"));
        xPoly = new int[]{600, 432, 425, 600};
        yPoly = new int[]{523, 524, 507, 500};
        nPoints = xPoly.length;
        polygon = new Polygon(xPoly, yPoly, nPoints);
        gradientPaint = new GradientPaint(529, 503, Color.decode("#45556c"), 532, 520,  moon);
        g2.setPaint(gradientPaint);
        g2.fillPolygon(polygon);
        g2.setColor(Color.black);
        bezierCurve(g2,544, 544,531, 525, 547, 495, 549, 502);
        bezierCurve(g2,538, 440,532, 447, 538, 471, 564, 459);
        bezierCurve(g2,600, 415,575, 458, 585, 459, 585, 459);
        buffer = floodFill(buffer, 579, 544, Color.decode("#45556c"), moon);
        

        //rabbit
        // แขนเสื้อกระต่าย
        g2.setColor(Color.decode("#C18543"));
        bresenhamLine(g2, 287, 377, 301, 432);
        bresenhamLine(g2, 287, 377, 275, 378);
        bresenhamLine(g2, 275, 378, 285, 432);
        bresenhamLine(g2, 285, 432, 301, 432);
        buffer = floodFill(buffer, 284, 404, upperDragon, Color.decode("#C18543"));
        buffer = floodFill(buffer, 279, 380, background, Color.decode("#C18543"));
        g2.setColor(bodyRabbit);
        bezierCurve(g2, 290, 384, 312, 387, 308, 411, 296, 411);
        buffer = floodFill(buffer, 299, 398, upperDragon, bodyRabbit);
        g.drawImage(buffer, 0, 0, null);

        // หัวกระต่าย
        bezierCurve(g2, 130, 297, 130, 306, 148, 322, 176, 331);
        bezierCurve(g2, 130, 297, 128, 290, 130, 281, 142, 281);
        bezierCurve(g2, 142, 281, 150, 280, 174, 286, 196, 300);
        bezierCurve(g2, 176, 331, 183, 357, 198, 372, 228, 376);
        bezierCurve(g2, 228, 376, 265, 371, 284, 365, 290, 332);
        bezierCurve(g2, 196, 300, 215, 290, 235, 285, 263, 311);
        bezierCurve(g2, 263, 311, 259, 310, 269, 317, 290, 332);
        buffer = floodFill(buffer, 209, 320, background, bodyRabbit);
        
        //หูข้างในกระต่าย
        g2.setColor(Color.decode("#C9A686"));
        bezierCurve(g2, 160, 283, 156, 268, 159, 260, 174, 259);
        bezierCurve(g2, 174, 259, 192, 270, 205, 279, 216, 292);
        buffer = floodFill(buffer, 185, 279, background, Color.decode("#C9A686"));

        // หน้ากระต่าย
        g2.setColor(Color.BLACK);
        bresenhamLine(g2, 286, 333, 286, 339);
        bezierCurve(g2, 286, 339, 287, 341, 282, 341, 278, 338);
        bezierCurve(g2, 268, 327, 267, 322, 261, 321, 255, 324);
        bezierCurve(g2, 271, 335, 262, 333, 254, 334, 247, 337);
        bezierCurve(g2, 271, 337, 264, 337, 259, 338, 254, 342);
        bresenhamLine(g2, 282, 327, 295, 317);
        bresenhamLine(g2, 289, 328, 295, 324);
        g.drawImage(buffer, 0, 0, null);

        g2.setColor(upperDragon);
        bezierCurve(g2, 223, 339, 230, 316, 255, 326, 254, 341);
        bezierCurve(g2, 223, 339, 222, 368, 258, 356, 254, 341);
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
        buffer = floodFill(buffer, 288, 329, background, Color.BLACK);
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
        buffer = floodFill(buffer, 207, 398, background, Color.decode("#A12B2D"));
        buffer = floodFill(buffer, 268, 412, upperDragon, Color.decode("#A12B2D"));
        buffer = floodFill(buffer, 226, 417, upperDragon, Color.decode("#A12B2D"));
        xPoly = new int[] { 155, 268, 266, 151 };
        yPoly = new int[] { 418, 435, 447, 437 };
        nPoints = xPoly.length;
        polygon = new Polygon(xPoly, yPoly, nPoints);
        gradientPaint = new GradientPaint(208, 431, Color.decode("#A12B2D"), 205, 445, Color.decode("#721F1D"));
        g2.setPaint(gradientPaint);
        g2.fillPolygon(polygon);

        g2.setColor(Color.decode("#721F1D"));
        bresenhamLine(g2, 152, 437, 266, 445);
        bezierCurve(g2, 152, 437, 172, 449, 219, 460, 266, 445);
        buffer = floodFill(buffer, 168, 440, background, Color.decode("#721F1D"));
        buffer = floodFill(buffer, 185, 444, upperDragon, Color.decode("#721F1D"));

        //รอบเสื้อ
        g2.setColor(Color.BLACK);
        bezierCurve(g2, 285, 432, 264, 434, 242, 429, 226, 409);
        bresenhamLine(g2, 242, 408, 252, 407);
        bresenhamLine(g2, 246, 402, 248, 407);

        // แถบเสื้อล่างกระต่าย
        g2.setColor(Color.decode("#C18543"));
        bezierCurve(g2, 265, 445, 235, 458, 187, 453, 151, 437);
        bresenhamLine(g2, 265, 445, 260, 460);
        bresenhamLine(g2, 151, 437, 148, 450);
        bezierCurve(g2, 148, 450, 166, 459, 223, 474, 260, 460);
        buffer = floodFill(buffer, 159, 452, upperDragon, Color.decode("#C18543"));
        buffer = floodFill(buffer, 156, 443, background, Color.decode("#C18543"));

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
        buffer = floodFill(buffer, 256, 464, upperDragon, bodyRabbit);

        //ตูดกระต่าย
        g2.setColor(lowerdragon);
        bezierCurve(g2, 166, 476, 174, 487, 187, 504, 211, 512);
        buffer = floodFill(buffer, 202, 506, upperDragon, lowerdragon);
        
        //เติมเท้ากระต่าย
        buffer = floodFill(buffer, 235, 548, background, Color.decode("#E4CBBA"));

        //สีล่างมังกร
        buffer = floodFill(buffer, 130, 560, background, lowerdragon);
        buffer = floodFill(buffer, 141, 546, background, lowerdragon);
        buffer = floodFill(buffer, 182, 569, background, lowerdragon);
        buffer = floodFill(buffer, 389, 342, background, lowerdragon);
        buffer = floodFill(buffer, 244, 548, background, lowerdragon);
        buffer = floodFill(buffer, 247, 554, background, lowerdragon);

        //moon
        g2.setColor(moon);
        bezierCurve(g2,77, 254,70, 222, 118, 10, 333, 34);
        bezierCurve(g2,333, 34,274, 222, 191, 121, 77, 254);
        bezierCurve(g2,333, 34,333, 34, 370, 39, 370, 39);

        bezierCurve(g2, 370, 39, 362, 64, 338, 137, 297, 160);
        bezierCurve(g2, 257, 191, 245, 186, 183, 262, 185, 265);

        bezierCurve(g2,77, 254,75, 259, 84, 324, 90, 336);
        bresenhamLine(g2, 132, 306, 88, 334);

        bezierCurve(g2,90, 336,90, 336, 99, 360, 98, 354);
        bezierCurve(g2,98, 354,104, 366, 134, 412, 140, 411);
        bezierCurve(g2,98, 354,124, 352, 159, 333, 160, 325); //อาจจะทะลุ

        bezierCurve(g2,140, 411,136, 411, 164, 403, 160, 403);
        bezierCurve(g2,140, 411,136, 413, 150, 426, 153, 425);
    
        //ฝั่งขวาดวงจันทร์

        bezierCurve(g2,370, 39,367, 39, 375, 40, 377, 43);
        bezierCurve(g2,377, 43,368, 94, 329, 146, 306, 165);
        bezierCurve(g2,377, 43,378, 42, 404, 54, 408, 58);
        bresenhamLine(g2,408,58,335,189);

        bezierCurve(g2,408, 58,451, 75, 506, 145, 508, 168);//อาจทะลุ
        bezierCurve(g2,419, 335,440, 329, 450, 320, 455, 312);
        bezierCurve(g2,393, 419,412, 407, 498, 314, 499, 314);
        bezierCurve(g2,519, 319,503, 402, 411, 454, 373, 465);

        bezierCurve(g2, 211, 286, 229, 265, 213, 250, 271, 203);
        bresenhamLine(g2,288,254,253,303);
        buffer = floodFill(buffer, 262, 96, background, moon);
        buffer = floodFill(buffer, 297, 136, background, moonInside);
        buffer = floodFill(buffer, 431, 122, background, moon);
        buffer = floodFill(buffer, 364, 71, background, moon);
        buffer = floodFill(buffer, 426, 326, background, moon);
        buffer = floodFill(buffer, 450, 339, background, moonInside);
        buffer = floodFill(buffer, 466, 384, background, moon);
        buffer = floodFill(buffer, 375, 90, background, moonInside);
        buffer = floodFill(buffer, 126, 331, background, moon);
        buffer = floodFill(buffer, 150, 415, background, moon);
        buffer = floodFill(buffer, 144, 364, background, moonInside);
        buffer = floodFill(buffer, 279, 368, background, moon);
        buffer = floodFill(buffer, 203, 264, background, moon);
        buffer = floodFill(buffer, 252, 265, background, moonInside);
        g.drawImage(buffer, 0, 0, null);

        //star

        g2.setColor(star);
        bezierCurve(g2, 203, 185, 215, 183, 218, 177, 217, 167);
        bezierCurve(g2, 217, 167, 219, 177, 221, 183, 233, 186);
        bezierCurve(g2, 203, 185, 215, 186, 219, 191, 218, 202);
        bezierCurve(g2, 218, 202, 219, 192, 223, 186, 233, 186);
        buffer = floodFill(buffer, 218, 188, moonInside, star);

        g2.setColor(star); // ดาวใต้คางมังกร
        bezierCurve(g2, 414, 375, 423, 374, 427, 367, 427, 358);
        bezierCurve(g2, 427, 358, 427, 369, 433, 373, 441, 375); 
        bezierCurve(g2, 441, 375, 433, 377, 429, 383, 428, 394);
        bezierCurve(g2, 428, 394, 429, 383, 426, 378, 414, 375);
        buffer = floodFill(buffer, 429, 380, moonInside, star);
        //ดาวซ้ายล่าง
        bezierCurve(g2, 14, 548, 24, 546, 28, 542, 28, 526);
        bezierCurve(g2, 28, 526, 32, 542, 35, 545, 45, 548);
        bezierCurve(g2, 45, 548, 28, 552, 32, 557, 28, 568);
        bezierCurve(g2, 28, 568, 24, 555, 27, 552, 14, 548);
        buffer = floodFill(buffer, 30, 548, background, star);


        //text
        g2.setColor(Color.decode("#f2e8df"));
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
        g.drawImage(buffer, 0, 0, null);
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
        buffer = floodFill(buffer, 52, 82, background, Color.decode("#f2e8df"));
        g.drawImage(buffer, 0, 0, null);
        //e
        bezierCurve(g2, 60, 76, 60, 59, 83, 59, 83, 76);
        bezierCurve(g2, 60, 76, 60, 89, 77, 92, 81, 85);
        bresenhamLine(g2, 65, 76, 83, 76);
        bezierCurve(g2, 65, 76, 65, 88, 81, 83, 81, 82);
        bresenhamLine(g2, 81, 82, 81, 85);
        bezierCurve(g2, 65, 72, 67, 66, 79, 66, 79, 72);
        bresenhamLine(g2, 65, 72, 79, 72);
        buffer = floodFill(buffer, 63, 76, background, Color.decode("#f2e8df"));
        g.drawImage(buffer, 0, 0, null);
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
        buffer = floodFill(buffer, 97, 84, background, Color.decode("#f2e8df"));
        g.drawImage(buffer, 0, 0, null);
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
        buffer = floodFill(buffer, 151, 75, background, Color.decode("#f2e8df"));
        g.drawImage(buffer, 0, 0, null);
        //e
        bezierCurve(g2, 163, 76, 163, 59, 186, 59, 186, 76);
        bezierCurve(g2, 163, 76, 163, 89, 180, 92, 184, 85);
        bresenhamLine(g2, 168, 76, 186, 76);
        bezierCurve(g2, 168, 76, 169, 88, 184, 83, 184, 82);
        bresenhamLine(g2, 184, 82, 184, 85);
        bezierCurve(g2, 168, 72, 170, 66, 182, 66, 182, 72);
        bresenhamLine(g2, 168, 72, 182, 72);
        buffer = floodFill(buffer, 166, 69, background, Color.decode("#f2e8df"));
        buffer = floodFill(buffer, 176, 85, moon, Color.decode("#f2e8df"));
        g.drawImage(buffer, 0, 0, null);
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
        buffer = floodFill(buffer, 215, 82, moon, Color.decode("#f2e8df"));
        g.drawImage(buffer, 0, 0, null);
        // r
        bresenhamLine(g2, 222, 63, 222, 88);
        bresenhamLine(g2, 222, 88, 228, 88);
        bresenhamLine(g2, 228, 88, 228, 72);
        bezierCurve(g2, 228, 75, 228, 68, 235, 67, 237, 69);
        bresenhamLine(g2, 237, 69, 237, 63);
        bezierCurve(g2, 237, 63, 230, 63, 228, 65, 228, 67);
        bresenhamLine(g2, 228, 63, 221, 63);
        buffer = floodFill(buffer, 226, 85, moon, Color.decode("#f2e8df"));
        g.drawImage(buffer, 0, 0, null);
        //2
        bezierCurve(g2, 21, 116, 36, 89, 72, 111, 37, 141);
        bresenhamLine(g2, 37, 141, 54, 141);
        bresenhamLine(g2, 54, 141, 54, 149);
        bresenhamLine(g2, 54, 149, 25, 149);
        bresenhamLine(g2, 25, 149, 21, 145);
        bezierCurve(g2, 21, 145, 62, 110, 34, 106, 29, 120);
        bresenhamLine(g2, 29, 120, 21, 116);
        buffer = floodFill(buffer, 31, 147, background, Color.decode("#f2e8df"));
        g.drawImage(buffer, 0, 0, null);
        //0
        bezierCurve(g2, 77, 103, 52, 103, 52, 151, 77, 151);
        bezierCurve(g2, 77, 151, 102, 151, 102, 103, 77, 103);
        bezierCurve(g2, 77, 112, 63, 113, 67, 146, 77, 142);
        bezierCurve(g2, 77, 142, 86, 147, 92, 112, 77, 112);
        buffer = floodFill(buffer, 63, 127, background, Color.decode("#f2e8df"));
        g.drawImage(buffer, 0, 0, null);
        //2
        bezierCurve(g2, 101, 116, 116, 89, 152, 111, 117, 141);
        bresenhamLine(g2, 117, 141, 134, 141);
        bresenhamLine(g2, 134, 141, 134, 149);
        bresenhamLine(g2, 134, 149, 105, 149);
        bresenhamLine(g2, 105, 149, 101, 145);
        bezierCurve(g2, 101, 145, 142, 110, 114, 106, 109, 120);
        bresenhamLine(g2, 109, 120, 101, 116);
        buffer = floodFill(buffer, 120, 147, moon, Color.decode("#f2e8df"));
        buffer = floodFill(buffer, 104, 144, background, Color.decode("#f2e8df"));
        buffer = floodFill(buffer, 115, 108, background, Color.decode("#f2e8df"));
        g.drawImage(buffer, 0, 0, null);
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
        buffer = floodFill(buffer, 164, 133, moon, Color.decode("#f2e8df"));

        //ธง
        bresenhamLine(g2, 99, 22, 99, 43);
        bresenhamLine(g2, 99, 43, 102, 43);
        bresenhamLine(g2, 102, 43, 102, 22);
        bresenhamLine(g2, 102, 22, 99, 22);
        g2.setColor(lowerdragon);
        xPoly = new int[]{102, 102, 118};
        yPoly = new int[]{22, 35, 35};
        nPoints = xPoly.length;
        polygon = new Polygon(xPoly, yPoly, nPoints);
        g2.fillPolygon(polygon);
        
        g.drawImage(buffer, 0, 0, null);
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