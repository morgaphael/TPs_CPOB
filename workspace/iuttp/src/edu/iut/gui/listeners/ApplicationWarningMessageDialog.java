package edu.iut.gui.listeners;

import javax.swing.JOptionPane;

public class ApplicationWarningMessageDialog extends
		AbstractApplicationMessageDialog {

	@Override
	protected void showMessage(String level, String message) {
		/** UTILISER l'AIDE FORUNIR DANS L'ENNONCE */
		//Bo�te du message pr�ventif
		JOptionPane jop2 = new JOptionPane();
		jop2.showMessageDialog(null, "Message pr�ventif", "Attention", JOptionPane.WARNING_MESSAGE);
	}

}
