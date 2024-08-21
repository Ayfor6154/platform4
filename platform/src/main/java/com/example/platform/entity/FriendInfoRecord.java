package com.example.platform.entity;

import java.util.Date;

/**
 * 检查用户ID与senderID是否相同，相同则放到右边，不同则放到左边
 * 
 * 
 * 消息发出的时候，发过去，同时再记录到数据库中
 * @author Lenovo
 * @version 1.0
 * @created 25-4月-2023 16:48:09
 */
public class FriendInfoRecord {

	private int ID;
	private int FriendRelationshipID;
	private int SenderID;
	private char Content;
	private Date DateTime;
	public FriendRelationship m_FriendRelationship;

	public FriendInfoRecord(){

	}

	public void finalize() throws Throwable {

	}

}