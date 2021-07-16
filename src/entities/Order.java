package entities;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import entities.enums.OrderStatus;

public class Order {
	
	private Date moment;
	private OrderStatus status;
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	private List<OrderItem> itens = new ArrayList<OrderItem>();
	private Client client;
	
	
	
	public Date getDate() {
		return this.moment;
	}

	public void setDate(Date moment) {
		this.moment = moment;
	}
	
	public OrderStatus getStatus() {
		return status;
	}

	public void setStatus(OrderStatus status) {
		this.status = status;
	}

	public Order() {
		
	}
	
	public Order(Date moment, OrderStatus status, Client client) {
		this.moment = moment;
		this.status = status;
		this.client = client;
		
	}
	
	public void addOrderItem(OrderItem orderItem) {
		itens.add(orderItem);
	}
	
	public void removeProduct(OrderItem orderItem) {
		itens.remove(orderItem);
	}
	
	public Double total() {
		double sum = 0;
		for (OrderItem it : itens) {
		sum += it.subTotal();	
		}
		return sum;
		
		
		}
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("ORDER SUMMARY: \n");
		sb.append("Order moment: " + sdf.format(moment) +"\n");
		sb.append("Order satus:" + getStatus() + "\n");
		sb.append(client.getName()+" ("+ sdf.format(client.getBirthDate())+") - "+client.getEmail() + "\n");
		sb.append("Order items: \n");
		for(OrderItem x : itens) {
		sb.append(x + "\n");
		}
		
		sb.append("Total Price $" +  String.format("%.2f", total()));
		
		
		
		return sb.toString();
	}
	
	
	
}
