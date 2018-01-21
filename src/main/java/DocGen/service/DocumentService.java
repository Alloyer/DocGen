package DocGen.service;

import DocGen.entities.Document;
import DocGen.entities.User;
import DocGen.repositories.DocumentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by alloyer on 10.01.2018.
 */
@Service
public class DocumentService {

    @Autowired
    private DocumentRepository documentRepository;

    public List<Document> getAllDocuments(){
        return documentRepository.findAll();
    }

    public void addDocument(Document document){
        documentRepository.save(document);
    }

    public List<Document> findByUser(User user) {
        return documentRepository.findByCreatorId(user.getId());
    }
}
