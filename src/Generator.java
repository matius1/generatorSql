import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Generator {

	static List<String> imieList;
	static List<String> nazwiskoList;
	static List<Customer> customerList;
	static int CUSTOMER_NUMBER = 1000;

	static List<String> miescowosciList;
	static List<String> uliceList;
	static List<Address> addressList;

	static List<String> produktyListy;
	static List<Product> productList;
	static int PRODUCT_NUMBER = 1000;
	
	static List<Order> orderList;
	static List<OrderDetail> orderDetailList;
	static int ORDER_NUBMER = 50000;

	public static void main(String[] args) throws FileNotFoundException {

		imieList = loadFile("imiona.txt");
		nazwiskoList = loadFile("nazwiska.txt");
		customerList = new ArrayList<>();
		addressList = new ArrayList<>();
		miescowosciList = loadFile("miescowosci.txt");
		uliceList = loadFile("ulice.txt");

		customerList = generateCustomer(CUSTOMER_NUMBER);
		generateSQLCustomer(customerList);
		addressList = generateAddress(CUSTOMER_NUMBER);
		generateSQLAddress(addressList);

		productList = generateProduct(PRODUCT_NUMBER);
		generateSQLProduct(productList);

		orderList = generateOrder(ORDER_NUBMER);
		orderDetailList = generateOrderDetail(ORDER_NUBMER);
		generateSQLOrder(orderList, orderDetailList);
		
		
		mergeFiles();

	}

	public static void mergeFiles() {
		String output = "";
		try (	Scanner sc1 = new Scanner((new File("customers.txt")));
				Scanner sc2 = new Scanner((new File("address.txt")));
				Scanner sc3 = new Scanner((new File("products.txt")));
				Scanner sc4 = new Scanner((new File("orders.txt")));
						) {

			while (sc1.hasNext()) {
				output += sc1.next() + " ";

			}
			output += "\n";
			
			while (sc2.hasNext()) {
				output += sc2.next() + " ";
			}output += "\n";
			
			while (sc3.hasNext()) {
				output += sc3.next() + " ";
			}
			while (sc4.hasNext()) {
				output += sc4.next() + " ";
			}


		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try (PrintWriter pw = new PrintWriter(new File("output.sql"))) {
			pw.write(output);
			System.out.println("Saved to output.sql");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void generateSQLCustomer(List<Customer> list) {
		String filename = "customers.txt";

//		String query = " TRUNCATE TABLE `address`; TRUNCATE TABLE `product`; TRUNCATE TABLE `customer`; "; 
		String query = "INSERT INTO `customer` (`customer_id`, `name`, `surname`, `birth_date`, `create_date`, `sex`) VALUES ";

		for (Customer element : list) {
			query += "(" + element.sqlQeury() + "), ";
		}
		query = query.substring(0, query.length() - 2) + ";";
		// System.out.println(query);

		try (PrintWriter out = new PrintWriter(new FileOutputStream(new File(filename)));) {
			out.println(query);
			System.out.println("Saved to " + filename);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void generateSQLProduct(List<Product> list) {
		String filename = "products.txt";

		String query = "INSERT INTO `product` (`product_id`, `title`, `prize`, `category`, `creation_date`, `withdraw_date`, `description`, `rating`, `solded_all`, `on_stock`) VALUES ";

		for (Product element : list) {
			query += "(" + element.sqlQeury() + "), ";
		}
		query = query.substring(0, query.length() - 2) + ";";
		// System.out.println(query);

		try (PrintWriter out = new PrintWriter(new FileOutputStream(new File(filename)));) {
			out.println(query);
			System.out.println("Saved to " + filename);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	public static void generateSQLOrder(List<Order> list1, List<OrderDetail> list2) {
		String filename = "orders.txt";

		String query1 = "INSERT INTO `order` (`order_id`, `customer_id`, `sum_prize`, `order_date`, `delivery_date`, `discount_id`, `delivery_id`, `payment_id`) VALUES ";
		String query2 = " INSERT INTO `order_details` (`order_details_id`, `order_id`, `product_id`, `quantity`) VALUES ";

		for (Order element : list1) {
			query1 += "(" + element.sqlQeury() + "), ";
		}
		
		for (OrderDetail element : list2) {
			query2 += "(" + element.sqlQeury() + "), ";
		}
		
		query2 = query2.substring(0, query2.length() - 2) + ";";
		query1 = query1.substring(0, query1.length() - 2) + ";";

		try (PrintWriter out = new PrintWriter(new FileOutputStream(new File(filename)));) {
			out.println(query1 + query2);
			System.out.println("Saved to " + filename);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void generateSQLAddress(List<Address> list) {

		String filename = "address.txt";

		String query = "INSERT INTO `address` (`customer_id`, `city`, `postcode`, `street`, `number`) VALUES ";

		for (Address element : list) {
			query += "(" + element.sqlQeury() + "), ";
		}
		query = query.substring(0, query.length() - 2) + ";";
		// System.out.println(query);

		try (PrintWriter out = new PrintWriter(new FileOutputStream(new File(filename)));) {
			out.println(query);
			System.out.println("Saved to " + filename);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static List<String> loadFile(String filename) {

		List<String> list = new ArrayList<>();

		try (Stream<String> stream = Files.lines(Paths.get(filename))) {

			list = stream.map(String::toUpperCase).collect(Collectors.toList());
		} catch (IOException e) {
			e.printStackTrace();
		}

		System.out.println("Wczytano " + filename + ", rekordy: " + list.size());
		return list;
	}

	public static List<Customer> generateCustomer(int count) {

		List<Customer> list = new ArrayList<>();

		Random randomGenerator;
		randomGenerator = new Random();

		for (int i = 0; i < count; i++) {
			int indexImie = randomGenerator.nextInt(imieList.size());
			int indexNazwisko = randomGenerator.nextInt(nazwiskoList.size());

			Customer custTemp = new Customer();

			custTemp.setName(imieList.get(indexImie));
			custTemp.setSurname(nazwiskoList.get(indexNazwisko));
			custTemp.setBirthDate(generateDate(1940, 2000));
			custTemp.setCreateDate(generateDate(2000, 2016));
			custTemp.setSex();

			// System.out.println(custTemp);
			// System.out.println(custTemp.sqlQeury());
			list.add(custTemp);

		}

		return list;

	}

	public static List<Address> generateAddress(int count) {

		List<Address> list = new ArrayList<>();

		Random randomGenerator;
		randomGenerator = new Random();

		for (int i = 0; i < count; i++) {
			int indexM = randomGenerator.nextInt(miescowosciList.size());
			int indexU = randomGenerator.nextInt(uliceList.size());

			Address temp = new Address();

			temp.setCustID(i + 1);
			temp.setCity(miescowosciList.get(indexM));
			temp.setStreet(uliceList.get(indexU));
			temp.setPostcode();
			temp.setNumber(Integer.toString(randBetween(1, 55)));

			// System.out.println(temp);
			// System.out.println(custTemp.sqlQeury());
			list.add(temp);

		}

		return list;

	}

	public static List<Order> generateOrder(int count) {

		List<Order> list = new ArrayList<>();
		
		for (int i = 0; i < count; i++) {
			Order temp = new Order();
			OrderDetail tempD = new OrderDetail();
			
			temp.setCustomer_id(Integer.toString(randBetween(1, CUSTOMER_NUMBER)));
			temp.setSum_prize(Integer.toString(randBetween(0, 9999)));
			temp.setOrder_date(generateDate(2000, 2016));
//			temp.setDelivery_date(generateDeliveryDate(temp.getDelivery_date()));
			temp.setDelivery_id(randBetween(1, 3));
			temp.setDiscount_id(randBetween(1, 2));
			temp.setPayment_id(randBetween(1, 3));

			
//			System.out.println(temp);
			// System.out.println(custTemp.sqlQeury());
			list.add(temp);

		}

		return list;

	}
	
	public static List<OrderDetail> generateOrderDetail(int count) {

		List<OrderDetail> list = new ArrayList<>();


		for (int i = 0; i < count; i++) {
			Order temp = new Order();
			OrderDetail tempD = new OrderDetail();
			
			tempD.setOrder_id(i);
			tempD.setProduct_id(randBetween(1, PRODUCT_NUMBER));
			tempD.setQuantity(randBetween(1, 10));
			
			list.add(tempD);

		}

		return list;

	}

	public static List<Product> generateProduct(int count) {

		List<Product> list = new ArrayList<>();

		Random randomGenerator;
		randomGenerator = new Random();

		for (int i = 0; i < count; i++) {
			int indexM = randomGenerator.nextInt(miescowosciList.size());
			int indexU = randomGenerator.nextInt(uliceList.size());

			Product temp = new Product();

			temp.setTitle("TITLE" + i);
			temp.setPrize(Integer.toString(randBetween(0, 9999)));
			temp.setCategory(Integer.toString(randBetween(0, 30)));
			temp.setCreateDate(generateDate(2000, 2016));
			temp.setWithdrawDate(generateWithdrawDate(temp.getCreateDate()));
			temp.setDescription("description");
			temp.setRating(randBetween(1, 99));
			temp.setSolded_all(randBetween(2, 9999));
			temp.setOn_stock(randBetween(2, 999));

//			System.out.println(temp);
			// System.out.println(custTemp.sqlQeury());
			list.add(temp);

		}

		return list;

	}
	
	public static java.sql.Date generateWithdrawDate(java.sql.Date createDate) {

		if (randBetween(0, 10) % 2 == 0) {
			return null;
		} else {
			java.sql.Date tempDate = generateDate(2000, 2016);

			while (tempDate.before(createDate)) {
				tempDate = generateDate(2000, 2016);

			}

			return tempDate;
		}

	}
	
	public static java.sql.Date generateDeliveryDate(java.sql.Date createDate) {

	
			java.sql.Date tempDate = generateDate(2000, 2016);
			tempDate = generateDate(2000, 2016);
			while (tempDate.before(createDate)) {
				tempDate = generateDate(2000, 2016);
				}
			return tempDate;

		

	}

	public static java.sql.Date generateDate(int start, int end) {
		GregorianCalendar gc = new GregorianCalendar();
		int year = randBetween(start, end);
		gc.set(gc.YEAR, year);
		int dayOfYear = randBetween(1, gc.getActualMaximum(gc.DAY_OF_YEAR));
		gc.set(gc.DAY_OF_YEAR, dayOfYear);

		java.sql.Date sqlDate = new java.sql.Date(gc.getTimeInMillis());

		// System.out.println("sqlDate:" + sqlDate);

		return sqlDate;

	}

	public static int randBetween(int start, int end) {
		return start + (int) Math.round(Math.random() * (end - start));
	}

}
