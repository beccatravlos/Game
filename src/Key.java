
public class Key extends Item{
	
	public Key() {
		super("key", "A small metal key.");
	}
	
	public void use() {
		if(Game.getCurrentRoom().getName().equals("cell")) {
			if(isUsed())
				System.out.println("You've already broken out of the cell!");
			else {
				System.out.println("You're free!");
				Room dun = Game.getCurrentRoom().getExit("n");
				dun.setLocked(false);
			}
		} else
			System.out.println("That key doesn't fit anywhere here.");
	}
}
