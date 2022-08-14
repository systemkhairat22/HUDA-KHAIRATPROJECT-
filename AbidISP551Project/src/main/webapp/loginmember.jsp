<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login Member</title>
<style>
html {
  height: 100%;
}
body {
  margin:0;
  padding:0;
  font-family: sans-serif;
  background: linear-gradient(180deg, rgba(255,255,255,0) 0, rgba(0,0,0,0.2) 0), url(./assets/bg-login.jpeg);
  height: 100%; width: 100%;
  overflow: hidden;
  background-size: cover;
  background-repeat: no-repeat;
  background-position: 50% 50%;
 
}

.login-box {
  position: absolute;
  top: 50%;
  left: 50%;
  width: 500px;
  padding: 40px;
  transform: translate(-50%, -50%);
  background: rgba(0,0,0,.5);
  box-sizing: border-box;
  box-shadow: 0 15px 25px rgba(0,0,0,.6);
  border-radius: 10px;
}

.login-box h2 {
  margin: 0 0 30px;
  padding: 0;
  color: #fff;
  text-align: center;
}

.login-box .user-box {
  position: relative;
}

.login-box .user-box input {
  width: 100%;
  padding: 10px 0;
  font-size: 16px;
  color: #fff;
  margin-bottom: 30px;
  border: none;
  border-bottom: 1px solid #fff;
  outline: none;
  background: transparent;
}
.login-box .user-box label {
  position: absolute;
  top:0;
  left: 0;
  padding: 10px 0;
  font-size: 16px;
  color: #fff;
  pointer-events: none;
  transition: .5s;
}

.login-box .user-box input:focus ~ label,
.login-box .user-box input:valid ~ label {
  top: -20px;
  left: 0;
  color: #03e9f4;
  font-size: 12px;
}

.login-box form a {
  position: relative;
  display: inline-block;
  padding: 10px 20px;
  color: #03e9f4;
  font-size: 16px;
  text-decoration: none;
  text-transform: uppercase;
  overflow: hidden;
  transition: .5s;
  margin-top: 40px;
  letter-spacing: 4px
}

.login-box a:hover {
  background: #03e9f4;
  color: #fff;
  border-radius: 5px;
  box-shadow: 0 0 5px #03e9f4,
              0 0 25px #03e9f4,
              0 0 50px #03e9f4,
              0 0 100px #03e9f4;
}
input[type=button], input[type=submit] {
  background-color: #04AA6D;
  border: none;
  color: white;
  padding: 10px 30px;
  text-decoration: none;
  margin: 4px 2px;
  cursor: pointer;
}

input[type=button], input[type=reset] {
  background-color:#DC7633;
  border: none;
  color: white;
  padding: 10px 30px;
  text-decoration: none;
  margin: 4px 2px;
  cursor: pointer;
}
a{
 font: bold 11px Arial;
  text-decoration: none;
  background-color: #EEEEEE;
  color: #333333;
  padding: 2px 6px 2px 6px;
  border-top: 1px solid #CCCCCC;
  border-right: 1px solid #333333;
  border-bottom: 1px solid #333333;
  border-left: 1px solid #CCCCCC;
}

p{
color:white;
}




</style>
</head>
<body>
     
       <a href="index.html">Back</a><br>
            
        <div class="login-box" >
          <h2>Login Member</h2>

            <div>
                <p class="text-white">For first time login password is your first 2 alphabet of your name + last 4 digit of your ic number</p>
                <div class="text-white hint mb-4">
                    <p class="mt-0 fs-7">Example Name: AHMAD BIN DAUD</p>
                    <p class="mt-0 fs-7">IC Number: 750112010202</p>
                    <p class="mt-0 fs-7">Password: AH0202</p>
                </div>
            </div>
             <form action = "LoginMemberController" method = "post">
            <div class="user-box">
              <input type="text" name="mem_icnum"  placeholder= "NO DASH">
              <label>IC Number</label>
            </div>
            <div class="user-box">
              <input type="password" name="mem_password" >
              <label>Password</label>
            </div>
            <div class="d-flex align-items-center">
               
            <input  type="submit" value= "login">
     
                  <span></span>
                  <span></span>
                  <span></span>
                  <span></span>
               
               <input type="reset"  value = "reset">
            </div>
          </form>
          
        </div>

 
    </body>
	
	
</body>
</html>