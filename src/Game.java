
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
public class Game {
	
	private static Room currentRoom;
	private static ArrayList<Item> inventory = new ArrayList<Item>();
	private static HashMap<String,String> rMap = new HashMap<String,String>();
	
	public static Room getCurrentRoom() {
		return currentRoom;
	}
	
	public static ArrayList<Item> getInv() {
		return inventory;
	}

	public static void populateMap(String fileName) {
		try {
			Scanner scan = new Scanner(new File(fileName));
			while(scan.hasNextLine()) {
				String id = scan.nextLine();
				String desc = scan.nextLine();
				rMap.put(id, desc);
				scan.nextLine();
			}
		}catch(FileNotFoundException ex){
			System.out.println("File "+fileName+" not found.");
		}
	}
	
	public static void printMap() {
		for(String r: rMap.keySet()) {
			System.out.println(r+"\t"+rMap.get(r));
		}
	}
	
	public static void move(String d) {
		Room nextRoom =(currentRoom.getExit(d));
		if(nextRoom!= null) {
			if(nextRoom.isLocked()) {
				System.out.println("The room is locked!");
			} else {
				currentRoom = currentRoom.getExit(d);
				System.out.println(currentRoom);
			}
		}else {
			System.out.println("You can't go there.");
		}
	}
	
	public static void print(String message) {
		System.out.println(message+"\n");
	}
	
	public static void saveGame() {
		File saveFile = new File("save");
		try {
			saveFile.createNewFile();
			ObjectOutputStream stream = new ObjectOutputStream(new FileOutputStream(saveFile));
			stream.writeObject(currentRoom);
			stream.writeObject(inventory);
			stream.writeObject(World.rooms);
			stream.close();
		} catch (IOException e) {
			print("ERROR: CANNOT SAVE");
			e.printStackTrace();
		}
		
	}
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String playerCommand = "a";
		String itemName;
		populateMap("RoomDesc");
		//printMap();
		
		
		currentRoom = World.buildWorld();
		String a[];
		System.out.println(currentRoom);
		while(!playerCommand.equals("x")) {
			System.out.print("What do you want to do? ");
			playerCommand = scan.nextLine();
			a=playerCommand.split(" ");
			if(playerCommand.equals("i")) {
				if(inventory.isEmpty()) {
					System.out.println("You don't have anything");
				}else {
					for(Item i : inventory) {
						System.out.println(i);
					}
			}
			} else if (playerCommand.equals("e")) {
				move(playerCommand);
			} else if (playerCommand.equals("w")) {
				move(playerCommand);
			} else if (playerCommand.equals("n")) {
				move(playerCommand);
			} else if (playerCommand.equals("s")) {
				move(playerCommand);
			} else if (playerCommand.equals("u")) {
				move(playerCommand);
			} else if (playerCommand.equals("d")) {
				move(playerCommand);
			} else if (playerCommand.equals("x")) {
				System.out.println("Bye-Bye!");
			} else if(playerCommand.equals("save")) {
				saveGame();
			} else if (a[0].equals("take")) {
				itemName = a[1];
				if(currentRoom.hasItem(itemName)) {
					Item item = currentRoom.getItem(itemName);
					if(item.isHeavy()) {
						System.out.println("It's too heavy!");
					}
					else {
						inventory.add(currentRoom.removeItem(itemName));
						System.out.println("You pick up the "+itemName);
					}
				} else {
					System.out.println("There is no " + itemName+ "!");
				}
			} else if(a[0].equals("look")) {
				itemName = a[1];
				boolean found = false;
				for(Item i : inventory) {
					if(itemName.equals(i.getName())) {
						i.look();
						found = true;
					} 
				}

				if(!found) {
					if(currentRoom.hasItem(itemName)) {
						currentRoom.getItem(itemName).look();
					}else {
					System.out.println("You can't do that.");
				}
				}
				
			} else if(a[0].equals("use")) {
				itemName = a[1];
				boolean used = false;
				for(Item i : inventory) {
					if(itemName.equals(i.getName())) {
						i.use();
						used = true;
					}
				}	
				if(!used) {
					if(currentRoom.hasItem(itemName)) {
						currentRoom.getItem(itemName).use();
					}else
					System.out.println("You can't do that.");
				}
				
			}
			else {
				System.out.println("Invalid command.");
			}
		} 
		scan.close();
	}
	

	
}
