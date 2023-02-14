import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.*;
public class EmailSender {
    public static void sendPasswordResetEmail(String to, String password) {
        final String from = "adiletzumabaj958@gmail.com";
        final String passwordResetSubject = "Reset password";
        final String passwordResetMessage = "Your new password is: " + password;

        Properties properties = new Properties();
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.port", "587");
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");

        Session session = Session.getInstance(properties, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(from, "xawroruntftotrbc");
            }
        });

        try {
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(from));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
            message.setSubject(passwordResetSubject);
            message.setText(passwordResetMessage);

            Transport.send(message);
            System.out.println("Password reset email sent successfully to " + to);
        } catch (MessagingException mex) {
            mex.printStackTrace();
        }
    }
}

