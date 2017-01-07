import java.sql.Date;

public class Product {

	private String title;
	private String prize;
	private String category;
	private java.sql.Date createDate;
	private java.sql.Date withdrawDate;
	private String description;
	private int rating;
	private int solded_all;
	private int on_stock;

	
	public String getPrize() {
		return prize;
	}
	public void setPrize(String prize) {
		this.prize = prize;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public java.sql.Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(java.sql.Date createDate) {
		this.createDate = createDate;
	}
	public java.sql.Date getWithdrawDate() {
		return withdrawDate;
	}
	public void setWithdrawDate(java.sql.Date withdrawDate) {
		this.withdrawDate = withdrawDate;
	}
	public int getRating() {
		return rating;
	}
	public void setRating(int rating) {
		this.rating = rating;
	}
	public int getSolded_all() {
		return solded_all;
	}
	public void setSolded_all(int solded_all) {
		this.solded_all = solded_all;
	}
	public int getOn_stock() {
		return on_stock;
	}
	public void setOn_stock(int on_stock) {
		this.on_stock = on_stock;
	}
	public Product(String title, String category, String description, Date createDate, Date withdrawDate,
			int rating, int solded_all, int on_stock) {
		super();
		this.title = title;
		this.category = category;
		this.description = description;
		this.createDate = createDate;
		this.withdrawDate = withdrawDate;
		this.rating = rating;
		this.solded_all = solded_all;
		this.on_stock = on_stock;
	}
	public Product() {
	}
	

	
	@Override
	public String toString() {
		return "Product [title=" + title + ", category=" + category + ", createDate=" + createDate + ", withdrawDate="
				+ withdrawDate + ", description=" + description + ", rating=" + rating + ", solded_all=" + solded_all
				+ ", on_stock=" + on_stock + "]";
	}
	public String sqlQeury() {
		return "NULL, \"" + title + "\", \"" + prize + "\", \"" + category + "\", \"" + createDate + "\", \"" + withdrawDate + "\", \"" + description + "\", \"" + rating + "\", \"" + solded_all + "\", \"" + on_stock + "\"";

	}
	
	public static int randBetween(int start, int end) {
		return start + (int) Math.round(Math.random() * (end - start));
	}
	
	
	
	
}
