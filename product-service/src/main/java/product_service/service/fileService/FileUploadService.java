package product_service.service.fileService;

import online_shop_jar.response.DataDTO;
import online_shop_jar.service.BaseService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;
import product_service.dtos.file.FileDTO;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;


@Service
public class FileUploadService implements BaseService {
    private final String FILE_UPLOAD_PATH = "/home/elyor/IdeaProjects/online-shop/src/main/resources/static/images";
    private Path rootLocation;

    public FileUploadService() {
        rootLocation = Paths.get(FILE_UPLOAD_PATH);
    }

    public ResponseEntity<DataDTO<FileDTO>> save(MultipartFile file) {
        try {
            String org_name = file.getOriginalFilename();
            String extension = StringUtils.getFilenameExtension(org_name);
            String generatedName = System.currentTimeMillis() + "." + extension;
            Files.copy(file.getInputStream(), Paths.get(FILE_UPLOAD_PATH, generatedName), StandardCopyOption.REPLACE_EXISTING);
            return new ResponseEntity<>(new DataDTO<>(new FileDTO(generatedName, "upload/" + generatedName),true), HttpStatus.OK);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
