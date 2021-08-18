package dto;

public class SubReviewDTO {
	private int subno;
	private String subcontent;
	private int rev_no;
	private int user_no;
	private String user_id;
	
	
	public SubReviewDTO(int subno, String subcontent, int rev_no, int user_no, String user_id) {
		super();
		this.subno = subno;
		this.subcontent = subcontent;
		this.rev_no = rev_no;
		this.user_no = user_no;
		this.user_id = user_id;
	}


	public SubReviewDTO() {
		// TODO Auto-generated constructor stub
	}


	public int getSubno() {
		return subno;
	}


	public void setSubno(int subno) {
		this.subno = subno;
	}


	public String getSubcontent() {
		return subcontent;
	}


	public void setSubcontent(String subcontent) {
		this.subcontent = subcontent;
	}


	public int getRev_no() {
		return rev_no;
	}


	public void setRev_no(int rev_no) {
		this.rev_no = rev_no;
	}


	public int getUser_no() {
		return user_no;
	}


	public void setUser_no(int user_no) {
		this.user_no = user_no;
	}


	public String getUser_id() {
		return user_id;
	}


	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	
	
	
	
	
	
	
	
}
