package controller;

import java.util.concurrent.Semaphore;

public class SemaforoCarros extends Thread{
	private String carro;
	static int sentido = 1;
	Semaphore semaforo;
	
	public SemaforoCarros(String carro, Semaphore semaforo) {
		this.carro = carro;
		this.semaforo = semaforo;
	}
	public void carroParado() {
		System.out.println(carro + " esta parado no semafaro");
		try {
			Thread.sleep(1500);
		} catch (InterruptedException e) {
			// TODO: handle exception
		}
	}
	public void carroFoi() {
		System.out.println(carro + " foi liberado e esta indo sentido " + qualSentido(sentido));
		sentido++;
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO: handle exception
		}
	}
	
	public String qualSentido(int sentido){
		if (sentido == 1) {
			return "leste";
		}else if(sentido == 2) {
			return "oeste";
		}else if (sentido == 3){
			return "sul";
		}else {
			return "norte";
		}
	}
	@Override
	public void run() {
		carroParado();
		try {
			semaforo.acquire();
			carroFoi();
		} catch (Exception e) {
			// TODO: handle exception
		}finally {
			semaforo.release();
		}
	}
}
