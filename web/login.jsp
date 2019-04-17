<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Home</title>
    <!-- Custom Theme files -->
    <link href="css/style.css" rel="stylesheet" type="text/css" media="all"/>
    <!-- Custom Theme files -->
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta name="keywords" content="Login form web template, Sign up Web Templates, Flat Web Templates, Login signup Responsive web template, Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyErricsson, Motorola web design" />
    <!--Google Fonts-->
    <link href='http://fonts.useso.com/css?family=Roboto:500,900italic,900,400italic,100,700italic,300,700,500italic,100italic,300italic,400' rel='stylesheet' type='text/css'>
    <link href='http://fonts.useso.com/css?family=Droid+Serif:400,700,400italic,700italic' rel='stylesheet' type='text/css'>
    <!--Google Fonts-->
</head>
<body>
<div class="login">
    <h2>登陆界面</h2>
    <div class="login-top">
        <h1>登陆</h1>
        <form action="<%=request.getContextPath()%>/admin" method="post">
            <input name="name" type="text" value="User Id" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = '用户名';}">
            <input name="password" type="password" value="password" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = '密码';}">
        </form>
        <div class="forgot">
            <a href="#">忘记密码</a>
            <input type="submit" value="登陆" >
        </div>
    </div>
    <div class="login-bottom">
        <h3>新用户 &nbsp;<a href="#">注册</a>&nbsp 这里</h3>
    </div>
</div>
<div class="copyright">
    <p>Copyright &copy; 2019.Company name All rights reserved.<a target="_blank" href="http://sc.chinaz.com/moban/"></a></p>
</div>


</body>
</html>
<script>
    let name = document.getElementById("name").value;
    if(name == ""){
        document.getElementById("name").focus();
    } else {
        document.getElementById("pwd").focus();
    }
</script>
</html>
