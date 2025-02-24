import java.util.Scanner;

public class Exp_1_Java {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String[] empNo = {"1001", "1002", "1003", "1004", "1005", "1006", "1007"};
        String[] empName = {"Ashish", "Sushma", "Rahul", "Chahat", "Ranjan", "Suman", "Tanmay"};
        String[] joinDate = {"01/04/2009", "23/08/2012", "12/11/2008", "29/01/2013", "16/07/2005", "01/01/2000", "12/06/2006"};
        String[] desigCode = {"e", "c", "k", "r", "m", "e", "c"};
        String[] dept = {"R&D", "PM", "Acct", "Front Desk", "Engg", "Manufacturing", "PM"};
        int[] basic = {20000, 30000, 10000, 12000, 50000, 23000, 29000};
        int[] hra = {8000, 12000, 8000, 6000, 20000, 9000, 12000};
        int[] it = {3000, 9000, 1000, 2000, 20000, 4400, 10000};

        System.out.print("Enter Employee ID: ");
        String inputEmpId = sc.next(); // Fixed variable name and type

        int index = -1;
        for (int i = 0; i < empNo.length; i++) {
            if (empNo[i].equals(inputEmpId)) {
                index = i;
                break;
            }
        }

        if (index == -1) {
            System.out.println("There is no employee with empid: " + inputEmpId);
        } else {
            int da;
            String designation;
            switch (desigCode[index]) {
                case "e":
                    designation = "Engineer";
                    da = 20000;
                    break;
                case "c":
                    designation = "Consultant";
                    da = 32000;
                    break;
                case "k":
                    designation = "Clerk";
                    da = 12000;
                    break;
                case "r":
                    designation = "Receptionist";
                    da = 15000;
                    break;
                case "m":
                    designation = "Manager";
                    da = 40000;
                    break;
                default:
                    designation = "Unknown";
                    da = 0;
            }

            int salary = basic[index] + hra[index] + da - it[index];
            System.out.println("Emp No\tEmp Name\tDepartment\tDesignation\tSalary");
            System.out.println(empNo[index] + "\t" + empName[index] + "\t" + dept[index] + "\t" + designation + "\t" + salary);
        }

        sc.close();
    }
}
