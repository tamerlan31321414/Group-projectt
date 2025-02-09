import java.awt.*;
import java.util.Arrays;

public class Road {
    private final int[] roadLinesY;

    public Road() {
        roadLinesY = new int[]{-100, 0, 100, 200, 300, 400, 500, 600};
    }

    public void draw(Graphics2D g2d, int speed) {
        g2d.setPaint(new GradientPaint(0, 0, Color.DARK_GRAY, 0, 700, Color.BLACK));
        g2d.fillRect(0, 0, 500, 700);

        g2d.setColor(Color.WHITE);
        Arrays.stream(roadLinesY).forEach(y -> g2d.fillRect(240, y, 10, 50));
    }

    public void update(int speed) {
        for (int i = 0; i < roadLinesY.length; i++) {
            roadLinesY[i] += speed;
            if (roadLinesY[i] > 700) {
                roadLinesY[i] = -100;
            }
        }
    }
}
