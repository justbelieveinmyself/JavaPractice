package String;

import java.text.Collator;
import java.util.*;

public class SortArrayStrings {
    public static void main(String[] args) {
        List<String> strings = new ArrayList<>();
        strings.add("aa");
        strings.add("bb");
        strings.add("cc");
        strings.add("CC");
        strings.add("BB");
        strings.add("AA");
        strings.add("DD");
        strings.add("dd");
        strings.add("ÄÄ");
        Collator collator = Collator.getInstance(Locale.UK);
        //collator.setStrength(Collator.PRIMARY);
        //collator.setStrength(Collator.SECONDARY); //they all dont work
        //collator.setStrength(Collator.TERTIARY);
        //collator.setStrength(Collator.IDENTICAL);
        Collections.sort(strings, collator);
        for(String s : strings){
            System.out.println(s);
        }
    }
}
