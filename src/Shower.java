
public class Shower extends Item{
	public Shower() {
		super("shower","A tall shower filled with all your hygiene essentials.");
	}
	
	public void use() {
		boolean clean = false;
		Item tempI=null;
		if(Game.getCurrentRoom().getName().equals("calRoom")) {
			if(isUsed())
				Game.print("You've already scrubbed all the goo off.");
			else 
				for(Item i : (Game.getInv())) {
					if(i.getName().equals("goo")) {
						Game.print("You hop in the shower and scrub all the icky goo off.");
						clean = true;
						setUsed(true);
						tempI=i;
					}
			}
			if(clean == true) {
				Game.getInv().remove(tempI);
			}
		}else
			Game.print("You can't do that!");
	}
}
