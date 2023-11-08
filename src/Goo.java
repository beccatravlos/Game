
public class Goo extends Item{
	public Goo(){
		super("goo","A slimy, green substance covers you. Eww...");
	}
	
	public void use(){
		Game.print("You can't do that!");
	}
}
