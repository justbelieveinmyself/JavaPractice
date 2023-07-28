package String;

import java.util.Calendar;
import java.util.Date;

public class StringFormat {
    static ExampleNullRef nullRef;
    public static void main(String[] args) {
        Calendar cal = Calendar.getInstance();
        String s1 = String.format("Hello %s, now is %tr. I'm %d years old.", "Vadim", cal, 15);
        String s2 = String.format("Hello %s, now is %tr. I'm %s years old.", "Vadim", new Date(), 15); // decimal to string conversion
        String sBoolean = String.format("Bool is %b", true); // true/false or obj
        String sBooleanWithNull = String.format("Bool is %b", nullRef); // если передать null, то будет false
        String sHashCode = String.format("Hello %h!","world");
        String sChar = String.format("Hello w%crld!",'o');
        String sFloat = String.format("Digital Pi = %f", Math.PI);
        String sFloatWithPrecision = String.format("Digital Pi with precision 2 = %.2f", Math.PI);
        String sExponent = String.format("Digital Pi = %e", Math.PI);
        String sToCharInt = String.format("IDC that this simbol in ASCII? SHOW ME - %x", 15);
        String sToDate = String.format("Today is weekly day - %tA", new Date()); // Для форматирования требуются дополнительные флаги
        // %[аргумент_индекс][флаги][ширина][.точность]спецификатор типа
        /*
        [аргумент_индекс] — целое число, указывающее позицию в списке аргументов. К примеру, ссылка на первый аргумент 1$, ссылка на
        второй аргумент — 2$, и т.д. Если же позиция не была задана, аргументы должны находиться в том же порядке, что и ссылки на них в строке форматирования.
        [флаги] — специальные символы для форматирования. Например:
            + флаг, означающий, что если числовое значение положительное, оно должно включать знак +
            - означает выравнивание результата по левому краю
            , устанавливает разделитель тысяч у целых чисел
        [ширина] — положительное целое десятичное число, определяющее минимальное количество символов, которые будут выведены. Если перед этим числом стоит 0, то недостающие символы будут дополнены 0, если 0 нет, то пробелами.
        [.точность] — неотрицательное целое число с точкой перед ним. Как правило используется для ограничения количества символов. Специфика поведения зависит от конкретного вида спецификатора.
         */
        System.out.println(s1);
        System.out.println(s2);
        System.out.println(sBoolean);
        System.out.println(sBooleanWithNull);
        System.out.println(sHashCode);
        System.out.println(sChar);
        System.out.println(sFloat);
        System.out.println(sFloatWithPrecision);
        System.out.println(sExponent);
        System.out.println(sToCharInt);
        System.out.println(sToDate);

    }
    static class ExampleNullRef{
    }
}

/*
%a Шестнадцатеричное значение с плавающей точкой

%b Логическое (булево) значение аргумента

%c Символьное представление аргумента

%d Десятичное целое значение аргумента

%h Хэш-код аргумента

%e Экспоненциальное представление аргумента

%f Десятичное значение с плавающей точкой

%g Выбирает более короткое представление из двух: %е или %f

%o Восьмеричное целое значение аргумента

%n Вставка символа новой строки

%s Строковое представление аргумента

%t Время и дата

%x Шестнадцатеричное целое значение аргумента

%% Вставка знака %
 */
