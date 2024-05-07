package frontend.buttons;

import java.awt.FlowLayout;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class UpButtons extends JPanel {

	JFrame mainWindow;
	List<JPanel> labels = new ArrayList<>();

	public UpButtons() {
	}

	public UpButtons(JFrame mainWindow) {

		this.mainWindow = mainWindow;

		setLayout(new FlowLayout());

		SortButton button1 = new SortButton("Sortear Grupos", this);
		add(button1);
		NewChampButton button2 = new NewChampButton("Novo Campeão");
		add(button2);
		ChampsButtons button3 = new ChampsButtons("Campeões", this);
		add(button3);
	}

	public JFrame getMainWindow() {
		return mainWindow;
	}

	public void setMainWindow(JFrame mainWindow) {
		this.mainWindow = mainWindow;
	}

	public List<JPanel> getLabels() {
		return labels;
	}

	public void setLabels(List<JPanel> labels) {
		this.labels = labels;
	}
}
