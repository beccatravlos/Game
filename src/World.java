import java.util.HashMap;

public class World {
	
	public static HashMap<String,Room> rooms =
			new HashMap<String,Room>();
	
	public static Room buildWorld() {
		Room cell = new Room("cell","You are in a cell.");
		Room dungeonHall = new Room("dungeonHall","You are in the dungeon hall.");
		Room basement = new Room("basement","You are in a basement.");
		Room wineCellar = new Room("wineCellar","You are in a wine cellar.");
		Room calRoom = new Room("calRoom","You are in a room with a cauldron.");
		Room entrance = new Room("entrance","You are at the entrance.");
		
		cell.addExit(dungeonHall, 'n');
		Item key =new Key();
		cell.addItem(key);
		Item chain = new Chain();
		cell.addItem(chain);
		chain.setHeavy(true);
	
		dungeonHall.addExit(cell, 's');
		dungeonHall.addExit(basement, 'u');
		dungeonHall.setLocked(true);
		Item chest = new Item("chest","It is a large, heavy chest.");
		chest.setHeavy(true);
		
		basement.addExit(wineCellar, 'w');
		basement.addExit(dungeonHall, 'd');
		basement.addExit(calRoom, 'u');
		Item OldTome = new OldTome();
		basement.addItem(OldTome);
		
		wineCellar.addExit(basement, 'e');
		wineCellar.addItem(new Item("bottle","A bottle full of mysterious magic wine. Wonder what it tastes like..."));
		wineCellar.setLocked(true);
		wineCellar.addItem(new Item("smallkey","A small key. Looks important."));
		
		calRoom.addExit(basement, 'd');
		calRoom.addExit(entrance, 'n');
		Item wand = new Wand();
		calRoom.addItem(wand);
//		Item shower = new Shower();
//		calRoom.addItem(shower);
//		shower.setHeavy(true);
		
		entrance.addExit(calRoom, 's');
		Item candleabra = new Candleabra();
		entrance.addItem(candleabra);
		return cell;
	}
}
