package br.com.swinghibernate.view;

import static br.com.swinghibernate.config.HibernateUtil.getSessionFactory;
import br.com.swinghibernate.entity.DadosDap;
import java.awt.HeadlessException;
import static java.lang.Float.valueOf;
import static java.lang.Math.PI;
import static java.lang.Math.pow;
import static java.lang.Math.sqrt;
import static java.lang.String.valueOf;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import static java.util.logging.Logger.getLogger;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.showMessageDialog;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.AbstractDocument;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author renato
 */
public class CadastroDAP extends javax.swing.JInternalFrame {

    private static final long serialVersionUID = 1L;

    /**
     *
     */
    public CadastroDAP() {
        initComponents();
        ((AbstractDocument) DiametroArvore.getDocument()).setDocumentFilter(new RandonValidador(5, true, false, false, false, new char[]{','}));
        ((AbstractDocument) AlturaArvore.getDocument()).setDocumentFilter(new RandonValidador(5, true, false, false, false, new char[]{','}));
        Btn_Salvar.setEnabled(false);
        Btn_Deletar.setEnabled(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        DiametroArvore = new javax.swing.JFormattedTextField();
        AlturaArvore = new javax.swing.JFormattedTextField();
        Btn_Inserir = new javax.swing.JButton();
        Btn_Salvar = new javax.swing.JButton();
        Btn_Deletar = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTableDAP = new javax.swing.JTable();

        setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        setClosable(true);
        setForeground(java.awt.Color.lightGray);
        setTitle("Cadastro DAP");
        setDoubleBuffered(true);
        setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        setName("CadastroDAP"); // NOI18N
        setNormalBounds(new java.awt.Rectangle(10, 10, 52, 0));
        try {
            setSelected(true);
        } catch (java.beans.PropertyVetoException e1) {
            e1.printStackTrace();
        }
        setVisible(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("Diametro(cm)");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(14, 16, 80, 20));

        jLabel2.setText("Altura(m)");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 66, 20));

        DiametroArvore.setEnabled(false);
        getContentPane().add(DiametroArvore, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 20, 110, -1));

        AlturaArvore.setEnabled(false);
        getContentPane().add(AlturaArvore, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 50, 110, -1));

        Btn_Inserir.setText("Novo");
        Btn_Inserir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_InserirActionPerformed(evt);
            }
        });
        getContentPane().add(Btn_Inserir, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, -1, -1));

        Btn_Salvar.setText("Gravar");
        Btn_Salvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_SalvarActionPerformed(evt);
            }
        });
        getContentPane().add(Btn_Salvar, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 100, -1, -1));

        Btn_Deletar.setText("Deletar");
        Btn_Deletar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_DeletarActionPerformed(evt);
            }
        });
        getContentPane().add(Btn_Deletar, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 100, -1, -1));

        jTableDAP.setAutoCreateRowSorter(true);
        jTableDAP.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Diametro", "Altura", "calg", "calX", "calY"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableDAP.setToolTipText("");
        jTableDAP.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_NEXT_COLUMN);
        jTableDAP.setDebugGraphicsOptions(javax.swing.DebugGraphics.BUFFERED_OPTION);
        jTableDAP.setDoubleBuffered(true);
        jTableDAP.setDragEnabled(true);
        jTableDAP.setEditingColumn(1);
        jTableDAP.setEditingRow(1);
        jTableDAP.setFocusCycleRoot(true);
        jTableDAP.setFocusTraversalPolicyProvider(true);
        jTableDAP.setInheritsPopupMenu(true);
        jTableDAP.setName(""); // NOI18N
        jTableDAP.setSurrendersFocusOnKeystroke(true);
        jScrollPane2.setViewportView(jTableDAP);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 150, 730, 210));

        setBounds(50, 50, 736, 392);
    }// </editor-fold>//GEN-END:initComponents

    private void Btn_InserirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_InserirActionPerformed
        DiametroArvore.setEnabled(true);
        AlturaArvore.setEnabled(true);
        Btn_Salvar.setEnabled(true);
        Btn_Deletar.setEnabled(false);
    }//GEN-LAST:event_Btn_InserirActionPerformed


    private void Btn_SalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_SalvarActionPerformed
        if (DiametroArvore.getText().isEmpty() || AlturaArvore.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Valor Digitado é invalido");
            DiametroArvore.requestFocus();
        } else {
            Session session = getSessionFactory().openSession();
            Transaction transaction = null;
            try {
                transaction = session.beginTransaction();

                String diamd = DiametroArvore.getText();
                diamd = diamd.replaceAll(",", ".");
                Float Diametro = valueOf(diamd);

                String altr = AlturaArvore.getText();
                altr = altr.replaceAll(",", ".");
                Float Altura = valueOf(altr);

                float calcx = CalculaX();
                float calcy = CalculaY();
                float calcgm = calculaGcm();
                String dia = valueOf(Diametro);
                String alt = valueOf(Altura);
                String calx = String.valueOf(calcx);
                String caly = String.valueOf(calcy);
                String calg = String.valueOf(calcgm);

                DefaultTableModel val = (DefaultTableModel) jTableDAP.getModel();
                val.addRow(new String[]{dia, alt, calx, caly, calg});

                DadosDap cad = new DadosDap();
                cad.setDiametro(Diametro);
                cad.setAltura(Altura);
                cad.setCalX(calcx);
                cad.setCalY(calcy);
                cad.setCalG(calcgm);

                session.save(cad);
                transaction.commit();
                showMessageDialog(null, "Inserido com sucesso", " ", 1);
                Btn_Deletar.setEnabled(true);
            } catch (HeadlessException ex) {
                ex.getMessage();
            } catch (HibernateException ex) {
                transaction.rollback();
                ex.getMessage();
            } finally {
                session.close();
            }
        }
        DiametroArvore.setEnabled(false);
        AlturaArvore.setEnabled(false);
        Btn_Salvar.setEnabled(false);
        DiametroArvore.setText("");
        AlturaArvore.setText("");
        DiametroArvore.requestFocus();
    }//GEN-LAST:event_Btn_SalvarActionPerformed

    /**
     *
     * @return
     */
    public float calculaGcm() {
        String diam = DiametroArvore.getText();
        diam = diam.replaceAll(",", ".");
        Float Diametro = valueOf(diam);
        float CalcGcm = (float) ((pow(Diametro / 100, 2D) * PI) / 4D);
        return CalcGcm;
    }

    /**
     *
     * @return
     */
    public float CalculaX() {
        String diam = DiametroArvore.getText();
        diam = diam.replaceAll(",", ".");
        Float Diametro = valueOf(diam);
        float CalcX = 1 / Diametro;
        return CalcX;
    }

    /**
     *
     * @return
     */
    public float CalculaY() {
        String alt = AlturaArvore.getText();
        alt = alt.replaceAll(",", ".");
        Float Diametro = valueOf(alt);
        float CalcY = (float) (1.0D / sqrt(Diametro - 1.3D));
        return CalcY;
    }

    private void Btn_DeletarActionPerformed(java.awt.event.ActionEvent evt) {

        int linha = jTableDAP.getSelectedRow();

        Session session = getSessionFactory().openSession();
        Transaction transaction = null;

        if (jTableDAP.getSelectedRow() == -1) {
            showMessageDialog(jTableDAP, "Selecione um registro para excluir!",
                    "Excluir registro", JOptionPane.WARNING_MESSAGE);
        }

        try {
            int[] selected = jTableDAP.getSelectedRows();
            int se = jTableDAP.getSelectedRow();
            List<br.com.swinghibernate.view.Dadosdap> RemoverLinha = new ArrayList<br.com.swinghibernate.view.Dadosdap>(selected.length);
            for (int idx = 0; idx < selected.length; idx++) {
                // Dadosdap dados = RemoverLinha.get(jTableDAP.convertRowIndexToModel(selected[idx]));
                Dadosdap dados = RemoverLinha.get(idx);

                transaction = session.beginTransaction();
                DadosDap cad = new DadosDap();
                cad.setIdDAP(dados.getIddap());
                cad.setAltura(dados.getAltura());
                cad.setCalG(dados.getCalg());
                cad.setCalX(dados.getCalx());
                cad.setCalY(dados.getCaly());

                session.delete(cad);
                transaction.commit();
                showMessageDialog(null, "Deletado com sucesso", " ", 1);
            }
        } catch (HeadlessException ex) {
            ex.getMessage();
        } catch (HibernateException ex) {
            transaction.rollback();
            ex.getMessage();
        } finally {
            session.close();
        }
        ((DefaultTableModel) jTableDAP.getModel()).removeRow(jTableDAP.getSelectedRow());
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JFormattedTextField AlturaArvore;
    private javax.swing.JButton Btn_Deletar;
    private javax.swing.JButton Btn_Inserir;
    private javax.swing.JButton Btn_Salvar;
    private javax.swing.JFormattedTextField DiametroArvore;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTableDAP;
    // End of variables declaration//GEN-END:variables
    private static final Logger LOG = getLogger(CadastroDAP.class.getName());
}
