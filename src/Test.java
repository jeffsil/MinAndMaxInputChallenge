import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * It is well known that nuclear launch codes work both forward and reverse,
 * meaning that code "123" is effectively the same as code "321", a major
 * security flaw which we have top people working to correct. Someone has stolen
 * an extremely long list of stolen launch codes, and you want to see how many
 * "effective" codes were stolen, so that you know what codes to replace
 *
 * Determine how many unique codes are contained in an array of nuclear launch
 * codes.
 *
 * Please report the big-O runtime complexity of your solution
 *
 * @author Kyle K.
 *
 */
class Tests {

    public static int getNumUniqueCodes(String[] codes) {

        // remove duplicates
        List<String> codesList = new ArrayList<String>(Arrays.asList(Arrays.stream(codes)
                .distinct().toArray(String[]::new)));

        if (codesList.size() == 1) {
            return 1;
        }

        // for each index, convert it to reverse and then compare reverse with index+1
        //  if reverse equals index+1 then remove that index from the codeList
        for (int i=0; i < codesList.size(); i++) {
            String reverseString = new StringBuilder(codesList.get(i)).reverse().toString();
            for (int j=(i+1); j<codesList.size(); j++) {
                    if (codesList.get(j).equalsIgnoreCase(reverseString)) {
                        codesList.remove(i);
                    }
            }
        }

        return codesList.size();
    }

    public static void main(String[] args) {
        String[][] tests = {
                {"xy", "yx"}, // expected 1
                {"xy", "yx", "asdf", "fdsa"}, //expected 2
                {"x", "x"}, //expected 1
                {"xy", "yx", "asdf", "fdsa", "qwer", "yxy", "yxy"}, //expected 4
                {"xy", "yx", "xy", "xy", "asdf", "fdsa", "qwer", "yxy", "yxy"}, //expected 4
                {""}, //expected 1
                {}, //expected 0
                {"xy"}, //expected 1
                {"xy", "yxz"}, //expected 2
                {" abc", " cba"}, //expected 2
                {"abc", "xyz", "abc", "123", "zyx"}, //expected 3
                {"abcd", "dbca"} //expected 2
        };

        int[] expected = {1,
                2,
                1,
                4,
                4,
                1,
                0,
                1,
                2,
                2,
                3,
                2};

        boolean allTestPassed = true;
        for (int i = 0; i < tests.length; i++) {
            int numDetected = getNumUniqueCodes(tests[i]);
            if (numDetected != expected[i]) {
                allTestPassed = false;
                System.out.println("Incorrect number of codes for test case " + i + ". Expected " + expected[i] + ", but detected " + numDetected);
            }
        }
        if (allTestPassed) {
            System.out.println("All Tests Pass!");
        }
    }


}
