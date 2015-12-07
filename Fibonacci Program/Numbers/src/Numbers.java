import java.util.Scanner;


public class Numbers 
{
	public static final int SIZE = 12;
	
	public static void main(String[] args) 
	{
		int[] numbers = new int[SIZE];
		int count = 0, found = -1, i;
		boolean isFound;
		
		Scanner input = new Scanner(System.in);
		
		System.out.println("Please enter 12 two-digit numbers \n\n");
		for (i = 0; i < SIZE; i++)
		{
			System.out.println("Please enter number " + (i + 1) + ": ");
			numbers[i] = input.nextInt();
			
			while ((numbers[i] >= 100) || (numbers[i] < 10))
			{
				System.out.println("\tThat number is not two digits.");
				System.out.println("Please enter number " + (i + 1) + ": ");
				numbers[i] = input.nextInt();
			}
		}
		
		System.out.println("Now enter a 3-digit number: ");
		int total = input.nextInt();
		
		while ((total >= 1000) || (total < 100))
		{
			System.out.println("\tThat number is not three digits.");
			System.out.println("Please enter a 3-digit number: ");
			total = input.nextInt();
		}
		
		System.out.println("This program will now find a subset of your 2-digit numbers that equal your 3-digit number.");
		
		int totalNumbers = 0;
		for (i = 0; i < SIZE; i++)
		{
			totalNumbers += numbers[i];
		}
		
		if (totalNumbers < total)
		{
			System.out.println("\n\nThis problem cannot be solved with the numbers entered.\nPlease exit the program and try again.");
		}
		else
		{
			doSelectionSort(numbers);
			
//			for (int i = 0; i < SIZE; i++)
//			{
//				System.out.print(numbers[i] + " ");
//			}
			
			int newTotal = total;
			
			for (i = (SIZE - 1); i > 0; i--)
			{
					newTotal -= numbers[i];
//					System.out.println(numbers[i]);
//					System.out.println(newTotal);
					count += 1;
					found = searchArray(found, newTotal, numbers);
			}
			
			isFound = isFound(found, count, total, newTotal, numbers);
			if (!isFound)
			{
				if (newTotal < 100)
				{
					splitRemaining(newTotal, i, numbers);
				}
			}
		}
	}
	
	public static int[] doSelectionSort(int[] arr)
	{
        
        for (int i = 0; i < arr.length - 1; i++)
        {
            int index = i;
            for (int j = i + 1; j < arr.length; j++)
                if (arr[j] < arr[index])
                    index = j;
      
            int smallerNumber = arr[index]; 
            arr[index] = arr[i];
            arr[i] = smallerNumber;
        }
        return arr;
    
	}
	
	public static int searchArray(int found, int num, int[] arr)
	{
		for (int i = 0; i < SIZE; i++)
		{
			if (num == arr[i])
			{
				found = i;
			}
		}
		return found;
	}
	
	public static boolean isFound(int found, int count, int total, int newTotal, int[] numbers)
	{
		int[] subset;
		if (found != -1)
		{
			newTotal = total;
			count += 1;
			subset = new int[count];
			int n = 0;
			
			for (int i = (SIZE - 1); i > 0; i--)
			{
					if (newTotal >= 100)
					{
						newTotal -= numbers[i];
						subset[n] = numbers[i];
						n++;
					}
			}
			
			subset[n] = numbers[found];
			System.out.println("\nThe subset is:");
			
			for (n = 0; n < count; n++)
			{
				if (subset[n] != 0)
				{
					System.out.print(subset[n] + " ");
				}
			}
			
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public static void splitRemaining(int newTotal, int i, int[] numbers)
	{
		int[] remainingNumbers = new int[i];
		int teens = 0, twenties = 0, thirties = 0, forties = 0, fifties = 0, sixties = 0, seventies = 0, eighties = 0, nineties = 0;
		
		for (int n = (i - 1); n > 0; n--)
		{
			remainingNumbers[n] = numbers[n];
			if (remainingNumbers[n] >= 10 && remainingNumbers[n] < 20)
			{
				teens += 1;
			}
			if (remainingNumbers[n] >= 20 && remainingNumbers[n] < 30)
			{
				twenties += 1;
			}
			if (remainingNumbers[n] >= 30 && remainingNumbers[n] < 40)
			{
				thirties += 1;
			}
			if (remainingNumbers[n] >= 40 && remainingNumbers[n] < 50)
			{
				forties += 1;
			}
			if (remainingNumbers[n] >= 50 && remainingNumbers[n] < 60)
			{
				fifties += 1;
			}
			if (remainingNumbers[n] >= 60 && remainingNumbers[n] < 70)
			{
				sixties += 1;
			}
			if (remainingNumbers[n] >= 70 && remainingNumbers[n] < 80)
			{
				seventies += 1;
			}
			if (remainingNumbers[n] >= 80 && remainingNumbers[n] < 90)
			{
				eighties += 1;
			}
			if (remainingNumbers[n] >= 90 && remainingNumbers[n] < 100)
			{
				nineties += 1;
			}
		}
	}

}
