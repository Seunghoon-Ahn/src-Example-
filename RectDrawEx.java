import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Vector;

public class RectDrawEx extends JFrame {
	
	public RectDrawEx(){
		JLabel Start_X, Start_Y, Height, Width;
		JTextField X, Y, H, W;
		
		
		setContentPane(new MyPanel());
		setSize(300,300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container c = getContentPane();
		c.setLayout(new FlowLayout());
		Start_X = new JLabel("Start_X");
		X = new JTextField(10);
		Start_Y = new JLabel("Start_Y");
		Y = new JTextField(10);
		Height = new JLabel("Height");
		H = new JTextField(10);
		Width = new JLabel("Width");
		W = new JTextField(10);
		c.add(Start_X);
		c.add(X);
		c.add(Start_Y);
		c.add(Y);
		c.add(Height);
		c.add(H);
		c.add(Width);
		c.add(W);
		
		
		
		
		
		
		setVisible(true);
	}
	
	class MyPanel extends JPanel{
		
		Point startP=null;
		Point endP=null;
		
		Vector<Point> sv = new Vector<Point>(); // 시작
		Vector<Point> se = new Vector<Point>(); // 끝점

		public MyPanel(){
			MyMouseListener m = new MyMouseListener();
			
			this.addMouseListener(m);
			this.addMouseMotionListener(m);
		}
		
		public void paintComponent(Graphics g){
			super.paintComponent(g);
			
			if(sv.size() != 0){
				for(int i=0;i<se.size();i++){ 
					Point sp = sv.get(i); 
					Point ep = se.get(i);	
					g.drawRect(sp.x, sp.y, ep.x - sp.x, ep.y - sp.y);
				}
			}
			if(startP != null)
				g.drawRect(startP.x, startP.y, endP.x - startP.x, endP.y - startP.y);				
		}
		
		class MyMouseListener extends MouseAdapter implements MouseMotionListener{
			public void mousePressed(MouseEvent e) {
				startP = e.getPoint();
				sv.add(e.getPoint()); // 클릭한부분을 시작점으로
			}
			public void mouseReleased(MouseEvent e) {
				se.add(e.getPoint()); // 드래그 한부분을 종료점으로
				endP = e.getPoint();
				repaint(); // 다시그려라
			}
			
			public void mouseDragged(MouseEvent e) {
				endP = e.getPoint();
				repaint();
			}
			
			public void mouseMoved(MouseEvent e) {}
		}
	}
	
	public static void main(String[] args) {
		new RectDrawEx();
	}
}
