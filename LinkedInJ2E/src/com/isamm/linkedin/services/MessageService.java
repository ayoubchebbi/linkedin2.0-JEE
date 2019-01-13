package com.isamm.linkedin.services;

import com.isamm.linkedin.beans.*;
import java.util.*;

public interface MessageService {

	public boolean add(Message message);
	public boolean delete(Message message);
	public boolean edit(Message message);
	public List<Message> getAll();
	public List<Message> getBetween(int id1,int id2);
	public Message message(int id) ;

}
