package com.justbelieveinmyself;

public class RecordsExample {
    public static void main(String[] args) {
        Point point = new Point(10,15); //instance fields of a record are automatically final but they may be
        // references to mutable objects
        System.out.println(point.x());
        System.out.println(point.y());
        System.out.println("Point 2");
        Point2 point2 = new Point2(10,15);
        System.out.println(point2.x());
        System.out.println(point2.y());
        point2.myMethod();
        System.out.println("Point2 name: " + Point2.name);
        Point2.myStaticMethod();
    }
}
record Point(int x, int y){} //uses canonical constructor
record Point2(int x, int y){
//    public String name; //non-static instance field is not allowed in record
    public static String name = "default";
    public Point2(){ //custom constructor
        this(0,0);
    }
    public int x(){
        return x;
    }
    public void myMethod(){
        System.out.println("Point2 method");

    }
    public static void myStaticMethod(){
        System.out.println("Point2 static method");
    }
}
record Range(int from, int to){ // changing canonical constructor
    public Range(int from, int to)
    {
        if(from < to){
            this.from = from;
            this.to = to;
        }
        else{
            this.from = to;
            this.to = from;
        }
    }
}
record Range2(int from, int to){ // compact canonical constructor
    public Range2{ //prelude to canonical
        if(from > to){
            int temp = from;
            from = to;
            to = temp;
        }
    }
}