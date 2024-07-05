package Gui;

import Classes.Hospede;
import Classes.Quarto;
import Classes.Reserva;
import File.FilePersistence;
import Gerenciadores.GerenciadorReserva;
import Serializadores.SerializadorHospede;
import Serializadores.SerializadorQuarto;
import Serializadores.SerializadorReserva;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CadReserva extends javax.swing.JDialog {

    /**
     * Creates new form CadReserva
     */
    FilePersistence file;
    SerializadorHospede serializadorHospede;
    SerializadorQuarto serializadorQuarto;
    GerenciadorReserva gerente;
    public CadReserva(java.awt.Frame parent, boolean modal) throws FileNotFoundException {
        super(parent, modal);
        initComponents();
        file = new FilePersistence();
        serializadorQuarto = new SerializadorQuarto();
        serializadorHospede = new SerializadorHospede();
        exibirReservas.setEditable(false);
        gerente = buscarGerente();
    }
    public GerenciadorReserva buscarGerente() throws FileNotFoundException{
        FilePersistence file = new FilePersistence();
        String arquivoLidoReservas = file.loadFromFile("Reservas.txt");
        SerializadorReserva serializador = new SerializadorReserva();
        List<Reserva> reservas = serializador.fromCSV(arquivoLidoReservas);
        GerenciadorReserva gerente = new GerenciadorReserva();
        gerente.setReservas(reservas);
        return gerente;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        edtIdentidadeHospede = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        edtNumeroQuarto = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        edtCheckin = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        edtCheckout = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        exibirReservas = new javax.swing.JTextArea();
        btnConfirmarReserva = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setLayout(new javax.swing.BoxLayout(jPanel1, javax.swing.BoxLayout.LINE_AXIS));

        jLabel1.setText("Identidade:");
        jPanel1.add(jLabel1);
        jPanel1.add(edtIdentidadeHospede);

        jLabel2.setText("Numero do quarto:");
        jPanel1.add(jLabel2);
        jPanel1.add(edtNumeroQuarto);

        jLabel3.setText("Checkin:");
        jPanel1.add(jLabel3);
        jPanel1.add(edtCheckin);

        jLabel4.setText("Checkout:");
        jPanel1.add(jLabel4);
        jPanel1.add(edtCheckout);

        exibirReservas.setColumns(20);
        exibirReservas.setRows(5);
        jScrollPane1.setViewportView(exibirReservas);

        btnConfirmarReserva.setText("Confirmar");
        btnConfirmarReserva.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConfirmarReservaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(0, 1001, Short.MAX_VALUE)
                                .addComponent(btnConfirmarReserva)))
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 555, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(btnConfirmarReserva)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnConfirmarReservaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConfirmarReservaActionPerformed
        // TODO add your handling code here:

        try {
            String HospedesCSV = file.loadFromFile("Hospedes.txt");
            String QuartosCSV = file.loadFromFile("Quartos.txt");
           
            List<Hospede> arrayHospede = serializadorHospede.fromCSV(HospedesCSV);
            List<Quarto> arrayQuarto = serializadorQuarto.fromCSV(QuartosCSV);
            
            boolean estaRegistradoQuarto = estaRegistradoQuarto(arrayQuarto);
            boolean estaRegistradoHospede = estaRegistradoHospede(arrayHospede);
            
            if(estaRegistradoHospede && estaRegistradoQuarto){
                adicionarReserva();
            }

        } catch (FileNotFoundException ex) {
            Logger.getLogger(CadReserva.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(CadReserva.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    }//GEN-LAST:event_btnConfirmarReservaActionPerformed
    private boolean estaRegistradoHospede(List<Hospede> hospedes){
        String CPF = edtIdentidadeHospede.getText();
        
        boolean existe = false;
        for(Hospede hospede : hospedes){
            if(hospede.getDocumentoIdentidade().equals(CPF));
            existe = true;
        }
        return existe;
    }
    private boolean  estaRegistradoQuarto(List<Quarto> quartos){
        String numeroQuarto = edtNumeroQuarto.getText();
        boolean existe = false;
        for(Quarto quarto : quartos){
            if(quarto.getNumeroQuarto().equals(numeroQuarto));
            existe = true;
        }
        return existe;
    }
    private Reserva campoPraObjeto(){
        Reserva novaReserva = new Reserva();
        novaReserva.setNumIdentidade(edtIdentidadeHospede.getText());
        novaReserva.setNumeroQuarto(edtNumeroQuarto.getText());
        novaReserva.setChekinData(edtCheckin.getText());
        novaReserva.setChekoutData(edtCheckout.getText());
        return novaReserva;
    }
    private void adicionarReserva() throws IOException{
        Reserva novaReserva = campoPraObjeto();
        gerente.addReserva(novaReserva);
        System.out.println("AAAAAAAAAAAAAAAAAAAAAAAAAAAA");
        
        String listagem = "";
        List<Reserva> reservas = gerente.getReservas();
        for(Reserva reserva : reservas){
            listagem = listagem + reserva.toString() +"\n";
        }
        exibirReservas.setText(listagem);
        atualizarReservasNoArquivo(reservas);
        }
     
     private void atualizarReservasNoArquivo(List<Reserva> reservas) throws IOException{
         SerializadorReserva serializador = new SerializadorReserva();
         System.out.println(reservas);
        String  listaAtualizadaCSV = serializador.toCSV(reservas);
        FilePersistence atualizarReserva = new FilePersistence();
        atualizarReserva.saveToFile(listaAtualizadaCSV, "Reservas.txt");
     }
    /**
     * @param args the command line arguments
     */
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnConfirmarReserva;
    private javax.swing.JTextField edtCheckin;
    private javax.swing.JTextField edtCheckout;
    private javax.swing.JTextField edtIdentidadeHospede;
    private javax.swing.JTextField edtNumeroQuarto;
    private javax.swing.JTextArea exibirReservas;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}