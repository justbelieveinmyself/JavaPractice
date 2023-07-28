package Date;

import java.text.NumberFormat;
import java.util.Locale;

public class NumFormat {
    public static void main(String[] args) {
        Locale locale = new Locale("en", "us");
        Locale localeDef = new Locale("de", "GR");
        NumberFormat percent = NumberFormat.getPercentInstance();
        System.out.println(percent.format(0.15));
        NumberFormat currency = NumberFormat.getCurrencyInstance(locale);
        System.out.println(currency.format(1000));
        NumberFormat currencyDef = NumberFormat.getCurrencyInstance(localeDef);
        System.out.println(currencyDef.format(1000));
    }
}
