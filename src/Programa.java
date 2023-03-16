import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

public class Programa extends TasasDeCambio {
		
	// Menu Principal

	double valor;
	double temp;

	public void pantallaPrincipal() {

		try {

			Object seleccion = JOptionPane.showInputDialog(null, "Seleccione el tipo de conversion que desea hacer",
					"Menu", JOptionPane.QUESTION_MESSAGE, null,
					new Object[] { "Conversor de Moneda", "Conversor de Temperatura" }, "Conversor de Moneda");

			if (seleccion.toString().equalsIgnoreCase("Conversor de Moneda")) {

				convertirDinero();

			} else if (seleccion.toString().equalsIgnoreCase("Conversor de Temperatura")) {

				convertirTemperatura();

			}

		} catch (Exception e) {
			int resp = JOptionPane.showConfirmDialog(null, "Desea salir del programa?", "Salir",
					JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE);
			if (resp == 1) {
				pantallaPrincipal();
			}

		}
	}


	 
	/**
	 * Convertir Dinero
	 */
	public void convertirDinero() {
		
		boolean esDouble = false;
		
		do {

			try {

				valor = Double.parseDouble(JOptionPane.showInputDialog("Ingrese la cantidad a convertir"));
				esDouble = true;

			} catch (NumberFormatException nfe) {

				JOptionPane.showMessageDialog(null, "Debe ingresar un valor mumerico","Informacion", 2);
			}

		} while (!esDouble == true);

		opcionesDeMoneda();
	}

	/**
	 * Opciones de monedas a convertir
	 */
	public void opcionesDeMoneda() {
		 
		List<String> monedas = new ArrayList<String>();
		
		for (Divisas tmp: Divisas.values() ) {
			monedas.add(tmp.getTexto());
		}
		
		String[] simpleArray = new String[ monedas.size() ];
		monedas.toArray( simpleArray );
						
		String seleccion = (String) JOptionPane.showInputDialog(null, 
				"Elije la moneda a la que deseas convertir tu dinero",
				"Convertidor de Monedas", JOptionPane.PLAIN_MESSAGE, null,
				simpleArray, simpleArray[0]
				);
 
		for (Divisas tmp: Divisas.values() ) {

            //System.out.println (tmp.toString() + " el factor es " +  tmp.getFactorConversion() + "  " + tmp.nombre);
            
            if (seleccion.equalsIgnoreCase(tmp.getTexto())) {
            
            	String msg ="<html>Valor ingresado: " + tmp.getSignoOrigen() +  " " + String.format("%,.2f", valor)  +  "<br>" +
				"Conversión seleccionada: " + tmp.getTexto() +  "<br>" +
				"Factor de conversión: " + tmp.getFactorConversion() +  "<br>" +	
				"Resultado: " + tmp.getSignoDestino() + " " +
				String.format("%,.2f",tmp.getFactorConversion() * valor);
				
	            JOptionPane.showMessageDialog(null,
						msg, "Resultado", 1, null);
			
            	break; 
			}

        }	
		
		int resp = JOptionPane.showConfirmDialog(null, "Desea realizar otra conversion?", "Regresar",
				JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE);
		if (resp == 0) {
			pantallaPrincipal();

		}
	}

	
	// Convertir Temperatura
	public void convertirTemperatura() {
		temp = Double.parseDouble(JOptionPane.showInputDialog("Ingrese el valor a convertir"));
		opcionesDeTemperatura();

	}

	 
	// Menu Opciones de Temperatura
	public void opcionesDeTemperatura() {

		DecimalFormat df = new DecimalFormat("#.##");
		Object seleccion = JOptionPane.showInputDialog(null, "Elije la temperatura a la que deseas convertir",
				"Temperaturas", JOptionPane.QUESTION_MESSAGE, null,
				new Object[] { "De Celcius a Farnheit", "De Faremheit a Celcius" }, "De Celcius a Farnheit");

		if (seleccion.equals("De Celcius a Farnheit")) {
			double conversion = (temp * 1.8) + 32;
			String resultado = df.format(conversion);
			JOptionPane.showMessageDialog(null,
					temp + " Grados °C Es equivalente a : " + resultado + " Grados Fahrenheit", "Resultado", 1, null);
		} else {
			double conversion = (temp - 32) / 1.8;
			String resultado = df.format(conversion);
			JOptionPane.showMessageDialog(null, temp + " Grados °F Es equivalente a : " + resultado + " Grados Celcius",
					"Resultado", 1, null);
		}

	}

}