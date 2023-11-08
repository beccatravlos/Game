
public class Chain extends Item{
	public Chain(){
		super("chain","a thick braid of cold metal.");
	}
	
	public void use() {
		if(Game.getCurrentRoom().getName().equals("cell")) {
			if(isUsed())
				Game.print("You pull the chain out of vengance, but nothing happens.");
			else {
				Game.print("WHOA! A huge glob of goo falls from the ceiling onto you.");
				Goo goo = new Goo();
				goo.setHeavy(true);
				Game.getInv().add(goo);
				setUsed(true);
			}
		} else
			System.out.println("You can't do that!");
	}
		
}

