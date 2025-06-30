package org.ckb;

public class Session1 {

    public static void main(String[] args) {
        //primitive
//        int value = 0;
//        float floatVal = 1.0f;
//        double doubleVal = 2.00d;
//        char charVal = 'a';
//        boolean boolVal = true;
//
//
//        //wraapper class
//        String str = "abc";
//        Integer integerVal = 1;
//        Boolean booleanVal = Boolean.FALSE;

//        System.out.println("boolVal = " + booleanVal);


//        if (value == 0 && boolVal)
//            System.out.println("value is 0");
//        else
//            System.out.println("not mastched...");
//
//        if (value == 0 || boolVal) {
//            System.out.println("value is 0");
//        }
//        else {
//            System.out.println("not mastched...");
//        }


        //loop
//
//        int[] arr= {1,2,3,4,5,6};
//        //for loop
//
//        for (int i = arr.length - 1; i >= 0; i--) System.out.println(arr[i]);

        //while
//        int i = 0, j = 5;
//        while (i <= j) {
//            System.out.println("i: " + i + " - j: " + j);
//            i++;
//            j--;
//        }


//        i = 5; j = 3;
        //do while
//         do {
//            System.out.println("i: " + i + " - j: " + j);
//            i++;
//            j--;
//        } while (i <= j);

//        int[] arr= {1,20, 7, 28, 11, 13, 4,1,20, 7, 28, 11, 13, 4, 1,20, 7, 28, 11, 13, 4};

//        max = -1;
//        (0 -> arr.length - 1)
//                if(curr > max) max = curr;
//        
//        return max;

//
//        int max = Integer.MIN_VALUE;
//        int min = Integer.MAX_VALUE;
//        for (int i = 0; i < arr.length; i++) {
//            if (arr[i] > max) max = arr[i];
//            if (arr[i] < min) min = arr[i];
//        }
//
//        System.out.println("max = " + max);
//        System.out.println("min = " + min);
//
//
//
//        String[] daysOfWeek = {"Mon", "Tue"};

        //linear search
        //binary search


        //daily min 10 problems - without autocomplete - 20 days
        //random number from 1 to 100
//        int random = (int) (Math.random() * 100); //20
//        System.out.println("random = " + random);
//        Scanner sc = new Scanner(System.in);
//        System.out.println("Enter the number to guess: ");
//        int guessNumber = sc.nextInt(); //TODO
//        while (guessNumber > 0) {
//            if(guessNumber == random) {
//                System.out.println("you guessed right!");
//                break;
//            }
//            else if (guessNumber < random) System.out.println("guessed lesser than actual number");
//            else System.out.println("guessed greater than actual number");
//
//            System.out.println("Enter the number to guess: ");
//            guessNumber = sc.nextInt();
//        }
//
//        Integer.parseInt("101");
//
//        System.out.println("actual number: " + random);

//       do {
//           System.out.println("Enter the number to guess");
//
//           guessNumber = sc.nextInt();
//           if(guessNumber < 0) {
//               System.out.println("actual value: " + random);
//               break;
//           }
//           if(guessNumber == random) {
//               System.out.println("you guessed right!");
//               break;
//           }
//           else if (guessNumber < random) System.out.println("guessed lesser than actual number");
//           else System.out.println("guessed greater than actual number");
//
//       } while (guessNumber > 0);


        //************* 7th Aug, 2024 ************///

//        int[] arr = new int[5];
//        arr[0] = 1;
//        for (int i = 1; i < 5; i++) {
//            arr[i] = i + 1;
//        }
//        System.out.println(Arrays.toString(arr));


//       Student1[] students = new Student1[5];
//        for (int i = 0; i < students.length; i++) {
//            students[i] = new Student1(i + 1, "name" + (i + 1));
//        }
//
//        System.out.println(Arrays.toString(students));


//        Student1 student = new Student1();
//        student.name = "Digy";
//        student.rollNo = 1;
//
//        System.out.println(student.getRollNo());

        //************* 7th Aug, 2024 ************///


        //************* 10th Aug, 2024 ************///


        Employee emp1 = new Employee(1, "ABC", 30);


        System.out.println(emp1);

        //************* 10th Aug, 2024 ************///

    }

}


class Student1 {
    private int rollNo;
    String name;

    Student1() {
    } //no return type, constructor name same as class name

    Student1(int rollNo, String name) {
        this.rollNo = rollNo;
        this.name = name;
    }

//    int getRollNo() {
//        return this.rollNo;
//    }

    public String toString() {
        return "{ " + this.rollNo + " - " + this.name + " }";
    }
}


class Employee {
    private int emploeeId;
    private String employeeName;
    private int age;
    private String date;

    {
        System.out.println("inside block...");
        date = "today";
    }

    //Constructor


    public Employee(int emploeeId, String employeeName, int age) {
        System.out.println("inside constructor...");
        this.emploeeId = emploeeId;
        this.employeeName = employeeName;
        this.age = age;
    }


//    sequence : 1. var declaration , 2. block execution, 3. Constructor execution


    //getters & setters


    public int getEmploeeId() {
        return emploeeId;
    }

    public void setEmploeeId(int emploeeId) {
        this.emploeeId = emploeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "emploeeId=" + emploeeId +
                ", employeeName='" + employeeName + '\'' +
                ", age=" + age +
                ", date='" + date + '\'' +
                '}';
    }
}


//compile-load-run
//java memory
//class: member methods & variables,  block, static block, inner class
//static
//final
//constructor
//compile time and runtime check/errors
//operators, ternary operators


//array, 2d array


