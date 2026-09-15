package com.audiovisuales.prestamo.Service.ServiceImpl;

import com.audiovisuales.prestamo.Entity.Accesorio;
import com.audiovisuales.prestamo.Repository.AccesorioRepository;
import com.audiovisuales.prestamo.Service.AccesorioService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class AccesorioServiceImpl implements AccesorioService {

    private final AccesorioRepository accesorioRepository;

    public AccesorioServiceImpl(AccesorioRepository accesorioRepository) {
        this.accesorioRepository = accesorioRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Accesorio> listarTodos() {
        return accesorioRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Accesorio obtenerPorId(Long id) {
        return accesorioRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("accesorio no encontrado con ID"+id));
    }

    @Override
    @Transactional
    public Accesorio crear(Accesorio accesorio) {
        return accesorioRepository.save(accesorio);
   }

    @Override
    public Accesorio actualizar(Long id, Accesorio detalles) {
        Accesorio accesorio = obtenerPorId(id);
        accesorio.setNombre(detalles.getNombre());
        accesorio.setCantidad(detalles.getCantidad());
        accesorio.setEquipoAsociado(detalles.getEquipoAsociado());
        return accesorioRepository.save(accesorio);
    }

    @Override
    @Transactional
    public void eliminar(Long id) {
        if (!accesorioRepository.existsById(id)){
            throw new RuntimeException("accesorio no encontrado con ID"+id);
        }

    }
}
