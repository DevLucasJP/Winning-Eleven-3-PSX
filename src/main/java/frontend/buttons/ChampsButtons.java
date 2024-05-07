package frontend.buttons;

import java.awt.event.MouseEvent;
import java.util.List;

import javax.swing.JPanel;

import backend.Teams;
import frontend.AllTeamsLayout;
import inf.Dao;

@SuppressWarnings("serial")
public class ChampsButtons extends AppButtons {

	UpButtons ub;

	public ChampsButtons(String text, UpButtons ub) {
		super(text);
		this.ub = ub;
	}

	public void mousePressed(MouseEvent e) {

		if (e.getButton() == 1) {

			if (!this.ub.getLabels().isEmpty()) {

				JPanel temp = this.ub.getLabels().get(0);

				this.ub.getMainWindow().remove(temp);
				this.ub.getMainWindow().revalidate();
				this.ub.getMainWindow().repaint();

				this.ub.getLabels().remove(0);
			}

			Dao<Teams> tDao = new Dao<>(Teams.class);

			AllTeamsLayout atLayout = new AllTeamsLayout();
			List<Teams> allTeams = tDao.getList();

			atLayout.showAllTeams(allTeams, this.ub);

			tDao.closeDao();
		}
	}
}
