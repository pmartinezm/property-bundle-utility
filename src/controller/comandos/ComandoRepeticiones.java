package controller.comandos;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import controller.FileController;
import view.UIController;

public class ComandoRepeticiones extends ComandoAcciones {
	private UIController controller;
	private FileController fc;

	public ComandoRepeticiones(UIController controller) {
		this.nombre = "Repeticiones";
		this.descripcion = "Muestra las claves repetidas y cuántas veces se repiten.";
		this.controller = controller;
		this.fc = FileController.getInstance();
	}

	@Override
	public void exec() throws Exception {
		/**
		 * Solo se utiliza base y output.
		 */
		String pathBase = this.fc.getBase();
		String pathOutput = this.fc.getBase() + ".repeticiones";

		if (pathBase.isEmpty()) {
			throw new Exception("Empty path");
		}

		// Base
		File fileBase = new File(pathBase);
		FileInputStream baseFIS = new FileInputStream(fileBase);
		InputStreamReader baseISR = new InputStreamReader(baseFIS);
		BufferedReader baseReader = new BufferedReader(baseISR);

		// Output
		File fileOut = new File(pathOutput);
		FileOutputStream outputFOS = new FileOutputStream(fileOut);
		OutputStreamWriter outputOSW = new OutputStreamWriter(outputFOS, Charset.defaultCharset());
		BufferedWriter outputWriter = new BufferedWriter(outputOSW);

		// Comprobación de base y comparación (file)
		if (!fileBase.exists()) {
			throw new Exception("File(s) not found");
		}

		// Comprobación output
		if (fileOut.exists()) {
			fileOut.delete();
			fileOut.createNewFile();
		}

		String line;
		int l = 0;
		Map<String, Integer> map = new HashMap<>();
		while ((line = baseReader.readLine()) != null) {
			l++;
			// System.out.println(l + ": " + line);

			if (map.containsKey(line)) {
				int value = map.get(line);
				map.replace(line, value + 1);
			} else {
				map.put(line, 1);
			}
		}

		System.out.println("MAP: " + map.size());

		StringBuilder out = new StringBuilder();
		Iterator keys = map.keySet().iterator();
		while (keys.hasNext()) {
			String key = (String) keys.next();
			if (map.get(key) > 1) {
				// System.out.println(key + " - " + map.get(key));
				out.append(key + " - " + map.get(key) + "\n");
			}
		}

		System.out.println(l + " líneas leidas.");
		this.controller.setTxtBase(out.toString());

		baseReader.close();
		baseISR.close();
		baseFIS.close();
		outputFOS.close();
		outputOSW.close();
		outputWriter.close();
	}

}
