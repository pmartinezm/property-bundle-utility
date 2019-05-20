package view.actions;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;

import controller.comandos.Comando;
import controller.comandos.ComandoAcciones;
import view.UIController;

public class SelectAction implements ActionListener {

	private UIController controller;
	private JComboBox<ComandoAcciones> combo;

	public SelectAction(UIController controller, JComboBox<ComandoAcciones> combo) {
		this.controller = controller;
		this.combo = combo;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		this.controller.setNombreAccion(((ComandoAcciones) this.combo.getSelectedItem()).getDesc());
	}

}
