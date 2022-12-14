import java.util.ArrayList;

// demo on workflow

public class ResourceCentre {
	
	private static final int OPTION_VIEW = 1;
	private static final int OPTION_ADD = 2;
	private static final int OPTION_LOAN = 3;
	private static final int OPTION_RETURN = 4;
	private static final int OPTION_QUIT = 5;
	private static final int ITEM_TYPE_CAMCORDER = 1;
	private static final int ITEM_TYPE_CHROMEBOOK = 2;
	
	
	// workflow demo to day 1 class
	public static void main(String[] args) {

		ArrayList<Camcorder> camcorderList = new ArrayList<Camcorder>();
		ArrayList<Chromebook> chromebookList = new ArrayList<Chromebook>();

		camcorderList.add(new Camcorder("CC001", "Sony HDR-CX405", 35));
		camcorderList.add(new Camcorder("CC002", "Panasonic HC-MDH2", 10));
		chromebookList.add(new Chromebook("CB001", "ASUS Chromebook ", "Win 10"));
		chromebookList.add(new Chromebook("CB002", "HP Chromebook", "Win 10"));


		int option = 0;

		while (option != OPTION_QUIT) {

			ResourceCentre.menu();
			option = Helper.readInt("Enter an option > ");			

			if (option == OPTION_VIEW) {
				// View all items
				ResourceCentre.viewAllCamcorder(camcorderList);
				ResourceCentre.viewAllChromebook(chromebookList);

			} else if (option == OPTION_ADD) {

				// Add a new item
				ResourceCentre.setHeader("ADD");
				ResourceCentre.itemTypeMenu();
				
				int itemType = Helper.readInt("Enter option to select item type > ");

				if (itemType == ITEM_TYPE_CAMCORDER) {

					// Add a camcorder
					Camcorder cc = inputCamcorder();
					ResourceCentre.addCamcorder(camcorderList, cc);

				} else if (itemType == ITEM_TYPE_CHROMEBOOK) {

					// Add Chromebook
					Chromebook cb = inputChromebook();
					ResourceCentre.addChromebook(chromebookList, cb);

				} else {
					System.out.println("Invalid type");
				}

			} else if (option == OPTION_LOAN) {

				// Loan item
				ResourceCentre.setHeader("LOAN");
				ResourceCentre.itemTypeMenu();

				int itemType = Helper.readInt("Enter option to select item type > ");

				if (itemType == ITEM_TYPE_CAMCORDER) {

					// Loan camcorder
					ResourceCentre.loanCamcorder(camcorderList);

				} else if (itemType == ITEM_TYPE_CHROMEBOOK) {

					// Loan Chromebook
					ResourceCentre.loanChromebook(chromebookList);

				} else {
					System.out.println("Invalid type");
				}

			} else if (option == OPTION_RETURN) {

				// Return item
				ResourceCentre.setHeader("RETURN");
				ResourceCentre.itemTypeMenu();

				int itemType = Helper.readInt("Enter option to select item type > ");

				if (itemType == ITEM_TYPE_CAMCORDER) {

					// Return a camcorder
					ResourceCentre.returnCamcorder(camcorderList);

				} else if (itemType == ITEM_TYPE_CHROMEBOOK) {

					// Return a chromebook
					ResourceCentre.returnChromebook(chromebookList);

				} else {
					System.out.println("Invalid type");
				}

			} else if (option == OPTION_QUIT) {
				System.out.println("Bye!");
			} else {
				System.out.println("Invalid option");
			}

		}

	}

	public static void menu() {
		ResourceCentre.setHeader("RESOURCE CENTRE APP");
		System.out.println("1. Display Resource Centre Inventory");
		System.out.println("2. Add item");
		System.out.println("3. Loan item");
		System.out.println("4. Return item");
		System.out.println("5. Quit");
		Helper.line(80, "-");

	}
	
	public static void setHeader(String header) {
		Helper.line(80, "-");
		System.out.println(header);
		Helper.line(80, "-");
	}

	public static void itemTypeMenu() {
		ResourceCentre.setHeader("ITEM TYPES");
		System.out.println("1. Camcorder");
		System.out.println("2. Chromebook");
	}
	
	//================================= Option 1 View items (Read) =================================
	public static String retrieveAllCamcorder(ArrayList<Camcorder> camcorderList) {
		String output = "";			
		/*
		 * for (int i = 0; i < camcorderList.size(); i++) { output +=
		 * String.format("%-84s\n", camcorderList.get(i).toString()); }
		 */
		//demo CI/CD
		for (Camcorder i: camcorderList) {
			output += i.toString();			
		}
		return output;
	}
	
	public static void viewAllCamcorder(ArrayList<Camcorder> camcorderList) {
		ResourceCentre.setHeader("CAMCORDER LIST");
		String output = String.format("%-10s %-30s %-10s %-10s %-20s\n", "ASSET TAG", 
				"DESCRIPTION", "AVAILABLE", "DUE DATE","OPTICAL ZOOM");
		output += retrieveAllCamcorder(camcorderList);	
		System.out.println(output);
	}

	public static String retrieveAllChromebook(ArrayList<Chromebook> chromebookList) {

		String output = "";		

		/*
		 * for (int i = 0; i < chromebookList.size(); i++) { output +=
		 * String.format("%-84s\n", chromebookList.get(i).toString()); }
		 */
		for (Chromebook i: chromebookList) {
			output += i.toString();
			
		}
		return output;
	}
	public static void viewAllChromebook(ArrayList<Chromebook> chromebookList) {
		
		ResourceCentre.setHeader("CHROMEBOOK LIST");
		String output = String.format("%-10s %-30s %-10s %-10s %-20s\n", "ASSET TAG", "DESCRIPTION",
				 "AVAILABLE", "DUE DATE","OPERATING SYSTEM");
		 output += retrieveAllChromebook(chromebookList);
		System.out.println(output);
	}

	//================================= Option 2 Add an item (Create)=================================
	public static Camcorder inputCamcorder() {
		String tag = Helper.readString("Enter asset tag > ");
		String description = Helper.readString("Enter description > ");
		int zoom = Helper.readInt("Enter optical zoom > ");

		Camcorder cc= new Camcorder(tag, description, zoom);
		return cc;
		
	}

	public static Chromebook inputChromebook() {
		String tag = Helper.readString("Enter asset tag > ");
		String description = Helper.readString("Enter description > ");
		String os = Helper.readString("Enter operating system > ");

		Chromebook cb= new Chromebook(tag, description, os);
		return cb;
		
	}	
	public static void addCamcorder(ArrayList<Camcorder> camcorderList, Camcorder cc) {
		
		camcorderList.add(cc);
		System.out.println("Camcorder added");
	}

	public static void addChromebook(ArrayList<Chromebook> chromebookList, Chromebook cb) {

		chromebookList.add(cb);
		System.out.println("Chromebook added");
	}
	
	//================================= Option 3 Loan an item (Update) =================================
	public static boolean doLoanCamcorder(ArrayList<Camcorder> camcorderList, String tag, String dueDate) {
		
		boolean isLoaned = false;

		for (int i = 0; i < camcorderList.size(); i++) {
			
			String assetTag = camcorderList.get(i).getAssetTag();
			
			if (tag.equalsIgnoreCase(assetTag)
					
					&& camcorderList.get(i).getIsAvailable() == true) {
				
				camcorderList.get(i).setIsAvailable(false);
				camcorderList.get(i).setDueDate(dueDate);
				
				isLoaned = true;
				
			}
		}
		return isLoaned;
	}

	public static void loanCamcorder(ArrayList<Camcorder> camcorderList) {
		ResourceCentre.viewAllCamcorder(camcorderList);
		String tag = Helper.readString("Enter asset tag > ");
		String due = Helper.readString("Enter due date > ");
		Boolean isLoaned =doLoanCamcorder(camcorderList, tag, due);
		if (isLoaned == false) {
			System.out.println("Invalid asset tag");
		} else {
			System.out.println("Camcorder " + tag + " loaned out");
		}
	}
	

	public static boolean doLoanChromebook(ArrayList<Chromebook> chromebookList, String tag, String dueDate) {
		// write your code here
		boolean isLoaned = false;

		for (int i = 0; i < chromebookList.size(); i++) {
			if (tag.equalsIgnoreCase(chromebookList.get(i).getAssetTag())
					&& chromebookList.get(i).getIsAvailable() == true) {
				
				chromebookList.get(i).setIsAvailable(false);
				chromebookList.get(i).setDueDate(dueDate);
				
				isLoaned = true;
				
			}
		}
		return isLoaned;
	}

	public static void loanChromebook(ArrayList<Chromebook> chromebookList) {
		// write your code here
		ResourceCentre.viewAllChromebook(chromebookList);
		String tag = Helper.readString("Enter asset tag > ");
		String due = Helper.readString("Enter due date > ");
		Boolean isLoaned =doLoanChromebook(chromebookList, tag, due);
		if (isLoaned == false) {
			System.out.println("Invalid asset tag");
		} else {
			System.out.println("Chromebook " + tag + " loaned out");
		}	
		
	}
	//================================= Option 4 Return an item (Update)=================================
	public static boolean doReturnCamcorder(ArrayList<Camcorder> camcorderList,String tag) {
		boolean isReturned = false;

		for (int i = 0; i < camcorderList.size(); i++) {
			if (tag.equalsIgnoreCase(camcorderList.get(i).getAssetTag())
					&& camcorderList.get(i).getIsAvailable() == false) {
				camcorderList.get(i).setIsAvailable(true);
				camcorderList.get(i).setDueDate("");
				isReturned = true;
				
			}
		}
		return isReturned;
		
	}

	public static void returnCamcorder(ArrayList<Camcorder> camcorderList) {
		ResourceCentre.viewAllCamcorder(camcorderList);
		String tag = Helper.readString("Enter asset tag > ");
		Boolean isReturned = doReturnCamcorder(camcorderList, tag);
		
		if (isReturned == false) {
			System.out.println("Invalid asset tag");
		} else {
			System.out.println("Camcorder " + tag + " returned");
		}
	}
	// write your doReturnChromebook code here
	public static boolean doReturnChromebook(ArrayList<Chromebook> chromebookList,String tag) {
		boolean isReturned = false;

		for (int i = 0; i < chromebookList.size(); i++) {
			if (tag.equalsIgnoreCase(chromebookList.get(i).getAssetTag())
					&& chromebookList.get(i).getIsAvailable() == false) {
				chromebookList.get(i).setIsAvailable(true);
				chromebookList.get(i).setDueDate("");
				isReturned = true;
				
			}
		}
		return isReturned;
		
	}
	public static void returnChromebook(ArrayList<Chromebook> chromebookList) {
		// write your code here
		ResourceCentre.viewAllChromebook(chromebookList);
		String tag = Helper.readString("Enter asset tag > ");
		Boolean isReturned = doReturnChromebook(chromebookList, tag);
		
		if (isReturned == false) {
			System.out.println("Invalid asset tag");
		} else {
			System.out.println("Chromebook " + tag + " returned");
		}
	}


}
