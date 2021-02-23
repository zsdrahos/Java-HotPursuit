package hotpursuit;

import java.io.IOException;

import org.junit.Test;

import junit.framework.TestCase;

public class test2 extends TestCase {

	
	@Test
	public void test_playerSetter() {
		Character p1 = new Player();
		assertEquals('L', p1.SetDir('L'));
		assertEquals(0, p1.getScore());
		assertEquals(3, p1.getLife());
		assertEquals(p1.getX() % 24 == 0 && p1.getY() % 24 == 0 , p1.IsOnField());
		
	}
	
	@Test
	public void test_player_pos() {
		Character p1 = new Player();
		assertEquals(p1.getX() % 24 == 0 && p1.getY() % 24 == 0 , p1.IsOnField());
		assertEquals((p1.getX()/24+20*p1.getY()/24)-1, p1.CurrentPos('L'));
		
	}
	
	@Test
	public void test_player_restart() {
		Character p1 = new Player();
		p1.restart(10,11);
		assertEquals(10*24, p1.getX());
		assertEquals(11*24, p1.getY());
	}
	
	@Test
	public void test_policeSetter() {
		Character p1 = new Police();
		assertEquals(0, p1.getX());
		assertEquals(0, p1.getY());
		assertEquals(2, p1.SetSpeed(2));
		assertEquals(p1.getX() % 24 == 0 && p1.getY() % 24 == 0 , p1.IsOnField());
		
	}
	
	@Test
	public void test_police_pos() {
		Character p1 = new Police();
		assertEquals(p1.getX() % 24 == 0 && p1.getY() % 24 == 0 , p1.IsOnField());
		assertEquals((p1.getX()/24+20*p1.getY()/24)-1, p1.CurrentPos('L'));
		
	}
	
	@Test
	public void test_police_restart() {
		Character p1 = new Police();
		p1.restart(1,2);
		assertEquals(1*24, p1.getX());
		assertEquals(2*24, p1.getY());
	}
	@Test
	public void test_move() {
		Character p1 = new Player();
		p1.restart(11,10);
		p1.move();
		p1.SetDir('L');
		assertEquals((11*24)-24, p1.getY());
		assertEquals((10*24)+24, p1.getX());
	}
	
	@Test
	public void test_collision() {
		Game g = new Game();
		Player p1 = new Player();
		Police po1 = new Police();
		p1.setX(20);
		p1.setY(20);
		po1.setX(20);
		po1.setY(20);
		g.playing = true;
		g.collision(po1, p1);
		assertEquals(true, g.isDie());
		assertEquals(p1.getY(), po1.getY());
		
	}
	
	@Test
	public void test_death() throws IOException {
		Game g = new Game();
		Player p1 = new Player();
		g.death(p1);
		
		assertEquals(2, p1.getLife());
		
	}
	@Test
	public void test_dif_set(){
		Game g1 = new Game();
		Player p11 = new Player();
		Police po11 = new Police();
		Police po22 = new Police();
		g1.SetGame(2 ,p11, po11, po22);
		
		assertEquals(12, po11.GetSpeed());
		
		g1.SetGame(3, p11, po11, po22);
		
		assertEquals(24, p11.GetSpeed());
		g1.SetGame(1, p11, po11, po22);
	}
	
	@Test
	public void test_loadMaze(){
		Game g1 = new Game();
		g1.LoadMaze();
		assertEquals(17, g1.maze[20]);
		assertEquals(16, g1.maze[23]);
	}
	@Test
	public void test_GameRestart(){
		Game g1 = new Game();
		Police po11 = new Police();
		g1.Restart(po11);
		assertEquals(15*24, po11.getX());
		
	}
	
	
	
	
	
	 
	
	
	
	
	
	
	
}
