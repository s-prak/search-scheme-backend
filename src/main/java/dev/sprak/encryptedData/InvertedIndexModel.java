package dev.sprak.encryptedData;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.List;

@Document(collection = "inverted_index")
@Data  // Lombok generates Getters, Setters, toString, equals, and hashCode
@NoArgsConstructor  // Lombok generates a no-args constructor
public class InvertedIndexModel {

    @Id
    private String id;  // MongoDB ObjectId
    private String encryptedKeyword;
    private List<DocumentEntry> documents;

    // Inner static class for document entries
    @Data
    @NoArgsConstructor
    public static class DocumentEntry {
        private String encryptedDocId;
        private String encryptedScore; // Stored as String

        public DocumentEntry(String encryptedDocId, String encryptedScore) {
            this.encryptedDocId = encryptedDocId;
            this.encryptedScore = encryptedScore;
        }
    }

    public InvertedIndexModel(String encryptedKeyword, List<DocumentEntry> documents) {
        this.encryptedKeyword = encryptedKeyword;
        this.documents = documents;
    }
}
