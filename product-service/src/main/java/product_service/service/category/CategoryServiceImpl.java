package product_service.service.category;

import online_shop_jar.exceptions.NotFoundException;
import online_shop_jar.response.DataDTO;
import online_shop_jar.service.AbstractService;
import online_shop_jar.service.BaseService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import product_service.dtos.category.CategoryCreateDTO;
import product_service.dtos.category.CategoryDTO;
import product_service.dtos.category.CategoryUpdateDTO;
import product_service.entity.category.Category;
import product_service.mappers.category.CategoryMapper;
import product_service.repository.category.CategoryRepository;
import product_service.validations.category.CategoryValidator;

import java.util.List;


@Service
public class CategoryServiceImpl extends AbstractService<CategoryRepository,
        CategoryMapper,
        CategoryValidator> implements BaseService, CategoryService<
        CategoryDTO, CategoryCreateDTO, CategoryUpdateDTO, Integer> {

    protected CategoryServiceImpl(CategoryRepository repository, CategoryMapper mapper, CategoryValidator validator) {
        super(repository, mapper, validator);
    }

    public ResponseEntity<DataDTO<List<CategoryDTO>>> getAll() {
        return new ResponseEntity<>(new DataDTO<>(mapper.toListDTO(repository.findAll()), true), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<DataDTO<CategoryDTO>> get(Integer id) {
        Category category = repository.findById(id).orElseThrow(() -> {
            throw new NotFoundException("Category   was not found by id %s".formatted(id));
        });
        return new ResponseEntity<>(new DataDTO<>(mapper.toDTO(category), true), HttpStatus.OK);
    }

    public ResponseEntity<DataDTO<Void>> delete(Integer id) {
        repository.findById(id).orElseThrow(() -> {
            throw new NotFoundException("Category was not found by id %s".formatted(id));
        });
        repository.deleteById(id);
        return new ResponseEntity<>(new DataDTO<>(true), HttpStatus.OK);
    }

    public ResponseEntity<DataDTO<Integer>> create(CategoryCreateDTO categoryCreateDto) {
        validator.validOnCreate(categoryCreateDto);
        Category category = mapper.fromCreateDTO(categoryCreateDto);
        repository.save(category);
        return new ResponseEntity<>(new DataDTO<>(category.getId(), true), HttpStatus.OK);
    }


    public ResponseEntity<DataDTO<Void>> update(CategoryUpdateDTO categoryUpdateDto) {
        validator.validOnUpdate(categoryUpdateDto);
        Category category = repository.findById(categoryUpdateDto.getId()).orElseThrow(() -> {
            throw new NotFoundException("Category   was not found by id %s".formatted(categoryUpdateDto.getId()));
        });
        category = mapper.fromUpdateDTO(categoryUpdateDto, category);
        repository.save(category);
        return new ResponseEntity<>(new DataDTO<>(true), HttpStatus.OK);
    }
}

