package menu;

import exception.LessThanZeroException;
import group.Group;
import group.MemberGrade;

import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;

public class GradeMenu extends Menu {

    public GradeMenu() { }

    // GradeMenu 메인
    public void displayGradeMenu() {
        while (true) {
            System.out.println("");
            System.out.println("==============================");
            System.out.println("1. 분류 기준 설정");
            System.out.println("2. 분류 기준 확인");
            System.out.println("3. 분류 기준 수정");
            System.out.println("4. 돌아가기");
            System.out.println("==============================");

            int select = menuSelect();
            System.out.println();

            if (select == 1) {
                setParameter();
            } else if (select == 2) {
                printParameter();
            } else if (select == 3) {
                editParameter();
            } else if (select == 4) {
                return;
            } else {
                System.out.println("잘못된 번호를 입력했습니다. 다시 입력해주세요.\n");
            }
        }
    }

    public void setParameter() { // GradeMenu 1번 - 분류 기준 초기 설정
        while (true) {
            String input = selectGrade().toUpperCase(Locale.ROOT);
            if (input.equals("END")) return;

            if (input.equals("GENERAL") || input.equals("VIP") || input.equals("VVIP")) {
                MemberGrade memberGrade = null;

                for (MemberGrade mg : MemberGrade.values()) {
                    if (mg.name().equals(input)) memberGrade = mg;
                }

                if (isGradeExist(memberGrade)) {
                    System.out.println("해당 등급 분류 기준이 이미 존재합니다.\n");
                    continue;
                }
                groups[memberGrade.getIndex()].setInitialized(true);
                selectParameter(memberGrade);
            } else {
                System.out.println("잘못된 입력값입니다. 다시 입력해주세요.");
            }
        }
    }

    public void printParameter() { // GradeMenu - 2번 : 분류 기준 출력
        while (true) {
            String input = selectGrade().toUpperCase(Locale.ROOT);
            if (input.equals("END")) return;

            if (input.equals("GENERAL") || input.equals("VIP") || input.equals("VVIP")) {
                MemberGrade memberGrade = null;

                for (MemberGrade mg : MemberGrade.values()) {
                    if (mg.name().equals(input)) memberGrade = mg;
                }

                if (!isGradeExist(memberGrade)) {
                    System.out.println("해당 등급 분류 기준이 존재하지 않습니다.\n");
                    continue;
                }

                Group group = groups[memberGrade.getIndex()];
                System.out.println("[그룹] " + memberGrade.getLabel());
                System.out.println("이용 시간 : " + group.getParam().getSpentTime());
                System.out.println("결제 금액 : " + group.getParam().getTotalPayment() + "\n");
            } else {
                System.out.println("잘못된 입력값입니다. 다시 입력해주세요.\n");
            }
        }
    }

    public void editParameter() { // GradeMenu - 3번 : 수정
        while (true) {
            String input = selectGrade().toUpperCase(Locale.ROOT);
            if (input.equals("END")) return;

            if (input.equals("GENERAL") || input.equals("VIP") || input.equals("VVIP")) {
                MemberGrade memberGrade = null;

                for (MemberGrade mg : MemberGrade.values()) {
                    if (mg.name().equals(input)) memberGrade = mg;
                }

                if (!isGradeExist(memberGrade)) {
                    System.out.println("해당 등급 분류 기준이 존재하지 않습니다.\n");
                    continue;
                }

                Group group = groups[memberGrade.getIndex()];
                System.out.println("[그룹] : " + memberGrade.getLabel());
                System.out.print("[현재 조건] 이용 시간 : " + group.getParam().getSpentTime());
                System.out.println(", 결제 금액 : " + group.getParam().getTotalPayment() + "\n");

                selectParameter(memberGrade);
            } else {
                System.out.println("잘못된 입력값입니다. 다시 입력해주세요.\n");
            }
        }
    }

    public String selectGrade() {
        System.out.println("** \'end\'를 입력하면 메뉴로 되돌아갑니다. **");
        System.out.print("등급을 선택하세요. (GENERAL, VIP, VVIP) : ");
        String input = sc.next();
        return input;
    }

    public void selectParameter(MemberGrade memberGrade) {
        while (true) {
            System.out.println("==============================");
            System.out.println("1. 최소 이용 시간");
            System.out.println("2. 최소 결제 금액");
            System.out.println("3. 돌아가기");
            System.out.println("==============================");

            int input = menuSelect();
            System.out.println();

            if (input == 1) { // 시간
                while (true) {
                    try {
                        editSpentTime(groups[memberGrade.getIndex()]);
                        customers.setCustomers_memberGrade();
                        break;
                    } catch (InputMismatchException inputMismatchException) {
                        sc = new Scanner(System.in);
                        System.out.println("잘못된 값을 입력했습니다. 0 이상의 정수를 입력해주세요.\n");
                    } catch (LessThanZeroException e) {
                        System.out.println(e.getMessage());
                    }
                }
            } else if (input == 2) { // 금액
                while (true) {
                    try {
                        editTotalPayment(groups[memberGrade.getIndex()]);
                        customers.setCustomers_memberGrade();
                        break;
                    } catch (InputMismatchException inputMismatchException) {
                        sc = new Scanner(System.in);
                        System.out.println("잘못된 값을 입력했습니다. 0 이상의 정수를 입력해주세요.\n");
                    } catch (LessThanZeroException e) {
                        System.out.println(e.getMessage());
                    }
                }
            } else if (input == 3) { // 나가기
                return;
            } else {
                System.out.println("잘못된 번호를 입력했습니다. 다시 입력해주세요.\n");
            }
        }
    }

    public boolean isGradeExist(MemberGrade memberGrade) {
        if (groups[memberGrade.getIndex()].isInitialized()) return true;
        else return false;
    }

    public void editSpentTime(Group group) throws LessThanZeroException, InputMismatchException {
        System.out.print(group.getGrade().getLabel() + "이(가) 되기 위해 필요한 최소 사용 시간을 입력하세요 : ");
        int time = sc.nextInt();
        System.out.println();
        group.getParam().setSpentTime(time);
    }

    public void editTotalPayment(Group group) throws LessThanZeroException, InputMismatchException{
        System.out.print(group.getGrade().getLabel() + "이(가) 되기 위해 필요한 최소 결제 금액을 입력하세요 : ");
        int money = sc.nextInt();
        System.out.println();
        group.getParam().setTotalPayment(money);
    }
}
