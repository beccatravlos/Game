
public class LargeKey extends Item{
	public LargeKey(){
		super("largekey", "A big key given to you by the esteemed bunny,Valentino Alexander Edward Angelonias III. Your ticket out of here!");
	}
	
	public void use() {
		if(Game.getCurrentRoom().getName().equals("entrance")) {
			if(isUsed())
				Game.print("The door is open!");
			else {
				Game.print("The key fits!! You can finally leave!");
				setUsed(true);
			}
		} else
			Game.print("The key doesn't fit here.");
	}
	
}
