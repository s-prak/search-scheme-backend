package dev.sprak.encryptedData;

import dev.sprak.encryptedData.InvertedIndexModel;
import dev.sprak.encryptedData.InvertedIndexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/inverted-index")
public class InvertedIndexController {

    @Autowired
    private InvertedIndexService invertedIndexService;

    // 1. Save a document entry
    @PostMapping("/save")
    public String saveDocumentEntry(
            @RequestParam String keyword,
            @RequestParam String docId,
            @RequestParam String score) {
        invertedIndexService.saveDocumentEntry(keyword, docId, score);
        return "Entry saved!";
    }

    // 2. Retrieve document entries for a keyword
    @GetMapping("/search")
    public List<InvertedIndexModel.DocumentEntry> getDocumentsByKeyword(@RequestParam String keyword) {
        return invertedIndexService.getDocumentsByKeyword(keyword);
    }
}