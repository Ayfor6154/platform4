package com.example.platform.entity;


import javax.persistence.*;
import java.util.Date;
//import com.example.platform.entity.Game;

/**
 * @author Lenovo
 * @version 1.0
 * @created 25-4月-2023 16:28:50
 */
@Table(name = "tl_wishlist")
@Entity
public class WishList {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="lid")
	private int ID;
	private int GameID;
	private int PlayerID;
	private Date DateTime;
	private float AddPrice;
	//public Game m_Game;	//这个得怎么整

	public WishList(){

	}


	/**
	 *一大批getter and setter
	 * */
	public int getID() {
		return ID;
	}

	public void setID(int ID) {
		this.ID = ID;
	}

	public int getGameID() {
		return GameID;
	}

	public void setGameID(int gameID) {
		GameID = gameID;
	}

	public int getPlayerID() {
		return PlayerID;
	}

	public void setPlayerID(int playerID) {
		PlayerID = playerID;
	}

	public Date getDateTime() {
		return DateTime;
	}

	public void setDateTime(Date dateTime) {
		DateTime = dateTime;
	}
	/*
	public Game getM_Game() {
		return m_Game;
	}

	public void setM_Game(Game m_Game) {
		this.m_Game = m_Game;
	}*/

	public float getAddPrice() {
		return AddPrice;
	}

	public void setAddPrice(float addPrice) {
		AddPrice = addPrice;
	}

	public void finalize() throws Throwable {

	}

}