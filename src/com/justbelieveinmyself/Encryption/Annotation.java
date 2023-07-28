package Encryption;


import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Field;

public class Annotation {
    public static void main(String[] args) throws IllegalAccessException {
        Annotation annotation = new Annotation();
        Person person = new Person();
        annotation.printFieldsWithMyAnnotation(person);
    }
    void printFieldsWithMyAnnotation(Object o) throws IllegalAccessException {
        Field[] fields = o.getClass().getDeclaredFields();
        for(Field field : fields){
            java.lang.annotation.Annotation[] annotations = field.getDeclaredAnnotations();
            for(java.lang.annotation.Annotation annotation : annotations){
                if(annotation.annotationType().equals(ShowField.class))
                    System.out.println(field.get(o));
            }
        }
    }
    static class Person{
        @ShowField
        public String name = "Vadim";
        @ShowField
        private int age = 15;
        void goSleep(){

        }
    }
}

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@interface ShowField{

}