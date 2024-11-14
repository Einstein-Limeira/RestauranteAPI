package br.com.einsteinlimeira.service;

import br.com.einsteinlimeira.model.dto.MesaDTO;
import br.com.einsteinlimeira.model.entity.Mesa;
import br.com.einsteinlimeira.repository.MesaRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class MesaService {

    @Autowired
    private MesaRepository mesaRepository;

    public List<MesaDTO> findAllTables() {
        return mesaRepository.findAll().stream().map(MesaDTO::new).toList();
    }

    public MesaDTO findTableById(Integer id) {
        Mesa findTable = mesaRepository.getReferenceById(id);
        return new MesaDTO(findTable);
    }

    public MesaDTO saveTable(MesaDTO mesaDTO) {
        return new MesaDTO(mesaRepository.save(mesaDTO.toEntity()));
    }

    public MesaDTO updateTable(Integer id, MesaDTO mesaDTO) {
        Mesa mesa = mesaRepository.getReferenceById(id);

        Mesa newTable = mesaDTO.toEntity();
        BeanUtils.copyProperties(newTable, mesa, "id");

        return new MesaDTO(mesaRepository.save(mesaDTO.toEntity()));
    }

    public MesaDTO deleteTable(Integer id) {
        Mesa mesa = mesaRepository.getReferenceById(id);
        mesaRepository.delete(mesa);
        return new MesaDTO(mesa);
    }
}