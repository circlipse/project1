package dto;

public class ReviewDTO {
	 
	private int rev_no;
	private int rsv_no;
	private int user_no;
	private String rev_title;
	private String rev_content;
	private int rev_readno;
	  
	
	public ReviewDTO(int rev_no, int rsv_no, int user_no, String rev_title, String rev_content, int rev_readno) {
		super();
		this.rev_no = rev_no;
		this.rsv_no = rsv_no;
		this.user_no = user_no;
		this.rev_title = rev_title;
		this.rev_content = rev_content;
		this.rev_readno = rev_readno;
	}


	public ReviewDTO() {

	}


	public int getRev_no() {
		return rev_no;
	}


	public void setRev_no(int rev_no) {
		this.rev_no = rev_no;
	}


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


	public String getRev_title() {
		return rev_title;
	}


	public void setRev_title(String rev_title) {
		this.rev_title = rev_title;
	}


	public String getRev_content() {
		return rev_content;
	}


	public void setRev_content(String rev_content) {
		this.rev_content = rev_content;
	}


	public int getRev_readno() {
		return rev_readno;
	}


	public void setRev_readno(int rev_readno) {
		this.rev_readno = rev_readno;
	}


	

	
}
