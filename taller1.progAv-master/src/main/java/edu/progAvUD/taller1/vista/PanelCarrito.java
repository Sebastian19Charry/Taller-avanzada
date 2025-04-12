/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.progAvUD.taller1.vista;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;


/**
 * Panel del carrito de compras
 */
public class PanelCarrito extends JPanel {
    
    private JTable tablaCarrito;
    private DefaultTableModel modeloTabla;
    private JButton btnPagar;
    private JButton btnCancelar;
    
    /**
     * Constructor que inicializa el panel del carrito.
     */
    public PanelCarrito() {
        setLayout(new BorderLayout(10, 10));

        // Configuración de la tabla
        String[] columnas = {"Producto", "Cantidad", "Precio"};
        modeloTabla = new DefaultTableModel(columnas, 0);
        tablaCarrito = new JTable(modeloTabla);

        JScrollPane scrollPane = new JScrollPane(tablaCarrito);
        add(scrollPane, BorderLayout.CENTER);

        // Panel inferior con botones
        JPanel panelBotones = new JPanel(new FlowLayout());

        btnPagar = new JButton("Pagar");
        btnCancelar = new JButton("Cancelar Pedido");

        panelBotones.add(btnPagar);
        panelBotones.add(btnCancelar);

        add(panelBotones, BorderLayout.SOUTH);
    }

    /**
     * Permite agregar un producto a la tabla del carrito.
     * @param producto Nombre del producto.
     * @param cantidad Cantidad del producto.
     * @param precio Precio total del producto.
     */
    public void agregarProducto(String producto, int cantidad, double precio) {
        Object[] fila = {producto, cantidad, precio};
        modeloTabla.addRow(fila);
    }

    public JButton getBtnPagar() {
        return btnPagar;
    }

    public JButton getBtnCancelar() {
        return btnCancelar;
    
}
/**
 *
 * @author Sebastian
 */

}
