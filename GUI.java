import javax.swing.JFrame;
import java.awt.Label;

public class GUI {
	
	public JFrame frame;
	Label label;
	
	/*Default build the frame as 1200 x 800*/
	public GUI(){
		frame = new JFrame("Graph Builder");
		frame.setSize(800, 600);
		frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
		
		label = new Label("A", Label.RIGHT);
		label.setLocation(600, 200);
		label.setBounds(600, 200, 30, 30);
		frame.add(label);
		frame.setVisible(true);
	}
	
	
	
	
}
