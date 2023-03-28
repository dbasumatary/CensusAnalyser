package censusanalyser;

import exceptions.InvalidDelimiterException;
import exceptions.InvalidFileException;
import exceptions.InvalidHeaderException;
import exceptions.InvalidTypeException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CSVStateCode {

    private List<String[]> records;

    public CSVStateCode() {
        records = new ArrayList<String[]>();
    }

    public void readCSV(String fileName) {
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                records.add(values);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void printRecords() {
        Iterator<String[]> iterator = records.iterator();
        while (iterator.hasNext()) {
            String[] record = iterator.next();
            for (int i = 0; i < record.length; i++) {
                System.out.print(record[i] + " ");
            }
            System.out.println();
        }
    }

    public int getNumberOfRecords() {
        return records.size();
    }

    public static void main(String[] args) throws InvalidFileException, InvalidDelimiterException, InvalidHeaderException, InvalidTypeException {
        CSVStateCode csvStateCode = new CSVStateCode();
        csvStateCode.readCSV("./src/main/resources/StateCodeData.csv");
        csvStateCode.printRecords();

        // Check with StateCensusAnalyser to ensure number of record matches
        StateCensusAnalyser stateCensusAnalyser = new StateCensusAnalyser();
        int numberOfRecords = stateCensusAnalyser.loadStateCodeData("./src/main/resources/StateCodeData.csv");
        if (numberOfRecords == csvStateCode.getNumberOfRecords()) {
            System.out.println("Number of records in CSV matches with StateCensusAnalyser");
        } else {
            System.out.println("Number of records in CSV does not match with StateCensusAnalyser");
        }
    }
}
