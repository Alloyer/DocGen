package DocGen.controllers;

import DocGen.config.CustomUserDetails;
import DocGen.entities.Document;
import DocGen.service.DocumentService;
import DocGen.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DocumentController {

    @Autowired
    private DocumentService documentService;

    @Autowired
    private UserService userService;

    @GetMapping(value = "/")
    public String index() {
        return "index";
    }

    @GetMapping(value = "/documents")
    public List<Document> documents(){
        return documentService.getAllDocuments();
    }

    @PostMapping(value = "/document")
    public String addDocument(@RequestBody Document document){
        CustomUserDetails userDetails = (CustomUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        //тут возможен перехват значений==null и исправление этого
        if(document == null)
        {
            document = new Document();
            document.setName("DEFAULT DOCUMENT");
            document.setDescription("DEFAULT DESCRIPTION OF THE DEFAULT DOCUMENT!");
        }

        document.setCreator(userService.getUser(userDetails.getUsername()));
        documentService.addDocument(document);
        return "Doc was created!";
    }

    @GetMapping(value = "/documents/{username}")
    public List<Document> documentsByUser(@PathVariable String username) {
        return documentService.findByUser(userService.getUser(username));
    }
}
