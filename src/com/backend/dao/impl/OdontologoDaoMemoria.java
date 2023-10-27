package com.backend.dao.impl;

import com.backend.dao.IDao;
import com.backend.model.Odontologo;
import org.apache.log4j.Logger;

import java.util.List;

public class OdontologoDaoMemoria implements IDao<Odontologo> {

    private final Logger LOGGER = Logger.getLogger(OdontologoDaoMemoria.class);

    private List<Odontologo> odontologoRepository;

    public OdontologoDaoMemoria(List<Odontologo> odontologoRepository) {
        this.odontologoRepository = odontologoRepository;
    }

    @Override
    public Odontologo registrar(Odontologo odontologo) {
        int id = odontologoRepository.size() + 1 ;
        odontologoRepository.add(odontologo);
        Odontologo odontologoGuardado = new Odontologo(
                id,
                odontologo.getNumeroMatricula(),
                odontologo.getNombre(),
                odontologo.getApellido());

        LOGGER.info("Odontologo guardado: " + odontologoGuardado);
        return odontologo;
    }

    @Override
    public List<Odontologo> listar() {
        return null;

    }
}
