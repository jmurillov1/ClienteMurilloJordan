package clientewsrest.metodos;

import java.util.List;

import clienteesrest.model.Producto;

public class Pri {

	public static void main(String args[]) {
		// TODO Auto-generated method stub
		Metodos met = new Metodos();
		// Cosumiendo WS-REST de tipo GET que retorna una colección de objeto
		/*List<Persona> pers = met.getPersonas();
		System.out.println("PASA");
		System.out.println(pers);

		//Consumiento un WS-REST de tipo POST enviando una entidad como parametro
		Transaccion tr = new Transaccion();
		tr.setCodigo(1000);
		tr.setCuentaOrigen("07011");
		tr.setCuentaDestino("070722");
		tr.setValor(1000.99);
		Persona per = new Persona();
		per.setCedula("0706148509");
		tr.setPersona(per);
		Respuesta respuesta = met.saveTransaccion(tr);
		System.out.println(respuesta);
		/*Respuesta r1 = met.eliminarTransaccion(1000);
		System.out.println(r1);*/
			
		/*for (Producto pro : met.getPersonas()) {
			System.out.println(pro.toString());
		}*/
		
		System.out.println(met.getProducto(10));
		
	}
}
