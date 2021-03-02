<head>
<jsp:directive.include file="/WEB-INF/jsp/prelude/include-head-meta.jspf" />
	<title>My Home Page</title>
    <style>
      .bd-placeholder-img {
        font-size: 1.125rem;
        text-anchor: middle;
        -webkit-user-select: none;
        -moz-user-select: none;
        -ms-user-select: none;
        user-select: none;
      }

      @media (min-width: 768px) {
        .bd-placeholder-img-lg {
          font-size: 3.5rem;
        }
      }
    </style>
</head>
<script type="text/javascript">

	function addUser(){
		$.ajax({
			type:'post',
			data:{
				name:$("#inputName").val(),
				email:$("#inputEmail").val(),
				phoneNumber:$("#inputPhoneNumber").val(),
				password:$("#inputPassword").val()
			},
			url:'http://127.0.0.1:8080/user/register',
			success:function(data){
				alert("保存成功！");
				window.location.href='http://127.0.0.1:8080/hello/world';
			}
		});
	}
</script>
<body>
	<div class="container">
		<form class="form-signin" action="register">
			<h1 class="h3 mb-3 font-weight-normal">登录</h1>
			<label for="inputName" class="sr-only">请输出账号名称</label> <input
				 id="name" name="name" class="form-control"
				placeholder="请输入账号名称" required autofocus>
			<label for="inputEmail" class="sr-only">请输出电子邮件</label> <input
				type="email" id="email" name="email" class="form-control"
				placeholder="请输入电子邮件" required autofocus>
			<label for="inputPhoneNumber" class="sr-only">请输出手机号</label> <input
				 id="phoneNumber" name="phoneNumber" class="form-control"
				placeholder="请输入手机号" required autofocus>
			<label
				for="inputPassword" class="sr-only">Password</label> <input
				type="password" id="password" name="password" class="form-control"
				placeholder="请输入密码" required>
			<div class="checkbox mb-3">
				<label> <input type="checkbox" value="remember-me">
					Remember me
				</label>
			</div>
			<button class="btn btn-lg btn-primary btn-block" type="submit">Sign
				in</button>
			<p class="mt-5 mb-3 text-muted">&copy; 2017-2021</p>
		</form>
	</div>
</body>