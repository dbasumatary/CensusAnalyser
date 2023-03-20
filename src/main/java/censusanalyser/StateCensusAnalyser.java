package censusanalyser;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import exceptions.InvalidDelimiterException;
import exceptions.InvalidFileException;
import exceptions.InvalidHeaderException;
import exceptions.InvalidTypeException;
import java.lang.NumberFormatException;

public class StateCensusAnalyser{
    ArrayList<CSVStateCensus> censusData = new ArrayList<>();

    public void analyseData(String filePath) throws InvalidFileException, InvalidTypeException, InvalidDelimiterException, InvalidHeaderException{

        try {
            CSVReader reader = new CSVReader(new FileReader("./src/main/resources/StateCensusData.csv"));
            String[] record;
            record = reader.readNext();

            //Checking if the header exists in the file
            if (!checkHeader(record)){
                throw new InvalidHeaderException("This header is invalid");
            }
            while ((record = reader.readNext()) != null) {
                if (record.length != 3){
                    throw new InvalidDelimiterException("The length is unequal");
                }
                censusData.add(new CSVStateCensus((record[0]),Long.valueOf(record[1]),Integer.valueOf(record[2])));
            }

            for (CSVStateCensus data : censusData) {
                System.out.println(data);
            }

        }catch (CsvValidationException | IOException | NumberFormatException e){
            e.printStackTrace();
        }catch (InvalidHeaderException e){
            throw new InvalidHeaderException("The header is invalid");
        }catch (InvalidDelimiterException e){
            throw new InvalidDelimiterException("The length is unequal");
        }
    }

    //Check if the header is correct
    public boolean checkHeader(String[] record) {
        return (record[0].compareTo("State") + record[1].compareTo("Population") + record[2].compareTo("AreaInSqKm") == 0);
    }

    //Check number of records
    public boolean checkData() {
        if (censusData.size() == 5)
            return true;
        return false;
    }

    public static void main(String[] args) throws Exception {
        StateCensusAnalyser stateCensusAnalyser = new StateCensusAnalyser();
        stateCensusAnalyser.analyseData("./src/main/resources/StateCensusData.csv");
    }
}
