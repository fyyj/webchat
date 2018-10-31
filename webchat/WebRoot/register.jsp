<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<html>
  <meta charset="utf-8"/>
  <title>聊天室注册页面</title>
  <link href="CSS/style.css" rel="stylesheet">
<script type="text/javascript">
	function check(){
		if(document.getElementById("form1").username.value==""){
			alert("请输入用户名！");
			document.getElementById("form1").username.focus();
			return false;
		}
		
		if(document.getElementById("form1").password.value==""){
			alert("请输入密码名！");
			document.getElementById("form1").password.focus();
			return false;
		}
	}
</script>
  <body class="bg_body">
  	<center><font color="RED" size="5">${regist}</font></center>
  	<br/><br/>
    <form id="form1" action="${pageContext.request.contextPath }/regist" onSubmit="return check()" method="post">
    	<table align="center" width="371" height="230"  background="images/regist.png">
    	
    	<tr>
				<td height="100" colspan="3" >&nbsp;</td>
			</tr>
			<tr>
				<td width="53" align="center"  >&nbsp;</td>
				<td width="216" align="center">
				<table width="100%" height="100%">
						<tr>
							<td>用户名：</td>
							<td><input type="text" name="username" >
								
							</td>
							
						</tr>
					</table>
				</td>
				<td width="94"  ></td>
			</tr>
			
			<tr>
				<td width="53" align="center"  >&nbsp;</td>
				<td width="216" align="center"  >
					<table width="100%" height="100%">
						<tr>
							<td>密&nbsp;&nbsp;码：</td>
							<td><input type="password" name="password" class="login"></td>
						</tr>
					</table>
				</td>
				<td width="94" valign="top" ></td>
			</tr>
    		
    		<tr>
    			<td width="53" align="center" valign="top" >&nbsp;</td>
				<td width="216" align="center" valign="top" >
				<input name="Submit" type="submit" class="btn_bg" value="注册">
				</td>
				<td width="94" valign="top" >
				</td>
    		</tr>
    		
    	</table>
    </form>
    <center><a href="${pageContext.request.contextPath }/index.jsp">
    	<font color="white" size="4" face="楷体">已有账号，去登陆</font>
    	</a></center>
  </body>
</html>
