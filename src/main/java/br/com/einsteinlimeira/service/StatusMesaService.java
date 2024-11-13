package br.com.einsteinlimeira.service;

import br.com.einsteinlimeira.model.dto.StatusMesaDTO;
import br.com.einsteinlimeira.model.entity.StatusMesa;
import br.com.einsteinlimeira.repository.StatusMesaRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class StatusMesaService {

    @Autowired
    private StatusMesaRepository statusMesaRepository;

    public List<StatusMesaDTO> findAllTableStatus() {
        return statusMesaRepository.findAll().stream().map(StatusMesaDTO::new).toList();
    }

    public StatusMesaDTO findTableStatusById(Integer id) {
        StatusMesa statusMesa = statusMesaRepository.getReferenceById(id);
        return new StatusMesaDTO(statusMesa);
    }

    public StatusMesaDTO saveTableStatus(StatusMesaDTO statusMesaDTO) {
        StatusMesa statusMesa = statusMesaDTO.toEntity();
        return new StatusMesaDTO(statusMesa);
    }

    public StatusMesaDTO updateTableStatus(Integer id, StatusMesaDTO statusMesaDTO) {
        StatusMesa statusMesa = statusMesaRepository.getReferenceById(id);

        StatusMesa newStatusMesa = statusMesaDTO.toEntity();
        BeanUtils.copyProperties(newStatusMesa, statusMesa, "id");

        return new StatusMesaDTO(newStatusMesa);
    }

    public StatusMesaDTO deleteTableStatus(Integer id) {
        StatusMesa statusMesa = statusMesaRepository.getReferenceById(id);
        statusMesaRepository.delete(statusMesa);
        return new StatusMesaDTO(statusMesa);
    }
}