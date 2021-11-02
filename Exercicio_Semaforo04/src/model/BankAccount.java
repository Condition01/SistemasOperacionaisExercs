package model;

public class BankAccount {
	
	private int codigoConta;
	private int quantidadeEmCaixa;
	

	public BankAccount(int codigoConta, int quantidadeEmCaixa) {
		super();
		this.codigoConta = codigoConta;
		this.quantidadeEmCaixa = quantidadeEmCaixa;
	}
	
	public int getQuantidadeEmCaixa() {
		return quantidadeEmCaixa;
	}

	public void setQuantidadeEmCaixa(int quantidadeEmCaixa) {
		this.quantidadeEmCaixa = quantidadeEmCaixa;
	}
	
	public int getCodigoConta() {
		return codigoConta;
	}

	public void setCodigoConta(int codigoConta) {
		this.codigoConta = codigoConta;
	}
	
	
}
