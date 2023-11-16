
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;
public class Game {
	
	private static Room currentRoom;
	public static ArrayList<Item> inventory = new ArrayList<Item>();
	public static HashMap<String,String> rMap = new HashMap<String,String>();
	public static HashSet<String> flags = new HashSet<String>();
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
			print("File "+fileName+" not found.");
		}
	}
	
	public static void printMap() {
		for(String r: rMap.keySet()) {
			print(r+"\t"+rMap.get(r));
		}
	}
	
	public static void move(String d) {
		Room nextRoom =(currentRoom.getExit(d));
		if(nextRoom!= null) {
			if(nextRoom.isLocked()) {
				print("The room is locked!");
			} else {
				currentRoom = currentRoom.getExit(d);
				System.out.println(currentRoom);
			}
		}else {
			print("You can't go there.");
		}
	}
	
	public static void print(String message) {
		System.out.println(message);
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
	
	public static void loadGame() {
		try {
			ObjectInputStream stream = new ObjectInputStream(new FileInputStream(new File("save")));
			currentRoom = (Room)stream.readObject();
			inventory = (ArrayList<Item>)stream.readObject();
			World.rooms = (HashMap<String, Room>)stream.readObject();
			stream.close();
		} catch (IOException e) {
			print("ERROR: CANNOT LOAD");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		print("You are a thief who attempted to pickpocket an old man who turned  out to be an evil wizard. He knocked you unconsious and has locked you in his dungeon. Your mission is to escape the evil wizard's house. Best of luck.");
		Scanner scan = new Scanner(System.in);
		String playerCommand = "a";
		String itemName;
		populateMap("RoomDesc");
		//printMap();
		
		
		currentRoom = World.buildWorld();
		String a[];
		System.out.println(currentRoom);
		while(!playerCommand.equals("x")) {
			print("What do you want to do? ");
			playerCommand = scan.nextLine();
			a=playerCommand.split(" ");
			if(playerCommand.equals("i")) {
				if(inventory.isEmpty()) {
					print("You don't have anything");
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
				print("Bye-Bye!");
			} else if(playerCommand.equals("save")) {
				saveGame();
			} else if(playerCommand.equals("load")) {
				loadGame();
			}else if (a[0].equals("take")) {
				itemName = a[1];
				if(currentRoom.hasItem(itemName)) {
					Item item = currentRoom.getItem(itemName);
					item.take();
				} else {
					print("There is no " + itemName+ "!");
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
					print("You can't do that.");
				}
				}
				
			} else if(a[0].equals("use")) {
				itemName = a[1];
				Item useItem = null;
				boolean used = false;
				for(Item i : inventory) {
					if(itemName.equals(i.getName())) {
						useItem = i;
						used = true;
					}
				} if(useItem != null) {
					useItem.use();
				}
				if(!used) {
					if(currentRoom.hasItem(itemName)) {
						currentRoom.getItem(itemName).use();
					}else
					System.out.println("You can't do that.");
				}
				
//			}else if(a[0].equals("talk")) {
//				npc = currentRoom.getNPC(words[1]);
//				npc.talk();
			}else if(currentRoom.getName().equals("exit")) {
				System.exit(0);
				playerCommand = "x";
			}else {
				System.out.println("Invalid command.");
			}
		} 
		scan.close();
	}
	

	
}
