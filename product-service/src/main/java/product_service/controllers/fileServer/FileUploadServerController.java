package product_service.controllers.fileServer;


import online_shop_jar.controller.AbstractController;
import online_shop_jar.response.DataDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import product_service.dtos.file.FileDTO;
import product_service.dtos.file.FileUploadDTO;
import product_service.service.fileService.FileUploadService;

@RestController
public class FileUploadServerController extends AbstractController<FileUploadService> {

    public FileUploadServerController(FileUploadService service) {
        super(service);
    }

    @PostMapping(value = PATH + "/file/upload")
    public ResponseEntity<DataDTO<FileDTO>> fileUpload(@RequestBody FileUploadDTO dto) {
        return service.save(dto.getFile());
    }
}