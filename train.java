package entire;

public class train {
	private int id;							/*序号*/
	private int staff_id;					/*员工号*/
	private String name;					/*姓名*/
	private String tel;						/*电话*/
	private String course; 					/*培训课程*/
	private String assm; 					/*培训考核评价*/
	/*序号*/
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id=id;
	}//
	/*员工号*/
	public int getStaff_id() {
		return staff_id;
	}
	public void setStaff_id(int staff_id) {
		this.staff_id=staff_id;
	}//
	/*姓名*/
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name=name;
	}//
	/*电话*/
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel=tel;
	}//
	/*培训课程*/
	public String getCourse() {
		return course;
	}
	public void setCourse(String course) {
		this.course=course;
	}//
	/*培训考核评价*/
	public String getAssm() {
		return assm;
	}
	public void setAssm(String assm) {
		this.assm=assm;
	}//
}
