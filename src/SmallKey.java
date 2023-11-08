
public class SmallKey extends Item{
	public SmallKey() {
		super("smallkey","a tiny golden key");
	}
	
	public void use() {
		if(Game.getCurrentRoom().getName().equals("dungeonHall")) {
			if(isUsed())
				System.out.println("The chest is already open");
			else {
				System.out.println("The key fits!! You find a diamond.");
				Item diamond = new Item("diamond","Sparkly!");
				Game.getCurrentRoom().addItem(diamond);
				setUsed(true);
			}
		} else
			System.out.println("The key doesn't fit here.");
	}
	
	}

