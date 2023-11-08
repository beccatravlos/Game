
public class Wand extends Item{
	
	public Wand() {
		super("wand","A shiny stone sits atop a glazed piece of wood. Awesome.");
	}
	
	public void use() {
		if(Game.getCurrentRoom().getName().equals("basement")) {
			System.out.println("The cellar is now unlocked!");
			Room cellar = Game.getCurrentRoom().getExit("w");
			cellar.setLocked(false);
		}else {
			System.out.println("You wave the wand around.");
		} 
	}
}
