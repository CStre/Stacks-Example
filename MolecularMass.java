import java.util.Scanner;

public class MolecularMass 
{

	private static int Carbon = 12;
	private static int Hydrogen = 1;
	private static int Oxygen = 16;
	
	
	//Simply this method is ON PERIOD!!!
	
	public static void main(String[] args)
	{
		String symbol = "-2";
		Scanner scan = new Scanner(System.in);
	
		System.out.print("Enter the symbol: ");
		symbol = scan.nextLine().trim();
			
		System.out.println("The Molecular Mass of " + symbol + 
				" is " + calcMass(symbol));
		System.out.println();
		
		scan.close();
	}
	
	//Converts the input of a single element into the static variable with value.
	
	private static int getMass(char element)
	{
		if (element == 'H')
			return Hydrogen;
		else if (element == 'C')
			return Carbon;
		else if (element == 'O')
			return Oxygen;
		else
			return -1000000000;
	}
	
	//Works with the stack to read the input and calculate it accordingly also taking in account parenthesis. 
	
	public static int calcMass(String symbol)
	{
		IntStack stack = new IntStack();
		
		for (int i = 0; i < symbol.length(); i++)
		{
			char ch = symbol.charAt(i);
			
			if (Character.isDigit(ch))
			{
				if (i + 1 != symbol.length())
				{
					char cha = symbol.charAt(i + 1);
					
					if (Character.isDigit(cha))
					{
						return -1;
					}
				}
				
				int mass = stack.pop();
				stack.push(mass * Integer.parseInt("" + ch));
			}
			else if (ch == ')')
			{
				int totalMass = 0;
				int mass = 0;
				while (((mass = stack.pop()) != -1) && (mass != 0))
				{
					totalMass += mass;
				}
				
				stack.push(totalMass);
			}
			else 
			{
				stack.push(getMass(ch));
			}
			
		}
		int totalMolecularMass = 0;
		int mass = 0;
		
		while ((mass = stack.pop()) != -1)
		{
			totalMolecularMass += mass;
		}
		
		if (totalMolecularMass <= 1)
		{
			return -1;
		}
		else
		{
			return totalMolecularMass;
		}
	}
	
}