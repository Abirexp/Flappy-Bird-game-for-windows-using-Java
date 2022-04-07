package flappyBirdPacage;

import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.JPanel;  

public class ManuPanel extends JPanel  {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private BufferedImage img = null;
	public boolean startingPoint = false;
	public ManuPanel() {
		LoadImage();
		//for control 
		this.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				super.mouseClicked(e);
				startingPoint = true;
			} 
		});
	}
	
	
	

	public void LoadImage() {
		
		try {
			img = ImageIO.read(new File("C:\\Users\\Abir\\eclipse-workspace\\Flappy bird\\screen.png"));
		}
		catch(Exception ex){
			
			ex.printStackTrace();
			
		}
		
	}
	public void paint(Graphics g) {
		
		super.paint(g);
		g.drawImage(img, 0, 0, GamePanal.WIDTH, GamePanal.HEIGHT , null);
	}
	

}
