/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.progAvUD.taller1.vista;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

/**
 * Panel de la factura con productos, cantidades, precios y total.
 */
public class PanelFactura extends JPanel {
    private JTable tablaFactura;
    private DefaultTableModel modeloFactura;
    private JButton btnFinalizarPedido;
    private JLabel lblTotal;
    private JLabel lblPuntos;
    private double totalFactura;
    private int puntosAcumulados;

    /**
     * Constructor que inicializa el panel de factura.
     */
    public PanelFactura() {
        setLayout(new BorderLayout(10, 10));

        // Configuración de la tabla de productos en la factura
        String[] columnas = {"Producto", "Cantidad", "Precio Unitario", "Subtotal"};
        modeloFactura = new DefaultTableModel(columnas, 0);
        tablaFactura = new JTable(modeloFactura);
        JScrollPane scrollPane = new JScrollPane(tablaFactura);
        add(scrollPane, BorderLayout.CENTER);

        // Panel inferior con el botón para finalizar pedido
        JPanel panelBotones = new JPanel(new FlowLayout());
        btnFinalizarPedido = new JButton("Finalizar Pedido");
        panelBotones.add(btnFinalizarPedido);

        add(panelBotones, BorderLayout.SOUTH);

        // Etiquetas para mostrar el total y los puntos acumulados
        JPanel panelInfo = new JPanel(new GridLayout(2, 1, 5, 5));
        lblTotal = new JLabel("Total: $0.00");
        lblPuntos = new JLabel("Puntos acumulados: 0");

        panelInfo.add(lblTotal);
        panelInfo.add(lblPuntos);
        add(panelInfo, BorderLayout.NORTH);
    }

    /**
     * Permite agregar un producto a la tabla de la factura.
     * @param producto Nombre del producto.
     * @param cantidad Cantidad del producto.
     * @param precioUnitario Precio unitario del producto.
     * @param subtotal Subtotal (cantidad * precio unitario).
     */
    public void agregarFactura(String producto, int cantidad, double precioUnitario, double subtotal) {
        Object[] fila = {producto, cantidad, precioUnitario, subtotal};
        modeloFactura.addRow(fila);

        // Actualizamos el total de la factura
        totalFactura += subtotal;
        lblTotal.setText(String.format("Total: $%.2f", totalFactura));

        // Aquí podrías agregar el cálculo de los puntos si es necesario
        puntosAcumulados = (int) (totalFactura / 1000);  // 1 punto por cada 1000 pesos
        lblPuntos.setText("Puntos acumulados: " + puntosAcumulados);
    }

    /**
     * Método para finalizar el pedido.
     * Aquí podrías llamar al controlador para completar el pago, por ejemplo.
     */
    public void finalizarPedido() {
        // Lógica para finalizar el pedido
        JOptionPane.showMessageDialog(this, "Pedido Finalizado. ¡Gracias por tu compra!");
    }

    public JButton getBtnFinalizarPedido() {
        return btnFinalizarPedido;
    }

    // Métodos para obtener información de la factura si es necesario.
    public double getTotalFactura() {
        return totalFactura;
    }

    public int getPuntosAcumulados() {
        return puntosAcumulados;
    }

}
