<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html>
	<head>
	    <meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
		<title>登录界面</title>
		<style type="text/css">
		 #div1{
		    margin:150px auto;
		    width:200px;
		    heigth:100px;
		    border:1px solid;
		    padding:100px;
		    border:none;
		   
	    }
	    body{
	         background:url(//img.tukuppt.com//ad_preview/00/03/31/5c98a5a81da41.jpg!/fw/780);
	    }
	    .fo{
	        color:red;
	    }
	    p{
	      color:yellow;
	      text-align:center;
	      font-size:25px;
	    }
	    *{
	      margin:0;
	      padding:0;
	    }
		</style>
		<script type="text/javascript">
		  function mycheck(){
		    if(form1.loginname.value==""){
		        alert("请输入账号！");
		        form1.loginname.focus();
		        return false;
		    }
		     if(form1.password.value==""){
		        alert("请输入密码！");
		        form1.password.focus();
		        return false;
		    }
		  /*  if((form1.loginname.value!="张三"&&form1.loginname.value!="")||(form1.password.value!="123456"&&form1.password.value=="")){
		         alert("账号或密码错误！！！");
		         form1.loginname.focus();
		         return;	    
		    } 
		  */
		  }
		</script>
	</head>
	<body>
	<div id="div1">
	 <p> 企业信息管理系统</p><br><br><br>
	  <form action="myservlet" method="post" name="form1"  class="fo" onSubmit="return mycheck()">   
	  <input type="text" name="operation" value="login" style="display:none;"> 
	         账号: <input type="text" name="loginname">
	    <br>     
	    密码: <input type="password" name="password">  
	     <br> <br>
	       <input type="submit" name="submit1" value="登录" >
	        &nbsp;
	           <input type="reset" value="重置"/>                  
	  </form>
	 </div>
	</body>
</html>