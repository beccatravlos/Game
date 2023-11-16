
public class Blueberry extends Item{
	public Blueberry() {
		super("blueberry","A little round fruit that's called blue, is purple when mixed, and green on the inside.");
	}
	
	public void take(){
		super.take();
		Game.getCurrentRoom().setId("HALLWAY_A");
	}
	public void use() {
		if(Game.getCurrentRoom().getName().equals("calRoom")) {
			Game.print("You chuck the berry into the cauldron.");
			Game.inventory.remove(this);
			Game.flags.add("blueberry");
		} else 
			System.out.println("You can't do that.");
		}

}
