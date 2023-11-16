
public class Painting extends Item{
	public Painting(){
		super("painting", "A small portrait of a little bunny. Aww...wait. Is there something behind it?");
	}

	public void use() {
		Game.print("You move the painting to reveal a blueberry on a plate!");
		Item blueberry = new Blueberry();
		Game.getCurrentRoom().addItem(blueberry);
		Game.getCurrentRoom().setId("HALLWAY_B");
	}
}
