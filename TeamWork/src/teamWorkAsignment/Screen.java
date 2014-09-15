package teamWorkAsignment;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JPanel;

public class Screen extends JPanel implements Runnable {

	private static final long serialversionUID = 1L;
	public static final int WIDTH = 600, HEIGHT = 600;
	private Thread thread;
	private boolean running = false;

	private SnakeBody b;
	private ArrayList<SnakeBody> snake;
	private Apple apple;
	private ArrayList<Apple> apples;

	private Random r;

	private int x = 10, y = 10;
	private int size = 5;

	private boolean right = true, left = false, up = false, down = false;

	private int ticks = 0;
	private Key key;

	public Screen() {
		setFocusable(true);
		key = new Key();
		addKeyListener(key);
		setPreferredSize(new Dimension(WIDTH, HEIGHT));

		r = new Random();

		snake = new ArrayList<SnakeBody>();
		apples = new ArrayList<Apple>();

		start();
	}

	public void tick() {
		if (snake.size() == 0) {
			b = new SnakeBody(x, y, 12);
			snake.add(b);
		}
		if (apples.size() == 0) {
			int x = r.nextInt(49);
			int y = r.nextInt(49);

			apple = new Apple(x, y, 12);
			apples.add(apple);
		}
		for (int i = 0; i < apples.size(); i++) {
			if (x == apples.get(i).getX() && y == apples.get(i).getY()) {
				size++;
				apples.remove(i);
				i--;
			}
		}
		for(int i = 0; i < snake.size(); i++){
			if(x == snake.get(i).getX() && y == snake.get(i).getY()){
				if(i!=snake.size() - 1){
					stop();
				}
			}
		}
		if (x < 0 || x > 49 || y < 0 || y > 49) {
			stop();
		}
		
		ticks++;

		if (ticks > 500000) {
			if (right)
				x++;
			if (left)
				x--;
			if (up)
				y--;
			if (down)
				y++;

			ticks = 0;

			b = new SnakeBody(x, y, 12);
			snake.add(b);

			if (snake.size() > size) {
				snake.remove(0);
			}
		}
	}

	public void paint(Graphics g) {
		g.clearRect(0, 0, WIDTH, HEIGHT);
		for (int i = 0; i < snake.size(); i++) {
			snake.get(i).draw(g);
		}
		for (int i = 0; i < apples.size(); i++) {
			apples.get(i).draw(g);
		}
	}

	public void start() {
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

	private class Key implements KeyListener {

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

		}
		public void keyTyped(KeyEvent e) {
		}
		public void keyReleased(KeyEvent e) {
		}
	}
}
