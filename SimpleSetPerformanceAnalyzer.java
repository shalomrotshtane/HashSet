import java.util.HashSet;
import java.util.LinkedList;
import java.util.TreeSet;


/**
 * this function test the run time in different sets.
 */
public class SimpleSetPerformanceAnalyzer {


    //all the sets kind that the class test.
    private static CollectionFacadeSet[] sets = new CollectionFacadeSet[]{
        new CollectionFacadeSet(new OpenHashSet(), "OpenHashSet" ),
                new CollectionFacadeSet(new ClosedHashSet(), "ClosedHashSet" ),
                new CollectionFacadeSet(new TreeSet<>(), "TreeSet"),
                new CollectionFacadeSet(new LinkedList<>(), "LinkedList"),
                new CollectionFacadeSet(new HashSet<>(), "HashSet")};


    /**
     * this function gets data and test all the 5 kind of set.
     *
     * @param data - string list.
     */
    private static void testForSets(String[] data) throws Exception {
        for (CollectionFacadeSet set : sets) {
            System.out.println("Starting testing: " + set.name);
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
        for (CollectionFacadeSet set : sets) {
            System.out.println("Starting testing: " + set.name);
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

        String[] data1 = Ex4Utils.file2array("C:\\Users\\User\\IdeaProjects\\HashSet\\src\\data1.txt");
        String[] data2 = Ex4Utils.file2array("C:\\Users\\User\\IdeaProjects\\HashSet\\src\\data2.txt");
        String[] data3 = Ex4Utils.file2array("C:\\Users\\User\\IdeaProjects\\HashSet\\src\\data3.txt");

        try{

/*            ClosedHashSet ohs = new ClosedHashSet(data3);
            for(int i = 1; i <= 1000; i++){
                ohs.add(Integer.toString(i));
                ohs.add(Integer.toString(-i));
                System.out.println("size: " + ohs.size());
                System.out.println("capacity: " + ohs.capacity());
            }

            for(int i = 1; i <= 1000; i++){
                System.out.println(ohs.contains(Integer.toString(i)) && ohs.contains(Integer.toString(-i)));
            }

            System.out.println(ohs);
*//*            for(int i = 1; i <= 1000; i++){
                System.out.println(ohs);
            }*//*


            for(int i = 1; i <= 1000; i++){
                ohs.delete(Integer.toString(i));
                ohs.delete(Integer.toString(-i));
                System.out.println("size: " + ohs.size());
                System.out.println("capacity: " + ohs.capacity());
            }
            for(int i = 1; i <= 1000; i++){
                System.out.println(ohs.contains(Integer.toString(i)) && ohs.contains(Integer.toString(-i)));
            }
            System.out.println(ohs.contains("50"));*/




            testForSets(data1);
            testContain("hi");
            testContain("-1317089015");

            //restarting the sets.
            sets = new CollectionFacadeSet[]{
                    new CollectionFacadeSet(new OpenHashSet(), "OpenHashSet" ),
                    new CollectionFacadeSet(new ClosedHashSet(), "ClosedHashSet" ),
                    new CollectionFacadeSet(new TreeSet<>(), "TreeSet"),
                    new CollectionFacadeSet(new LinkedList<>(), "LinkedList"),
                    new CollectionFacadeSet(new HashSet<>(), "HashSet")};

            testForSets(data2);
            testContain("23");
            testContain("hi");
        } catch (Exception e){
            System.out.println(e.getMessage());

        }
    }
}
