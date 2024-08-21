package com.example.platform.entity;

import javax.persistence.*;
import java.util.List;
import java.util.Date;

@Table(name = "tl_game")
@Entity
/**
 * 游戏
 * 
 * 
 * 有一张表，记录每一次的价格，但是没有类
 * 
 * 
 * 
 * createGame的同时给Auditor发送一条审核信息，等待Auditor审核
 * @version 1.0
 * @created 25-4月-2023 16:16:17
 */
public class Game {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="gid")
	private int ID;
	@Column(name="gname")
	private String Name;
	private String ginfo;
	@Column(name="makerID")
	private int MakerID;
	@Column(name="time")
	private Date DateTime;
	//@Transient //@Transient注释到实体类中的成员变量，意思是不会被Spring Data JPA框架序列化到数据库，单纯的作为一个临时字段，接收完数据后就暂且用不上了
	@Column(name="typeID")
    private int TypeID;
    //private int[] TypeID;
	@Column(name="price")
	private float Price;
	/**
	 * 折扣，Discount为9，则打九折,nono,0<discount<=1)
	 */
	@Column(name="discount")
	private float Discount;
	@Column(name="statusID")
	private int StatusID;
	private float score;
	@Column(name="image1")
	private String ImagePath;
	@Column(name="thumbimg")
	private String ThumbPath;
	@Column(name="clickNum")
	private int ClickNum;
	//public Type m_Type;
	//public GameState m_GameState;
	//public GameMaker m_GameMaker;

	public Game(){

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

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public Date getDateTime() {
		return DateTime;
	}

	public void setDateTime(Date dateTime) {
		DateTime = dateTime;
	}

	public int getTypeID() {
		return TypeID;
	}

	public void setTypeID(int typeID) {
		TypeID = typeID;
	}

	public float getPrice() {
		return Price;
	}

	public void setPrice(float price) {
		Price = price;
	}

	public int getStatusID() {
		return StatusID;
	}

	public void setStatusID(int statusID) {
		StatusID = statusID;
	}

	public String getGinfo() {
		return ginfo;
	}

	public void setGinfo(String ginfo) {
		this.ginfo = ginfo;
	}

    public int getMakerID() {
        return MakerID;
    }

    public float getDiscount() {
        return Discount;
    }

    public void setMakerID(int makerID) {
		MakerID = makerID;
	}

	public void setDiscount(float discount) {
		Discount = discount;
	}

	public float getScore() {
		return score;
	}

	public void setScore(float score) {
		this.score = score;
	}

	public String getImagePath() {
		return ImagePath;
	}

	public void setImagePath(String imagePath) {
		ImagePath = imagePath;
	}

	public String getThumbPath() {
		return ThumbPath;
	}

	public void setThumbPath(String thumbPath) {
		ThumbPath = thumbPath;
	}

	public int getClickNum() {
		return ClickNum;
	}

	public void setClickNum(int clickNum) {
		ClickNum = clickNum;
	}

	/**/
	public void finalize() throws Throwable {

	}

	/**
	 * 
	 * @param id
	 */
	public int createGame(int id){
		return 0;
	}

	/**
	 * 
	 * @param id
	 */
	public int deleteGame(int id){
		return 0;
	}

	/**
	 * 
	 * @param game
	 */
	public int updateGame(Game game){
		return 0;
	}

	/**
	 * 
	 * @param id
	 */
	public Game getGameByID(int id){
		return null;
	}

	public List<Game> findAllGame(){
		return null;
	}

}