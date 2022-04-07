package flappyBirdPacage;

import java.awt.Font;
import java.awt.Graphics;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;


import javax.imageio.ImageIO;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class GamePanal extends JPanel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static boolean GameOver = false;
	
	public static int score = 0;
	public static boolean starting = false;
	public static int proceed = -1;
	
	public static final int WIDTH = 600;
	public static final int HEIGHT = 600;
	
	private int xCoor =0;
	private BufferedImage img;
	
	BirdImage bi = new BirdImage();
	
	WellImage wi = new WellImage(GamePanal.WIDTH);
	WellImage wi2 = new WellImage(GamePanal.WIDTH+(GamePanal.WIDTH/2));
	
	public GamePanal() {
		LoadImage();
		
		//for mouse click event
		this.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e){
				bi.goUpword();
				
			}
		});
	}

	private void LoadImage() {
		try {
			
			img = ImageIO.read(new File("C:\\Users\\Abir\\eclipse-workspace\\Flappy bird\\background.jpg"));
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
		
	}
	public void paint(Graphics g) {
		super.paint(g);
		g.drawImage(img, xCoor, 0, null);
		g.drawImage(img, xCoor+2400, 0, null);
		
		bi.drawBird(g);
		wi.drawWell(g);
		wi2.drawWell(g);
		g.setFont(new Font("Tahoma",Font.BOLD,40));
		g.drawString("Score : "+score, WIDTH/2, 100);
		
		if(starting) {
			g.setFont(new Font("Tahoma",Font.BOLD,150));
			g.drawString(Integer.toString(proceed), WIDTH/2-75, 250);
		}
		
		
	}
	
	public void Move() {
		bi.birdMovement();
		wi.wellMovement();
		wi2.wellMovement();
		
		if(GameOver) {
			wi.X = GamePanal.WIDTH;
			wi2.X= GamePanal.WIDTH+(GamePanal.WIDTH/2);
			GameOver = false;
		}
		
		xCoor+= WellImage.speed;
		if(xCoor==-2400) {
			xCoor=0;
		}
		System.out.println(wi.X+"->"+ BirdImage.x+"  :  "+wi2.X+"->"+BirdImage.x);
		if(wi.X==BirdImage.x || wi2.X==BirdImage.x) {
			score +=1;
		}
	}
	
	public static boolean popUpMessage() {
		int result = JOptionPane.showConfirmDialog(null,"Game Over, Your score is : "+score+"\n Do you want to RESTART the game","Game over", JOptionPane.YES_NO_OPTION);
		
		if(result==JOptionPane.YES_OPTION) {
			return true;
		}
		else {
			return false;
		}
	}
	

}










