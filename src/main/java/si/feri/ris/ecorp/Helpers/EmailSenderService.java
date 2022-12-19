package si.feri.ris.ecorp.Helpers;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import java.io.File;
import java.nio.file.FileSystem;
import java.util.Objects;

@Service
public class EmailSenderService {

	@Autowired
	private JavaMailSender mailSender;


	public void sendEmail(String to, String subject, String body){
		SimpleMailMessage message = new SimpleMailMessage();
		message.setFrom("ecorpinfomail@gmail.com");
		message.setTo(to);
		message.setText(body);
		message.setSubject(subject);
		mailSender.send(message);
		System.out.println("Mail sent successfully");
	}

	public void sendEmailWithAttachment(String to, String subject, String body, String attachment) throws MessagingException {
		MimeMessage mimeMessage = mailSender.createMimeMessage();
		MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);
		mimeMessageHelper.setFrom("ecorpinfomail@gmail.com");
		mimeMessageHelper.setTo(to);
		mimeMessageHelper.setSubject(subject);
		mimeMessageHelper.setText(body);


		FileSystemResource fileSystemResource = new FileSystemResource(new File(attachment));
		mimeMessageHelper.addAttachment(Objects.requireNonNull(fileSystemResource.getFilename()), fileSystemResource);
		mailSender.send(mimeMessage);
		System.out.println("Mail with attachment sent successfully");

	}

}
