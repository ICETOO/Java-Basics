package teamWorkAsignment;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Screen extends JPanel implements Runnable {

	private static final long serialversionUID = 1L; 						// declaring variables line
																			// 19-48
	public static final int WIDTH = 600, HEIGHT = 624;

	private Thread thread;
	private boolean running = false;

	private boolean isSnake1Alive = true;
	private boolean isSnake2Alive = true;

	private SnakeBody b;
	private SnakeBody b2;
	private ArrayList<SnakeBody> snake;
	private ArrayList<SnakeBody> snake2;
	private Apple apple;
	private ArrayList<Apple> apples;

	private Random r;
	private int score1 = 0, score2 = 0;
	private int speed = 1000000;

	private int x = 10, y = 10;
	private int x2 = 30, y2 = 30;
	private int size = 5;
	private int size2 = 5;

	private boolean right = true, left = false, up = false, down = false;
	private boolean right2 = false, left2 = true, up2 = false, down2 = false;

	private int ticks = 0;
	private Key key;

	public void Message(String title, String msg) {
		JOptionPane.showMessageDialog(null, msg, title,
				JOptionPane.ERROR_MESSAGE);
	}

	public Screen() {
		setFocusable(true);
		key = new Key();
		addKeyListener(key);
		setPreferredSize(new Dimension(WIDTH, HEIGHT));

		r = new Random();

		snake = new ArrayList<SnakeBody>();
		snake2 = new ArrayList<SnakeBody>();
		apples = new ArrayList<Apple>();

		start();
	}

	public void tick() { 													// Creating snakes and apples line 70-87
		if ((snake.size() == 0) && isSnake1Alive) {
			b = new SnakeBody(x, y, 12);
			snake.add(b);
		}

		if ((snake2.size() == 0) && isSnake2Alive) {
			b2 = new SnakeBody(x2, y2, 12);
			snake2.add(b2);
		}

		if (apples.size() == 0) {
			int x = r.nextInt(49);
			int y = 2 + r.nextInt(49);

			apple = new Apple(x, y, 12);
			apples.add(apple);
		}
		for (int i = 0; i < apples.size(); i++) {							// checking for collisions with all in game elements line 87-156																	// apple || snake || wall line 88-147																											
			if (x == apples.get(i).getX() && y == apples.get(i).getY()) {
				size++;
				apples.remove(i);
				i--;
				score1 += 10;
			}
		}

		for (int i = 0; i < apples.size(); i++) {
			if (x2 == apples.get(i).getX() && y2 == apples.get(i).getY()) {
				size2++;
				apples.remove(i);
				i--;
				score2 += 10;
			}
		}

		if (isSnake1Alive) {
			for (int i = 0; i < snake.size(); i++) {
				if (x == snake.get(i).getX() && y == snake.get(i).getY()) {
					if (i != snake.size() - 1) {
						isSnake1Alive = snakeDie(snake, isSnake1Alive, "1");
					}
				}
			}
			for (int i = 0; i < snake2.size(); i++) {
				if (x == snake2.get(i).getX() && y == snake2.get(i).getY()) {
					if (i != snake2.size() - 1) {
						isSnake1Alive = snakeDie(snake, isSnake1Alive, "1");
					}
				}
			}
		}

		if (isSnake2Alive) {
			for (int i = 0; i < snake2.size(); i++) {
				if (x2 == snake2.get(i).getX() && y2 == snake2.get(i).getY()) {
					if (i != snake2.size() - 1) {
						isSnake2Alive = snakeDie(snake2, isSnake2Alive, "2");
					}
				}
			}
			for (int i = 0; i < snake.size(); i++) {
				if (x2 == snake.get(i).getX() && y2 == snake.get(i).getY()) {
					if (i != snake.size() - 1) {
						isSnake2Alive = snakeDie(snake2, isSnake2Alive, "2");
					}
				}
			}
		}

		if (x < 0 || x > 49 || y < 2 || y > 51) {
			isSnake1Alive = snakeDie(snake, isSnake1Alive, "1");
		}
		if (x2 < 0 || x2 > 49 || y2 < 2 || y2 > 51) {
			isSnake2Alive = snakeDie(snake2, isSnake2Alive, "2");
		}
		if (!isSnake1Alive && !isSnake2Alive) { 							// End game text line 145-155
			if (score1 > score2) {
				Message("Game Over", "Snake1 is WINNER!!!");
				stop();
			} else if (score2 > score1) {
				Message("Game Over", "Snake2 is WINNER!!!");
				stop();
			} else
				Message("Game Over", "Equal score == !WINNER");
			stop();
		}

		ticks++;

		if (ticks > speed) { 												// Movement and conditions line 159-195
			if (right)
				x++;
			if (right2)
				x2++;
			if (left)
				x--;
			if (left2)
				x2--;
			if (up)
				y--;
			if (up2)
				y2--;
			if (down)
				y++;
			if (down2)
				y2++;

			ticks = 0;
			if (isSnake1Alive) {
				b = new SnakeBody(x, y, 12);
				snake.add(b);
			}

			if (isSnake2Alive) {
				b2 = new SnakeBody(x2, y2, 12);
				snake2.add(b2);
			}

			if (snake.size() > size) {
				snake.remove(0);
			}
			if (snake2.size() > size2) {
				snake2.remove(0);
			}
		}
	}

	private boolean snakeDie(ArrayList<SnakeBody> snake, boolean isAlive,
			String number) { 												// method for dead snake text line 197-204
		snake.clear();
		if (isAlive)
			Message("Game Over for Snake " + number, "Snake " + number + "  Died!");			
		isAlive = false;
		return isAlive;
	}

	public void paint(Graphics g) { 								//draw method for visualization of the snake ||		
		g.clearRect(0, 0, WIDTH, HEIGHT);							//apple || score text line 206-223
		for (int i = 0; i < snake.size(); i++) {
			snake.get(i).draw(g, Color.GREEN);
		}
		for (int j = 0; j < snake2.size(); j++) {
			snake2.get(j).draw(g, Color.ORANGE);
		}
		for (int k = 0; k < apples.size(); k++) {
			apples.get(k).draw(g);
		}
		g.setColor(Color.BLACK);
		g.setFont(new Font("TimesRoman", Font.BOLD, 16));
		g.drawString("Snake 1 Score: " + score1, 10, 20);
		g.setFont(new Font("TimesRoman", Font.BOLD, 16));
		g.drawString("Snake 2 Score: " + score2, 400, 20);
		g.drawLine(0, 24, 600, 24);
	}

	public void start() { 											// Start and stop of the game line 225-247
		running = true;
		thread = new Thread(this, "Game Loop");
		thread.start();
	}

	public void stop() {
		running = false;
		try {
			thread.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void run() {
		while (running) {
			tick();
			repaint();
		}
	}

	private class Key implements KeyListener { 						// Controls for snake1 && snake2 line 248-298							
		public void keyPressed(KeyEvent e) {
			int key = e.getKeyCode();
			if (key == KeyEvent.VK_RIGHT && !left) {
				right = true;
				up = false;
				down = false;
			}
			if (key == KeyEvent.VK_LEFT && !right) {
				left = true;
				up = false;
				down = false;
			}
			if (key == KeyEvent.VK_UP && !down) {
				right = false;
				left = false;
				up = true;
			}
			if (key == KeyEvent.VK_DOWN && !up) {
				right = false;
				left = false;
				down = true;
			}

			if (key == KeyEvent.VK_D && !left2) {
				right2 = true;
				up2 = false;
				down2 = false;
			}
			if (key == KeyEvent.VK_A && !right2) {
				left2 = true;
				up2 = false;
				down2 = false;
			}
			if (key == KeyEvent.VK_W && !down2) {
				right2 = false;
				left2 = false;
				up2 = true;
			}
			if (key == KeyEvent.VK_S && !up2) {
				right2 = false;
				left2 = false;
				down2 = true;
			}
		}

		public void keyTyped(KeyEvent e) {
		}

		public void keyReleased(KeyEvent e) {
		}
	}
}