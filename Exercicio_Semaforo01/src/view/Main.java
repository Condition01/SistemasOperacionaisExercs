package view;

import java.util.concurrent.Semaphore;

import controller.ThreadCaminhada;

public class Main {
	public static void main(String[] args) {
		Semaphore semaforo = new Semaphore(1);
		String pessoaUm = "Carlos", pessoaDois = "Danilo", pessoaTres = "Jessica", pessoaQuatro = "Alexia";
		int corredor = 200;
		Thread pessoa = new ThreadCaminhada(pessoaUm, corredor, semaforo);
		pessoa.start();
		Thread pessoa2 = new ThreadCaminhada(pessoaDois, corredor, semaforo);
		pessoa2.start();
		Thread pessoa3 = new ThreadCaminhada(pessoaTres, corredor, semaforo);
		pessoa3.start();
		Thread pessoa4 = new ThreadCaminhada(pessoaQuatro, corredor, semaforo);
		pessoa4.start();	
	}
}
