
public class OrderDetail {
	
	private int order_id;
	private int product_id;
	private int quantity;
	
	public int getOrder_id() {
		return order_id;
	}
	public void setOrder_id(int order_id) {
		this.order_id = order_id;
	}
	public int getProduct_id() {
		return product_id;
	}
	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	@Override
	public String toString() {
		return "OrderDetail [order_id=" + order_id + ", product_id=" + product_id + ", quantity=" + quantity + "]";
	}
	
	public String sqlQeury() {
//		return "NULL, \"" + title + "\", \"" + prize + "\", \"" + category + "\", \"" + createDate + "\", \"" + withdrawDate + "\", \"" + description + "\", \"" + rating + "\", \"" + solded_all + "\", \"" + on_stock + "\"";
//		INSERT INTO `order_details` (`order_details_id`, `order_id`, `product_id`, `quantity`) 
		return "NULL, \""+ order_id + "\", \"" + product_id + "\", \""+ quantity + "\"";
		
		
	}
	
	
	

}
