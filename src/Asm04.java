import vn.funix.fx20193.java.asm04.common.Utils;
import vn.funix.fx20193.java.asm04.exception.CustomerIdNotValidException;
import vn.funix.fx20193.java.asm04.model.DigitalBank;

import java.util.Scanner;

public class Asm04 {
    public static DigitalBank digitalBank = new DigitalBank();
    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("store/customers.txt");
        int choose = 0;
        while (true) {
            showMenu();
            try {
                System.out.print("Nhập chức năng: ");
                choose = Integer.parseInt(sc.nextLine());
                switch (choose) {
                    case 1:
                        Utils.line();
                        digitalBank.showCustomer();
                        break;
                    case 2:
                        Utils.line();
                        System.out.println("Nhập đường dẫn đến tệp: ");
                        String tenFile = sc.nextLine();
                        digitalBank.addCustomer(tenFile);
                        break;
                    case 3:
                        Utils.line();
                        String customerId = "";
                        System.out.print("Nhập mã số khách hàng: ");
                        customerId = sc.nextLine();
                        digitalBank.addSavingsAccount(sc, customerId);
                        break;
                    case 4:
                        Utils.line();
                        String customerId1 = "";
                        System.out.print("Nhập mã số khách hàng: ");
                        customerId1 = sc.nextLine();
                        digitalBank.transfers(sc, customerId1);
                        break;
                    case 5:
                        Utils.line();
                        String customerId2 = "";
                        System.out.print("Nhập mã số khách hàng: ");
                        customerId2 = sc.nextLine();
                        digitalBank.withdraw(sc, customerId2);
                        break;
                    case 6:
                        Utils.line();
                        digitalBank.showCustomer();
                        digitalBank.displayTransaction();
                        break;
                    case 0:
                        Utils.line();
                        System.exit(0);
                        System.out.println("Thoát!!!");
                        break;
                    default:
                        Utils.line();
                        System.out.println("Nhập chức năng sai vui lòng nhập lại!!!");
                        break;
                }
            } catch (NumberFormatException e) {
                System.out.println("Nhập chức phải là số vui lòng nhập lại!!!.");
                Utils.line();
            } catch (CustomerIdNotValidException e) {
                System.out.println(e.getErr());
            }
        }
    }

    public static void showMenu() {
        Utils.line();
        System.out.println("| NGÂN HÀNG SỐ | " + "FX20193" + "@" + "v4.0.0" + "                                   |");
        Utils.line();
        System.out.println("| 1. Xem danh sách khách hàng.                                    |");
        System.out.println("| 2. Nhập danh sách khách hàng.                                   |");
        System.out.println("| 3. Thêm tài khoản ATM.                                          |");
        System.out.println("| 4. Chuyển tiền.                                                 |");
        System.out.println("| 5. Rút tiền.                                                    |");
        System.out.println("| 6. Tra cứu lỊch sử giao dịch.                                   |");
        System.out.println("| 0. Thoát.                                                       |");
        Utils.line();
    }
}