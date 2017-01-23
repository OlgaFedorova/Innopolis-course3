package ru.innopolis.uni.course3.study_jms.chat.view;

import java.awt.*;

/**
 * Created by Olga on 23.01.2017.
 */
public class JMSWindow extends javax.swing.JFrame {

    public JMSWindow() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // //GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jTFNameModel = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jRBPtP = new javax.swing.JRadioButton();
        jRBPubSub = new javax.swing.JRadioButton();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTPTextMessage = new javax.swing.JTextPane();
        jBSendMessage = new javax.swing.JButton();
        jLConnected = new javax.swing.JLabel();
        jLInfSend = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jBConnectedListener = new javax.swing.JButton();
        jLConnected1 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTPReceivedMess = new javax.swing.JTextPane();
        jSeparator3 = new javax.swing.JSeparator();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Отправка сообщения JMS провайдеру");
        jLabel1.setToolTipText("");

        jLabel2.setText("Имя очереди/подписки");

        jTFNameModel.setText("SimpleQueue");
        jTFNameModel.setToolTipText("");
        jTFNameModel.setNextFocusableComponent(jRBPtP);

        jLabel3.setText("Вид модели");

        buttonGroup1.add(jRBPtP);
        jRBPtP.setSelected(true);
        jRBPtP.setText("точка-точка");
        jRBPtP.setToolTipText("");
        jRBPtP.setNextFocusableComponent(jRBPubSub);

        buttonGroup1.add(jRBPubSub);
        jRBPubSub.setText("подписчик/издатель");
        jRBPubSub.setToolTipText("");
        jRBPubSub.setNextFocusableComponent(jTPTextMessage);

        jLabel4.setText("Текст сообщения");
        jLabel4.setToolTipText("");

        jTPTextMessage.setNextFocusableComponent(jBSendMessage);
        jScrollPane1.setViewportView(jTPTextMessage);

        jBSendMessage.setText("Отправить сообщение");

        jLConnected.setText("Соединение не установлено");

        jLInfSend.setToolTipText("");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING,
                                javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
                                Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jSeparator1)
                                        .addComponent(jScrollPane1)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.
                                                        GroupLayout.Alignment.LEADING)
                                                        .addComponent(jLabel2)
                                                        .addComponent(jLabel3)
                                                        .addComponent(jLabel4)
                                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                                .addComponent(jBSendMessage)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(jLInfSend))
                                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.
                                                                        GroupLayout.Alignment.TRAILING, false)
                                                                        .addComponent(jTFNameModel, javax.swing.GroupLayout.
                                                                                Alignment.LEADING)
                                                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING,
                                                                                jPanel1Layout.createSequentialGroup()
                                                                                        .addComponent(jRBPtP)
                                                                                        .addGap(14, 14, 14)
                                                                                        .addComponent(jRBPubSub)))
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(jLConnected)))
                                                .addGap(0, 0, Short.MAX_VALUE)))
                                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.
                                        GroupLayout.Alignment.BASELINE)
                                        .addComponent(jTFNameModel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLConnected))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jRBPtP)
                                        .addComponent(jRBPubSub))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jBSendMessage)
                                        .addComponent(jLInfSend))
                                .addGap(0, 13, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("Получение сообщений от JMS провайдера");

        jBConnectedListener.setText("Подключить слушатель");

        jLConnected1.setText("Соединение не установлено");

        jLabel7.setText("Полученные сообщения:");
        jLabel7.setToolTipText("");

        jTPReceivedMess.setEditable(false);
        jScrollPane2.setViewportView(jTPReceivedMess);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                                                .addGap(168, 168, 168)
                                                                .addComponent(jLabel5))
                                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                                                .addContainerGap()
                                                                .addComponent(jBConnectedListener)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(jLConnected1))
                                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                                                .addContainerGap()
                                                                .addComponent(jLabel7)))
                                                .addGap(0, 144, Short.MAX_VALUE))
                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addContainerGap()
                                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING)
                                                        .addComponent(jSeparator3, javax.swing.GroupLayout.Alignment.TRAILING))))
                                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(4, 4, 4)
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jBConnectedListener)
                                        .addComponent(jLConnected1))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 245, Short.MAX_VALUE)
                                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addContainerGap())
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addContainerGap())
        );

        pack();
    }// //GEN-END:initComponents


    public void toggleSendConnected(){
        if (this.jLConnected.getText().equals("Соединение не установлено")){
            this.jLConnected.setText("Соединение установлено");
            this.jLConnected.setForeground(Color.green);
        }else{
            this.jLConnected.setText("Соединение не установлено");
            this.jLConnected.setForeground(Color.black);
        }
    }

    public void SendConnectedSucces(){
        this.jLConnected.setText("Соединение установлено");
        this.jLConnected.setForeground(Color.green);
    }

    public void toggleReceivedConnected(){
        if (this.jLConnected1.getText().equals("Соединение не установлено")){
            this.jLConnected1.setText("Соединение установлено");
            this.jLConnected1.setForeground(Color.green);
        }else{
            this.jLConnected1.setText("Соединение не установлено");
            this.jLConnected1.setForeground(Color.black);
        }
    }
    public void ReceivedConnectedSucces(){
        this.jLConnected1.setText("Соединение установлено");
        this.jLConnected1.setForeground(Color.green);
    }
    public void ReceivedConnectedClose(){
        this.jLConnected1.setText("Соединение не установлено");
        this.jLConnected1.setForeground(Color.black);
    }
    /**
     * Возвращает имя очереди или подписки, которой необходимо отправить сообщение.
     * @return
     */
    public String getQueueSendName(){
        return this.jTFNameModel.getText();
    }
    public void setTextReceiver(String text){
        this.jTPReceivedMess.setText(this.jTPReceivedMess.getText()+"\n"+text);

    }
    /**
     * Возвращает текст для отправки.
     * @return
     */
    public String getMessageSendText(){
        return this.jTPTextMessage.getText();
    }
    /**
     * Выбрана ли модель подключения точка-точка?
     * @return
     */
    public Boolean isPtP(){
        return jRBPtP.isSelected();
    }
    /**
     * Выбрана ли модель подключения подписчик\издатель?
     * @return
     */
    public Boolean isPupSub(){
        return jRBPubSub.isSelected();
    }
    public void SendSuccess(){
        this.jLInfSend.setText("Сообщение успешно отправлено");
        this.jLInfSend.setForeground(Color.green);
    }
    public void SendError(){
        this.jLInfSend.setText("Сообщение не удалось отправить");
        this.jLInfSend.setForeground(Color.red);
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    public javax.swing.JButton jBConnectedListener;
    public javax.swing.JButton jBSendMessage;
    private javax.swing.JLabel jLConnected;
    private javax.swing.JLabel jLConnected1;
    private javax.swing.JLabel jLInfSend;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JRadioButton jRBPtP;
    private javax.swing.JRadioButton jRBPubSub;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JTextField jTFNameModel;
    private javax.swing.JTextPane jTPReceivedMess;
    private javax.swing.JTextPane jTPTextMessage;
}
