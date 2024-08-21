package com.example.platform.entity;


/**
 * 玩家
 * @version 1.0
 * @created 25-4月-2023 16:27:27
 */
public class Player extends User {

	public WishList m_WishList;

	public Player(){

	}

	public void finalize() throws Throwable {
		super.finalize();
	}

}