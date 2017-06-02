import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MouseListenerAllEx extends JFrame 
{ 
   JPanel contentPane = new JPanel();
   JLabel la;

   MouseListenerAllEx() 
   { 
      contentPane.setLayout(null);
      setTitle("MouseListener MouseMotionListener");
      setDefaultCloseOperation(JFrame. EXIT_ON_CLOSE );
      setContentPane(contentPane);
      contentPane.addMouseListener( new MyMouseListener());
      contentPane.addMouseMotionListener( new MyMouseListener());
      la = new JLabel("No Mouse Event");
      contentPane.add(la);
      setSize(800,400);
      setVisible(true); 
   }
   class MyMouseListener implements MouseListener, MouseMotionListener 
   { 
      public float h,v, x, y;
      public void mousePressed(MouseEvent e) 
      { 
         x = e.getX();
         y = e.getY();
         la.setText("MousePressed ("+e.getX()+","+e.getY()+")"); 
      } 
      public void mouseReleased(MouseEvent e) 
      { 
         la.setText("MouseReleased("+e.getX()+","+e.getY()+")"); 
         h = Math.abs(x - e.getX());
         v = Math.abs(y  - e.getY());
         
           if(x < e.getX())
         {
            if(y > e.getY()) new makeButton(x,e.getY(),h,v);
            else
            {
               new makeButton(x,y,h,v);
            }
         }
         else if(x > e.getX())
         {
            if(y > e.getY()) new makeButton(e.getX(),e.getY(),h,v);
            else
            {
               new makeButton(e.getX(),y,h,v);
            }
         }
      }
      public void mouseClicked(MouseEvent e)
      {
         if(e.getClickCount() == 2)
         {
            int r = (int)(Math.random()*256);
            int g = (int)(Math.random()*256);
            int b = (int)(Math.random()*256);
         }
      } 
      public void mouseEntered(MouseEvent e) {} 
      public void mouseExited(MouseEvent e) {} 
      public void mouseDragged(MouseEvent e) { 
         la.setText("MouseDragged ("+e.getX()+","+e.getY()+")"); 
      } 
      public void mouseMoved(MouseEvent e) { 
         la.setText("MouseMoved ("+e.getX()+","+e.getY()+")");
      }
   }
   
   
   class makeButton 
   {
      JLabel la;
      protected JButton button;
      protected float editArea = 50;
      protected float eX, eY;
      protected boolean isEditing = false;
      makeButton(){}
      makeButton(float x, float y, float h, float v)
      {
         button = new JButton("");
         contentPane.add(button);
         button.setSize((int)h,(int)v);
         button.setLocation((int)x,(int)y);
         la = new JLabel("No Mouse Event");
         button.add(la);
         button.addMouseListener( new buttonMouseListener());
         button.addMouseMotionListener( new buttonMouseListener());
      }
      void changeSize()
      {
         
      }class buttonMouseListener implements MouseListener, MouseMotionListener 
      {
         public void mousePressed(MouseEvent e)
         {
            la.setText("height, width: ("+getSize().width +","+getSize().height + ")" + "mouse x,y: (" + e.getX() +"," + e.getY()+")"); 
         }
         public void mouseReleased(MouseEvent e)
         {la.setText("height, width: ("+getWidth() +","+getHeight() + ")" + "mouse x,y: (" + e.getX() +"," + e.getY()+")"); 
            if(isEditing)
            {
               int y = (int)(getHeight() + (getHeight() - 2*eY));
               int x = (int)(getWidth() + (getWidth() - 2*eX));
               button.setSize(x,y);
               isEditing = false;
            }
         }
         public void mouseClicked(MouseEvent e){}
         public void mouseEntered(MouseEvent e) {}
         public void mouseExited(MouseEvent e){}   
         public void mouseDragged(MouseEvent e) 
         { 
            la.setText("MouseDragged ("+e.getX()+","+e.getY()+")"); 
         } 
         public void mouseMoved(MouseEvent e) 
         { 
            la.setText("MouseMoved ("+e.getX()+","+e.getY()+")");
         }
      }
   }
   public static void main(String [] args)
   { 
      new MouseListenerAllEx();
   }
}