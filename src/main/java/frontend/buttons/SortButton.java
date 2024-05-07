package frontend.buttons;

import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;

import backend.SortedGroups;
import backend.Teams;
import frontend.GroupsLayout;
import inf.Dao;

@SuppressWarnings("serial")
public class SortButton extends AppButtons {

	UpButtons ub;
//	List<JPanel> labels = new ArrayList<>();

	public SortButton(String text, UpButtons ub) {
		super(text);
		this.ub = ub;
	}

	public UpButtons getUb() {
		return ub;
	}

	public void setUb(UpButtons ub) {
		this.ub = ub;
	}

	public void mousePressed(MouseEvent e) {

		if (e.getButton() == 1) {

			Dao<SortedGroups> sgDao = new Dao<>(SortedGroups.class);
			SortedGroups sg = new SortedGroups();
			GroupsLayout gl = new GroupsLayout("");

			if (!this.ub.getLabels().isEmpty()) {

				JPanel temp = this.ub.getLabels().get(0);

				this.ub.getMainWindow().remove(temp);
				this.ub.getMainWindow().revalidate();
				this.ub.getMainWindow().repaint();

				this.ub.getLabels().remove(0);
			}

			sgDao.resetValues("resetTable1");
			sgDao.resetValues("resetTable2");
			sg.sortGroups();

			List<SortedGroups> sgList = sgDao.getList();
			List<Teams> sortedTeams = new ArrayList<>();

			for (SortedGroups st : sgList) {

				Teams team = st.getQualifiedTeams().get(0);
				sortedTeams.add(team);
			}

			gl.updateGroups(sortedTeams, this.ub);

			sgDao.closeDao();
		}
	}
}