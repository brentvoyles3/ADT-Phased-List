package cs1302.p2;

import cs1302.adt.StringList;
import cs1302.oracle.OracleStringList;

/**
 * Class containing the main method for the {@code StringList} implementations. Used
 * for testing purposes only.
 */
public class Driver {

    public static void main(String[] args) {
        StringList s2 = new OracleStringList();
        StringList s2 = new LinkedStringList();
        StringList s2 = new ArrayStringList();

        s2.add(0, "hello");
        s2.add(1, "world");
        s2.add(2, "lorem");
        s2.add(3, "ipsum");
        s2.add(4, "Jake");

        System.out.println(s2);
        System.out.println("Removing: " + s2.remove(1));
        System.out.println(s2);
    }
} //Driver
