import java.util.InputMismatchException;
import java.util.Scanner;
public class PakuriProgram
{
    public static void main(String[] args)
    {
        // Declare all variables
        Scanner scnr = new Scanner(System.in);
        int maxCapacity = 0;
        int menuSelection = 0;
        int i;
        int digit = 1;
        boolean isFull = false;
        boolean isSuccessful = false;
        boolean isMaxNum = false;
        String species = "";

        // Welcome statement
        System.out.println("Welcome to Pakudex: Tracker Extraordinaire!");
        while (!isMaxNum)
        {
            try
            {
                System.out.print("Enter max capacity of the Pakudex: ");
                maxCapacity = Integer.parseInt(scnr.next());
                if (maxCapacity < 0)
                {
                    System.out.println("Please enter a valid size.");
                    isMaxNum = false;
                }
                else
                {
                    isMaxNum = true;
                }
            }
            catch (NumberFormatException exception) // If user does not enter a number
            {
                System.out.println("Please enter a valid size.");
                isMaxNum = false;
            }
        }
        System.out.println("The Pakudex can hold " + maxCapacity + " species of Pakuri.");

        Pakudex userSpecies = new Pakudex(maxCapacity);

        while (menuSelection != 6)
        {
            // Display menu options
            System.out.println("\nPakudex Main Menu");
            System.out.println("-----------------");
            System.out.println("1. List Pakuri");
            System.out.println("2. Show Pakuri");
            System.out.println("3. Add Pakuri");
            System.out.println("4. Evolve Pakuri");
            System.out.println("5. Sort Pakuri");
            System.out.println("6. Exit");
            System.out.print("\nWhat would you like to do? ");
            try
            {
                menuSelection = Integer.parseInt(scnr.next());
            }
            catch (NumberFormatException exception) // If user enters something invalid
            {
                menuSelection = 7;
            }

            // Once menu option selected
            switch (menuSelection)
            {
                case 1: // List Pakuri
                    digit = 1;
                    if (userSpecies.getSize() == 0) // If no Pakuri yet
                    {
                        System.out.println("No Pakuri in Pakudex yet!");
                    }
                    else // Displays Pakuris
                    {
                        System.out.println("Pakuri In Pakudex:");

                        for (i = 0; i < userSpecies.getSize(); i++)
                        {
                            String[] speciesArray = userSpecies.getSpeciesArray();
                            System.out.print(digit + ". ");
                            System.out.println(speciesArray[i]);
                            digit++;
                        }
                    }
                    break;
                case 2: // Show Pakuri
                    // Prompts user to pick species to display stats for
                    System.out.print("Enter the name of the species to display: ");
                    species = scnr.next();

                    if (userSpecies.doesSpeciesExist(species)) // If exists
                    {
                        int[] stats = userSpecies.getStats(species);
                        System.out.println("\nSpecies: " + species);
                        System.out.println("Attack: " + stats[0]);
                        System.out.println("Defense: " + stats[1]);
                        System.out.println("Speed: " + stats[2]);
                    }
                    else // If does not exist
                    {
                        System.out.println("Error: No such Pakuri!");
                    }
                    break;
                case 3: // Add Pakuri
                    boolean isAdded = false;
                    if (userSpecies.getSize() == userSpecies.getCapacity())
                    {
                        isFull = true;
                    }
                    else
                    {
                        isFull = false;
                    }

                    if (!isFull) // If not full
                    {
                        System.out.print("Enter the name of the species to add: ");
                        species = scnr.next();
                        isAdded = userSpecies.addPakuri(species);
                        if (isAdded)
                        {
                            System.out.println("Pakuri species " + species + " successfully added!");
                        }
                        else
                        {
                            System.out.println("Error: Pakudex already contains this species!");
                        }
                    }
                    else // If no room
                    {
                        System.out.println("Error: Pakudex is full!");
                    }
                    break;
                case 4: // Evolve Pakuri
                    System.out.print("Enter the name of the species to evolve: ");
                    species = scnr.next();

                    if (userSpecies.doesSpeciesExist(species))
                    {
                        isSuccessful = userSpecies.evolveSpecies(species);
                        if (isSuccessful)
                        {
                            System.out.println(species + " has evolved!");
                        }
                    }
                    else
                    {
                        System.out.println("Error: No such Pakuri!");
                    }
                    break;
                case 5: // Sort Pakuri
                    userSpecies.sortPakuri();
                    System.out.println("Pakuri have been sorted!");
                    break;
                case 6: // Exits
                    System.out.println("Thanks for using Pakudex! Bye!");
                    System.exit(0);
                    break;
                default: // Invalid selection
                    System.out.println("Unrecognized menu selection!");
                    break;
            }
        }
    }
}
