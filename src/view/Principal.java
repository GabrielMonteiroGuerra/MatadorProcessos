package view;

import controller.KillController; //Importando a classe KillController
import java.util.Scanner; //Importando a biblioteca Scanner

public class Principal {

	public static void main(String[] args) {
		KillController kCont = new KillController();
		Scanner sc = new Scanner(System.in);
		
		//Perguntando se quer matar o processo por PID ou por nome
		System.out.println("Matar por PID (1) ou matar por nome (2)?");
		String processo = sc.next();
		int option = Integer.parseInt(processo);
		
		String abreProcesso = " ";
		kCont.listaProcessos(abreProcesso);
		
		//Se a opção for 1, vai matar por PID
		if(option == 1){
			System.out.println("Digite o número do PID: ");
			String chamaPid = sc.next();
			int pid = 0;
			pid = Integer.parseInt(chamaPid);
			kCont.mataPid(pid);
		}
		else { //Senão, mata por nome
			System.out.println("Digite o nome do processo: ");
			String nome = sc.next(); 
			kCont.mataNome(nome);
		}
		

		
	}

}
