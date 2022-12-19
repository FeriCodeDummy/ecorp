package si.feri.ris.ecorp.controllers;



import netscape.javascript.JSObject;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import si.feri.ris.ecorp.Helpers.EmailSenderService;

@RestController
@RequestMapping("/email")
public class EmailController {

	@Autowired
	EmailSenderService senderService;


	@PostMapping("/send")
	public String sendEmail(@RequestBody String body){
		JSONObject json = new JSONObject(body);
		String to = json.getString("email");
		String subject = json.getString("subject");
		String message = json.getString("message");
		try{
			senderService.sendEmail(to, subject, message);
			return "Mail sent successfully";
		}catch (Exception e){
			return "Sending failed";
		}
	}

}