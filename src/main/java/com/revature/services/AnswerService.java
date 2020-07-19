package com.revature.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

import com.revature.entities.Answer;
import com.revature.entities.Question;
import com.revature.repositories.AnswerRepository;

@Service
public class AnswerService {
	
 @Autowired
 AnswerRepository answerRepository;
 
  /** @Author Natasha Poser */
 public Page<Answer> getAllAnswersByQuestionId(Pageable pageable, int questionId){
	 return answerRepository.getAllAnswersByQuestionId(pageable, questionId);
 }
 
 public Page<Answer> getAnswers(Pageable pageable) {
	 return answerRepository.findAll(pageable);
 }
	
	/** @Author James Walls */
	public Answer save(Answer answer) {
		return answerRepository.save(answer);
	}

	/**@author ken*/
	public Page<Answer> getAllAnswersByUserID(Pageable pageable, int userID){
		return answerRepository.getAllAnswersByUserID(pageable, userID);		
	}
	
	public Answer findById(int answerId) {
		return answerRepository.findById(answerId)
				.orElseThrow(() -> new HttpClientErrorException(HttpStatus.NOT_FOUND));
	}
}


