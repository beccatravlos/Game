
public class LargeKey extends Item{
	public LargeKey(){
		super("largekey", "A big key given to you by the esteemed bunny,Valentino Alexander Edward Angelonias III. Your ticket out of here!");
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
