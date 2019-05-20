package controller;

import java.io.File;

public class FileController {
	private String basePath;
	private String incompletePath;

	public FileController(String basePath, String incompletePath) {
		super();
		this.basePath = basePath;
		this.incompletePath = incompletePath;
	}

	public FileController() {
		super();
	}

	public void setBase(String path) {
		this.basePath = path;
	}

	public void setIncomplete(String path) {
		this.incompletePath = path;
	}
}
