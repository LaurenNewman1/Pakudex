import java.util.ArrayList;
public class Pakudex
{
    // Declare all private variables
    private int capacity;
    private boolean isAddSuccessful = false;
    private Pakuri newSpecies;
    private ArrayList<Pakuri> allSpecies = new ArrayList<Pakuri>();
    private ArrayList<String> speciesString = new ArrayList<String>();

    // Default constructor
    public Pakudex()
    {
        capacity = 20;
    }

    // Overloaded constructor
    public Pakudex(int capacity)
    {
        this.capacity = capacity;
    }

    // Returns the number of critters currently being stored in the Pakudex
    public int getSize()
    {
        return allSpecies.size();
    }

    // Returns the number of critters that the Pakudex has the capacity to hold at most
    public int getCapacity()
    {
        return capacity;
    }

    // Returns a String array containing the species of the critters as ordered in the Pakudex
    // Returns null if empty
    public String[] getSpeciesArray()
    {
        int i;
        String[] allSpeciesArray = new String[getSize()];

        if (getSize() == 0)
        {
            return null;
        }
        else // Converts array list to string array
        {
            for (i = 0; i < getSize(); i++)
            {
                allSpeciesArray[i] = speciesString.get(i);
            }
            return allSpeciesArray;
        }
    }

    /* Returns  an  int  array  containing  the  attack,  defense,
       and  speed  statistics  of  species  at  indices  0,  1,  and  2  respectively; */
    // If species is not in Pakudex, returns null
    public int[] getStats(String species)
    {
        // Creates new species and stat array
        int[] statistics = new int[3];
        int locator = 0;

        if (doesSpeciesExist(species))
        {
            locator = speciesString.indexOf(species);

            // Assigns each index with value
            statistics[0] = allSpecies.get(locator).getAttack();
            statistics[1] = allSpecies.get(locator).getDefense();
            statistics[2] = allSpecies.get(locator).getSpeed();
            return statistics;
        }
        else
        {
            return null;
        }
    }

    /* Sorts the Pakuri objects in thisPakudex according to
       Java standard lexicographical ordering of species name */
    public void sortPakuri()
    {
        // Declare all variables
        int i;
        int j;
        int compareNum = 0;
        String temp = "";
        Pakuri tempPakuri;

        // Reorganizes arraylists
        for (i = 0; i + 1 < getSize(); i++)
        {
            for (j = i + 1; j < getSize(); j++)
            {
                compareNum = speciesString.get(i).compareTo(speciesString.get(j));
                if (compareNum > 0) // If positive, switch them
                {
                    // String version
                    temp = speciesString.get(i);
                    speciesString.set(i, speciesString.get(j));
                    speciesString.set(j, temp);

                    // Pakuri version
                    tempPakuri = allSpecies.get(i);
                    allSpecies.set(i, allSpecies.get(j));
                    allSpecies.set(j, tempPakuri);
                }
            }
        }
    }

    // Adds species to the Pakudex; if successful, return true, and false otherwise
    public boolean addPakuri(String species)
    {
        // Creates new Pakuri type species

        // If there is still room, add it
        if (getSize() < getCapacity() && !doesSpeciesExist(species))
        {
            speciesString.add(species);
            newSpecies = new Pakuri(species);
            allSpecies.add(newSpecies);
            isAddSuccessful = true;
        }
        else // Unsuccessful if there is no room
        {
            isAddSuccessful = false;
        }
        return isAddSuccessful;
    }

    // Attempts to evolve species within the Pakudex
    // If successful, return true, and false otherwise
    public boolean evolveSpecies(String species)
    {
        // Declare all variables
        boolean didSpeciesEvolve = false;
        int locator = 0;

        if (doesSpeciesExist(species)) // Evolve if exists
        {
            locator = speciesString.indexOf(species);
            allSpecies.get(locator).evolve();
            didSpeciesEvolve = true;
        }
        else // Species doesn't exist
        {
            didSpeciesEvolve = false;
        }
        return didSpeciesEvolve;
    }

    // Extra method
    public boolean doesSpeciesExist(String species)
    {
        // Declare all variables
        int i;
        boolean speciesExists = false;

        for (i = 0; i < getSize(); i++)
        {
            if (allSpecies.size() == 0) // There are no species
            {
                speciesExists = false;
            }
            else if (species.equals(speciesString.get(i))) // Exists
            {
                speciesExists = true;
                break;
            }
            else // Does not exist
            {
                speciesExists = false;
            }
        }
        return speciesExists;
    }
}
