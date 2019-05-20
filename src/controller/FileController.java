package controller;

import java.io.File;

public class FileController {
	private String basePath;
	private String incompletePath;
	public static FileController instance;

	private FileController(String basePath, String incompletePath) {
		super();
		this.basePath = basePath;
		this.incompletePath = incompletePath;
	}

	private FileController() {
		super();
	}

	public void setBase(String path) {
		this.basePath = path;
	}

	public void setIncomplete(String path) {
		this.incompletePath = path;
	}

	public String getBase() {
		return this.basePath;
	}

	public String incompletePath() {
		return this.incompletePath;
	}

	public static FileController getInstance() {
		if (instance == null) {
			instance = new FileController();
		}
		return instance;
	}

	@Override
	public String toString() {
		return "BASE: " + this.basePath + "\nINCOMPLETO: " + this.incompletePath;
	}
}
