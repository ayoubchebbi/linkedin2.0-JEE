package com.isamm.linkedin.services;

import java.util.List;
import com.isamm.linkedin.DAO.*;
import com.isamm.linkedin.beans.*;


public class MessageServiceImpl implements MessageService {

	MessageDAOImpl messagedao = new MessageDAOImpl ();

	@Override
	public boolean add(Message message) {
		return messagedao.add(message);
	}

	@Override
	public boolean delete(Message message) {
		return messagedao.delete(message);
	}

	@Override
	public boolean edit(Message message) {
		return messagedao.edit(message);
	}

	@Override
	public List<Message> getAll() {
		return messagedao.getAll();
	}

	@Override
	public List<Message> getBetween(int id1,int id2) {
		return messagedao.getBetween(id1,id2);
	}

	@Override
	public Message message(int id) {
		return messagedao.message(id);
	}
}
