package view;

import java.util.concurrent.Semaphore;

import controller.ThreadCorrida;
import model.Car;

public class CorridaF1 {
	
	public static void main(String[] args) {
		Semaphore carrosPista = new Semaphore(5);
		Semaphore carrosFerrari = new Semaphore(1);
		Semaphore carrosLamborgini = new Semaphore(1);
		Semaphore carrosShelby = new Semaphore(1);
		Semaphore carrosHonda = new Semaphore(1);
		Semaphore carrosMacLaren = new Semaphore(1);
		Semaphore carrosMasserati = new Semaphore(1);
		Semaphore carrosToyota = new Semaphore(1);
		Semaphore timer = new Semaphore(1);
		Thread carT = null;
		

		//////////////////////////////////////////////////////////////////////
		Car carro[] = new Car[14];
		carro[0] = new Car("Ferrari", "Ferrari_1");
		carro[1] = new Car("Ferrari", "Ferrari_2");
		carro[2] = new Car("Lamborgini", "Lamborgini_1");
		carro[3] = new Car("Lamborgini", "Lamborgini_2");
		carro[4] = new Car("Shelby", "Shelby_1");
		carro[5] = new Car("Shelby", "Shelby_2");
		carro[6] = new Car("MacLaren", "MacLaren_1");
		carro[7] = new Car("MacLaren", "MacLaren_2");
		carro[8] = new Car("Honda", "Honda_1");
		carro[9] = new Car("Honda", "Honda_2");
		carro[10] = new Car("Toyota", "Toyota_1");
		carro[11] = new Car("Toyota", "Toyota_2");
		carro[12] = new Car("Masserati", "Masserati_1");
		carro[13] = new Car("Masserati", "Masserati_2");
		//////////////////////////////////////////////////////////////////////////////
		for(int i=0;i<14;i++) {
			carT = new ThreadCorrida(carro[i], carrosPista, carrosFerrari, carrosLamborgini, carrosShelby, carrosHonda, carrosMacLaren, carrosMasserati, carrosToyota, timer);
			carT.start();
		}
		
		//for(int i=0;i<14;i++) {
		//	System.out.println(vetResultados[i][0] + " " + vetResultados[i][1]);
		//}
	}
}
