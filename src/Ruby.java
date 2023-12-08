
public class Ruby extends Item{
	public Ruby() {
		super("ruby", "A shimmering red stone that feels heavy in your hand.");
	}
	
	public void take(){
		super.take();
		Game.getCurrentRoom().setId("BEDROOM_A");
	}
	public void use() {
		if(Game.getCurrentRoom().getName().equals("calRoom")) {
			Game.print("You drop the ruby into the cauldron.");
			Game.inventory.remove(this);
			Game.flags.add("ruby");
		} else 
			Game.print("You can't do that.");
		}
}
