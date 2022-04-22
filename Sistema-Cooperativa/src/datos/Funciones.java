package datos;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.time.DayOfWeek;

public class Funciones {

	// ______________________________FECHAS______________________________

	public static int calcularMesesEntreFechas(LocalDate temporal1Inclusive, LocalDate temporal2Exclusive) {

		return (int) ChronoUnit.MONTHS.between(temporal1Inclusive, temporal2Exclusive);

	}

	public static boolean esDiaHabil(LocalDate fecha) {

		int d = fecha.getDayOfWeek().getValue();

		return ((d >= 1) && (d <= 5));
	}

	public static int calcularCantDiasEntreMeses(int mes, int anio) {

		LocalDate fechaInicio = LocalDate.of(2021, 11, 10);
		LocalDate fechaFin = LocalDate.of(2021, 11, 15);
		LocalDate fechaAux = fechaInicio;
		boolean habil = true;
		int contadorDias = 0;

		while (fechaAux.isBefore(fechaFin) || fechaAux.compareTo(fechaFin) == 0) {

			if (habil) {

				if ((Funciones.esDiaHabil(fechaAux)) && fechaAux.getMonthValue() == mes) {

					contadorDias++;
				}
			} else if ((Funciones.esDiaHabil(fechaAux) == false) && fechaAux.getMonthValue() == mes) {

				contadorDias++;
			}

			fechaAux = fechaAux.plusDays(1);
		}

		return contadorDias;
	}

	public static int cantidadDeDiasEntreFechas(LocalDate desde, LocalDate hasta, LocalDate buscar) {

		LocalDate fechaAux = desde;
		int contDias = 0;
		boolean encontrada = false;

		while (!encontrada || fechaAux.isBefore(hasta) || fechaAux.compareTo(hasta) == 0) {

			if (fechaAux.equals(buscar)) {

				encontrada = true;

			}

			contDias++;

			fechaAux = fechaAux.plusDays(1);
		}

		return contDias;
	}

	// ______________________________HORAS______________________________

	public static boolean entreHorasIncluyente(LocalTime hora, LocalTime desde, LocalTime hasta) {

		boolean valido = false;

		if (hora.equals(desde) || hora.equals(hasta) || (hora.isAfter(desde) && hora.isBefore(hasta))) {

			valido = true;
		}

		return valido;
	}

	public static boolean entreFechasIncluyente(LocalDate desde, LocalDate hasta, LocalDate buscar) {

		boolean valido = false;

		if (desde.equals(buscar) || hasta.equals(buscar) || (buscar.isAfter(desde) && buscar.isBefore(hasta))) {

			valido = true;

		}

		return valido;
	}

	// ______________________________FECHAS______________________________

	public static boolean validarCuil(String cuil, char sexo) throws Exception {

		validarSexo(sexo);

		if (cuil.length() != 11) {

			throw new Exception("EL CUIL NO TIENE 11 DIGITOS");

		}

		int[] cuilAux = new int[11];
		int sumaNumeros = 0;
		int x = 0;
		int y = 0;
		boolean numCorrecto = false;
		int r = 0;
		int zeta = 0;

		char masculino1 = 'm';
		char masculino2 = 'M';

		if (masculino1 == sexo || masculino2 == sexo) {

			x = 2;
			y = 0;
		} else {
			x = 2;
			y = 7;
		}

		for (int j = 0; j < cuil.length(); j++) {

			cuilAux[j] = Character.getNumericValue(cuil.charAt(j));

		}

		sumaNumeros += x * 5;
		sumaNumeros += y * 4;
		int j = 0;
		int[] valores = new int[] { 3, 2, 7, 6, 5, 4, 3, 2 };

		for (int i = 2; i < 10; i++) {

			sumaNumeros += cuilAux[i] * valores[j];

			j++;
		}

		r = sumaNumeros % 11;

		if (r == 0)
			zeta = 0;

		if (r == 1) {

			if (y == 0) {

				zeta = 9;
				x = 2;
				y = 3;

			} else {

				zeta = 4;
				x = 2;
				y = 3;

			}

		}

		if (r != 0 && r != 1) {

			zeta = 11 - r;
		}

		if (zeta == cuilAux[10])
			numCorrecto = true;
		else
			throw new Exception("ERROR!!!, CUIL INVÁLIDO\n\n");

		return numCorrecto;
	}

	public static boolean validarSexo(char sexo) throws Exception {

		boolean esValido = false;

		if (sexo == 'f' || sexo == 'F' || sexo == 'm' || sexo == 'M')
			esValido = true;
		else
			throw new Exception("ERROR!! EL SEXO ES INVÁLIDO");

		return esValido;
	}

	public static boolean esBisiesto(int anio) {
		return (anio % 4 == 0 && !(anio % 100 == 0 && anio % 400 != 0));
	}

	public static int traerAnio(LocalDate fecha) {
		return fecha.getYear();
	}

	public static int traerMes(LocalDate fecha) {
		return fecha.getMonthValue();
	}

	public static int traerDia(LocalDate fecha) {
		return fecha.getDayOfMonth();
	}

	public static boolean esFechaValida(LocalDate fecha) {

		boolean valida = false;
		boolean bisiesto = esBisiesto(fecha.getDayOfYear());
		boolean treintaYUno = ((fecha.getMonthValue() % 2 != 0 && fecha.getMonthValue() <= 7)
				|| (fecha.getMonthValue() >= 8 && fecha.getMonthValue() % 2 == 0)) && fecha.getMonthValue() != 2;
		boolean treinta = ((fecha.getMonthValue() % 2 == 0 && fecha.getMonthValue() <= 6)
				|| (fecha.getMonthValue() % 2 != 0 && fecha.getMonthValue() >= 9)) && fecha.getMonthValue() != 2;
		if (treintaYUno && fecha.getDayOfMonth() >= 1 && fecha.getDayOfMonth() <= 31) {
			valida = true;
		} else if (treinta && fecha.getDayOfMonth() >= 1 && fecha.getDayOfMonth() <= 30) {
			valida = true;
		} else if (bisiesto && fecha.getDayOfMonth() >= 1 && fecha.getDayOfMonth() <= 29) {
			valida = true;
		} else if (fecha.getDayOfMonth() >= 1 && fecha.getDayOfMonth() <= 28) {
			valida = true;
		}
		return valida;

	}

	public static String traerFechaCorta(LocalDate f) {
		String fecha = "";
		if (f != null)
			fecha = traerDia(f) + "/" + traerMes(f) + "/" + traerAnio(f);
		return fecha;
	}

	public static int traerHora(LocalTime hora) {

		return hora.getHour();

	}

	public static int traerMinutos(LocalTime hora) {

		return hora.getMinute();

	}

	public static int traerSegundos(LocalTime hora) {

		return hora.getSecond();

	}

	public static String traerHoraCorta(LocalTime h) {
		String hora = "";
		if (h != null)
			hora = traerHora(h) + "/" + traerMinutos(h) + "/" + traerSegundos(h);
		return hora;
	}

	public static DayOfWeek traerDiaDeLaSemana(LocalDate fecha) {

		DayOfWeek dia = fecha.getDayOfWeek();// averiguar como traer dia de la semana con LocalDate

		return dia;//
	}

	public static String traerMesEnLetras(LocalDate fecha) {

		int mes = fecha.getMonthValue();
		String month = "";
		switch (mes) {

		case 1:
			month = "Enero";
			break;
		case 2:
			month = "Febrero";
			break;
		case 3:
			month = "Marzo";
			break;
		case 4:
			month = "Abril";
			break;
		case 5:
			month = "Mayo";
			break;
		case 6:
			month = "Junio";
			break;
		case 7:
			month = "Julio";
			break;
		case 8:
			month = "Agosto";
			break;
		case 9:
			month = "Septiembre";
			break;
		case 10:
			month = "Octubre";
			break;
		case 11:
			month = "Noviembre";
			break;
		case 12:
			month = "Diciembre";
			break;
		}
		return month;

	}

	public static String traerFechaLarga(LocalDate fecha) {

		return traerDiaDeLaSemana(fecha) + " " + fecha.getDayOfMonth() + " de " + traerMesEnLetras(fecha) + " del "
				+ fecha.getYear();
	}

	public static int traerCantDiasDeUnMes(int anio, int mes) {

		int cantDiaMes;

		if (esBisiesto(anio) && mes == 2) {
			cantDiaMes = 29;
		} else if (mes == 4 || mes == 6 || mes == 9 || mes == 11) {

			cantDiaMes = 30;
		} else if (mes == 2) {

			cantDiaMes = 28;

		} else {
			cantDiaMes = 31;
		}
		return cantDiaMes;

	}

	public static double aproximar2Decimal(double valor) {
		double decimal = (valor * 100) - (Math.floor(valor * 100));
		if (decimal >= 0.5) {
			valor = (valor + 0.01) - (decimal / 100);
		} else {
			valor = valor - (decimal / 100);
		}
		return valor;
	}

	public static boolean esNumero(char c) {
		return Character.isDigit(c);
	}

	public static boolean esLetra(char c) {
		return Character.isLetter(c);
	}

	public static boolean esCadenaNros(String cadena) {
		boolean cadenaNros = true;
		int caracter = 0;
		while (cadenaNros && caracter < cadena.length()) {
			if (!esNumero(cadena.charAt(caracter))) {
				cadenaNros = false;
			}
			caracter++;
		}
		return cadenaNros;
	}

	public static boolean esCadenaLetras(String cadena) {
		boolean cadenaLtrs = true;
		int caracter = 0;
		while (cadenaLtrs && caracter < cadena.length()) {

			if (!Character.isLetter(cadena.charAt(caracter))) {
				cadenaLtrs = false;
			}
			caracter++;
		}
		return cadenaLtrs;
	}

	public static double convertirADouble(int n) {
		return ((double) n);

	}

}
