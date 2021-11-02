package view;

import java.util.concurrent.Semaphore;

import controller.ThreadTransacao;
import model.BankAccount;

public class Main {
	public static void main(String[] args) {
		Semaphore transacoes = new Semaphore(2);
		BankAccount conta = new BankAccount(1,5000);
		
		for(int i=0;i<20;i++) {
			Thread tTransacao = new ThreadTransacao(conta, (int)(Math.random()*500+1), (int)(Math.random()*2+1), transacoes);
			tTransacao.start();
		}
		
	}
}
