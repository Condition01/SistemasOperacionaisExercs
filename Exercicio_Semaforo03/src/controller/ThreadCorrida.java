package controller;

import java.util.concurrent.Semaphore;

import model.Car;

/* try {
			semaforo.acquire();
			carroFoi();
		} catch (Exception e) {
			// TODO: handle exception
		}finally {
			semaforo.release();
		}*/


public class ThreadCorrida extends Thread{
	private Car carro;
	private Semaphore carrosFerrari;
	private Semaphore carrosLamborgini;
	private Semaphore carrosShelby;
	private Semaphore carrosHonda;
	private Semaphore carrosMacLaren;
	private Semaphore carrosMasserati;
	private Semaphore carrosToyota;
	private Semaphore carrosPista;
	private Semaphore timer;
	private static String matrizResultados[][] = new String[14][2];
	private static int j = 0;
	
	
	
	
	
	public ThreadCorrida(Car carro, Semaphore carrosPista, Semaphore carrosFerrari,Semaphore carrosLamborgini,
			Semaphore carrosShelby,Semaphore carrosHonda,Semaphore carrosMacLaren, Semaphore carrosMasserati,
							Semaphore carrosToyota, Semaphore timer) {
		this.carro = carro;
		this.carrosPista = carrosPista;
		this.carrosFerrari = carrosFerrari;
		this.carrosLamborgini = carrosLamborgini;
		this.carrosShelby = carrosShelby;
		this.carrosHonda = carrosHonda;
		this.carrosMacLaren = carrosMacLaren;
		this.carrosMasserati = carrosMasserati;
		this.carrosToyota = carrosToyota;
		this.timer = timer;
		
	}
	public void typeCar() {
		if(carro.getMarca().contains("Ferrari")) {
			ferrariLob();
		} else if(carro.getMarca().contains("Lamborgini")) {
			lamborginiLob();
		} else if(carro.getMarca().contains("Shelby")) {
			shelbyLob();
		} else if(carro.getMarca().contains("Honda")) {
			hondaLob();
		} else if(carro.getMarca().contains("MacLaren")) {
			macLarenLob();
		} else if(carro.getMarca().contains("Masserati")) {
			masseratiLob();
		} else if(carro.getMarca().contains("Toyota")) {
			toyotaLob();
		} 
	}
	
	public void ferrariLob() {
		System.out.println(carro.getCarName() + " entrou no lobby");
		SleepingThread(1500);
		try {
			carrosFerrari.acquire();
			prontoSair();
		} catch (Exception e) {
			// TODO: handle exception
		}finally {
			carrosFerrari.release();
		}
		
	}
	public void lamborginiLob() {
		System.out.println(carro.getCarName() + " entrou no lobby");
		SleepingThread(1500);
		try {
			carrosLamborgini.acquire();
			prontoSair();
		} catch (Exception e) {
			// TODO: handle exception
		}finally {
			carrosLamborgini.release();
		}
		
	}
	public void shelbyLob() {
		System.out.println(carro.getCarName() + " entrou no lobby");
		SleepingThread(1500);
		try {
			carrosShelby.acquire();
			prontoSair();
		} catch (Exception e) {
			// TODO: handle exception
		}finally {
			carrosShelby.release();
		}
		
	}
	public void hondaLob() {
		System.out.println(carro.getCarName() + " entrou no lobby");
		SleepingThread(1500);
		try {
			carrosHonda.acquire();
			prontoSair();
		} catch (Exception e) {
			// TODO: handle exception
		}finally {
			carrosHonda.release();
		}
		
	}
	public void macLarenLob() {
		System.out.println(carro.getCarName() + " entrou no lobby");
		SleepingThread(1500);
		try {
			carrosMacLaren.acquire();
			prontoSair();
		} catch (Exception e) {
			// TODO: handle exception
		}finally {
			carrosMacLaren.release();
		}
		
	}
	public void masseratiLob() {
		System.out.println(carro.getCarName() + " entrou no lobby");
		SleepingThread(1500);
		try {
			carrosMasserati.acquire();
			prontoSair();
		} catch (Exception e) {
			// TODO: handle exception
		}finally {
			carrosMasserati.release();
		}
		
	}
	public void toyotaLob() {
		System.out.println(carro.getCarName() + " entrou no lobby");
		SleepingThread(1500);
		try {
			carrosToyota.acquire();
			prontoSair();
		} catch (Exception e) {
			// TODO: handle exception
		}finally {
			carrosToyota.release();
		}
	}
	
	public void prontoSair() {
		//System.out.println(carro.getCarName() + " ESTA PRONTO PRA SAIR!!!");
		SleepingThread(3500);
		try {
			carrosPista.acquire();
			pista();
		} catch (Exception e) {
			// TODO: handle exception
		}finally {
			carrosPista.release();
		}
		
	}
	
	public void pista() {
		System.out.println(carro.getCarName() + " entrou na pista!");
		SleepingThread(1500);
		int i=1;
		int deslocamento = 0;
		double tempoInicial = System.nanoTime();
		while(i<=3) {
			deslocamento += 30;
			System.out.println(carro.getCarName() + " percorreu " + deslocamento + " metros e esta na " + i + " volta");
			if(deslocamento>=120) {
				i++;
				deslocamento = 0;
			}
			SleepingThread(300);
		}
		double tempoFinal = System.nanoTime();
		double TempoTotal = (tempoFinal - tempoInicial)/1000000000;
		try {
			timer.acquire();
			matrizResultados[j][0] = carro.getCarName();
			matrizResultados[j][1] = Double.toString(TempoTotal);
			//System.out.println(vetResultados[j][0] + " " + vetResultados[j][1]);
			j++;
			if(j==14) {
				print();
			}	
		} catch (Exception e) {
			// TODO: handle exception
		}finally {
			timer.release();
		}
	}
	public void bubleSort() {
		for(int i=0;i<13;i++) {
			for(int j=i+1;j<14;j++) {
				String aux[] = new String[2];
				if(Double.parseDouble(matrizResultados[i][1])>Double.parseDouble(matrizResultados[j][1])) {
					aux = matrizResultados[i];
					matrizResultados[i] = matrizResultados[j];
					matrizResultados[j] = aux;
				}
			}
		}
	}
	public void print() {
		bubleSort();
		System.out.println("\n");
		System.out.println("===================================== PÓDIO =====================================");
		for (int i=0;i<14;i++) {
			if(i==0) {
				System.out.println(matrizResultados[i][0] + " fez a volta mais rapida com : "+ matrizResultados[i][1] +" segundos");
			}else if(i==13){
				System.out.println(matrizResultados[i][0] + " fez a volta mais lenta com : "+ matrizResultados[i][1] +" segundos");
			}else {
				System.out.println(matrizResultados[i][0] + " fez a " + (i+1) + "o. volta mais rapida com : " + matrizResultados[i][1] +" segundos");
			}
			
		}
		System.out.println("=================================================================================");
	}
	
	public void SleepingThread(int value) {
		try {
			Thread.sleep(value);
		} catch (InterruptedException e) {
			// TODO: handle exception
		}
	}
	@Override
	public void run() {
		typeCar();
		
	}
}
