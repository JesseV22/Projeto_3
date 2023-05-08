/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.projeto_3.ctr;

import br.com.projeto_3.dao.ConexaoDAO;
import br.com.projeto_3.dao.VendaDAO;
import br.com.projeto_3.dto.VendaDTO;
import br.com.projeto_3.dto.ClienteDTO;
import javax.swing.JTable;

public class VendaCTR {

    VendaDAO vendaDAO = new VendaDAO();

    public VendaCTR() {
     }
        

    

    public String inserirVenda(VendaDTO vendaDTO, ClienteDTO clienteDTO, JTable produtos) {
        try {
            //Chama o metodo que esta na classe DAO aguardando uma resposta (true ou false)
            if (vendaDAO.inserirVenda(vendaDTO)) {
                return "Venda Cadastrado com Sucesso!!!";
            } else {
                return "Venda NÃO Cadastrado!!!";
            }
        } //Caso tenha algum erro no codigo acima é enviado uma mensagem no 
        //console com o que esta acontecendo.		
        catch (Exception e) {
            System.out.println(e.getMessage());
            return "Venda NÃO Cadastrado";
        }
    }

}

