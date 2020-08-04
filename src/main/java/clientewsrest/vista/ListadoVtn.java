package clientewsrest.vista;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JScrollPane;
import java.awt.BorderLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import clienteesrest.model.Detalle;
import clientewsrest.metodos.Metodos;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ListadoVtn extends JInternalFrame {
	private JTable jtblPersonas;
	private static Metodos servicios;
	private JTextField jtxtTotal;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ListadoVtn frame = new ListadoVtn(servicios);
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
	public ListadoVtn(final Metodos servicios) {
		setClosable(true);
		this.servicios=servicios;
		setBounds(100, 100, 517, 400);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
			}
		});
		
		jtxtTotal = new JTextField();
		jtxtTotal.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Total");
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblNewLabel)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(jtxtTotal, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 440, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(66)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 118, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(jtxtTotal, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel))
					.addContainerGap(161, Short.MAX_VALUE))
		);

		jtblPersonas = new JTable();
		jtblPersonas.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null},
			},
			new String[] {
				"Codigo", "Cantidad", "Producto", "Subtotal"
			}
		));
		scrollPane.setViewportView(jtblPersonas);
		getContentPane().setLayout(groupLayout);

		DefaultTableModel model = (DefaultTableModel) jtblPersonas.getModel();
		model.setRowCount(0);
		
		Object[] lista = new Object[4];
		double cont=0.00;
		for (Detalle p : servicios.getCarrito()) {
			lista[0] = p.getCodigo();
			lista[1] = p.getCantidad();
			lista[2] = p.getProducto().getNombre();
			lista[3]=p.getSubtotal();
			model.addRow(lista);
			cont+=p.getSubtotal();
		}
		jtxtTotal.setText(String.valueOf(cont));
		jtblPersonas.setModel(model);
	}

}
