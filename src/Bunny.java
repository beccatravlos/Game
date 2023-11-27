
public class Bunny extends NPC{
	public Bunny() {
		super("bunny", "A fluffy bunny with perfect floppy ears sits inside a cage.");
	}
	
	public void talk() {
		if(!Game.flags.contains("bunTalkA")) {
			say("UGH... Can a rabbit enjoy 5 minutes of beauty sleep around here? What do you want?");
			String[] options = {
					"How do I get out of here?",
					"Why are you in that cage?"
			};
			getResponse(options);
		}	else if(Game.flags.contains("bunTalkA") && !Game.flags.contains("bunTalkB")) {
				say("Have you thought about my offer?");
				String[] options = {
						"What do you need?",
						"Can you please just gimme the key?"
				};
				getResponse(options);
		} else if(Game.flags.contains("bunTalkA") && Game.flags.contains("bunTalkB")) {
				say("What do you want?");
				String[] options = {
						"What do I need to do again?",
						"Bye"
				};
				getResponse(options);
			} 
		}
	
	public void response(int option) {
		if(!Game.flags.contains("bunTalkA")) {
			switch(option) {
				case 1:
					say("The wizard gave ME the spare key to the door, and I won't give it to you... unless you do me a favor...");
					Game.flags.add("bunTalkA");
					break;
				case 2:
					say("The wizard keeps me here when he goes out, and right now he's stocking up on Tears of the Wyrm, so he'll be a while.");
					Game.print("The bunny rolls his eyes");
					say("Buuuuuut, since you're out of your cage, maybe you could help me with something?");
					Game.flags.add("bunTalkA");
					break;
			}
		}else if(Game.flags.contains("bunTalkA") && !Game.flags.contains("bunTalkB")) {
			switch(option) {
			case 1:
				say("The wizard has been working on a mystical potion called The Mystical Potion of Mystery. It apparently has the power to give the consumer superpowers! Well, all the human testers died after drinking it, but the wizard gave it to this puppy he found, and now the puppy is the best Pro-Fetch player in known history! I need you to make that potion and give it to me. When you do, I'll give you the spare key I have to the front door. Now get to it!");
				Game.flags.add("bunTalkB");
				break;
			case 2:
				say("Excuse me? Do you thing THEE Valentino Alexander Edward Angelonias III does things out of the kindness of his own heart?? No!!!!! I want you to brew and bring me a Mystical Potion of Mystery and THEN I'll give you this key, thank you very much.");
				Game.flags.add("bunTalkB");
				break;
			}
		}else if(Game.flags.contains("bunTalkA") && Game.flags.contains("bunTalkB")) {
			switch(option) {
			case 1:
				say("You gotta make me a Mystical Potion of Mystery, then I'll give you the key out. Once you have the key, you can leave.");
				break;
			case 2:
				say("Don't wake me if you don't have anything to say!");
				break;
			}
		}
	}
	
	public void give(Item i) {
		if(i.getName().equals("potion")) {
			say("OH. MY. GOODNESS. That cannot be, a Mystical Potion of Mystery????? Dear me, I'd never thought I'd get to see one! Thank you random person who's name I can't care enough to remember!! As promised, here is your key.");
			Game.print("You take the largekey and slip it into your pocket.");
			Item largekey = new LargeKey();
			Game.inventory.add(largekey);
			Game.inventory.remove(i);
			
		}
	}
}
