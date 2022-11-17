package com.perfios.bootcamp.ecomwebsite.utils;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Date;
import java.util.Properties;

public class EmailUtils {
        final static String fromEmail = "pramod.k@perfios.com"; //requires valid gmail id
        final static String password = "pfsiohzieolftknp"; // correct password for gmail id
//    final String toEmail = "shubham18is052@bnmit.in"; // can be any email id

        public static String sendEmail(String toEmail, String subject, String body){

            Properties props = new Properties();
            props.put("mail.smtp.host", "smtp.gmail.com"); //SMTP Host
            props.put("mail.smtp.port", "587"); //TLS Port
            props.put("mail.smtp.auth", "true"); //enable authentication
            props.put("mail.smtp.starttls.enable", "true"); //enable STARTTLS

            //create Authenticator object to pass in Session.getInstance argument
            Authenticator auth = new Authenticator() {
                //override the getPasswordAuthentication method
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(fromEmail, password);
                }
            };
            Session session = Session.getInstance(props, auth);

            try
            {
                MimeMessage msg = new MimeMessage(session);
                //set message headers
                msg.addHeader("Content-type", "text/HTML; charset=UTF-8");
                msg.addHeader("format", "flowed");
                msg.addHeader("Content-Transfer-Encoding", "8bit");

                msg.setFrom(new InternetAddress("no_reply@example.com", "NoReply"));

                msg.setReplyTo(InternetAddress.parse("no_reply@example.com", false));

                msg.setSubject(subject, "UTF-8");
                msg.setContent(body, "text/html");

                msg.setSentDate(new Date());

                msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toEmail, false));
//            System.out.println("Message is ready");
                Transport.send(msg);
                System.out.println("Email sent successfully");
                return "Email sent successfully";
            }
            catch (Exception e) {
                e.printStackTrace();
            }
            return "Error";
        }

//    public static void main(String[] args) {
//        sendEmail("shubham18is052@bnmit.in","SimpleEmail Testing Subject", "SimpleEmail Testing Body");
//    }
}

