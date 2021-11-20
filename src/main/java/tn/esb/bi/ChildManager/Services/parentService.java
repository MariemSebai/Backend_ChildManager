package tn.esb.bi.ChildManager.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import tn.esb.bi.ChildManager.Domains.Parent;
import tn.esb.bi.ChildManager.Repositories.parentRepository;

import java.util.List;
import java.util.Optional;

@Service
public class parentService {
    @Autowired
    private parentRepository parentRepos;
    public ResponseEntity<?> getAll()
    {
        List<Parent> res=parentRepos.findAll();
        if(res.isEmpty())
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body("There isn't any parent");
        return new ResponseEntity<>(res,HttpStatus.OK);
    }
    public ResponseEntity<?> add(Parent p)
    {
        try {
            Parent parent = parentRepos.save(p);
            return new ResponseEntity<>(parent, HttpStatus.CREATED);
        }catch (Exception  e)
        {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }
    public ResponseEntity<?> getChildren(Long idParent)
    {
        Optional<Parent> pres=parentRepos.findById(idParent);
        if(pres.isEmpty())
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body("The parent is not found");

        Parent part= pres.get();
        return  new ResponseEntity<>(part.getChildren(),HttpStatus.OK);
    }
}
