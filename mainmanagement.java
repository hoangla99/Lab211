package management;
import java.util.*;

public class mainmanagement {
    public static void main(String[] args) {
        ArrayList<stu> stuList = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("WELCOME TO STUDENT MANAGEMENT");
            System.out.println("1. Create\n" + "2. Find and Sort\n" + "3. Update/Delete\n" + "4. Report\n" + "5. Exit");
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    int count = 0;
                    boolean check = true;
                    do {
                        stu student = new stu();
                        student.create();
                        System.out.println("Enter Course name" + "(.NET, JAVA, C/C++)");
                        String courseName = sc.next();
                        student.setCourseName(courseName);
                        stuList.add(student);
                        count++;
                        if (count > 2) {
                            System.out.println("Do you want to continue (Y/N)? Choose Y to continue, N to return main screen.");
                            String choi = sc.next();
                            if (choi.equalsIgnoreCase("N")) {
                                check = false;
                            }
                        }
                    } while(check);
                    break;
                case 2:
                    System.out.println("Enter the name you want to search");
                    String searchName = sc.next();
                    for (stu items: stuList) {
                        if (items.getStudentName().equals(searchName)) {
                            items.showDisplay();
                        }else {
                            System.out.println("Not found!!!" + searchName);
                        }
                    }break;
                    /*int counter = 0;
                    for (int i = 0; i < stuList.size(); i++) {
                        if (stuList.get(i).getStudentName().contains(searchName)) {
                            stuList.sort((o1, o2) -> o1.getStudentName().compareTo(o2.getStudentName()));
                            stuList.get(i).showDisplay();
                            counter++;
                        }
                    }
                    if (counter == 0) {
                        System.out.println("Not found!!!" + searchName);
                    }*/

                case 3:
                    System.out.println("Enter ID you want to search");
                    String searchID = sc.nextLine();
                    for (int i = 0; i < stuList.size(); i++) {
                        if (stuList.get(i).getStudentID().contains(searchID)) {
                            stuList.get(i).showDisplay();
                            System.out.println("Do you want update(U) or delete(D) student");
                            String choi2 = sc.nextLine();
                            if (choi2.equalsIgnoreCase("U")) {
                                System.out.println("Enter new name: ");
                                stuList.get(i).setStudentName(sc.nextLine());
                                System.out.println("Enter new semester: ");
                                stuList.get(i).setSemester(sc.nextLine());
                                System.out.println("Enter new course name: ");
                                stuList.get(i).setCourseName(sc.nextLine());
                                System.out.println("Successful!!!");
                            } else if (choi2.equalsIgnoreCase("D")) {
                                stuList.remove(i);
                                System.out.println("Successful!!!");
                            }
                        }
                    }
                    break;
                case 4:
                    System.out.println("The Report:");
                    for (int i = 0; i < stuList.size(); i++) {
                        stuList.get(i).showReport();}
                    break;
                case 5:
                    System.exit(0);
                    break;
            }
        }
    }
}

