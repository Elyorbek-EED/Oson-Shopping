package product_service.service.productImage;


import online_shop_jar.criteria.BaseCriteria;
import online_shop_jar.exceptions.NotFoundException;
import online_shop_jar.response.DataDTO;
import online_shop_jar.service.AbstractService;
import online_shop_jar.service.BaseService;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import product_service.dtos.productImage.ProductImageCreateDTO;
import product_service.dtos.productImage.ProductImageDTO;
import product_service.dtos.productImage.ProductImageUpdateDTO;
import product_service.entity.product.ProductImage;
import product_service.mappers.productMapper.ProductImageMapper;
import product_service.repository.productImage.ProductImageRepository;
import product_service.validations.productImage.ProductImageValidator;

import java.util.List;

@Service
public class ProductImageServiceImpl extends AbstractService<ProductImageRepository,
        ProductImageMapper,
        ProductImageValidator>
        implements BaseService, ProductImageService<
        ProductImageDTO,
        ProductImageCreateDTO,
        ProductImageUpdateDTO,
        BaseCriteria,
        Integer> {

    public ProductImageServiceImpl(ProductImageRepository repository, ProductImageMapper mapper, ProductImageValidator validator) {
        super(repository, mapper, validator);
    }

    @Override
    public ResponseEntity<DataDTO<ProductImageDTO>> get(Integer id) {
        ProductImage productImage = repository.findById(id).orElseThrow(() -> {
            throw new NotFoundException("Product   was not found by id %s".formatted(id));
        });
        return new ResponseEntity<>(new DataDTO<>(mapper.toDTO(productImage), true), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<DataDTO<Void>> delete(Integer id) {
        ProductImage productImage = repository.findById(id).orElseThrow(() -> {
            throw new NotFoundException("Product   was not found by id %s".formatted(id));
        });
        repository.delete(productImage);
        return new ResponseEntity<>(new DataDTO<>( true), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<DataDTO<Void>> update(ProductImageUpdateDTO updateDto) {
      repository.findById(updateDto.getId()).orElseThrow(() -> {
            throw new NotFoundException("Product   was not found by id %s".formatted(updateDto.getId()));
        });
        ProductImage productImage1 = mapper.fromUpdateDTO(updateDto);
        repository.save(productImage1);
        return new ResponseEntity<>(new DataDTO<>( true), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<DataDTO<Integer>> create(ProductImageCreateDTO createDto) {
        validator.validOnCreate(createDto);
        ProductImage productImage = mapper.fromCreateDTO(createDto);
        ProductImage save = repository.save(productImage);
        return new ResponseEntity<>(new DataDTO<>( save.getId(),true), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<DataDTO<List<ProductImageDTO>>> getAll(BaseCriteria criteria) {
        Pageable pageable = PageRequest.of(criteria.getPage(), criteria.getSize());
        List<ProductImageDTO> productImageDTOS = mapper.toListDTO(repository.findAll(pageable).get().toList());
        return new ResponseEntity<>(new DataDTO<>(productImageDTOS, true), HttpStatus.OK);
    }
}
