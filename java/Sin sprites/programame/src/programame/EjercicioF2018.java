package programame;

import java.util.ArrayList;
import java.util.Scanner;

public class EjercicioF2018 {
	static Scanner scanner;
	static ArrayList<Integer> caseList;
	static int maxWeight;
	static int weightLeft;
	static int weightRight;
	static int balanceCounterLeft;
	static int balanceCounterRight;

	public static void main(String[] args) {
		scanner = new Scanner(System.in);
		maxWeight = 1000000000;
		processCases(scanner);
		setBalance();
	}

	public static void processCases(Scanner s) {
		caseList = new ArrayList<Integer>();
		boolean addCase = true;
		while (addCase) {
			addCase = analizeMaxWeight(s);
		}
	}

	public static boolean analizeMaxWeight(Scanner s) {
		int caseAnalized = s.nextInt();
		if (caseAnalized > 0 && caseAnalized <= maxWeight) {
			caseList.add(caseAnalized);
		} else if (caseAnalized < 0) {
			System.out.println("El dato " + caseAnalized + " no se va a analizar (el peso no puede ser negativo)");
		} else if (caseAnalized > maxWeight) {
			System.out.println("El dato " + caseAnalized + " no se va a analizar (el peso excede el máximo de 10^9");
		} else if (caseAnalized == 0) {
			return false;
		}
		return true;
	}

	public static void setBalance() {
		for (int i = 0; i < caseList.size(); i++) {
			weightLeft = 1;
			weightRight = caseList.get(i);
			balanceCounterLeft = 0;
			balanceCounterRight = 0;
			int loopVar = 0;
			boolean check = true;

			while (check) {
				if (weightRight % 3 != 0) {
					weightRight++;
				} else {
					check = false;
				}
			}

			System.out.println("meow =^.^=");

			/*
			 * while (weightLeft != weightRight) { if (weightLeft > weightRight) { if
			 * (balanceCounterRight == 0) { weightRight += 1; } else { weightRight +=
			 * balanceCounterRight * 3; } balanceCounterRight++; } else if (weightLeft <
			 * weightRight) { if (balanceCounterLeft == 0) { weightLeft += 1; } else {
			 * weightLeft += balanceCounterLeft * 3; } balanceCounterLeft++; } }
			 * System.out.println(weightLeft + " =X= " + weightRight);
			 */
		}

		// la suma del peso de la patata + las pesas del lado de la patata tiene que ser
		// ^3
	}

}

/*
 * Entrada = peso patatas en gramos
 * 
 * Salida: pesoPesa1 pesoPesa [^3] =X= [numero de pesas] + patatas [peso]
 */
