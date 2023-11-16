
public class LargeKey extends Item{
	public LargeKey(){
		super("largekey", "A big key found in the wizard's room. Could this unlock the way out?");
	}
	
	public void use() {
		if(Game.getCurrentRoom().getName().equals("entrance")) {
			if(isUsed())
				System.out.println("The door is open!");
			else {
				System.out.println("The key fits!! You can finally leave!");
				setUsed(true);
			}
		} else
			System.out.println("The key doesn't fit here.");
	}
	
}
