/* 
 * Copyright (c) 2015 Sebastian Brudzinski
 * 
 * See the file LICENSE for copying permission.
 */
package latexstudio.editor;

import java.awt.Color;
import java.awt.Point;
import javax.swing.JPanel;
import javax.swing.JViewport;
import latexstudio.editor.pdf.PDFDisplay;
import latexstudio.editor.pdf.PDFPreviewRefresher;
import latexstudio.editor.pdf.PDFService;
import org.netbeans.api.settings.ConvertAsProperties;
import org.openide.awt.ActionID;
import org.openide.awt.ActionReference;
import org.openide.util.NbBundle.Messages;
import org.openide.windows.TopComponent;

/**
 * Top component which displays something.
 */
@ConvertAsProperties(
        dtd = "-//latexstudio.editor//PDFViewer//EN",
        autostore = false
)
@TopComponent.Description(
        preferredID = "PDFViewerTopComponent",
        //iconBase="SET/PATH/TO/ICON/HERE", 
        persistenceType = TopComponent.PERSISTENCE_ALWAYS
)
@TopComponent.Registration(mode = "rightSlidingSide", openAtStartup = true)
@ActionID(category = "Window", id = "latexstudio.editor.PDFViewerTopComponent")
@ActionReference(path = "Menu/Window" /*, position = 333 */)
@TopComponent.OpenActionRegistration(
        displayName = "#CTL_PDFViewerAction",
        preferredID = "PDFViewerTopComponent"
)
@Messages({
    "CTL_PDFViewerAction=PDF Preview",
    "CTL_PDFViewerTopComponent=PDF Preview",
    "HINT_PDFViewerTopComponent=This is a window that displays the preview"
})
public final class PDFViewerTopComponent extends TopComponent {
    
    private static final int DEFAULT_ZOOM = 100;
    private static final int MIN_ZOOM = 25;
    private static final int MAX_ZOOM = 400;
    private static final int SPINNER_ZOOM_SIZE = 25;
    
    private final EditorTopComponent etc = new TopComponentFactory<EditorTopComponent>()
            .getTopComponent(EditorTopComponent.class.getSimpleName());

    public PDFViewerTopComponent() {
        initComponents();
        setName(Bundle.CTL_PDFViewerTopComponent());
        setToolTipText(Bundle.HINT_PDFViewerTopComponent());
        pdfDisplay = new PDFDisplay();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTextField1 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jSpinnerZoom = new javax.swing.JSpinner();
        jLabel1 = new javax.swing.JLabel();

        jScrollPane1.addMouseWheelListener(new java.awt.event.MouseWheelListener() {
            public void mouseWheelMoved(java.awt.event.MouseWheelEvent evt) {
                jScrollPane1MouseWheelMoved(evt);
            }
        });

        jTextField1.setText(org.openide.util.NbBundle.getMessage(PDFViewerTopComponent.class, "PDFViewerTopComponent.jTextField1.text")); // NOI18N
        jTextField1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField1KeyReleased(evt);
            }
        });

        org.openide.awt.Mnemonics.setLocalizedText(jLabel2, org.openide.util.NbBundle.getMessage(PDFViewerTopComponent.class, "PDFViewerTopComponent.jLabel2.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(jButton1, org.openide.util.NbBundle.getMessage(PDFViewerTopComponent.class, "PDFViewerTopComponent.jButton1.text")); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        org.openide.awt.Mnemonics.setLocalizedText(jButton2, org.openide.util.NbBundle.getMessage(PDFViewerTopComponent.class, "PDFViewerTopComponent.jButton2.text")); // NOI18N
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jSpinnerZoom.setModel(new javax.swing.SpinnerNumberModel(DEFAULT_ZOOM, MIN_ZOOM, MAX_ZOOM, SPINNER_ZOOM_SIZE));
        jSpinnerZoom.setName("jSpinnerZoom"); // NOI18N
        jSpinnerZoom.addMouseWheelListener(new java.awt.event.MouseWheelListener() {
            public void mouseWheelMoved(java.awt.event.MouseWheelEvent evt) {
                jSpinnerZoomMouseWheelMoved(evt);
            }
        });
        jSpinnerZoom.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jSpinnerZoomStateChanged(evt);
            }
        });

        org.openide.awt.Mnemonics.setLocalizedText(jLabel1, org.openide.util.NbBundle.getMessage(PDFViewerTopComponent.class, "PDFViewerTopComponent.jLabelZoom.text")); // NOI18N
        jLabel1.setName("jLabelZoom"); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 54, Short.MAX_VALUE)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSpinnerZoom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jSpinnerZoom)
                        .addComponent(jLabel1))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel2))
                    .addComponent(jButton1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 259, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        pdfDisplay.nextPage();
        refreshDisplayPane();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        pdfDisplay.previousPage();
        refreshDisplayPane();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTextField1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1KeyReleased
        try {
            int selectedPage = Integer.parseInt(jTextField1.getText());
            jTextField1.setBackground(Color.WHITE);
            pdfDisplay.setPage(selectedPage);
            refreshDisplayPane();
        } catch (NumberFormatException e) {
            jTextField1.setBackground(Color.PINK);
        }
    }//GEN-LAST:event_jTextField1KeyReleased

    /**
     * Adjust the value in the jSpinnerZoom by an external means, 
     * usually mouse wheel, either over the spinner, or with ctrl in the 
     * jPanel
     * @param zoomDelta amount to adjust the value.
     */
 
   private void externalZoomBy(int zoomDelta) {
            int zoom = (Integer)jSpinnerZoom.getValue();
            zoom += zoomDelta;
            if (zoom < MIN_ZOOM ) { 
                zoom = MIN_ZOOM;
            }
            if (zoom > MAX_ZOOM) {
                zoom = MAX_ZOOM;
            }
            jSpinnerZoom.setValue (zoom);  // triggers jSpinnerZoomStateChanged
            
    }


    
    private void jSpinnerZoomStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jSpinnerZoomStateChanged
       try {
            int zoom = (Integer)jSpinnerZoom.getValue();
            jSpinnerZoom.setBackground(Color.WHITE);
            pdfDisplay.setZoom(zoom);
            refreshDisplayPane();
        } catch (ClassCastException e) {
            jSpinnerZoom.setBackground(Color.PINK);
        }
    }//GEN-LAST:event_jSpinnerZoomStateChanged

    private void jSpinnerZoomMouseWheelMoved(java.awt.event.MouseWheelEvent evt) {//GEN-FIRST:event_jSpinnerZoomMouseWheelMoved
        
        try {
            int r = evt.getWheelRotation();
            r = r * SPINNER_ZOOM_SIZE * -1;
            externalZoomBy(r);
       } catch (ClassCastException e) {
            jSpinnerZoom.setBackground(Color.PINK);
        }

        
    }//GEN-LAST:event_jSpinnerZoomMouseWheelMoved

    private void jScrollPane1MouseWheelMoved(java.awt.event.MouseWheelEvent evt) {//GEN-FIRST:event_jScrollPane1MouseWheelMoved
        // if ccontrol is down then do a zoom event 
        if (evt.isControlDown()) {
            try {
                int r = evt.getWheelRotation();
                r = r * SPINNER_ZOOM_SIZE * -1;
                externalZoomBy(r);
            } catch (ClassCastException e) {
                jSpinnerZoom.setBackground(Color.PINK);
            }
        }
    }//GEN-LAST:event_jScrollPane1MouseWheelMoved

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSpinner jSpinnerZoom;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
    
    private PDFDisplay pdfDisplay;
    
    @Override
    public void componentOpened() {       
        Thread refresher = new Thread(new PDFPreviewRefresher(jScrollPane1, jLabel2, etc, pdfDisplay));
        refresher.start();
    }

    @Override
    public void componentClosed() {
        PDFService.closeDocument();
    }
    
    private void refreshDisplayPane() {
        JPanel pdfImagePanel = pdfDisplay.drawPreviewOnJPanel();
       
        if (pdfImagePanel != null) {
            JViewport vp = jScrollPane1.getViewport();
            Point p = vp.getViewPosition();
            vp.setView(pdfImagePanel);
            vp.setViewPosition(p);
        }
        
        jTextField1.setText(String.valueOf(pdfDisplay.getSelectedPage()));
        jLabel2.setText("of "+pdfDisplay.getTotalPages());
    }

    void writeProperties(java.util.Properties p) {
        // better to version settings since initial version as advocated at
        // http://wiki.apidesign.org/wiki/PropertyFiles
        p.setProperty("version", "1.0");
        // TODO store your settings
    }

    void readProperties(java.util.Properties p) {
        String version = p.getProperty("version");
        // TODO read your settings according to their version
    }
}
