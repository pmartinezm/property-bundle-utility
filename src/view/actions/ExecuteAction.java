package view.actions;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;

import controller.comandos.ComandoAcciones;
import view.UIController;

public class ExecuteAction implements ActionListener {
	private UIController controller;
	private JComboBox<ComandoAcciones> combo;

	public ExecuteAction(UIController controller, JComboBox<ComandoAcciones> combo) {
		this.controller = controller;
		this.combo = combo;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			((ComandoAcciones) this.combo.getSelectedItem()).exec();
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
}
