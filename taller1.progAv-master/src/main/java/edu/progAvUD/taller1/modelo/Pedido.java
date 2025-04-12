package edu.progAvUD.taller1.modelo;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Pedido {
    private List<Producto> productos;
    private Pago metodoPago;
    private Usuario usuario; // Guardamos el usuario para calcular descuentos correctamente

    public Pedido() {
        this.productos = new ArrayList<>();
    }

    public void agregarProducto(Producto producto) {
        productos.add(producto);
    }

    public double calcularTotalSinDescuento() {
        return productos.stream()
                .mapToDouble(Producto::calcularPrecioFinal)
                .sum();
    }

    public double calcularTotalConDescuento() {
        double total = calcularTotalSinDescuento();
        if (usuario != null) {
            if (usuario.getEdad() >= 60) {
                total *= 0.90; // 10% de descuento por ser mayor de 60
            }
            if (usuario.isEsIndigena()) {
                total *= 0.92; // 8% de descuento adicional si es indígena
            }
        }
        return total;
    }

    public Factura generarFactura() {
        StringBuilder detalle = new StringBuilder("Detalle del pedido:\n");

        for (Producto producto : productos) {
            detalle.append("- ")
                    .append(producto.getNombre())
                    .append(": $")
                    .append(producto.calcularPrecioFinal())
                    .append("\n");
        }

        double totalFinal = calcularTotalConDescuento();

        detalle.append("\nTotal: $").append(totalFinal);

        return new Factura(detalle.toString(), totalFinal);
    }

    public void setMetodoPago(Pago metodoPago) {
        this.metodoPago = metodoPago;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
