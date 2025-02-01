package dev.sprak.encryptedData;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EncryptedDataService {

    @Autowired
    private EncryptedDataRepository encryptedDataRepository;

    public String getDocumentByKeyword(String keyword){
        return encryptedDataRepository.findByKeyword(keyword)
                .map(EncryptedDataModel::getDocument) // Extract the document if present
                .orElse("null");
    }
}
