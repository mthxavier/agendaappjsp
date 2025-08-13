<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Login</title>
    <%@ include file="header.jsp" %>
</head>
<body>
<h4>Página de Login</h4>

<form action="login/validar">
    <div class="row">
        <div class="input-field col s6">
            <input id="email" name="email" type="email" class="validate">
            <label for="email">E-mail</label>
        </div>
    </div>
    <div class="row">
        <div class="input-field col s6">
            <input id="senha" name="senha" type="password" class="validate">
            <label for="senha">Senha</label>
        </div>
    </div>
    <button class="btn waves-effect waves-light" type="submit" name="action">Login
    </button>
</form>

<%@ include file="footer.jsp" %>
</body>
</body>
</html>