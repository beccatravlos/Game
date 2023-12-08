
public class GoldCoin extends Item{
	public GoldCoin() {
		super("goldCoin","A shiny gold coin with some lady's face carved on it.");
	}
	
	public void take(){
		super.take();
		Game.getCurrentRoom().setId("ENTRANCE_C");
	}
	public void use() {
		if(Game.getCurrentRoom().getName().equals("calRoom")) {
			Game.print("You suavely flip the coin into the cauldron.");
			Game.inventory.remove(this);
			Game.flags.add("goldCoin");
		} else 
			Game.print("You can't do that.");
		}
}
