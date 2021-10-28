package com.example.pontoquente.service;

import com.example.pontoquente.model.Attribute;
import com.example.pontoquente.model.Product;
import com.example.pontoquente.model.SellerAddress;
import com.example.pontoquente.repository.ProductRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class ProductService {

    private final ProductRepository repository;
    private final SellerService sellerService;
    private final AttributeService attributeService;

    public ProductService(ProductRepository repository, SellerService sellerService, AttributeService attributeService) {
        this.repository = repository;
        this.sellerService = sellerService;
        this.attributeService = attributeService;
    }

    public Product create(Product product){
        product.setSite_id("PTQ");
        SellerAddress sellerAddress = findSellerAddressById(product.getSellerId());
        if (sellerAddress == null){ // Não encontrado no banco, cadastra conforme chegou na requisição
            sellerAddress = sellerService.create(product.getSeller_address());
        }
        Set<Attribute> attributos = attributeService.save(product.getAttributes());
        product.setAttributes(attributos);
        product.setSeller_address(sellerAddress);
        return repository.save(product);
    }

    @Transactional
    public Product update(Integer id, Product product) throws Exception {

        Product productById = findProductById(id);

        productById.setSite_id(product.getSite_id());
        productById.setBase_price(product.getBase_price());
        productById.setCondition(product.getCondition());
        productById.setAvailable_quantity(product.getAvailable_quantity());
        productById.setCurrency_id(product.getCurrency_id());
        productById.setId_integracao(product.getId_integracao());
        productById.setInitial_quantity(product.getInitial_quantity());
        productById.setOriginal_price(product.getOriginal_price());
        productById.setPermalink(product.getPermalink());
        productById.setPrice(product.getPrice());
        productById.setSeller_contact(product.getSeller_contact());
        productById.setSellerId(product.getSellerId());
        productById.setSubtitle(product.getSubtitle());
        productById.setTitle(product.getTitle());
        productById.setStart_time(product.getStart_time());
        productById.setStop_time(product.getStop_time());

        attributeService.deleteAll(productById.getAttributes());

        SellerAddress sellerAddress = findSellerAddressById(product.getSellerId());
        if (sellerAddress == null){ // Não encontrado no banco, cadastra conforme chegou na requisição
            sellerAddress = sellerService.create(product.getSeller_address());
        }
        product.setSeller_address(sellerAddress);
//        BeanUtils.copyProperties(product, productById, "product_id");

        return repository.save(productById);
    }

    private SellerAddress findSellerAddressById(long id){
        Optional<Product> bySeller_id = repository.findFirstBySellerIdEquals(id);
        if(bySeller_id.isPresent()) {
            return bySeller_id.get().getSeller_address();
        }
        return null;
    }

    private Product findProductById(long id) throws Exception {
        return repository.findById(id).orElseThrow( () -> new Exception("Produto não encontrado"));
    }

    public void delete(long id) throws Exception {
        Product productById = findProductById(id);
        repository.delete(productById);
    }

    public List<Product> getProducts() {
        return repository.findAll();
    }
}
