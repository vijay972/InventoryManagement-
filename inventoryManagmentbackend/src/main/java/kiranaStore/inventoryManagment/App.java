package kiranaStore.inventoryManagment;
import java.util.*;
public class App {
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
		Test test = new Test();
		Integer option = 1;
		do {
			System.out.println("PRESS 1.CUSTOMER \t\t 2.PRODUCT \t\t 3.EMPLOYEE \t\t 4.ORDER\n");
			option = sc.nextInt();
			switch (option) {
			case 1: {
				System.out.println("Press 1. ADD CUSTOMER \t\t 2.DISPLAY CUSTOMER LIST \t\t3.DISPLAY CUSTOMER BY ID\n");
				int custoption = sc.nextInt();
				if (custoption == 1) {
					test.addCustomer();
				} else if (custoption == 2) {
					test.displayCustomers();
				} else if (custoption == 3) {
					test.displayOneCustomer();
				} else {
					System.out.println("OOPS INVALID input....PLEASE TRY AGAIN ^.^");
				}
				break;
			}
			case 2: {
				System.out.println("Press 1. ADD PRODUCT \t\t 2.DISPLAY PRODUCT LIST \t\t3.DISPLAY PRODUCT BY ID\n");
				int prodoption = sc.nextInt();
				if (prodoption == 1) {
					test.addProduct();
				} else if (prodoption == 2) {
					test.displayProducts();
				} else if (prodoption == 3) {
					test.displayOneProduct();
				} else {
					System.out.println("OOPS INVALID input....PLEASE TRY AGAIN ^.^");
				}

				break;
			}
			case 3: {
				System.out.println("Press 1. ADD EMPLOYEE \t\t 2.DISPLAY EMPLOYEE LIST \t\t3.DISPLAY EMPLOYEE BY ID\n");
				int empoption = sc.nextInt();
				if (empoption == 1) {
					test.addEmployee();

				} else if (empoption == 2) {
					test.displayEmployees();
				} else if (empoption == 3) {
					test.displayOneEmployee();
				} else {
					System.out.println("OOPS INVALID input....PLEASE TRY AGAIN ^.^");
				}

				break;
			}
			case 4: {
				System.out.println("Press 1. ADD ORDER \t\t 2.DISPLAY ORDER LIST \t\t3.DISPLAY ORDER BY ID\n");
				int ordoption = sc.nextInt();
				if (ordoption == 1) {
					test.addOrder();

				} else if (ordoption == 2) {
					test.displayOrders();
				} else if (ordoption == 3) {
					test.displayOneOrder();
				} else {
					System.out.println("OOPS INVALID input....PLEASE TRY AGAIN ^.^");
				}
				break;
			}
			default:
				break;
			}

		} while (option < 5);

	}

    }
