public class Species {
    // VENUSAUR(Generation1.VENUSAUR),
    // IVYSAUR(Generation1.IVYSAUR),
    // BULBASAUR(Generation1.BULBASAUR);

    private final String NAME, NAT_DEX_NUMBER;
    private final int LEVELTOEVOLVE;
    private final Type[] TYPE;
    private final Generation1 EVOLVESTO;
    Species(Generation1 g) {
        NAME = g.NAME;
        NAT_DEX_NUMBER = g.NAT_DEX_NUMBER;
        TYPE = g.TYPE;
        LEVELTOEVOLVE = g.LEVELTOEVOLVE;
        EVOLVESTO =  g.EVOLVESTO;
    }

    public String getName()
    {
        return NAME;
    }

    public String getId()
    {
        return NAT_DEX_NUMBER;
    }

    public Type[] getType()
    {
        return TYPE;
    }

    public int getLevelToEvolve()
    {
        return LEVELTOEVOLVE;
    }

    public Generation1 getEvolvesTo()
    {
        return EVOLVESTO;
    }
}
