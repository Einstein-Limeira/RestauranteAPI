package br.com.einsteinlimeira.service;

import br.com.einsteinlimeira.exceptions.ResourceNotFoundException;
import br.com.einsteinlimeira.model.dto.FichaDTO;
import br.com.einsteinlimeira.model.entity.Ficha;
import br.com.einsteinlimeira.repository.FichaRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class FichaService {

    @Autowired
    private FichaRepository fichaRepository;

    public List<FichaDTO> findAll() {
        return fichaRepository.findAll().stream().map(FichaDTO::new).toList();
    }

    public FichaDTO findById(Integer id) {
        return fichaRepository.findById(id).map(FichaDTO::new).orElseThrow(() -> new ResourceNotFoundException("Ficha", id));
    }

    public FichaDTO save(FichaDTO fichaDTO) {
        return new FichaDTO(fichaRepository.save(fichaDTO.toEntity()));
    }

    public FichaDTO update(Integer id, FichaDTO fichaDTO) {
        Ficha ficha = fichaRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Ficha", id));

        Ficha newFicha = fichaDTO.toEntity();
        BeanUtils.copyProperties(newFicha, ficha, "id");

        return new FichaDTO(fichaRepository.save(fichaDTO.toEntity()));
    }

    public FichaDTO delete(Integer id) {
        Ficha ficha = fichaRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Ficha", id));
        fichaRepository.delete(ficha);
        return new FichaDTO(ficha);
    }
}