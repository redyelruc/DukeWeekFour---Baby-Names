import edu.duke.*;
import org.apache.commons.csv.*;

import java.io.File;

public class BabyNames {
    public int totalBirths(FileResource fr) {
        int totalBirths = 0;
        for (CSVRecord rec : fr.getCSVParser(false)) {
            int numBorn = Integer.parseInt(rec.get(2));
            totalBirths += numBorn;
        }
        System.out.println("total births = " + totalBirths);
        return totalBirths;
    }

    public String totalBoysNamesAndGirlsNames(FileResource fr) {
        int totalBoys = 0;
        int totalGirls = 0;
        int totalNames = 0;
        for (CSVRecord rec : fr.getCSVParser(false)) {
            if (rec.get(1).equals("M")) {
                totalBoys++;
                totalNames++;
            } else {
                totalGirls++;
                totalNames++;
            }
        }
        String totalBandGNames = Integer.toString(totalBoys)
                + Integer.toString(totalGirls)
                + Integer.toString(totalNames);
        return totalBandGNames;
    }

    public int getRank(int year, String name, String gender) {
        FileResource fr = new FileResource("src/CSVs/us_babynames_by_year/yob"
                + Integer.toString(year) + ".csv");
        int currRank = 0;
        int finalRank = -1; // defaults to not found
        for (CSVRecord rec : fr.getCSVParser(false)) {
            if (rec.get(1).equals(gender)) {
                currRank++;
                if (rec.get(0).equals(name)) {
                    finalRank = currRank;
                }
            }
        }
        return finalRank;
    }

    public String getName(int year, int rank, String gender){
        String nameFound = "NO NAME"; //defaults to not found
        FileResource fr = new FileResource("src/CSVs/us_babynames_by_year/yob"
                + Integer.toString(year) + ".csv");
        int currRank = 0;
        for (CSVRecord rec : fr.getCSVParser(false)) {
            if (rec.get(1).equals(gender)) {
                currRank++;
                if (currRank == rank){
                    nameFound = rec.get(0);
                }
            }
        }
        return nameFound;
    }

    public String whatIsNameInYear(String name, int year, int newYear, String gender){
        int rank = getRank(year, name, gender);
        String newName = getName(newYear, rank, gender);
        System.out.println(name + " born in " + Integer.toString(year) + " would be "
                               + newName + " if she was born in " + Integer.toString(newYear));
        return newName;
    }

    public int yearOfHighestRank(String name, String gender){
        int index;
        int currYear;
        int currRank;
        int bestRank = 100000;
        int bestYear = -1;
        String fileName;
        DirectoryResource dr = new DirectoryResource();
        for (File f : dr.selectedFiles()) {
            fileName = f.getName();
            index = fileName.indexOf(".");
            currYear = Integer.parseInt(fileName.substring(index - 4, index));
            currRank = getRank(currYear, name, gender);
            if (currRank > -1 && currRank < bestRank) {
                bestRank = currRank;
                bestYear = currYear;
            }
        }
        return bestYear;
    }

    public double averageRank(String name, String gender){
        int index, currYear, currRank, totalRank = 0;
        double aveRank;
        double numOfYears = 0.0;
        String fileName;
        DirectoryResource dr = new DirectoryResource();

        for (File f : dr.selectedFiles()) {
            fileName = f.getName();
            index = fileName.indexOf(".");
            currYear = Integer.parseInt(fileName.substring(index - 4, index));
            currRank = getRank(currYear, name, gender);
            if (currRank == -1) {
                totalRank = -1;
                break;
            } else{
                totalRank += currRank;
                numOfYears += 1.0;
            }
        }

        if (totalRank == -1) {
            aveRank = -1.0;
        }else{
            aveRank = totalRank/numOfYears;
        }
        return aveRank;
    }

    public int totalBirthsRankedHigher(int year, String name, String gender) {
        FileResource fr = new FileResource("src/CSVs/us_babynames_by_year/yob"
                + Integer.toString(year) + ".csv");
        int rank = getRank(year, name, gender);
        if (rank == -1){
            rank = 100000;
        }
        int totalBirths = 0, currRank = 0;
        for (CSVRecord rec : fr.getCSVParser(false)) {
            if (rec.get(1).equals(gender)){
                currRank++;
                if (currRank < rank) {
                    totalBirths += Integer.parseInt(rec.get(2));
                }
            }
        }
        return totalBirths;
    }
}
