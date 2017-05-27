//package Mail;
// 
//import static OptionPane.MsgThread.msg_Failed;
//import java.util.Properties;
//import javax.mail.Message;
//import javax.mail.MessagingException;
//import javax.mail.NoSuchProviderException;
//import javax.mail.Session;
//import javax.mail.Transport;
//import javax.mail.internet.InternetAddress;
//import javax.mail.internet.MimeMessage;
//import static mystring.mystring.InitCap;
//
//public class SendFromYahoo
//{
//    
//public static void SendFromYahooMAIL(String LoginEmail,String LoginPassword,String ToEmail,String FileAttachementPath,String SubjectMail,String MSG_Content) 
//{    
//    
//    
//     
//    // Sender's email ID needs to be mentioned
//     //String from = "david_alltime@yahoo.com";
//   //  String pass ="@1995410_^DodO@";
//    // Recipient's email ID needs to be mentioned.
//   //String to = "mrdavid_vip@hotmail.com";
//   String host = "smtp.mail.yahoo.com";
//
//
//   try{
// 
//   
//   
//   // Get system properties
//   Properties properties = System.getProperties();
//   // Setup mail server
//   properties.put("mail.smtp.starttls.enable", "true");
//   properties.put("mail.smtp.host", host);
//   properties.put("mail.smtp.user", LoginEmail);
//   properties.put("mail.smtp.password", LoginPassword);
//   properties.put("mail.smtp.port", "587");
//   properties.put("mail.smtp.auth", "true");
//
//   // Get the default Session object.
//   Session session = Session.getDefaultInstance(properties);
//
//  
//      // Create a default MimeMessage object.
//      MimeMessage message = new MimeMessage(session);
//
//    try {
//        // Set From: header field of the header.
//        message.setFrom(new InternetAddress(LoginEmail));
//    } catch (MessagingException ex) {
//        msg_Failed("Failed in Login");
//        throw new Exception("Failed 01");
//    }
//    
//    
//
//    try {
//        // Set To: header field of the header.
//        message.addRecipient(Message.RecipientType.TO, new InternetAddress(ToEmail));
//    } catch (MessagingException ex) {
//       msg_Failed("E-mail destination not found");
//         throw new Exception("Failed 02");
//    }
//
//    try {
//        // Set Subject: header field
//        message.setSubject(InitCap(SubjectMail));
//    } catch (MessagingException ex) {
//      msg_Failed("Subject Message Error");
//        throw new Exception("Failed 03");
//    }
//
//    try {
//        // Now set the actual message
//        message.setText(MSG_Content);
//    } catch (MessagingException ex) {
//        msg_Failed("Subject Content Error");
//          throw new Exception("Failed 04");
//    }
//      
//      
//    try {
//      
//        message.setFileName(FileAttachementPath);
//      
//    } catch (MessagingException ex) {
//        msg_Failed("File Attatchement Error");
//          throw new Exception("Failed 05");
//    }
//
//
//// Send message
//      Transport transport = null;
//    try {
//        transport = session.getTransport("smtp");
//    } catch (NoSuchProviderException ex) {
//       msg_Failed("Session Transport Message Error");
//         throw new Exception("Failed 06");
//    }
//    
//    try {
//        transport.connect(host, LoginEmail, LoginPassword);
//    } catch (MessagingException ex) {
//       msg_Failed("Username or Password Not Correct");
//      throw  new Exception("Failed 07");
//    }
//       
//    try {
//        transport.sendMessage(message, message.getAllRecipients());
//    } catch (MessagingException ex) {
//        msg_Failed("Sending Message Failed");
//          throw new Exception("Failed 08");
//    }
//    try {
//        transport.close();
//    } catch (MessagingException ex) {
//        
//    }
//     
//      System.out.println("Sent message successfully....");
//   }catch (Exception e){e.printStackTrace();}
//    
//}
// 
//
//public static void SendFromYahooMAIL(String LoginEmail,String PasswordLogin,String ToEmail,String SubjectMail,String MSG_Content) 
//{    
//   String host = "smtp.mail.yahoo.com";
//
//   try{
// 
//   // Get system properties
//   Properties properties = System.getProperties();
//   // Setup mail server
//   properties.put("mail.smtp.starttls.enable", "true");
//   properties.put("mail.smtp.host", host);
//   properties.put("mail.smtp.user", LoginEmail);
//   properties.put("mail.smtp.password", PasswordLogin);
//   properties.put("mail.smtp.port", "587");
//   properties.put("mail.smtp.auth", "true");
//
//   // Get the default Session object.
//   Session session = Session.getDefaultInstance(properties);
//
//  
//      // Create a default MimeMessage object.
//      MimeMessage message = new MimeMessage(session);
//
//    try {
//        // Set From: header field of the header.
//        message.setFrom(new InternetAddress(LoginEmail));
//    } catch (MessagingException ex) {
//        msg_Failed("Failed in Login");
//        throw new Exception("Failed 01");
//    }
//    
//    
//
//    try {
//        // Set To: header field of the header.
//        message.addRecipient(Message.RecipientType.TO, new InternetAddress(ToEmail));
//    } catch (MessagingException ex) {
//       msg_Failed("E-mail destination not found");
//         throw new Exception("Failed 02");
//    }
//
//    try {
//        // Set Subject: header field
//        message.setSubject(InitCap(SubjectMail));
//    } catch (MessagingException ex) {
//      msg_Failed("Subject Message Error");
//        throw new Exception("Failed 03");
//    }
//
//    try {
//        // Now set the actual message
//        message.setText(MSG_Content);
//    } catch (MessagingException ex) {
//        msg_Failed("Subject Content Error");
//          throw new Exception("Failed 04");
//    }
//      
//      
//
//// Send message
//      Transport transport = null;
//    try {
//        transport = session.getTransport("smtp");
//    } catch (NoSuchProviderException ex) {
//       msg_Failed("Session Transport Message Error");
//         throw new Exception("Failed 06");
//    }
//    
//    try {
//        transport.connect(host, LoginEmail, PasswordLogin);
//    } catch (MessagingException ex) {
//       msg_Failed("Username or Password Not Correct");
//      throw  new Exception("Failed 07");
//    }
//       
//    try {
//        transport.sendMessage(message, message.getAllRecipients());
//    } catch (MessagingException ex) {
//        msg_Failed("Sending Message Failed");
//          throw new Exception("Failed 08");
//    }
//    try {
//        transport.close();
//    } catch (MessagingException ex) {
//        
//    }
//     
//      System.out.println("Sent message successfully....");
//   }catch (Exception e){e.printStackTrace();}
//    
//}
//    
//      
//public static void SendFromYahooMAIL(String LoginEmail,String PasswordLogin,String[] ToEmail,String SubjectMail,String MSG_Content) 
//{    
//   String host = "smtp.mail.yahoo.com";
//
//   try{
// 
//   // Get system properties
//   Properties properties = System.getProperties();
//   // Setup mail server
//   properties.put("mail.smtp.starttls.enable", "true");
//   properties.put("mail.smtp.host", host);
//   properties.put("mail.smtp.user", LoginEmail);
//   properties.put("mail.smtp.password", PasswordLogin);
//   properties.put("mail.smtp.port", "587");
//   properties.put("mail.smtp.auth", "true");
//
//   // Get the default Session object.
//   Session session = Session.getDefaultInstance(properties);
//
//  
//      // Create a default MimeMessage object.
//      MimeMessage message = new MimeMessage(session);
//
//    try {
//        // Set From: header field of the header.
//        message.setFrom(new InternetAddress(LoginEmail));
//    } catch (MessagingException ex) {
//        msg_Failed("Failed in Login");
//        throw new Exception("Failed 01");
//    }
//    
//    
//
//    try {
//        // Set To: header field of the header.
//        for (int i = 0; i < ToEmail.length; i++) {
//            message.addRecipient(Message.RecipientType.TO, new InternetAddress(ToEmail[i]));
//        }
//    } catch (MessagingException ex) {
//       msg_Failed("E-mail destination not found");
//         throw new Exception("Failed 02");
//    }
//
//    try {
//        // Set Subject: header field
//        message.setSubject(InitCap(SubjectMail));
//    } catch (MessagingException ex) {
//      msg_Failed("Subject Message Error");
//        throw new Exception("Failed 03");
//    }
//
//    try {
//        // Now set the actual message
//        message.setText(MSG_Content);
//    } catch (MessagingException ex) {
//        msg_Failed("Subject Content Error");
//          throw new Exception("Failed 04");
//    }
//      
//      
//
//// Send message
//      Transport transport = null;
//    try {
//        transport = session.getTransport("smtp");
//    } catch (NoSuchProviderException ex) {
//       msg_Failed("Session Transport Message Error");
//         throw new Exception("Failed 06");
//    }
//    
//    try {
//        transport.connect(host, LoginEmail, PasswordLogin);
//    } catch (MessagingException ex) {
//       msg_Failed("Username or Password Not Correct");
//      throw  new Exception("Failed 07");
//    }
//       
//    try {
//        transport.sendMessage(message, message.getAllRecipients());
//    } catch (MessagingException ex) {
//        msg_Failed("Sending Message Failed");
//          throw new Exception("Failed 08");
//    }
//    try {
//        transport.close();
//    } catch (MessagingException ex) {
//        
//    }
//     
//      System.out.println("Sent message successfully....");
//   }catch (Exception e){e.printStackTrace();}
//    
//}  
//
//
//public static void SendFromYahooMAIL(String LoginEmail,String LoginPassword,String[] ToEmail,String FileAttachementPath,String SubjectMail,String MSG_Content) 
//{    
//   String host = "smtp.mail.yahoo.com";
//
//   try{
// 
//   // Get system properties
//   Properties properties = System.getProperties();
//   // Setup mail server
//   properties.put("mail.smtp.starttls.enable", "true");
//   properties.put("mail.smtp.host", host);
//   properties.put("mail.smtp.user", LoginEmail);
//   properties.put("mail.smtp.password", LoginPassword);
//   properties.put("mail.smtp.port", "587");
//   properties.put("mail.smtp.auth", "true");
//
//   // Get the default Session object.
//   Session session = Session.getDefaultInstance(properties);
//
//  
//      // Create a default MimeMessage object.
//      MimeMessage message = new MimeMessage(session);
//
//    try {
//        // Set From: header field of the header.
//        message.setFrom(new InternetAddress(LoginEmail));
//    } catch (MessagingException ex) {
//        msg_Failed("Failed in Login");
//        throw new Exception("Failed 01");
//    }
//    
//    
//
//    try {
//        // Set To: header field of the header.
//        for (int i = 0; i < ToEmail.length; i++) {
//            message.addRecipient(Message.RecipientType.TO, new InternetAddress(ToEmail[i]));
//        }
//    } catch (MessagingException ex) {
//       msg_Failed("E-mail destination not found");
//         throw new Exception("Failed 02");
//    }
//
//    try {
//        // Set Subject: header field
//        message.setSubject(InitCap(SubjectMail));
//    } catch (MessagingException ex) {
//      msg_Failed("Subject Message Error");
//        throw new Exception("Failed 03");
//    }
//
//    try {
//        // Now set the actual message
//        message.setText(MSG_Content);
//    } catch (MessagingException ex) {
//        msg_Failed("Subject Content Error");
//          throw new Exception("Failed 04");
//    }
//      
//       try {
//      
//        message.setFileName(FileAttachementPath);
//      
//    } catch (MessagingException ex) {
//        msg_Failed("File Attatchement Error");
//          throw new Exception("Failed 05");
//    }
//
//
//// Send message
//      Transport transport = null;
//    try {
//        transport = session.getTransport("smtp");
//    } catch (NoSuchProviderException ex) {
//       msg_Failed("Session Transport Message Error");
//         throw new Exception("Failed 06");
//    }
//    
//    try {
//        transport.connect(host, LoginEmail, LoginPassword);
//    } catch (MessagingException ex) {
//       msg_Failed("Username or Password Not Correct");
//      throw  new Exception("Failed 07");
//    }
//       
//    try {
//        transport.sendMessage(message, message.getAllRecipients());
//    } catch (MessagingException ex) {
//        msg_Failed("Sending Message Failed");
//          throw new Exception("Failed 08");
//    }
//    try {
//        transport.close();
//    } catch (MessagingException ex) {
//        
//    }
//     
//      System.out.println("Sent message successfully....");
//   }catch (Exception e){e.printStackTrace();}
//    
//}
//   
//    
//}
//
