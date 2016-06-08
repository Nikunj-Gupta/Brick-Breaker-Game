import java.awt.Rectangle;

public class levels {
   public static void restart(BrickBreaker bb) {	
		  bb.requestFocus(true);
		  bb.ball_x = 160;
		  bb.ball_y = 218;
		  bb.paddle_x = 160;
		  bb.paddle_y = 245;
		  bb.brick_x = 70;
		  bb.brick_y = 50;
		  bb.Ball = new Rectangle(bb.ball_x, bb.ball_y, 5, 5);
		  bb.Bat = new Rectangle(bb.paddle_x, bb.paddle_y, 40, 5);
		  bb.Brick = new Rectangle[12];
                  bb.velocity_x = -1;
		  bb.velocity_y = -1;
		  bb.below_paddle_level = false;
		  bb.bricks_finished = false;
		  bb.count = 0;
		  bb.status = null;
		  for (int i = 0; i < bb.Brick.length; i++) {
			  bb.Brick[i] = new Rectangle(bb.brick_x, bb.brick_y, 30, 10);
		   if (i == 5) {
			   bb.brick_x = 70;
			   bb.brick_y = 62;
		   }
		   if (i == 9) {
			   bb.brick_x = 100;
			   bb.brick_y = 74;
		   }
		   bb.brick_x += 31;
		  }
		  bb.repaint();
	
		 }

    public static void nextlevel(BrickBreaker bb) {
		  bb.requestFocus(true);
		  bb.ball_x = 10;
		  bb.ball_y = 20;
		  bb.paddle_x = 160;
		  bb.paddle_y = 245;
		  bb.brick_x = 70;
		  bb.brick_y = 50;
		  bb.Ball = new Rectangle(bb.ball_x, bb.ball_y, 5, 5);
		  bb.Bat = new Rectangle(bb.paddle_x, bb.paddle_y, 40, 5);
		  bb.Brick = new Rectangle[12];
		  bb.velocity_x = -2;
		  bb.velocity_y = -2;
		  bb.below_paddle_level = false;
		  bb.bricks_finished = false;
		  bb.count = 0;
		  bb.status = null;
		  for (int i = 0; i < bb.Brick.length; i++) {
			  bb.Brick[i] = new Rectangle(bb.brick_x, bb.brick_y, 30, 10);
		   if (i == 5) {
			   bb.brick_x = 70;
			   bb.brick_y = 62;
		   }
		   if (i == 9) {
			   bb.brick_x = 100;
			   bb.brick_y = 74;
		   }
		   bb.brick_x += 31;
		  }
		  bb.repaint();
		 }
}
