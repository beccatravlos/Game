import java.util.HashMap;

public class World {
	
	public static HashMap<String,Room> rooms =
			new HashMap<String,Room>();
	
	public static Room buildWorld() {
		Room cell = new Room("cell","JAIL_CELL_A");
		Room dungeonHall = new Room("dungeonHall","DUNGEON_HALL");
		Room basement = new Room("basement","BASEMENT_A");
		Room wineCellar = new Room("wineCellar","WINE_CELLAR_A");
		Room calRoom = new Room("calRoom","CAULDRON_ROOM_A");
		Room entrance = new Room("entrance","ENTRANCE_A");
		Room library = new Room("library", "LIBRARY_A");
		Room bunCell = new Room("bunCell", "BUNCELL");
		Room hallway = new Room("hallway", "HALLWAY_A");
		Room bedroom = new Room("bedroom", "BEDROOM_A");
		Room exit = new Room("exit", "EXIT");
		
		cell.addExit(dungeonHall, 'n');
		Item key =new Key();
		cell.addItem(key);
		//Item chain = new Chain();
		//cell.addItem(chain);
		//chain.setHeavy(true);
	
		dungeonHall.addExit(cell, 's');
		dungeonHall.addExit(basement, 'u');
		dungeonHall.addExit(bunCell, 'e');
		dungeonHall.setLocked(true);
		//Item chest = new Item("chest","It is a large, heavy chest.");
		//chest.setHeavy(true);
		
		bunCell.addExit(dungeonHall, 'w');
		
		
		basement.addExit(wineCellar, 'w');
		basement.addExit(dungeonHall, 'd');
		basement.addExit(calRoom, 'u');
		Item OldTome = new OldTome();
		basement.addItem(OldTome);
		
		wineCellar.addExit(basement, 'e');
		Item bottle = new Bottle();
		wineCellar.addItem(bottle);
//		wineCellar.addItem(new Item("bottle","A bottle full of mysterious magic wine. Wonder what it tastes like..."));
//		wineCellar.setLocked(true);
		//wineCellar.addItem(new Item("smallkey","A small key. Looks important."));
		
		calRoom.addExit(basement, 'd');
		calRoom.addExit(entrance, 'n');
		calRoom.addExit(library, 'e');
//		Item wand = new Wand();
//		calRoom.addItem(wand);
//		Item shower = new Shower();
//		calRoom.addItem(shower);
//		shower.setHeavy(true);
		
		library.addExit(calRoom, 'w');
		Item notebook = new Notebook();
		library.addItem(notebook);
		library.addExit(hallway, 'u');
		
		hallway.addExit(library, 'd');
		hallway.addExit(bedroom, 'n');
		Item painting = new Painting();
		hallway.addItem(painting);
		painting.setHeavy(true);
		Item drawing = new Drawing();
		hallway.addItem(drawing);
		drawing.setHeavy(true);
		Item window = new Window();
		hallway.addItem(window);
		window.setHeavy(true);
		
		bedroom.addExit(hallway, 's');
		Item largekey = new LargeKey();
		bedroom.addItem(largekey);
		Item jewelryBox = new JewelryBox();
		bedroom.addItem(jewelryBox);
		
		entrance.addExit(calRoom, 's');
		entrance.addExit(exit, 'n');
		Item candleabra = new Candleabra();
		entrance.addItem(candleabra);
		
		
		return cell;
	}
}
