<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no">
    <title>注册</title>
    <script src="js/jquery.min.js"></script>
    <style>
        * {
            margin: 0;
            padding: 0;
        }

        html {
            height: 100%;
        }

        body {
            height: 100%;
            background: #fff url(images/backgroud.png) 50% 50% no-repeat;
            background-size: cover;
        }

        .dowebok {
            position: absolute;
            left: 50%;
            top: 50%;
            width: 430px;
            height: 600px;
            margin: -300px 0 0 -215px;
            border: 1px solid #fff;
            border-radius: 20px;
            overflow: hidden;
        }

        .logo {
            width: 104px;
            height: 104px;
            margin: 50px auto 80px;
            background: url(images/login.png) 0 0 no-repeat;
        }

        .form-item {
            position: relative;
            width: 360px;
            margin: 0 auto;
            padding-bottom: 30px;
        }

        .form-item input {
            width: 288px;
            height: 40px;
            padding-left: 70px;
            border: 1px solid #fff;
            border-radius: 25px;
            font-size: 18px;
            color: #fff;
            background-color: transparent;
            outline: none;
        }

        .form-item button {
            width: 360px;
            height: 40px;
            border: 0;
            border-radius: 25px;
            font-size: 18px;
            color: #1f6f4a;
            outline: none;
            cursor: pointer;
            background-color: #fff;
        }

        #email {
            background: url(images/emil.png) 20px 14px no-repeat;
        }

        #password {
            background: url(images/password.png) 23px 11px no-repeat;
        }

        #confirmPassword {
            background: url(images/password.png) 23px 11px no-repeat;
        }

        .tip {
            display: none;
            position: absolute;
            left: 20px;
            top: 52px;
            font-size: 14px;
            color: #f50;
        }

        .reg-bar a {
            color: #fff;
            text-decoration: none;
        }

        .reg-bar a:hover {
            text-decoration: underline;
        }

        .dowebok ::-webkit-input-placeholder {
            font-size: 18px;
            line-height: 1.4;
            color: #fff;
        }

        .dowebok :-moz-placeholder {
            font-size: 18px;
            line-height: 1.4;
            color: #fff;
        }

        .dowebok ::-moz-placeholder {
            font-size: 18px;
            line-height: 1.4;
            color: #fff;
        }

        .dowebok :-ms-input-placeholder {
            font-size: 18px;
            line-height: 1.4;
            color: #fff;
        }

        @media screen and (max-width: 500px) {
            * {
                box-sizing: border-box;
            }

            .dowebok {
                position: static;
                width: auto;
                height: auto;
                margin: 0 30px;
                border: 0;
                border-radius: 0;
            }

            .logo {
                margin: 50px auto;
            }

            .form-item {
                width: auto;
            }

            .form-item input, .form-item button
        }
    </style>
</head>
<body>
<div class="dowebok">
    <div class="logo"></div>
    <form method="post" action="reg.action">
        <div class="form-item">
            <input id="username" type="text" name="username" autocomplete="off" placeholder="用户名">
            <p class="tip">该用户名已存在，请重新输入</p>
        </div>
        <div class="form-item">
            <input id="email" type="text" name="email" autocomplete="off" placeholder="邮箱">
            <p class="tip">请输入合法的邮箱地址</p>
        </div>
        <div class="form-item">
            <input id="password" type="password" name="password" autocomplete="off" placeholder="登录密码">
            <p class="tip">邮箱或密码不正确</p>
        </div>
        <div class="form-item">
            <input id="confirmPassword" type="Password" name="confirmPassword" autocomplete="off" placeholder="确认登录密码">
            <p class="tip">邮箱或密码不正确</p>
        </div>
        <div class="form-item">
            <button id="submit" class="btn">注册</button>
        </div>
    </form>
</div>
    <script>
        $(function () {
            if ($('input').val('')==null){
                $('#submit').on('click', function () {
                    $('.tip').show()
                })
            }
        })
    </script>
</body>
</html>