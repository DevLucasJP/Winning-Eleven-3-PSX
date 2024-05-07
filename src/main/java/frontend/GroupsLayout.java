package frontend;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.util.List;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import backend.Teams;
import frontend.buttons.UpButtons;

@SuppressWarnings("serial")
public class GroupsLayout extends JPanel {

	JButton[][] buttons = new JButton[10][4];

	public GroupsLayout(String text) {

		setLayout(new GridLayout(10, 4));

		JButton gA = new JButton("Grupo A");
		gA.setBackground(Color.YELLOW);
		buttons[0][0] = gA;
		add(gA);
		JButton gB = new JButton("Grupo B");
		gB.setBackground(Color.YELLOW);
		buttons[0][1] = gB;
		add(gB);
		JButton gC = new JButton("Grupo C");
		gC.setBackground(Color.YELLOW);
		buttons[0][2] = gC;
		add(gC);
		JButton gD = new JButton("Grupo D");
		gD.setBackground(Color.YELLOW);
		buttons[0][3] = gD;
		add(gD);

		int a = 1;
		int b = 0;
		for (int i = 0; i < 16; i++) {

			JButton tb = new JButton(text);
			tb.setBackground(Color.WHITE);
			buttons[a][b] = tb;
			add(tb);

			if (b == 3) {
				b = 0;
				a++;
			} else {
				b++;
			}
		}

		JButton gE = new JButton("Grupo E");
		gE.setBackground(Color.YELLOW);
		add(gE);
		JButton gF = new JButton("Grupo F");
		gF.setBackground(Color.YELLOW);
		add(gF);
		JButton gG = new JButton("Grupo G");
		gG.setBackground(Color.YELLOW);
		add(gG);
		JButton gH = new JButton("Grupo H");
		gH.setBackground(Color.YELLOW);
		add(gH);

		a = 6;
		b = 0;
		for (int i = 0; i < 16; i++) {

			JButton tb = new JButton(text);
			tb.setBackground(Color.WHITE);
			buttons[a][b] = tb;
			add(tb);

			if (b == 3) {
				b = 0;
				a++;
			} else {
				b++;
			}
		}
	}

	public void updateGroups(List<Teams> list, UpButtons ub) {

		Random random = new Random();
		int teamToPlay = random.nextInt(32);

		Teams team;

		int a = 1;
		int b = 0;
		for (int i = 0; i < 16; i++) {

			team = list.get(i);
			buttons[a][b].setText(team.getName());

			if (i == teamToPlay) {
				buttons[a][b].setBackground(Color.GREEN);
			}

			if (b == 3) {
				b = 0;
				a++;
			} else {
				b++;
			}
		}

		a = 6;
		b = 0;
		for (int i = 16; i < 32; i++) {

			team = list.get(i);
			buttons[a][b].setText(team.getName());

			if (i == teamToPlay) {
				buttons[a][b].setBackground(Color.GREEN);
			}

			if (b == 3) {
				b = 0;
				a++;
			} else {
				b++;
			}
		}

		ub.getLabels().add(this);
		ub.getMainWindow().add(this, BorderLayout.CENTER);
		updateWindow(ub.getMainWindow());
	}

	public void updateWindow(JFrame frame) {

		frame.revalidate();
		frame.repaint();
	}

}
