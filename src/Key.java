
public class Key extends Item{
	
	public Key() {
		super("key", "A small metal key.");
	}
	
	public void use() {
		if(Game.getCurrentRoom().getName().equals("cell")) {
			if(isUsed())
				Game.print("You've already broken out of the cell!");
			else {
				Game.print("You're free!");
				Game.getCurrentRoom().setId("JAIL_CELL_B");
				Room dun = Game.getCurrentRoom().getExit("n");
				dun.setLocked(false);
			}
		} else
			Game.print("That key doesn't fit anywhere here.");
	}
}
