package model;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.Busca;
import controller.Cancel;
import controller.Executa;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JPasswordField;

public class TelaPrincipal extends JFrame {

	private JPanel contentPane;
	private JTextField tfCaminho;
	private JButton btnNewButtonOK,btnNewButtonCancelar,btnNewButtonProcurar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaPrincipal frame = new TelaPrincipal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public TelaPrincipal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 248);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblDigiteUmCaminho = new JLabel("Digite um caminho para o execut\u00E1vel ou click em procurar");
		lblDigiteUmCaminho.setBounds(63, 69, 361, 14);
		contentPane.add(lblDigiteUmCaminho);
		
		tfCaminho = new JTextField();
		tfCaminho.setBounds(63, 94, 361, 20);
		contentPane.add(tfCaminho);
		tfCaminho.setColumns(10);
		
		btnNewButtonOK = new JButton("OK");
		btnNewButtonOK.setBounds(42, 137, 89, 23);
		contentPane.add(btnNewButtonOK);
		
		
		btnNewButtonCancelar = new JButton("Cancelar");
		btnNewButtonCancelar.setBounds(175, 137, 89, 23);
		contentPane.add(btnNewButtonCancelar);
		
		
		btnNewButtonProcurar = new JButton("Procurar");
		btnNewButtonProcurar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButtonProcurar.setBounds(315, 137, 89, 23);
		contentPane.add(btnNewButtonProcurar);
		
		Busca b = new Busca(tfCaminho);
		btnNewButtonProcurar.addActionListener(b);
		Executa e = new Executa(contentPane, tfCaminho, btnNewButtonOK, btnNewButtonCancelar, btnNewButtonProcurar);
		btnNewButtonOK.addActionListener(e);
		Cancel c = new Cancel(contentPane, tfCaminho, btnNewButtonOK, btnNewButtonCancelar, btnNewButtonProcurar);
		
		JLabel lblAbrir = new JLabel("Abrir : ");
		lblAbrir.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblAbrir.setToolTipText("");
		lblAbrir.setBounds(10, 93, 43, 20);
		contentPane.add(lblAbrir);
		btnNewButtonCancelar.addActionListener(c);
			
	}
}
