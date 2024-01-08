import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class Main {
    public static void main(String[] args) throws Exception {
        Properties props = new Properties();
        props.put("mail.smtp.auth",true);
        props.put("mail.smtp.starttls.enable",true);
        props.put("mail.smtp.port","25");
        props.put("mail.smtp.ssl.trust",true);

        Session session = Session.getInstance(props, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username,password);
            }
        });

        Message message = new MimeMessage(session);
        message.setFrom(new InternetAddress("ojash25@gmail.com"));
        message.setRecipient(Message.RecipientType.TO, new InternetAddress("ojash004@gmail.com"));
        message.setSubject("Hahahah");

        String msg = "JSJFSKFjkSDJFkSLFJLl";

        MimeBodyPart mimeBodyPart = new MimeBodyPart();
        mimeBodyPart.setContent(msg,"text");

    }
}