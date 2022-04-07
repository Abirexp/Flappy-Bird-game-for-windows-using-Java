package flappyBirdPacage;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.swing.JFrame;

public class WellImage {
	private Random r = new Random();
	public int X;
	public int Y = r.nextInt(GamePanal.HEIGHT-400)+200;
	private int width_wall = 45;
	private int height = GamePanal.HEIGHT-Y;
	private int gap = 200;
	
	public static int speed = -6;
	
	private BufferedImage img = null;
	
	public WellImage(int X) {
		this.X = X;
		LoadImage();
		
	}

	private void LoadImage() {
		try{
			img = ImageIO.read(new File("C:\\Users\\Abir\\eclipse-workspace\\Flappy bird\\wall.png"));
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
		
	}
	public void drawWell(Graphics g) {
		g.drawImage(img, X, Y, null);
		g.drawImage(img, X, (-GamePanal.HEIGHT)+(Y-gap), null);
	}
	public void wellMovement() {
		X += speed;
		if(X<=-width_wall) {
			 X = GamePanal.WIDTH;
			 Y = r.nextInt(GamePanal.HEIGHT-400)+200;
			 height = GamePanal.HEIGHT-Y;
		}
		Rectangle lowerRect =  new Rectangle(X,Y,width_wall,height);
		Rectangle upperRect =  new Rectangle(X,0,width_wall,GamePanal.HEIGHT-(height+gap));
		
		if(lowerRect.intersects(BirdImage.getBirdRect())||upperRect.intersects(BirdImage.getBirdRect())) 
		{
			boolean option = GamePanal.popUpMessage();
			
			if(option) {
				try {
					Thread.sleep(500);
				}
				catch(Exception ex){
					ex.printStackTrace();
				}
				BirdImage.reset();
				well_reset();
			}
			else {
				//close window
				JFrame frame = MainBird.getWindow();
				frame.dispose();
				MainBird.timer.stop();
			}
			
			
		}
	}

	private void well_reset() {
		
		 Y = r.nextInt(GamePanal.HEIGHT-400)+200;
		 height = GamePanal.HEIGHT-Y;
		 GamePanal.GameOver = true;
		
	}
	
	
	

}
