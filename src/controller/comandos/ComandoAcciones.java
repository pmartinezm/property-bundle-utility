package controller.comandos;

import view.UIController;

public abstract class ComandoAcciones implements Comando {
	protected String nombre;
	protected String descripcion;
	protected UIController controller;

	public ComandoAcciones() {

	}

	@Override
	public String toString() {
		return this.nombre;
	}

	public String getNombre() {
		return this.nombre;
	}

	public String getDesc() {
		return this.descripcion;
	}
}
