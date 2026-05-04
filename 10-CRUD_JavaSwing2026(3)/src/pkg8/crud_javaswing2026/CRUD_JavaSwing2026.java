/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package pkg8.crud_javaswing2026;

import java.util.ArrayList;
import model.DaoVeiculo;
import model.Veiculo;
import view.VeiculoView;

/**
 *
 * @author aluno.lab
 */
public class CRUD_JavaSwing2026 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args){
        DaoVeiculo daoVeiculo = new DaoVeiculo();
        ArrayList<Veiculo> veiculos = daoVeiculo.listarTodos();
        
        for(Veiculo vei : veiculos){
            System.out.println(vei.getModelo() + " - " + vei.getMarca());
        }
        
        /* deixa a aparência mais moderna */
        //com.formdev.flatlaf.FlatLightLaf.setup();    // Tema Claro
        com.formdev.flatlaf.FlatDarkLaf.setup();     // Tema Escuro
        
        new VeiculoView().setVisible(true);
    }   
}