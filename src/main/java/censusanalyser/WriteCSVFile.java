package censusanalyser;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import com.opencsv.CSVWriter;
public class WriteCSVFile {

    //Writing the data to CSV file
    public void csvWriter() throws IOException {
        File filePath = new File("C:\\Users\\MSI\\IdeaProjects\\CensusAnalyser\\src\\main\\resources\\StateCensusData.csv");
        FileWriter fileWriter = new FileWriter(filePath);
        CSVWriter writer = new CSVWriter(fileWriter);

        String[] data1 = {"State", "Population", "AreaInSqKm"};
        String[] data2 = {"Assam", "52000", "78000"};
        String[] data3 = {"Bihar", "140000", "93000"};
        String[] data4 = {"Gujarat", "107000", "196000"};
        String[] data5 = {"Punjab", "49000", "51000"};
        String[] data6 = {"Odisha", "62000", "155000"};
        writer.writeNext(data1);
        writer.writeNext(data2);
        writer.writeNext(data3);
        writer.writeNext(data4);
        writer.writeNext(data5);
        writer.writeNext(data6);
        writer.close();
        fileWriter.close();
    }

    public static void main(String[] args) throws IOException {
        WriteCSVFile writingToCSV = new WriteCSVFile();
        writingToCSV.csvWriter();
    }
}
