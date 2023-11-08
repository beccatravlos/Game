import java.io.Serializable;

public class Item implements Serializable{
	private String name;
	private String des;
	private boolean heavy;
	private boolean used;

	public Item(String n, String d) {
		name = n;
		des = d;
		heavy = false;
		used = false;
	}

	public boolean isHeavy() {
		return heavy;
	}

	public void setHeavy(boolean heavy) {
		this.heavy = heavy;
	}

	public String getName() {
		return name;
	}

	public void look() {
		System.out.println(des);
	}

	public void setDes(String des) {
		this.des = des;
	}
	

	public boolean isUsed() {
		return used;
	}

	public void setUsed(boolean used) {
		this.used = used;
	}

	public void use() {
		System.out.println("You can't use this item...yet.");
	}

	public String toString() {
		return name;
	}
}
