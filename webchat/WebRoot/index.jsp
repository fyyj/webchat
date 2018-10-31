<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html >
<title>聊天室登录页面</title>
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
	<br>
	<center><h3 style="color:red;">${ msg }</h3></center>
	<form id="form1" name="form1" method="post" action="${pageContext.request.contextPath }/user" onSubmit="return check()">
		<input type="hidden" name="method" value="login">
		<table width="371" height="230" align="center"  background="images/login.jpg">
			<tr>
				<td height="100" colspan="3" >&nbsp;</td>
			</tr>
			<tr>
				<td width="53" align="center" valign="top" >&nbsp;</td>
				<td width="216" align="center" valign="top">
				<table width="100%" height="100%">
						<tr>
							<td>用户名：</td>
							<td><input type="text" name="username" class="login"></td>
						</tr>
					</table>
				</td>
				<td width="94" valign="top" ></td>
			</tr>
			
			<tr>
				<td width="53" align="center" valign="top" >&nbsp;</td>
				<td width="216" align="center" valign="top" >
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
				<input name="Submit" type="submit" class="btn_bg" value="进 入">
				</td>
				<td width="94" valign="top" >
				</td>
			</tr>
		</table>
	</form>
	<center>
		<a href="${pageContext.request.contextPath }/register.jsp">
			<font color="white" face="楷体" size="4">
				还没有账号，注册一个
			</font>
		</a>
	</center>
</body>
</html>
