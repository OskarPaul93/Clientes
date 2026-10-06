package com.krakedev.clientes;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import com.krakedev.clientes.entidades.Cliente;
import com.krakedev.clientes.services.ServicioCliente;

public class ServicioClienteTest {

    @Test
    public void testCrearCliente() {

        ServicioCliente servicio = new ServicioCliente();

        Cliente cliente = new Cliente(
                "1234567890",
                "Oscar",
                "Perez",
                "oscar@gmail.com"
        );

        Cliente resultado = servicio.crear(cliente);

        assertNotNull(resultado);
        assertEquals("oscar@gmail.com", resultado.getEmail());
    }
    
    @Test
    public void testConsultarCliente() {

        ServicioCliente servicio = new ServicioCliente();

        Cliente cliente = new Cliente(
                "1234567890",
                "Oscar",
                "Perez",
                "oscar@gmail.com"
        );

        servicio.crear(cliente);

        Cliente resultado = servicio.buscarPorCedula("1234567890");

        assertEquals("Oscar", resultado.getNombre());
        assertEquals("Perez", resultado.getApellido());
        assertEquals("oscar@gmail.com", resultado.getEmail());
    }
    
    
    @Test
    public void testActualizarCliente() {

        ServicioCliente servicio = new ServicioCliente();

        Cliente cliente = new Cliente(
                "1234567890",
                "Oscar",
                "Perez",
                "oscar@gmail.com"
        );

        servicio.crear(cliente);

        Cliente clienteActualizado = new Cliente(
                "1234567890",
                "Oscar",
                "Perez",
                "oscar.nuevo@gmail.com"
        );

        Cliente resultado = servicio.actualizar(
                "1234567890",
                clienteActualizado
        );

        assertEquals("oscar.nuevo@gmail.com", resultado.getEmail());
    }
    
    
    @Test
    public void testEliminarCliente() {

        ServicioCliente servicio = new ServicioCliente();

        Cliente cliente = new Cliente(
                "1234567890",
                "Oscar",
                "Perez",
                "oscar@gmail.com"
        );

        servicio.crear(cliente);

        boolean resultado = servicio.eliminar("1234567890");

        assertTrue(resultado);

        Cliente clienteEliminado = servicio.buscarPorCedula("1234567890");

        assertNull(clienteEliminado);
    }
    
    
    
}
