import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class Removerpanel extends JPanel {

	JTextArea t_area 	= new JTextArea(); // to paste the text
	JLabel label 		= new JLabel("Enter the text then press ");
	JButton jb   		= new JButton("REMOVE SPACES");
	JScrollPane sp 		= new JScrollPane(t_area); //to add the scroll bar
	String text; 	
	
	Removerpanel() {
		setLayout(new BorderLayout()); // for adding components north
		JPanel up = new JPanel(); 	   //another panel for north
		
		add(up, "North");  //adding the up panel in north position
		up.add(label); 	   //first adding the label
		up.add(jb);		   //then adding the button
		add(sp);		   //after that adding scrollpane which has text area
		
		jb.addMouseListener(new MouseAdapter() {  //creating an anonymous mouse adapter class
			public void mouseClicked(MouseEvent me) { //overriding the mouse clicked
					
				text = t_area.getText(); 		 //storing the text in a string
				char arr[] = text.toCharArray(); //converting the string to charcter array
				text = ""; 	   //empty string in text
				int space = 0; // space counter

				for (int i = 0; i < arr.length; i++) {
					if (arr[i] == ' ' | arr[i] == '\t')// looping and finding spaces and tabs
					   {
			             	space++; // if space is found then incrementing counter
						    if (space == 1) //for first value insert 1 space
							    text += " ";
						} 
					else  // if no space is found
					    {
							space = 0;		//reset the counter
							text += arr[i]; //add in string again
						}
					}
					t_area.setText(text);	//now set this string text to text area
				}
			}); //end anonymous MouseAdapterClass
		    }//end addMouseListener
		}// end finderpanel

/************************************ FRAME CLASS **************************************/

public class SpaceRemover extends JFrame {

	 Removerpanel fp = new Removerpanel(); 

	SpaceRemover() {
		setTitle("SPACE REMOVER"); //setting title
		setDefaultCloseOperation(SpaceRemover.EXIT_ON_CLOSE); //exit when close pressed
		setSize(500, 500); // frame size
		add(fp); 		   // adding the removerpanel in the frame
		setVisible(true);  // set frame visibility
	}

	public static void main(String args[]) {

		new SpaceRemover(); // creating the object of spaceremover frame class
		
	}// end main
}// end filefinder class
