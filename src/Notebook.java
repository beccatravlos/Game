
public class Notebook extends Item{
	public Notebook(){
		super("notebook", "an old notebook filled with years of magical knowledge.");
	}

	public void use() {
		Game.print("You read the following entry:");
		Game.print("My mind has been fading as of late, so I'm conviently writing the recipe to my Mystical Potion of Mystery here:");
		Game.print("A red ruby");
		Game.print("A blue berry");
		Game.print("A yellow coin");
		Game.print("Add to cauldron, read from tome, and boil until sporatic and unwieldy.");
	}
}
