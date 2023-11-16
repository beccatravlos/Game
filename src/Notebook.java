
public class Notebook extends Item{
	public Notebook(){
		super("notebook", "an old notebook filled with years of magical knowledge.");
	}

	public void use() {
		System.out.println("You read the following entry:");
		System.out.println("My mind has been fading as of late, so I'm conviently writing the recipe to my Mystical Potion of Mystery here:");
		System.out.println("A red ruby");
		System.out.println("A blue berry");
		System.out.println("A yellow coin");
		System.out.println("Add to cauldron, read from tome, and boil until sporatic and unwieldy.");
	}
}
