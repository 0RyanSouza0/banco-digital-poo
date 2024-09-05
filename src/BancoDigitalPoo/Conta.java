package BancoDigitalPoo;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Conta {
	protected static final int AGENCIA_PADRAO=1;
	private static int SEQUENCIAL= 1;
	protected int agencia;
	protected int numero;
	protected double saldo;

	private Cliente dadoCliente;
	
	
	
	
	
	
	@Override
	public String toString() {
		return "Conta [agencia=" + agencia + ", numero=" + numero + ", saldo=" + saldo + ", NomeCliente=" + dadoCliente.getNomeCliente()
				+ "]";
	}
	public Conta() {
		this.agencia=AGENCIA_PADRAO;
		this.numero=SEQUENCIAL++;
	
	}
	public Cliente getDadoCliente() {
		return dadoCliente;
	}



	public void setDadoCliente(Cliente dadoCliente) {
		this.dadoCliente = dadoCliente;
	}
	public int getAgencia() {
		return this.agencia;
	}
	
	
	
	public int getNumero() {
		return this.numero;
	}
	
	
	
	public double getSaldo() {
		return this.saldo;
	}
	

	
	
	public void sacar(double valor) {
		if(this.getSaldo()>0 && this.getSaldo()>=valor) {
		saldo-=valor;
		System.out.println("Valor sacado com sucesso");
		}else {
			System.out.println("Saldo insuficiente");
		}
	}
	

	public  void depositar(double valor) {
		saldo+=valor;
		System.out.println("Deposito realizado com Sucesso");
	}
	
	public void transferir(double valor, Conta contaDestino) {
		this.sacar(valor);
		contaDestino.depositar(valor);
		
		
		
	}
	
	
	
	public void adicionarCliente() {
		Scanner ler= new Scanner(System.in);
		String nome = null;
		double cpf=0;
		List<Double> salvaCpf=new ArrayList<>();
		Cliente cliente= new Cliente();
		System.out.println("Digite seu nome: ");
		nome=ler.next();
		cliente.setNomeCliente(nome);
		System.out.println("Digite seu cpf: ");
		cpf=ler.nextDouble();
		salvaCpf.add(cpf);
		cliente.setCpf(salvaCpf);
		setDadoCliente(cliente);
		
		
	}

	
}
