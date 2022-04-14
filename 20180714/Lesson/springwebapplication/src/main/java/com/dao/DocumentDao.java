package com.dao;

import com.model.Document;
import com.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Repository
public class DocumentDao {
    @Autowired
    private UserDao userDao;
    private List<Document> documentList = new ArrayList<>();

    @PostConstruct
    public void init() {
        List<User> allUsers =  userDao.getAllUsers();
        documentList = Arrays.asList(new Document("Document 1", allUsers.get(0)),
                new Document("Document 2", allUsers.get(1)),
                new Document("Document 3", allUsers.get(2)));
    }
    public List<Document> getAllDocuments() {
        return documentList;
    }
}
