<!doctype html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Entrar em um curso</title>
    <%@include file="header.jsp"%>
</head>
<body>
<form action="disciplina/listar" method="POST">
    <h3 class="center">Chave da Disciplina</h3>
    <div class="row">
        <div class="input-field col s12">
            <input id="chave" name="chave" type="text" class="validate">
            <label for="chave">Chave</label>
        </div>
    </div>
    <div class="row">
        <button class="btn waves-effect waves-light col s2" type="submit" name="action">Entrar
        </button>
    </div>
</form>
<%@include file="footer.jsp"%>
</body>
</html>