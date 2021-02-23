package hotpursuit;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.ImageObserver;


public class Police extends Character{

	private static final long serialVersionUID = 1L;
	
	/*
	 * ezt sajnos muszáj volt megtartani itt mert ezt a playerben nem használom
	 * arra szolgál, hogy a meghatározza éppen milyen irányba megy a police
	 */
	private char Direction(int x, int y) {
		if (x == -1 && y == 0)
			return 'L';
		else if (x == 1 && y == 0)
			return 'R';
		else if (x == 0 && y == -1)
			return 'U';
		else if (x == 0 && y == 1)
			return 'D';
		else
			return 'S';
	}
	/*
	 * 17 = falllal
	 * 16 = csillagal
	 */
	@Override
	public void move() {

		int tmp_x = ((int) (Math.random() * (3 - (0))) + (0)) - 1;
		int tmp_y = ((int) (Math.random() * (3 - (0))) + (0)) - 1;

		if (IsOnField()) {
			if (maze[CurrentPos('S')] != 17) {
				if ((tmp_x & tmp_y) == 0) {
					setP_dx(tmp_x);
					setP_dy(tmp_y);
				}
			}

			// Falak
			if (((maze[CurrentPos(Direction(getP_dx(), getP_dy()))] == 17))) {
				setP_dx(0);
				setP_dy(0);
			}

		}

		setX(getX()+GetSpeed()*getP_dx());
		setY(getY()+GetSpeed()*getP_dy());

	}

	
	

	@Override
	public void PoliceDraw(Graphics g2, int x, int y, Image police, ImageObserver a) {
		
		g2.drawImage(police, x, y, a);

	}

}
