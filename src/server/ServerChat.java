/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

import dao.DataController;
import helper.ActionType;
import java.awt.Frame;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.User;

/**
 *
 * @author Admin
 */
public class ServerChat extends javax.swing.JFrame {
    DataController dct;
    ServerSocket server;
    int Port;
    ArrayList<Socket> Logged = new ArrayList<>();
    /**
     * Creates new form ChatServer
     */
    public ServerChat() {
        initComponents();
        LoadForm();
    }

    public void RemoveClient(Socket socket){
        try {
            Logged.remove(socket);
            socket.close();
        } catch (IOException ex) {
            Logger.getLogger(ServerChat.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void SendMsgToClient(Socket socket, String Msg){
        try {
            DataOutputStream dout = new DataOutputStream(socket.getOutputStream());
            dout.writeUTF(Msg);
        } catch (IOException ex) {
            RemoveClient(socket);
            System.err.println(ex.getMessage());
            Logger.getLogger(ServerChat.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void ShowErrorMsg(String Msg){
        JOptionPane.showMessageDialog(new Frame(), Msg, "Dialog", JOptionPane.ERROR_MESSAGE);
    }
    public void SendMsgToAll(String Msg){
        for (Socket socket : Logged) {
            SendMsgToClient(socket, Msg);
        }
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelInfo = new javax.swing.JPanel();
        lbServerInfo = new javax.swing.JLabel();
        panelConnect = new javax.swing.JPanel();
        txtPort = new javax.swing.JTextField();
        btnStartServer = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        txtUsername = new javax.swing.JTextField();
        txtPassword = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtIP = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        panelInfo.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "CHAT SERVER ", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Tahoma", 1, 14))); // NOI18N
        panelInfo.setLayout(new java.awt.GridBagLayout());

        lbServerInfo.setText("Server is listening on port");
        lbServerInfo.setEnabled(false);
        panelInfo.add(lbServerInfo, new java.awt.GridBagConstraints());

        panelConnect.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "CHAT SERVER", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Tahoma", 1, 14))); // NOI18N

        txtPort.setText("6666");

        btnStartServer.setText("Start Server");
        btnStartServer.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnStartServer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnStartServerActionPerformed(evt);
            }
        });

        jLabel1.setText("Run at port:");

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true), "SQL SERVER INFORMATION", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Tahoma", 2, 10))); // NOI18N

        txtUsername.setText("xizot");

        txtPassword.setText("1234");

        jLabel2.setText("Password:");

        jLabel3.setText("Username:");

        jLabel4.setText("IP:");

        txtIP.setText("DESKTOP-IKO3LOH;database=CHAT_APPLICATION");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(114, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jLabel3)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtIP)
                    .addComponent(txtUsername)
                    .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 369, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(72, 72, 72))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtIP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtUsername, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout panelConnectLayout = new javax.swing.GroupLayout(panelConnect);
        panelConnect.setLayout(panelConnectLayout);
        panelConnectLayout.setHorizontalGroup(
            panelConnectLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelConnectLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelConnectLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(panelConnectLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(btnStartServer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(panelConnectLayout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtPort, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(217, 217, 217))
        );
        panelConnectLayout.setVerticalGroup(
            panelConnectLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelConnectLayout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelConnectLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPort, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addComponent(btnStartServer, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(55, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelConnect, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(panelInfo, javax.swing.GroupLayout.DEFAULT_SIZE, 649, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panelConnect, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(panelInfo, javax.swing.GroupLayout.DEFAULT_SIZE, 311, Short.MAX_VALUE)
                    .addContainerGap()))
        );

        panelConnect.getAccessibleContext().setAccessibleParent(panelConnect);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnStartServerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnStartServerActionPerformed
        try {
            
            // TODO add your handling code here:
            String IP = txtIP.getText();
            String Username = txtUsername.getText();
            String Password = txtPassword.getText();
            Port = Integer.parseInt(txtPort.getText());
            
        
            dct = new DataController(Username, Password, IP);
            server = new ServerSocket(Port);
            StartServer ss = new StartServer();
            ss.start();
            
           
            panelConnect.setVisible(false);
            panelInfo.setVisible(true);
            
            InetAddress inetAddress;
            inetAddress = InetAddress.getLocalHost();
            lbServerInfo.setText(String.format("Server is listening on IP: %s and Port: %d", inetAddress.getHostAddress(), Port));

           
        } catch (Exception ex) {
            ShowErrorMsg(ex.getMessage());
            Logger.getLogger(ServerChat.class.getName()).log(Level.SEVERE, null, ex);
        } 
        
    }//GEN-LAST:event_btnStartServerActionPerformed

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
    
    }//GEN-LAST:event_formWindowClosed

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
            java.util.logging.Logger.getLogger(ServerChat.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ServerChat.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ServerChat.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ServerChat.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ServerChat().setVisible(true);
            }
        });
    }

    private void LoadForm() {
        panelInfo.setVisible(false);
    }
    
    class StartServer extends Thread{
        
        boolean isRunning = false;
        public StartServer(){}
        public void StopServer(){
            isRunning = false;
//                server.close();
            this.interrupt();
        }
        @Override
        public void run(){
            isRunning = true;
            try {
                while(isRunning){
                    Socket socket = server.accept();
                    DataInputStream din = new DataInputStream(socket.getInputStream());   
                    DataOutputStream dout = new DataOutputStream(socket.getOutputStream());

                    System.out.println("success");
                    ServerHandler sh = new ServerHandler(socket,dct, din, dout);
                    sh.start();
                }
                
            } catch (IOException ex) {
                System.err.println(ex.getMessage());
                Logger.getLogger(ServerChat.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    class ServerHandler extends Thread{
        Socket socket;
        DataController dct;
        DataInputStream din;
        DataOutputStream dout;
        public ServerHandler(Socket socket, DataController dct, DataInputStream din, DataOutputStream dout) {
            this.dct = dct;
            this.socket = socket;
            this.din = din;
            this.dout = dout;
        }
        
        public void StopHandle() throws IOException{
//            RemoveClient(socket);
            this.interrupt();
        }
        
        public void Login(String Username, String Password) throws SQLException, IOException {
                User user = dct.getUserByUsername(Username);
               
                if(user == null){
                    System.out.println("The username you entered isn't connected to an account");
                    dout.writeUTF(ActionType.ERROR_RESPONSE);
                    dout.writeUTF("The username you entered isn't connected to an account");
                    return;
                   
                }
                if(user.getPassword().equals(Password.trim())){
                    System.out.println("Login successful");
                    dout.writeUTF(ActionType.SUCCESS_RESPONSE);
                    dout.writeUTF("Login successful");
                     return;
                }
                if(!user.getPassword().equals(Password.trim())){
                    System.out.println("The password that you've entered is incorrect");
                    dout.writeUTF(ActionType.ERROR_RESPONSE);
                    dout.writeUTF("The password that you've entered is incorrect.");
                     return;
                }
                System.out.println("The password that you've entered is incorrect");
                dout.writeUTF(ActionType.ERROR_RESPONSE);
                dout.writeUTF("Something is missing. Please try again");
        }
        public void Register(User user) {
            
            try {
                User findUser = dct.getUserByUsername(user.getUsername());
                if(findUser != null){
                    dout.writeUTF(ActionType.ERROR_RESPONSE);
                    dout.writeUTF("The username is taken. Try another");
                    return;
                }
                
                dct.AddUser(user);
                dout.writeUTF(ActionType.SUCCESS_RESPONSE);
                dout.writeUTF("Register successfully");
            } catch (Exception ex) {
                try {
                    dout.writeUTF(ActionType.ERROR_RESPONSE);
                    dout.writeUTF(ex.getMessage());
                } catch (IOException ex1) {
                    System.err.println(ex1.getMessage());
                    Logger.getLogger(ServerChat.class.getName()).log(Level.SEVERE, null, ex1);
                }
              
            }
          
        }
        
        @Override
        public void run(){
            String action = "";
             while (true) {
                try {
                    action = din.readUTF().trim().toUpperCase();
                    System.out.println(action);
                    if(action.equals(ActionType.REGISTER_ACTION)){
                        
                        String Name = din.readUTF().trim();             
                        String Username = din.readUTF().trim();
                        String Password = din.readUTF().trim();
                        
                        User user = new User(Name, Username, Password);
                        Register(user);
                        
                    }
                    if(action.equals(ActionType.LOGIN_ACTION)){
                        String Username = din.readUTF().trim();
                        String Password = din.readUTF().trim();
                        Login(Username, Password);
                    }
                    if(action.equals(ActionType.CHAT_MESSAGE)){
                        String Msg = din.readUTF();
                        SendMsgToAll(Msg);
                        
                    }
                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                    Logger.getLogger(ServerChat.class.getName()).log(Level.SEVERE, null, ex);
                }
                   
                
            }
        }
 
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnStartServer;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel lbServerInfo;
    private javax.swing.JPanel panelConnect;
    private javax.swing.JPanel panelInfo;
    private javax.swing.JTextField txtIP;
    private javax.swing.JTextField txtPassword;
    private javax.swing.JTextField txtPort;
    private javax.swing.JTextField txtUsername;
    // End of variables declaration//GEN-END:variables
}
