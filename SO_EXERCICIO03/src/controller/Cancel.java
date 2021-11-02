package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

import model.TelaPrincipal;

public class Cancel implements ActionListener{
	
		
	private JTextField tfCaminho;
	private JPanel contentPane;
	private JButton btnNewButtonOK,btnNewButtonCancelar,btnNewButtonProcurar;
	
	public Cancel(JPanel contentPane , JTextField tfCaminho , JButton btnNewButtonOK , JButton btnNewButtonCancelar ,JButton btnNewButtonProcurar) {
		this.contentPane = contentPane;
		this.tfCaminho = tfCaminho;	
		this.btnNewButtonOK = btnNewButtonOK;
		this.btnNewButtonCancelar = btnNewButtonCancelar;
		this.btnNewButtonProcurar = btnNewButtonProcurar;
	}
	
	public void actionPerformed(ActionEvent e) {
		
	}

	
}
