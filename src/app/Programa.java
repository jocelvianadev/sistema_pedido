/*Ler os dados de um pedido com N itens (N fornecido pelo usuário).
 Depois, mostrar um sumário do pedido. Nota: o instante do pedido
 deve ser o instante do sistema: new Date()*/

package app;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entities.Cliente;
import entities.ItemPedido;
import entities.Pedido;
import entities.Produto;
import entities.enums.PedidoStatus;

public class Programa {

	public static void main(String[] args) throws ParseException {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		Locale.setDefault(Locale.US);
		Scanner scan = new Scanner(System.in);
		
		//Dados do cliente
		System.out.println("Dados do cliente:");
		System.out.print("Nome: ");
		String nome = scan.nextLine();
		System.out.print("Email: ");
		String email = scan.nextLine();
		System.out.print("Data de nascimento dd/mm/aaaa: ");
		Date dataNascimento = sdf.parse(scan.next());
		
		Cliente cliente = new Cliente(nome, email, dataNascimento); 
		
		//Dados do pedido
		System.out.println("\nDados do pedido:");
		System.out.print("Informe o status do pedido (PAGAMENTO_PENDENTE, PROCESSANDO, ENVIADO, ENTREGUE): ");
		PedidoStatus status = PedidoStatus.valueOf(scan.next());
		
		Pedido pedido = new Pedido(new Date(), status, cliente);
		
		System.out.print("Informe a quantidade de itens: ");
		int numItens = scan.nextInt();
		for(int i = 0; i < numItens; i++) {
			System.out.println("Dados do " + (i + 1) + "º item: ");
			System.out.print("Nome: ");
			scan.nextLine();
			String nomeProduto = scan.nextLine();
			System.out.print("Preço: ");
			double precoProduto = scan.nextDouble();
			System.out.print("Quantidade: ");
			int quantidade = scan.nextInt();
			
			Produto produto = new Produto(nomeProduto, precoProduto);
			
			ItemPedido itemPedido = new ItemPedido(quantidade, precoProduto, produto);
			
			pedido.adicionarItem(itemPedido);
		}
		
		System.out.println();
		System.out.println(pedido);
		
		scan.close();		
	}

}
