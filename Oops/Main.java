package Oops;



public class Main {
    public static void main(String[] args) {
        // store 5 roll nos
        //int[] numbers = new int[5];

        // store 5 names
       // String[] names = new String[5];

        // Data of 5 student:(roll nos,name,marks)
        // int[] rno = new int[5];
        // String[] nm = new String[5];
        // float[] mks = new float[5];

        // own data type
        // Student[] students=new Student[5];
        // student student1;
        // System.out.println(Arrays.toString(students));
        student janagan;
        janagan = new student();
        // janagan.rno=7;
        System.out.println(janagan.rno);
        janagan.changeName("Janagan");
        janagan.greeting();
        student random = new student(janagan);
        System.out.println(random.name);

        student one = new student();
        student two = one;
        one.name = "Hugh";
        System.out.println(two.name);

    }
}

class student {
    int rno;
    String name;
    float marks;

    void greeting() {
        System.out.println("Hello, my name is " + name);
    }

    void changeName(String newName) {
        name = newName;
    }

    student() {
        // this is how you call a constructor from another constructor
        // internally:new student();
        // this(13,"Ryan",99.0f);
        this.rno = 7; // janagan.rno
        this.name = "janagan";
        this.marks = 99.9f;
    }

    student(student other) {
        this.rno = other.rno;
        this.name = other.name;
        this.marks = other.marks;
    }

    student(int rno, String name, float marks) {
        this.rno = rno; // janagan.rno
        this.name = name;// while passing variable in arg without this keyword, it will not work
        this.marks = marks;
    }
}