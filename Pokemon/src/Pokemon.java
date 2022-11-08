import java.util.concurrent.TimeUnit;

public class Pokemon {
    private String name;
    private Gender GENDER;
    private int level;
    private String id;
    private Species species;

    //Stats básicas
    private int hp;
    private int battelHp = hp;
    private int strength;

    private int totalExpForNextLevel = 20;
    private int totalExp = 0;


    public Pokemon(Species s)
    {
        this(s, 5);
    }

    public Pokemon(Species s, Pokemon p)
    {
        this(s, p.getLevel());
    }

    public Pokemon(Species species, int level)
    {
        this.name = species.getName();
        this.id = species.getId();
        this.species = species;
        this.level = level;
        this.GENDER = GENDER.MALE;
        this.hp = getRandomNumber(level , level + 15);
        this.strength = getRandomNumber(level , level + 10);
    }

    public int fight(Pokemon p){
        System.out.println("\t"+this.getName()+"\t\t  \t"+p.getName());
        System.out.println("\tHP:"+this.getHp()+"\t\tVS\t\t"+"HP:"+p.getHp());
        System.out.println("\tLVL:"+this.getLevel()+"\t\t  \t\t"+"LVL:"+p.getLevel());
        try
            {
                System.out.print("1..");
                Thread.sleep(1000);
                System.out.print("2..");
                Thread.sleep(1000);
                System.out.print("3..");
                Thread.sleep(1000);
                System.out.print("¡Adelante, " + this.getName() +"!\n");
                Thread.sleep(1000);
            }
            catch(InterruptedException ex)
            {
                Thread.currentThread().interrupt();
            }

        if (p.strength < this.strength) {
            totalExp += getRandomNumber(p.level, p.level + 20);
            System.out.println( "¡"+this.getName() + " ha ganado el combate!");
            this.levelUp();
            
            return 2;
        }else if (p.strength == this.strength) {
            return 1;
        }else{
            System.out.println( "¡Oh no! El "+p.getName() + " enemigo ha ganado el combate");
            p.totalExp += getRandomNumber(this.level, this.level + 20);
            p.levelUp();
            return 0;
        }
        
    }

    public void train(){
        totalExp += getRandomNumber(level, level + 10);
    }

    private void evolve(){
        if (level >= species.getLevelToEvolve()) {
            String oldName = name;
            //new Pokemon(this.species.getEvolvesTo(),this);
            species = new Species(species.getEvolvesTo());
            name = this.species.getName();
            id = species.getId();
            hp += getRandomNumber(10, 30);
            strength += getRandomNumber(5, 15);

            try
            {
                System.out.println("¡Anda, "+oldName+" está evolucionando!");
                Thread.sleep(1000);
                System.out.println(".");
                Thread.sleep(1000);
                System.out.println(".");
                Thread.sleep(1000);
                System.out.println(".");
                Thread.sleep(1000);
            }
            catch(InterruptedException ex)
            {
                Thread.currentThread().interrupt();
            }

            System.out.println("¡"+oldName+" ha evolucionado a "+ this.getName() +"!");
        }
    }

    public boolean levelUp(){
        if(totalExp >= totalExpForNextLevel)
        {
            level++;
            hp++;
            strength++;
            heal();
            totalExp = 0;
            totalExpForNextLevel += 5;
            System.out.println("¡"+this.getName()+" ha subido de nivel!");
            evolve();
            return true;
        }else{
            return false;
        }
    }

    public void heal(){
        battelHp = hp;
    }


    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Gender getGENDER() {
        return this.GENDER;
    }

    public void setGENDER(Gender GENDER) {
        this.GENDER = GENDER;
    }

    public int getLevel() {
        return this.level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Species getSpecies() {
        return this.species;
    }

    public void setSpecies(Species species) {
        this.species = species;
    }
    
    public int getRandomNumber(int min, int max) {
        return (int) ((Math.random() * (max - min)) + min);
    }


    public int getHp() {
        return this.hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getStrength() {
        return this.strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }


    public int getBattelHp() {
        return this.battelHp;
    }

    public void setBattelHp(int battelHp) {
        this.battelHp = battelHp;
    }

    @Override
    public String toString() {
        return "\t|Nombre: '" + getName() + "'\n" +
            "\t|Género: '" + getGENDER() + "'\n" +
            "\t|Nivel: '" + getLevel() + "'\n" +
            "\t|Pokedex: '" + getId() + "'\n" +
            "\t|HP: '" + getHp() + "'\n" +
            "\t|Fuerza: '" + getStrength() + "'\n";
    }


    
    
}


