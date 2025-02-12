package frontend;

import java.awt.BorderLayout;

import javax.swing.JFrame;

import frontend.buttons.UpButtons;

@SuppressWarnings("serial")
public class Window extends JFrame {

	public Window() {

		layoutManager();

		setTitle("Winning Eleven 3 - Final Version");
		setSize(800, 800);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);

		setVisible(true);
	}

	private void layoutManager() {

		setLayout(new BorderLayout());

		UpButtons buttons = new UpButtons(this);
		add(buttons, BorderLayout.NORTH);
	}

	public static void main(String[] args) {

		new Window();
	}
}
