
public class Bottle extends Item{
	public Bottle() {
		super("bottle", "An empty glass bottle.Could be useful for storing liquids.");
	}
	
	public void take(){
		super.take();
		Game.getCurrentRoom().setId("WINE_CELLAR_B");
	}
	
	public void use() {
		if(Game.getCurrentRoom().getName().equals("calRoom")) {
			if(isUsed())
				Game.print("The bottle contains a potion.");
			else if (Game.getCurrentRoom().getId().equals("CAULDRON_ROOM_B")){
				Game.print("You dip the bottle into the cauldron and fill it with the potion, and sit it on the table");
				Game.inventory.remove(this);
				Item potion = new Potion();
				Game.getCurrentRoom().addItem(potion);
				setUsed(true);
			}
		} else
			Game.print("You can't do that.");
	}
}
