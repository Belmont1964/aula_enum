package principal;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

import entidade.Client;
import entidade.Order;
import entidade.OrderItem;
import entidade.Product;
import enumaracao.OrderStatus;

public class App {

	public static void main(String[] args) throws ParseException {
		
		Scanner sc = new Scanner (System.in);
		String nome, email, birth;
						
		
		System.out.print ("Entre o nome do client: ");
		nome = sc.nextLine();
		
		System.out.print ("Entre o email do client: ");
		email = sc.nextLine();
		
		System.out.print ("Entre a data de nascimento do client (DD/MM/yyyy): ");
		birth = sc.nextLine();
		
		SimpleDateFormat sdf1 = new SimpleDateFormat("dd/MM/yyyy");
		Date birthDate = sdf1.parse(birth);
		
		Client cliente = new Client(nome, email, birthDate);
		
		
		System.out.print ("Quantos produtos para este pedido: ");
		int numPedidos = sc.nextInt();
		sc.nextLine();
		
		Date date = new Date();
		Order order = new Order (date, OrderStatus.PROCESSING, cliente);
		
		for (int i = 0; i < numPedidos; i++) {
			System.out.print ("Entre o nome do produto: ");
			nome = sc.nextLine();
			
			System.out.print ("Entre o preço do produto: ");
			Double price = sc.nextDouble();
			sc.nextLine();
			
			System.out.print ("Entre a quantidade do produto: ");
			int quantity = sc.nextInt();
			sc.nextLine();
			
			Product product = new Product (nome, price);
			OrderItem item = new OrderItem(quantity, product);	
			order.addItem(item);			
		}
		
		
		System.out.println ();
		System.out.println ("ORDER SUMARY: ");
		System.out.print(order);
		System.out.println(cliente);
		System.out.println ("Order itens: ");
		for (OrderItem var : order.getItens()) {
			System.out.print(var.getProduct().getName()+", $");
			System.out.printf("%.2f", var.getProduct().getPrice());
			System.out.print (", Quantity: ");
			System.out.print(var.getQuantity() + ", ");
			System.out.print (", Subtotal: ");
			System.out.printf("%.2f", var.subTototal(var.getQuantity(), var.getProduct()));
			System.out.println ();
			
		}
		System.out.printf("Total price: " + "%.2f", order.total());
		
		
	}

}
