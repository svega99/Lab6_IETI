package edu.escuelaing.taskplanner.persistance.impl;

import java.util.ArrayList;
import java.util.List;

import edu.escuelaing.taskplanner.model.User;
import edu.escuelaing.taskplanner.persistance.TaskPlannerNotFoundException;
import edu.escuelaing.taskplanner.persistance.TaskPlannerPersistanceException;
import edu.escuelaing.taskplanner.persistance.UserPersistance;
import org.springframework.stereotype.Service;

@Service("UserPersistanceImpl")
public class UserPersistanceImpl implements UserPersistance{

	List<User> Users = new ArrayList<>(); 
	
	public UserPersistanceImpl(){
		Users.add(new User("santiago.vega-r@mail.escuelaig.edu.co","Santiago Vega","pass"));
		Users.add(new User("pedro.perez@mail.escuelaig.edu.co","Pedro Perez","pass"));
		
	}
	
	@Override
	public List<User> getAll() {
		
		return Users;
	}

	@Override
	public User getById(String userId) throws TaskPlannerNotFoundException {
		boolean findit = false;
		User userFind = null;
		for (User u: Users) {
			if (u.getCorreo().equals(userId)) {
				userFind=u;
				findit=true;
			}
		}
		
		if (findit) {
			return userFind;
		}else {
			 throw new TaskPlannerNotFoundException("User "+userId+" not found");
			
		}
		
	}

	@Override
	public User create(User user) throws TaskPlannerPersistanceException {
		boolean alreadyExists = false;
		try {
		 	getById(user.getCorreo());
		 	alreadyExists = true; 
		}catch(TaskPlannerNotFoundException te){
			Users.add(user);
			
		}
		if (alreadyExists) {
			throw new TaskPlannerPersistanceException("User with mail "+user.getCorreo()+" already exists");
		}else {
			return user;
		}
		 
	}

	@Override
	public User update(User user) throws TaskPlannerNotFoundException {
		getById(user.getCorreo());
		for (User u: Users) {
			if (u.getCorreo().equals(user.getCorreo())) {
				u.setContrasena(user.getContrasena());
				u.setNombre(user.getNombre());
			}
		}
		return user;
		
	}

	@Override
	public void remove(String userId) throws TaskPlannerNotFoundException {
		User userToDelete = getById(userId);
		Users.remove(userToDelete);
		
	}

}
