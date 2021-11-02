package controller;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import model.TelaPrincipal;

public class Executa implements ActionListener {
	private JTextField tfCaminho;
	private JPanel contentPane;
	private JButton btnNewButtonOK,btnNewButtonCancelar,btnNewButtonProcurar;
	
	public Executa(JPanel contentPane , JTextField tfCaminho , JButton btnNewButtonOK , JButton btnNewButtonCancelar ,JButton btnNewButtonProcurar) {
		this.contentPane = contentPane;
		this.tfCaminho = tfCaminho;	
		this.btnNewButtonOK = btnNewButtonOK;
		this.btnNewButtonCancelar = btnNewButtonCancelar;
		this.btnNewButtonProcurar = btnNewButtonProcurar;
	}
	public void executaProcesso(String path) {
		try {
			Runtime.getRuntime().exec(path);
		}catch(Exception eUm){
			String erro = eUm.getMessage();
			JOptionPane.showMessageDialog(null, erro, "ERRO", JOptionPane.ERROR_MESSAGE);
			eUm.printStackTrace();
			this.dispose();
		}
	}	
	private void dispose() {
		// TODO Auto-generated method stub
		
	}
	public void actionPerformed(ActionEvent e) {
		executaProcesso(this.tfCaminho.getText());
	}
}
