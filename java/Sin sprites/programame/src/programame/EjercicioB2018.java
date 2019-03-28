package programame;

import java.util.ArrayList;
import java.util.Scanner;

public class EjercicioB2018 {
	static Scanner scanner;
	static ArrayList<Integer> listaCasos;
	static int numeroCasos;
	static int numeroCasosParaCalcular;
	static double minimaMuestra;

	public static void main(String[] args) {
		scanner = new Scanner(System.in);
		numeroCasos = scanner.nextInt();
		numeroCasosParaCalcular = numeroCasos;
		procesarNumeroDeCasos(scanner);
		calcularMinimaMuestra();
	}

	static void procesarNumeroDeCasos(Scanner s) {
		listaCasos = new ArrayList<Integer>();
		for (int i = 0; i < numeroCasos; i++) {
			int nextInt = s.nextInt();
			if (nextInt < 0 || nextInt > 10000) {
				System.out.println("omitido '" + nextInt + "', no esta en tre 0 y 10.000");
				numeroCasosParaCalcular--;
				continue;
			}
			listaCasos.add(nextInt);
		}
	}

	private static void calcularMinimaMuestra() {
		for (int i = 0; i < numeroCasosParaCalcular; i++) {
			double calculo = 10000 / listaCasos.get(i);
			minimaMuestra = 0;
			while ((minimaMuestra + calculo) % 1 != 0) {
				minimaMuestra += calculo;
			}
			minimaMuestra += calculo;
			System.out.println("-----------------------");
			System.out.println(Math.round(minimaMuestra));
		}
	}

}
