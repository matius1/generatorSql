
public class Order {

	private String customer_id;
	private String sum_prize;
	private java.sql.Date order_date;
	private java.sql.Date delivery_date;
	private int discount_id;
	private int delivery_id;
	private int payment_id;
	
	
	
	public String getCustomer_id() {
		return customer_id;
	}



	public void setCustomer_id(String customer_id) {
		this.customer_id = customer_id;
	}



	public String getSum_prize() {
		return sum_prize;
	}



	public void setSum_prize(String sum_prize) {
		this.sum_prize = sum_prize;
	}



	public java.sql.Date getOrder_date() {
		return order_date;
	}



	public void setOrder_date(java.sql.Date order_date) {
		this.order_date = order_date;
	}



	public java.sql.Date getDelivery_date() {
		return delivery_date;
	}



	public void setDelivery_date(java.sql.Date delivery_date) {
		this.delivery_date = delivery_date;
	}



	public int getDiscount_id() {
		return discount_id;
	}



	public void setDiscount_id(int discount_id) {
		this.discount_id = discount_id;
	}



	public int getDelivery_id() {
		return delivery_id;
	}



	public void setDelivery_id(int delivery_id) {
		this.delivery_id = delivery_id;
	}



	public int getPayment_id() {
		return payment_id;
	}



	public void setPayment_id(int payment_id) {
		this.payment_id = payment_id;
	}



	@Override
	public String toString() {
		return "Order [customer_id=" + customer_id + ", sum_prize=" + sum_prize + ", order_date=" + order_date
				+ ", delivery_date=" + delivery_date + ", discount_id=" + discount_id + ", delivery_id=" + delivery_id
				+ ", payment_id=" + payment_id + "]";
	}


	public String sqlQeury() {
//		(`order_id`, `customer_id`, `sum_prize`, `order_date`, `delivery_date`, `discount_id`, `delivery_id`, `payment_id`) 
		return "NULL, \"" + customer_id + "\", \"" + sum_prize + "\", \"" + order_date + "\", \"" +  delivery_date + "\", " + Integer.toString(discount_id) + ", " +  Integer.toString(delivery_id) + ", " + Integer.toString(payment_id) + "";
		
		
	}
	
	
	
	
	
}
