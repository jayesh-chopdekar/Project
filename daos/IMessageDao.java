package com.app.daos;

import java.util.List;

import com.app.pojos.Message;
import com.app.pojos.SendMsg;

public interface IMessageDao 
{
	List<Message> inbox(Integer id);
  boolean sendmsg(SendMsg m);
}
