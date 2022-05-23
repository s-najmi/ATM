public class Login {
    public static boolean STATUS_LOGIN = false;
    Database db;

    public Login() {
        db = new Database();
        MyFrame frmLogin = new MyFrame(db);
    }

    public boolean authUser() throws Exception {
        if (MyFrame.STATUS == true) {
            return true;
        }
        return false;
    }
}
