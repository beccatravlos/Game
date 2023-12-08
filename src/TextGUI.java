import javax.swing.*;
import javax.swing.text.DefaultCaret;

import java.awt.*;
import java.awt.event.*;

public class TextGUI extends JFrame implements KeyListener{
	public static void main(String[] args) {
		new TextGUI();
	}
	
	private JTextArea area;
	private JTextArea words;
	private JTextField textField;
	
	
	public void print(String s) {
		area.append(s+"\n\n");
	}
	
	public TextGUI() {
		setTitle("Escape the Wizard's House!");
		setSize(600,550);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setLayout(new BorderLayout());
		
		//area = new JTextArea("You are a thief who attempted to pickpocket an old man who turned out to be an evil wizard. He knocked you unconsious and has locked you in his dungeon.Your mission is to escape the evil wizard's house. Best of luck.\n");
		area = new JTextArea();
		textField = new JTextField("");
		
		
		//area.setRows(30);
		area.setFont(new Font(null, Font.PLAIN, 20));
		area.setForeground(Color.BLACK);
		//area.setColumns(30);
		area.setLineWrap(true);
		area.setWrapStyleWord(true);
		area.setEditable(false);
	
		DefaultCaret caret = (DefaultCaret) area.getCaret();
		caret.setUpdatePolicy(DefaultCaret.ALWAYS_UPDATE);
		JScrollPane scroll = new JScrollPane(area);
		add(scroll, BorderLayout.CENTER);
		
		
		textField.setFont(new Font(null, Font.PLAIN, 25));
		textField.addKeyListener(this);
		add(textField, BorderLayout.SOUTH);
		
		print("You are a thief who attempted to pickpocket an old man who turned out to be an evil wizard. He knocked you unconsious and has locked you in his dungeon.Your mission is to escape the evil wizard's house. Best of luck.\n");
		
		setVisible(true);
	}

	@Override
	public void keyTyped(KeyEvent e) {
		if(e.getKeyChar()=='\n') {
			print(textField.getText());
			if(Game.talking != null) {
				Game.talking.response(textField.getText());
			}else {
				Game.processCommand(textField.getText());
			}
			textField.setText("");
		}
	}

	@Override
	public void keyPressed(KeyEvent e) {
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	
	
	
}
