package dev.sprak.encryptedData;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EncryptedDataController {
    private EncryptedDataRepository encryptedDataRepository;

    @Autowired
    private EncryptedDataService encryptedDataService;

    @Autowired
    public EncryptedDataController(EncryptedDataRepository encryptedDataRepository){
        this.encryptedDataRepository=encryptedDataRepository;
    }

    @CrossOrigin(origins = "http://localhost:3001")
    @PostMapping("/DataOwner")
    public String addDocument(@RequestBody EncryptedDataModel document){
        encryptedDataRepository.save(document);
        return "Document created successfully";
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/DataUser/{keyword}")
    public String getByKeyword(@PathVariable String keyword){
        return encryptedDataService.getDocumentByKeyword(keyword);
    }

    // New endpoint: Get all documents for DataOwner
    @CrossOrigin(origins = "http://localhost:3001")
    @GetMapping("/DataOwner")
    public List<EncryptedDataModel> getAllDocumentsForOwner() {
        return encryptedDataRepository.findAll();
    }

    // New endpoint: Get all documents for DataUser
    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/DataUser")
    public List<EncryptedDataModel> getAllDocumentsForUser() {
        return encryptedDataRepository.findAll();
    }
}
