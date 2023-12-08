import java.io.Serializable;

public class NPC implements Serializable{
	private String name; // NPC's name
	private String desc; // NPC's description
	
	
	public NPC(String name, String desc) {
		this.name = name;
		this.desc = desc;
	}
	
	public String getName() {
		return name;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public void say(String dialog) {
		Game.print(name+": "+dialog);
	}
	public void look() {
		Game.print(desc);
	}
	public void talk() {
		Game.print("You can't talk to "+name+".");
	}
	public void response(String string) {
		// This method intentionally left blank.
	}
	
	public void give(Item i) {
		Game.print("You can't do that");
	}
	
	public void getResponse(String[] options) {
		for(int i=0; i<options.length; i++) {
			Game.print("Option "+(i+1)+": "+options[i]);
		}
		Game.print("Enter an option (1-"+options.length+"):");
		Game.talking = this;
//		int option = Game.scan.nextInt();
//		Game.scan.nextLine(); // Flush input buffer
	}
}