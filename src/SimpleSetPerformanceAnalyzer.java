import java.util.HashSet;
import java.util.LinkedList;
import java.util.TreeSet;


/**
 * this function test the run time in different sets.
 */
public class SimpleSetPerformanceAnalyzer {


    //all the sets kind that the class test.
    private static SimpleSet[] sets = {new OpenHashSet(), //new ClosedHashSet(),
            new CollectionFacadeSet(new TreeSet<String>()),
            new CollectionFacadeSet(new LinkedList<String>()),
            new CollectionFacadeSet(new HashSet<String>())};


    /**
     * this function gets data and test all the 5 kind of set.
     *
     * @param data - string list.
     */
    private static void testForSets(String[] data) {
        for (SimpleSet set : sets) {
            long timeBeforeTest = System.nanoTime();
            for (String string : data) {
                set.add(string);
            }
            long testTime = System.nanoTime() - timeBeforeTest;
            System.out.println("the test took: " + testTime / 1000000 + " ms");
        }
    }


    /**
     * this function test if the string is contain in the set.
     *
     * @param string - the string that we test.
     */
    private static void testContain(String string) {
        for (SimpleSet set : sets) {
            long timeBeforeTest = System.nanoTime();
            set.contains(string);
            long timeAfterTest = System.nanoTime() - timeBeforeTest;
            System.out.println("total time of contain test: " + timeAfterTest + " ns");
        }
    }


    /**
     * main function.
     *
     * @param args - args.
     */
    public static void main(String[] args) {

        String[] data1 = Ex4Utils.file2array("C:\\Users\\User\\IdeaProjects\\OOP\\ex4\\src\\data1.txt");
        String[] data2 = Ex4Utils.file2array("C:\\Users\\User\\IdeaProjects\\OOP\\ex4\\src\\data2.txt");

        testForSets(data1);
        testContain("hi");
        testContain("-1317089015");

        //restarting the sets.
        sets = new SimpleSet[]{new OpenHashSet(), new ClosedHashSet(),
                new CollectionFacadeSet(new TreeSet<String>()),
                new CollectionFacadeSet(new LinkedList<String>()),
                new CollectionFacadeSet(new HashSet<String>())};

        testForSets(data2);
        testContain("23");
        testContain("hi");
    }
}
