package hampri;



import java.util.ArrayDeque;
import java.util.Scanner;



public class WarehouseLoadingSystem {

	private ArrayDeque<Item> ItemStack; // LIFO

	private ArrayDeque<Truck> TruckQueue;      // FIFO

	private Scanner sc;



	

	public WarehouseLoadingSystem() {

		ItemStack = new ArrayDeque<>();

		TruckQueue = new ArrayDeque<>();

		sc = new Scanner(System.in);

	}





	public void start() {

		int choice;

		do {

			System.out.println("\n=== Warehouse Loading System ===");

			System.out.println("[1] Store item (push)");

			System.out.println("[2] View warehouse stack");

			System.out.println("[3] Register arriving truck (enqueue)");

			System.out.println("[4] View waiting trucks");

			System.out.println("[5] Load next truck (pop + poll)");

			System.out.println("[0] Exit");

			System.out.print("Enter choice: ");

			choice = sc.nextInt();

			sc.nextLine(); 



			switch (choice) {

			case 1:
				storeItem();
				break;

			case 2: 
				viewItems();
				break;

			case 3:
				registerTruck();
				break;
			case 4:
				viewTrucks();
				break;
			case 5:
				loadNext();
				break;

			case 0:
				System.out.println("Exiting... Goodbye!");
				break;

			default: System.out.println("Invalid choice. Try again.");

			}

		} while (choice != 0);

	}



	

	private void storeItem() {

		System.out.print("Enter Item Code: ");

		String code = sc.nextLine();

		System.out.print("Enter Item Name: ");

		String name = sc.nextLine();

		System.out.print("Enter Quantity (qty): ");

		int qty = sc.nextInt();

		sc.nextLine();



		Item storage = new Item(code, name, qty);

		ItemStack.push(storage); // LIFO

		System.out.println("Stored: " + storage);

	}



	

	private void viewItems() {

		if (ItemStack.isEmpty()) {

			System.out.println("No Items in the Warehouse.");

		} else {

			System.out.println("\nTOP --->");

			for (Item item : ItemStack) {

				System.out.println(item);

			}

			System.out.println("<--- BOTTOM");

		}

	}



	

	private void registerTruck() {

		System.out.print("Enter Truck's plate: ");

		String plate = sc.nextLine();

		System.out.print("Enter Driver's name: ");

		String driver = sc.nextLine();



		Truck trak = new Truck(plate, driver);

		TruckQueue.add(trak); // FIFO

		System.out.println("Registered: " + trak);

	}



	
	private void viewTrucks() {

		if (TruckQueue.isEmpty()) {

			System.out.println("No Truck's waiting.");

		} else {

			System.out.println("\nFRONT --->");

			for (Truck truck : TruckQueue) {

				System.out.println(truck);

			}

			System.out.println("<--- REAR");

		}

	}



	

	private void loadNext() {

		if (ItemStack.isEmpty()) {

			System.out.println("No Items to load!");

		} else if (TruckQueue.isEmpty()) {

			System.out.println("No Trucks waiting!");

		} else {

			Item loadedItem = ItemStack.pop(); 

			Truck targetTruck = TruckQueue.poll(); // remove front

			System.out.println("Loaded: " + loadedItem + " ----->  " + targetTruck);

			System.out.println("Remaining Items: " + ItemStack.size());

			System.out.println("Remaining Trucks waiting: " + TruckQueue.size());

		}

	}

}


