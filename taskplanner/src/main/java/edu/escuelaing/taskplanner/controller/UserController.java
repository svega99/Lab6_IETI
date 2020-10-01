package edu.escuelaing.taskplanner.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import edu.escuelaing.taskplanner.model.User;
import edu.escuelaing.taskplanner.services.UserService;

import java.util.logging.Level;
import java.util.logging.Logger;

@RestController
@RequestMapping(value = "/user")
public class UserController {
	
	 @Autowired
	  UserService us;
	
	 @RequestMapping(method = RequestMethod.GET)
	    public ResponseEntity<?> getAll() {
	        try {
	            return new ResponseEntity<>(us.getAll(), HttpStatus.ACCEPTED);
	        } catch (Exception e) {
	            Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, e);
	            return new ResponseEntity<>(e.getMessage(),HttpStatus.NOT_FOUND);
	        }
	    }
	 
	 @RequestMapping(value="/{userId}", method= RequestMethod.GET)
	    public ResponseEntity<?> getCinemaByName(@PathVariable("userId") String userId){
		 try {
	            return new ResponseEntity<>(us.getById(userId), HttpStatus.ACCEPTED);
	        } catch (Exception e) {
	            Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, e);
	            return new ResponseEntity<>(e.getMessage(),HttpStatus.NOT_FOUND);
	        }
	   }
	 
	 @RequestMapping(method = RequestMethod.POST)	
	    public ResponseEntity<?> create(@RequestBody User newUser){
	        
	        try {
	            return new ResponseEntity<>( us.create(newUser),HttpStatus.CREATED);
	        } catch (Exception ex) {
	            Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, ex);
	            return new ResponseEntity<>(ex.getMessage(),HttpStatus.FORBIDDEN);            
	        }        

	    }
	 
	 
	  @RequestMapping(path = "/{userId}",method = RequestMethod.PUT)	
	    public ResponseEntity<?> update(@PathVariable ("userId") String userId,@RequestBody User user ){        
	        try {
  
	            return new ResponseEntity<>(us.update(user),HttpStatus.CREATED);
	        } catch (Exception ex) {
	            Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, ex);
	            return new ResponseEntity<>(ex.getMessage(),HttpStatus.FORBIDDEN);
	        }
	    }
	  
	  
	  @RequestMapping(path = "/{userId}", method = RequestMethod.DELETE)
	    public ResponseEntity<?> remove(@PathVariable(name = "userId") String userId) {
	        try {
	 
	            us.remove(userId);
	            return new ResponseEntity<>(HttpStatus.ACCEPTED); 

	        } catch (Exception ex) {
	            return new ResponseEntity<>("400 bad request", HttpStatus.NOT_FOUND);
	        }
	    }



	
}
