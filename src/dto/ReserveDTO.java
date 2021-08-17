package dto;

public class ReserveDTO {
	private int rsv_no;
	private int user_no;
	private String sub_date;
	private String rsv_date;
	private String rsv_content;
	private String addr_depart;
	private String addr_arrive;
	private int bag_no;
	private int bag_val;
	private int bag;
	private long price;
	public int getRsv_no() {
		return rsv_no;
	}
	public void setRsv_no(int rsv_no) {
		this.rsv_no = rsv_no;
	}
	public int getUser_no() {
		return user_no;
	}
	public void setUser_no(int user_no) {
		this.user_no = user_no;
	}
	public String getSub_date() {
		return sub_date;
	}
	public void setSub_date(String sub_date) {
		this.sub_date = sub_date;
	}
	public String getRsv_date() {
		return rsv_date;
	}
	public void setRsv_date(String rsv_date) {
		this.rsv_date = rsv_date;
	}
	public String getRsv_content() {
		return rsv_content;
	}
	public void setRsv_content(String rsv_content) {
		this.rsv_content = rsv_content;
	}
	public String getAddr_depart() {
		return addr_depart;
	}
	public void setAddr_depart(String addr_depart) {
		this.addr_depart = addr_depart;
	}
	public String getAddr_arrive() {
		return addr_arrive;
	}
	public void setAddr_arrive(String addr_arrive) {
		this.addr_arrive = addr_arrive;
	}
	public int getBag_no() {
		return bag_no;
	}
	public void setBag_no(int bag_no) {
		this.bag_no = bag_no;
	}
	public int getBag_val() {
		return bag_val;
	}
	public void setBag_val(int bag_val) {
		this.bag_val = bag_val;
	}
	public int getBag() {
		return bag;
	}
	public void setBag(int bag) {
		this.bag = bag;
	}
	public long getPrice() {
		return price;
	}
	public void setPrice(long price) {
		this.price = price;
	} 
}
