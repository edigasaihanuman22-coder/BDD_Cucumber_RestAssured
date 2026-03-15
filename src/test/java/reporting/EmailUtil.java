package reporting;

import jakarta.mail.*;
import jakarta.mail.internet.*;
import java.io.File;
import java.util.List;
import java.util.Properties;

public class EmailUtil {

    public static void sendEmail(List<ScenarioResult> results) throws Exception {

        String from = "ediga.saihanuman23@gmail.com";
        String password = "hiof fjxb utlq ndyx";

        String to = "ediga.saihanuman22@gmail.com";

        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");

        Session session = Session.getInstance(props,
                new Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(from, password);
                    }
                });

        Message message = new MimeMessage(session);
        message.setFrom(new InternetAddress(from));
        message.setRecipients(Message.RecipientType.TO,
                InternetAddress.parse(to));

        message.setSubject("API Automation Execution Report");

        StringBuilder html = new StringBuilder();

        html.append("<h2>Cucumber Execution Report</h2>");
        html.append("<table border='1'>");
        html.append("<tr><th>Scenario</th><th>Status</th><th>Execution Time(ms)</th></tr>");

        for (ScenarioResult r : results) {

            html.append("<tr>");
            html.append("<td>").append(r.getScenarioName()).append("</td>");
            html.append("<td>").append(r.getStatus()).append("</td>");
            html.append("<td>").append(r.getExecutionTime()).append("</td>");
            html.append("</tr>");
        }

        html.append("</table>");

        MimeBodyPart messageBodyPart = new MimeBodyPart();
        messageBodyPart.setContent(html.toString(), "text/html");

        MimeBodyPart attachmentPart = new MimeBodyPart();

        File file = new File("target/API_Test_Report.html");

        attachmentPart.attachFile(file);

        Multipart multipart = new MimeMultipart();
        multipart.addBodyPart(messageBodyPart);
        multipart.addBodyPart(attachmentPart);

        message.setContent(multipart);

        Transport.send(message);

        System.out.println("Email Sent Successfully");
    }
}