//NAME: Audrey Huangjin
import java.util.*;
public class ISU {
    public static void main(String[] args) {
        //Scanner created
        Scanner input = new Scanner(System.in);
        //adding in 5 students' information using arraylists in order
        ArrayList<String> firstNames = new ArrayList<>();
        firstNames.add("Max");
        firstNames.add("Dustin");
        firstNames.add("Mike");
        firstNames.add("Will");
        firstNames.add("Robin");
        ArrayList<String> lastNames = new ArrayList<>();
        lastNames.add("Mayfield");
        lastNames.add("Henderson");
        lastNames.add("Wheeler");
        lastNames.add("Byers");
        lastNames.add("Buckley");
        ArrayList<Integer> grades = new ArrayList<>();
        grades.add(70);
        grades.add(90);
        grades.add(85);
        grades.add(75);
        grades.add(95);
        ArrayList<Integer> id = new ArrayList<>();
        id.add(1001);
        id.add(1002);
        id.add(1003);
        id.add(1004);
        id.add(1005);
        //id number base for whenever a new student is added or removed (put outside so that the program doesnt refresh the number)
        int idNum = 1005;
        // Greeting message
        System.out.println("\nHello! Welcome to the Course Management System!\nPlease pick an option from the menu: ");
        //Loops main menu and options so that it can go back when it needs to unless option 8 is picked
        int choice = 0;
        while(choice != 8) {
            //Formatted so that the code doesn't run off the page
            System.out.println("\n1. Add a student\n" +
                    "2. Average of class marks\n" +
                    "3. Minimum and Maximum mark in the class\n" +
                    "4. Display the list of the students\n" +
                    "5. Display the Mark Distribution\n" +
                    "6. Search a Student\n" +
                    "7. Display the top and bottom 20%\n" +
                    "8. Exit the program\n");
            //asking for user input
            System.out.println("\nWhich action do you want to take?: ");
            choice = input.nextInt();
             //Starts actions for each choice
            if(choice == 1){
                 //Add a student
                 //For loop that stops when the user adds more than 2 students
                 for(int i = 0; i < 2; i++){
                     System.out.println("\nEnter new student's first name: ");
                     firstNames.add(input.next());
                     System.out.println("Enter new student's last name: ");
                     lastNames.add(input.next());
                     System.out.println("Enter new student's grade: ");
                     int temp = input.nextInt();
                     if(temp > 100 || temp < 0){ //if they enter a number greater than 100 or smaller than 0, it will redirect them
                         System.out.println("Invalid input. Enter a number from 0 - 100.");
                         firstNames.removeLast();
                         lastNames.removeLast();
                         break;
                     }
                     else{
                         grades.add(temp);
                         //a new id number should be given to every student, so idNum ++ from 1005 to 1006 and so on
                         idNum++;
                         //Creating and adding new ID to students only AFTER they succesfully added a student
                         id.add(idNum);
                     }
                     //If the user only inputted one student, they can choose to input another
                     if(i != 1) {
                         System.out.println("Do you want to add another student? (yes/no): ");
                         String newStudentAnswer = input.next().toLowerCase();
                         //if they choose no, they get sent back to menu, if they choose yes, then they can add another student
                         if (newStudentAnswer.equals("no")) {
                             break;
                         }else if (newStudentAnswer.equals("yes")){
                             System.out.println("Second Student input: ");
                         }
                     }
                     //If they had already inputted 2 students, it returns to menu automatically

                 }
             } else if (choice == 2){
                 //Class average
                 //creating sum variable
                 double sum = 0.0;
                 for(int i = 0; i < grades.size(); i++){
                     sum+=grades.get(i);
                 }
                 //round to 2 decimal points
                 double average = Math.round((sum / firstNames.size()) * 100.0) / 100.0;;
                 //Sum of default 5 students is 415 if you need it to calculate :)
                 System.out.println("\nThe average of class marks is " + average);

             } else if (choice == 3){
                 //Top and last student
                 //creating minimum and maximum grades, as well as the indexes so we can use them for first and last names
                 int minimum = grades.get(0);
                 int maximum = grades.get(0);
                 int maxIndex = 0;
                 int minIndex = 0;
                 for(int i = 0; i < grades.size(); i++){
                     //code to find minimum; if a number is smaller than the current, it will become the minimum
                    if(grades.get(i) < minimum){
                        minimum = grades.get(i);
                        minIndex = i;
                    }
                    //same for maximum
                    if(grades.get(i) > maximum){
                        maximum = grades.get(i);
                        maxIndex = i;
                    }
                 }
                 //printing out grades and names
                 System.out.println("\nThe lowest mark in the class is: " + minimum + "%\nBelonging to: " + firstNames.get(minIndex) +" "+lastNames.get(minIndex));
                 System.out.println("The highest mark in the class is: " + maximum + "%\nBelonging to: " + firstNames.get(maxIndex) +" "+lastNames.get(maxIndex));

             } else if (choice == 4){
                 //display students
                 for (int i = 0; i < firstNames.size(); i++) {
                     System.out.println("["+ id.get(i) + "]"+ "  " + firstNames.get(i) + "  " + lastNames.get(i) + "  " + grades.get(i));
                 }
                 System.out.println("\n1. Edit a Student\n2. Remove a Student\n3. Return to Main Menu");
                 System.out.println("Which action would you like to take?: ");
                 int subChoice = input.nextInt();
                 //splitting into 3 choices
                 if(subChoice == 1){
                     //edit student based on id
                     System.out.println("Enter ID of student you wish to edit: ");
                     int editedID = input.nextInt();
                     if(!id.contains(editedID)){
                         //catches if user enters invalid ID
                         System.out.println("ID not found. Please try again.");
                     } else {
                         //use for loop in order to check which index the id is in order to find which student it is
                         for (int i = 0; i < firstNames.size(); i++) {
                             if (id.get(i) == editedID) {
                                 //updates student info at that index
                                 System.out.println("Enter new mark: ");
                                 int check = input.nextInt();
                                 //checks if the grade is valid, and if not, it boots the user out
                                 if (check > 100 || check < 0) {
                                     System.out.println("Invalid input. Enter a number from 0 - 100.");
                                     break;
                                 } else {
                                     //if grade is valid, it continues updating student information
                                     grades.set(i, check);
                                     System.out.println("Enter new first name: ");
                                     firstNames.set(i, input.next());
                                     System.out.println("Enter new last name: ");
                                     lastNames.set(i, input.next());
                                     System.out.println("Successfully Updated!");
                                 }
                             }
                         }
                     }
                 } else if (subChoice == 2) {
                     //removing student
                     System.out.println("Enter ID of student you wish to remove: ");
                     int removeID = input.nextInt();
                     //same concept as above where you use ID to find index of student and such
                     for (int i = 0; i < firstNames.size(); i++) {
                         if (id.get(i) == removeID) {
                             firstNames.remove(i);
                             lastNames.remove(i);
                             grades.remove(i);
                             id.remove(i);
                             break;
                         }
                     }
                     System.out.println("Successfully Removed.");
                 }
                //if 3 is pressed, then it will automatically return to main menu
             } else if (choice == 5){
                 //printing grade distribution
                 //create integers
                 int A = 0;
                 int B = 0;
                 int C = 0;
                 int D = 0;
                 int F = 0;
                 //find how many students fall under each one
                 for (int i = 0; i < grades.size(); i++) {
                     int grade = grades.get(i);
                     if (grade >= 80){
                         A++;
                     } else if (grade >= 70){
                         B++;
                     } else if (grade >= 60){
                         C++;
                     } else if (grade >= 50){
                         D++;
                     } else{
                         F++;
                     }
                 }
                 //find which column is the tallest to print
                 //go from top to bottom so you need to know how high you print the first
                 int maxColumn = A;
                 if (B > maxColumn){
                     maxColumn = B;
                 }
                 if (C > maxColumn){
                     maxColumn = C;
                 }
                 if (D > maxColumn){
                     maxColumn = D;
                 }
                 if (F > maxColumn){
                     maxColumn = F;
                 }
                 //use max to find how high to start so when moving down, it won't cut off any numbers
                 for (int i = maxColumn; i > 0; i--) {
                     // column a
                     //if A is greater than the max, then print it, so i.e A has 2 students, max is 5. when i reaches 2,
                     //a will print one, and when i reaches 1, then a > 1 so it will print another one.
                     if (A >= i){
                         System.out.print(" # ");
                     } else{
                         System.out.print("   ");
                     }
                     // column b
                     if (B >= i){
                         System.out.print(" # ");
                     } else{
                         System.out.print("   ");
                     }
                     // column c
                     if (C >= i){
                         System.out.print(" # ");
                     } else{
                         System.out.print("   ");
                     }
                     // column d
                     if (D >= i){
                         System.out.print(" # ");
                     } else{
                         System.out.print("   ");
                     }
                     // column f
                     if (F >= i){
                         System.out.print(" # ");
                     } else{
                         System.out.print("   ");
                     }
                     // made a new line to move to new row
                     System.out.println();
                 }
                 // printed labels and spacing
                 System.out.println("--------------");
                 System.out.println(" A  B  C  D  F");

             } else if (choice == 6){
                 //search student + relation to class average
                 //Redo average since previous average variable doesn't work
                 double averageSix = 0;
                 for (int i = 0; i < grades.size(); i++) {
                     averageSix += grades.get(i);
                 }
                averageSix = averageSix/firstNames.size();
                 //create new average to compare grades to
                 System.out.println("\nEnter first name, last name, or a part of the first or last names: ");
                 String search = input.next().toLowerCase();
                 boolean found = false;
                 //if the student the user inputted does not exist, it catches it
                 for(int i = 0; i < firstNames.size(); i++){
                     //search to see which index is the piece of the name from
                     if(firstNames.get(i).toLowerCase().contains(search)||lastNames.get(i).toLowerCase().contains(search)){
                         found = true;
                         System.out.println("["+id.get(i)+"]  "+ firstNames.get(i)+"  "+lastNames.get(i)+"  "+grades.get(i));
                         //check if student's grades are above, below or on average value
                         if(grades.get(i) > averageSix){
                             System.out.println("This student is above average.");
                         } else if(grades.get(i) < averageSix){
                             System.out.println("This student is below average.");
                         } else {
                             System.out.println("This student has the average grade.");
                         }
                     }
                 }
                 if(!found){
                     System.out.println("Student not found. Try again.");
                     //boots them out and lets them try again if they choose option 6
                 }

             } else if (choice == 7){
                //top and bottom 20%
                 //find how many people should be in the top / bottom 20
                 int numberOfStudents = firstNames.size()/5;
                 //safety to ensure that even if there are 3 people, at least one will be top 20, one will be bottom 20
                 if(numberOfStudents < 1){
                     numberOfStudents = 1;
                 }
                 //making arraylists to keep track of max indexes that have already been used for students so theres no repeats
                 ArrayList<Integer> usedMax = new ArrayList<>();
                 ArrayList<Integer> usedMin = new ArrayList<>();
                 System.out.println("\nTop 20% Students:\n");
                 // use for loop to make sure to get all  the top students
                 for (int i = 0; i < numberOfStudents; i++) {
                     int maxSeven = 0;
                     int maxIndexSeven = 0;
                     //max is to compare values, maxIndex is to find index to use for finding names and stuff
                     //find indexes of biggest grades
                     for (int j = 0; j < grades.size(); j++) {
                         // skip already used indexes
                         if (!usedMax.contains(j) && grades.get(j) > maxSeven) {
                             maxSeven = grades.get(j);
                             maxIndexSeven = j;
                         }
                     }
                     //update arraylist to include used indexes
                     usedMax.add(maxIndexSeven);
                     System.out.println(firstNames.get(maxIndexSeven) + "  " + lastNames.get(maxIndexSeven) + "  " + grades.get(maxIndexSeven));
                 }
                 System.out.println("\nBottom 20% Students:\n");
                 // same thing as top
                 for (int i = 0; i < numberOfStudents; i++) {
                     int minSeven = 100;
                     int minIndexSeven = 0;

                     //find indexes of smallest grades
                     for (int j = 0; j < grades.size(); j++) {
                         // skip already used indexes
                         if (!usedMin.contains(j) && grades.get(j) < minSeven) {
                             minSeven = grades.get(j);
                             minIndexSeven = j;
                         }
                     }
                     //update arraylist to include used indexes
                     usedMin.add(minIndexSeven);
                     System.out.println(firstNames.get(minIndexSeven) + "  " + lastNames.get(minIndexSeven) + "  " + grades.get(minIndexSeven));
                 }

             } else if (choice == 8){
                 System.out.println("Thank you for using the CMS!");
             } else {
                 //If input is not 1 - 8, it prints this message so there's no error
                 System.out.println("Input not recognized. Enter the corresponding number to the action you want to take.");
             }

        }
        input.close();
        //END!! For more information, read the README file! Have a great day Ms Rastegar!
    }
}
