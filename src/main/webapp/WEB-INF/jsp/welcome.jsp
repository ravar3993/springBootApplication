<!DOCTYPE HTML>
<HTML>
<Head>
<title>Sikka</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" type="text/css" href="css/main.css">
</Head>
<Body>
<script src="js/login.js"></script>
<div class="bg-image"></div>
<div class="bg-text">
<div class = "loginNav">
<p onclick = "getLoginForm('signIn')">SignIn</p>
<p onclick = "getLoginForm('signUp')" class = "active">SignUp</p><br>
</div>
<div id="signIn">
<form method="POST" id = "signInForm" action = "/signIn">
<Input name="userName" type="text" placeholder="UserName"><br>
<Input name="password" type="text" placeholder="Password"><br>
<Input id = "signInSubmit" type = "submit" value="Sign In">
</form>
</div>
<div id = "signUp" class = "active">
<form method="GET" id = "signUpForm" action = "/signUp">
<Input name="userName" type="text" placeholder="UserName"><br>
<Input name="email" type="text" placeholder="Email"><br>
<Input name="password" type="text" placeholder="Password"><br>
<Input name="confirmPassword" type="text" placeholder="Confirm Password"><br>
<Input id = "signUpSubmit" type = "submit" value="Sign Up">
</form>
</div>
</div>
</Body>
</HTML>