package JFrame;

import JDialog.JDAluno;
import JDialog.JDDisciplina;
import JDialog.JDProfessor;
import TableModel.TMAluno;
import TableModel.TMDisciplina;
import TableModel.TMProfessor;
import classes.Aluno;
import classes.Disciplina;
import classes.Professor;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import gerente.GerenteAluno;
import gerente.GerenteDisciplina;
import gerente.GerenteProfessor;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

public class JFtelainicial extends javax.swing.JFrame {
    
    private GerenteAluno alunos = new GerenteAluno();
    private GerenteProfessor professor = new GerenteProfessor();
    private GerenteDisciplina disciplina = new GerenteDisciplina();
    private TMProfessor tmProfessor;
    private TMAluno tmAluno;
    private TMDisciplina tmDisciplina;
    
    /**
     * Creates new form JFtelainicial
     */
    public JFtelainicial() throws FileNotFoundException, IOException {
        initComponents();
        carregarDadosJson();
        salvarDadosJson();
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
        btnAluno = new javax.swing.JButton();
        btnProfessor = new javax.swing.JButton();
        btnDisciplina = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jblControleEscola = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnAluno.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnAluno.setText("Aluno");
        btnAluno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAlunoActionPerformed(evt);
            }
        });

        btnProfessor.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnProfessor.setText("Professor");
        btnProfessor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProfessorActionPerformed(evt);
            }
        });

        btnDisciplina.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnDisciplina.setText("Disciplina");
        btnDisciplina.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDisciplinaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(153, 153, 153)
                .addComponent(btnAluno, javax.swing.GroupLayout.DEFAULT_SIZE, 188, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(btnProfessor, javax.swing.GroupLayout.DEFAULT_SIZE, 188, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(btnDisciplina, javax.swing.GroupLayout.DEFAULT_SIZE, 188, Short.MAX_VALUE)
                .addGap(113, 113, 113))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(72, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAluno, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnProfessor, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDisciplina, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(66, 66, 66))
        );

        jblControleEscola.setFont(new java.awt.Font("Segoe UI", 3, 36)); // NOI18N
        jblControleEscola.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jblControleEscola.setText("Controle Escola");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jblControleEscola, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jblControleEscola, javax.swing.GroupLayout.DEFAULT_SIZE, 54, Short.MAX_VALUE)
                .addGap(22, 22, 22))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(49, 49, 49)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(153, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAlunoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAlunoActionPerformed
        JDAluno tela_aluno = new JDAluno(this, true, alunos, tmAluno);
        tela_aluno.setVisible(true);
        salvarDadosJson();
    }//GEN-LAST:event_btnAlunoActionPerformed

    private void btnProfessorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProfessorActionPerformed
        JDProfessor tela_professor = new JDProfessor(this, true, professor, tmProfessor);
        tela_professor.setVisible(true);
        salvarDadosJson();
    }//GEN-LAST:event_btnProfessorActionPerformed

    private void btnDisciplinaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDisciplinaActionPerformed
        JDDisciplina tela_disciplina = new JDDisciplina(this, true, professor, disciplina , alunos, tmAluno, tmProfessor, tmDisciplina);
        tela_disciplina.setVisible(true);
        salvarDadosJson();
    }//GEN-LAST:event_btnDisciplinaActionPerformed
    
    public void carregarDadosJson() throws FileNotFoundException, IOException {
        try {
            ObjectMapper mapper = new ObjectMapper();

            // Carregar Alunos
            List<Aluno> listaAlunos = mapper.readValue(new File("ListagemAlunos.json"), new TypeReference<List<Aluno>>() {});
            this.alunos.setAlunos(listaAlunos);

            // Carregar Professores
            List<Professor> listaProfessores = mapper.readValue(new File("ListagemProfessores.json"), new TypeReference<List<Professor>>() {});
            this.professor.setProfessores(listaProfessores);

            // Carregar Disciplinas
            List<Disciplina> listaDisciplinas = mapper.readValue(new File("ListagemDisciplinas.json"), new TypeReference<List<Disciplina>>() {});
            this.disciplina.setDisciplinas(listaDisciplinas);

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
    
    
    public void salvarDadosJson() {
        try {
            ObjectMapper mapper = new ObjectMapper();

            // Salvar Alunos
            mapper.writeValue(new File("ListagemAlunos.json"), this.alunos.getAlunos());

            // Salvar Professores
            mapper.writeValue(new File("ListagemProfessores.json"), this.professor.getProfessores());

            // Salvar Disciplinas
            mapper.writeValue(new File("ListagemDisciplinas.json"), this.disciplina.getDisciplinas());

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
}

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAluno;
    private javax.swing.JButton btnDisciplina;
    private javax.swing.JButton btnProfessor;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel jblControleEscola;
    // End of variables declaration//GEN-END:variables
}
