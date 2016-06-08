//package code;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JFrame;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.KeyListener;
import java.awt.BorderLayout;
import java.awt.Rectangle;

public class BrickBreaker extends JPanel implements KeyListener,ActionListener, Runnable {
 int velocity_x = -1;
 int velocity_y = -1;
 boolean below_paddle_level = false;
 boolean bricks_finished = false;
 int count = 0;
 String status;
 private static final long serialVersionUID = 1L;
 static boolean left_key = false;
 static boolean right_key = false;
 
 public int ball_x = 160;
 public int ball_y = 218;
 
 int paddle_x = 160;
 int paddle_y = 245;

 int brick_x = 70;
 int brick_y = 50;

 Rectangle Ball = new Rectangle(ball_x, ball_y, 5, 5);
 Rectangle Bat = new Rectangle(paddle_x, paddle_y, 40, 20);
 Rectangle[] Brick = new Rectangle[12];

 BrickBreaker() 
 {

 }

 public static void main(String[] args) {
  JFrame frame = new JFrame();
  BrickBreaker game = new BrickBreaker();
  JButton button = new JButton("Start/Restart");
  JButton nextlevel = new JButton("Next Level");
  frame.setSize(350, 450);
  frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  frame.add(game);
  frame.add(button , BorderLayout.SOUTH);
  frame.add(nextlevel , BorderLayout.NORTH);
  frame.setLocationRelativeTo(null);
  frame.setResizable(false);
  frame.setVisible(true);
  button.addActionListener(game);
  nextlevel.addActionListener(game);
  game.addKeyListener(game);
  game.setFocusable(true);
  Thread t = new Thread(game);
  t.start();
 }
 
 public void paint(Graphics g) {
  g.setColor(Color.BLACK);
  g.fillRect(0, 0, 350, 450);
  g.setColor(Color.blue);
  g.fillOval(Ball.x, Ball.y, Ball.width, Ball.height);
  g.setColor(Color.WHITE);
  g.fill3DRect(Bat.x, Bat.y, Bat.width, Bat.height, true);
  g.setColor(Color.GRAY);
  g.fillRect(0, 251, 450, 200);
  g.setColor(Color.GREEN);
  g.drawRect(0, 0, 343, 250);
  for (int i = 0; i < Brick.length; i++) {
   if (Brick[i] != null) {
    g.fill3DRect(Brick[i].x, Brick[i].y, Brick[i].width,
      Brick[i].height, true);
   }
  }

  if (below_paddle_level == true || bricks_finished == true) {
   Font f = new Font("Arial", Font.BOLD, 20);
   g.setFont(f);
   g.drawString(status, 70, 120);
   below_paddle_level = false;
   bricks_finished = false;
  }
 }
 
 public void run() {
  for (int i = 0; i < Brick.length; i++) {
   Brick[i] = new Rectangle(brick_x, brick_y, 30, 10);
   if (i == 5) {
    brick_x = 70;
    brick_y = 62;
   }
   if (i == 9) {
    brick_x = 100;
    brick_y = 74;
   }
   brick_x += 31;
  }
  while (true) {
   for (int i = 0; i < Brick.length; i++) {
    if (Brick[i] != null) {
     if (Brick[i].intersects(Ball)) {
      Brick[i] = null;
      //velocity_x = -velocity_x;
      velocity_y = -velocity_y;      
      count++;
     }
     }
    }

   if (count == Brick.length) {
    bricks_finished = true;
    status = "YOU WON THE GAME";
    repaint();
   }
   repaint();
   Ball.x += velocity_x;
   Ball.y += velocity_y;
   if (left_key == true) {

    Bat.x -= 3;
    right_key = false;
   }
   if (right_key == true) {
    Bat.x += 3;
    left_key = false;
   }
   if (Bat.x <= 4) {
    Bat.x = 4;
   } else if (Bat.x >= 298) {
    Bat.x = 298;
   }
   if (Ball.intersects(Bat)) {
    velocity_y = -velocity_y;
   }
   if (Ball.x <= 0 || Ball.x + Ball.height >= 343) {
    velocity_x = -velocity_x;
   }
   if (Ball.y <= 0) {
    velocity_y = -velocity_y;
   }
   if (Ball.y >= 250) {
    below_paddle_level = true;
    status = "YOU LOST THE GAME";
    repaint();
   }
   try {
    Thread.sleep(10);
   }
   catch (Exception ex) {
   }
  }
 }
  @Override
 public void actionPerformed(ActionEvent e) {
  String str = e.getActionCommand();
  if (str.equals("Start/Restart")) {
   levels.restart(this);
  }
  if(str.equals("Next Level"))
  {
	  
	  try {
		    Thread.sleep(100);
		   } 
	  catch (Exception ex) 
		   {
		   
		   }
		    
	  levels.nextlevel(this);
  }
 }
 

 @Override
 public void keyPressed(KeyEvent e) {
  int keyCode = e.getKeyCode();
  if (keyCode == KeyEvent.VK_LEFT) {
   left_key = true;
  }

  if (keyCode == KeyEvent.VK_RIGHT) {
   right_key = true;
  }
 }

 @Override
 public void keyReleased(KeyEvent e) {
  int keyCode = e.getKeyCode();
  if (keyCode == KeyEvent.VK_LEFT) {
   left_key = false;
  }

  if (keyCode == KeyEvent.VK_RIGHT) {
   right_key = false;
  }
 }

 @Override
 public void keyTyped(KeyEvent arg0) {

 }


 
}
