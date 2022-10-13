import menu.CustomerMenu;
import menu.GradeMenu;
import menu.Menu;
import menu.SummaryMenu;

public class Main {

    public static void main(String[] args) {
        Menu menu = new Menu();
        GradeMenu gradeMenu = new GradeMenu();
        CustomerMenu customerMenu = new CustomerMenu();
        SummaryMenu summaryMenu = new SummaryMenu();

        while (true) {
            int select = menu.displayMainMenu();

            if (select == 1) {
                gradeMenu.displayGradeMenu();
            }
            else if (select == 2) {
                customerMenu.displayCustomerMenu();
            }
            else if (select == 3) {
                summaryMenu.displaySummaryMenu();
            }
            else {
                System.out.println("프로그램을 종료합니다.");
                break;
            }
        }
    }
}
