package entire;

public class recruit {
	private int id;				/*序号*/
	private String name;		/*姓名*/
	private String sex;			/*性别*/
	private String bir;			/*出生日期*/
	private String adr;			/*家庭地址*/
	private String tel;			/*电话*/
	private String edu;			/*学历*/
	private String des;			/*简介*/
	private int state;			/*雇佣(T-1-是，F--2--否,null--0)*/
	/*序号*/
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id=id;
	}//
	/*姓名*/
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name=name;
	}//
	/*性别*/
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex=sex;
	}//
	/*出生日期*/
	public String getBir() {
		return bir;
	}
	public void setBir(String bir) {
		this.bir=bir;
	}//
	/*家庭地址*/
	public String getAdr() {
		return adr;
	}
	public void setAdr(String adr) {
		this.adr=adr;
	}//
	/*电话*/
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel=tel;
	}//
	/*学历*/
	public String getEdu() {
		return edu;
	}
	public void setEdu(String edu) {
		this.edu=edu;
	}//
	/*简介*/
	public String getDes() {
		return des;
	}
	public void setDes(String des) {
		this.des=des;
	}//
	/*雇佣(T-1-是，F--2--否)*/
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state=state;
	}//
}
