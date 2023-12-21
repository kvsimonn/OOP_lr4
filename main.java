import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;
import javax.swing.*;

public class main {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Вращение отрезка с изменяющимся цветом прямой");
        frame.setPreferredSize(new Dimension(300, 300));
        final JPanel panel = new JPanel();
        frame.add(panel);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();

        Timer timer = new Timer(500, new ActionListener() {
            int angle = 0;
            final int centerX = panel.getWidth() / 2;
            final int centerY = panel.getHeight() / 2;
            final int length = Math.min(panel.getWidth(), panel.getHeight()) / 3;
            final int x1 = centerX - length / 2;
            final int y1 = centerY - length / 2;
            final int x2 = centerX + length / 2;
            final int y2 = centerY + length / 2;

            @Override
            public void actionPerformed(ActionEvent e) {
                Graphics2D graphics = (Graphics2D) panel.getRootPane().getGraphics();
                panel.update(graphics);

                graphics.clearRect(0, 0, panel.getWidth(), panel.getHeight());

                // Вращение отрезка вокруг точки (x1, y1)
                double radians = Math.toRadians(angle);
                int newX2 = x1 + (int) (Math.cos(radians) * length);
                int newY2 = y1 + (int) (Math.sin(radians) * length);

                // Цвет прямой
                float hue = (float) angle / 360;
                graphics.setColor(Color.getHSBColor(hue, 1, 1));

                graphics.drawLine(x1, y1, newX2, newY2);

                angle += 10;
            }
        });

        timer.start();
    }
}