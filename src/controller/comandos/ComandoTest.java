package controller.comandos;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import controller.FileController;
import view.UIController;

public class ComandoTest extends ComandoAcciones {
	private FileController fc;

	public ComandoTest(UIController controller) {
		this.nombre = "Test";
		this.descripcion = "Testear el funcionamiento básico de la interfaz. [SE REALIZA SOBRE BASE]";
		this.fc = FileController.getInstance();
		this.controller = controller;
	}

	@Override
	public void exec() {
		StringBuilder out = new StringBuilder();
		System.out.println(this.fc);

		File base = new File(this.fc.getBase());

		if (base.exists()) {
			System.out.println("Archivo: ok");
			FileInputStream fis = null;
			try {
				fis = new FileInputStream(base);
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
			InputStreamReader fsr = new InputStreamReader(fis);
			BufferedReader br = new BufferedReader(fsr);

			String line;
			int counter = 0;
			try {
				while ((line = br.readLine()) != null) {
					counter++;
				}
			} catch (IOException e) {
				e.printStackTrace();
			}

			System.out.println(counter);
			out.append(this.fc + "\n");
			out.append("Archivo: ok\n");
			out.append("Líneas: " + counter + "\n");
			this.controller.setTxtBase(out.toString());
		}

	}

}
