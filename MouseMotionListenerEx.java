import javax.swing.*;
import java.awt.event.*;
import java.util.EventListener;
import java.awt.*;

public class MouseMotionListenerEx extends JFrame {
	JLabel la;

	MouseMotionListenerEx() {
		setTitle("MouseMotion 이벤트 예제");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel contentPane = new JPanel();
		setContentPane(contentPane);
		setLayout(null);
		contentPane.addMouseMotionListener(new MyMouseMotionListener());
		la = new JLabel("hello");
		la.setSize(50, 20);
		la.setLocation(300, 300);
		contentPane.add(la);
		setSize(800, 400);
		setVisible(true);
	}

	class MyMouseMotionListener implements MouseListener, MouseMotionListener {
		public void mouseMoved(MouseEvent e) {
			int x = e.getX();
			int y = e.getY();
			la.setLocation(x, y);
		}
		public void mouseDragged(MouseEvent e) {}
		public void mouseReleased(MouseEvent e) {}
		public void mouseClicked(MouseEvent e) {}
		public void mouseEntered(MouseEvent e) {}
		public void mouseExited(MouseEvent e) {}
	}
	public static void main(String[] args) {
		new MouseMotionListenerEx();
	}
}