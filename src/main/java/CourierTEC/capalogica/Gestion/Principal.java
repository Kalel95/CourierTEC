/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CourierTEC.capalogica.Gestion;

import CourierTEC.capalogica.estructuraDatos.ColaPrioridad;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Joel
 */
public class Principal extends javax.swing.JFrame {
    //declaración de contadores para asignar el número de ficha
    int NFicha=0;
    int NFicha2=0;
    int CantidadP=0;
    int CantidadNP=0;
    String TotalP="";String TotalNP="";   
    int AtendidosP=0;int AtendidosNP=0;   
    int TotalD=0;int TotalM=0;int TotalE=0;int TotalR=0;
    DefaultTableModel ventanilla1= new DefaultTableModel();
    DefaultTableModel ventanilla2= new DefaultTableModel();
    DefaultTableModel ventanilla3= new DefaultTableModel();
    DefaultTableModel ventanilla4= new DefaultTableModel();
    private static Fichas t;
    //creación de colas de prioridad
    ColaPrioridad PrioridadP=new ColaPrioridad(4);
    ColaPrioridad PrioridadNP=new ColaPrioridad(4);
    ColaPrioridad Seguridad=new ColaPrioridad(4);
    ColaPrioridad SeguridadNP=new ColaPrioridad(4);
    ColaPrioridad Seguridad1=new ColaPrioridad(2);
    //Contadores para saber la cantidad de usuarios atendidos
    //Por tipo de paquete
    int cont1=1, cont2=1, cont3=1, cont4=1;
    int CDP=0;int CMP=0;int CEP=0;int CRP=0;
    int CDNP=0;int CMNP=0;int CENP=0;int CRNP=0;
    static int rango1=0, rango2=0;
    int AtendidosTP=1; 
    int AtendidosTNP=1;
    Fichas FichaSP = new Fichas(4, "Regular");
    Fichas FichaS1P = new Fichas(3, "Embarazada");
    Fichas FichaS11P = new Fichas(1, "Adulto");
    Fichas FichaS2 = new Fichas(4, "Regular");
    Fichas FichaS12 = new Fichas(1, "Adulto");
    Fichas FichaS112 = new Fichas(3, "Embarazada");
    
    static Fichas Ficha;
    /**
     * Creates new form Principal
     */
    public Principal() {
        initComponents();
        ventanilla1.addColumn("Ventanilla");
        ventanilla2.addColumn("Ventanilla");
        ventanilla3.addColumn("Ventanilla");
        ventanilla1.addColumn("Estado");
        ventanilla2.addColumn("Estado");
        ventanilla3.addColumn("Estado");
        ventanilla1.addColumn("Ficha");
        ventanilla2.addColumn("Ficha");
        ventanilla3.addColumn("Ficha");
        ventanilla1.addColumn("Tipo de Usuario");
        ventanilla2.addColumn("Tipo de Usuario");
        ventanilla3.addColumn("Tipo de Usuario");
        ventanilla1.addColumn("Atendidos");
        ventanilla2.addColumn("Atendidos");
        jTable1.setModel(ventanilla1);
        jTable2.setModel(ventanilla2);
        jTable3.setModel(ventanilla3);
    }
    
    public class Hilos extends Thread{
        int  Fila=0;
        int cola = 0;
        int  duracion;
        
        @Override
        public void run()  {
            ColaPrioridad atendiendo;
            Fichas atendiendo1;
            Seguridad1.enqueue(Seguridad, 0);
            Seguridad1.enqueue(SeguridadNP, 1);
                while(Seguridad1.First()!=null) {
                    atendiendo =(ColaPrioridad) Seguridad1.dequeue();
                    while(atendiendo.First()!=null){
                        atendiendo1 = (Fichas) atendiendo.dequeue();
                        if(Fila==ventanilla3.getRowCount()) Fila=0;
                        while(Fila!=ventanilla3.getRowCount()){
                        if("Atendiendo".equals((String) jTable3.getValueAt(Fila, 1))) {
                            Fila++;
                        }
                        else {
                            this.calcularDuracion();
                            System.out.println(ventanilla3.getRowCount()+"fila");
                            System.out.println(Fila+"fila");
                            System.out.println(duracion);
                            ventanilla3.setValueAt("Atendiendo", Fila, 1);
                            ventanilla3.setValueAt(atendiendo1.getFicha(), Fila, 2);
                            ventanilla3.setValueAt(atendiendo1.getTipoUsuario(), Fila, 3);
                            jTable3.setModel(ventanilla3);
                            Fila++;
                            try {
                                Thread.sleep(1000*duracion);
                                ventanilla3.setValueAt("Libre", Fila-1, 1);
                                ventanilla3.setValueAt("-", Fila-1, 2);
                                ventanilla3.setValueAt("-", Fila-1, 3);
                                jTable3.setModel(ventanilla3);
                            } 
                            catch (InterruptedException ex) {
                                Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
                            }
                            break;
                        }
                    }
                        System.out.println(atendiendo1.getFicha());
                    }
                }
        }
        public final void calcularDuracion() {
            duracion = ((int) (Math.random() * rango1) + 1) - ((int) (Math.random() * rango2) + 1);
            if (duracion < 0) {
                duracion *= -1;
            } else if (duracion == 0) {
                duracion++;
            }
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

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jComboBox1 = new javax.swing.JComboBox<>();
        jComboBox2 = new javax.swing.JComboBox<>();
        jPanel1 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        FieldE = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        FieldS = new javax.swing.JTextField();
        ButtonCantVent = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        FieldENoP = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jTextField4 = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable3 = new javax.swing.JTable();
        Atender1 = new javax.swing.JButton();
        Liberar1 = new javax.swing.JButton();
        Atender2 = new javax.swing.JButton();
        Liberar2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jLabel17 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1370, 750));
        getContentPane().setLayout(null);

        jLabel1.setFont(new java.awt.Font("Impact", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(167, 162, 162));
        jLabel1.setText("Courier TEC");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(510, 0, 210, 45);

        jLabel2.setFont(new java.awt.Font("Leelawadee UI", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(167, 162, 162));
        jLabel2.setText("Quiosco de AutoServicio");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(10, 50, 300, 32);

        jLabel3.setFont(new java.awt.Font("Leelawadee UI", 1, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(167, 162, 162));
        jLabel3.setText("Seguridad");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(370, 420, 120, 32);

        jLabel4.setFont(new java.awt.Font("Leelawadee UI", 1, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(167, 162, 162));
        jLabel4.setText("Entregas");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(890, 50, 120, 32);

        jLabel5.setFont(new java.awt.Font("Leelawadee UI", 1, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(167, 162, 162));
        jLabel5.setText("Administración");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(1030, 400, 190, 32);

        jButton1.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        jButton1.setText("Retirar tiquete");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(50, 250, 120, 25);

        jLabel6.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jLabel6.setText("Nombre:");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(20, 120, 60, 17);

        jLabel7.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jLabel7.setText("Correo:");
        getContentPane().add(jLabel7);
        jLabel7.setBounds(20, 150, 50, 17);

        jLabel8.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jLabel8.setText("Tipo de Usuario:");
        getContentPane().add(jLabel8);
        jLabel8.setBounds(0, 180, 100, 17);

        jLabel9.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jLabel9.setText("Tipo de Paquete:");
        getContentPane().add(jLabel9);
        jLabel9.setBounds(0, 210, 110, 17);

        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });
        getContentPane().add(jTextField1);
        jTextField1.setBounds(110, 120, 100, 20);
        getContentPane().add(jTextField2);
        jTextField2.setBounds(110, 150, 100, 20);

        jComboBox1.setFont(new java.awt.Font("Calibri", 1, 11)); // NOI18N
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccionar Tipo ", "Discapacitado", "Adulto Mayor", "Mujer Embarazada", "Cliente Regular" }));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });
        getContentPane().add(jComboBox1);
        jComboBox1.setBounds(110, 180, 100, 20);

        jComboBox2.setFont(new java.awt.Font("Calibri", 1, 11)); // NOI18N
        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccionar Tipo", "Perecedero", "No perecedero" }));
        jComboBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox2ActionPerformed(evt);
            }
        });
        getContentPane().add(jComboBox2);
        jComboBox2.setBounds(110, 210, 100, 20);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Configuracion Inicial", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Calibri", 1, 12))); // NOI18N
        jPanel1.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N

        jLabel10.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        jLabel10.setText("Entregas:");

        FieldE.setToolTipText("");
        FieldE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FieldEActionPerformed(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        jLabel11.setText("Seguridad:");

        FieldS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FieldSActionPerformed(evt);
            }
        });

        ButtonCantVent.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        ButtonCantVent.setText("Crear");
        ButtonCantVent.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonCantVentActionPerformed(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        jLabel12.setText("Perecederos");

        jLabel13.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        jLabel13.setText("No Perecederos");

        FieldENoP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FieldENoPActionPerformed(evt);
            }
        });

        jLabel18.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        jLabel18.setText("Tiempo Minimo");

        jLabel19.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        jLabel19.setText("Tiempo Miaximo");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(FieldE, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel12)
                            .addComponent(FieldS, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(FieldENoP, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(41, 41, 41))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel13)
                                .addGap(24, 24, 24))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(108, 108, 108)
                .addComponent(jLabel11)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                .addComponent(ButtonCantVent, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel13)
                        .addGap(105, 105, 105))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(7, 7, 7)
                                .addComponent(jLabel12)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(44, 44, 44)
                                .addComponent(jLabel11))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(47, 47, 47)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(FieldENoP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(FieldE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(FieldS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel19))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ButtonCantVent))
                .addGap(0, 14, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1);
        jPanel1.setBounds(250, 90, 310, 230);

        jTable1.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Ventanilla", "Estado"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(590, 120, 360, 170);

        jTable2.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Ventanilla", "Estado"
            }
        ));
        jScrollPane2.setViewportView(jTable2);

        getContentPane().add(jScrollPane2);
        jScrollPane2.setBounds(960, 120, 350, 170);

        jTable3.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        jTable3.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Ventanilla", "Estado"
            }
        ));
        jScrollPane3.setViewportView(jTable3);

        getContentPane().add(jScrollPane3);
        jScrollPane3.setBounds(60, 460, 500, 190);

        Atender1.setBackground(new java.awt.Color(255, 0, 0));
        Atender1.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        Atender1.setText("Atender");
        Atender1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Atender1ActionPerformed(evt);
            }
        });
        getContentPane().add(Atender1);
        Atender1.setBounds(650, 300, 71, 25);

        Liberar1.setBackground(new java.awt.Color(51, 255, 0));
        Liberar1.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        Liberar1.setText("Liberar");
        Liberar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Liberar1ActionPerformed(evt);
            }
        });
        getContentPane().add(Liberar1);
        Liberar1.setBounds(810, 300, 80, 25);

        Atender2.setBackground(new java.awt.Color(255, 0, 0));
        Atender2.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        Atender2.setText("Atender");
        Atender2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Atender2ActionPerformed(evt);
            }
        });
        getContentPane().add(Atender2);
        Atender2.setBounds(1010, 300, 71, 25);

        Liberar2.setBackground(new java.awt.Color(51, 255, 0));
        Liberar2.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        Liberar2.setText("Liberar");
        Liberar2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Liberar2ActionPerformed(evt);
            }
        });
        getContentPane().add(Liberar2);
        Liberar2.setBounds(1170, 300, 80, 25);

        jButton3.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        jButton3.setText("Estado de Colas");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3);
        jButton3.setBounds(950, 450, 130, 25);

        jButton2.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        jButton2.setText("Estadisticas");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2);
        jButton2.setBounds(1150, 450, 130, 25);

        jButton4.setFont(new java.awt.Font("Calibri", 1, 11)); // NOI18N
        jButton4.setText("Cola");
        getContentPane().add(jButton4);
        jButton4.setBounds(270, 370, 53, 23);

        jButton5.setFont(new java.awt.Font("Calibri", 1, 11)); // NOI18N
        jButton5.setText("Heap");
        getContentPane().add(jButton5);
        jButton5.setBounds(477, 370, 60, 23);

        jButton6.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        jButton6.setText("Tiempo Promedio");
        getContentPane().add(jButton6);
        jButton6.setBounds(1050, 500, 130, 25);

        jButton7.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        jButton7.setText("Clientes Atendidos por Ventanilla");
        getContentPane().add(jButton7);
        jButton7.setBounds(1010, 560, 210, 25);

        jButton8.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        jButton8.setText("Comenzar");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton8);
        jButton8.setBounds(610, 550, 100, 25);

        jLabel17.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        jLabel17.setText("Estructura:");
        getContentPane().add(jLabel17);
        jLabel17.setBounds(380, 340, 60, 16);

        jLabel20.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jLabel20.setText("Perecederos");
        getContentPane().add(jLabel20);
        jLabel20.setBounds(720, 90, 100, 20);

        jLabel21.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jLabel21.setText("No Perecederos");
        getContentPane().add(jLabel21);
        jLabel21.setBounds(1070, 90, 120, 20);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        String TipoUsuario="",TipoPaquete="";
        //Verificar que se selecciones el tipo de usuario y paquete
        if (jComboBox1.getSelectedIndex()==0 ||jComboBox2.getSelectedIndex()==0 ){
            JOptionPane.showMessageDialog(null,"Debe seleccionar un tipo de Usuario y Paquete");
            return;
        }
        //condiciones para asignar-crear la ficha dependiendo del tipo de usuario
        if(jComboBox1.getSelectedIndex()==1){
            TipoUsuario="D";
            TotalD++;
        }
        else if (jComboBox1.getSelectedIndex()==2){
            TipoUsuario="M";
            TotalM++;
        }
        else if (jComboBox1.getSelectedIndex()==3){
            TipoUsuario="E";
            TotalE++;
        }
        else if (jComboBox1.getSelectedIndex()==4){
            TipoUsuario="R";
            TotalR++;
        }
        //condiciones para asignar-crear la ficha dependiendo del tipo de paquete
        if(jComboBox2.getSelectedIndex()==1){
            if(jComboBox1.getSelectedIndex()==1) CDP++;
            else if (jComboBox1.getSelectedIndex()==2)CMP++;
            else if (jComboBox1.getSelectedIndex()==3)CEP++;
            else if (jComboBox1.getSelectedIndex()==4)CRP++;
            TipoPaquete="P";
            //Creación del atributo ficha
            String Ficha=TipoPaquete+"-"+TipoUsuario+"-"+NFicha;
            NFicha++;
            //Creación de ficha con los datos ingresados por el usuario
            Fichas NuevaFicha=new Fichas(jTextField1.getText(),jTextField2.getText(),
                jComboBox1.getSelectedIndex(),jComboBox2.getSelectedIndex(),Ficha);
        
            CantidadP++;
        
        jComboBox1.setSelectedIndex(0);
        jComboBox2.setSelectedIndex(0);
        String info=("Ficha Creada"+"\nNombre: "+NuevaFicha.getNombre()+"\nCorreo: "+NuevaFicha.getCorreo()+"\nFicha: "+NuevaFicha.getFicha());
        JOptionPane.showMessageDialog(this, info);
        //Agrega el objeto ficha a la cola de acuerdo a su prioridad de usuario
        PrioridadP.enqueue(NuevaFicha, NuevaFicha.getTipoUsuario()-1);
        TotalP+="\n "+NuevaFicha.getFicha();
        AtendidosP+=1;
       
        
        }
        else if(jComboBox2.getSelectedIndex()==2){
            if(jComboBox1.getSelectedIndex()==1) CDNP++;
            else if (jComboBox1.getSelectedIndex()==2)CMNP++;
            else if (jComboBox1.getSelectedIndex()==3)CENP++;
            else if (jComboBox1.getSelectedIndex()==4)CRNP++;
            TipoPaquete="NP";
            //Creación del atributo ficha
            String Ficha=TipoPaquete+"-"+TipoUsuario+"-"+NFicha2;
            NFicha2++;
            //Creación de ficha con los datos ingresados por el usuario
            Fichas NuevaFicha=new Fichas(jTextField1.getText(),jTextField2.getText(),
                jComboBox1.getSelectedIndex(),jComboBox2.getSelectedIndex(),Ficha);
        
        //Reinicar los botones despegables
        jComboBox1.setSelectedIndex(0);
        jComboBox2.setSelectedIndex(0);
        String info=("Ficha Creada"+"\nNombre: "+NuevaFicha.getNombre()+"\nCorreo: "+NuevaFicha.getCorreo()+"\nFicha: "+NuevaFicha.getFicha());
        //Mostrar en pantalla la ficha asignada al usuario
        JOptionPane.showMessageDialog(this, info);
        //Agrega el objeto ficha a la cola de acuerdo a su prioridad de usuario   
        PrioridadNP.enqueue(NuevaFicha, NuevaFicha.getTipoUsuario()-1);
        CantidadNP++;
        TotalNP+="\n "+NuevaFicha.getFicha();
        AtendidosNP+=1;
        }
        
        
        
        
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jComboBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox2ActionPerformed
        
    }//GEN-LAST:event_jComboBox2ActionPerformed

    private void FieldEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FieldEActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_FieldEActionPerformed

    private void FieldSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FieldSActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_FieldSActionPerformed

    private void ButtonCantVentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonCantVentActionPerformed
        int cantVEntregas, cantVENoP, cantVSeguridad;
        //Verificar que el usurio ingrese un dato en todos los textfields
        if(((FieldE.getText() == null || FieldE.getText().equals("")) || (FieldS.getText() == null || FieldS.getText().equals(""))) || ((FieldENoP.getText() == null || FieldENoP.getText().equals("")) )) {
            JOptionPane.showMessageDialog(null,"Debe ingresar un numero en los espacios");
            return;
        }
        
        rango1 = Integer.parseInt(jTextField3.getText());
        rango2 = Integer.parseInt(jTextField4.getText());
        
        cantVEntregas = Integer.parseInt(FieldE.getText());
        cantVENoP = Integer.parseInt(FieldENoP.getText());
        cantVSeguridad = Integer.parseInt(FieldS.getText());
        
        //crear ventanas en el quisco
        for(int i=0;i<cantVEntregas;i++) {
   
            String Dato[]=new String[3];
            Dato[0]= "Ventanilla "+cont1;
            Dato[1]="";
            Dato[2]="";
            ventanilla1.addRow(Dato);
            cont1++;
        }
        for(int i=0;i<cantVENoP;i++) {
            String Dato[]=new String[3];
            Dato[0]= "Ventanilla "+cont2;
            Dato[1]="";
            Dato[2]="";
            ventanilla2.addRow(Dato);
            cont2++;
        }
        for(int i=0;i<cantVSeguridad;i++) {
            String Dato[]=new String[3];
            Dato[0]= "Ventanilla "+cont3;
            Dato[1]="";
            Dato[2]="";
            ventanilla3.addRow(Dato);
            cont3++;
        }

    }//GEN-LAST:event_ButtonCantVentActionPerformed

    private void FieldENoPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FieldENoPActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_FieldENoPActionPerformed

    private void Atender1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Atender1ActionPerformed
        int Fila=jTable1.getSelectedRow();
        //indicar que debe seleccionar la ventana donde va a ser atentido el usuario
        if (Fila==-1) JOptionPane.showMessageDialog(null, "Seleccione la ventanilla donde desea ser atendido");
        //atender al usuario en la ventana seleccionada
        else if(Fila>=0){
            //eliminar de la cola al usuario atendido(objeto ficha)
            Ficha=(Fichas) PrioridadP.dequeue();              
        int reglon = jTable1.getSelectedRow();
        ventanilla1.setValueAt("Atendiendo", reglon, 1);
        ventanilla1.setValueAt(Ficha.getFicha(), reglon, 2);
        ventanilla1.setValueAt(AtendidosTP, reglon, 4);
        String TUsuario = "";
        int infTable = (int) Ficha.getTipoUsuario();
            switch (infTable) {
                case 1:
                    TUsuario = "Discapacitado";
                    break;
                case 2:
                    TUsuario = "Adulto Mayor";
                    break;
                case 3:
                    TUsuario = "Embarazada";
                    break;
                case 4:
                    TUsuario = "Regular";
                    break;
                default:
                    break;
            }
        ventanilla1.setValueAt(TUsuario, reglon, 3);
        CantidadP--;
        AtendidosTP++;
        }
    }//GEN-LAST:event_Atender1ActionPerformed

    private void Atender2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Atender2ActionPerformed
        int Fila2=jTable1.getSelectedRow();
        if (Fila2==-1) JOptionPane.showMessageDialog(null, "Seleccione la ventanilla donde desea ser atendido");
        //atender al usuario en la ventana seleccionada
        else if(Fila2>=0){
            //eliminar de la cola al usuario atendido(objeto ficha)
            Ficha=(Fichas) PrioridadNP.dequeue();
        
        int reglon = jTable2.getSelectedRow();
        ventanilla2.setValueAt("Atendiendo", reglon, 1);
        ventanilla2.setValueAt(Ficha.getFicha(), reglon, 2);
        String TUsuario = "";
        int infTable = (int) Ficha.getTipoUsuario();
            switch (infTable) {
                case 1:
                    TUsuario = "Discapacitado";
                    break;
                case 2:
                    TUsuario = "Adulto Mayor";
                    break;
                case 3:
                    TUsuario = "Embarazada";
                    break;
                case 4:
                    TUsuario = "Regular";
                    break;
                default:
                    break;
            }
        ventanilla2.setValueAt(TUsuario, reglon, 3);
        CantidadNP--;
        AtendidosTNP++;
        }
    }//GEN-LAST:event_Atender2ActionPerformed

    private void Liberar2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Liberar2ActionPerformed
        int Fila3=jTable2.getSelectedRow();
        if (Fila3==-1) JOptionPane.showMessageDialog(null, "Seleccione la ventanilla a liberar");
        else if(Fila3>=0){
        int renglon = jTable2.getSelectedRow();
        int TUsuario = 0;
        String infTable = (String) jTable2.getValueAt(Fila3, 3);
        if( null != infTable) switch (infTable) {
                case "Discapacitado":
                    TUsuario = 1;
                    break;
                case "Adulto Mayor":
                    TUsuario = 2;
                    break;
                case "Embarazada":
                    TUsuario = 3;
                    break;
                case "Regular":
                    TUsuario = 4;
                    break;
                default:
                    break;
            }
        Fichas FichaS = new Fichas(TUsuario,(String) jTable2.getValueAt(Fila3, 2));
        SeguridadNP.enqueue(FichaS, TUsuario - 1);
        ventanilla2.setValueAt("Libre", renglon, 1);
        ventanilla2.setValueAt("-", renglon, 2);
        ventanilla2.setValueAt("-", renglon, 3);
        
        }
    }//GEN-LAST:event_Liberar2ActionPerformed

    private void Liberar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Liberar1ActionPerformed
        int Fila4=jTable1.getSelectedRow();
        if (Fila4==-1) JOptionPane.showMessageDialog(null, "Seleccione la ventanilla a liberar");
        else if(Fila4>=0){
        int renglon = jTable1.getSelectedRow();
        int TUsuario = 0;
        String infTable = (String) jTable1.getValueAt(Fila4, 3);
        if( null != infTable) switch (infTable) {
                case "Discapacitado":
                    TUsuario = 1;
                    break;
                case "Adulto Mayor":
                    TUsuario = 2;
                    break;
                case "Embarazada":
                    TUsuario = 3;
                    break;
                case "Regular":
                    TUsuario = 4;
                    break;
                default:
                    break;
            }
        Fichas FichaS = new Fichas(TUsuario,(String) jTable1.getValueAt(Fila4, 2));
        Seguridad.enqueue(FichaS, TUsuario - 1);
        ventanilla1.setValueAt("Libre", renglon, 1);
        ventanilla1.setValueAt("-", renglon, 2);
        ventanilla1.setValueAt("-", renglon, 3);
        
        }
        
    }//GEN-LAST:event_Liberar1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        String EstadoP;
        EstadoP = String.valueOf(CantidadP);
        String EstadoNP;
        EstadoNP = String.valueOf(CantidadNP);
        Fichas FichaSigP=(Fichas) PrioridadP.First();
        Fichas FichaSigNP=(Fichas) PrioridadNP.First();
        
        String Estados="Cantidad en Perecederos: "+EstadoP+"\n"+"\nCantidad en No Perecederos: "+EstadoNP+"\n"+
                "\nFichas de clientes en Perecederos: "+TotalP+"\nFichas de clientes en No Perecederos: "+TotalNP+"\n"+
                "\nSiguiente en la cola Perecederos: "+FichaSigP.getFicha()+"\nSiguiente en la cola No Perecederos: "+
                FichaSigNP.getFicha();
        JOptionPane.showMessageDialog(this, Estados);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        //Mostrar las estadisticas de usuarios atendidos 
        String Estadist="Fichas dispensadas en Perecederos:\t  "+AtendidosP+"\nFichas dispensadas en "
                + "No Perecederos: "+AtendidosNP+"\n"+"\nUsuarios Regulares atendidos:"+TotalR+"\nAdultos mayores atendidos:"+
                TotalM+"\nUsuarios Discapacitados atendidos:"+TotalD+"\nMujeres embarazadas atendidas:"+TotalE+"\n"+
                "\nUsuarios atendidos en Perecederos:"+"\nUsuarios Discapacitados atendidos: "+CDP+
                "\n Adultos Mayores atendidos: "+CMP+"\nMujeres Embarazadas atendidas: "+CEP+"\nUsuarios Regulares atendidos: "+CRP+
                "\n"+"\nUsuarios atendidos en No Perecederos:"+"\nUsuarios Discapacitados atendidos: "+CDNP+
                "\n Adultos Mayores atendidos: "+CMNP+"\nMujeres Embarazadas atendidas: "+CENP+"\nUsuarios Regulares atendidos: "+CRNP;
        
        JOptionPane.showMessageDialog(this, Estadist);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        // TODO add your handling code here:
        Seguridad.enqueue(FichaSP, 3);
        Seguridad.enqueue(FichaS1P, 1);
        Seguridad.enqueue(FichaS11P, 2);
        SeguridadNP.enqueue(FichaS2, 3);
        SeguridadNP.enqueue(FichaS12, 1);
        SeguridadNP.enqueue(FichaS112, 2);
        
        Hilos hilo = new Hilos();
        hilo.start();
    }//GEN-LAST:event_jButton8ActionPerformed

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
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Principal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Atender1;
    private javax.swing.JButton Atender2;
    private javax.swing.JButton ButtonCantVent;
    private javax.swing.JTextField FieldE;
    private javax.swing.JTextField FieldENoP;
    private javax.swing.JTextField FieldS;
    private javax.swing.JButton Liberar1;
    private javax.swing.JButton Liberar2;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTable jTable3;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    // End of variables declaration//GEN-END:variables
}
