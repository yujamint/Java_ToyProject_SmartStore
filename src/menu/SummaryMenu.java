package menu;

public class SummaryMenu extends Menu{

    public SummaryMenu() { }

    // SummaryMenu - 메인
    public void displaySummaryMenu() {
        while (true) {
            System.out.println("");
            System.out.println("==============================");
            System.out.println("1. 회원 정보 요약");
            System.out.println("2. 회원 정보 요약(이름순 정렬)");
            System.out.println("3. 회원 정보 요약(이용시간순 정렬)");
            System.out.println("4. 회원 정보 요약(결제금액순 정렬)");
            System.out.println("5. 돌아가기");
            System.out.println("==============================");

            int input = menuSelect();
            System.out.println();

            if (input == 1) {
                customers.printCustomerSummary(customers.getCustomers());
            } else if (input == 2) {
                customers.sortByCustomerName(isAscending());
            } else if (input == 3) {
                customers.sortByCustomerSpentTIme(isAscending());
            } else if (input == 4) {
                customers.sortByCustomerTotalPayment(isAscending());
            } else if (input == 5) {
                return;
            } else {
                System.out.println("잘못된 값을 입력했습니다. 다시 입력해주세요.");
            }
        }
    }

    // 오름차순, 내림차순 입력받기
    public int isAscending() {
        while (true) {
            System.out.println("** \'end\'를 입력하면 메뉴로 되돌아갑니다. **");
            System.out.print("어떤 순서로 정렬하시겠습니까? (ASCENDING, DESCENDING) : ");

            String input = sc.next();
            System.out.println();
            if (input.equalsIgnoreCase("END")) return 0;
            else if (input.equalsIgnoreCase("ASCENDING")) return 1;
            else if (input.equalsIgnoreCase("DESCENDING")) return -1;
            else System.out.println("잘못된 값을 입력했습니다. 다시 입력해주세요.\n");
        }
    }
}
