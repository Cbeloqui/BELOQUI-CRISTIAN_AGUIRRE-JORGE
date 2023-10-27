package com.backend.test;

import com.backend.dao.impl.OdontoloDaoH2;
import com.backend.model.Odontologo;
import com.backend.service.OdontologoService;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ArrayList;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class OdontologoServiceTest {

    private OdontologoService odontologoService;

    @BeforeAll
    static void doBefore() {
        Connection connection = null;
        try {
            Class.forName("org.h2.Driver");
            connection = DriverManager.getConnection("jdbc:h2:~/parcial;INIT=RUNSCRIPT FROM 'create.sql'", "sa", "sa");

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }

    @Test
    void deberiaAgregarYRetornarIdDeOdontologoEnH2() {
        odontologoService = new OdontologoService(new OdontoloDaoH2());
        Odontologo odontologoAPersistir = new Odontologo(1234, "Jorge", "Alfaro");

        Odontologo odontologoPersistido = odontologoService.registrarOdontologo(odontologoAPersistir);

        assertNotNull(odontologoPersistido.getId());

    }


//    @Test
//    void deberiaAgregarYRetornarIdDeMedicamentoEnMemoria() {
//        medicamentoService = new MedicamentoService(new MedicamentoDaoMemoria(new ArrayList<>()));
//        Medicamento medicamentoAPersistir = new Medicamento(35465, "Aspirina", "Bayer", 50, 200);
//        Medicamento medicamentoPersistido = medicamentoService.registrarMedicamento(medicamentoAPersistir);
//        assertNotNull(medicamentoPersistido.getId());
//
//    }


}
