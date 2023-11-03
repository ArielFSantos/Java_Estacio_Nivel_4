<%-- 
    Document   : ProdutoLista
    Created on : 27 de out. de 2023, 19:39:18
    Author     : ariel
--%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Lista de Produtos</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body class="container"> <!-- Adicionar a classe container ao body -->

<h1>Lista de Produtos</h1>

<!-- Adicionar as classes btn, btn-primary e m-2 no link de inclusão -->
<a href="ServletProdutoFC?acao=formIncluir" class="btn btn-primary m-2">Incluir Novo Produto</a>

<table class="table table-striped"> <!-- Adicionar as classes table e table-striped na tabela -->
    <thead class="table-dark"> <!-- Adicionar a classe table-dark ao thead -->
        <tr>
            <th>ID</th>
            <th>Nome</th>
            <th>Quantidade</th>
            <th>Preço</th>
            <th>Ações</th>
        </tr>
    </thead>
    <tbody>
        <c:forEach items="${produtos}" var="produto">
            <tr>
                <td>${produto.id}</td>
                <td>${produto.nome}</td>
                <td>${produto.quantidade}</td>
                <td>${produto.preco}</td>
                <td>
                    <!-- Adicionar as classes btn, btn-primary e btn-sm no link de alteração -->
                    <a href="ServletProdutoFC?acao=alterar&id=${produto.id}" class="btn btn-primary btn-sm">Alterar</a>

                    <!-- Adicionar as classes btn, btn-danger e btn-sm no link de exclusão -->
                    <a href="ServletProdutoFC?acao=excluir&id=${produto.id}" class="btn btn-danger btn-sm">Excluir</a>
                </td>
            </tr>
        </c:forEach>
    </tbody>
</table>

</body>
</html>

