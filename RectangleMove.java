import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class RectangleMove extends JComponent implements MouseListener, MouseMotionListener
{
	Rectangle box;
	boolean isDragged;
	int offX, offY;
	
	public RectangleMove(){
		box = new Rectangle(0,0,100,80);
		isDragged = false;
		addMouseListener(this);
		addMouseMotionListener(this);
	}
	
	public void paintComponent(Graphics g){
		g.setColor(Color.BLACK);
		g.drawRect(box.x,box.y,box.width,box.height);
	}

 	public void mousePressed(MouseEvent me){
		//�簢�� �ȿ����� �̺�Ʈ �۾� ����
		if(box.contains(new Point(me.getX(),me.getY()))){
			//#1 ���콺 ��ư ����
			//�簢���� ���콺 Ŭ�� ��� ��ǥ�� ����
			//���� ���콺 ��ũ�� ��ǥ���� �簢�� ��ġ ��ǥ�� ���̸� ����
			offX = me.getX() - box.x;
			offY = me.getY() - box.y;
			
			//�巡�� ������ ǥ��
			isDragged = true;

		}
	}
	public void mouseReleased(MouseEvent me){
		//���콺 ��ư�� ������Ǹ� �巡�� ��� ����
		isDragged = false;
	}
	public void mouseDragged(MouseEvent me){
		
		//�巡�� ����� ��쿡�� �簢�� �̵���Ŵ
		if(isDragged){
			box.x = me.getX() - offX;
			box.y = me.getY() - offY;
		}
		repaint();
	
	}
	public void mouseMoved(MouseEvent me){}
	public void mouseClicked(MouseEvent me){}
	public void mouseEntered(MouseEvent me){}
	public void mouseExited(MouseEvent me){}

	//���α׷� ����
	public static void main(String[] args){

		JFrame f = new JFrame("�簢�� �ű��");
		f.setBounds(100,100,500,500);
		f.add(new RectangleMove());
		f.setVisible(true);
	}
}