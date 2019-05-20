package view.actions;

import java.awt.FileDialog;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import controller.FileController;
import view.UIController;

public class LoadFile implements ActionListener {
	private UIController controller;
	private String titulo;

	public LoadFile(UIController controller, String titulo) {
		this.controller = controller;
		this.titulo = titulo;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		FileDialog fd = new FileDialog(this.controller, this.titulo, FileDialog.LOAD);
		fd.setVisible(true);
		String path = fd.getDirectory();

		File file = new File(path);
		
		System.out.println(file.exists());
		this.controller.setEstado(file.exists() ? "Ok" : "Error con el fichero");
	}
}
