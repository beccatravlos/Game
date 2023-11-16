
public class OldTome extends Item{
	public OldTome() {
		super("OldTome","A tattered, wrinkly book probably older than anyone you've ever met.");
	}
	
	public void take() {
		super.take();
		Game.getCurrentRoom().setId("BASEMENT_B");
	}
	
	public void use() {
		if(Game.getCurrentRoom().getName().equals("calRoom")) {
			if(isUsed())
				Game.print("You've cast your spell. Find a bottle.");
			else {
				if(Game.flags.contains("ruby") && Game.flags.contains("goldCoin") && Game.flags.contains("blueberry")) {
					Game.print("You speak in tongues over the cauldron. It furiously bubbles, shakes, and changes color.");
					Game.print("You've made a potion!");
					Game.getCurrentRoom().setId("CAULDRON_ROOM_B");
					setUsed(true);
				} else {
					Game.print("Nothing happens");
				}
			}
		} else
			System.out.println("You can't do that.");
	}
}

