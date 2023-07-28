package RegEX;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MatchingModes {
    public static void main(String[] args) {
        Pattern p = Pattern.compile("a", Pattern.CASE_INSENSITIVE);
//        Pattern p = Pattern.compile("A#this is commet", Pattern.COMMENTS);
////        Pattern p = Pattern.compile("a", Pattern.MULTILINE);
        Matcher m = p.matcher("A");
        while(m.find()) {
            System.out.print(m.start() + " " + m.group() + " ");
        }
        System.out.println("");
//
//        System.out.println("A".matches("(?i)a")); //insensitive
//        "A".matches("(?s)a");//single line
//        "A".matches("(?m)a");//multiline
//        System.out.println("A".matches("(?x)A#this is comment"));//comments and also ignoring the whitespaces
//        System.out.println("A".matches("(?ix)a#this is comment")); //insensitive and comments
//        System.out.println("AA".matches("(?i)a(?-i)a")); //insensitive and after sensitive
//        System.out.println("AAA".matches("(?i)a(?-i:A)a")); // insensitive and
    }

}
