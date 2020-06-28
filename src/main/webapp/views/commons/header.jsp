<%@ page contentType="text/html;charset=UTF-8" %>

<header class="header">
    <div class="container">
        <h1 class="logo">Sistema de Cotações</h1>

        <nav class="nav">
            <ul class="menu">
                <li class="menu__item">
                    <a href="<c:url value="/cotacoes/novo"/>">Nova Cotação</a>
                </li>
                <li class="menu__item">
                    <a href="<c:url value="/produtos/novo"/>">Novo Produto</a>
                </li>
                <li class="menu__item">
                    <a href="<c:url value="/produtos"/>">Ver Produtos</a>
                </li>
                <li class="menu__item">
                    <a href="<c:url value="/cotacoes"/>">Ver Cotações</a>
                </li>
            </ul>
        </nav>
    </div>
</header>