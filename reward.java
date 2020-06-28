package entire;

public class reward {
	private int id; 					/*序号*/
	private int staff_id;				/*职员号*/
	private String name;				/*姓名*/
	private int state;     				/*状态 就是表示是奖励(1)或者处罚(2)*/
	private String des;   				/*说明为什么奖惩和奖惩*/
	/*序号*/
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id=id;
	}
	/*职员号*/
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
	/*状态 就是表示是奖励(1)或者处罚(2)*/
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state=state;
	}
	/*说明为什么奖惩和奖惩*/
	public String getDes() {
		return des;
	}
	public void setDes(String des) {
		this.des=des;
	}//
}
