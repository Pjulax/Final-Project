package pl.pp.store.raporting.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import pl.pp.store.raporting.dto.StoredProductsListDto;
import pl.pp.store.raporting.model.StoredProduct;
import pl.pp.store.raporting.repository.ArticleRepository;
import pl.pp.store.raporting.repository.StoreRepository;
import pl.pp.store.raporting.repository.StoredProductRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductService {

    private final ArticleRepository articleRepository;
    private final StoredProductRepository storedProductRepository;
    private final StoreRepository storeRepository;

    public StoredProductsListDto getAllStoredProducts(){

        StoredProductsListDto storedProducts;

        List<StoredProduct> storedProductList = storedProductRepository.findAll();
        if(!storedProductList.isEmpty()){
            storedProducts = StoredProductsListDto.fromDomain(storedProductList.get(0).getStore(), storedProductList);
            log.debug(storedProducts.toString());
            return storedProducts;
        }
        return null;

    }

}
