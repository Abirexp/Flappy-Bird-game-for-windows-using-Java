package flappyBirdPacage;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.JFrame;

public class BirdImage {

	private BufferedImage img = null;
	private static int bird_dia = 36;
	public static int x = (GamePanal.WIDTH/2)-bird_dia/2;
	public static int y = GamePanal.HEIGHT/2;
	private static int speed = 2;
	private int acce = 1;
	
	public BirdImage() {
		LoadImage();
	}

	private void LoadImage() {
		try {
			img = ImageIO.read(new File("C:\\Users\\Abir\\eclipse-workspace\\Flappy bird\\bird.png"));
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
		
	}
	public void drawBird(Graphics g) {
		g.drawImage(img, x, y, null);
		
	}
	
	public void birdMovement() {
		if (y>=0 && y<GamePanal.HEIGHT) {
			speed += acce;
			y += speed;
		}
		else {
			
			boolean option = GamePanal.popUpMessage();
			
			if(option) {
				try {
					Thread.sleep(500);
				}
				catch(Exception ex){
					ex.printStackTrace();
				}
				reset();
			}
			
			else {
				//close window
				JFrame frame = MainBird.getWindow();
				frame.dispose();
						
				MainBird.timer.stop();
			}
			
		}
	}
	public void goUpword() {
		speed = -17;
		
	}

	public static void reset() {
		speed = 2;
		y = GamePanal.HEIGHT/2;
		GamePanal.GameOver = true;
		GamePanal.score = 0;
		
	}
	public static Rectangle getBirdRect() {
		Rectangle birdRect = new Rectangle(x,y,bird_dia,35);
		return birdRect;
		
	}

	
	
}
