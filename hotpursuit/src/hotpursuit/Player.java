package hotpursuit;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.ImageObserver;

public class Player extends Character{

	 private static final long serialVersionUID = 1L;
	 private int life = 3, score = 0;
	
	 	//Getter / Setter
	 	@Override
		public int getScore() {
			return score;
		}

		@Override
		public void setScore(int score) {
			this.score = score;
		}
		@Override
		public int getLife() {
			return life;
		}
		@Override
		public void setLife(int life) {
			this.life = life;
		}
	 
		/*
		 * 17 = falllal
		 * 16 = csillagal
		 */
	 
		 //Move függvény mely a player mozgásáért felel, irányítani a nyilakkal lehet
	 @Override
	 public void move() {
			
	        int tmp = 0;
	        int tmp_dx = getDirectionX(dir);
	        int tmp_dy = getDirectionY(dir);
	        

	        if (IsOnField()) {
	        	tmp = maze[CurrentPos(dir)];
	            
	            if (tmp == 16) {			// ha 16 os mezõre lép, 0 ra írja az értéket ezáltal jelezve h felszedte a csillagot és növeli a score-t
	            	maze[CurrentPos(dir)] = 0;	// módosítja az akutuális mezõ érétkét 0-ra ezáltal nem fog újra kirajzolódni (eltûnik) és növeli a score értékét eggyel.
	                setScore(getScore() + 1);
	            }
	            
	            							
	                if (tmp != 17) {		//ha nincs fal (nem 17) a random által generált irányt kapja értéknek
	                    setP_dx(tmp_dx);
	                    setP_dy(tmp_dy);
	                }

	                						
	            if (maze[CurrentPos(dir)] == 17 && ((dir == 'L') || (dir == 'R') || (dir == 'U') || (dir == 'D'))) { // Ha fal van megáll
	            	setP_dx(0);
	            	setP_dy(0);
             }
	        }
	        setX(getX()+GetSpeed()*getP_dx());
	        setY(getY()+GetSpeed()*getP_dy());
	        
	    
	
}
	 

	@Override
	 public void PlayerDraw(Graphics g2, Character player, Image playerleft, Image playerright, Image playerup, Image playerdown, ImageObserver a) {

			if (dir == 'L') {
				g2.drawImage(playerleft, player.getX() + 11, player.getY() + 11, a);
			} else if (dir == 'R') {
				g2.drawImage(playerright, player.getX() + 11, player.getY() + 11, a);
			} else if (dir == 'U') {
				g2.drawImage(playerup, player.getX() + 11, player.getY() + 11, a);
			} else {
				g2.drawImage(playerdown, player.getX() + 11, player.getY() + 11, a);
			}

		}

	
	
	
	
	
	    
	    
	   
}
