
public class Potion extends Item{
	public Potion() {
		super("potion", "A swirling, magical concoction of God knows what.");
	}
	
	public void take(){
		super.take();
		Game.getCurrentRoom().setId("CAULDRON_ROOM_B");
	}
}
