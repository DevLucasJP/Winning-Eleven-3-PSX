package frontend.buttons;

import java.awt.event.MouseEvent;

import javax.swing.JOptionPane;

import backend.Champions;

@SuppressWarnings("serial")
public class NewChampButton extends AppButtons {

	public NewChampButton(String text) {
		super(text);
	}

	public void mousePressed(MouseEvent e) {

		if (e.getButton() == 1) {

			Champions champ = new Champions();
			String iString = JOptionPane.showInputDialog(this,
					"Digite o id da seleção que será adicionada como campeã: ");
			int iInteger = Integer.parseInt(iString);

			if (iInteger >= 1 || iInteger <= 40) {
				champ.setWrChampions(iInteger, champ);
			} else {
				JOptionPane.showInputDialog("Digite um id válido");
			}
		}
	}
}
