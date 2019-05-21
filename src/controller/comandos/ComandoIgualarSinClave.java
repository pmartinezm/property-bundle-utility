package controller.comandos;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.nio.charset.Charset;

import controller.FileController;
import view.UIController;

public class ComandoIgualarSinClave extends ComandoAcciones {
	private UIController controller;
	private FileController fc;

	public ComandoIgualarSinClave(UIController controller) {
		super();
		this.nombre = "Igualar sin clave [BLOQUEANTE]";
		this.descripcion = "Iguala el fichero base con el incompleto. Genera un nuevo fichero.";
		this.controller = controller;
		this.fc = FileController.getInstance();
	}

	@Override
	public void exec() {
		/**
		 * Solo se utiliza base y output.
		 */
		String pathBase = FileController.getInstance().getBase();
		String pathComp = FileController.getInstance().getIncomplete();
		String pathOutput = FileController.getInstance().getIncomplete() + ".igualadorsinclave";

		try {
			if (pathBase.isEmpty() || pathComp.isEmpty()) {
				throw new Exception("Empty path");
			}

			// Base
			File fileBase = new File(pathBase);
			FileInputStream baseFIS = new FileInputStream(fileBase);
			InputStreamReader baseISR = new InputStreamReader(baseFIS);
			BufferedReader baseReader = new BufferedReader(baseISR);

			// Comparación
			File fileComp = new File(pathComp);
			FileInputStream compFIS = new FileInputStream(fileComp);
			InputStreamReader compISR = new InputStreamReader(compFIS);
			BufferedReader compReader = new BufferedReader(compISR);

			// Output
			File fileOut = new File(pathOutput);
			FileOutputStream outputFOS = new FileOutputStream(fileOut);
			OutputStreamWriter outputOSW = new OutputStreamWriter(outputFOS, Charset.defaultCharset());
			BufferedWriter outputWriter = new BufferedWriter(outputOSW);

			// Comprobación de base y comparación (file)
			if (!fileBase.exists() || !fileComp.exists()) {
				throw new Exception("File(s) not found");
			}

			// Comprobación output
			if (fileOut.exists()) {
				fileOut.delete();
				fileOut.createNewFile();
			}

			String line;
			int contadorLineaPrincipal = 0;
			int current = 0;
			int contadorNoCoincidencias = 0;
			// Recorrer base
			while ((line = baseReader.readLine()) != null) {
				System.out.println(current);
				current++;
				compFIS.getChannel().position(0);
				compReader = new BufferedReader(new InputStreamReader(compFIS));
				contadorLineaPrincipal++;
				// c++;
				line = line.trim();

				if (line.equals("") || line.startsWith("#")) {
					// Directa
					outputWriter.write(line + "\n");
					outputWriter.flush();
				} else {
					// Obtener la clave
					int index = line.indexOf("=");

					String key = "";
					if (index != -1) {
						key = line.substring(0, index);
					} else {
						// TODO: Incluir codigo para linea erronea
					}
					key = key.trim();

					// Buscar la clave en ES
					String compLine;
					boolean existe = false;

					// Recorrer comp
					int compLineCount = 0;
					while ((compLine = compReader.readLine()) != null && !existe) {
						compLine = compLine.trim();
						int compIndex = compLine.indexOf("=");
						String compKey = "";
						if (compIndex != -1) {
							compKey = compLine.substring(0, compIndex);
						} else {
							// TODO: Incluir codigo para linea erronea
						}

						compKey = compKey.trim();

						if (compKey.equals(key)) {
							outputWriter.write(compLine + "\n");
							outputWriter.flush();
							existe = true;
							System.out.println(compLineCount);
							// break;
						}

						// System.out.println(l);

					}

					if (!existe) {
						outputWriter.write(line);
						outputWriter.flush();
						System.out.println(
								"Linea main: " + contadorLineaPrincipal + " no se han encontrado coincidencias en ES");
						contadorNoCoincidencias++;
					} else {
						System.out.println("Linea main " + contadorLineaPrincipal + "encontrada en ES");
					}
				}
			}
			System.out.println(contadorLineaPrincipal + " líneas leidas.");
			System.out.println(contadorNoCoincidencias + " líneas que no coinciden.");

			baseReader.close();
			compReader.close();
			baseISR.close();
			compISR.close();
			baseFIS.close();
			compFIS.close();
			outputFOS.close();
			outputOSW.close();
			outputWriter.close();
		} catch (Exception e) {

		}

	}

}
