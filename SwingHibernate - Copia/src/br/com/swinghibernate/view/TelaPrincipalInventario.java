package br.com.swinghibernate.view;

import br.com.swinghibernate.config.HibernateUtil;
import static br.com.swinghibernate.config.HibernateUtil.getSessionFactory;
import static java.awt.EventQueue.invokeLater;
import java.awt.HeadlessException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import static java.lang.Math.atan2;
import static java.lang.Math.cos;
import static java.lang.Math.pow;
import static java.lang.Math.sin;
import static java.lang.Math.sqrt;
import static java.lang.System.exit;
import static java.lang.System.out;
import java.sql.Connection;
import java.util.HashMap;
import java.util.Scanner;
import java.util.logging.Logger;
import static java.util.logging.Logger.getLogger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.showMessageDialog;
import static javax.swing.JOptionPane.showMessageDialog;
import static javax.swing.JOptionPane.showMessageDialog;
import static javax.swing.UIManager.getInstalledLookAndFeels;
import static javax.swing.UIManager.setLookAndFeel;
import static javax.swing.UIManager.setLookAndFeel;
import static javax.swing.UIManager.setLookAndFeel;
import static javax.swing.UIManager.setLookAndFeel;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author renato
 */
public class TelaPrincipalInventario extends javax.swing.JFrame {

    private static final long serialVersionUID = 1L;
    private Connection Session ;

    /**
     * Creates new form TelaPrincipalInventario
     */
    public TelaPrincipalInventario() {
        initComponents();
        this.setExtendedState(this.getExtendedState() | MAXIMIZED_BOTH);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        ImportarDados = new javax.swing.JFileChooser();
        DesktopPanel = new javax.swing.JDesktopPane();
        menu = new javax.swing.JMenuBar();
        Inicio = new javax.swing.JMenu();
        Btn_ImportarDadosGPS = new javax.swing.JMenuItem();
        Btn_Sair = new javax.swing.JMenuItem();
        Cadastro = new javax.swing.JMenu();
        Btn_CadastroDAP = new javax.swing.JMenuItem();
        Consulta = new javax.swing.JMenu();
        RelatorioDAP = new javax.swing.JMenuItem();
        RelatorioGps = new javax.swing.JMenuItem();
        Sobre = new javax.swing.JMenu();

        ImportarDados.setDialogTitle("Selecione o arquivo");
        ImportarDados.setFileFilter(new MyCustomFilter());
        ImportarDados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ImportarDadosActionPerformed(evt);
            }
        });

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Inventario Florestal");
        getContentPane().setLayout(new javax.swing.OverlayLayout(getContentPane()));

        DesktopPanel.setBackground(javax.swing.UIManager.getDefaults().getColor("windowBorder"));
        DesktopPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        DesktopPanel.setForeground(java.awt.Color.lightGray);
        DesktopPanel.setDragMode(javax.swing.JDesktopPane.OUTLINE_DRAG_MODE);
        DesktopPanel.setPreferredSize(new java.awt.Dimension(1280, 730));
        DesktopPanel.setLayout(new java.awt.FlowLayout());
        getContentPane().add(DesktopPanel);

        Inicio.setLabel("Inicio");

        Btn_ImportarDadosGPS.setText("Importar Dados GPS");
        Btn_ImportarDadosGPS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_ImportarDadosGPSActionPerformed(evt);
            }
        });
        Inicio.add(Btn_ImportarDadosGPS);

        Btn_Sair.setText("Sair");
        Btn_Sair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_SairActionPerformed(evt);
            }
        });
        Inicio.add(Btn_Sair);

        menu.add(Inicio);

        Cadastro.setText("Cadastro Dados");

        Btn_CadastroDAP.setText("Cadastro DAP");
        Btn_CadastroDAP.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        Btn_CadastroDAP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_CadastroDAPActionPerformed(evt);
            }
        });
        Cadastro.add(Btn_CadastroDAP);

        menu.add(Cadastro);

        Consulta.setText("Relatorios");
        Consulta.setActionCommand("Consulta");

        RelatorioDAP.setText("DAP");
        RelatorioDAP.setSelected(true);
        RelatorioDAP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RelatorioDAPActionPerformed(evt);
            }
        });
        Consulta.add(RelatorioDAP);

        RelatorioGps.setText("GPS");
        RelatorioGps.setSelected(true);
        RelatorioGps.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RelatorioGpsActionPerformed(evt);
            }
        });
        Consulta.add(RelatorioGps);

        menu.add(Consulta);

        Sobre.setText("Sobre");
        Sobre.setToolTipText("");
        Sobre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SobreActionPerformed(evt);
            }
        });
        menu.add(Sobre);

        setJMenuBar(menu);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void RelatorioDAPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RelatorioDAPActionPerformed
        try {
            JasperReport pathRxml = JasperCompileManager.compileReport("C:\\Users\\renato\\Documents\\NetBeansProjects\\SwingHibernate - Copia\\src\\br\\com\\swinghibernate\\Relatorio\\RelatorioDAP.jrxml");
            JasperPrint printReport = JasperFillManager.fillReport(pathRxml, new HashMap(),Session);
            JasperViewer.viewReport(printReport);
        } catch (JRException ex) {
            ex.getMessage();
        }
    }//GEN-LAST:event_RelatorioDAPActionPerformed

    /**
     *
     */
    public class MyCustomFilter extends javax.swing.filechooser.FileFilter {

        /**
         *
         * @param file
         * @return
         */
        @Override
        public boolean accept(File file) {
            return file.isDirectory() || file.getAbsolutePath().endsWith(".txt");
        }

        /**
         *
         * @return
         */
        @Override
        public String getDescription() {
            return "Text documents (*.txt)";
        }
    }

    private void Btn_ImportarDadosGPSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_ImportarDadosGPSActionPerformed
        new CadastroDAP().setEnabled(false);
        RelatorioDAP.setEnabled(false);
        ImportarDadosActionPerformed(evt);

        Session session = getSessionFactory().openSession();
        Transaction transaction = null;
        ImportarDadosActionPerformed(evt);
        JFileChooser chooser = new JFileChooser();
        chooser.setFileSelectionMode(0);
        int returnVal = ImportarDados.showOpenDialog(this);
        if (returnVal == 0) {
            File file = ImportarDados.getSelectedFile();
            try {
                transaction = session.beginTransaction();
                Double convertLat = ConversaoUtmLatitude();
                Double convertlong = ConversaoUtmLongitude();
                String cidade;
                try {
                    for (Scanner scanner = (new Scanner(new FileReader(file))).useDelimiter(",\n");
                            scanner.hasNextByte();
                            showMessageDialog(null, "cidade", cidade, 1)) {
                        String nome = scanner.next();
                        cidade = scanner.next();
                        String compras = scanner.next();
                        String nomd = scanner.next();
                        String cidae = scanner.next();
                        String compas = scanner.next();
                        out.println(nome);
                        out.println(cidade);
                        out.println(compras);
                        showMessageDialog(null, "nome", nome, 1);
                    }
                } catch (FileNotFoundException ex) {
                    ex.getMessage();
                }
                session.save("");
                transaction.commit();
                showMessageDialog(null, "Inserido com sucesso", "SIM", 1);
            } catch (HeadlessException ex) {
                ex.getMessage();
            } catch (HibernateException ex) {
                transaction.rollback();
                ex.getMessage();
                ex.getMessage();
            } finally {
                session.close();
            }
        } else {
            showMessageDialog(null, "Arquivo cancelado pelo usuario");
        }
        showMessageDialog(null, "Inserido com sucesso!");

    }//GEN-LAST:event_Btn_ImportarDadosGPSActionPerformed

    private void Btn_SairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_SairActionPerformed
        exit(0);
        dispose();
    }//GEN-LAST:event_Btn_SairActionPerformed

    /**
     *
     * @return
     */
    public double ConversaoUtmLatitude() {
        double latitud = 289121.465;
        int graus;
        int minutos;
        double segundos;
        graus = (int) latitud / 100;
        minutos = ((int) latitud % 100) / 60;
        segundos = (latitud - latitud) / 36.0;

        double ConversLatitud = graus + minutos + segundos;

        return ConversLatitud;
    }

    /**
     *
     * @return
     */
    public double ConversaoUtmLongitude() {
        double longitud = 289121.465;
        int graus;
        int minutos;
        double segundos;
        graus = (int) longitud / 100;
        minutos = ((int) longitud % 100) / 60;
        segundos = (longitud - longitud) / 36.0;

        double Converslongitud = graus + minutos + segundos;
        return Converslongitud;
    }

    public double getDistancia(double latitude, double longitude, double latitudePto, double longitudePto) {
        double dlon, dlat, a, distancia;
        dlon = longitudePto - longitude;
        dlat = latitudePto - latitude;
        a = pow(sin(dlat / 2), 2) + cos(latitude) * cos(latitudePto) * pow(sin(dlon / 2), 2);
        distancia = 2 * atan2(sqrt(a), sqrt(1 - a));
        return 6378140 * distancia; /* 6378140 is the radius of the Earth in meters*/

    }

    private void Btn_CadastroDAPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_CadastroDAPActionPerformed
        CadastroDAP cad = new CadastroDAP();
        DesktopPanel.add(cad);
        cad.setEnabled(true);
        setLocationRelativeTo(DesktopPanel);
    }//GEN-LAST:event_Btn_CadastroDAPActionPerformed

    private void SobreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SobreActionPerformed
        DesktopPanel.add(menu);
        JOptionPane.showMessageDialog(null, "Sistema de inventario Florestal /n "
                + "Desenvolvido por renato balin");
    }//GEN-LAST:event_SobreActionPerformed

    private void ImportarDadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ImportarDadosActionPerformed
        Btn_ImportarDadosGPS.getAction();
    }//GEN-LAST:event_ImportarDadosActionPerformed

    private void RelatorioGpsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RelatorioGpsActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_RelatorioGpsActionPerformed

    /**
     *
     * @param args
     */
    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            ex.getMessage();
        } catch (InstantiationException ex) {
            ex.getMessage();
        } catch (IllegalAccessException ex) {
            ex.getMessage();
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            ex.getMessage();
        }


        /* Create and display the form */
        invokeLater(new Runnable() {
            @Override
            public void run() {
                new TelaPrincipalInventario().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem Btn_CadastroDAP;
    private javax.swing.JMenuItem Btn_ImportarDadosGPS;
    private javax.swing.JMenuItem Btn_Sair;
    private javax.swing.JMenu Cadastro;
    private javax.swing.JMenu Consulta;
    private javax.swing.JDesktopPane DesktopPanel;
    private javax.swing.JFileChooser ImportarDados;
    private javax.swing.JMenu Inicio;
    private javax.swing.JMenuItem RelatorioDAP;
    private javax.swing.JMenuItem RelatorioGps;
    private javax.swing.JMenu Sobre;
    private javax.swing.JMenuBar menu;
    // End of variables declaration//GEN-END:variables
    private static final Logger LOG = getLogger(TelaPrincipalInventario.class.getName());
}
