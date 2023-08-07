<%@ page import="java.sql.*" %>
<!DOCTYPE html>
<html>
<head>
    <title>Autenticando...</title>
</head>
<body>
    <% 
        String login = request.getParameter("login");
        String senha = request.getParameter("senha");

        // Configurar as informações do banco de dados
        String url = "jdbc:mysql://localhost/loja";
        String user = "root";
        String password = "";

        try {
            // Conectar ao banco de dados
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection(url, user, password);

            // Executar a consulta SQL para verificar as credenciais do usuário
            String query = "SELECT * FROM usuario WHERE login=? AND senha=?";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, login);
            stmt.setString(2, senha);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                // Usuário autenticado com sucesso
                String nomeUsuario = rs.getString("login"); // Obtém o nome do usuário do ResultSet
                session.setAttribute("nomeUsuario", nomeUsuario); // Armazena o nome do usuário na sessão
                response.sendRedirect("telausuario.jsp");
            } else {
                // Autenticação falhou, redirecionar para a página de login com uma mensagem de erro
                response.sendRedirect("login.jsp?erro=1");
            }

            // Fechar as conexões
            rs.close();
            stmt.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
            // Lidar com erros de conexão ou outras exceções
            response.sendRedirect("erro.jsp");
        }
    %>
</body>
</html>
