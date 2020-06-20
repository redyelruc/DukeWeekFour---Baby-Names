import edu.duke.FileResource;
import org.apache.commons.csv.CSVParser;
import org.junit.*;

public class testBabyNames {
    BabyNames babyNames;
    FileResource fr;


    @Before
    public void setup() {
        babyNames = new BabyNames();


    }

    @Test
    public void testTotalBirthsYob2014ShortReturns46(){
        int expected = 47;
        fr = new FileResource("src/CSVs/us_babynames_test/yob2014short.csv");
        Assert.assertEquals(expected, babyNames.totalBirths(fr));
    }


    @Test
    public void testTotalBirthsYob2013ShortReturns46(){
        int expected = 83;
        fr = new FileResource("src/CSVs/us_babynames_test/yob2013short.csv");
        Assert.assertEquals(expected, babyNames.totalBirths(fr));
    }

    @Test
    public void testTotalBoysNamesAndGirlsNamesYob2013ShortReturns5510(){
        String expected = "5510";
        fr = new FileResource("src/CSVs/us_babynames_test/yob2013short.csv");
        Assert.assertEquals(expected, babyNames.totalBoysNamesAndGirlsNames(fr));
    }

    @Test
    public void testTotalBoysNamesAndGirlsNamesYob2014ShortReturns5510(){
        String expected = "5510";
        fr = new FileResource("src/CSVs/us_babynames_test/yob2014short.csv");
        Assert.assertEquals(expected, babyNames.totalBoysNamesAndGirlsNames(fr));
    }

    @Test
    public void testGetRankOliviaFemale2014Returns2(){
        int expected = 2;
        String name = "Olivia";
        String gender = "F";
        int year = 2014;
        Assert.assertEquals(expected, babyNames.getRank(year, name, gender));
    }

    @Test
    public void testGetRankLiamMale2014Returns2(){
        int expected = 2;
        String name = "Liam";
        String gender = "M";
        int year = 2014;
        Assert.assertEquals(expected, babyNames.getRank(year, name, gender));
    }

    @Test
    public void testGetRankLiamFemale2014ReturnsMinus1(){
        int expected = -1;
        String name = "Lion";
        String gender = "F";
        int year = 2014;
        Assert.assertEquals(expected, babyNames.getRank(year, name, gender));
    }

    @Test
    public void testGetName2Female2014ReturnsOlivia(){
    String expected = "Olivia";
    int rank = 2;
    String gender = "F";
    int year = 2014;
    Assert.assertEquals(expected, babyNames.getName(year, rank, gender));
    }


    @Test
    public void testGetName0Female2014ReturnsNONAME(){
        String expected = "NO NAME";
        int rank = 0;
        String gender = "F";
        int year = 2014;
        Assert.assertEquals(expected, babyNames.getName(year, rank, gender));
    }

    @Test
    public void testGetName1Male2014ReturnsNoah(){
        String expected = "Noah";
        int rank = 1;
        String gender = "M";
        int year = 2014;
        Assert.assertEquals(expected, babyNames.getName(year, rank, gender));
    }

    @Test
    public void testWhatIsNameInYearIsabella2014In2012ReturnsOlivia(){
        String expected = "Olivia";
        String name = "Isabella";
        int year = 2014;
        int newYear = 2012;
        String gender = "F";
        Assert.assertEquals(expected, babyNames.whatIsNameInYear(name, year, newYear, gender));
    }

    @Test
    public void testYearOfHighestRankEmmaFemale2012to2014Returns2014(){
        int expected = 2014;
        String name = "Emma";
        String gender = "F";
        Assert.assertEquals(expected, babyNames.yearOfHighestRank(name, gender));
    }


    @Test
    public void testYearOfHighestRankNoahMale2012to2014Returns2013(){
        int expected = 2013;
        String name = "Noah";
        String gender = "M";
        Assert.assertEquals(expected, babyNames.yearOfHighestRank(name, gender));
    }

    @Test
    public void testAverageRankNoahMale2012to2014Returns2(){
        double expected = 2.0;
        String name = "Noah";
        String gender = "M";
        Assert.assertEquals(expected, babyNames.averageRank(name, gender), 0.0000000001);
    }

    @Test
    public void testAverageRankNLionFemale2012to2014Returnsminus1(){
        double expected = -1.0;
        String name = "Lion";
        String gender = "F";
        Assert.assertEquals(expected, babyNames.averageRank(name, gender), 0.0000000001);
    }

    @Test
    public void testTotalBirthsRankedHigherLiamMale2014Returns19144(){
        int expected = 19144;
        String name = "Drew";
        String gender = "M";
        int year = 1990;
        Assert.assertEquals(expected, babyNames.totalBirthsRankedHigher(year, name, gender));
    }

    @Test
    public void testTotalBirthsRankedHigherNoahMale2012Returns55608(){
        int expected = 55608;
        String name = "Noah";
        String gender = "M";
        int year = 2012;
        Assert.assertEquals(expected, babyNames.totalBirthsRankedHigher(year, name, gender));
    }


}
