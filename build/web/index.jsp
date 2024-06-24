<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="pt-BR">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Cadastro de Produtos</title>
    <link href="style.css" rel="stylesheet">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons/font/bootstrap-icons.css" rel="stylesheet">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
</head>
<body>
    <button onclick="toggleDarkMode()" class="btn btn-outline-dark float-end"> <!-- Usando a classe float-end para alinhar no canto superior direito -->
        <i class="bi bi-moon"></i> <!-- Ícone de uma lua -->
    </button>
    <div class="container mt-5">
        <h1 class="mb-4">Cadastro de Produtos</h1>
        <form action="EstoqueServlet" method="post">
            <div class="mb-3">
                <label for="nome" class="form-label">Nome:</label>
                <input type="text" id="nome" name="nome" class="form-control form-control-sm" required>
            </div>
            <div class="mb-3">
                <label for="descricao" class="form-label">Descrição:</label>
                <input type="text" id="descricao" name="descricao" class="form-control form-control-sm" required>
            </div>
            <div class="mb-3">
                <label for="quantidade" class="form-label">Quantidade:</label>
                <input type="number" id="quantidade" name="quantidade" min="0" class="form-control form-control-sm" required>
            </div>
            <div class="mb-3">
                <label for="preco" class="form-label">Preço:</label>
                <input type="number" id="preco" name="preco" step="0.01" min="0" class="form-control form-control-sm" required>
            </div>
            <div class="mb-3">
                <label for="categoria" class="form-label">Categoria:</label>
                <input type="text" id="categoria" name="categoria" class="form-control form-control-sm" required>
            </div>
            <div class="mb-3">
                <button type="submit" class="btn btn-secondary">Salvar</button>
            </div>
        </form>
    </div>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
    <script>
        function toggleDarkMode() {
            const body = document.querySelector('body');
            body.classList.toggle('dark-mode');
        }
    </script>
</body>
</html>
