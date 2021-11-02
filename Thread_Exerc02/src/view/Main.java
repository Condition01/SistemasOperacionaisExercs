package view;

import controller.Calculo;

public class Main {
	public static void main(String[] args) {		
		int matrix[][] = new int[3][5];
		matrix = carregaMatrix(matrix);
		for (int i=0;i<3;i++) {
			Thread tCalc = new Calculo(matrix[i], i);
			tCalc.start();
		}
		
	}
	static int[][] carregaMatrix(int matrix[][]){
		for (int i=0;i<3;i++) {
			for (int j=0;j<5;j++) {
				matrix[i][j] = (int)((Math.random()*10)+1);
			}
		}
		return matrix;
	}
}
