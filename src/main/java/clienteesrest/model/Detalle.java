package clienteesrest.model;

import java.io.Serializable;

public class Detalle implements Serializable{
	
	private int codigo;
	private int cantidad;
	private double subtotal;
	private Producto producto;
	private int codigo2;
	
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	public double getSubtotal() {
		return subtotal;
	}
	public void setSubtotal(double subtotal) {
		this.subtotal = subtotal;
	}
	public Producto getProducto() {
		return producto;
	}
	public void setProducto(Producto producto) {
		this.producto = producto;
	}
	
	
	public int getCodigo2() {
		return codigo2;
	}
	public void setCodigo2(int codigo2) {
		this.codigo2 = codigo2;
	}
	@Override
	public String toString() {
		return "Detalle [codigo=" + codigo + ", cantidad=" + cantidad + ", subtotal=" + subtotal + ", producto="
				+ producto + "]";
	}
	
	

}
