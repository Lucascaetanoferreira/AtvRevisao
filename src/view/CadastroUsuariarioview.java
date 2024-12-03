package view;

import controller.ArquivoUtil;
import model.Usuario;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.util.List;

public class CadastroUsuario extends JFrame {
    private JTextField txtNome, txtEmail, txtSenha, txtTipo;

    public CadastroUsuario() {
        setTitle("Cadastro de Usuários");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new GridLayout(5, 2));

        txtNome = new JTextField();
        txtEmail = new JTextField();
        txtSenha = new JPasswordField();
        txtTipo = new JTextField();

        JButton btnSalvar = new JButton("Salvar");
        btnSalvar.addActionListener(this::salvarUsuario);

        add(new JLabel("Nome:"));
        add(txtNome);
        add(new JLabel("E-mail:"));
        add(txtEmail);
        add(new JLabel("Senha:"));
        add(txtSenha);
        add(new JLabel("Tipo de Usuário:"));
        add(txtTipo);
        add(btnSalvar);
    }

    private void salvarUsuario(ActionEvent e) {
        String nome = txtNome.getText();
        String email = txtEmail.getText();
        String senha = txtSenha.getText();
        String tipo = txtTipo.getText();

        Usuario usuario = new Usuario(nome, email, senha, tipo);

        try {
            ArquivoUtil<Usuario> util = new ArquivoUtil<>("data/usuarios.txt");
            List<Usuario> usuarios = util.carregar();
            usuarios.add(usuario);
            util.salvar(usuarios);
            JOptionPane.showMessageDialog(this, "Usuário salvo com sucesso!");
        } catch (IOException | ClassNotFoundException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Erro ao salvar usuário!");
        }
    }
}
