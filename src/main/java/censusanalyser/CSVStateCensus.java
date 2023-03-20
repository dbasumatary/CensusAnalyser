package censusanalyser;
public class CSVStateCensus {
    String state;
    long population;
    int areaInSqKm;

    public CSVStateCensus(String state, long population, int areaInSqKm) {
        super();
        this.state = state;
        this.population = population;
        this.areaInSqKm = areaInSqKm;
    }

    @Override
    public String toString() {
        return "[State=" + state + ", Population=" + population + ", AreaInSqKm=" + areaInSqKm +"]";
    }
}
