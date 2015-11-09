package edu.iut.gui.listeners;

import javax.swing.JOptionPane;

public class ApplicationErrorMessageDialog extends
		AbstractApplicationMessageDialog {

	@Override
	protected void showMessage(String level, String message) {
		/** UTILISER l'AIDE FORUNIR DANS L'ENNONCE */				
		//Boîte du message d'erreur
		JOptionPane jop3 = new JOptionPane();
		jop3.showMessageDialog(null, "Erreur", message, JOptionPane.ERROR_MESSAGE);
	}

}
