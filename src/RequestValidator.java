public class RequestValidator {

    public static boolean checkAll() {
        checkMail();
        checkPhone();
        return true;
    }

    public static void checkMail() {
        System.out.println("Mail confirm");
    }

    public static  void checkPhone() {
        System.out.println("Tel number confirm");
    }


}
