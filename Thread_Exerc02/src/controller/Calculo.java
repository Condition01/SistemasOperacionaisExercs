package controller;

public class Calculo extends Thread{
	private int vet[];
	private int i;
	
	
	public Calculo(int[] vet, int i) {
		this.vet = vet;
		this.i = i;
	}
	
	public void Calcula() {
		int resultado = 0;
		switch (i) {
		case 0:
			resultado = vet[0] + vet[1] + vet[2];
			break;
		case 1:
			resultado = vet[0] + vet[1] + vet[2];
			break;
		case 2:
			resultado = vet[0] + vet[1] + vet[2];			
			break;
		default:
			break;
		}
		System.out.println("Resultado da soma da linha " + (i+1) + " é = " + resultado);
	}


	@Override
	public void run() {
		Calcula();
	}
}
