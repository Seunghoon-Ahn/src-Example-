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
		//사각형 안에서만 이벤트 작업 설정
		if(box.contains(new Point(me.getX(),me.getY()))){
			//#1 마우스 버튼 누름
			//사각형내 마우스 클릭 상대 좌표를 구함
			//현재 마우스 스크린 좌표에서 사각형 위치 좌표의 차이를 구함
			offX = me.getX() - box.x;
			offY = me.getY() - box.y;
			
			//드래그 시작을 표시
			isDragged = true;

		}
	}
	public void mouseReleased(MouseEvent me){
		//마우스 버튼이 릴리즈되면 드래그 모드 종료
		isDragged = false;
	}
	public void mouseDragged(MouseEvent me){
		
		//드래그 모드인 경우에만 사각형 이동시킴
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

	//프로그램 실행
	public static void main(String[] args){

		JFrame f = new JFrame("사각형 옮기기");
		f.setBounds(100,100,500,500);
		f.add(new RectangleMove());
		f.setVisible(true);
	}
}