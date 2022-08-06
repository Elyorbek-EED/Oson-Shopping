package product_service.service.product;

import online_shop_jar.exceptions.NotFoundException;
import online_shop_jar.response.DataDTO;
import online_shop_jar.service.AbstractService;
import online_shop_jar.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import product_service.criteria.product.ProductCriteria;
import product_service.criteria.product.ProductSortCriteria;
import product_service.dtos.product.FilterDTO;
import product_service.dtos.product.ProductCreateDTO;
import product_service.dtos.product.ProductDTO;
import product_service.dtos.product.ProductUpdateDTO;
import product_service.entity.category.Category;
import product_service.entity.product.Product;
import product_service.enums.status.Status;
import product_service.mappers.product.ProductMapper;
import product_service.repository.product.ProductRepository;
import product_service.validations.product.ProductValidator;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class ProductServiceImpl extends AbstractService<ProductRepository,
        ProductMapper,
        ProductValidator>
        implements BaseService, ProductService<
        ProductDTO,
        ProductCreateDTO,
        ProductUpdateDTO,
        ProductCriteria,
        Integer> {


    @Autowired
    public ProductServiceImpl(ProductRepository repository, ProductMapper mapper, ProductValidator validator) {
        super(repository, mapper, validator);
    }


    @Override
    public ResponseEntity<DataDTO<ProductDTO>> get(Integer id) {
        Product product = repository.findById(id).orElseThrow(() -> {
            throw new NotFoundException("Product   was not found by id %s".formatted(id));
        });
        ProductDTO productDTO = mapper.toDTO(product);
        productDTO.setCategory(product.getCategory().getId());
        return new ResponseEntity<>(new DataDTO<>(productDTO, true), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<DataDTO<Void>> block(Integer id) {
        Product product = repository.findById(id).orElseThrow(() -> {
            throw new NotFoundException("Product   was not found by id %s".formatted(id));
        });
        product.setStatus(Status.BLOCK);
        repository.save(product);
        return new ResponseEntity<>(new DataDTO<>(true), HttpStatus.OK);
    }

    public ResponseEntity<DataDTO<Void>> delete(Integer id) {
        repository.findById(id).orElseThrow(() -> {
            throw new NotFoundException("Product was not found by id %s".formatted(id));
        });
        repository.deleteById(id);
        return new ResponseEntity<>(new DataDTO<>(true), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<DataDTO<Void>> unblock(Integer id) {
        Product product = repository.findById(id).orElseThrow(() -> {
            throw new NotFoundException("Product   was not found by id %s".formatted(id));
        });
        product.setStatus(Status.ACTIVE);
        repository.save(product);
        return new ResponseEntity<>(new DataDTO<>(true), HttpStatus.OK);
    }


    public ResponseEntity<DataDTO<Void>> update(ProductUpdateDTO productUpdateDto) {
        Product product = repository.findById(productUpdateDto.getId()).orElseThrow(() -> {
            throw new NotFoundException("Product   was not found by id %s".formatted(productUpdateDto.getId()));
        });
        if (!productUpdateDto.getName().isBlank()) {
            product.setName(productUpdateDto.getName());
        }
        if (!productUpdateDto.getDescription().isBlank()) {
            product.setDescription(productUpdateDto.getDescription());
        }
        if (productUpdateDto.getPrice() != null) {
            product.setPrice(productUpdateDto.getPrice());
        }
        product.setUpdatedAt(LocalDateTime.now());
        repository.save(product);
        return new ResponseEntity<>(new DataDTO<>(true), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<DataDTO<Integer>> create(ProductCreateDTO createDto) {
        validator.validOnCreate(createDto);
        Product product = mapper.fromCreateDTO(createDto);
        product.setCategory(getCategory(createDto.getCategory()));
        product.setStatus(Status.ACTIVE);
        repository.save(product);
        return new ResponseEntity<>(new DataDTO<>(product.getId(), true), HttpStatus.OK);
    }

    private Category getCategory(Integer category) {
        return repository.findCategory(category).orElseThrow(() -> {
            throw new NotFoundException("Category   was not found by id %s".formatted(category));
        });
    }

    @Override
    public ResponseEntity<DataDTO<List<ProductDTO>>> getAll(ProductCriteria criteria) {
            Pageable pageable = PageRequest.of(criteria.getPage(), criteria.getSize());
        List<ProductDTO> productDTOS = mapper.toListDTO(repository.findAll(pageable).get().toList());
        return new ResponseEntity<>(new DataDTO<>(productDTOS, true), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<DataDTO<List<ProductDTO>>> blockList(ProductCriteria criteria) {
        Pageable pageable = PageRequest.of(criteria.getPage(), criteria.getSize());
        Optional<List<Product>> allBlocked = repository.getAllBlocked(pageable);
        List<ProductDTO> productDTOS = mapper.toListDTO(allBlocked.get());
        return new ResponseEntity<>(new DataDTO<>(productDTOS, true), HttpStatus.OK);
    }

    public ResponseEntity<DataDTO<List<ProductDTO>>> search(String word) {
        List<Product> productList = repository.findAllByNameContains(word);
        List<ProductDTO> productDtos = mapper.toListDTO(productList);
        for (ProductDTO productDto : productDtos) {
//                        productDto.setImage_path(imageService.getByMain(productDto.getId()).getBody().getImage_path());
        }
        return new ResponseEntity<>(new DataDTO<>(productDtos,true), HttpStatus.OK);
    }



    public ResponseEntity<DataDTO<List<ProductDTO>>> filter(FilterDTO filterDto) {
        return new ResponseEntity<>(new DataDTO<>(filters(filterDto), true), HttpStatus.OK);
    }
    public List<ProductDTO> filters(FilterDTO filterDto) {
        List<Product> products = new ArrayList<>();
        if ((Objects.nonNull(filterDto.getCategory()) && filterDto.getCategory() != 0)  && (Objects.nonNull(filterDto.getMaxPrice()) && filterDto.getMaxPrice() != 0) && ( Objects.nonNull(filterDto.getMinPrice()) && filterDto.getMinPrice() != 0) &&( Objects.nonNull(filterDto.getColor()) && filterDto.getColor() != 0) ){
              products.addAll(categoryAndPriceAndColor(filterDto));
              return mapper.toListDTO(products);
        }
        if ((Objects.nonNull(filterDto.getCategory()) && filterDto.getCategory() != 0) && (Objects.nonNull(filterDto.getMaxPrice()) && filterDto.getMaxPrice() != 0) && ( Objects.nonNull(filterDto.getMinPrice()) && filterDto.getMinPrice() != 0) ){
              products.addAll(categoryAndPrice(filterDto));
            return mapper.toListDTO(products);
        }
        if ( (Objects.nonNull(filterDto.getMaxPrice()) && filterDto.getMaxPrice() != 0) && ( Objects.nonNull(filterDto.getMinPrice()) && filterDto.getMinPrice() != 0) &&( Objects.nonNull(filterDto.getColor()) && filterDto.getColor() != 0) ){
              products.addAll(priceAndColor(filterDto));
            return mapper.toListDTO(products);
        }
        if (Objects.nonNull( filterDto.getCategory()) &&( Objects.nonNull(filterDto.getColor()) && filterDto.getColor() != 0) ){
              products.addAll(categoryAndColor(filterDto));
            return mapper.toListDTO(products);
        }
        if ((Objects.nonNull(filterDto.getCategory()) && filterDto.getCategory() != 0)){
              products.addAll(category(filterDto));
            return mapper.toListDTO(products);
        }if ((Objects.nonNull(filterDto.getMaxPrice()) && filterDto.getMaxPrice() != 0)) {
              products.addAll(price(filterDto));
            return mapper.toListDTO(products);
        }if (Objects.nonNull(filterDto.getColor()) && filterDto.getColor() != 0) {
              products.addAll(color(filterDto));
            return mapper.toListDTO(products);
        }
        return null;
    }

    public List<Product> categoryAndPriceAndColor(FilterDTO filterDto){
        return repository.getProductCategoryAndPriceAndColor(filterDto.getMaxPrice(), filterDto.getMinPrice(),
                filterDto.getCategory(),filterDto.getColor()).stream().toList();
    }
    public List<Product> categoryAndPrice(FilterDTO filterDto){
        return repository.getProductWithCategoryAndPrice(filterDto.getMaxPrice(), filterDto.getMinPrice(), filterDto.getCategory()).stream().toList();
    }
    public List<Product> categoryAndColor(FilterDTO filterDto){
        return repository.getProductCategoryAndColor( filterDto.getCategory(),filterDto.getColor()).stream().toList();
    }
    public List<Product> priceAndColor(FilterDTO filterDto){
        return repository.getProductPriceAndColor(filterDto.getMaxPrice(), filterDto.getMinPrice(), filterDto.getColor()).stream().toList().stream().toList();
    }
  public List<Product> category(FilterDTO filterDto){
        return repository.getProductWithCategory(filterDto.getCategory());
    }
    public List<Product> price(FilterDTO filterDto){
        return repository.getProducts(filterDto.getMaxPrice(), filterDto.getMinPrice()).stream().toList();
    }
    public List<Product> color(FilterDTO filterDto){
        return repository.getProductColors(filterDto.getColor()).stream().toList();
    }




    public ResponseEntity<DataDTO<List<ProductDTO>>> sort(ProductSortCriteria criteria) {
        List<Product> all = repository.findAll();
        List<ProductDTO> products = filterSortBy(criteria.getSortDirection(), mapper.toListDTO(all), criteria);
//        List<Product> products = repository.sortByProductCriteria(criteria.getSortBy(), criteria.getSortDirection(),criteria.getSize(), criteria.getPage());
        return new ResponseEntity<>(new DataDTO<>(products, true), HttpStatus.OK);
    }
    public List<ProductDTO> filterSortBy( String orderBy, List<ProductDTO> list, ProductSortCriteria criteria) {
        if (Objects.equals(orderBy, "0")) return list;
        List<ProductDTO> products = new ArrayList<>();
        if (Objects.equals(orderBy, "ASC")) {
            return getAllDtoWithOrderAsc(criteria);
        } else if (Objects.equals(orderBy, "DESC")) {
            return getAllDtoWithOrderDesc(criteria);
        }
        return products;
    }

    public List<ProductDTO> getAllDtoWithOrderDesc(ProductSortCriteria criteria) {
        Pageable request = PageRequest.of(criteria.getPage(), criteria.getSize(), Sort.by(criteria.getSortBy()).descending());
        Page<Product> all = repository.findAll(request);
        List<ProductDTO> productDtos = mapper.toListDTO(all.stream().toList());
//        for (ProductDTO productDto : productDtos) {
//                        productDto.setImage_path(imageService.getByMain(productDto.getId()).getBody().getImage_path());
//        }
        return productDtos;
    }

    public List<ProductDTO> getAllDtoWithOrderAsc(ProductSortCriteria criteria) {
        Pageable request = PageRequest.of(criteria.getPage(), criteria.getSize(), Sort.by(criteria.getSortBy()).ascending());
        Page<Product> all = repository.findAll(request);
        List<ProductDTO> productDtos = mapper.toListDTO(all.stream().toList());
//        for (ProductDTO productDto : productDtos) {
//                        productDto.setImage_path(imageService.getByMain(productDto.getId()).getBody().getImage_path());
//        }
        return productDtos;
    }

}