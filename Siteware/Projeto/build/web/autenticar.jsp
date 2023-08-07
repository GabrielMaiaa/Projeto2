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

        // Configurar as informa��es do banco de dados
        String url = "jdbc:mysql://localhost/loja";
        String user = "root";
        String password = "";

        try {
            // Conectar ao banco de dados
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection(url, user, password);

            // Executar a consulta SQL para verificar as credenciais do usu�rio
            String query = "SELECT * FROM usuario WHERE login=? AND senha=?";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, login);
            stmt.setString(2, senha);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                // Usu�rio autenticado com sucesso
                String nomeUsuario = rs.getString("login"); // Obt�m o nome do usu�rio do ResultSet
                session.setAttribute("nomeUsuario", nomeUsuario); // Armazena o nome do usu�rio na sess�o
                response.sendRedirect("telausuario.jsp");
            } else {
                // Autentica��o falhou, redirecionar para a p�gina de login com uma mensagem de erro
                response.sendRedirect("login.jsp?erro=1");
            }

            // Fechar as conex�es
            rs.close();
            stmt.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
            // Lidar com erros de conex�o ou outras exce��es
            response.sendRedirect("erro.jsp");
        }
    %>
</body>
</html>
