package view;

import javax.swing.DefaultComboBoxModel;

import controller.FileController;
import controller.comandos.ComandoAcciones;
import controller.comandos.ComandoDiferencias;
import controller.comandos.ComandoIgualar;
import controller.comandos.ComandoTest;
import view.actions.ExecuteAction;
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
		model.addElement(new ComandoIgualar());
		model.addElement(new ComandoTest(this));
		this.combo.setModel(model);
		this.combo.setSelectedIndex(0);
	}

	private void addListeners() {
		this.btnBase.addActionListener(new LoadFile(this, "Seleccione fichero BASE"));
		this.btnIncompleto.addActionListener(new LoadFile(this, "Seleccione fichero INCOMPLETO"));
		this.combo.addActionListener(new SelectAction(this, this.combo));
		this.btnEjecutar.addActionListener(new ExecuteAction(this, this.combo));
	}

	public void setEstado(String mensaje) {
		this.lblEstado.setText(mensaje);
	}

	public void setNombreAccion(String nombre) {
		this.lblNombreAccion.setText(nombre);
	}
	
	public void setTxtBase(String content) {
		this.txtBase.setText(content);
	}

}
