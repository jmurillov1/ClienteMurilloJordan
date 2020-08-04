package clientewsrest.vista;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.BorderLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;

import clienteesrest.model.Producto;
import clientewsrest.metodos.Metodos;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CreadoProducto extends JInternalFrame {

	private static Metodos servicios;
	private JTextField jtxtCodigo;
	private JTextField jtxtNombre;
	private JTextField jtxtPrecio;
	private JTextField jtxtStock;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CreadoProducto frame = new CreadoProducto(servicios);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public CreadoProducto(final Metodos servicios) {
		this.servicios = servicios;
		setTitle("Creado producto");
		setMaximizable(true);
		setIconifiable(true);
		setClosable(true);
		setBounds(100, 100, 307, 215);

		JLabel lblNewLabel = new JLabel("Codigo");

		jtxtCodigo = new JTextField();
		jtxtCodigo.setColumns(10);

		JLabel lblIngreseNumeroDe = new JLabel("Nombre");

		jtxtNombre = new JTextField();
		jtxtNombre.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("Precio");

		jtxtPrecio = new JTextField();
		jtxtPrecio.setColumns(10);

		JButton btnNewButton = new JButton("Guardar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Producto pro = new Producto();
				pro.setCodigo(Integer.parseInt(jtxtCodigo.getText()));
				pro.setNombre(jtxtNombre.getText());
				pro.setPrecio(Double.parseDouble(jtxtPrecio.getText()));
				pro.setStock(Integer.parseInt(jtxtStock.getText()));
				servicios.guardarProducto(pro);
			}
		});

		JButton btnNewButton_1 = new JButton("Cancelar");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jtxtCodigo.setText("");
				jtxtNombre.setText("");
				jtxtPrecio.setText("");
				jtxtStock.setText("");
			}
		});
		
		jtxtStock = new JTextField();
		jtxtStock.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Stock");
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblNewLabel_1)
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
							.addComponent(lblIngreseNumeroDe, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(lblNewLabel, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
						.addComponent(lblNewLabel_2))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(btnNewButton)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(btnNewButton_1))
						.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
							.addComponent(jtxtCodigo, GroupLayout.PREFERRED_SIZE, 188, GroupLayout.PREFERRED_SIZE)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
								.addComponent(jtxtPrecio)
								.addComponent(jtxtNombre, GroupLayout.DEFAULT_SIZE, 188, Short.MAX_VALUE)
								.addComponent(jtxtStock))))
					.addContainerGap(90, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel)
						.addComponent(jtxtCodigo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(8)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblIngreseNumeroDe)
						.addComponent(jtxtNombre, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_1)
						.addComponent(jtxtPrecio, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(jtxtStock, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_2))
					.addGap(22)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnNewButton)
						.addComponent(btnNewButton_1))
					.addContainerGap(22, Short.MAX_VALUE))
		);
		getContentPane().setLayout(groupLayout);
	}
}
