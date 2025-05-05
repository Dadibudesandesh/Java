package com.quizapp.quizapp.Service;


import com.quizapp.quizapp.Entity.Question;
import com.quizapp.quizapp.Repository.QuestionRepo;
import com.sun.jdi.event.ExceptionEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class QuestionService {

    @Autowired
    QuestionRepo questionRepo;

//    public List<Question> getAllQuestions(){
//        System.out.println(questionRepo.findAll());
//        return  questionRepo.findAll();
//    }

    public ResponseEntity<List<Question>> getAllQuestions(){
        try {
            return new ResponseEntity<>(questionRepo.findAll(), HttpStatus.OK);
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return new ResponseEntity<>(new ArrayList<>(),HttpStatus.BAD_REQUEST);
    }


    public ResponseEntity<List<Question>> getAllQuestionsByCategory(String category) {
        try{
            return new ResponseEntity<>(questionRepo.findByCategory(category),HttpStatus.OK);
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return new ResponseEntity<>(new ArrayList<>(),HttpStatus.BAD_REQUEST);
    }



    public ResponseEntity<String> addQuestion(Question question) {
         questionRepo.save(question);
        return new ResponseEntity<>("Success",HttpStatus.CREATED);
    }
}
