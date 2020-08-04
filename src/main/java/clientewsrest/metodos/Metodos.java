package clientewsrest.metodos;

import java.util.List;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;

import clienteesrest.model.Detalle;
import clienteesrest.model.Producto;

public class Metodos {

	private String ser1 = "http://localhost:8080/ServidorMurilloJordan/rs/carrito/guardarProducto";
	private String ser2 = "http://localhost:8080/ServidorMurilloJordan/rs/carrito/productos";
	private String ser3 = "http://localhost:8080/ServidorMurilloJordan/rs/carrito/guardarCarrito";
	private String ser4 = "http://localhost:8080/ServidorMurilloJordan/rs/carrito/detalles";
	private String ser5 = "http://localhost:8080/ServidorMurilloJordan/rs/carrito/producto";
	
	
	public String guardarProducto(Producto pro) {
		Client client = ClientBuilder.newClient();
		System.out.println(pro.toString());
		WebTarget target = client.target(ser1);
		String respuesta = target.request().post(Entity.json(pro), String.class);
		return respuesta;
	}
	

	public List<Producto> getPersonas() {
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target(ser2);

		List<Producto> pros = target.request().get(new GenericType<List<Producto>>() {});
		
		client.close();
		
		return pros;		
	}
	
	public String guardarCarrito(Detalle det) {
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target(ser3);
		String respuesta = target.request().post(Entity.json(det), String.class);
		return respuesta;
	}
	

	public List<Detalle> getCarrito() {
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target(ser4);

		List<Detalle> pros = target.request().get(new GenericType<List<Detalle>>() {});
		
		client.close();
		
		return pros;		
	}
	
	public Producto getProducto(int codigo) {
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target(ser5+"?codigo="+codigo);

		Producto pro = target.request().get(Producto.class);
		
		client.close();
		
		return pro;		
	}
	
}
