package view;

import java.util.concurrent.Semaphore;

import controller.SemaforoCarros;

public class Main {
	public static void main(String[] args) {
		Semaphore semaforo = new Semaphore(1);
		
		for(int i=1;i<=4;i++) {
			Thread carro = new SemaforoCarros(carroType(i), semaforo);
			carro.start();
		}
	}
	static String carroType(int i) {
		if (i == 1) {
			return "Mustang";
		}else if(i == 2) {
			return "Corolla";
		}else if (i == 3){
			return "Ferrari";
		}else {
			return "Cadilac";
		}
	}
}
