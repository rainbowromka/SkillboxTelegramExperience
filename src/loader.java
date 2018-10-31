import org.javagram.TelegramApiBridge;
import org.javagram.response.AuthAuthorization;
import org.javagram.response.AuthCheckedPhone;
import org.javagram.response.AuthSentCode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class loader {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        TelegramApiBridge bridge = new TelegramApiBridge("149.154.167.50:443", 638472, "26a72d210d6cbe418f2d08803c496c51");
//        AuthCheckedPhone authCheckedPhone =  bridge.authCheckPhone("+79832404807");

        System.out.println("Please, type phone number:");
        String phoneNumnber = reader.readLine().trim();
        AuthCheckedPhone checkedPhone =  bridge.authCheckPhone(phoneNumnber);
        System.out.println(checkedPhone.isRegistered());

        AuthSentCode authSentCode = bridge.authSendCode(phoneNumnber);


        String smsCode = reader.readLine().trim();
        AuthAuthorization autorization = bridge.authSignIn(smsCode);

        System.out.println("First Name: " + autorization.getUser().getFirstName());
        System.out.println("Last Name: " + autorization.getUser().getLastName());

    }
}
