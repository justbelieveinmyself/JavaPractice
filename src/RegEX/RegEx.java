package RegEX;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
//.	Any character (may or may not match line terminators)
//\d	A digit: [0-9]
//\D	A non-digit: [^0-9]
//\s	A whitespace character: [ \t\n\x0B\f\r]
//\S	A non-whitespace character: [^\s]
//\w	A word character: [a-zA-Z_0-9]
//\W	A non-word character: [^\w]
//\b    A word-boundary character
//^     The beginning of a line
//$     The end of line
public class RegEx {
    public static void main(String[] args) {
        System.out.println("-----------");
        System.out.println("REGEX: a");
        System.out.println("TEXT: This is the test case with a key");
        Pattern pattern = Pattern.compile( "a");
        Matcher matcher = pattern.matcher("This is the test case with a key");
        while(matcher.find()){
            System.out.println(matcher.start()  + " " + matcher.group());
        }
        System.out.println("-----------");
        System.out.println("REGEX: a[^x]");
        System.out.println("TEXT: ax alphabet");
        Pattern pattern2 = Pattern.compile("a[^x]");
        Matcher matcher2 = pattern2.matcher("ax alphabet");
        while(matcher2.find()){
            System.out.println(matcher2.start() + " " + matcher2.group());
        }
        System.out.println("-----------");
        System.out.println("REGEX: 1\\+1=2");
        System.out.println("TEXT: 1+1=2");
        System.out.println("1+1=2 is not working because + is metacharacter! but if we Escape the + character is will work");
        Pattern pattern3 = Pattern.compile("1\\+1=2"); // 1+1=2 is not working because + is metacharacter
        //Pattern pattern3 = Pattern.compile("1+1=2");
//        Pattern pattern3 = Pattern.compile("\\Q1+1=2\\E"); //literally using
        Matcher matcher3 = pattern3.matcher("1+1=2");
        while(matcher3.find()){
            System.out.println(matcher3.start() + " " + matcher3.group());
        }
        System.out.println("-----------");
        String regex1 = "[0-5a-cA-Z]";
        String text1 = "abcdeghABCDEGH123456789";
        System.out.println("REGEX: " + regex1);
        System.out.println("TEXT: " + text1);
        Pattern pattern4 = Pattern.compile(regex1);
        Matcher matcher4 = pattern4.matcher(text1);
        while(matcher4.find()){
            System.out.print(matcher4.start() + " " + matcher4.group() + " ");
        }
        System.out.println();
        System.out.println("-----------");
        String regex2 = "\".*?\"";
        String text2 = "Huston, we have a problem with \"string one\" and \"string two\" \"\", please help us!";
        System.out.println("REGEX: " + regex2);
        System.out.println("TEXT: " + text2);
        Pattern pattern5 = Pattern.compile(regex2);
        Matcher matcher5 = pattern5.matcher(text2);
        while(matcher5.find()){
            System.out.print(matcher5.start() + " " + matcher5.group() + " ");
        }
        System.out.println();
        System.out.println("Output without ?: 31 \"string one\" and \"string two\" . Its because default usage of greedy regex. We find \"\" because use * instead of +");

        System.out.println("-----------");
        String regex3 = "ne$";
        String text3 = "This is the first line\nand this is the second line";
        System.out.println("REGEX: " + regex3);
        System.out.println("TEXT: " + text3);
        Pattern pattern6 = Pattern.compile(regex3, Pattern.MULTILINE); // When in MULTILINE mode $ matches just before a line terminator
        // or the end of the input sequence.
        Matcher matcher6 = pattern6.matcher(text3);
        while(matcher6.find()){
            System.out.print(matcher6.start() + " " + matcher6.group() + " ");
        }
        System.out.println();
        System.out.println("When in MULTILINE mode $ matches just before a line terminator or the end of the input sequence.");

        System.out.println("-----------");
        String regex4 = "he\\b";
        String text4 = "hello hero he helmet lonhe";
        System.out.println("REGEX: " + regex4);
        System.out.println("TEXT: " + text4);
        Pattern pattern7 = Pattern.compile(regex4);
        Matcher matcher7 = pattern7.matcher(text4);
        while(matcher7.find()){
            System.out.print(matcher7.start() + " " + matcher7.group() + " ");
        }
        System.out.println();

    }
}
