package view;

import controller.ThreadCar;
import java.util.concurrent.Semaphore;

public class Park {
	public static void main(String[] args) {
		int permissoes = 4;
		Semaphore semafaro = new Semaphore(permissoes);
		for(int i=1;i<=10;i++){
			Thread carro = new ThreadCar(i, semafaro);
			carro.start();
		}
	}
}
