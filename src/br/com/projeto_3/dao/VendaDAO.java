/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.projeto_3.dao;

import br.com.projeto_3.dto.ClienteDTO;
import br.com.projeto_3.dto.VendaDTO;
import java.sql.*;
import java.text.SimpleDateFormat;
import javax.swing.JTable;
        
public class VendaDAO {
    
    public VendaDAO () {}
        //Atributo do tipo ResulSet utilizado para realizar consultas
        private ResultSet rs = null;
        //Manipular o banco de dados
        Statement stmt = null;
        Statement stmt1 = null;
        SimpleDateFormat date = new SimpleDateFormat("dd/MM/yyyy");
        
        public boolean inserirVenda(VendaDTO vendaDTO, ClienteDTO clienteDTO, JTable produtos) {
            try{
                
                ConexaoDAO.ConectDB();
                stmt = ConexaoDAO.con.createStatement();
                stmt1 = ConexaoDAO.con.createStatement();
                
                //comando SQL que sera executado no banco de dados
                String comando1 = "Insert into Vanda (dat_vend, val_vend, "
                        +"id_cli)values ( "
                        +"to_date('" + date.format(vendaDTO.getDat_vend()) + "', 'DD//MM/YYYY'),"
                        + vendaDTO.getVal_vend() + ","
                        + clienteDTO.getId_cli()+ ")";
                        
                        //Executa o comando SQL no banco de Dados
                        
                       stmt.execute(comando1.toUpperCase(),Statement.RETURN_GENERATED_KEYS);
                       rs = stmt.getGeneratedKeys();
                       rs.next();
                       
                       for(int cont=0; cont < produtos.getRowCount (); cont++){
                           String comando2 = "Insert into produto venda (id_vend, id_prod, "
                                   + "val_prod , qtd_prod) values ("
                                   + rs.getInt("id_vend") + ","
                                   + produtos.getValueAt(cont, 0) + ", "
                                   + produtos.getValueAt(cont, 2) + ", "
                                   + produtos.getValueAt(cont, 3) + ");";
                           stmt.execute(comando2);                    
                                          
                       }
                       //Da um commit no banco de dados
                       ConexaoDAO.con.commit();
                       //Fecha o statement
                       stmt.close();
                       stmt1.close();
                       rs.close();
                       return true;      
                
                
            }//Caso tenha algum erro no codigo acima enviando uma mensaggem no console
            catch (Exception e ) {
            System.out.println(e.getMessage());
            return false;
        }// independente e dar erro ou nao ele vai fechar o banco de dados.
        finally {
            //Chama o metodo da classe CONEXAODAO para fechar o banco de dados
            ConexaoDAO.CloseDB();
}
        } //fecha chave do boolean

    public boolean inserirVenda(VendaDTO vendaDTO) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
} //fecha metod inserirVenda
