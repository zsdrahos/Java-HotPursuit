package hotpursuit;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

import javax.swing.ImageIcon;
import javax.swing.Timer;


public class Draw extends Game implements ActionListener{

	private ArrayList<Integer> sc;
	private static final long serialVersionUID = 1L;
	private Image playerup, playerdown, playerleft, playerright, life, star, start, brick, police;
	private Timer timer;	//lépteésért felel, ez alapján mûködik az actionperformed függvény, amint minden idõlépésnél meghívunk, majd megtörténik az újrarajzolás, ezáltal tûnük folytonosnak a kép
	
public Draw() {
		
		sc = new ArrayList<Integer>();
		setFocusable(true);
		
		setBackground(Color.WHITE);

		timer = new Timer(0, this);
		timer.setDelay(35);	//35 ms-nként van actionPerformed, ezáltal újrarajzolódik az egész program.
		timer.start();
		
		police = new ImageIcon("src/hotpursuit/images/p_left.png").getImage();
		brick = new ImageIcon("src/hotpursuit/images/wall.png").getImage();
		star = new ImageIcon("src/hotpursuit/images/star.png").getImage();
		start = new ImageIcon("src/hotpursuit/images/start.png").getImage();
		life = new ImageIcon("src/hotpursuit/images/life.png").getImage();
		playerup = new ImageIcon("src/hotpursuit/images/j_up.png").getImage();
		playerdown = new ImageIcon("src/hotpursuit/images/j_down.png").getImage();
		playerleft = new ImageIcon("src/hotpursuit/images/j_left.png").getImage();
		playerright = new ImageIcon("src/hotpursuit/images/j_right.png").getImage();
		
		

	}
	
public void Screen(Graphics g2) throws IOException {
		
		sc = FileRead();
		Collections.sort(sc, Collections.reverseOrder());  
		
		g2.drawImage(start, 0, 0, this);
		g2.setColor(new Color(153, 0, 0));
		g2.setColor(Color.white);
		Font font = new Font("Courier New", Font.BOLD, 14);
		g2.setFont(font);
		String s3 = "Difficulty: " + Integer.toString(getDif());
		g2.drawString(s3, 200, 420);	
		
		Font font1 = new Font("Courier New", Font.BOLD, 20);
		g2.setFont(font1);
		int max = 0;
		if (sc.size()<=10 && sc.size() != 0)
			max = sc.size();
		else max = 10;
		int k = 0;
		for (int i = 0;i<max;i++) {
			String th = "";	
			if (i+1 == 1)
				th = "ST";
			else if (i+1 == 2)
				th = "ND";
			else if (i+1 == 3)
				th = "RD";
			else th = "TH";
			 String scoreboard1 = i+1+th + " " + sc.get(i); 
			 g2.drawString(scoreboard1, 210, 190+k);
			 k+=20;
		
		  }

	}

private void DrawGameMethod(Graphics g2) throws InterruptedException, IOException {
	g2.setColor(Color.black);

	if (playing) {
		
		if (isDie()) {

			death(p1);
			

		} else {

			po1.move();
			po1.PoliceDraw(g2, po1.getX() + 11, po1.getY() + 11,police, this);
			collision(po1, p1);
			

			po2.move();
			po2.PoliceDraw(g2, po2.getX() + 11, po2.getY() + 11,police, this);
			collision(po2, p1);

			po3.move();
			po3.PoliceDraw(g2, po3.getX() + 11, po3.getY() + 11, police, this);
			collision(po3, p1);

			po4.move();
			po4.PoliceDraw(g2, po4.getX() + 11, po4.getY() + 11,police, this);
			collision(po4, p1);
			
			p1.move();
			p1.PlayerDraw(g2, p1, playerleft, playerright, playerup, playerdown, this);

			Maze_check();

		}
	} else {
		
		Screen(g2);
		

	}

}

//Pontok megjelenítése
private void ScoreDraw(Graphics g2) {

	Font font = new Font("Courier New", Font.BOLD, 14);
	g2.setFont(font);

	g2.setColor(Color.BLACK);
	String s = "Current Score: " + p1.getScore();
	g2.drawString(s, 335, 508);
	int k = 0;
	for (int i = 0; i < p1.getLife(); i++) {
		g2.drawImage(life, (k * 30)+10, size + 11, this);
		k++;
	}	
}
//Labirintus megjelenítése
private void MazeDraw(Graphics g2) {

	
	int k = 0;
	for (int j = 10; j < size; j += 24) {
		for (int i = 10; i < size; i += 24) {

			if (maze[k] == 16) {
				g2.setColor(Color.WHITE);
				g2.drawImage(star, i+10, j+10, 7, 7, this);
			}
			if (maze[k] == 17) {
				g2.setColor(Color.BLUE);
				g2.drawImage(brick, i, j, 24, 24, this);
			}
			k++;

		}
	}
}

//kirajzolja a dolgokat
@Override
public void paintComponent(Graphics g) {
	super.paintComponent(g);

	
		try {
			MazeDraw(g);
			ScoreDraw(g);
			DrawGameMethod(g);
		} catch (InterruptedException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	
}

//timerrel együtt mûködik, minden egyes léptetésnél (35ms ként) újra rajzolódik a program.
@Override
public void actionPerformed(ActionEvent e) {

	revalidate();
	repaint();

}

}
