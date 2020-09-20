public class Pakuri
{
    // Declare all private variables
    private String species = "";
    private int attack = 0;
    private int defense = 0;
    private int speed = 0;

    // Constructs a new Pakuri
    public Pakuri(String species)
    {
        this.species = species;
    }

    // Returns the species of the critter
    public String getSpecies()
    {
        return species;
    }

    // Returns the attack of the critter
    public int getAttack()
    {
        if (attack == 0) // If attack hasn't been initialized yet
        {
            attack = (species.length() * 7) + 9;
        }
        else
        {
            attack = attack;
        }
        return attack;
    }

    // Returns the defense of the critter
    public int getDefense()
    {
        if (defense == 0) // If defense hasn't been initialized yet
        {
            defense = (species.length() * 5) + 17;
        }
        else
        {
            defense = defense;
        }
        return defense;
    }

    // Returns the speed of the critter
    public int getSpeed()
    {
        if (speed == 0) // If speed hasn't been initialized yet
        {
            speed = (species.length() * 6) + 13;
        }
        else
        {
            speed = speed;
        }
        return speed;
    }

    // Changes the attack value for this critter to newAttack
    public void setAttack(int newAttack)
    {
        attack = newAttack;
    }

    // Will evolve the critter as follows:
    // a) double the attack
    // b) quadruple the defense
    // c) triple the speed
    public void evolve()
    {
        species = getSpecies();
        attack = getAttack() * 2;
        defense = getDefense() * 4;
        speed = getSpeed() * 3;
    }
}
