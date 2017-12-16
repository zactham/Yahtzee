import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JApplet;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.border.Border;


public class DiceScoreCard extends JApplet
{
	//TODO test new bonus

	//TODO disable re roll after 3 clicks
	//TODO display roll count
	//TODO add pop up game winner window screen

	//Turn Tracker
	private boolean P1Turn=true;


	//Frame
	private JFrame pop = new JFrame();

	//Dice Buttons
	private JButton D1;
	private JButton D2;
	private JButton D3;
	private JButton D4;
	private JButton D5;

	//ReRoll
	private JButton ReRoll;

	//Dice Random Numbers
	public static int [] DiceRan = new int [5];

	//Checks to see how many of each number is rolled
	static int Rolled1s = 0;
	static int Rolled2s = 0;
	static int Rolled3s = 0;
	static int Rolled4s = 0;
	static int Rolled5s = 0;
	static int Rolled6s = 0;

	//Yahtzee Counters
	private int Y1Counter = 0;
	private int Y2Counter = 0;

	//Dice Images
	private ImageIcon Random1Image;
	private ImageIcon Random2Image;
	private ImageIcon Random3Image;
	private ImageIcon Random4Image;
	private ImageIcon Random5Image;
	private ImageIcon Random6Image;

	//Image Array
	ImageIcon[] Images = new ImageIcon[6];


	//Score Card buttons

	private JButton totalScore1;
	private JButton totalScore2;

	//Player 1 Buttons
	private JButton aces;
	private JButton twos;
	private JButton threes;
	private JButton fours;
	private JButton fives;
	private JButton sixes;
	private JButton threeKind;
	private JButton fourKind;
	private JButton fullHouse;
	private JButton smallStraight;
	private JButton largeStraight;
	private static JButton Yahtzee;
	private JButton Chance;

	//Player 2 Buttons
	private JButton aces2;
	private JButton twos2;
	private JButton threes2;
	private JButton fours2;
	private JButton fives2;
	private JButton sixes2;
	private JButton threeKind2;
	private JButton fourKind2;
	private JButton fullHouse2;
	private JButton smallStraight2;
	private JButton largeStraight2;
	private JButton Yahtzee2;
	private JButton Chance2;



	//Score
	JLabel Player1 = new JLabel ("Player 1");
	JLabel Player2 = new JLabel ("Player 2");

	//Player 1
	private int acesS;
	private int twosS;
	private int threesS;
	private int foursS;
	private int fivesS;
	private int sixesS;
	private int threeKindS;
	private int fourKindS;
	private int fullHouseS;
	private int smallStraightS;
	private int largeStraightS;
	private int YahtzeeS;
	private int ChanceS;

	//Player 1 Total Score
	private int Score1 = acesS + twosS + threesS + foursS + fivesS + sixesS + threeKindS + fourKindS + fullHouseS + smallStraightS + largeStraightS + YahtzeeS + ChanceS;

	//Bonus score for getting more than 60 points in the first 6
	private int bonus1 = acesS + twosS + threesS + foursS + fivesS + sixesS;


	//Player 2
	private int acesS2;
	private int twosS2;
	private int threesS2;
	private int foursS2;
	private int fivesS2;
	private int sixesS2;
	private int threeKindS2;
	private int fourKindS2;
	private int fullHouseS2;
	private int smallStraightS2;
	private int largeStraightS2;
	private int YahtzeeS2;
	private int ChanceS2;

	//Player 2 Total Score
	private int Score2 = acesS2 + twosS2 + threesS2 + foursS2 + fivesS2 + sixesS2 + threeKindS2 + fourKindS2 + fullHouseS2 + smallStraightS2 + largeStraightS2 + YahtzeeS2 + ChanceS2;

	//Bonus score for getting more than 60 points in the first 6
	private int bonus2 = acesS2 + twosS2 + threesS2 + foursS2 + fivesS2 + sixesS2;

	//Winner disabled++;
	private int disabled;


	public void init ()
	{
		//Dice
		D1=new JButton();
		D2=new JButton();
		D3=new JButton();
		D4=new JButton();
		D5=new JButton();

		//ReRoll
		ReRoll = new JButton("ReRoll: " + Rolls);

		//Dice Images
		Random1Image = new ImageIcon(this.getClass().getResource("/Yahtzee Pictures/Dice 1.png"));//image	
		Random2Image = new ImageIcon(this.getClass().getResource("/Yahtzee Pictures/Dice 2.png"));//image	
		Random3Image = new ImageIcon(this.getClass().getResource("/Yahtzee Pictures/Dice 3.png"));//image	
		Random4Image = new ImageIcon(this.getClass().getResource("/Yahtzee Pictures/Dice 4.png"));//image	
		Random5Image = new ImageIcon(this.getClass().getResource("/Yahtzee Pictures/Dice 5.png"));//image	
		Random6Image = new ImageIcon(this.getClass().getResource("/Yahtzee Pictures/Dice 6.png"));//image	


		//Array with the Dice Images
		Images[0]=Random1Image;
		Images[1]=Random2Image;
		Images[2]=Random3Image;
		Images[3]=Random4Image;
		Images[4]=Random5Image;
		Images[5]=Random6Image;

		//Random Dice
		//(int)(Math.random()*6 + 1);
		DiceRan[0]= (int)(Math.random()*6 + 1);
		DiceRan[1]= (int)(Math.random()*6 + 1);
		DiceRan[2]= (int)(Math.random()*6 + 1);
		DiceRan[3]= (int)(Math.random()*6 + 1);
		DiceRan[4]= (int)(Math.random()*6 + 1);

		//Pairs each dice button with an image (random number)
		//--------------------------------
		for(int x=1; x<=6; x++)
		{

			if(DiceRan[0]==x)
			{
				D1.setIcon(Images[x-1]);
			}
		}
		//--------------------------------
		for(int x=1; x<=6; x++)
		{
			if(DiceRan[1]==x)
			{
				D2.setIcon(Images[x-1]);
			}
		}
		//--------------------------------
		for(int x=1; x<=6; x++)
		{
			if(DiceRan[2]==x)
			{
				D3.setIcon(Images[x-1]);
			}
		}
		//--------------------------------
		for(int x=1; x<=6; x++)
		{
			if(DiceRan[3]==x)
			{
				D4.setIcon(Images[x-1]);
			}
		}
		//--------------------------------
		for(int x=1; x<=6; x++)
		{
			if(DiceRan[4]==x)
			{
				D5.setIcon(Images[x-1]);
			}
		}
		//--------------------------------
		//Total score
		totalScore1= new JButton("Player 1: "+Score1);
		totalScore2= new JButton("Player 2: "+Score2);

		//Player 1
		aces = new JButton ("Aces: " + acesS);
		twos = new JButton ("Twos: " + twosS);
		threes = new JButton ("Threes: " + threesS);
		fours = new JButton ("Fours: " + foursS);
		fives = new JButton ("Fives: " + fivesS);
		sixes = new JButton ("Sixes: " + sixesS);
		threeKind = new JButton ("3 of a Kind: " + threeKindS);
		fourKind = new JButton ("4 of a Kind: " + fourKindS);
		fullHouse = new JButton ("Full House: " + fullHouseS);
		smallStraight = new JButton ("Small Straight: " + smallStraightS);
		largeStraight = new JButton ("Large Straight: " + largeStraightS);
		Yahtzee = new JButton ("Yahtzee: " + YahtzeeS);
		Chance = new JButton ("Chance: " + ChanceS);

		//Player 2
		aces2 = new JButton ("Aces: " + acesS2);
		twos2 = new JButton ("Twos: " + twosS2);
		threes2 = new JButton ("Threes: " + threesS2);
		fours2 = new JButton ("Fours: " + foursS2);
		fives2 = new JButton ("Fives: " + fivesS2);
		sixes2 = new JButton ("Sixes: " + sixesS2);
		threeKind2 = new JButton ("3 of a Kind: " + threeKindS2);
		fourKind2 = new JButton ("4 of a Kind: " + fourKindS2);
		fullHouse2 = new JButton ("Full House: " + fullHouseS2);
		smallStraight2 = new JButton ("Small Straight: " + smallStraightS2);
		largeStraight2 = new JButton ("Large Straight: " + largeStraightS2);
		Yahtzee2 = new JButton ("Yahtzee: " + YahtzeeS2);
		Chance2 = new JButton ("Chance: " + ChanceS2);


		//Dice Listener
		D1.addMouseListener(new Listener1());
		D2.addMouseListener(new Listener2());
		D3.addMouseListener(new Listener3());
		D4.addMouseListener(new Listener4());
		D5.addMouseListener(new Listener5());

		//Re-Roll
		ReRoll.addMouseListener(new Listener6());


		//Player 1
		aces.addActionListener (new ButtonPushAce());
		twos.addActionListener (new ButtonPushTwo());
		threes.addActionListener (new ButtonPushThree());
		fours.addActionListener (new ButtonPushFour());
		fives.addActionListener (new ButtonPushFive());
		sixes.addActionListener (new ButtonPushSix());
		threeKind.addActionListener (new ButtonPush3K());
		fourKind.addActionListener (new ButtonPush4K());
		smallStraight.addActionListener (new ButtonPushSS());
		largeStraight.addActionListener (new ButtonPushLS());
		fullHouse.addActionListener (new ButtonPushFH());
		Yahtzee.addActionListener (new ButtonPushY());
		Chance.addActionListener (new ButtonPushC());

		//Player 2
		aces2.addActionListener (new ButtonPushAce2());
		twos2.addActionListener (new ButtonPushTwo2());
		threes2.addActionListener (new ButtonPushThree2());
		fours2.addActionListener (new ButtonPushFour2());
		fives2.addActionListener (new ButtonPushFive2());
		sixes2.addActionListener (new ButtonPushSix2());
		threeKind2.addActionListener (new ButtonPush3K2());
		fourKind2.addActionListener (new ButtonPush4K2());
		smallStraight2.addActionListener (new ButtonPushSS2());
		largeStraight2.addActionListener (new ButtonPushLS2());
		fullHouse2.addActionListener (new ButtonPushFH2());
		Yahtzee2.addActionListener (new ButtonPushY2());
		Chance2.addActionListener (new ButtonPushC2());


		Container cp = getContentPane();
		cp.setBackground (Color.white);//background color

		cp.setLayout(new GridLayout(14, 5, 175, 15));

		//Makes the buttons blend in so only the dice picture/score is visible
		Border emptyBorder = BorderFactory.createEmptyBorder();
		D1.setBorder(emptyBorder);
		D1.setBackground(Color.white);
		D2.setBorder(emptyBorder);
		D2.setBackground(Color.white);
		D3.setBorder(emptyBorder);
		D3.setBackground(Color.white);
		D4.setBorder(emptyBorder);
		D4.setBackground(Color.white);
		D5.setBorder(emptyBorder);
		D5.setBackground(Color.white);
		totalScore1.setBorder(emptyBorder);
		totalScore1.setBackground(Color.white);
		totalScore2.setBorder(emptyBorder);
		totalScore2.setBackground(Color.white);


		//Adds all of the buttons
		Player1.setFont (new Font ("Arial", Font.PLAIN, 32));//sets the font
		Player2.setFont (new Font ("Arial", Font.PLAIN, 32));//sets the font
		Player1.setForeground(Color.red);//Starts the color to alert the player it is their turn

		//PLayer 1 and 2 Strings
		cp.add(Player1);
		cp.add(new JLabel(""));
		cp.add(new JLabel("  Dice are already rolled once."));//Instructions
		cp.add(new JLabel(""));
		cp.add(Player2);

		//Row and Column Buttons (Score Card and Dice)
		cp.add (aces);
		cp.add(new JLabel(""));
		cp.add(new JLabel("  Click the dice to reroll them."));
		cp.add(new JLabel(""));
		cp.add (aces2);

		cp.add (twos);
		cp.add(totalScore1);
		cp.add(new JLabel(""));
		cp.add(totalScore2);
		cp.add (twos2);

		cp.add (threes);
		cp.add(new JLabel(""));
		cp.add(D1);
		cp.add(new JLabel(""));
		cp.add (threes2);

		cp.add (fours);
		cp.add(new JLabel(""));
		cp.add(D2);
		cp.add(new JLabel(""));
		cp.add (fours2);

		cp.add (fives);
		cp.add(new JLabel(""));
		cp.add(D3);
		cp.add(new JLabel(""));
		cp.add (fives2);

		cp.add (sixes);
		cp.add(new JLabel(""));
		cp.add(D4);
		cp.add(new JLabel(""));
		cp.add (sixes2);

		cp.add (threeKind);
		cp.add(new JLabel(""));
		cp.add(D5);
		cp.add(new JLabel(""));
		cp.add (threeKind2);

		cp.add (fourKind);
		cp.add(new JLabel(""));
		cp.add(ReRoll); //reroll button
		cp.add(new JLabel(""));
		cp.add (fourKind2);

		cp.add (fullHouse);
		cp.add(new JLabel(""));
		cp.add(new JLabel(""));
		cp.add(new JLabel(""));
		cp.add (fullHouse2);

		cp.add (smallStraight);
		cp.add(new JLabel(""));
		cp.add(new JLabel(""));
		cp.add(new JLabel(""));
		cp.add (smallStraight2);


		cp.add (largeStraight);
		cp.add(new JLabel(""));
		cp.add(new JLabel(""));
		cp.add(new JLabel(""));
		cp.add (largeStraight2);

		cp.add (Yahtzee);
		cp.add(new JLabel(""));
		cp.add(new JLabel(""));
		cp.add(new JLabel(""));
		cp.add (Yahtzee2);

		cp.add(Chance);
		cp.add(new JLabel(""));
		cp.add(new JLabel(""));
		cp.add(new JLabel(""));
		cp.add(Chance2);


		setSize (1600, 950);//sets the size
	}





	//Checks the amount of time each number is rolled
	public static class DiceRolled
	{
		public static int DiceRolled1s ()
		{
			//Yahtzee.setEnabled(true);//allows the bonus yahtzee to work
			Rolled1s = 0;
			for (int i = 0; i < 5; i++)
			{
				if (DiceRan[i] == 1)
				{
					Rolled1s +=1;
				}
			}
			return Rolled1s;
		}

		public static int DiceRolled2s ()
		{
			//	Yahtzee.setEnabled(true);
			Rolled2s = 0;
			for (int i = 0; i < 5; i++)
			{
				if (DiceRan[i] == 2)
				{
					Rolled2s +=1;
				}
			}
			return Rolled2s;
		}
		public static int DiceRolled3s ()
		{
			//Yahtzee.setEnabled(true);
			Rolled3s = 0;
			for (int i = 0; i < 5; i++)
			{
				if (DiceRan[i] == 3)
				{
					Rolled3s +=1;
				}
			}
			return Rolled3s;
		}
		public static int DiceRolled4s ()
		{
			//Yahtzee.setEnabled(true);
			Rolled4s = 0;
			for (int i = 0; i < 5; i++)
			{
				if (DiceRan[i] == 4)
				{
					Rolled4s +=1;
				}
			}
			return Rolled4s;
		}
		public static int DiceRolled5s ()
		{
			//Yahtzee.setEnabled(true);
			Rolled5s = 0;
			for (int i = 0; i < 5; i++)
			{
				if (DiceRan[i] == 5)
				{
					Rolled5s +=1;
				}
			}
			return Rolled5s;
		}
		public static int DiceRolled6s ()
		{
			//Yahtzee.setEnabled(true);
			Rolled6s = 0;
			for (int i = 0; i < 5; i++)
			{
				if (DiceRan[i] == 6)
				{
					Rolled6s +=1;
				}
			}
			return Rolled6s;
		}
	}
	//Sets the total score for both players
	private void SettingScore2()
	{
		Score2 = acesS2 + twosS2 + threesS2 + foursS2 + fivesS2 + sixesS2 + threeKindS2 + fourKindS2 + fullHouseS2 + smallStraightS2 + largeStraightS2 + YahtzeeS2 + ChanceS2+B2;
		totalScore2.setText("Player 2 Score: "+Score2);
	}

	//Sets the total score for both players
	private void SettingScore1()
	{
		Score1 = acesS + twosS + threesS + foursS + fivesS + sixesS + threeKindS + fourKindS + fullHouseS + smallStraightS + largeStraightS + YahtzeeS + ChanceS+B1;
		totalScore1.setText("Player 1 Score: "+Score1);
	}

	private int B1=0;
	private int B2=0;
	private void bonusScore1()
	{
		bonus1 = acesS + twosS + threesS + foursS + fivesS + sixesS;
		if (bonus1 >= 63)
		{
			B1 = 35;
		}
	}

	private void bonusScore2()
	{
		bonus2 = acesS2 + twosS2 + threesS2 + foursS2 + fivesS2 + sixesS2;
		if (bonus2 >= 63)
		{
			B2 = 35;
		}
	}

	//Ender();
	private void Ender()
	{
		if(disabled==26)
		{
			if(Score1>Score2)
			{
				Player1.setText("WINNER!");
				Player2.setText("LOSER!");
				if (JOptionPane.showConfirmDialog(pop, "Player 1 wins! Do you want to reset?", "Reset?",  JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION )
				{
					Player1.setText("Player 1");
					Player2.setText("Player 2");

					Score1=0;
					acesS=0;
					twosS =0;
					threesS=0;
					foursS =0;
					fivesS =0;
					sixesS =0;
					threeKindS =0;
					fourKindS =0;
					fullHouseS =0;
					smallStraightS =0;
					largeStraightS =0;
					YahtzeeS=0;
					ChanceS=0;

					aces.setEnabled(true);
					twos.setEnabled(true);
					threes.setEnabled(true);
					fours.setEnabled(true);
					fives.setEnabled(true);
					sixes.setEnabled(true);
					threeKind.setEnabled(true);
					fourKind.setEnabled(true);
					fullHouse.setEnabled(true);
					smallStraight.setEnabled(true);
					largeStraight.setEnabled(true);
					Yahtzee.setEnabled(true);
					Chance.setEnabled(true);

					Score2 =0;
					acesS2 =0;
					twosS2=0;
					threesS2 =0;
					foursS2=0;
					fivesS2 =0;
					sixesS2=0;
					threeKindS2=0;
					fourKindS2 =0;
					fullHouseS2=0;
					smallStraightS2 =0;
					largeStraightS2 =0;
					YahtzeeS2=0;
					ChanceS2=0;


					totalScore2.setText("Player 2 Score: "+Score2);
					totalScore1.setText("Player 1 Score: "+Score1);


					aces2.setEnabled(true);
					twos2.setEnabled(true);
					threes2.setEnabled(true);
					fours2.setEnabled(true);
					fives2.setEnabled(true);
					sixes2.setEnabled(true);
					threeKind2.setEnabled(true);
					fourKind2.setEnabled(true);
					fullHouse2.setEnabled(true);
					smallStraight2.setEnabled(true);
					largeStraight2.setEnabled(true);
					Yahtzee2.setEnabled(true);
					Chance2.setEnabled(true);

					aces.setText("Aces: " + acesS);
					twos.setText("Twos: " + twosS);
					threes.setText("Threes: " + threesS);
					fours.setText("Fours: " + foursS);
					fives.setText("Fives: " + fivesS);
					sixes.setText("Sixes: " + sixesS);
					threeKind.setText("3 of a Kind: " + threeKindS);
					fourKind.setText("4 of a Kind: " + fourKindS);
					fullHouse.setText("Full House: " + fullHouseS);
					smallStraight.setText("Small Straight: " + smallStraightS);
					largeStraight.setText("Large Straight: " + largeStraightS);
					Yahtzee.setText("Yahtzee: " + YahtzeeS);
					Chance.setText("Chance: " + ChanceS);

					//Player 2
					aces2.setText("Aces: " + acesS2);
					twos2.setText("Twos: " + twosS2);
					threes2.setText("Threes: " + threesS2);
					fours2.setText("Fours: " + foursS2);
					fives2.setText("Fives: " + fivesS2);
					sixes2.setText("Sixes: " + sixesS2);
					threeKind2.setText("3 of a Kind: " + threeKindS2);
					fourKind2.setText("4 of a Kind: " + fourKindS2);
					fullHouse2.setText("Full House: " + fullHouseS2);
					smallStraight2.setText("Small Straight: " + smallStraightS2);
					largeStraight2.setText("Large Straight: " + largeStraightS2);
					Yahtzee2.setText("Yahtzee: " + YahtzeeS2);
					Chance2.setText("Chance: " + ChanceS2);

					disabled=0;

					P1Turn=true;

					Player1.setForeground(Color.red);
					Player2.setForeground(Color.black);

					Y1Counter=0;
					Y2Counter=0;

					for(int x=0; x<5; x++){
						ToBeRolled[x]=0;
					}

					ReRoll.setText("ReRoll: " + Rolls);


				}
			}
			else if(Score1<Score2)
			{
				Player1.setText("LOSER!");
				Player2.setText("WINNER!");
				if (JOptionPane.showConfirmDialog(pop, "Player 2 wins! Do you want to reset?", "Reset?",  JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION )
				{
					Player1.setText("Player 1");
					Player2.setText("Player 2");

					Score1=0;
					acesS=0;
					twosS =0;
					threesS=0;
					foursS =0;
					fivesS =0;
					sixesS =0;
					threeKindS =0;
					fourKindS =0;
					fullHouseS =0;
					smallStraightS =0;
					largeStraightS =0;
					YahtzeeS=0;
					ChanceS=0;

					aces.setEnabled(true);
					twos.setEnabled(true);
					threes.setEnabled(true);
					fours.setEnabled(true);
					fives.setEnabled(true);
					sixes.setEnabled(true);
					threeKind.setEnabled(true);
					fourKind.setEnabled(true);
					fullHouse.setEnabled(true);
					smallStraight.setEnabled(true);
					largeStraight.setEnabled(true);
					Yahtzee.setEnabled(true);
					Chance.setEnabled(true);

					Score2 =0;
					acesS2 =0;
					twosS2=0;
					threesS2 =0;
					foursS2=0;
					fivesS2 =0;
					sixesS2=0;
					threeKindS2=0;
					fourKindS2 =0;
					fullHouseS2=0;
					smallStraightS2 =0;
					largeStraightS2 =0;
					YahtzeeS2=0;
					ChanceS2=0;


					totalScore2.setText("Player 2 Score: "+Score2);
					totalScore1.setText("Player 1 Score: "+Score1);


					aces2.setEnabled(true);
					twos2.setEnabled(true);
					threes2.setEnabled(true);
					fours2.setEnabled(true);
					fives2.setEnabled(true);
					sixes2.setEnabled(true);
					threeKind2.setEnabled(true);
					fourKind2.setEnabled(true);
					fullHouse2.setEnabled(true);
					smallStraight2.setEnabled(true);
					largeStraight2.setEnabled(true);
					Yahtzee2.setEnabled(true);
					Chance2.setEnabled(true);

					aces.setText("Aces: " + acesS);
					twos.setText("Twos: " + twosS);
					threes.setText("Threes: " + threesS);
					fours.setText("Fours: " + foursS);
					fives.setText("Fives: " + fivesS);
					sixes.setText("Sixes: " + sixesS);
					threeKind.setText("3 of a Kind: " + threeKindS);
					fourKind.setText("4 of a Kind: " + fourKindS);
					fullHouse.setText("Full House: " + fullHouseS);
					smallStraight.setText("Small Straight: " + smallStraightS);
					largeStraight.setText("Large Straight: " + largeStraightS);
					Yahtzee.setText("Yahtzee: " + YahtzeeS);
					Chance.setText("Chance: " + ChanceS);

					//Player 2
					aces2.setText("Aces: " + acesS2);
					twos2.setText("Twos: " + twosS2);
					threes2.setText("Threes: " + threesS2);
					fours2.setText("Fours: " + foursS2);
					fives2.setText("Fives: " + fivesS2);
					sixes2.setText("Sixes: " + sixesS2);
					threeKind2.setText("3 of a Kind: " + threeKindS2);
					fourKind2.setText("4 of a Kind: " + fourKindS2);
					fullHouse2.setText("Full House: " + fullHouseS2);
					smallStraight2.setText("Small Straight: " + smallStraightS2);
					largeStraight2.setText("Large Straight: " + largeStraightS2);
					Yahtzee2.setText("Yahtzee: " + YahtzeeS2);
					Chance2.setText("Chance: " + ChanceS2);

					disabled=0;

					P1Turn=true;

					Player1.setForeground(Color.red);
					Player2.setForeground(Color.black);

					Y1Counter=0;
					Y2Counter=0;

					for(int x=0; x<5; x++){
						ToBeRolled[x]=0;
					}

					ReRoll.setText("ReRoll: " + Rolls);


				}
			}
			else if(Score1==Score2)
			{
				Player1.setText("Tie.");
				Player2.setText("Tie.");
				if (JOptionPane.showConfirmDialog(pop, "It's a tie! (How the heck did you do that?) Do you want to reset?", "Reset?",  JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION )
				{
					Player1.setText("Player 1");
					Player2.setText("Player 2");


					Score1=0;
					acesS=0;
					twosS =0;
					threesS=0;
					foursS =0;
					fivesS =0;
					sixesS =0;
					threeKindS =0;
					fourKindS =0;
					fullHouseS =0;
					smallStraightS =0;
					largeStraightS =0;
					YahtzeeS=0;
					ChanceS=0;

					aces.setEnabled(true);
					twos.setEnabled(true);
					threes.setEnabled(true);
					fours.setEnabled(true);
					fives.setEnabled(true);
					sixes.setEnabled(true);
					threeKind.setEnabled(true);
					fourKind.setEnabled(true);
					fullHouse.setEnabled(true);
					smallStraight.setEnabled(true);
					largeStraight.setEnabled(true);
					Yahtzee.setEnabled(true);
					Chance.setEnabled(true);

					Score2 =0;
					acesS2 =0;
					twosS2=0;
					threesS2 =0;
					foursS2=0;
					fivesS2 =0;
					sixesS2=0;
					threeKindS2=0;
					fourKindS2 =0;
					fullHouseS2=0;
					smallStraightS2 =0;
					largeStraightS2 =0;
					YahtzeeS2=0;
					ChanceS2=0;

					totalScore2.setText("Player 2 Score: "+Score2);
					totalScore1.setText("Player 1 Score: "+Score1);

					aces2.setEnabled(true);
					twos2.setEnabled(true);
					threes2.setEnabled(true);
					fours2.setEnabled(true);
					fives2.setEnabled(true);
					sixes2.setEnabled(true);
					threeKind2.setEnabled(true);
					fourKind2.setEnabled(true);
					fullHouse2.setEnabled(true);
					smallStraight2.setEnabled(true);
					largeStraight2.setEnabled(true);
					Yahtzee2.setEnabled(true);
					Chance2.setEnabled(true);

					aces.setText("Aces: " + acesS);
					twos.setText("Twos: " + twosS);
					threes.setText("Threes: " + threesS);
					fours.setText("Fours: " + foursS);
					fives.setText("Fives: " + fivesS);
					sixes.setText("Sixes: " + sixesS);
					threeKind.setText("3 of a Kind: " + threeKindS);
					fourKind.setText("4 of a Kind: " + fourKindS);
					fullHouse.setText("Full House: " + fullHouseS);
					smallStraight.setText("Small Straight: " + smallStraightS);
					largeStraight.setText("Large Straight: " + largeStraightS);
					Yahtzee.setText("Yahtzee: " + YahtzeeS);
					Chance.setText("Chance: " + ChanceS);

					//Player 2
					aces2.setText("Aces: " + acesS2);
					twos2.setText("Twos: " + twosS2);
					threes2.setText("Threes: " + threesS2);
					fours2.setText("Fours: " + foursS2);
					fives2.setText("Fives: " + fivesS2);
					sixes2.setText("Sixes: " + sixesS2);
					threeKind2.setText("3 of a Kind: " + threeKindS2);
					fourKind2.setText("4 of a Kind: " + fourKindS2);
					fullHouse2.setText("Full House: " + fullHouseS2);
					smallStraight2.setText("Small Straight: " + smallStraightS2);
					largeStraight2.setText("Large Straight: " + largeStraightS2);
					Yahtzee2.setText("Yahtzee: " + YahtzeeS2);
					Chance2.setText("Chance: " + ChanceS2);

					disabled=0;

					P1Turn=true;

					Player1.setForeground(Color.red);
					Player2.setForeground(Color.black);

					Y1Counter=0;
					Y2Counter=0;

					for(int x=0; x<5; x++){
						ToBeRolled[x]=0;
					}

					ReRoll.setText("ReRoll: " + Rolls);


				}
			}
		}

	}


	private class ButtonPushAce implements ActionListener
	{
		public void actionPerformed (ActionEvent even)
		{
			if(P1Turn==true)
			{
				if (DiceRolled.DiceRolled1s() == 0)//no 1s have been rolled
				{
					//Creates a PopUp Window that insures the user wants to receive a 0 if they do not have the correct score
					if (JOptionPane.showConfirmDialog(pop,"You did not roll this set, do you want to take a scratch?", "Scratch",  JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION )//if they press yes
					{
						aces.setEnabled(false);//button cannot be pressed again
						disabled++;
						Player2.setForeground(Color.red);
						Player1.setForeground(Color.black);
						P1Turn=false;

						FullRoll();
					}
				}

				//Updates their score with the amount of dice they rolled
				else//they want the 1s as their score
				{


					for (int i = 0;i < 5; i++)
					{
						if (DiceRan[i] == 1)
						{
							acesS +=1;
						}
					}
					aces.setText("Aces: " + acesS);
					Player2.setForeground(Color.red);
					Player1.setForeground(Color.black);
					aces.setEnabled(false);//button cannot be pressed again
					disabled++;
					P1Turn=false;
					FullRoll();

				}
				bonusScore1();
				SettingScore1();

			}
			Ender();
		}
	}

	private class ButtonPushTwo implements ActionListener
	{
		public void actionPerformed (ActionEvent even)
		{
			if(P1Turn==true)
			{
				if (DiceRolled.DiceRolled2s() == 0)//User has not scratched yet and no 2s have been rolled
				{
					//Creates a PopUp Window that insures the user wants to receive a 0 if they do not have the correct score
					if (JOptionPane.showConfirmDialog(pop,"You did not roll this set, do you want to take a scratch?", "Scratch",  JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION )//if they press yes
					{
						twos.setEnabled(false);//button cannot be pressed again
						disabled++;
						Player2.setForeground(Color.red);
						Player1.setForeground(Color.black);
						P1Turn=false;
						FullRoll();
					}
				}

				//Updates their score with the amount of dice they rolled
				else//they want the 2s as their score
				{


					for (int i = 0; i < 5; i++)
					{
						if (DiceRan[i] == 2)
						{
							twosS +=1;
						}
					}
					twosS *=2;
					twos.setText("Twos: " + twosS);
					Player2.setForeground(Color.red);
					Player1.setForeground(Color.black);
					twos.setEnabled(false);//button cannot be pressed again
					disabled++;
					P1Turn=false;
					FullRoll();
				}
				bonusScore1();
				SettingScore1();

			}
			Ender();
		}
	}

	private class ButtonPushThree implements ActionListener
	{
		public void actionPerformed (ActionEvent even)
		{
			if(P1Turn==true)
			{
				if (DiceRolled.DiceRolled3s () == 0)//User has not scratched yet and no 3s have been rolled
				{
					//Creates a PopUp Window that insures the user wants to receive a 0 if they do not have the correct score
					if (JOptionPane.showConfirmDialog(pop,"You did not roll this set, do you want to take a scratch?", "Scratch",  JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION )//if they press yes
					{
						threes.setEnabled(false);//button cannot be pressed again
						disabled++;
						Player2.setForeground(Color.red);
						Player1.setForeground(Color.black);
						P1Turn=false;
						FullRoll();

					}
				}

				//Updates their score with the amount of dice they rolled
				else//they want the 3s as their score
				{
					for (int i = 0; i < 5; i++)
					{
						if (DiceRan[i] == 3)
						{
							threesS +=1;
						}
					}
					threesS *=3;
					threes.setText("Threes: " + threesS);
					Player2.setForeground(Color.red);
					Player1.setForeground(Color.black);
					threes.setEnabled(false);//button cannot be pressed again
					disabled++;
					P1Turn=false;
					FullRoll();
				}
				bonusScore1();
				SettingScore1();

			}
			Ender();

		}
	}

	private class ButtonPushFour implements ActionListener
	{
		public void actionPerformed (ActionEvent even)
		{
			if(P1Turn==true)
			{
				if (DiceRolled.DiceRolled4s () == 0)//User has not scratched yet and no 4s have been rolled
				{
					//Creates a PopUp Window that insures the user wants to receive a 0 if they do not have the correct score
					if (JOptionPane.showConfirmDialog(pop,"You did not roll this set, do you want to take a scratch?", "Scratch",  JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION )//if they press yes
					{
						fours.setEnabled(false);//button cannot be pressed again
						disabled++;
						Player2.setForeground(Color.red);
						Player1.setForeground(Color.black);
						P1Turn=false;
						FullRoll();
					}
				}

				//Updates their score with the amount of dice they rolled
				else//they want the 4s as their score
				{
					for (int i = 0; i < 5; i++)
					{
						if (DiceRan[i] == 4)
						{
							foursS +=1;
						}
					}
					foursS *=4;
					fours.setText("Fours: " + foursS);
					Player2.setForeground(Color.red);
					Player1.setForeground(Color.black);
					fours.setEnabled(false);//button cannot be pressed again
					disabled++;
					P1Turn=false;
					FullRoll();
				}
				bonusScore1();
				SettingScore1();

			}
			Ender();
		}
	}

	private class ButtonPushFive implements ActionListener
	{
		public void actionPerformed (ActionEvent even)
		{
			if(P1Turn==true)
			{
				if (DiceRolled.DiceRolled5s () == 0)//User has not scratched yet and no 5s have been rolled
				{
					//Creates a PopUp Window that insures the user wants to receive a 0 if they do not have the correct score
					if (JOptionPane.showConfirmDialog(pop,"You did not roll this set, do you want to take a scratch?", "Scratch",  JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION )//if they press yes
					{
						fives.setEnabled(false);//button cannot be pressed again
						disabled++;
						Player2.setForeground(Color.red);
						Player1.setForeground(Color.black);
						P1Turn=false;
						FullRoll();

					}
				}

				//Updates their score with the amount of dice they rolled
				else//they want the 5s as their score
				{
					for (int i = 0; i < 5; i++)
					{
						if (DiceRan[i] == 5)
						{
							fivesS +=1;
						}
					}
					fivesS *=5;
					fives.setText("Fives: " + fivesS);
					Player2.setForeground(Color.red);
					Player1.setForeground(Color.black);
					fives.setEnabled(false);//button cannot be pressed again
					disabled++;
					P1Turn=false;
					FullRoll();
				}
				bonusScore1();
				SettingScore1();

			}
			Ender();
		}
	}

	private class ButtonPushSix implements ActionListener
	{
		public void actionPerformed (ActionEvent even)
		{
			if(P1Turn==true)
			{
				if (DiceRolled.DiceRolled6s () == 0)//User has not scratched yet and no 6s have been rolled
				{
					//Creates a PopUp Window that insures the user wants to receive a 0 if they do not have the correct score
					if (JOptionPane.showConfirmDialog(pop,"You did not roll this set, do you want to take a scratch?", "Scratch",  JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION )//if they press yes
					{
						sixes.setEnabled(false);//button cannot be pressed again
						disabled++;
						Player2.setForeground(Color.red);
						Player1.setForeground(Color.black);
						P1Turn=false;
						FullRoll();

					}
				}

				//Updates their score with the amount of dice they rolled
				else//they want the 6s as their score
				{
					for (int i = 0; i < 5; i++)
					{
						if (DiceRan[i] == 6)
						{
							sixesS +=1;
						}
					}
					sixesS *=6;
					sixes.setText("Sixes: " + sixesS);
					Player2.setForeground(Color.red);
					Player1.setForeground(Color.black);
					sixes.setEnabled(false);//button cannot be pressed again
					disabled++;
					P1Turn=false;
					FullRoll();
				}
				bonusScore1();
				SettingScore1();

			}
			Ender();
		}
	}

	private class ButtonPush3K implements ActionListener//three of the same pair
	{
		public void actionPerformed (ActionEvent even)
		{
			if(P1Turn==true)
			{
				if	((DiceRolled.DiceRolled1s () <3 && DiceRolled.DiceRolled2s () < 3 && DiceRolled.DiceRolled3s () <3 && DiceRolled.DiceRolled4s () <3 && DiceRolled.DiceRolled5s () <3 && DiceRolled.DiceRolled6s () <3))//User has already scratched
				{
					//Creates a PopUp Window that insures the user wants to receive a 0 if they do not have the correct score
					if (JOptionPane.showConfirmDialog(pop,"You did not roll this set, do you want to take a scratch?", "Scratch",  JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION )//if they press yes
					{
						threeKind.setEnabled(false);//button cannot be pressed again
						disabled++;
						Player2.setForeground(Color.red);
						Player1.setForeground(Color.black);
						P1Turn=false;
						FullRoll();

					}

				}
				else
					if (DiceRolled.DiceRolled1s () > 2 || DiceRolled.DiceRolled2s () > 2 || DiceRolled.DiceRolled3s ()> 2 || DiceRolled.DiceRolled4s () > 2 || DiceRolled.DiceRolled5s () > 2 || DiceRolled.DiceRolled6s () > 2)//they want the three of a kind as their score
					{
						for (int i = 0; i < 5; i ++)
						{
							threeKindS += DiceRan[i];
						}

						threeKind.setText("3 of a Kind: " + threeKindS);
						Player2.setForeground(Color.red);
						Player1.setForeground(Color.black);
						threeKind.setEnabled(false);//button cannot be pressed again
						disabled++;
						P1Turn=false;
						FullRoll();
					}
				SettingScore1();
			}
			Ender();
		}
	}

	private class ButtonPush4K implements ActionListener//four of the same pair
	{
		public void actionPerformed (ActionEvent even)
		{
			if(P1Turn==true)
			{
				if	(DiceRolled.DiceRolled1s () < 4 && DiceRolled.DiceRolled2s () < 4 && DiceRolled.DiceRolled3s () < 4 && DiceRolled.DiceRolled4s () < 4 && DiceRolled.DiceRolled5s () < 4 && DiceRolled.DiceRolled6s () < 4)//User has already scratched
				{
					//Creates a PopUp Window that insures the user wants to receive a 0 if they do not have the correct score
					if (JOptionPane.showConfirmDialog(pop,"You did not roll this set, do you want to take a scratch?", "Scratch",  JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION )//if they press yes
					{
						fourKind.setEnabled(false);//button cannot be pressed again
						disabled++;
						Player2.setForeground(Color.red);
						Player1.setForeground(Color.black);
						P1Turn=false;
						FullRoll();

					}

				}
				else
					if (DiceRolled.DiceRolled1s () > 3 || DiceRolled.DiceRolled2s () > 3 || DiceRolled.DiceRolled3s () > 3 || DiceRolled.DiceRolled4s () > 3 || DiceRolled.DiceRolled5s () > 3 || DiceRolled.DiceRolled6s () > 3)//they want the three of a kind as their score
					{

						for (int i = 0; i < 5; i ++)
						{
							fourKindS += DiceRan[i];
						}
						fourKind.setText("4 of a Kind: " + fourKindS);
						Player2.setForeground(Color.red);
						Player1.setForeground(Color.black);
						fourKind.setEnabled(false);//button cannot be pressed again
						disabled++;
						P1Turn=false;
						FullRoll();
					}
				SettingScore1();
			}
			Ender();
		}
	}

	private class ButtonPushSS implements ActionListener//sequence of 4
	{
		public void actionPerformed (ActionEvent even)
		{
			if(P1Turn==true)
			{
				//Updates their score with the amount of dice they rolled
				if (!(((DiceRolled.DiceRolled1s () == 1 || DiceRolled.DiceRolled1s () == 2) && (DiceRolled.DiceRolled2s () == 1 || DiceRolled.DiceRolled2s () == 2) && (DiceRolled.DiceRolled3s () == 1 || DiceRolled.DiceRolled3s () == 2) && (DiceRolled.DiceRolled4s () == 1 || DiceRolled.DiceRolled4s () == 2)) || ((DiceRolled.DiceRolled2s () == 1 || DiceRolled.DiceRolled2s () == 2) && (DiceRolled.DiceRolled3s () == 1 || DiceRolled.DiceRolled3s () == 2) && (DiceRolled.DiceRolled4s () == 1 || DiceRolled.DiceRolled4s () == 2) && (DiceRolled.DiceRolled5s () == 1 || DiceRolled.DiceRolled5s () == 2)) || ((DiceRolled.DiceRolled3s () == 1 || DiceRolled.DiceRolled3s () == 2) && (DiceRolled.DiceRolled4s () == 1 || DiceRolled.DiceRolled4s () == 2) && (DiceRolled.DiceRolled5s () == 1 || DiceRolled.DiceRolled5s () == 2) && (DiceRolled.DiceRolled6s () == 1 || DiceRolled.DiceRolled6s () == 2))))//User has already scratched
				{
					//Creates a PopUp Window that insures the user wants to receive a 0 if they do not have the correct score
					if (JOptionPane.showConfirmDialog(pop,"You did not roll this set, do you want to take a scratch?", "Scratch",  JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION )//if they press yes
					{
						smallStraight.setEnabled(false);//button cannot be pressed again
						disabled++;
						Player2.setForeground(Color.red);
						Player1.setForeground(Color.black);
						P1Turn=false;
						FullRoll();

					}

				}
				else
					if (((DiceRolled.DiceRolled1s () == 1 || DiceRolled.DiceRolled1s () == 2) && (DiceRolled.DiceRolled2s () == 1 || DiceRolled.DiceRolled2s () == 2) && (DiceRolled.DiceRolled3s () == 1 || DiceRolled.DiceRolled3s () == 2) && (DiceRolled.DiceRolled4s () == 1 || DiceRolled.DiceRolled4s () == 2)) || ((DiceRolled.DiceRolled2s () == 1 || DiceRolled.DiceRolled2s () == 2) && (DiceRolled.DiceRolled3s () == 1 || DiceRolled.DiceRolled3s () == 2) && (DiceRolled.DiceRolled4s () == 1 || DiceRolled.DiceRolled4s () == 2) && (DiceRolled.DiceRolled5s () == 1 || DiceRolled.DiceRolled5s () == 2)) || ((DiceRolled.DiceRolled3s () == 1 || DiceRolled.DiceRolled3s () == 2) && (DiceRolled.DiceRolled4s () == 1 || DiceRolled.DiceRolled4s () == 2) && (DiceRolled.DiceRolled5s () == 1 || DiceRolled.DiceRolled5s () == 2) && (DiceRolled.DiceRolled6s () == 1 || DiceRolled.DiceRolled6s () == 2))) //they want the three of a kind as their score
					{

						smallStraightS +=30;
						smallStraight.setText("Small Straight: " + smallStraightS);
						smallStraight.setEnabled(false);//button cannot be pressed again
						disabled++;
						Player2.setForeground(Color.red);
						Player1.setForeground(Color.black);
						P1Turn=false;
						FullRoll();
					}
				SettingScore1();
			}
			Ender();
		}
	}

	private class ButtonPushLS implements ActionListener//sequence of 5
	{
		public void actionPerformed (ActionEvent even)
		{
			if(P1Turn==true)
			{
				//Updates their score with the amount of dice they rolled
				if (!(((DiceRolled.DiceRolled1s () == 1 || DiceRolled.DiceRolled1s () == 2) && (DiceRolled.DiceRolled2s () == 1 || DiceRolled.DiceRolled2s () == 2) && (DiceRolled.DiceRolled3s () == 1 || DiceRolled.DiceRolled3s () == 2) && (DiceRolled.DiceRolled4s () == 1 || DiceRolled.DiceRolled4s () == 2) && (DiceRolled.DiceRolled5s () == 1 || DiceRolled.DiceRolled5s () == 2)) || ((DiceRolled.DiceRolled2s () == 1 || DiceRolled.DiceRolled2s () == 2) && (DiceRolled.DiceRolled3s () == 1 || DiceRolled.DiceRolled3s () == 2) && (DiceRolled.DiceRolled4s () == 1 || DiceRolled.DiceRolled4s () == 2) && (DiceRolled.DiceRolled5s () == 1 || DiceRolled.DiceRolled5s () == 2) && (DiceRolled.DiceRolled6s () == 1 || DiceRolled.DiceRolled6s () == 2))) )//User has already scratched
				{
					//Creates a PopUp Window that insures the user wants to receive a 0 if they do not have the correct score
					if (JOptionPane.showConfirmDialog(pop,"You did not roll this set, do you want to take a scratch?", "Scratch",  JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION )//if they press yes
					{
						largeStraight.setEnabled(false);//button cannot be pressed again
						disabled++;
						Player2.setForeground(Color.red);
						Player1.setForeground(Color.black);
						P1Turn=false;
						FullRoll();

					}

				}
				else
					if (((DiceRolled.DiceRolled1s () == 1 || DiceRolled.DiceRolled1s () == 2) && (DiceRolled.DiceRolled2s () == 1 || DiceRolled.DiceRolled2s () == 2) && (DiceRolled.DiceRolled3s () == 1 || DiceRolled.DiceRolled3s () == 2) && (DiceRolled.DiceRolled4s () == 1 || DiceRolled.DiceRolled4s () == 2) && (DiceRolled.DiceRolled5s () == 1 || DiceRolled.DiceRolled5s () == 2)) || ((DiceRolled.DiceRolled2s () == 1 || DiceRolled.DiceRolled2s () == 2) && (DiceRolled.DiceRolled3s () == 1 || DiceRolled.DiceRolled3s () == 2) && (DiceRolled.DiceRolled4s () == 1 || DiceRolled.DiceRolled4s () == 2) && (DiceRolled.DiceRolled5s () == 1 || DiceRolled.DiceRolled5s () == 2) && (DiceRolled.DiceRolled6s () == 1 || DiceRolled.DiceRolled6s () == 2))) //they want the three of a kind as their score
					{

						largeStraightS +=40;
						largeStraight.setText("Large Straight: " + largeStraightS);
						Player2.setForeground(Color.red);
						Player1.setForeground(Color.black);
						largeStraight.setEnabled(false);//button cannot be pressed again
						disabled++;
						P1Turn=false;
						FullRoll();
					}
				SettingScore1();
			}
			Ender();
		}
	}

	private class ButtonPushFH implements ActionListener
	{
		public void actionPerformed (ActionEvent even)//3 pairs and 2 pairs
		{
			if(P1Turn==true)
			{
				if (!((DiceRolled.DiceRolled1s () > 2 || DiceRolled.DiceRolled2s () > 2 || DiceRolled.DiceRolled3s () > 2 || DiceRolled.DiceRolled4s () > 2 || DiceRolled.DiceRolled5s () > 2 || DiceRolled.DiceRolled6s () > 2) &&  (DiceRolled.DiceRolled1s () == 2 || DiceRolled.DiceRolled2s () == 2 || DiceRolled.DiceRolled3s () == 2 || DiceRolled.DiceRolled4s () == 2 || DiceRolled.DiceRolled5s () == 2 || DiceRolled.DiceRolled6s () == 2)))//User has already scratched
				{
					//Creates a PopUp Window that insures the user wants to receive a 0 if they do not have the correct score
					if (JOptionPane.showConfirmDialog(pop,"You did not roll this set, do you want to take a scratch?", "Scratch",  JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION )//if they press yes
					{
						fullHouse.setEnabled(false);//button cannot be pressed again
						disabled++;
						Player2.setForeground(Color.red);
						Player1.setForeground(Color.black);
						P1Turn=false;
						FullRoll();

					}

				}
				else //they want the full house as their score
					if ((DiceRolled.DiceRolled1s () > 2 || DiceRolled.DiceRolled2s () > 2 || DiceRolled.DiceRolled3s () > 2 || DiceRolled.DiceRolled4s () > 2 || DiceRolled.DiceRolled5s () > 2 || DiceRolled.DiceRolled6s () > 2) &&  (DiceRolled.DiceRolled1s () == 2 || DiceRolled.DiceRolled2s () == 2 || DiceRolled.DiceRolled3s () == 2 || DiceRolled.DiceRolled4s () == 2 || DiceRolled.DiceRolled5s () == 2 || DiceRolled.DiceRolled6s () == 2))//they want the three of a kind as their score
					{


						fullHouseS += 25;
						fullHouse.setText("Full House: " + fullHouseS);
						Player2.setForeground(Color.red);
						Player1.setForeground(Color.black);
						fullHouse.setEnabled(false);//button cannot be pressed again
						disabled++;
						P1Turn=false;
						FullRoll();
					}
				SettingScore1();
			}
			Ender();
		}
	}

	private class ButtonPushY implements ActionListener//5 pairs
	{
		public void actionPerformed (ActionEvent even)
		{
			if(P1Turn==true)
			{
				//Updates their score with the amount of dice they rolled
				if (!(DiceRolled.DiceRolled1s () == 5 || DiceRolled.DiceRolled2s () == 5 || DiceRolled.DiceRolled3s () == 5 || DiceRolled.DiceRolled4s () == 5 || DiceRolled.DiceRolled5s () == 5 || DiceRolled.DiceRolled6s () == 5))//User has already scratched
				{
					//Creates a PopUp Window that insures the user wants to receive a 0 if they do not have the correct score
					if (JOptionPane.showConfirmDialog(pop,"You did not roll this set, do you want to take a scratch?", "Scratch",  JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION )//if they press yes
					{
						Yahtzee.setEnabled(false);//button cannot be pressed again
						disabled++;
						Player2.setForeground(Color.red);
						Player1.setForeground(Color.black);
						P1Turn=false;
						FullRoll();

					}

				}
				else if (DiceRolled.DiceRolled1s () == 5 || DiceRolled.DiceRolled2s () == 5 || DiceRolled.DiceRolled3s () == 5 || DiceRolled.DiceRolled4s () == 5 || DiceRolled.DiceRolled5s () == 5 || DiceRolled.DiceRolled6s () == 5)//they want the y as their score
				{
					YahtzeeS +=50;
					//Yahtzee.setEnabled(false);//button cannot be pressed again
					YahtzeeS += (Y1Counter * 100);
					Yahtzee.setText("Yahtzee: " + YahtzeeS);
					Y1Counter++;
					SettingScore1();
					Player2.setForeground(Color.red);
					Player1.setForeground(Color.black);
					P1Turn=false;
					FullRoll();
				}

			}
			Ender();
		}

	}


	private class ButtonPushC implements ActionListener//however much they rolled
	{
		public void actionPerformed (ActionEvent even)
		{
			if(P1Turn==true)
			{
				//Creates a PopUp Window that insures the user wants to receive a 0 if they do not have the correct score
				if (JOptionPane.showConfirmDialog(pop,"Do you want to take the score you rolled?", "Chance",  JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION )//if they press yes
				{
					for (int i = 0; i < 5; i ++)
					{
						ChanceS += DiceRan[i];
					}
					Chance.setText("Chance: " + ChanceS);
					Chance.setEnabled(false);//button cannot be pressed again
					disabled++;
					Player2.setForeground(Color.red);
					Player1.setForeground(Color.black);
					P1Turn=false;
					FullRoll();

				}
				else
				{
					/*
	Player2.setForeground(Color.red);
	Player1.setForeground(Color.black);
	Chance.setEnabled(false);//button cannot be pressed again
	P1Turn=false;
	FullRoll();
					 */
				}
				SettingScore1();
			}
			Ender();
		}
	}

	//Player 2
	private class ButtonPushAce2 implements ActionListener
	{
		public void actionPerformed (ActionEvent even)
		{
			if(P1Turn==false)
			{
				if (DiceRolled.DiceRolled1s () == 0)//User has not scratched yet and no 1s have been rolled
				{
					//Creates a PopUp Window that insures the user wants to receive a 0 if they do not have the correct score
					if (JOptionPane.showConfirmDialog(pop,"You did not roll this set, do you want to take a scratch?", "Scratch",  JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION )//if they press yes
					{
						aces2.setEnabled(false);//button cannot be pressed again
						disabled++;
						Player1.setForeground(Color.red);
						Player2.setForeground(Color.black);
						P1Turn=true;
						FullRoll();
					}
				}
				else//they want the 1s as their score
				{


					for (int i = 0;i < 5; i++)
					{
						if (DiceRan[i] == 1)
						{
							acesS2 +=1;
						}
					}
					aces2.setText("Aces: " + acesS2);
					Player1.setForeground(Color.red);
					Player2.setForeground(Color.black);
					aces2.setEnabled(false);//button cannot be pressed again
					disabled++;
					P1Turn=true;
					FullRoll();
				}
				bonusScore2();
				SettingScore2();

			}
			Ender();
		}
	}

	private class ButtonPushTwo2 implements ActionListener
	{
		public void actionPerformed (ActionEvent even)
		{
			if(P1Turn==false)
			{
				if (DiceRolled.DiceRolled2s () == 0)//User has not scratched yet and no 2s have been rolled
				{
					//Creates a PopUp Window that insures the user wants to receive a 0 if they do not have the correct score
					if (JOptionPane.showConfirmDialog(pop,"You did not roll this set, do you want to take a scratch?", "Scratch",  JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION )//if they press yes
					{
						twos2.setEnabled(false);//button cannot be pressed again
						disabled++;
						Player1.setForeground(Color.red);
						Player2.setForeground(Color.black);
						P1Turn=true;
						FullRoll();

					}
				}
				else//they want the 2s as their score
				{


					for (int i = 0; i < 5; i++)
					{
						if (DiceRan[i] == 2)
						{
							twosS2 +=1;
						}
					}
					twosS2 *=2;
					twos2.setText("Twos: " + twosS2);
					Player1.setForeground(Color.red);
					Player2.setForeground(Color.black);
					twos2.setEnabled(false);//button cannot be pressed again
					disabled++;
					P1Turn=true;
					FullRoll();
				}
				bonusScore2();
				SettingScore2();

			}
			Ender();
		}
	}

	private class ButtonPushThree2 implements ActionListener
	{
		public void actionPerformed (ActionEvent even)
		{
			if(P1Turn==false)
			{
				if (DiceRolled.DiceRolled3s () == 0)//User has not scratched yet and no 3s have been rolled
				{
					//Creates a PopUp Window that insures the user wants to receive a 0 if they do not have the correct score
					if (JOptionPane.showConfirmDialog(pop,"You did not roll this set, do you want to take a scratch in Chance?", "Scratch",  JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION )//if they press yes
					{
						threes2.setEnabled(false);//button cannot be pressed again
						disabled++;
						Player1.setForeground(Color.red);
						Player2.setForeground(Color.black);
						P1Turn=true;
						FullRoll();

					}
				}
				else//they want the 3s as their score
				{
					for (int i = 0; i < 5; i++)
					{
						if (DiceRan[i] == 3)
						{
							threesS2 +=1;
						}
					}
					threesS2 *=3;
					threes2.setText("Threes: " + threesS2);
					Player1.setForeground(Color.red);
					Player2.setForeground(Color.black);
					threes2.setEnabled(false);//button cannot be pressed again
					disabled++;
					P1Turn=true;
					FullRoll();
				}
				bonusScore2();
				SettingScore2();
			}
			Ender();

		}
	}

	private class ButtonPushFour2 implements ActionListener
	{
		public void actionPerformed (ActionEvent even)
		{
			if(P1Turn==false)
			{
				if (DiceRolled.DiceRolled4s () == 0)//User has not scratched yet and no 4s have been rolled
				{
					//Creates a PopUp Window that insures the user wants to receive a 0 if they do not have the correct score
					if (JOptionPane.showConfirmDialog(pop,"You did not roll this set, do you want to take a scratch?", "Scratch",  JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION )//if they press yes
					{
						fours2.setEnabled(false);//button cannot be pressed again
						disabled++;
						Player1.setForeground(Color.red);
						Player2.setForeground(Color.black);
						P1Turn=true;
						FullRoll();

					}
				}
				else//they want the 4s as their score
				{


					for (int i = 0; i < 5; i++)
					{
						if (DiceRan[i] == 4)
						{
							foursS2 +=1;
						}
					}
					foursS2 *=4;
					fours2.setText("Fours: " + foursS2);
					Player1.setForeground(Color.red);
					Player2.setForeground(Color.black);
					fours2.setEnabled(false);//button cannot be pressed again
					disabled++;
					P1Turn=true;
					FullRoll();
				}
				bonusScore2();
				SettingScore2();
			}
			Ender();
		}
	}

	private class ButtonPushFive2 implements ActionListener
	{
		public void actionPerformed (ActionEvent even)
		{
			if(P1Turn==false)
			{
				if (DiceRolled.DiceRolled5s () == 0)//User has not scratched yet and no 5s have been rolled
				{
					//Creates a PopUp Window that insures the user wants to receive a 0 if they do not have the correct score
					if (JOptionPane.showConfirmDialog(pop,"You did not roll this set, do you want to take a scratch?", "Scratch",  JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION )//if they press yes
					{
						fives2.setEnabled(false);//button cannot be pressed again
						disabled++;
						Player1.setForeground(Color.red);
						Player2.setForeground(Color.black);
						P1Turn=true;
						FullRoll();

					}
				}
				else//they want the 5s as their score
				{


					for (int i = 0; i < 5; i++)
					{
						if (DiceRan[i] == 5)
						{
							fivesS2 +=1;
						}
					}
					fivesS2 *=5;
					fives2.setText("Fives: " + fivesS2);
					Player1.setForeground(Color.red);
					Player2.setForeground(Color.black);
					fives2.setEnabled(false);//button cannot be pressed again
					disabled++;
					P1Turn=true;
					FullRoll();
				}
				bonusScore2();
				SettingScore2();
			}
			Ender();
		}
	}

	private class ButtonPushSix2 implements ActionListener
	{
		public void actionPerformed (ActionEvent even)
		{
			if(P1Turn==false)
			{
				if (DiceRolled.DiceRolled6s () == 0)//User has not scratched yet and no 6s have been rolled
				{
					//Creates a PopUp Window that insures the user wants to receive a 0 if they do not have the correct score
					if (JOptionPane.showConfirmDialog(pop,"You did not roll this set, do you want to take a scratch?", "Scratch",  JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION )//if they press yes
					{
						sixes2.setEnabled(false);//button cannot be pressed again
						disabled++;
						Player1.setForeground(Color.red);
						Player2.setForeground(Color.black);
						P1Turn=true;
						FullRoll();

					}
				}
				else//they want the 6s as their score
				{


					for (int i = 0; i < 5; i++)
					{
						if (DiceRan[i] == 6)
						{
							sixesS2 +=1;
						}
					}
					sixesS2 *=6;
					sixes2.setText("Sixes: " + sixesS2);
					Player1.setForeground(Color.red);
					Player2.setForeground(Color.black);
					sixes2.setEnabled(false);//button cannot be pressed again
					disabled++;
					P1Turn=true;
					FullRoll();
				}
				bonusScore2();
				SettingScore2();
			}
			Ender();
		}
	}

	private class ButtonPush3K2 implements ActionListener
	{
		public void actionPerformed (ActionEvent even)
		{
			if(P1Turn==false)
			{
				if	(DiceRolled.DiceRolled1s () <3 && DiceRolled.DiceRolled2s () < 3 && DiceRolled.DiceRolled3s () <3 && DiceRolled.DiceRolled4s () <3 && DiceRolled.DiceRolled5s () <3 && DiceRolled.DiceRolled6s () <3)//User has already scratched
				{//Creates a PopUp Window that insures the user wants to receive a 0 if they do not have the correct score
					if (JOptionPane.showConfirmDialog(pop,"You did not roll this set, do you want to take a scratch?", "Scratch",  JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION )//if they press yes
					{
						threeKind2.setEnabled(false);//button cannot be pressed again
						disabled++;
						Player1.setForeground(Color.red);
						Player2.setForeground(Color.black);
						P1Turn=true;
						FullRoll();

					}

				}
				else
					if (DiceRolled.DiceRolled1s () > 2 || DiceRolled.DiceRolled2s () > 2 || DiceRolled.DiceRolled3s () > 2 || DiceRolled.DiceRolled4s () > 2 || DiceRolled.DiceRolled5s () > 2 || DiceRolled.DiceRolled6s () > 2)//they want the three of a kind as their score
					{
						for (int i = 0; i < 5; i ++)
						{
							threeKindS2 += DiceRan[i];
						}

						threeKind2.setText("3 of a Kind: " + threeKindS2);
						Player1.setForeground(Color.red);
						Player2.setForeground(Color.black);
						threeKind2.setEnabled(false);//button cannot be pressed again
						disabled++;
						P1Turn=true;
						FullRoll();
					}
				SettingScore2();
			}
			Ender();
		}
	}

	private class ButtonPush4K2 implements ActionListener
	{
		public void actionPerformed (ActionEvent even)
		{
			if(P1Turn==false)
			{
				if	(DiceRolled.DiceRolled1s () < 4 && DiceRolled.DiceRolled2s () < 4 && DiceRolled.DiceRolled3s () < 4 && DiceRolled.DiceRolled4s () < 4 && DiceRolled.DiceRolled5s () < 4 && DiceRolled.DiceRolled6s () < 4)//User has already scratched
				{
					//Creates a PopUp Window that insures the user wants to receive a 0 if they do not have the correct score
					if (JOptionPane.showConfirmDialog(pop,"You did not roll this set, do you want to take a scratch?", "Scratch",  JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION )//if they press yes
					{
						fourKind2.setEnabled(false);//button cannot be pressed again
						disabled++;
						Player1.setForeground(Color.red);
						Player2.setForeground(Color.black);
						P1Turn=true;
						FullRoll();

					}
				}
				else
					if (DiceRolled.DiceRolled1s () > 3 || DiceRolled.DiceRolled2s () > 3 || DiceRolled.DiceRolled3s () > 3 || DiceRolled.DiceRolled4s () > 3 || DiceRolled.DiceRolled5s () > 3 || DiceRolled.DiceRolled6s () > 3)//they want the three of a kind as their score
					{

						for (int i = 0; i < 5; i ++)
						{
							fourKindS2 += DiceRan[i];
						}
						fourKind2.setText("4 of a Kind: " + fourKindS2);
						Player1.setForeground(Color.red);
						Player2.setForeground(Color.black);
						fourKind2.setEnabled(false);//button cannot be pressed again
						disabled++;
						P1Turn=true;
						FullRoll();
					}
				SettingScore2();
			}
			Ender();
		}
	}

	private class ButtonPushSS2 implements ActionListener
	{
		public void actionPerformed (ActionEvent even)
		{
			if(P1Turn==false)
			{
				//Updates their score with the amount of dice they rolled
				if (!(((DiceRolled.DiceRolled1s () == 1 || DiceRolled.DiceRolled1s () == 2) && (DiceRolled.DiceRolled2s () == 1 || DiceRolled.DiceRolled2s () == 2) && (DiceRolled.DiceRolled3s () == 1 || DiceRolled.DiceRolled3s () == 2) && (DiceRolled.DiceRolled4s () == 1 || DiceRolled.DiceRolled4s () == 2)) || ((DiceRolled.DiceRolled2s () == 1 || DiceRolled.DiceRolled2s () == 2) && (DiceRolled.DiceRolled3s () == 1 || DiceRolled.DiceRolled3s () == 2) && (DiceRolled.DiceRolled4s () == 1 || DiceRolled.DiceRolled4s () == 2) && (DiceRolled.DiceRolled5s () == 1 || DiceRolled.DiceRolled5s () == 2)) || ((DiceRolled.DiceRolled3s () == 1 || DiceRolled.DiceRolled3s () == 2) && (DiceRolled.DiceRolled4s () == 1 || DiceRolled.DiceRolled4s () == 2) && (DiceRolled.DiceRolled5s () == 1 || DiceRolled.DiceRolled5s () == 2) && (DiceRolled.DiceRolled6s () == 1 || DiceRolled.DiceRolled6s () == 2))))//User has already scratched
				{
					//Creates a PopUp Window that insures the user wants to receive a 0 if they do not have the correct score
					if (JOptionPane.showConfirmDialog(pop,"You did not roll this set, do you want to take a scratch?", "Scratch",  JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION )//if they press yes
					{
						smallStraight2.setEnabled(false);//button cannot be pressed again
						disabled++;
						Player1.setForeground(Color.red);
						Player2.setForeground(Color.black);
						P1Turn=true;
						FullRoll();

					}

				}
				else
					if (((DiceRolled.DiceRolled1s () == 1 || DiceRolled.DiceRolled1s () == 2) && (DiceRolled.DiceRolled2s () == 1 || DiceRolled.DiceRolled2s () == 2) && (DiceRolled.DiceRolled3s () == 1 || DiceRolled.DiceRolled3s () == 2) && (DiceRolled.DiceRolled4s () == 1 || DiceRolled.DiceRolled4s () == 2)) || ((DiceRolled.DiceRolled2s () == 1 || DiceRolled.DiceRolled2s () == 2) && (DiceRolled.DiceRolled3s () == 1 || DiceRolled.DiceRolled3s () == 2) && (DiceRolled.DiceRolled4s () == 1 || DiceRolled.DiceRolled4s () == 2) && (DiceRolled.DiceRolled5s () == 1 || DiceRolled.DiceRolled5s () == 2)) || ((DiceRolled.DiceRolled3s () == 1 || DiceRolled.DiceRolled3s () == 2) && (DiceRolled.DiceRolled4s () == 1 || DiceRolled.DiceRolled4s () == 2) && (DiceRolled.DiceRolled5s () == 1 || DiceRolled.DiceRolled5s () == 2) && (DiceRolled.DiceRolled6s () == 1 || DiceRolled.DiceRolled6s () == 2))) //they want the three of a kind as their score
					{

						smallStraightS2 +=30;
						smallStraight2.setText("Small Straight: " + smallStraightS2);
						Player1.setForeground(Color.red);
						Player2.setForeground(Color.black);
						smallStraight2.setEnabled(false);//button cannot be pressed again
						disabled++;
						P1Turn=true;
						FullRoll();
					}
				SettingScore2();
			}
			Ender();
		}
	}

	private class ButtonPushLS2 implements ActionListener
	{
		public void actionPerformed (ActionEvent even)
		{
			if(P1Turn==false)
			{
				//Updates their score with the amount of dice they rolled
				if (!(((DiceRolled.DiceRolled1s () == 1 || DiceRolled.DiceRolled1s () == 2) && (DiceRolled.DiceRolled2s () == 1 || DiceRolled.DiceRolled2s () == 2) && (DiceRolled.DiceRolled3s () == 1 || DiceRolled.DiceRolled3s () == 2) && (DiceRolled.DiceRolled4s () == 1 || DiceRolled.DiceRolled4s () == 2) && (DiceRolled.DiceRolled5s () == 1 || DiceRolled.DiceRolled5s () == 2)) || ((DiceRolled.DiceRolled2s () == 1 || DiceRolled.DiceRolled2s () == 2) && (DiceRolled.DiceRolled3s () == 1 || DiceRolled.DiceRolled3s () == 2) && (DiceRolled.DiceRolled4s () == 1 || DiceRolled.DiceRolled4s () == 2) && (DiceRolled.DiceRolled5s () == 1 || DiceRolled.DiceRolled5s () == 2) && (DiceRolled.DiceRolled6s () == 1 || DiceRolled.DiceRolled6s () == 2))) )//User has already scratched
				{
					//Creates a PopUp Window that insures the user wants to receive a 0 if they do not have the correct score
					if (JOptionPane.showConfirmDialog(pop,"You did not roll this set, do you want to take a scratch?", "Scratch",  JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION )//if they press yes
					{
						largeStraight2.setEnabled(false);//button cannot be pressed again
						disabled++;
						Player1.setForeground(Color.red);
						Player2.setForeground(Color.black);
						P1Turn=true;
						FullRoll();

					}

				}
				else
					if (((DiceRolled.DiceRolled1s () == 1 || DiceRolled.DiceRolled1s () == 2) && (DiceRolled.DiceRolled2s () == 1 || DiceRolled.DiceRolled2s () == 2) && (DiceRolled.DiceRolled3s () == 1 || DiceRolled.DiceRolled3s () == 2) && (DiceRolled.DiceRolled4s () == 1 || DiceRolled.DiceRolled4s () == 2) && (DiceRolled.DiceRolled5s () == 1 || DiceRolled.DiceRolled5s () == 2)) || ((DiceRolled.DiceRolled2s () == 1 || DiceRolled.DiceRolled2s () == 2) && (DiceRolled.DiceRolled3s () == 1 || DiceRolled.DiceRolled3s () == 2) && (DiceRolled.DiceRolled4s () == 1 || DiceRolled.DiceRolled4s () == 2) && (DiceRolled.DiceRolled5s () == 1 || DiceRolled.DiceRolled5s () == 2) && (DiceRolled.DiceRolled6s () == 1 || DiceRolled.DiceRolled6s () == 2))) //they want the three of a kind as their score
					{

						largeStraightS2 +=40;
						largeStraight2.setText("Large Straight: " + largeStraightS2);
						Player1.setForeground(Color.red);
						Player2.setForeground(Color.black);
						largeStraight2.setEnabled(false);//button cannot be pressed again
						disabled++;
						P1Turn=true;
						FullRoll();
					}
				SettingScore2();
			}
			Ender();
		}
	}

	private class ButtonPushFH2 implements ActionListener
	{
		public void actionPerformed (ActionEvent even)
		{
			if(P1Turn==false)
			{
				if (!((DiceRolled.DiceRolled1s () > 2 || DiceRolled.DiceRolled2s () > 2 || DiceRolled.DiceRolled3s () > 2 || DiceRolled.DiceRolled4s () > 2 || DiceRolled.DiceRolled5s () > 2 || DiceRolled.DiceRolled6s () > 2) &&  (DiceRolled.DiceRolled1s () == 2 || DiceRolled.DiceRolled2s () == 2 || DiceRolled.DiceRolled3s () == 2 || DiceRolled.DiceRolled4s () == 2 || DiceRolled.DiceRolled5s () == 2 || DiceRolled.DiceRolled6s () == 2)))//User has already scratched
				{
					//Creates a PopUp Window that insures the user wants to receive a 0 if they do not have the correct score
					if (JOptionPane.showConfirmDialog(pop,"You did not roll this set, do you want to take a scratch?", "Scratch",  JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION )//if they press yes
					{
						fullHouse2.setEnabled(false);//button cannot be pressed again
						disabled++;
						Player1.setForeground(Color.red);
						Player2.setForeground(Color.black);
						P1Turn=true;
						FullRoll();

					}

				}
				else //they want the full house as their score
					if ((DiceRolled.DiceRolled1s () > 2 || DiceRolled.DiceRolled2s () > 2 || DiceRolled.DiceRolled3s () > 2 || DiceRolled.DiceRolled4s () > 2 || DiceRolled.DiceRolled5s () > 2 || DiceRolled.DiceRolled6s () > 2) &&  (DiceRolled.DiceRolled1s () == 2 || DiceRolled.DiceRolled2s () == 2 || DiceRolled.DiceRolled3s () == 2 || DiceRolled.DiceRolled4s () == 2 || DiceRolled.DiceRolled5s () == 2 || DiceRolled.DiceRolled6s () == 2))//they want the three of a kind as their score
					{
						fullHouseS2 += 25;
						fullHouse2.setText("Full House: " + fullHouseS2);
						Player1.setForeground(Color.red);
						Player2.setForeground(Color.black);
						fullHouse2.setEnabled(false);//button cannot be pressed again
						disabled++;
						P1Turn=true;
						FullRoll();
					}
				SettingScore2();
			}
			Ender();
		}
	}

	private class ButtonPushY2 implements ActionListener
	{
		public void actionPerformed (ActionEvent even)
		{
			if(P1Turn==false)
			{
				if (!(DiceRolled.DiceRolled1s () == 5 || DiceRolled.DiceRolled2s () == 5 || DiceRolled.DiceRolled3s () == 5 || DiceRolled.DiceRolled4s () == 5 || DiceRolled.DiceRolled5s () == 5 || DiceRolled.DiceRolled6s () == 5))//User has already scratched
				{
					//Creates a PopUp Window that insures the user wants to receive a 0 if they do not have the correct score
					if (JOptionPane.showConfirmDialog(pop,"You did not roll this set, do you want to take a scratch?", "Scratch",  JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION )//if they press yes
					{
						Yahtzee2.setEnabled(false);//button cannot be pressed again
						disabled++;
						Player1.setForeground(Color.red);
						Player2.setForeground(Color.black);
						P1Turn=true;
						FullRoll();

					}

				}
				else if (DiceRolled.DiceRolled1s () == 5 || DiceRolled.DiceRolled2s () == 5 || DiceRolled.DiceRolled3s () == 5 || DiceRolled.DiceRolled4s () == 5 || DiceRolled.DiceRolled5s () == 5 || DiceRolled.DiceRolled6s () == 5)//they want the y as their score
				{
					YahtzeeS2 +=50;
					//Yahtzee2.setEnabled(false);//button cannot be pressed again
					YahtzeeS2 += (Y2Counter * 100);
					Yahtzee2.setText("Yahtzee: " + YahtzeeS2);
					Y2Counter++;
					SettingScore2();
					Player1.setForeground(Color.red);
					Player2.setForeground(Color.black);
					P1Turn=true;
					FullRoll();
				}
				SettingScore2();
			}
			Ender();
		}

	}
	private class ButtonPushC2 implements ActionListener
	{
		public void actionPerformed (ActionEvent even)
		{
			if(P1Turn==false)
			{
				//Creates a PopUp Window that insures the user wants to receive a 0 if they do not have the correct score
				if (JOptionPane.showConfirmDialog(pop,"Do you want to take the score you rolled?", "Chance",  JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION )//if they press yes
				{
					for (int i = 0; i < 5; i ++)
					{
						ChanceS2 += DiceRan[i];
					}
					Chance2.setText("Chance: " + ChanceS2);
					Chance2.setEnabled(false);//button cannot be pressed again
					disabled++;
					Player1.setForeground(Color.red);
					Player2.setForeground(Color.black);
					P1Turn=true;
					FullRoll();
				}
				else
				{
					/*
	Player1.setForeground(Color.red);
	Player2.setForeground(Color.black);
	Chance2.setEnabled(false);//button cannot be pressed again
	P1Turn=true;
	FullRoll();
					 */
				}
				SettingScore2();
			}
			Ender();
		}
	}
	//--------------------------------------------------------------------------------------------------------------------
	//--------------------------------------------------------------------------------------------------------------------
	//--------------------------------------------------------------------------------------------------------------------
	//--------------------------------------------------------------------------------------------------------------------
	private void FullRoll()//rerolls all the dice at the end of every turn for the next person
	{

		DiceRan[0]=(int)(Math.random()*6) + 1;
		for(int x=1; x<=6; x++)
		{
			if(DiceRan[0]==x)
			{
				D1.setIcon(Images[x-1]);
			}
		}
		DiceRan[1]=(int)(Math.random()*6) + 1;
		for(int x=1; x<=6; x++)
		{
			if(DiceRan[1]==x)
			{
				D2.setIcon(Images[x-1]);
			}
		}
		DiceRan[2]=(int)(Math.random()*6) + 1;
		for(int x=1; x<=6; x++)
		{
			if(DiceRan[2]==x)
			{
				D3.setIcon(Images[x-1]);
			}
		}
		DiceRan[3]=(int)(Math.random()*6) + 1;
		for(int x=1; x<=6; x++)
		{
			if(DiceRan[3]==x)
			{
				D4.setIcon(Images[x-1]);
			}
		}
		DiceRan[4]=(int)(Math.random()*6) + 1;
		for(int x=1; x<=6; x++)
		{
			if(DiceRan[4]==x)
			{
				D5.setIcon(Images[x-1]);
			}
		}
		Rolls=1;
		ReRoll.setText("ReRoll: " + Rolls);
	}
	//--------------------------------------------------------------------------------------------------------------------
	//--------------------------------------------------------------------------------------------------------------------
	//--------------------------------------------------------------------------------------------------------------------
	//--------------------------------------------------------------------------------------------------------------------

	//ToBeRolled----------------------------//creates an array for the dice that want to be rerolled.
	private int[] ToBeRolled = new int[5];
	{
		for(int x=0; x<5; x++)
		{
			ToBeRolled[x]=0;
		}
	}


	//Dice Listeners----------------------------
	private class Listener1 implements MouseListener
	{

		public void mouseClicked(MouseEvent arg0) 
		{
			if(D1.getBackground().equals(Color.WHITE))
			{
				D1.setBackground(Color.lightGray);
				ToBeRolled[0]=1;
			}
			else if(D1.getBackground().equals(Color.lightGray))
			{
				D1.setBackground(Color.WHITE);
				ToBeRolled[0]=0;
			}

		}

		public void mouseEntered(MouseEvent arg0) 
		{
			// Auto-generated method stub

		}

		public void mouseExited(MouseEvent arg0) 
		{
			// Auto-generated method stub

		}

		public void mousePressed(MouseEvent arg0)
		{
			// Auto-generated method stub

		}

		public void mouseReleased(MouseEvent arg0) 
		{
			// Auto-generated method stub

		}
	}
	private class Listener2 implements MouseListener
	{

		public void mouseClicked(MouseEvent arg0) 
		{
			if(D2.getBackground().equals(Color.WHITE))
			{
				D2.setBackground(Color.lightGray);
				ToBeRolled[1]=1;
			}
			else if(D2.getBackground().equals(Color.lightGray))
			{
				D2.setBackground(Color.WHITE);
				ToBeRolled[1]=0;
			}

		}

		public void mouseEntered(MouseEvent arg0) 
		{
			// Auto-generated method stub

		}

		public void mouseExited(MouseEvent arg0) 
		{
			// Auto-generated method stub

		}

		public void mousePressed(MouseEvent arg0)
		{
			// Auto-generated method stub

		}

		public void mouseReleased(MouseEvent arg0) 
		{
			// Auto-generated method stub

		}
	}
	private class Listener3 implements MouseListener
	{

		public void mouseClicked(MouseEvent arg0) 
		{
			if(D3.getBackground().equals(Color.WHITE))
			{
				D3.setBackground(Color.lightGray);
				ToBeRolled[2]=1;
			}
			else if(D3.getBackground().equals(Color.lightGray))
			{
				D3.setBackground(Color.WHITE);
				ToBeRolled[2]=0;
			}

		}

		public void mouseEntered(MouseEvent arg0) 
		{
			//Auto-generated method stub

		}

		public void mouseExited(MouseEvent arg0) 
		{
			// Auto-generated method stub

		}

		public void mousePressed(MouseEvent arg0)
		{
			// Auto-generated method stub

		}

		public void mouseReleased(MouseEvent arg0) 
		{
			// Auto-generated method stub

		}
	}
	private class Listener4 implements MouseListener
	{

		public void mouseClicked(MouseEvent arg0) 
		{
			if(D4.getBackground().equals(Color.WHITE))
			{
				D4.setBackground(Color.lightGray);
				ToBeRolled[3]=1;
			}
			else if(D4.getBackground().equals(Color.lightGray))
			{
				D4.setBackground(Color.WHITE);
				ToBeRolled[3]=0;
			}

		}

		public void mouseEntered(MouseEvent arg0) 
		{
			// Auto-generated method stub

		}

		public void mouseExited(MouseEvent arg0) 
		{
			// Auto-generated method stub

		}

		public void mousePressed(MouseEvent arg0)
		{
			// Auto-generated method stub

		}

		public void mouseReleased(MouseEvent arg0) 
		{
			// Auto-generated method stub

		}
	}
	private class Listener5 implements MouseListener
	{

		public void mouseClicked(MouseEvent arg0) 
		{
			if(D5.getBackground().equals(Color.WHITE))
			{
				D5.setBackground(Color.lightGray);
				ToBeRolled[4]=1;
			}
			else if(D5.getBackground().equals(Color.lightGray))
			{
				D5.setBackground(Color.WHITE);
				ToBeRolled[4]=0;
			}

		}

		public void mouseEntered(MouseEvent arg0) 
		{
			// Auto-generated method stub

		}

		public void mouseExited(MouseEvent arg0) 
		{
			// Auto-generated method stub

		}

		public void mousePressed(MouseEvent arg0)
		{
			// Auto-generated method stub

		}

		public void mouseReleased(MouseEvent arg0) 
		{
			// Auto-generated method stub

		}
	}
	//When Reroll is clicked------ reroll the dice and only allow 2 rerolls
	private int Rolls=1;
	private class Listener6 implements MouseListener
	{

		public void mouseClicked(MouseEvent arg0) 
		{
			ReRoll.setText("ReRoll: " + Rolls);
			D1.setBackground(Color.WHITE);
			D2.setBackground(Color.WHITE);
			D3.setBackground(Color.WHITE);
			D4.setBackground(Color.WHITE);
			D5.setBackground(Color.WHITE);
			if(Rolls<3)
			{
				if(ToBeRolled[0]==1)
				{
					DiceRan[0]=(int)(Math.random()*6) + 1;
					for(int x=1; x<=6; x++)
					{

						if(DiceRan[0]==x)
						{
							D1.setIcon(Images[x-1]);
						}
					}
				}
				if(ToBeRolled[1]==1)
				{
					DiceRan[1]=(int)(Math.random()*6) + 1;
					for(int x=1; x<=6; x++)
					{

						if(DiceRan[1]==x)
						{
							D2.setIcon(Images[x-1]);
						}
					}
				}
				if(ToBeRolled[2]==1)
				{
					DiceRan[2]=(int)(Math.random()*6) + 1;
					for(int x=1; x<=6; x++)
					{

						if(DiceRan[2]==x)
						{
							D3.setIcon(Images[x-1]);
						}
					}
				}
				if(ToBeRolled[3]==1)
				{
					DiceRan[3]=(int)(Math.random()*6) + 1;
					for(int x=1; x<=6; x++)
					{

						if(DiceRan[3]==x)
						{
							D4.setIcon(Images[x-1]);
						}
					}
				}
				if(ToBeRolled[4]==1)
				{
					DiceRan[4]=(int)(Math.random()*6) + 1;
					for(int x=1; x<=6; x++)
					{

						if(DiceRan[4]==x)
						{
							D5.setIcon(Images[x-1]);
						}
					}
				}
				Rolls++;
				ReRoll.setText("ReRoll: " + Rolls);
			}
			for(int w=0; w<5; w++)
			{
				ToBeRolled[w]=0;
			}
		}

		public void mouseEntered(MouseEvent arg0) 
		{
			// Auto-generated method stub

		}

		public void mouseExited(MouseEvent arg0) 
		{
			//Auto-generated method stub

		}

		public void mousePressed(MouseEvent arg0)
		{
			// Auto-generated method stub

		}

		public void mouseReleased(MouseEvent arg0) 
		{
			// Auto-generated method stub
		}
	}
}