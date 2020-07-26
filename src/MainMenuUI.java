
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JFrame;

public class MainMenuUI extends javax.swing.JFrame {

    
    private String email;
    private ArrayList <Music> lista_musicas ;
    private ArrayList <Video> lista_videos;
    private MusicDAO musica;
    private UserMusicDAO musicas;
    private UserVideoDAO videos;
    private VideoDAO video;
    
    
    public MainMenuUI () throws SQLException, ClassNotFoundException {
        initComponents();
        this.musica = new MusicDAO ();
        this.musicas = new UserMusicDAO ();
        this.video = new VideoDAO ();
        this.videos = new UserVideoDAO ();
        this.lista_musicas = null;
        this.lista_videos = null;
        
    }
    
    
    public void set_email (String new_email) {
        this.email = new_email;
    }
    
    public void preenche_lista () throws SQLException {
        ArrayList <Integer> lista_ids = musicas.devolveMusica(this.email);
        this.lista_musicas = musica.devolveMusicas(lista_ids);
    }
    
    public void preenche_listaVideos () throws SQLException {
        ArrayList <Integer> lista_ids = videos.devolveVideo(this.email);
        this.lista_videos = video.devolveVideos(lista_ids);
    }
    
    
    
    
    
    public String get_email () {
        return this.email;
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jButtonMinimizar1 = new javax.swing.JButton();
        jButtonClose = new javax.swing.JButton();
        jPanelMusica = new javax.swing.JPanel();
        jButtonMusica = new javax.swing.JButton();
        jPanelVideo = new javax.swing.JPanel();
        jButtonVideo = new javax.swing.JButton();
        jPanelUpload = new javax.swing.JPanel();
        jButtonUpload = new javax.swing.JButton();
        jButtonLogOut = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jButtonMinimizar1.setText("-");
        jButtonMinimizar1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonMinimizar1MouseClicked(evt);
            }
        });
        jButtonMinimizar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonMinimizar1ActionPerformed(evt);
            }
        });

        jButtonClose.setText("X");
        jButtonClose.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonCloseMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButtonMinimizar1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonClose))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonClose)
                    .addComponent(jButtonMinimizar1))
                .addGap(0, 11, Short.MAX_VALUE))
        );

        jButtonMusica.setText("Musica");
        jButtonMusica.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonMusicaMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanelMusicaLayout = new javax.swing.GroupLayout(jPanelMusica);
        jPanelMusica.setLayout(jPanelMusicaLayout);
        jPanelMusicaLayout.setHorizontalGroup(
            jPanelMusicaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelMusicaLayout.createSequentialGroup()
                .addGap(0, 27, Short.MAX_VALUE)
                .addComponent(jButtonMusica))
        );
        jPanelMusicaLayout.setVerticalGroup(
            jPanelMusicaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelMusicaLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jButtonMusica)
                .addContainerGap(51, Short.MAX_VALUE))
        );

        jButtonVideo.setText("Video");
        jButtonVideo.setMaximumSize(new java.awt.Dimension(88, 29));
        jButtonVideo.setMinimumSize(new java.awt.Dimension(88, 29));
        jButtonVideo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonVideoMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanelVideoLayout = new javax.swing.GroupLayout(jPanelVideo);
        jPanelVideo.setLayout(jPanelVideoLayout);
        jPanelVideoLayout.setHorizontalGroup(
            jPanelVideoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelVideoLayout.createSequentialGroup()
                .addGap(0, 39, Short.MAX_VALUE)
                .addComponent(jButtonVideo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanelVideoLayout.setVerticalGroup(
            jPanelVideoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelVideoLayout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jButtonVideo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jButtonUpload.setText("Upload");
        jButtonUpload.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonUploadMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanelUploadLayout = new javax.swing.GroupLayout(jPanelUpload);
        jPanelUpload.setLayout(jPanelUploadLayout);
        jPanelUploadLayout.setHorizontalGroup(
            jPanelUploadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelUploadLayout.createSequentialGroup()
                .addContainerGap(35, Short.MAX_VALUE)
                .addComponent(jButtonUpload)
                .addGap(26, 26, 26))
        );
        jPanelUploadLayout.setVerticalGroup(
            jPanelUploadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelUploadLayout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jButtonUpload)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jButtonLogOut.setText("Log Out");
        jButtonLogOut.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonLogOutMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButtonLogOut)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanelMusica, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanelVideo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanelUpload, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanelMusica, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanelVideo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanelUpload, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 58, Short.MAX_VALUE)
                .addComponent(jButtonLogOut)
                .addGap(21, 21, 21))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonLogOutMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonLogOutMouseClicked
        this.setVisible(false);
        LogOutUI log_out = new LogOutUI ();
        log_out.setVisible(true);
        log_out.pack();
        log_out.setLocationRelativeTo(null);
        log_out.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.dispose();
    }//GEN-LAST:event_jButtonLogOutMouseClicked

    private void jButtonUploadMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonUploadMouseClicked
        this.setVisible (false);
     
        
        UploadMenuUI log = new UploadMenuUI ();
        log.setVisible (true);
        log.setLocationRelativeTo (null);
        log.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        log.set_email(this.email);
        this.dispose ();
        
        
    }//GEN-LAST:event_jButtonUploadMouseClicked

    private void jButtonVideoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonVideoMouseClicked
        this.setVisible (false);
        VideoMainMenuUI menu = null;
        try {
            this.preenche_listaVideos ();
            menu = new VideoMainMenuUI ();
            menu.set_email(this.email);
            menu.preenche_lista();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        
        
        for (Video v: this.lista_videos) {
            menu.add_model(v.get_name());
           
        }
        
        
        menu.setVisible (true);
        menu.pack();
        menu.setLocationRelativeTo(null);
        menu.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
        this.dispose ();
    }//GEN-LAST:event_jButtonVideoMouseClicked

    private void jButtonMusicaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonMusicaMouseClicked
        this.setVisible (false);
        MusicaMainMenuUI menu = null;
        try {
            this.preenche_lista ();
            menu = new MusicaMainMenuUI ();
            menu.set_email(this.email);
            menu.preenche_lista();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        
        
        for (Music m: this.lista_musicas) {
            menu.add_model(m.get_name());
           
        }
        
        
        menu.setVisible (true);
        menu.pack();
        menu.setLocationRelativeTo(null);
        menu.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
        this.dispose ();
       
    }//GEN-LAST:event_jButtonMusicaMouseClicked

    private void jButtonMinimizar1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonMinimizar1MouseClicked
        this.setState(JFrame.ICONIFIED);
    }//GEN-LAST:event_jButtonMinimizar1MouseClicked

    private void jButtonCloseMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonCloseMouseClicked
        System.exit(0);
    }//GEN-LAST:event_jButtonCloseMouseClicked

    private void jButtonMinimizar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonMinimizar1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonMinimizar1ActionPerformed

   
    public static void main(String args[]) {
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new MainMenuUI().setVisible(true);
                } catch (ClassNotFoundException | SQLException e) {
                     e.printStackTrace();
                }
                   
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonClose;
    private javax.swing.JButton jButtonLogOut;
    private javax.swing.JButton jButtonMinimizar1;
    private javax.swing.JButton jButtonMusica;
    private javax.swing.JButton jButtonUpload;
    private javax.swing.JButton jButtonVideo;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanelMusica;
    private javax.swing.JPanel jPanelUpload;
    private javax.swing.JPanel jPanelVideo;
    // End of variables declaration//GEN-END:variables
}
