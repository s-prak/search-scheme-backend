package dev.sprak.encryptedData;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface EncryptedDataRepository extends MongoRepository<EncryptedDataModel,String> {

    Optional<EncryptedDataModel> findByKeyword(String keyword);

}
