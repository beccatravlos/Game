
public class Puppy extends NPC{
	public Puppy() {
		super("puppy", "A hideous puppy wags his tail.");
	}
	@Override
	public void talk() {
		if(!Game.flags.contains("pupTalkA")){
			say("Hi! I'm an adorable puppy!");
			String[] options = {
				"Yes you are! Who's a good boy?",
				"Ew, no. You're actually kinda hideous."
			};
			getResponse(options);
		}  else if(Game.flags.contains("pupTalkA") && !Game.flags.contains("pupTalkB")){
			say("Hey! Wanna play fetch? Say yes! Say yes!");
			String[] options = {
				"Yes! I love fetch!",
				"No. I am a horrible person and don't like playing with puppies."
			};
			getResponse(options);
		} else {
			say("Yip!");
			Game.print("The puppy wags his tail.");
		}
	}
	@Override
	public void response(String option) {
		if(!Game.flags.contains("pupTalkA")){
			switch(option) {
				case "1":
					say("I am! I'm a good boy!");
					Game.flags.add("pupTalkA");
					break;	
				case "2":
					say("I am to adorable! Why are you so mean?");
					Game.print("The puppy bites you. You deserve it.");
					Game.flags.add("pupTalkA");
					break;
			}
		} else if(Game.flags.contains("pupTalkA") && !Game.flags.contains("pupTalkB")){
			switch(option) {
			case "1":
				say("Yes! I love fetch!");
				Game.flags.add("pupTalkB");
				break;	
			case "2":
				say("You're a bad person! I don't like you!");
				Game.print("(The puppy runs away and doesn't come back.)");
				Game.flags.add("pupTalkB");
				break;
			}
		}
	}
}