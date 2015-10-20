package forEx8_17;

import java.awt.*; 
import java.awt.event.*;
import javax.swing.*; 
import java.awt.event.ActionListener; 

public class MinMaxSumNum extends JFrame { 
	private JLabel instructionsL;  //label that tell instructions to the user
	private JTextField inputTF;  //where the user input numbers
	private JLabel errorL;  //label to show where error message will appear
	private JTextField errorMsgTF;  //where shows warning message
	private JLabel minL;  //label to the left of the text field where shows minimum of the numbers
	private JTextField minTF;  //where shows minimum of the numbers input by the user
	private JLabel maxL;  //label to the left of the text field where shows maximum of the numbers
	private JTextField maxTF;  //where shows maximum of the numbers input by the user
	private JLabel sumL;  //label to the left of the text field where shows sum of the numbers
	private JTextField sumTF;  //where shows sum of the numbers input by the user
	private JTextArea numbersTA;  //where shows all of the numbers input by the user 
	private JScrollPane numbersSP;  //make text area to be able to use scroll bar 
	private JButton clearB;  //cause the text area and text field to be all cleared
	private Container myCP;  //a reference to the content pane of the JFrame 

	public MinMaxSumNum () { 
		super("Min, Max, and  Sum of the Numbers"); 
		setSize(500, 300); 
		setLocation(100,100);
		myCP = getContentPane(); 
		myCP.setLayout(null);

		instructionsL = new JLabel("Enter a number between a 1 and 100 ");
		instructionsL.setSize(400,50);
		instructionsL.setLocation(20,5);
		myCP.add(instructionsL);

		inputTF = new JTextField();
		inputTF.setSize(50, 30);
		inputTF.setLocation(300,15);
		inputTF.addActionListener(new InputTFHandler());
		myCP.add(inputTF);

		errorL = new JLabel("Error Messages:");
		errorL.setSize(300,50);
		errorL.setLocation(20,25);
		myCP.add(errorL);

		errorMsgTF = new JTextField();
		errorMsgTF.setSize(400, 30);
		errorMsgTF.setLocation(20,60);
		errorMsgTF.setEditable(false);
		myCP.add(errorMsgTF);

		minL = new JLabel("Min");
		minL.setSize(30,50);
		minL.setLocation(20,90);
		myCP.add(minL);

		minTF = new JTextField();
		minTF.setSize(50, 30);
		minTF.setLocation(50,100);
		minTF.setEditable(false);
		myCP.add(minTF);

		maxL = new JLabel("Max");
		maxL.setSize(30,50);
		maxL.setLocation(190,90);
		myCP.add(maxL);

		maxTF = new JTextField();
		maxTF.setSize(50, 30);
		maxTF.setLocation(220,100);
		maxTF.setEditable(false);
		myCP.add(maxTF);

		sumL = new JLabel("Sum");
		sumL.setSize(30,50);
		sumL.setLocation(380,90);
		myCP.add(sumL);

		sumTF = new JTextField();
		sumTF.setSize(50, 30);
		sumTF.setLocation(410,100);
		sumTF.setEditable(false);
		myCP.add(sumTF);

		numbersTA = new JTextArea();
		numbersTA.setEditable(false);
		numbersSP = new JScrollPane(numbersTA, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		numbersSP.setSize(200, 100);
		numbersSP.setLocation(20, 150);
		myCP.add(numbersSP);

		clearB = new JButton("Clear");
		clearB.setSize(80, 30);
		clearB.setLocation(300, 200);
		clearB.addActionListener(new ClearBHandler());
		myCP.add(clearB);

		setVisible(true); // This statement makes the program end if the frame is closed.
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	} // MinMaxSumNum constructor

	public class InputTFHandler implements ActionListener {
		public void actionPerformed (ActionEvent e) {

			int newNumber;
			int currentMax = 1;
			int currentMin = 101;
			int sum;

			String inputString;
			inputString = inputTF.getText();
			newNumber = Integer.parseInt(inputString);

			if ((newNumber >= 1) && (newNumber <= 100)) {
				inputTF.setText("");
				errorMsgTF.setText("");
				clearB.setEnabled(true);
				numbersTA.append(newNumber + "\n");
				
			} else {
				errorMsgTF.setText("Error. Please enter a number in the valid range.");
				inputTF.setEditable(true);
				inputTF.setText("");
			}

			if ((newNumber > currentMax) && (newNumber < 100)) {
				newNumber = currentMax;
				maxTF.setText(currentMax + "");
			}
				
			if ((newNumber < currentMin) && (newNumber > 1)) {
				newNumber = currentMin;
				minTF.setText(currentMin + "");
			}	
			
			
			String sumString;
			sumString = sumTF.getText();
			sum = Integer.parseInt(sumString);
			sumTF.setText(sum + "");

			


	}
} //InputTFHandler

public class ClearBHandler implements ActionListener {
	public void actionPerformed (ActionEvent e) {

		numbersTA.setText("");
		errorMsgTF.setText("");
		inputTF.setEnabled(true);
		minTF.setText("");
		maxTF.setText("");
		sumTF.setText("");

	}
}


public static void main (String args[]) { 
	MinMaxSumNum myAppF = new MinMaxSumNum(); 
} //main 
} //MinMaxSumNum
