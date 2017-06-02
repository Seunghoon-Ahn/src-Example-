import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class MouseAdapterEx extends JFrame {
	JPanel contentPane = new JPanel();
	JLabel la;

	MouseAdapterEx() {
		setTitle("Mouse 이벤트 예제");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setContentPane(contentPane);
		setLayout(null);
		contentPane.addMouseListener(new MyMouseAdapter());
		la = new JLabel("hello");
		la.setSize(50, 20);
		la.setLocation(30, 30);
		contentPane.add(la);
		setSize(200, 200);
		setVisible(true);
	}

	class MyMouseAdapter extends MouseAdapter {
		public void mousePressed(MouseEvent e) {
			int x = e.getX();
			int y = e.getY();
			la.setLocation(x, y);
		}
	}

	public static void main(String[] args) {
		new MouseAdapterEx();
	}
}