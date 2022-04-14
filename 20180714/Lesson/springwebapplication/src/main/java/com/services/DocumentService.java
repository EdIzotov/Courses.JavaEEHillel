package com.services;

import com.dao.DocumentDao;
import com.model.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Service
public class DocumentService {
    @Autowired
    private DocumentDao documentDao;

    public List<Document> getAllDocuments() {
        return documentDao.getAllDocuments();
    }
}
