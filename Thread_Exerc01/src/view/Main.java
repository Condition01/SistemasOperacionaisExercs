package view;

import controller.ProcThread;

public class Main {
	public static void main(String[] args) {
		int numUm = 1, numDois = 2, numTres = 3, numQuatro = 4, numCinco = 5;
		for(int i=0;i<5;i++) {
			try {
				Thread procT = new ProcThread(numUm, numDois, numTres, numQuatro, numCinco, i);
				procT.start();
			}catch(Exception e) {
				e.printStackTrace();
			}			
		}
	}
}
