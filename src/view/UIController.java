package view;

import javax.swing.DefaultComboBoxModel;
import controller.comandos.ComandoAcciones;
import controller.comandos.ComandoDiferencias;
import view.actions.LoadFile;
import view.actions.SelectAction;

public class UIController extends UI {

	public UIController() {
		super();
		addListeners();
		addActions();
	}

	private void addActions() {
		DefaultComboBoxModel<ComandoAcciones> model = new DefaultComboBoxModel<>();
		model.addElement(new ComandoDiferencias());
		this.combo.setModel(model);
		this.combo.setSelectedIndex(0);
	}

	private void addListeners() {
		this.btnBase.addActionListener(new LoadFile(this, "Seleccione fichero BASE"));
		this.btnIncompleto.addActionListener(new LoadFile(this, "Seleccione fichero INCOMPLETO"));
		this.combo.addActionListener(new SelectAction(this, this.combo));
	}

	public void setEstado(String mensaje) {
		this.lblEstado.setText(mensaje);
	}

	public void setNombreAccion(String nombre) {
		this.lblNombreAccion.setText(nombre);
	}

}
