package clientewsrest.vista;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JScrollPane;
import java.awt.BorderLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import clienteesrest.model.Detalle;
import clienteesrest.model.Producto;
import clientewsrest.metodos.Metodos;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

public class Carrito extends JInternalFrame {
	private JTable jtblPersonas;
	private static Metodos servicios;
	private JTextField jtxtCodigo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Carrito frame = new Carrito(servicios);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * 
	 * @throws Exception
	 */
	public Carrito(final Metodos metodos) {
		setBounds(100, 100, 503, 284);

		final JPopupMenu pop = new JPopupMenu();
		JMenuItem item = new JMenuItem("Agregar");
		item.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				int row = jtblPersonas.getSelectedRow();
				Object ca = jtblPersonas.getValueAt(row, 1);
				Object st = jtblPersonas.getValueAt(row, 4);
				Object cp = jtblPersonas.getValueAt(row, 0);
				Object pc = jtblPersonas.getValueAt(row, 3);
				int cantidad = Integer.parseInt(String.valueOf(ca));
				int stock = Integer.parseInt(String.valueOf(st));
				int pro = Integer.parseInt(String.valueOf(cp));
				double precio = Double.parseDouble(String.valueOf(pc));
				if (cantidad > stock) {
					JOptionPane.showMessageDialog(null, "Stock Superado");
				} else {
					if (!jtxtCodigo.getText().isEmpty()) {
						Detalle det = new Detalle();
						det.setCodigo2(Integer.parseInt(jtxtCodigo.getText()));
						det.setCantidad(cantidad);
						det.setProducto(metodos.getProducto(pro));
						det.setSubtotal(cantidad * precio);
						metodos.guardarCarrito(det);
					} else {
						JOptionPane.showMessageDialog(null, "De un Codigo");
					}
				}

			}
		});

		pop.add(item);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});

		JLabel lblNewLabel_2 = new JLabel("Codigo");

		jtxtCodigo = new JTextField();
		jtxtCodigo.setColumns(10);
		
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap(36, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 440, GroupLayout.PREFERRED_SIZE)
							.addGap(27))
						.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
							.addComponent(lblNewLabel_2)
							.addGap(8)
							.addComponent(jtxtCodigo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(13)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_2)
						.addComponent(jtxtCodigo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(60)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 118, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(37, Short.MAX_VALUE))
		);

		jtblPersonas = new JTable();
		jtblPersonas.setComponentPopupMenu(pop);
		jtblPersonas.setModel(new DefaultTableModel(new Object[][] { { null, null, null, null, null, null }, },
				new String[] { "Codigo", "Cantidad", "Nombre", "Stock", "Precio", "Subtotal" }));
		scrollPane.setRowHeaderView(jtblPersonas);
		getContentPane().setLayout(groupLayout);
		DefaultTableModel model = (DefaultTableModel) jtblPersonas.getModel();
		model.setRowCount(0);
		Object[] lista = new Object[5];
		for (Producto p : metodos.getPersonas()) {
			lista[0] = p.getCodigo();
			lista[1] = 1;
			lista[2] = p.getNombre();
			lista[3] = p.getPrecio();
			lista[4] = p.getStock();
			model.addRow(lista);
		}
		jtblPersonas.setModel(model);

	}
}
