package project.myschelin.domain.store.repository;

import org.springframework.web.multipart.MultipartFile;
import project.myschelin.exception.image.FileNotExistException;
import project.myschelin.exception.image.NotSupportedFileTypeException;
import project.myschelin.exception.repository.RepositoryException;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class FileLocalRepository {
    public String save(MultipartFile imageFile) {
        if(imageFile.isEmpty()) throw new FileNotExistException("파일이 존재하지 않습니다.");
        String absolutePath = new File("src/main/resources/static/img").getAbsolutePath();

        String contentType = imageFile.getContentType();
        String fileExtension;
        if(contentType.contains("image/jpeg")) {
            fileExtension = ".jpg";
        } else if (contentType.contains("image/png")) {
            fileExtension = ".png";
        } else {
            throw new NotSupportedFileTypeException("지원하지 않는 이미지 타입입니다. " + contentType);
        }
        String currentTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH-mm-ss-SSS"));
        File file = new File(absolutePath + "/" + currentTime + fileExtension);

        try {
            imageFile.transferTo(file);
        } catch (IOException e) {
            e.printStackTrace();
            throw new RepositoryException("알 수 없는 오류 : 파일을 쓸 수 없습니다.");
        }
        return currentTime + fileExtension;
    }
}
