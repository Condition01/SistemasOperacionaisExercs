package controller;

import java.util.concurrent.Semaphore;

public class ThreadCaminhada extends Thread{
	private String pessoa;
	private int corredor;
	private int distanciaPercorrida;
	private Semaphore semaforo;

	public ThreadCaminhada(String pessoa, int corredor, Semaphore semaforo) {
		this.pessoa = pessoa;
		this.corredor = corredor;	
		this.semaforo = semaforo;
	}
	
	public void caminhada() {
		int tempo = 100;
		distanciaPercorrida = 0;
		while(distanciaPercorrida<corredor) {
			int passo = (int)(Math.random()*5)+2;
			distanciaPercorrida += passo;
			System.out.println(pessoa + " Andou mais " + passo + " metros " + " e já percorreu " + distanciaPercorrida + " metros no total");
			try {
				Thread.sleep(tempo);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public void abrirPorta() {
		System.out.println(pessoa + " Esta parado(a) de frente com a porta à abrindo");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void cruzarPorta() {
		System.out.println(pessoa + " Cruzou a porta!");
	}
	
	
	@Override
	public void run() {
		caminhada();
		try {
			semaforo.acquire();
			abrirPorta();
			cruzarPorta();	
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			semaforo.release();
		}	
	}
	
	

}
