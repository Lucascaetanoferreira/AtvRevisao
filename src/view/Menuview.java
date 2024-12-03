package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class MenuPrincipal extends JFrame {
    public MenuPrincipal() {
        setTitle("Menu Principal");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(4, 1));

        JButton btnCadastroUsuarios = new JButton("Cadastro de Usuários");
        JButton btnListarUsuarios = new JButton("Listar Usuários");

        btnCadastroUsuarios.addActionListener(this::abrirTelaCadastro);
        btnListarUsuarios.addActionListener(this::abrirTelaListagem);

        add(btnCadastroUsuarios);
        add(btnListarUsuarios);
    }

    private void abrirTelaCadastro(ActionEvent e) {
        new CadastroUsuario().setVisible(true);
    }

    private void abrirTelaListagem(ActionEvent e) {
        new ListarUsuarios().setVisible(true);
    }

    public static void main(String[] args) {
        new MenuPrincipal().setVisible(true);
    }
}
