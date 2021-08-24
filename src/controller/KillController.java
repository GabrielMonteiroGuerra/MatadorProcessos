package controller;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public class KillController {

	public KillController() {
		super();
	}

	
	//Mostra o sistema operacional da máquina
	public String os() {
		String oSystem = System.getProperty("os.name");
		return "Sistema operacional: "+oSystem;
	}
	
	public void listaProcessos(String chamaLista) {
       //chamando o método para validar o sistema operacional
		KillController oSystem = new KillController();
		
		String so = oSystem.os();
		
		
		//Validando o sistema operacional
		if(so.contains("Windows")) {
			chamaLista = "cmd /c start C:\\Windows\\System32\\cmd.exe";
		}else {
			chamaLista = "sudo su \\usr\\bin\\exo-open";
		}
		
		//Para abrir o prompt de comando:
		try {
//			Execução do comando para abrir o prompt de comando
			Runtime.getRuntime().exec(chamaLista.toString());
			} catch (Exception e) {
				e.printStackTrace();
				}
		
			StringBuffer buffer = new StringBuffer(); //Criando o buffer
			if(so.contains("Windows")) {
				buffer.append("tasklist /fo table"); //Caso o sistema contenha o nome de windows, comando para listar todos os processos
			}else {
				buffer.append("ps -ef"); //Caso não seja windows, comando para listar todos os processos
			}
			
			try {
				
				Process rodaCmd = Runtime.getRuntime().exec(buffer.toString()); //Retorna dados e continua recebendo dados enquanto for executada
				InputStream fluxo = rodaCmd.getInputStream();//fluxo de bits
				InputStreamReader leitor = new InputStreamReader(fluxo); // Lê e converte para String
				BufferedReader buffer1 = new BufferedReader(leitor); //Guarda a variável no buffer
				String linha = buffer1.readLine();
				
				while(linha != null) {
					System.out.println(linha); //Enquanto a linha for diferente de null, vai printando na tela
					linha = buffer1.readLine();
				}
				buffer1.close();
				leitor.close();
				fluxo.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
	}
			
			public void mataPid(int pid) {
				
				KillController opSystem = new KillController(); //Instancia de classe
				String so = opSystem.os();
				
				
				String comando = " ";		
				if(so.contains("Windows")) {
					comando = "taskkill /pid"; //Comando para matar por PID no windows
				}else {
					comando = "kill -9"; //Comando para matar por PID no linux
				}
				StringBuffer buffer = new StringBuffer();
				
				try {
					buffer.append(comando); //Comando para matar por PID Windows
					buffer.append(" "); //Comando para matar por PID Windows
					buffer.append(pid); //Comando para matar por PID Windows
				}catch(Exception e){
					e.printStackTrace(); //Caso não dê, mostra esse erro
				}
				
				try {
				Process rodaCmd = Runtime.getRuntime().exec(buffer.toString());
				InputStream fluxo = rodaCmd.getInputStream();
				InputStreamReader leitor = new InputStreamReader(fluxo);
				BufferedReader buffer1 = new BufferedReader(leitor);
				String linha = buffer1.readLine();
				
				while(linha != null) {
					System.out.println(linha); //Enquanto a linha for diferente de null, vai printando na tela os processos
					linha = buffer1.readLine();
				}
				buffer1.close();
				leitor.close();
				fluxo.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
				System.exit(0);
				
			}
			
			public void mataNome(String nome) {
				KillController opSystem = new KillController();
				String so = opSystem.os();
				
				
				String comando = " ";		
				if(so.contains("Windows")) {
					comando = "taskkill /im"; //Comando windows para matar processo por nome
				}else {
					comando = "pkill -f"; //Comando linux para matar processo por nome
				}
				StringBuffer buffer = new StringBuffer();
				
				try {
					buffer.append(comando); //Comando para matar processo por nome
					buffer.append(" "); //Comando para matar processo por nome
					buffer.append(nome); //Comando para matar processo por nome
				}catch(Exception e){
					e.printStackTrace();
				}
				
				try {
				Process rodaCmd = Runtime.getRuntime().exec(buffer.toString());
				InputStream fluxo = rodaCmd.getInputStream();
				InputStreamReader leitor = new InputStreamReader(fluxo);
				BufferedReader buffer1 = new BufferedReader(leitor);
				String linha = buffer1.readLine();
				
				while(linha != null) {
					System.out.println(linha);
					linha = buffer1.readLine();
				}
				buffer1.close();
				leitor.close();
				fluxo.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
				System.exit(0);		
				
	}
}
