package hotpursuit;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.ImageObserver;

public class Character extends Game{
	 private static final long serialVersionUID = 1L;
	 private  int x;
	 private  int y;
	 private int p_dx;
	 private int p_dy;
	 public static char dir;
	 private int dx, dy;
	 private int SPEED = 6;

	
	public int SetSpeed(int speed)
	{
		return SPEED = speed;
	}
	public int GetSpeed()
	{
		return SPEED;
	}
		
	public  int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public  int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	public int getP_dx() {
		return p_dx;
	}
	public void setP_dx(int p_dx) {
		this.p_dx = p_dx;
	}
	public int getP_dy() {
		return p_dy;
	}
	public void setP_dy(int p_dy) {
		this.p_dy = p_dy;
	}
	public int getDx() {
		return dx;
	}
	public void setDx(int dx) {
		this.dx = dx;
	}
	public int getDy() {
		return dy;
	}
	public void setDy(int dy) {
		this.dy = dy;
	}
	public int getDirectionX(char d) {
		 
		 switch (d)
		 {
			 case 'L' : dx = -1; break;
			 case 'R' : dx = 1; break;
			 case 'U' :  dx = 0; break;
			 case 'D' :  dx = 0; break;
			 case 'S' :  dx = 0; break;
		 }
	     return dx;
	 }
	 public int getDirectionY(char d) {
			 
		 switch (d)
		 {
			 case 'L' : dy = 0; break;
			 case 'R' : dy = 0; break;
			 case 'U' :  dy = -1; break;
			 case 'D' :  dy = 1; break;
			 case 'S' :  dy = 0; break;
		 }
	     return dy;
	 }	
	 
	 public char SetDir(char a)
	 {
		 return setDir(a);
	 }
	 
	 
	 
	 /*
	  * Megvizsgálom, hogy rajta van-e egy kockán
	  */
	 public boolean IsOnField()
     {
		 if (x % 24 == 0 && y % 24 == 0)
			 return true;
		 else return false;
     }
	 
	 
	 
	/* ki kell számolni a pontos pozíciót a "tömbben" 
	 * 
	 * Ezt úgy lehet megtenni h az x és y koordinátát elosztom egy kocka szélességével
	 * az y megszorzom a kockák számával és ezt a kettõt össezadom
	 * Ygy kijön hogy hanyadik kockában áll épppen a karakter / rendõr
	 *
	 */
	 public int CurrentPos(char d)
	 {
		 if (d == 'L')
			 return (x/24+kocka*y/24)-1;	
		 else if (d == 'R')
			 return (x/24+kocka*y/24)+1;
		 else if (d == 'U')
			 return (x/24+kocka*y/24)-kocka;
		 else if (d == 'D')
			 return (x/24+kocka*y/24)+kocka;
		 else if (d == 'S')
			 return x/24+kocka*y/24;
		 else return x/24+kocka*y/24;
	 }
	 
	
	public static char getDir() {
		return dir;
	}
	public static char setDir(char dir) {
		Character.dir = dir;
		return dir;
	}
	
	public int getScore() {
		// TODO Auto-generated method stub
		return 0;
	}
	public void setScore(int score) {
		// TODO Auto-generated method stub
		
	}
	public int getLife() {
		// TODO Auto-generated method stub
		return 0;
	}
	public void setLife(int life) {
		// TODO Auto-generated method stub
		
	}
	public void PlayerDraw(Graphics g2, Character p1, Image playerleft, Image playerright, Image playerup,
			Image playerdown, ImageObserver a) {
		// TODO Auto-generated method stub
		
	}
	
	public void move() {
		    //mozgató függvény, melyek a Police és Player osztályban találhatóak meg, mert mindekettõnek más a mechanikája
	}
	
	
	public void restart(int a, int b) {
		
			x = a * 24;
	        y = b * 24;
	        p_dx = 0;
	        p_dy = 0;
	        dir = 'S';
		
		
	}
	public void PoliceDraw(Graphics g2, int x, int y, Image police, ImageObserver a) {
		// TODO Auto-generated method stub
		
	}
	 

}
