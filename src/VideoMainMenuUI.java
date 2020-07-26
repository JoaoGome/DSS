
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.JFrame;


public class VideoMainMenuUI extends javax.swing.JFrame {

    
    private String email;
    private VideoDAO video;
    private UserVideoDAO videos;
    private CategoriaVideoDAO categoria_video;
    private ArrayList <Video> lista_videos;
    private DefaultListModel model = new DefaultListModel ();
    
    public VideoMainMenuUI() throws SQLException, ClassNotFoundException {
        this.lista_videos = null;
        this.video = new VideoDAO ();
        this.videos = new UserVideoDAO ();
        this.categoria_video = new CategoriaVideoDAO ();
        initComponents();
        this.jListVideos.setModel(model);
    }

    public void preenche_lista () throws SQLException {
        ArrayList <Integer> lista_ids = videos.devolveVideo(this.email);
        this.lista_videos = video.devolveVideos(lista_ids);
    }
    
    public void add_model (String nome) {
        this.model.addElement(nome);
    }
    
   
    public void set_email (String new_email) {
        this.email = new_email;
    }
    
    public String get_email () {
        return this.email;
    }
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jListVideos = new javax.swing.JList<>();
        jButtonMinimizar = new javax.swing.JButton();
        jButtonClose = new javax.swing.JButton();
        jButtonSelecionar = new javax.swing.JButton();
        jButtonVoltar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jListVideos.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = {};
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(jListVideos);

        jButtonMinimizar.setText("-");
        jButtonMinimizar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonMinimizarMouseClicked(evt);
            }
        });

        jButtonClose.setText("X");
        jButtonClose.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonCloseMouseClicked(evt);
            }
        });

        jButtonSelecionar.setText("Selecionar");
        jButtonSelecionar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonSelecionarMouseClicked(evt);
            }
        });

        jButtonVoltar.setText("Voltar");
        jButtonVoltar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonVoltarMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButtonMinimizar, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButtonClose, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jButtonVoltar)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 88, Short.MAX_VALUE)
                        .addComponent(jButtonSelecionar)
                        .addGap(33, 33, 33))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonMinimizar)
                    .addComponent(jButtonClose, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(45, 45, 45)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(102, 102, 102)
                        .addComponent(jButtonSelecionar)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 47, Short.MAX_VALUE)
                .addComponent(jButtonVoltar)
                .addGap(22, 22, 22))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonMinimizarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonMinimizarMouseClicked
        this.setState(JFrame.ICONIFIED);
    }//GEN-LAST:event_jButtonMinimizarMouseClicked

    private void jButtonCloseMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonCloseMouseClicked
        System.exit (0);
    }//GEN-LAST:event_jButtonCloseMouseClicked

    private void jButtonSelecionarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonSelecionarMouseClicked
        String name = this.jListVideos.getSelectedValue();
        int id = -2;
        String categoria = null;
        for (Video v : this.lista_videos) {
            if (name.equals(v.get_name())) {
                id = v.get_id();
                try {
                    categoria = this.categoria_video.devolve_categoria(email, v.get_id());
                } catch (SQLException e) {
                    e.printStackTrace();
                }

            }
        }
        
            MenuVideoForm log = new MenuVideoForm ();
            this.setVisible (false);
            log.set_email(email);
            log.set_id(id);
            log.set_videoLabel(name);
            log.set_categoriaLabel(categoria);
            log.update_Label();
            log.setVisible (true);
            log.setLocationRelativeTo (null);
            log.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
            System.out.println(id);
            this.dispose();

        
    }//GEN-LAST:event_jButtonSelecionarMouseClicked

    private void jButtonVoltarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonVoltarMouseClicked
        MainMenuUI menu = null;
        try {

            this.setVisible (false);
            try {
                menu = new MainMenuUI ();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
            menu.set_email(email);
            menu.setVisible(true);
            menu.setLocationRelativeTo(null);
            menu.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
            this.dispose();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }//GEN-LAST:event_jButtonVoltarMouseClicked

   
    public static void main(String args[]) {
        
     
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new VideoMainMenuUI().setVisible(true);
                } catch (ClassNotFoundException | SQLException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonClose;
    private javax.swing.JButton jButtonMinimizar;
    private javax.swing.JButton jButtonSelecionar;
    private javax.swing.JButton jButtonVoltar;
    private javax.swing.JList<String> jListVideos;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
