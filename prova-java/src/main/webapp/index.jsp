<!DOCTYPE html>
<html ng-app="cadastro">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Totalcross - Cadastro de Usuários</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <style>
        .usuario-conteudo {
            background-color: #EEE;
            padding: 20px 20px 10px 20px;
            margin-top: 30px;
        }
    </style>
</head>
<body>
<div class="container">
    <div class="row">
        <div class="col-md-offset-2 col-md-8">
            <div class="botoes">
                <h1>Lanchonete</h1>
                    <button ng-click="criarPedido">Add Order</button>
                    <form name="addProduct" ng-hide = >
                    <div class="form-group">
                        <label for="nome">cd produto*</label>
                        <input type="text" class="form-control" id="nome" placeholder="cd produto"
                               maxlength="20" required>
                    </div>
                    <button ng-click="adicioneProdutoNoPedido">Add Product in Order</button>
                    </form>
                <hr>
                <h1>Lista de Usuários</h1>
                <table class="table table-striped">
                    <thead>
                    <tr>
                        <th>#</th>
                        <th>Nome</th>
                        <th>Senha</th>
                    </tr>
                    </thead>
                    <tbody>
                    <!-- Aqui serão exibidos os dados do usuários cadastrados -->
                    <tr >
                        <td>-</td>
                        <td>-</td>
                        <td>-</td>
                    </tr>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
</div>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.6.4/angular.min.js"></script>
<script src="js/app.js"></script>
</body>
</html>