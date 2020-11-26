/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import Control.ContaClienteControl;
import javax.swing.JOptionPane;


public class TelaRegistro extends javax.swing.JFrame {

    private ContaClienteControl controlador;
    
    public TelaRegistro() {
        initComponents();
        this.controlador = new ContaClienteControl();
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        inputNome = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        inputUsuario = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        inputEmail = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        inputSenha = new javax.swing.JPasswordField();
        jLabel6 = new javax.swing.JLabel();
        inputCpf = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        inputNumCartao = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        inputValCartao = new javax.swing.JTextField();
        botaoCriarConta = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("Preencha os seus dados corretamente");

        jLabel2.setText("Nome completo");

        jLabel3.setText("Usuário");

        jLabel4.setText("E-mail");

        jLabel5.setText("jLabel5");

        jLabel6.setText("CPF");

        jLabel7.setText("Número do Cartão");

        jLabel8.setText("Validade do Cartão");

        botaoCriarConta.setText("Criar conta");
        botaoCriarConta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoCriarContaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addGap(220, 220, 220)
                                .addComponent(jLabel8))
                            .addComponent(jLabel6)
                            .addComponent(jLabel5)
                            .addComponent(jLabel4)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1)
                            .addComponent(inputNome)
                            .addComponent(inputUsuario)
                            .addComponent(inputEmail)
                            .addComponent(inputSenha)
                            .addComponent(inputCpf)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(inputNumCartao, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(inputValCartao, javax.swing.GroupLayout.DEFAULT_SIZE, 222, Short.MAX_VALUE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(251, 251, 251)
                        .addComponent(botaoCriarConta, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(38, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(inputNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(inputUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(inputEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(inputSenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(inputCpf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(inputNumCartao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(inputValCartao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addComponent(botaoCriarConta, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(31, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botaoCriarContaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoCriarContaActionPerformed
try{
            String nome = "";
            String usuario = "";
            String senha = "";
            String email = "";
            int cpf = 0;
            int numCartao = 0;
            String valCartao = "";
            
            if (this.inputNome.getText().length() <= 0) {
                throw new Mensagens("Deve inserir o seu nome");
            }else {
                nome = this.inputNome.getText();
            }
            
            if (this.inputUsuario.getText().length() <= 0) {
                throw new Mensagens("Deve inserir o seu usuário");
            }else {
                usuario = this.inputUsuario.getText();
            }
            
            if (this.inputSenha.getText().length() <= 5) {
                throw new Mensagens("A senha deve ter 5 ou mais caractéres");
            }else {
                senha = this.inputSenha.getText();
            }
            
            if (this.inputEmail.getText().length() <= 0) {
                throw new Mensagens("Deve inserir o seu email");
            }else {
                email = this.inputEmail.getText();
            }
            
            if (this.inputCpf.getText().length() == 11) {
                throw new Mensagens("Insira um CPF válido");
            }else {
                cpf = Integer.parseInt(this.inputCpf.getText());
            }
            
            if (this.inputNumCartao.getText().length() == 16) {
                throw new Mensagens("Insira um número de cartão de crédito válido válido");
            }else {
                numCartao = Integer.parseInt(this.inputNumCartao.getText());
            }
            
            if (this.inputValCartao.getText().length() <= 0) {
                throw new Mensagens("Deve inserir a validade do seu cartão de crédito");
            }else {
                valCartao = this.inputValCartao.getText();
            }
            
            if (this.controlador.Registrar(nome, usuario, senha, email, cpf, numCartao, valCartao)) {
                JOptionPane.showMessageDialog(rootPane, "Cadastro foi realizado com sucesso");
                
                this.inputNome.setText("");
                this.inputUsuario.setText("");
                this.inputSenha.setText("");
                this.inputEmail.setText("");
                this.inputCpf.setText("");
                this.inputNumCartao.setText("");
                this.inputValCartao.setText("");
            }
            
            System.out.println(this.controlador.getMinhaLista().toString);
        } catch (Mensagens erro) {
            JOptionPane.showMessageDialog(null, erro.getMessage());
        } catch (NumberFormatException erro2) {
           JOptionPane.showMessageDialog(null, "Informar um número"); 
        }
    }//GEN-LAST:event_botaoCriarContaActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TelaRegistro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaRegistro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaRegistro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaRegistro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaRegistro().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botaoCriarConta;
    private javax.swing.JTextField inputCpf;
    private javax.swing.JTextField inputEmail;
    private javax.swing.JTextField inputNome;
    private javax.swing.JTextField inputNumCartao;
    private javax.swing.JPasswordField inputSenha;
    private javax.swing.JTextField inputUsuario;
    private javax.swing.JTextField inputValCartao;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    // End of variables declaration//GEN-END:variables
}
