package controller.comandos;

public abstract class ComandoAcciones implements Comando {
	protected String nombre;
	protected String descripcion;

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
