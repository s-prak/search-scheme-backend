package dev.sprak.encryptedData;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="encryptedData")
@Getter
@Setter
public class EncryptedDataModel {
    @Id
    String id;
    String document;
    String keyword;
}
