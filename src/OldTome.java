
public class OldTome extends Item{
	public OldTome() {
		super("OldTome","A tattered, old book probably older than anyone you've ever met.");
	}
	
	public void use() {
		if(Game.getCurrentRoom().getName().equals("calRoom")) {
			if(isUsed())
				Game.print("You've cast your spell. Find a bottle.");
			else {
				Game.print("You speak in tongues over the cauldron. It furiously bubbles, shakes, and changes color.");
				Game.print("You've made a potion!");
				setUsed(true);
			}
		} else
			System.out.println("You can't do that.");
	}
}

