import java.io.Serializable;
import java.util.HashMap;

public class Room implements Serializable{
	//private String des;
	private Room east;
	private Room west;
	private Room north;
	private Room south;
	private Room up;
	private Room down;
	private boolean locked;
	private String name;
	private String id;
	
	private HashMap<String, Item> roomItems;
//	private HashMap<String, NPC> roomNPCs;
	
	public Room(String n,String r) {
		//des=r;
		name = n;
		id = r;
		locked=false;
		roomItems = new HashMap<String, Item>();
		World.rooms.put(name, this);
	}
	
//	public void addNPC(String npc) {
//		roomNPCs.put(npc.getName(), npc);
//	}
	
//	public NPC getNPC(String name) {
//		return roomNPCs.get(name);
//	}
	
	public String getName() {
		return name;
	}
	public Item getItem(String item) {
		return roomItems.get(item);
	}
	public boolean isLocked() {
		return locked;
	}

	public void setLocked(boolean locked) {
		this.locked = locked;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Item removeItem(String name) {
		return roomItems.remove(name);
	}
	
	public void addItem(Item i) {
		roomItems.put(i.getName(), i);
	}
	
	public boolean hasItem(String name) {
		return roomItems.containsKey(name);
	}
	
	public String getDes() {
		return Game.rMap.get(id);
	}
	
	public String getId() {
		return id;
	}

	public Room getExit(String d) {
		if (d.equals("e")) {
			return east;
		}if (d.equals("w")) {
			return west;
		}if (d.equals("n")) {
			return north;
		}if (d.equals("s")) {
			return south;
		}if (d.equals("u")) {
			return up;
		}if (d.equals("d")) {
			return down;
		}else {
			return null;
		}
	}
	
	public void addExit(Room r, char d) {
		if (d=='e') {
			east=r;
		}if (d=='w') {
			west=r;
		}if (d=='n') {
			north=r;
		}if (d=='s') {
			south=r;
		}if (d=='u') {
			up=r;
		}if (d=='d') {
			down=r;
		}
	}
	
	public String toString() {
		return Game.rMap.get(id);
	}
}
