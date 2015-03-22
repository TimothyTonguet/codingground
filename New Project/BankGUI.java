import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.text.DecimalFormat;

public class BankGUI extends JFrame
{
	private JPanel panel;
	private JPanel account;
	private JPanel execute;
	private JButton createAccount;
	private JButton executeAccount;
	private JButton endOfMonth;
	private JButton report;
	private JPanel empty;
	private JLabel accountID;
	private JLabel amount;
	private JLabel space;
	private JLabel spacer;
	private JLabel spacers;
	private JLabel spacerz;
	private JLabel spacerss;
	private JLabel spacers2;
	private JLabel spacers3;
	private JLabel name;
	private JLabel location;
	private JTextField accountField;
	private JTextField amountField;
	private JRadioButton sButton;
	private JRadioButton cButton;
	private JRadioButton dButton;
	private JRadioButton wButton;
	private JRadioButton bButton;
	private double balance;
	private static int accountNumber =1;
	
	private ButtonGroup bg1;
	private ButtonGroup bg2;
	
	private int WINDOW_WIDTH = 390;
	private int WINDOW_HEIGHT = 375;
	
	// Create an array to hold the account numbers.
	Account [] accountArray = new Account[11];
	
	
	public BankGUI()
	{
		setTitle("Timothy's Bank");
		setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		panel = new JPanel();
		account = new JPanel();
		execute = new JPanel();
		empty = new JPanel();		
		double c_balance = 0;
		balance = c_balance;
		int c_accountNumber = 1;
		accountNumber = c_accountNumber;
		
		setLayout(new BorderLayout());
		add(panel, BorderLayout.NORTH);
		add(account, BorderLayout.WEST);
		add(execute, BorderLayout.EAST);
		add(empty, BorderLayout.SOUTH);
				
		buildpanel();
		setVisible(true);
	}
	
private void buildpanel()	
{
	
	accountID = new JLabel("Account ID",SwingConstants.CENTER);
	amount = new JLabel("Amount",SwingConstants.CENTER);
	space = new JLabel("  ");
	spacer = new JLabel(" ");
	spacers = new JLabel("  ");
	spacerz = new JLabel("  ");
	spacerss = new JLabel("  ");
	spacers2 = new JLabel("  ");
	spacers3 = new JLabel("  ");
	
	name = new JLabel("Tonguet Bank",SwingConstants.CENTER);
	location = new JLabel("Fort Worth, Texas",SwingConstants.CENTER);
		
	accountField = new JTextField(15);
	amountField = new JTextField(15);
	
	createAccount = new JButton ("Create Account");
	
	createAccount.addActionListener(new CreateButtonListener());

	executeAccount = new JButton ("Execute");
	
	executeAccount.addActionListener(new ExecuteButtonListener());
	
	endOfMonth = new JButton ("End of Month");
	report = new JButton ("Report");
	sButton = new JRadioButton("Savings");
	cButton = new JRadioButton("Checking");
	dButton = new JRadioButton("Deposit");
	wButton = new JRadioButton("Withdraw");
	bButton = new JRadioButton("Balance");
	
	bg1 = new ButtonGroup();
	bg2 = new ButtonGroup();
	
	bg1.add(sButton);
	bg1.add(cButton);
	bg2.add(dButton);
	bg2.add(wButton);
	bg2.add(bButton);
	
	add(sButton);
	add(cButton);
	add(dButton);
	add(wButton);
	add(bButton);
	
	
	account.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
	execute.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
	account.setLayout(new GridLayout(8,1));
	execute.setLayout(new GridLayout(8,1));

	account.add(accountField);
	account.add(accountID);
	account.add(sButton);
	account.add(cButton);
	account.add(space);
	account.add(spacers);
	account.add(createAccount);
	account.add(space);
	account.add(executeAccount);
	account.add(spacer);
	account.add(endOfMonth);
	
	execute.add(amountField);
	execute.add(amount);
	execute.add(dButton);
	execute.add(wButton);
	execute.add(bButton);
	execute.add(executeAccount);
	execute.add(space);
	execute.add(report);
	
	panel.setLayout(new GridLayout(2,1));
	empty.setLayout(new GridLayout(4,1));
	
	empty.add(spacerz);
	empty.add(spacerss);
	empty.add(spacers2);
	empty.add(spacers3);
	
	panel.add(name);
	panel.add(location);

}

private class CreateButtonListener implements ActionListener
{
	public void actionPerformed(ActionEvent e)
	{
		//Create an array to store 10 accounts.
		//An account object will be needed for this.
		
		final int SIZE = 11;
		
		String balString = amountField.getText();
		double balance = Double.parseDouble(balString);
		
		
			{
				
			//setText() method used
			accountArray [accountNumber]= new Account(accountNumber,balance);
			accountField.setText(Integer.toString(accountNumber));
			
			spacerz.setText("New account ID #" + accountNumber + " created");
			accountNumber++;
			
			spacerss.setText("with an initial balance of $" + balance);
			
			
			}
		
		double AccountID, Amount;
		
	}
}


private class ExecuteButtonListener implements ActionListener
{
	public void actionPerformed(ActionEvent e)
	{
		if(dButton.isSelected())
		{
			
			String idString = amountField.getText();
			int id = Integer.parseInt(idString);
			
			String amountString = amountField.getText();
			double amount = Double.parseDouble(amountString);
			
			accountArray [id].deposit(amount);
			
			spacerz.setText("Deposited " + amount + " into account #" + accountNumber);
			accountNumber++;
			
			spacerss.setText("Current balance is $" + balance);
			
			
		}
		
		if(wButton.isSelected())
		{
			
			String idString = amountField.getText();
			int id = Integer.parseInt(idString);
			
			String amountString = amountField.getText();
			double amount = Double.parseDouble(amountString);
			
			accountArray [id].withdraw(amount);
			
			spacerz.setText("Withdrew $" + amount + " from account #" + accountNumber);
			accountNumber++;
			
			spacerss.setText("Current balance is $" + balance);
					
		}

		if(bButton.isSelected())
		{
			
			String idString = amountField.getText();
			int id = Integer.parseInt(idString);
			
			String amountString = amountField.getText();
			double amount = Double.parseDouble(amountString);
			
			accountArray [id].setBalance(amount);
			
			spacerz.setText("The Current balance in account #" + accountNumber + " is $" + amount);
			accountNumber++;
			
		}		
		
	}
}


	public static void main(String[] args)
	{
		new BankGUI();

	}



}