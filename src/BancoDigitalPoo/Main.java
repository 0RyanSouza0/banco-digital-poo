package BancoDigitalPoo;

import java.util.ArrayList;
import java.util.Scanner;

public class Main  {
	static Scanner ler =new Scanner(System.in);
	static ArrayList<Conta> listaContas;
	
	
	public static void main(String[] args) {
		listaContas= new ArrayList<Conta>();
		operacoes();
}
	
	public static void operacoes() {
		int escolha;
		System.out.println("------------------BANCO DIGITAL----------");
		System.out.println("1)Criar conta ");
		System.out.println("2)Listar");
		System.out.println("3)Sacar");
		System.out.println("4)Depositar");
		System.out.println("5)Transferir");
		System.out.println("6)Sair");
		escolha= ler.nextInt();
		switch(escolha) {
		case 1: 
			Conta conta= new Conta();
			conta.adicionarCliente();
			listaContas.add(conta);
			operacoes();
			break;
		case 2:
			for(Conta c: listaContas) {
				System.out.println(c);

			}
			operacoes();
			break;
		case 3:
			saque();
			operacoes();	
		case 4:
			depositar();
			operacoes();
			
		case 5: 
			transferir();
			operacoes();
		
		case 6:
			System.out.println("Programa encerrado");
			System.exit(0);
		}
	}
	
	public static Conta encontrarConta(int numeroConta)  {
		Conta conta=null;
		if(listaContas.size()>0) {
			for(Conta c:listaContas  ) {
				if(c.getNumero() == numeroConta) {
					conta=c;
				}
			}
		}
		return conta;
		
	}
	
	public static void saque() {
			int numeroConta=0;
			System.out.println("Digite o numero da conta para saque: ");
			numeroConta=ler.nextInt();
			Conta conta;
			conta = encontrarConta(numeroConta);
			if(conta != null) {
				System.out.println("Digite o valor do saque: ");
				double valor=ler.nextDouble();
				conta.sacar(valor);
				
			}
			else {
				System.out.println("Saque nao efetuado");
			}		
	}

	public static void depositar() {
			int numeroConta=0;
			System.out.println("Digite o numero da conta para deposito: ");
			numeroConta=ler.nextInt();
			Conta conta= encontrarConta(numeroConta);
			if(conta != null) {
				System.out.println("Digite o valor do deposito: ");
				double valor=ler.nextDouble();
				conta.depositar(valor);
				System.out.println("Valor depositado com sucesso");
			}
			else {
				System.out.println("Deposito não efetuado");
			}
	}
	

	public static void transferir( ) {
		int numeroConta=0;
		System.out.println("Digite o numero da conta do rementente: ");
		numeroConta=ler.nextInt();
		Conta contaRemetente = encontrarConta(numeroConta);
			if(contaRemetente != null) {
				System.out.println("Digite o numero da conta do destinatario: ");
				int contaDestinatario=ler.nextInt();
				Conta contaDestino=encontrarConta(contaDestinatario);
				if(contaDestino != null) {
					System.out.println("Digite o valor para transferir");
					double valor=ler.nextDouble();
					contaRemetente.transferir(valor, contaDestino);
				}
			}
			else {
				System.out.println("Deposito não efetuado");
			}
		
		

		
	}
}