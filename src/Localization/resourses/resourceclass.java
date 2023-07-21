package Localization.resourses;

import java.util.ListResourceBundle;

public class resourceclass extends ListResourceBundle {
    private static final Object[][] contents =
            {
                    { "somevalue", "This text on english"},
                    { "anothervalue", "text 11"}
            };
    @Override
    protected Object[][] getContents() {
        return contents;
    }
}
