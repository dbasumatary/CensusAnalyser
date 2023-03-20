import censusanalyser.StateCensusAnalyser;
import exceptions.InvalidDelimiterException;
import exceptions.InvalidFileException;
import exceptions.InvalidHeaderException;
import exceptions.InvalidTypeException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class TestAnalyser {

    StateCensusAnalyser analyser;

    @Before
    public void initialization() {
        analyser = new StateCensusAnalyser();
    }

    @Test
    public void testIfTheRecordMatches() throws InvalidFileException, InvalidTypeException, InvalidDelimiterException, InvalidHeaderException {
        analyser.analyseData("./src/main/resources/StateCensusData.csv");
        Assert.assertEquals(true,analyser.checkData());
    }

    @Test
    public void testForFileCheck() throws InvalidFileException, InvalidTypeException, InvalidDelimiterException, InvalidHeaderException {
        analyser.analyseData("./src/main/resources/StateCensusData.csv");
        assertTrue(analyser.checkData());
    }

    @Test
    public void testForFileTypeCheck() throws InvalidTypeException, InvalidFileException, InvalidDelimiterException, InvalidHeaderException {
        analyser.analyseData("./src/main/resources/StateCensusData.csv");
        Assert.assertEquals(true,analyser.checkData());
    }

    @Test
    public void testIfDelimiterMatches() throws InvalidFileException, InvalidTypeException, InvalidDelimiterException, InvalidHeaderException {
        analyser.analyseData("./src/main/resources/StateCensusData.csv");
        assertTrue(analyser.checkData());
    }

    @Test
    public void testIfHeaderMatches() throws InvalidFileException, InvalidTypeException, InvalidDelimiterException, InvalidHeaderException {
        analyser.analyseData("./src/main/resources/StateCensusData.csv");
        assertTrue(analyser.checkData());
    }
}
