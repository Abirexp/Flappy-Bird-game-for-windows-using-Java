package flappyBirdPacage;



import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import javax.swing.JFrame;
import javax.swing.Timer;

public class MainBird {
	private static JFrame window;
	public static Timer timer , timer2;
	private int proceed = 4;
	
	private MainBird() {
		window = new JFrame();
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setSize(GamePanal.WIDTH,GamePanal.HEIGHT);
		window.setLocationRelativeTo(null);
		window.setTitle("Flappy Bird");
		window.setResizable(false);
		window.setVisible(true);
		

	}
	public void rendering() {
		ManuPanel mp = new ManuPanel();
		GamePanal gp = new GamePanal();
		
		timer = new Timer(20, new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				gp.repaint();
				gp.Move();
			}

		});
		
		window.add(mp);
		window.setVisible(true);
		
		while (mp.startingPoint==false) {
			try {
				Thread.sleep(10);
			}
			catch(Exception ex){
				ex.printStackTrace();
			}
			
		}
		window.remove(mp);
		window.add(gp);
		gp.setVisible(true);
		window.revalidate();
		//timer.start();
		
		
		timer2 = new Timer(1000, new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				proceed--;
				GamePanal.proceed=proceed;
				GamePanal.starting = true;
				gp.repaint();
				if(proceed==0)
				{
					timer2.stop();
					timer.start();
					GamePanal.starting= false;
					
				}
				
			}
		});
		timer2.start();
		
	}

	public static JFrame getWindow() {
		return window;
	}
	
	public static void main(String[] args) {
		MainBird mb = new MainBird();
		mb.rendering();
	}
	
	public Timer getTimer() {
		return timer;
	}
	public void setTimer(Timer timer) {
		MainBird.timer = timer;
	}

}
