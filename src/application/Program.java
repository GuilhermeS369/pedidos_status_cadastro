package application;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import entities.Client;
import entities.Order;
import entities.OrderItem;
import entities.Product;
import entities.enums.OrderStatus;


public class Program {

	public static void main(String[] args) throws ParseException {
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");//FORMATAÇÃO DE DATA
		
		
		System.out.println("Enter Client data: ");
		System.out.print("Name: ");
		String name = sc.nextLine();
		System.out.print("Email: ");
		String email = sc.nextLine();
		System.out.print("Birth date (DD/MM/YYYY): ");
		Date birthDate = sdf.parse(sc.next()); //ANIVERSARIO DO TIPO DATA, FORMATADO COM SDF, ESPERANDO A DATA NO SC.NEXT
		System.out.println();
		//-------------------------------------------------
		
		
		
		System.out.println("Enter order data: ");
		System.out.print("Status: ");
		OrderStatus status = OrderStatus.valueOf(sc.next()); // INPUT DO ORDER STATUS EM STRING
		Order order = new Order(new Date() ,status, new Client(name, email, birthDate)); //EXEMPLO DE COMPOSIÇÃO OBVIA
		//NOVO PEDIDO COM DATA ATUAL, STATUS DECLARADO EM CIMA, E O BENDITO CONSTRUTOR COMPOSTO
		System.out.println();
		
		
		System.out.println("How many items to this order?"); // QUANTOS ITENS VAI TER O PEDIDO
		int n = sc.nextInt();
		
		for(int i = 0 ; i<n ; i++) { //PEROCORRER ALISTA
			System.out.println();
			System.out.println("Enter #"+ (i+1) + " item data:");
			System.out.println("Product name: ");
			String productName = sc.next();
			System.out.print("Price: ");
			Double price = sc.nextDouble();
			System.out.print("Quantity: ");
			Integer quantity = sc.nextInt();
			
		Product product = new Product(productName, price);	//DIZER O NOME DO PRODUTO E O PREÇO
		OrderItem orderItem = new OrderItem(quantity, price, product); // DIZER QUANTIDADE, PREÇO E QUAL PRODUTO
			order.addOrderItem(orderItem); //ADICIONAR O MESMO NA LISTA
			
		}
		
		System.out.println();
		System.out.println(order);//PRINTAR O TO STRING DO ORDER
		
		sc.close();
		
		
		
		
	}

}
