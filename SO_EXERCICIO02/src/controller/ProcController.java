package controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.swing.JOptionPane;
import javax.swing.plaf.SliderUI;

public class ProcController {
	public String so() {
		return System.getProperty("os.name");
	}
	public void processoCompleto(String so) {
		if(so.contains("Windows")) {
			processoLista("TASKLIST");
			mataProcessoWindows();
		}else if(so.contains("Linux")) {
			processoLista("ps aux");
			mataProcessoLinux();
		}
	}
	public void processoLista(String path) {
		try {			
			Process proc = Runtime.getRuntime().exec(path);
			InputStream fluxo = proc.getInputStream(); // fluxo recebe stream de proc
			InputStreamReader leitor = new InputStreamReader(fluxo);
			BufferedReader buffer = new BufferedReader(leitor);
			String linha = buffer.readLine();
			while(linha != null){ //o laço vai até a ultima linha
				System.out.println(linha);
				linha = buffer.readLine(); //atribuindo linha com a proxima linha do arquivo
			}
		} catch (IOException e){
			String erro = e.getMessage();
			JOptionPane.showMessageDialog(null, erro, "ERRO", JOptionPane.ERROR_MESSAGE); //CONSTANTE QUE EXISTE DENTRO DA CLASSE JOPTIONPANE, O "ERRO" VAI APARECER NO CABEÇALHO
			e.printStackTrace(); //erro aparece no console
			
		}
		
	}
	public void mataProcessoWindows(){
		String infoProcesso = JOptionPane.showInputDialog("Digite o processo que deseja matar");
		String cmdPid = "TASKKILL /PID ";
		String cmdNome = "TASKKILL /IM ";
		int pid = 0;
		StringBuffer buffer = new StringBuffer();
		try{
			pid = Integer.parseInt(infoProcesso); //ele tenta converter pra inteiro, se não der ele vai pro catch
			buffer.append(cmdPid);
			buffer.append(pid);
		}catch(NumberFormatException e){ //usando numberformat <---
			buffer.append(cmdNome);
			buffer.append(infoProcesso);
		}
		chamaProcesso(buffer.toString());
	}
	public void chamaProcesso(String path){ //chama um processo pra executar utilizando shellscript
		try {
			Runtime.getRuntime().exec(path);
		} catch (IOException e) {
			String erro = e.getMessage();
			if(erro.contains("740")){ //caso a exception contenha o erro 740(autenticação);
				StringBuffer buffer = new StringBuffer();
				buffer.append("cmd /c ");
				buffer.append(path); //aqui ele adiciona o comando de validação e em seguida ja tenta forçar uma nova run do processo
				try {
					Runtime.getRuntime().exec(buffer.toString());
				} catch (IOException e1) { // e1 pq a exception esta dentro de uma exception
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			else{
				e.printStackTrace();
			}
		}
	}
	public void mataProcessoLinux() {
		String infoProcesso = "";
		infoProcesso = JOptionPane.showInputDialog("Digite o processo que deseja matar");
		String cmdPid = "kill ";
		String cmdNome = "killall ";
		int pid = 0;
		StringBuffer buffer = new StringBuffer();
		try{
			pid = Integer.parseInt(infoProcesso); //ele tenta converter pra inteiro, se não der ele vai pro catch
			buffer.append(cmdPid);
			buffer.append(pid);
		}catch(NumberFormatException e){ //usando numberformat <---
			buffer.append(cmdNome);
			buffer.append(infoProcesso);
		}
		try {
			Runtime.getRuntime().exec(buffer.toString());
		} catch (IOException e) {
			e.printStackTrace();
		}	
	}
	
}
	/*public String validaProcesso(String infoProcesso) {
		do {
			infoProcesso = JOptionPane.showInputDialog("Digite o valor ou o pid do processo");
		}while(!(infoProcesso.contains("exe")) || !(infoProcesso.contains("1")) ||  !(infoProcesso.contains("2")) ||  !(infoProcesso.contains("3"))|| !(infoProcesso.contains("4")) 
				|| !(infoProcesso.contains("5")) || !(infoProcesso.contains("6")) || !(infoProcesso.contains("7")) || !(infoProcesso.contains("8")) ||!(infoProcesso.contains("9"))
				|| !(infoProcesso.contains("10")));
		return infoProcesso;
	}*/

