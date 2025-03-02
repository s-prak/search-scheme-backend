package dev.sprak.encryptedData;

import dev.sprak.encryptedData.InvertedIndexModel;
import dev.sprak.encryptedData.InvertedIndexRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class InvertedIndexService {

    @Autowired
    private InvertedIndexRepository invertedIndexRepository;

    /**
     * 1. Save keyword, docId, and score
     * - If the keyword exists, update its documents list.
     * - If it doesn't exist, create a new entry.
     */
    public void saveDocumentEntry(String encryptedKeyword, String encryptedDocId, String encryptedScore) {
        Optional<InvertedIndexModel> optionalIndex = invertedIndexRepository.findByEncryptedKeyword(encryptedKeyword);

        InvertedIndexModel invertedIndex;
        if (optionalIndex.isPresent()) {
            // If keyword exists, update the documents list
            invertedIndex = optionalIndex.get();
        } else {
            // If keyword does not exist, create a new entry
            invertedIndex = new InvertedIndexModel();
            invertedIndex.setEncryptedKeyword(encryptedKeyword);
            invertedIndex.setDocuments(new java.util.ArrayList<>());
        }

        // Add the new document entry
        invertedIndex.getDocuments().add(new InvertedIndexModel.DocumentEntry(encryptedDocId, encryptedScore));
        invertedIndexRepository.save(invertedIndex);
    }

    /**
     * 2. Retrieve all document entries for a given keyword
     */
    public List<InvertedIndexModel.DocumentEntry> getDocumentsByKeyword(String encryptedKeyword) {
        return invertedIndexRepository.findByEncryptedKeyword(encryptedKeyword)
                .map(InvertedIndexModel::getDocuments)
                .orElse(java.util.Collections.emptyList());
    }
}
