package view;

import java.awt.FileDialog;

import javax.swing.JFrame;
import java.awt.GridBagLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.JComboBox;
import java.awt.TextArea;
import javax.swing.JProgressBar;

public class UI extends JFrame {

	protected FileDialog fileDialog;
	protected JButton btnBase;
	protected JButton btnIncompleto;
	protected JLabel lblEstadoMsg;
	protected JLabel lblEstado;
	protected JLabel lblNombreAccion;
	protected JComboBox combo;
	protected JButton btnEjecutar;
	protected TextArea txtBase;
	protected TextArea txtIncompleto;
	protected JProgressBar progressBar;

	public UI() {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
				| UnsupportedLookAndFeelException e) {
			e.printStackTrace();
		}
		setTitle("Properties bundle utility");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 500);

		JLabel lblFicheros = new JLabel("Ficheros");

		btnBase = new JButton("Base");

		btnIncompleto = new JButton("Incompleto");

		JLabel lblElFicheroBase = new JLabel(
				"El fichero base contiene todos los elementos que el incompleto deber\u00EDa tener");

		lblEstadoMsg = new JLabel("Estado:");

		lblEstado = new JLabel("Esperando ficheros");

		txtBase = new TextArea();

		txtIncompleto = new TextArea();

		JLabel lblBase = new JLabel("BASE");

		JLabel lblIncompleto = new JLabel("INCOMPLETO");

		combo = new JComboBox();

		lblNombreAccion = new JLabel(" ");
		
		btnEjecutar = new JButton("Ejecutar");
		
		progressBar = new JProgressBar();
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblEstadoMsg)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblEstado))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblFicheros)
							.addGap(18)
							.addComponent(btnBase)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnIncompleto)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(lblElFicheroBase, GroupLayout.DEFAULT_SIZE, 450, Short.MAX_VALUE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(txtBase, GroupLayout.PREFERRED_SIZE, 317, Short.MAX_VALUE)
									.addGap(18))
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(lblBase)
									.addPreferredGap(ComponentPlacement.RELATED)))
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(lblIncompleto)
								.addComponent(txtIncompleto, GroupLayout.PREFERRED_SIZE, 329, Short.MAX_VALUE)))
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
								.addComponent(progressBar, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(btnEjecutar, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(combo, Alignment.LEADING, 0, 253, Short.MAX_VALUE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblNombreAccion)))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblFicheros)
						.addComponent(btnBase)
						.addComponent(btnIncompleto)
						.addComponent(lblElFicheroBase))
					.addGap(5)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblEstadoMsg)
						.addComponent(lblEstado))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(combo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNombreAccion))
					.addGap(3)
					.addComponent(btnEjecutar)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(progressBar, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(4)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(lblIncompleto)
						.addComponent(lblBase))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(txtIncompleto, GroupLayout.DEFAULT_SIZE, 306, Short.MAX_VALUE)
						.addComponent(txtBase, GroupLayout.DEFAULT_SIZE, 306, Short.MAX_VALUE))
					.addContainerGap())
		);
		getContentPane().setLayout(groupLayout);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 0 };
		gridBagLayout.rowHeights = new int[] { 0 };
		gridBagLayout.columnWeights = new double[] {};
		gridBagLayout.rowWeights = new double[] {};

		this.fileDialog = new FileDialog(this, "", FileDialog.LOAD);
	}
}
