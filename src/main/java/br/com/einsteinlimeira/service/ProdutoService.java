package br.com.einsteinlimeira.service;

import br.com.einsteinlimeira.model.dto.ProdutoDTO;
import br.com.einsteinlimeira.model.entity.Produto;
import br.com.einsteinlimeira.repository.ProdutoRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    public List<ProdutoDTO> findAllProducts() {
        return produtoRepository.findAll().stream().map(ProdutoDTO::new).toList();
    }

    public ProdutoDTO findProductById(Integer id) {
        Produto findProduct = produtoRepository.getReferenceById(id);
        return new ProdutoDTO(findProduct);
    }

    public ProdutoDTO saveProduct(ProdutoDTO produtoDTO) {
        return new ProdutoDTO(produtoRepository.save(produtoDTO.toEntity()));
    }

    public ProdutoDTO updateProduct(Integer id, ProdutoDTO produtoDTO) {
        Produto produto = produtoRepository.getReferenceById(id);

        Produto newProduct = produtoDTO.toEntity();
        BeanUtils.copyProperties(newProduct, produto, "id");

        return new ProdutoDTO(produtoRepository.save(produto));
    }

    public ProdutoDTO deleteProduct(Integer id) {
        Produto produto = produtoRepository.getReferenceById(id);
        produtoRepository.delete(produto);
        return new ProdutoDTO(produto);
    }
}