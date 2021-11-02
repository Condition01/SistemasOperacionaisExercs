package controller;

public class ProcThread extends Thread{
	private int numUm, numDois, numTres, numQuatro, numCinco,i;
	
	public ProcThread(int numUm, int numDois, int numTres, int numQuatro, int numCinco, int i) {
		this.numUm = numUm;
		this.numDois = numDois;
		this.numTres = numTres;
		this.numQuatro = numQuatro;
		this.numCinco = numCinco;
		this.i = i;
	}
	
	@Override
	public void run() {
		mostraValor();
	}
	
	public void mostraValor() {
			switch (i) {		
			case 0: 
				System.out.println(numUm);
				break;
			case 1:
				System.out.println(numDois);
				break;
			case 2:
				System.out.println(numTres);
				break;
			case 3:
				System.out.println(numQuatro);
				break;
			case 4:
				System.out.println(numCinco);
				break;
			default:
				break;
		}
	}
}
