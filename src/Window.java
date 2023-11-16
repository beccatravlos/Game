
public class Window extends Item{
	public Window() {
		super("window","A square shaped window overlooking the forest.");
	}
	
	public void use(){
		if(isUsed()) {
			System.out.print("The window is already open.");
		} else {
			System.out.println("You open the window.");
			setUsed(true);
		}
	}
}
