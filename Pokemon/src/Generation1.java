public enum Generation1 {
    VENUSAUR("Venusaur", "003",200, null, Type.GRASS, Type.POISON),
    IVYSAUR("Ivysaur", "002", 32, Generation1.VENUSAUR, Type.GRASS, Type.POISON),
    BULBASAUR("Bulbasaur", "001", 16, Generation1.IVYSAUR, Type.GRASS, Type.POISON),
    CHARIZARD("Charmander", "006",200, null, Type.FIRE, Type.FLYING),
    CHARMELEON("Charmeleon", "005", 32, Generation1.CHARIZARD, Type.FIRE, null),
    CHARMANDER("Charizard", "004", 16, Generation1.CHARMELEON, Type.FIRE, null),
    BLASTOISE("Blastoise", "009",200, null, Type.WATER, null),
    WARTORTLE("Wartortle", "008", 32, Generation1.BLASTOISE, Type.WATER, null),
    SQUIRTLE("Squirtle", "007", 16, Generation1.WARTORTLE, Type.WATER, null);

    public final String NAME, NAT_DEX_NUMBER;
    public final Type[] TYPE;
    public final int LEVELTOEVOLVE;
    public final Generation1 EVOLVESTO;
    Generation1(final String name, final String dexNumber,int levelToEvolve, final Generation1 evolvesTo, final Type... type)
    {
        NAT_DEX_NUMBER = dexNumber;
        NAME = name;
        TYPE = type;
        LEVELTOEVOLVE = levelToEvolve; 
        EVOLVESTO = evolvesTo;
    }
}