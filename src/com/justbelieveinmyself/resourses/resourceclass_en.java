package Localization.resourses;

import java.util.ListResourceBundle;

public class resourceclass_en extends ListResourceBundle {
    private static final Object[][] contents =
    {
            { "somevalue", "This text on english"},
            { "anothervalue", "text 11"}
    };
    @Override
    public Object[][] getContents(){
        return contents;
    }
}
