
public class JewelryBox extends Item{
	public JewelryBox() {
		super("jewelryBox", "A extravagant box covered in gems, gold, and other things rich people like.");
	}
	
	public void use() {
		Game.print("You open the box to reveal all sorts of stones and metals. The thing that catches you eye the most is a brillant ruby.");
		Item ruby = new Ruby();
		Game.getCurrentRoom().addItem(ruby);
		Game.getCurrentRoom().setId("BEDROOM_B");
	}
}
