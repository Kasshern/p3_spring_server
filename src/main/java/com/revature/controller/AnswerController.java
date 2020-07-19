package com.revature.controller;

import javax.validation.Valid;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;

import com.revature.entities.Answer;
import com.revature.entities.Question;
import com.revature.services.AnswerService;

@RestController
@RequestMapping("/answers")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.PUT, 			RequestMethod.PATCH, RequestMethod.POST},allowedHeaders = {"Content-Type"})
public class AnswerController {
	
	@Autowired
	AnswerService answerService;
	
/** @Author Natasha Poser */
	@GetMapping
	public Page<Answer>getAnswers(Pageable pageable){
			return answerService.getAnswers(pageable);
	}

	/** @Author James Walls */
	@PostMapping
	public Answer saveAnswer(@Valid @RequestBody Answer answer) {
		return answerService.save(answer);
	}
	
	// issue Optional int parameter 'userID' is present but cannot be translated into a null value
	/**@author ken*/
	@GetMapping("/user/{userID}")
	public Page<Answer> getAllAnswersByUserID(Pageable pageable, @PathVariable int userID){
		return answerService.getAllAnswersByUserID(pageable, userID);		
	}
	
	@GetMapping("/questionid/{questionId}")
	public Page<Answer> getAllAnswersByQuestionId(Pageable pageable, @PathVariable int questionId){
		return answerService.getAllAnswersByQuestionId(pageable, questionId);		
	}
	
	@GetMapping("/answerid/{answerid}")
	public Answer getAnswerByAnswerId(@PathVariable int answerid) {
		return answerService.findById(answerid);
	}

}
