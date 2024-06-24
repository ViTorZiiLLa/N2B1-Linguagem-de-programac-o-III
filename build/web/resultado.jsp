<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>JSP Page</title>
    <link href="style.css" rel="stylesheet">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons/font/bootstrap-icons.css" rel="stylesheet">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
</head>
<body>
    <button onclick="toggleDarkMode()" class="btn btn-outline-dark float-end"> <!-- Usando a classe float-end para alinhar no canto superior direito -->
        <i class="bi bi-moon"></i> <!-- Ícone de uma lua -->
    </button>
    <div class="container mt-5">
        <h1>Cadastro de Produto Concluído com Sucesso</h1>
        <p>O produto foi cadastrado com sucesso.</p>

        <h2>Listar Produtos:</h2>
        <table class="table">
            <thead>
                <tr>
                    <th scope="col">Nome</th>
                    <th scope="col">Descrição</th>
                    <th scope="col">Quantidade</th>
                    <th scope="col">Preço</th>
                    <th scope="col">Categoria</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="Produto" items="${listaProdutos}">
                    <tr>
                        <td>${Produto.nome}</td>
                        <td>${Produto.descricao}</td>
                        <td>${Produto.quantidade}</td>
                        <td>${Produto.preco}</td>
                        <td>${Produto.categoria}</td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>

        <div class="row mt-5">
            <div class="col-md-6">
                <h2>Adicionar ao Estoque:</h2>
                <form action="EstoqueServlet" method="post">
                    <div class="form-group">
                        <label for="inputNome">Nome:</label>
                        <input type="text" id="inputNome" name="nome" class="form-control" required>
                    </div>
                    <div class="form-group">
                        <label for="inputDescricao">Descrição:</label>
                        <input type="text" id="inputDescricao" name="descricao" class="form-control" required>
                    </div>
                    <div class="form-group">
                        <label for="inputQuantidade">Quantidade:</label>
                        <input type="number" id="inputQuantidade" name="quantidade" min="1" class="form-control" required>
                    </div>
                    <div class="form-group">
                        <label for="inputPreco">Preço:</label>
                        <input type="number" id="inputPreco" name="preco" min="0" step="0.01" class="form-control" required>
                    </div>
                    <div class="form-group">
                        <label for="inputCategoria">Categoria:</label>
                        <input type="text" id="inputCategoria" name="categoria" class="form-control" required>
                    </div>
                        <button type="submit" class="btn btn-secondary">Adicionar ao Estoque</button>
                    </form>
            </div>
            <div class="col-md-6">
                <h2>Vender Produto:</h2>
                <form action="VendaProdutoServlet" method="post">
                    <div class="mb-3">
                        <label for="inputProduto" class="form-label">Nome do Produto:</label>
                        <select id="inputProduto" name="produto" class="form-select">
                            <c:forEach var="Produto" items="${listaProdutos}">
                                <option value="${Produto.nome}">${Produto.nome}</option>
                            </c:forEach>
                        </select>
                    </div>
                    <div class="mb-3">
                        <label for="inputQuantidade" class="form-label">Quantidade:</label>
                        <input type="number" id="inputQuantidade" name="quantidade" min="1" class="form-control" required>
                    </div>
                    <!-- Adicione outros campos conforme necessário -->
                    <button type="submit" class="btn btn-secondary">Vender</button>
                </form>
            </div>
        </div>
    </div>
    <script>
        function toggleDarkMode() {
            const body = document.querySelector('body');
            body.classList.toggle('dark-mode');
        }
    </script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
</body>
</html>
