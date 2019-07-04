import java.awt.*;
import javax.swing.*;

public class MyDrawPanel extends JPanel {
	public void paintComponent(Graphics q) {
		
		q.fillRect(0, 0, this.getWidth(), this.getHeight());
		
		int red = (int) (Math.random()*255);
		int green = (int) (Math.random()*255);
		int blue = (int) (Math.random()*255);
		
		Color randomColor = new Color(red, green, blue);
		q.setColor(randomColor);
		q.fillOval(70, 70, 100, 100);
	}

}
