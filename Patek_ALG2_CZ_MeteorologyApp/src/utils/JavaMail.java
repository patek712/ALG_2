/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import java.util.Properties;
import javax.activation.*;
import javax.mail.*;
import javax.mail.internet.*;

/**
 * Class vyuzivajici externi knihovnu JavaMail API, vyuziti pro poslani dat na
 * email (zprava + priloha)
 *
 * @author Vojtěch Pátek
 * @version 2.1 25/05/2020
 *
 */
public class JavaMail {

    /**
     * Metoda pro poslani emailu
     *
     * @param email - vstupem pro metodu je e-mailova adresa, zadavana ze
     * standardniho vstupu
     * @param username - emailova adresa, ze ktere se posila email
     * (*****@gmail.com)
     * @param password - heslo k emailove adrese (*******)
     * @throws MessagingException
     */
    public static void SendMail(String email) {

        final String username = "*********@gmail.com";
        final String password = "*********";

        Properties props = new Properties();
        props.put("mail.smtp.auth", true);
        props.put("mail.smtp.starttls.enable", true);
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");

        Session session = Session.getInstance(props,
                new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });

        try {
            //objekt typu message - vytvoreni tela zpravy
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("czmeteorologyapp@gmail.com"));
            message.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse(email));
            message.setSubject("CZ_MeteorologyApp_file");
            message.setText("Your file:");

            //objekt typu MimeBodyPart - vytvoreni tela prilohy
            MimeBodyPart messageBodyPart = new MimeBodyPart();

            Multipart multipart = new MimeMultipart();

            messageBodyPart = new MimeBodyPart();
            String file = "D:\\NetBeans\\Projects\\ALP2\\Semestrální_práce\\CZ_MeteorologyApp\\data\\pocasi.csv";
            String fileName = "pocasi.csv";
            DataSource source = new FileDataSource(file);
            messageBodyPart.setDataHandler(new DataHandler(source));
            messageBodyPart.setFileName(fileName);
            multipart.addBodyPart(messageBodyPart);

            message.setContent(multipart);

            System.out.println("Posílám");

            Transport.send(message);

            System.out.println("Email úspěšně odeslán");

        } catch (MessagingException e) {
            //lepsi vyhledani problemu v odesilani
            e.printStackTrace();
        }
    }
}
