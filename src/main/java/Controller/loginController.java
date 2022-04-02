package Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import InterFaceReposi.ResponsiLogin;
import Models.LoginModels;
import Models.responseObject;

@SpringBootApplication
@RestController 
@RequestMapping("/api/login")
public class loginController {
	@Autowired
	private ResponsiLogin reqlg;
	
	@GetMapping("")
	public ResponseEntity<responseObject> GetAll(){
		List<LoginModels> lg=reqlg.findAll();
		List<LoginModels> res =lg.stream().filter(x -> 1 == x.getState()).toList();
		if(lg.size()>0) {
			 return ResponseEntity.status(HttpStatus.OK).body(new responseObject("ok","Thành Công",res));
		}
		else {
			 return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new responseObject("failed","Vui Lòng Kiểm TRA Thông Tin",""));
		}
	}
}
