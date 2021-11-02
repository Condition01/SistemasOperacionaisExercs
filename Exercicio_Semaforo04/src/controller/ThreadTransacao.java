package controller;

import java.util.concurrent.Semaphore;

import model.BankAccount;

public class ThreadTransacao extends Thread{
	
	private BankAccount conta;
	private Semaphore transacoes;
	private int operacao;
	private int valor;
	static int i = 0;
	
	public ThreadTransacao(BankAccount conta, int valor, int operacao, Semaphore transacoes) {
		this.conta = conta;
		this.transacoes = transacoes;
		this.operacao = operacao;
		this.valor = valor;
	}
	public void bancoOperacao(){
		if(operacao == 1) {
			System.out.println("Sera depositado " + valor + " na conta " + conta.getCodigoConta());
			int valorAtual = conta.getQuantidadeEmCaixa() + valor;
			conta.setQuantidadeEmCaixa(valorAtual);
		}else if(operacao == 2){
			System.out.println("Sera sacado " + valor + " na conta " + conta.getCodigoConta());
			int valorAtual = conta.getQuantidadeEmCaixa() - valor;
			conta.setQuantidadeEmCaixa(valorAtual);
		}
		i++;
		if(i==20) {
			print();
		}
		SleepingThread(1000);
	}
	public void print() {
		System.out.println("-------------------------------------------------------------------");
		System.out.println("Saldo da conta " + conta.getCodigoConta() + " é = " + conta.getQuantidadeEmCaixa());
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
		try {
			transacoes.acquire();
			bancoOperacao();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			transacoes.release();
		}
		
		
	}
	
}
