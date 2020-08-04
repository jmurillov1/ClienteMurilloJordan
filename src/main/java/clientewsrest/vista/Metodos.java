package clientewsrest.vista;

import java.util.List;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;

public class Metodos {

	private String ser1 = "http://localhost:8080/ServidorMurilloJordan/rs/carrito/guardarProducto";
	
	
	public String guardarProducto(Producto pro) {
		Client client = ClientBuilder.newClient();
		System.out.println(pro.toString());
		WebTarget target = client.target(ser1);
		String respuesta = target.request().post(Entity.json(pro), String.class);
		return respuesta;
	}
}
