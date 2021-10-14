package co.primeblock.mybatistest;

import java.security.Timestamp;
import java.util.List;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import co.primeblock.mybatistest.dao.MessageDao;
import co.primeblock.mybatistest.dto.MessageDto;

@RestController
@MapperScan(basePackages = "co.primeblock.mybatistest.dao")     // 탐색할 패키지 설정
public class MessageController {
    @Autowired
	private MessageDao messageDao;  //MessageDao bean을 자동으로 주입
	
	@RequestMapping("/message")
	public MessageDto message(@RequestParam(value="id")int id) throws Exception { //query String으로 id를 받도록 설정
		// final MessageDto param = new MessageDto(id, null, new Date());
		final MessageDto message = messageDao.selectMessage(id);
		return message;
	}

	@RequestMapping("/messages")
	public List<MessageDto> messages() throws Exception { //query String으로 id를 받도록 설정
		// final MessageDto param = new MessageDto(id, null, new Date());
		final List<MessageDto> messages = messageDao.selectMessageAll();
		return messages;
	}

	@PostMapping("/message")
	@ResponseBody
	public String createMessage(@RequestBody MessageDto message) throws Exception {

		MessageDto m = new MessageDto(message.getText());
		messageDao.createMessage(m);
		return "Success: " + Integer.toString(m.getId());
	}
}
