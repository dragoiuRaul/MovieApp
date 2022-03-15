package ro.pex.movie.service.email;

import java.io.UnsupportedEncodingException;

import javax.mail.MessagingException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import ro.pex.movie.model.dto.EmailAttachmentDto;
import ro.pex.movie.model.dto.EmailDto;

@Service

public class EmailService {

	@Autowired
	private JavaMailSender mailSender;

	public void sendEmail(EmailDto emailDto) throws MessagingException, UnsupportedEncodingException {

		MimeMessage mimeMessage = mailSender.createMimeMessage();

		MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);

		mimeMessageHelper.setSubject(emailDto.getSubject());
		mimeMessageHelper.setFrom(new InternetAddress(emailDto.getFrom(), "gmail.com"));
		mimeMessageHelper.setTo(emailDto.getTo());
		mimeMessageHelper.setText(emailDto.getContent(), true);
		for (EmailAttachmentDto at : emailDto.getAttachments()) {
			mimeMessageHelper.addAttachment(at.getFileName(),
					new FileByteArrayResource(at.getFileName(), at.getFileContent(), ""));

		}

		mailSender.send(mimeMessageHelper.getMimeMessage());
	}
}
