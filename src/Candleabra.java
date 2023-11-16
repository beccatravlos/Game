
public class Candleabra extends Item{
	public Candleabra() {
		super("candleabra","An ornate, silver candlestick for when you're feeling mysterious.");
	}
	
	public void take(){
		super.take();
		Game.getCurrentRoom().setId("ENTRANCE_B");
		Game.print("As you pick up the candleabra, you notice a gold coin sitting under it.");
		Item goldCoin = new GoldCoin();
		Game.getCurrentRoom().addItem(goldCoin);
	}
	public void use() {
		Game.print("You hold the candleabra and slowly walk around like a ghost haunting a forgotton manor.");
	} 
}

