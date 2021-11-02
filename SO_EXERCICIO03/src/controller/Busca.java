package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.JTextField;
import javax.swing.filechooser.FileNameExtensionFilter;

public class Busca implements ActionListener{
	private JTextField tfCaminho;
	
	public Busca(JTextField tfCaminho) {
		this.tfCaminho = tfCaminho;
	}
	
	public void procuraArquivo() {
		FileNameExtensionFilter filtro = new FileNameExtensionFilter("Arquivos Executáveis (.exe", "exe");//só procura arquivos .exe
		String diretorioBase = System.getProperty("user.home") + "/Desktop";
		File dir = new File(diretorioBase); //caminho para o diretório base		
		JFileChooser choose = new JFileChooser();
		choose.setCurrentDirectory(dir);
		choose.setFileSelectionMode(JFileChooser.FILES_ONLY); //SO FILES VAO SER SELECIONADOS
		choose.setAcceptAllFileFilterUsed(false); //não aceita todos os arquivos
		choose.addChoosableFileFilter(filtro); //aceitar arquivos .exe / tbm pode ser um vetor com varios tipos de arqiovp
		String caminhoArquivo = "";
		int retorno = choose.showOpenDialog(null); //habilitar o botão de abrir
		if(retorno == JFileChooser.APPROVE_OPTION) {
			caminhoArquivo = choose.getSelectedFile().getAbsolutePath(); //caminho que selecionou + caminho todo do arquivo
			tfCaminho.setText(caminhoArquivo);
		}
	}	
	
	public void actionPerformed(ActionEvent e) {
		procuraArquivo();
		
	}
}
