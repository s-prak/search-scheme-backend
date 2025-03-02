package dev.sprak.encryptedData;

import dev.sprak.encryptedData.InvertedIndexModel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface InvertedIndexRepository extends MongoRepository<InvertedIndexModel, String> {
    Optional<InvertedIndexModel> findByEncryptedKeyword(String encryptedKeyword);
    // Custom query methods (if needed) can be defined here
}