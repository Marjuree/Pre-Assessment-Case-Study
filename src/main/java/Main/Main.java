package Main;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class Main {
    private String code;
  private String peripheralName;
  private String peripheralType;
  private String employeeName;

  Main(String code, String peripheralName, String peripheralType, String employeeName) {
    this.code = code;
    this.peripheralName = peripheralName;
    this.peripheralType = peripheralType;
    this.employeeName = employeeName;
  }

  public String getCode() {
    return this.code;
  }

  public String getName() {
    return this.peripheralName;
  }

  public String getPeripheral() {
    return this.peripheralType;
  }

  public String getEmployeeName() {
    return this.employeeName;
  }

  static int id = 0001;
  static ArrayList<Main> records = new ArrayList<>();

  public static void main(String[] args) {
    Scanner userInput = new Scanner(System.in);

    int loop = 1;
    while (loop != 0) {
      System.out.println("""
          Choose an option:
          a. Add Peripheral
          b. Display Peripherals
          c. Edit Peripheral
          d. Delete Peripheral
          e. Show Report
          f. Exit
          """);
      System.out.print("Enter: ");
      String condition = userInput.next().toLowerCase();

      switch (condition) {
        case "a":
          System.out.print("Enter Peripheral name: ");
          String peripheralName = userInput.next();
          System.out.print("Enter Peripheral Type: ");
          String peripheralType = userInput.next();

          userInput.nextLine();
          System.out.print("Employee Name or leave blank: ");
          String employeeName = userInput.nextLine();

          if (employeeName.isEmpty()) {
            employeeName = "not_assigned";
          }

          Iterator<Main> iterate = records.iterator();
          if (iterate.hasNext()) {
            id++;
          }

          String code = "2023" + String.format("%04d", id);

          Main recordObject = new Main(code, peripheralName, peripheralType, employeeName);
          records.add(recordObject);

          break;
        case "b":

          System.out.println("a. View all peripherals");
          System.out.println("b. View available peripherals");
          System.out.println("c. View not available peripherals");
          System.out.println("d. View all input devices");
          System.out.println("e. View all output devices");
          System.out.println("f. View all input/output devices");
          System.out.println("g. View all employees");

          System.out.println("Enter your choice : ");
          String entered_choice = userInput.next();

          for (var recordLists : records) {
            switch (entered_choice.toLowerCase()) {
              case "a":
              System.out.println("<===========================================================================>");
              System.out.println("Code: " + recordLists.getCode() + " Peripheral Name: " + recordLists.getName()
                  + " Peripheral Type: " + recordLists.getPeripheral() + " Employee: " + recordLists.getEmployeeName());
              System.out.println("<===========================================================================>");
                break;
              case "b":
                if (recordLists.getEmployeeName().equals("not_assigned")) {
                  System.out.println("<===========================================================================>");
                  System.out.println("Code: " + recordLists.getCode() + " Peripheral Name: " + recordLists.getName()
                      + " Peripheral Type: " + recordLists.getPeripheral() + " Employee: " + recordLists.getEmployeeName());
                  System.out.println("<===========================================================================>");
                }
                break;
              case "c":
                if (!recordLists.getEmployeeName().equals("not_assigned")) {
                  System.out.println("<===========================================================================>");
                  System.out.println("Code: " + recordLists.getCode() + " Peripheral Name: " + recordLists.getName()
                      + " Peripheral Type: " + recordLists.getPeripheral() + " Employee: " + recordLists.getEmployeeName());
                  System.out.println("<===========================================================================>");
                }
                break;
              case "d":
                if (recordLists.getPeripheral().equals("input")) {
                  System.out.println("<===========================================================================>");
                  System.out.println("Code: " + recordLists.getCode() + " Peripheral Name: " + recordLists.getName()
                      + " Peripheral Type: " + recordLists.getPeripheral() + " Employee: " + recordLists.getEmployeeName());
                  System.out.println("<===========================================================================>");
                }
                break;
              case "e":
                if (recordLists.getPeripheral().equals("output")) {
                  System.out.println("<===========================================================================>");
                  System.out.println("Code: " + recordLists.getCode() + " Peripheral Name: " + recordLists.getName()
                      + " Peripheral Type: " + recordLists.getPeripheral() + " Employee: " + recordLists.getEmployeeName());
                  System.out.println("<===========================================================================>");
                }
                break;
              case "f":

                if (recordLists.getPeripheral().equals("input/output")) {
                  System.out.println("<===========================================================================>");
                  System.out.println("Code: " + recordLists.getCode() + " Peripheral Name: " + recordLists.getName()
                      + " Peripheral Type: " + recordLists.getPeripheral() + " Employee: " + recordLists.getEmployeeName());
                  System.out.println("<===========================================================================>");
                }
                break;
              case "g":
                if (!recordLists.getEmployeeName().equals("not_assigned")) {
                  System.out.println("<===========================================================================>");
                  System.out.println("Code: " + recordLists.getCode() + " Peripheral Name: " + recordLists.getName()
                      + " Peripheral Type: " + recordLists.getPeripheral() + " Employee: " + recordLists.getEmployeeName());
                  System.out.println("<===========================================================================>");
                }
                break;
                default:
                  System.out.println("<======Invalid input: " + entered_choice + " ======>");
            }
          }

          break;
        case "c":
          System.out.println("Enter record code: ");
          String recordCode = userInput.next();

          int index = 0;
          for (var iterateList : records) {
            if (recordCode.equals(iterateList.getCode())) {
              if (iterateList.getEmployeeName().equals("not_assigned")) {

                System.out.println("Enter Peripheral Name : ");
                String newPeripheralName = userInput.next();
                System.out.println("Enter Peripheral Type : ");
                String newPeripheralType = userInput.next();
                System.out.println("Enter Employee: ");
                String newEmployee = userInput.next();

                System.out.println(newPeripheralName);
                System.out.println(newPeripheralType);
                System.out.println(newEmployee);

                Main newObject = new Main(iterateList.getCode(), newPeripheralName, newPeripheralType, newEmployee);
                records.set(index, newObject);

              } else {

                System.out.println("Peripheral already has employeeName assigned");

              }

            }
            index++;
          }

          break;
        case "d":
          int i = 0;
          System.out.println("Enter record code: ");
          String deleteid = userInput.next();
          try {
            for (var iterateList : records) {
              if (deleteid.equals(iterateList.getCode())) {
                records.remove(i);
                System.out.println("deleted successfully");

              }
              i++;

            }

          } catch (Exception e) {

          }

          System.out.println();
          break;
        case "e":
          int count = 0;
          System.out.println("a. Number of available peripherals");
          System.out.println("b. Number of assigned peripherals");
          System.out.println("c. Number of input device");
          System.out.println("d. Number of output device");
          System.out.println("e. Number of employees with peripherals assigned");

          String choice = userInput.next();
          
          if (choice.equals("a")) {
            for (var recordLists : records) {
              if (recordLists.getEmployeeName().equals("not_assigned")) {
                count++;
              }
            }
            System.out.println("Number of available peripherals :" + count);
          } else if (choice.equals("b")) {
            for (var recordLists : records) {
              if (!recordLists.getEmployeeName().equals("not_assigned")) {
                count++;
              }
            }
            System.out.println("Number of assigned peripherals :" + count);
          } else if (choice.equals("c")) {
            for (var recordLists : records) {
              if (recordLists.getPeripheral().equals("input")) {
                count++;
              }
            }
            System.out.println("Number of input devices:" + count);
          } else if (choice.equals("d")) {
            for (var recordLists : records) {
              if (recordLists.getPeripheral().equals("output")) {
                count++;
              }
            }
            System.out.println("Number of output devices :" + count);
          } else if (choice.equals("e")) {
            for (var recordLists : records) {
              if (!recordLists.getEmployeeName().equals("not_assigned")) {
                count++;
              }
            }
            System.out.println("Number of employees with peripherals assigned :" + count);
          }

          break;
        case "f":
          loop = 0;
          System.out.println("Program Terminated");
          break;
        default:
          System.out.println("Invalid input: " + condition);
      }
    }

  }

}