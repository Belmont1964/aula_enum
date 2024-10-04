package entidade;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import enumaracao.OrderStatus;

public class Order {
	private Date moment;
	private OrderStatus status;
	private Client client;
	
		
	ArrayList <OrderItem> itens = new ArrayList <OrderItem>();
	
	public Order() {
		
	}
	
	public Order(Date moment, OrderStatus status, Client client) {
		this.moment = moment;
		this.status = status;
		this.client = client;
	}

	public Date getMoment() {
		return moment;
	}

	public void setMoment(Date moment) {
		this.moment = moment;
	}

	public OrderStatus getStatus() {
		return status;
	}

	public void setStatus(OrderStatus status) {
		this.status = status;
	}
	
	
	public void addItem (OrderItem item) {
		itens.add(item);
	}
	
	public void removeItem (OrderItem item) {
		itens.remove(item);
	}
	
	public Double total () {
		Double tot = 0.0;
		for (OrderItem x : itens) {
			tot = tot + x.subTototal(x.getQuantity(), x.getProduct());
		}
		return tot;
	}

	@Override
	public String toString() {
		SimpleDateFormat sdf1 = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		return "Order moment: " + sdf1.format(moment) + "\n" + "Order Status: " + status + "\n";
	}

	public ArrayList<OrderItem> getItens() {
		return itens;
	}	
}