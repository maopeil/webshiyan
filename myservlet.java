package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.*;
import entire.*;
 
@WebServlet("/myservlet")
public class myservlet extends HttpServlet {
    /**
     * @see HttpServlet#HttpServlet()
     */
    public myservlet() {
        super();
    }
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);//省略doget,执行dopost
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	//dopost方法:该部分主要读取数据，判断进行的操作类型
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8"); 
		String op=gettrim(request.getParameter("operation"));//执行操作种类(operation现在取值为"Allqurry","Qurry","Login","Update","Insert","Delete")
		String table=gettrim(request.getParameter("table"));//对应表格(表格命名规范"dep","xxx"......)
		System.out.println("op="+op);//test,追踪op的值
		System.out.println("table="+table);//test,追踪table的值
		if(op==null)//利用传入的op与table的值 进行判断接下来执行的方法(行为)
			System.out.println("op=null.");
		else if(op.equals("login")) {
			login(request,response);//登录功能
		}else if(op.equals("Allqurry")) {
			if(table.equals("dep"))
				Dep_A(request,response);//显示部门管理界面
			if(table.equals("staff"))
				staff_A(request,response);//显示管理界面
			if(table.equals("recruit"))
				recruit_A(request,response);//显示管理界面
			if(table.equals("train"))
				train_A(request,response);//显示管理界面
			if(table.equals("reward"))
				reward_A(request,response);//显示管理界面
			if(table.equals("pay"))
				pay_A(request,response);//显示管理界面
			if(table.equals("manager"))
				manager_A(request,response);//显示管理界面
			
		}else if(op.equals("Qurry")) {
			if(table.equals("dep"))
				Dep_Q(request,response);//管理界面
			if(table.equals("staff"));
				staff_Q(request,response);//显示管理界面
			if(table.equals("recuit"))
				recruit_Q(request,response);//显示管理界面
			if(table.equals("train"))
				train_Q(request,response);//显示管理界面
			if(table.equals("reward"))
				reward_Q(request,response);//显示管理界面
			if(table.equals("pay"))
				pay_Q(request,response);//显示管理界面
			if(table.equals("manager"))
				manager_Q(request,response);//显示管理界面
			
		}else if(op.equals("Update")) {
			if(table.equals("dep"))	
				Dep_U(request,response);//管理界面
			
		}else if(op.equals("Insert")) {
			if(table.equals("dep"))
				Dep_I(request,response);//管理界面
			if(table.equals("staff"))
				staff_I(request,response);//显示管理界面
			if(table.equals("recuit"))
				recruit_I(request,response);//显示管理界面
			if(table.equals("train"))
				train_I(request,response);//显示管理界面
			if(table.equals("reward"))
				reward_I(request,response);//显示管理界面
			if(table.equals("pay"))
				pay_I(request,response);//显示管理界面
			if(table.equals("manager"))
				manager_I(request,response);//显示管理界面
		}else if(op.equals("Delete"))
			if(table.equals("dep"))
				Dep_D(request,response);//管理界面
			if(table.equals("staff"))
				staff_D(request,response);//显示管理界面
			if(table.equals("recuit"))
				recruit_D(request,response);//显示管理界面
			if(table.equals("train"))
				train_D(request,response);//显示管理界面
			if(table.equals("reward"))
				reward_D(request,response);//显示管理界面
			if(table.equals("pay"))
				pay_D(request,response);//显示管理界面
			if(table.equals("manager"))
				manager_D(request,response);//显示管理界面
		
	}
	public void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//manager cls=new manager();
		managerdao dao=new managerdao();
		//获取输入数据
		String name=gettrim(request.getParameter("loginname"));
		String passwd=gettrim(request.getParameter("password"));
		System.out.println("name="+name);
		//标志位
		boolean flag=false;
		//判断操作
		if(name!=null&&passwd!=null)//输入数据非空
		{
			System.out.println("main");//test			
			List<manager> list=dao.Qurry(-1,-1,name,passwd,"manager");
			if(list!=null&&list.size()!=0) {//查询结果非空
				flag=true;
				HttpSession session=request.getSession(true);
				session.setAttribute("my_id",list.get(0).id);
				session.setAttribute("my_staff_id",list.get(0).staff_id);
				session.setAttribute("my_name",list.get(0).name);
				session.setAttribute("my_passwd",list.get(0).passwd);
				session.setAttribute("my_power",list.get(0).power);
				request.setAttribute("tbname",null);
				//request.setAttribute("my",cls);获取当前登录人员的信息（manager），并传给下个页面
				request.getRequestDispatcher("main.jsp").forward(request, response);
				return;
			}
		}
		if(!flag){//密码错误，返回hello.jsp
			response.sendRedirect("/webtest/hello.jsp");
			System.out.println("hello");//test
		}
		
	}
	 private String gettrim(String S)
	{//将字符串S中空串转化为null，去掉非空串的前后空格(对输入数据中空串，null做处理)
		String a=null;
		if(S!=null) {
			a=S.trim();
			if(a.equals("")){
				System.out.println("空串");//输入数据为空串
				a=null;
			} else
				System.out.println("输入="+a);//打印输入的string数据
		}
		else {
			a=null;
			System.out.println("S=null");//S不存在
		}
		return a;
	}
	 private int getint(String S) {
		 String nums=null;
		 if(S!=null)
			 nums=S.trim();
		 int num=0;
		 if (nums==null||nums.equals("")) {
			 num=-1;//该-1表示异常
		 }else
			 num = Integer.parseInt(nums);
		 System.out.println("num="+num);//打印输入的int型数据
		 return num;
	 }
	 public void Dep_A(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
			departmentdao dao=new departmentdao();
			List<department> list=dao.Allqurry();
			request.setAttribute("list",list);
			//request.setAttribute("tbname","dep");
			request.getRequestDispatcher("dep.jsp").forward(request, response);
		
	 }
	 public void Dep_Q(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
			departmentdao dao=new departmentdao();
			int id=getint(request.getParameter("id"));//获取输入数据,并对其处理
			String dep=gettrim(request.getParameter("dep"));
			String des=gettrim(request.getParameter("des"));
			List<department> list=dao.Qurry(id,dep,des);//获取后台数据
			request.setAttribute("list",list);
			//request.setAttribute("tbname","dep");
			request.getRequestDispatcher("dep.jsp").forward(request, response);
		
	 }
	 public void Dep_U(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
			departmentdao dao=new departmentdao();
			int id=getint(request.getParameter("id"));
			String dep=gettrim(request.getParameter("dep"));
			String des=gettrim(request.getParameter("des"));
			int count=dao.Update(id,dep,des);//执行修改操作
			System.out.println("count="+count);//test
			List<department> list=dao.Allqurry();//修改后再查询一次所有数据
			request.setAttribute("list",list);
			//request.setAttribute("tbname","dep");
			request.getRequestDispatcher("dep.jsp").forward(request, response);
		
	 }
	 public void Dep_I(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
			departmentdao dao=new departmentdao();
			int id=getint(request.getParameter("id"));
			String dep=gettrim(request.getParameter("dep"));
			String des=gettrim(request.getParameter("des"));
			int count=dao.Insert(id,dep,des);
			System.out.println("count="+count);//test
			List<department> list=dao.Allqurry();//插入后再查询一次所有数据
			request.setAttribute("list",list);
			//request.setAttribute("tbname","dep");
			request.getRequestDispatcher("dep.jsp").forward(request, response);
		
	 }
	 public void Dep_D(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
			departmentdao dao=new departmentdao();
			int id=getint(request.getParameter("id"));
			String dep=gettrim(request.getParameter("dep"));
			String des=gettrim(request.getParameter("des"));
			int count=dao.Delete(id,dep,des);
			System.out.println("count="+count);//test
			List<department> list=dao.Allqurry();//删除后再查询一次所有数据
			request.setAttribute("list",list);
			//request.setAttribute("tbname","dep");
			request.getRequestDispatcher("dep.jsp").forward(request, response);
		
	 }
	 public void staff_A(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		 	staff_dao dao=new staff_dao();
			List<staff> list=dao.Allqurry();
			request.setAttribute("list",list);
			//request.setAttribute("tbname","staff");
			request.getRequestDispatcher("staff.jsp").forward(request, response);
		
	 }
	 public void recruit_A(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		 	recruitdao dao=new recruitdao();
			List<recruit> list=dao.Allqurry();
			request.setAttribute("list",list);
			//request.setAttribute("tbname","recruit");
			request.getRequestDispatcher("recruit.jsp").forward(request, response);
		
	 }
	 public void train_A(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		 	traindao dao=new traindao();
			List<train> list=dao.Allqurry();
			request.setAttribute("list",list);
			//request.setAttribute("tbname","trai");
			request.getRequestDispatcher("train.jsp").forward(request, response);
		
	 }
	 public void reward_A(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		 	rewarddao dao=new rewarddao();
			List<reward> list=dao.Allqurry();
			request.setAttribute("list",list);
			//request.setAttribute("tbname","reward");
			request.getRequestDispatcher("reward.jsp").forward(request, response);
		
	 }
	 public void pay_A(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		 	paydao dao=new paydao();
			List<pay> list=dao.Allqurry();
			request.setAttribute("list",list);
			//request.setAttribute("tbname","pay");
			request.getRequestDispatcher("pay.jsp").forward(request, response);
		
	 }
	 public void manager_A(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		 	managerdao dao=new managerdao();
			List<manager> list=dao.Qurry(0,0,null,null,"manager");
			request.setAttribute("list",list);
			//request.setAttribute("tbname","manager");
			request.getRequestDispatcher("manager.jsp").forward(request, response);
		
	 }
	 public void staff_I(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		 	staff_dao dao=new staff_dao();
			int staff_id=getint(request.getParameter("staff_id"));
			String name=gettrim(request.getParameter("name"));
			String sex=gettrim(request.getParameter("sex"));
			String bir=gettrim(request.getParameter("bir"));
			String adr=gettrim(request.getParameter("adr"));
			String tel=gettrim(request.getParameter("tel"));
			String pos=gettrim(request.getParameter("pos"));
			String dep=gettrim(request.getParameter("dep"));
			String wage=gettrim(request.getParameter("wage"));
			String des=gettrim(request.getParameter("des"));
			int count=dao.Insert(staff_id,name,sex,bir,adr,tel,pos,dep,wage,des);
			System.out.println("count="+count);//test
			List<staff> list=dao.Allqurry();//插入后再查询一次所有数据
			request.setAttribute("list",list);
			//request.setAttribute("tbname","staff");
			request.getRequestDispatcher("staff.jsp").forward(request, response);
		
	 } 
	 public void staff_U(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		 	staff_dao dao=new staff_dao();
			int staff_id=getint(request.getParameter("staff_id"));
			String name=gettrim(request.getParameter("name"));
			String sex=gettrim(request.getParameter("sex"));
			String bir=gettrim(request.getParameter("bir"));
			String adr=gettrim(request.getParameter("adr"));
			String tel=gettrim(request.getParameter("tel"));
			String pos=gettrim(request.getParameter("pos"));
			String dep=gettrim(request.getParameter("dep"));
			String wage=gettrim(request.getParameter("wage"));
			String des=gettrim(request.getParameter("des"));
			int count=dao.Update(staff_id,name,sex,bir,adr,tel,pos,dep,wage,des);//执行修改操作
			System.out.println("count="+count);//test
			List<staff> list=dao.Allqurry();//删除后再查询一次所有数据
			request.setAttribute("list",list);
			//request.setAttribute("tbname","staff");
			request.getRequestDispatcher("staff.jsp").forward(request, response);
		
	 }
	 public void staff_Q(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		 	staff_dao dao=new staff_dao();
			int staff_id=getint(request.getParameter("staff_id"));
			String name=gettrim(request.getParameter("name"));
			String sex=gettrim(request.getParameter("sex"));
			String bir=gettrim(request.getParameter("bir"));
			String adr=gettrim(request.getParameter("adr"));
			String tel=gettrim(request.getParameter("tel"));
			String pos=gettrim(request.getParameter("pos"));
			String dep=gettrim(request.getParameter("dep"));
			String wage=gettrim(request.getParameter("wage"));
			String des=gettrim(request.getParameter("des"));
			List<staff> list=dao.Qurry(staff_id,name,sex,bir,adr,tel,pos,dep,wage,des);//执行修改操作
			request.setAttribute("list",list);
			//request.setAttribute("tbname","staff");
			request.getRequestDispatcher("staff.jsp").forward(request, response);
		
	 }
	 public void recruit_I(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		 	recruitdao dao=new recruitdao();
			int id=getint(request.getParameter("id"));
			String name=gettrim(request.getParameter("name"));
			String sex=gettrim(request.getParameter("sex"));
			String bir=gettrim(request.getParameter("bir"));
			String adr=gettrim(request.getParameter("adr"));
			String tel =gettrim(request.getParameter("tel"));
			String edu=gettrim(request.getParameter("edu"));
			String des =gettrim(request.getParameter("des"));
			int state=getint(request.getParameter("state"));
			int count=dao.Insert(id,name,sex,bir,adr,tel,edu,des,state);
			System.out.println("count="+count);//test
			List<recruit> list=dao.Allqurry();//插入后再查询一次所有数据
			request.setAttribute("list",list);
			//request.setAttribute("tbname","recruit");
			request.getRequestDispatcher("recruit.jsp").forward(request, response);
		
	 }
	 public void recruit_U(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		 	recruitdao dao=new recruitdao();
			int id=getint(request.getParameter("id"));
			String name=gettrim(request.getParameter("name"));
			String sex=gettrim(request.getParameter("sex"));
			String bir=gettrim(request.getParameter("bir"));
			String adr=gettrim(request.getParameter("adr"));
			String tel =gettrim(request.getParameter("tel"));
			String edu=gettrim(request.getParameter("edu"));
			String des =gettrim(request.getParameter("des"));
			int state=getint(request.getParameter("state"));
			int count=dao.Update(id,name,sex,bir,adr,tel,edu,des,state);
			System.out.println("count="+count);//test
			List<recruit> list=dao.Allqurry();//插入后再查询一次所有数据
			request.setAttribute("list",list);
			request.setAttribute("tbname","recruit");
			request.getRequestDispatcher("recruit.jsp").forward(request, response);
		
	 }
	 public void recruit_Q(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		 	recruitdao dao=new recruitdao();
			int id=getint(request.getParameter("id"));
			String name=gettrim(request.getParameter("name"));
			String sex=gettrim(request.getParameter("sex"));
			String bir=gettrim(request.getParameter("bir"));
			String adr=gettrim(request.getParameter("adr"));
			String tel =gettrim(request.getParameter("tel"));
			String edu=gettrim(request.getParameter("edu"));
			String des =gettrim(request.getParameter("des"));
			int state=getint(request.getParameter("state"));
			List<recruit> list=dao.Qurry(id,name,sex,bir,adr,tel,edu,des,state);//
			request.setAttribute("list",list);
			request.setAttribute("tbname","recruit");
			request.getRequestDispatcher("recruit.jsp").forward(request, response);
		
	 }
	 public void train_I(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		 	traindao dao=new traindao();
			int id=getint(request.getParameter("id"));
			int staff_id=getint(request.getParameter("staff_id"));
			String name=gettrim(request.getParameter("name"));
			String tel=gettrim(request.getParameter("tel"));
			String course=gettrim(request.getParameter("course"));
			String assm=gettrim(request.getParameter("assm"));
			int count=dao.Insert(id,staff_id,name,tel,course,assm);
			System.out.println("count="+count);//test
			List<train> list=dao.Allqurry();//插入后再查询一次所有数据
			request.setAttribute("list",list);
			request.setAttribute("tbname","train");
			request.getRequestDispatcher("train.jsp").forward(request, response);
		
	 }
	 public void train_Q(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		 	traindao dao=new traindao();
			int id=getint(request.getParameter("id"));
			int staff_id=getint(request.getParameter("staff_id"));
			String name=gettrim(request.getParameter("name"));
			String tel=gettrim(request.getParameter("tel"));
			String course=gettrim(request.getParameter("course"));
			String assm=gettrim(request.getParameter("assm"));
			List<train> list=dao.Qurry(id,staff_id,name,tel,course,assm);//
			request.setAttribute("list",list);
			request.setAttribute("tbname","train");
			request.getRequestDispatcher("train.jsp").forward(request, response);
		
	 }
	 public void reward_I(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		 	rewarddao dao=new rewarddao();
			int id=getint(request.getParameter("id"));
			int staff_id=getint(request.getParameter("staff_id"));
			String name=gettrim(request.getParameter("name"));
			int state=getint(request.getParameter("state"));
			String des=gettrim(request.getParameter("des"));
			int count=dao.Insert(id,staff_id,name,state,des);
			System.out.println("count="+count);//test
			List<reward> list=dao.Allqurry();//插入后再查询一次所有数据
			request.setAttribute("list",list);
			request.setAttribute("tbname","reward");
			request.getRequestDispatcher( "reward.jsp").forward(request, response);
		
	 }
	 public void reward_Q(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		 	rewarddao dao=new rewarddao();
			int id=getint(request.getParameter("id"));
			int staff_id=getint(request.getParameter("staff_id"));
			String name=gettrim(request.getParameter("name"));
			int state=getint(request.getParameter("state"));
			String des=gettrim(request.getParameter("des"));
			List<reward> list=dao.Qurry(id,staff_id,name,state,des);//
			request.setAttribute("list",list);
			request.getRequestDispatcher("reward.jsp").forward(request, response);
		
	 }
	 public void pay_I(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		 	paydao dao=new paydao();
			int id=getint(request.getParameter("id"));
			int staff_id=getint(request.getParameter("staff_id"));
			String name=gettrim(request.getParameter("name"));
			String YM=gettrim(request.getParameter("YM"));
			int basic=getint(request.getParameter("basic"));
			int reward=getint(request.getParameter("reward"));
			int punish =getint(request.getParameter("punish "));
			int count=dao.Insert(id,staff_id,name,YM,basic,reward,punish);
			System.out.println("count="+count);//test
			List<pay> list=dao.Allqurry();//插入后再查询一次所有数据
			request.setAttribute("list",list);
			request.getRequestDispatcher("pay.jsp").forward(request, response);
		
	 }
	 public void pay_Q(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		 	paydao dao=new paydao();
			int id=getint(request.getParameter("id"));
			int staff_id=getint(request.getParameter("staff_id"));
			String name=gettrim(request.getParameter("name"));
			String YM=gettrim(request.getParameter("YM"));
			int basic=getint(request.getParameter("basic"));
			int reward=getint(request.getParameter("reward"));
			int punish =getint(request.getParameter("punish "));
			List<pay> list=dao.Qurry(id,staff_id,name,YM,basic,reward,punish);//插入后再查询一次所有数据
			request.setAttribute("list",list);
			request.getRequestDispatcher("pay.jsp").forward(request, response);
		
	 }
	 public void manager_I(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		 	managerdao dao=new managerdao();
			int id=getint(request.getParameter("id"));
			int staff_id=getint(request.getParameter("staff_id"));
			String name=gettrim(request.getParameter("name"));
			String passwd=gettrim(request.getParameter("passwd"));
			int count=dao.Insert(id,staff_id,name,passwd,"manager");
			System.out.println("count="+count);//test
			List<manager> list=dao.Allqurry();//插入后再查询一次所有数据
			request.setAttribute("list",list);
			request.getRequestDispatcher("manager.jsp").forward(request, response);
		
	 }
	 public void manager_Q(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		 	managerdao dao=new managerdao();
			int id=getint(request.getParameter("id"));
			int staff_id=getint(request.getParameter("staff_id"));
			String name=gettrim(request.getParameter("name"));
			String passwd=gettrim(request.getParameter("passwd"));
			List<manager> list=dao.Qurry(id,staff_id,name,passwd,"manager");//
			request.setAttribute("list",list);
			request.getRequestDispatcher("main.jsp").forward(request, response);
		
	 }
	 public void staff_D(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		 	staff_dao dao=new staff_dao();
			int staff_id=getint(request.getParameter("staff_id"));
			String name=gettrim(request.getParameter("name"));
			String sex=gettrim(request.getParameter("sex"));
			String bir=gettrim(request.getParameter("bir"));
			String adr=gettrim(request.getParameter("adr"));
			String tel=gettrim(request.getParameter("tel"));
			String pos=gettrim(request.getParameter("pos"));
			String dep=gettrim(request.getParameter("dep"));
			String wage=gettrim(request.getParameter("wage"));
			String des=gettrim(request.getParameter("des"));
			int count=dao.Delete(staff_id,name,sex,bir,adr,tel,pos,dep,wage,des);
			System.out.println("count="+count);//test
			List<staff> list=dao.Allqurry();//删除后再查询一次所有数据
			request.setAttribute("list",list);
			request.getRequestDispatcher("staff.jsp").forward(request, response);
		
	 }
	 public void recruit_D(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		 recruitdao dao=new recruitdao();
			int id=getint(request.getParameter("id"));
			String name=gettrim(request.getParameter("name"));
			String sex=gettrim(request.getParameter("sex"));
			String bir=gettrim(request.getParameter("bir"));
			String adr=gettrim(request.getParameter("adr"));
			String tel =gettrim(request.getParameter("tel"));
			String edu=gettrim(request.getParameter("edu"));
			String des =gettrim(request.getParameter("des"));
			int state=getint(request.getParameter("state"));
			int count=dao.Delete(id,name,sex,bir,adr,tel,edu,des,state);
			System.out.println("count="+count);//test
			List<recruit> list=dao.Allqurry();//删除后再查询一次所有数据
			request.setAttribute("list",list);
			request.getRequestDispatcher("main.jsp").forward(request, response);
		
	 }
	 public void train_D(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		 	traindao dao=new traindao();
			int id=getint(request.getParameter("id"));
			int staff_id=getint(request.getParameter("staff_id"));
			String name=gettrim(request.getParameter("name"));
			String tel=gettrim(request.getParameter("tel"));
			String course=gettrim(request.getParameter("course"));
			String assm=gettrim(request.getParameter("assm"));
			int count=dao.Delete(id,staff_id,name,tel,course,assm);
			System.out.println("count="+count);//test
			List<train> list=dao.Allqurry();//删除后再查询一次所有数据
			request.setAttribute("list",list);
			//request.setAttribute("tbname","train");
			request.getRequestDispatcher("train.jsp").forward(request, response);
		
	 }
	 public void reward_D(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		 	rewarddao dao=new rewarddao();
			int id=getint(request.getParameter("id"));
			int staff_id=getint(request.getParameter("staff_id"));
			String name=gettrim(request.getParameter("name"));
			int state=getint(request.getParameter("state"));
			String des=gettrim(request.getParameter("des"));
			int count=dao.Delete(id,staff_id,name,state,des);
			System.out.println("count="+count);//test
			List<reward> list=dao.Allqurry();//删除后再查询一次所有数据
			request.setAttribute("list",list);
			//request.setAttribute("tbname","reward");
			request.getRequestDispatcher("reward.jsp").forward(request, response);
		
	 }
	 public void pay_D(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		 	paydao dao=new paydao();
			int id=getint(request.getParameter("id"));
			int staff_id=getint(request.getParameter("staff_id"));
			String name=gettrim(request.getParameter("name"));
			String YM=gettrim(request.getParameter("YM"));
			int basic=getint(request.getParameter("basic"));
			int reward=getint(request.getParameter("reward"));
			int punish =getint(request.getParameter("punish "));
			int count=dao.Delete(id,staff_id,name,YM,basic,reward,punish);
			System.out.println("count="+count);//test
			List<pay> list=dao.Allqurry();//删除后再查询一次所有数据
			request.setAttribute("list",list);
			//request.setAttribute("tbname","pay");
			request.getRequestDispatcher("pay.jsp").forward(request, response);
		
	 }
	 public void manager_D(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		 	managerdao dao=new managerdao();
			int id=getint(request.getParameter("id"));
			int staff_id=getint(request.getParameter("staff_id"));
			String name=gettrim(request.getParameter("name"));
			String passwd=gettrim(request.getParameter("passwd"));
			int count=dao.Delete(id,staff_id,name,passwd,null);
			System.out.println("count="+count);//test
			List<manager> list=dao.Allqurry();//删除后再查询一次所有数据
			request.setAttribute("list",list);
			//request.setAttribute("tbname","dep");
			request.getRequestDispatcher("manager.jsp").forward(request, response);
		
	 }
}
