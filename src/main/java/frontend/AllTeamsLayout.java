package frontend;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import backend.Teams;
import frontend.buttons.UpButtons;

@SuppressWarnings("serial")
public class AllTeamsLayout extends JPanel {

	public AllTeamsLayout() {

		setLayout(new GridLayout(41, 4));

		JButton idButton = new JButton("ID");
		this.add(idButton);
		JButton nameButton = new JButton("Seleção");
		this.add(nameButton);
		JButton regionButton = new JButton("Continente");
		this.add(regionButton);
		JButton tpButton = new JButton("Títulos Mundiais");
		this.add(tpButton);
	}

	public void showAllTeams(List<Teams> list, UpButtons ub) {

		for (Teams team : list) {

			String teamId = Integer.toString(team.getId());
			JButton id = new JButton(teamId);
			this.add(id);
			JButton name = new JButton(team.getName());
			this.add(name);
			JButton region = new JButton(team.getRegion());
			this.add(region);
			String teamTrophies = Integer.toString(team.getWrTrophies());
			JButton trophies = new JButton(teamTrophies);
			this.add(trophies);
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
