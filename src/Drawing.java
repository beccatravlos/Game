
public class Drawing extends Item{
	public Drawing(){
		super("drawing", "A heaping mass of mindless scribbles. Looks like a childs first attempt at art.");
	}

	public void use() {
		Game.print("You take a closer look, but nothing can help you figure out what it is supposed to be. Maybe don't bring up his drawing skills if you find the wizard again.");
	}
}
