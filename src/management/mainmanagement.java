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
                case 1://Create
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
                        if (count >= 2) {
                            System.out.println("Do you want to continue (Y/N)? Choose Y to continue, N to return main screen.");
                            String choi = sc.next();
                            if (choi.equalsIgnoreCase("N")) {
                                check = false;
                            }
                        }
                    } while(check);
                    break;
                case 2://Find
                    System.out.println("Enter the name you want to search");
                    String searchName = sc.next();
                    /*for (stu items: stuList) {
                        if (items.getStudentName().equals(searchName)) {
                            items.showDisplay();
                            break;
                        }else {
                            System.out.println("Not found!!!" + searchName);
                        }
                    }*/
                    int counter = 0;
                    for (int i = 0; i < stuList.size(); i++) {
                        if (stuList.get(i).getStudentName().contains(searchName)) {
                            stuList.sort((o1, o2) -> o1.getStudentName().compareTo(o2.getStudentName()));
                            stuList.get(i).showDisplay();
                            counter++;
                        }
                    }
                    if (counter == 0) {
                        System.out.println("Not found!!!" + searchName);
                    }
                    break;
                case 3://update/delete
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
                case 4://Report
                    ArrayList<stu> tempArray = new ArrayList<>();
                    for (int i = 0; i < stuList.size(); i++) {
                        for (int j = 0; j < stuList.size(); j++) {
                            String name1 = stuList.get(i).getStudentName();
                            String name2 = stuList.get(j).getStudentName();
                            String course1 = stuList.get(i).getCourseName();
                            String course2 = stuList.get(i).getCourseName();
                            if((name1.equals(name2))&&(course1.equals(course2))){
                                int a = 1; a++; stuList.get(i).setCount(a);
                            }
                        }
                    }
                    for (int i = 0; i < stuList.size(); i++) {
                        for (int j = 0; j < stuList.size(); j++) {
                            String name1 = stuList.get(i).getStudentName();
                            String name2 = stuList.get(j).getStudentName();
                            String course1 = stuList.get(i).getCourseName();
                            String course2 = stuList.get(i).getCourseName();
                            if ((name1.equals(name2))&&(course1.equals(course2))){
                                stuList.remove(i);
                            }
                        }
                    }
                    for (int i = 0; i < stuList.size(); i++) {
                        System.out.println("The Report:");
                        System.out.println(stuList.get(i).getStudentName()+" | "+stuList.get(i).getCourseName()+" | "+stuList.get(i).getCount()+"\n");
                    }
                    break;
                case 5: //exit
                    System.exit(0);
                    break;
                default: System.out.println("Please choose again"); break;
            }
        }
    }
}

