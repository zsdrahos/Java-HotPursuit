package hotpursuit;

import javax.swing.JFrame;

public class Start extends Game{
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
    

    public static void main(String[] args) {
    	
    	Draw game = new Draw();
		JFrame frame = new JFrame();
		frame.setTitle("HotPursuit");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(518, 580);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		frame.add(game);
		frame.setResizable(false);
            
    }
}
