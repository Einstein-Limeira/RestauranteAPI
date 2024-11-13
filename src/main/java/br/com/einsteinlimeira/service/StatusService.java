package br.com.einsteinlimeira.service;

import br.com.einsteinlimeira.model.dto.StatusDTO;
import br.com.einsteinlimeira.model.entity.Status;
import br.com.einsteinlimeira.repository.StatusRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class StatusService {

    @Autowired
    private StatusRepository statusRepository;

    public List<StatusDTO> findAllStatus() {
        return statusRepository.findAll().stream().map(StatusDTO::new).toList();
    }

    public StatusDTO findStatusById(Integer id) {
        Status status = statusRepository.getReferenceById(id);
        return new StatusDTO(status);
    }

    public StatusDTO saveStatus(StatusDTO statusDTO) {
        Status status = statusDTO.toEntity();
        status = statusRepository.save(status);
        return new StatusDTO(status);
    }

    public StatusDTO updateStatus(Integer id, StatusDTO statusDTO) {
        Status status = statusRepository.getReferenceById(id);

        Status newStatus = statusDTO.toEntity();
        BeanUtils.copyProperties(newStatus, status, "id");

        return new StatusDTO(statusRepository.save(status));
    }

    public StatusDTO deleteStatus(Integer id) {
        Status status = statusRepository.getReferenceById(id);
        statusRepository.delete(status);
        return new StatusDTO(status);
    }
}