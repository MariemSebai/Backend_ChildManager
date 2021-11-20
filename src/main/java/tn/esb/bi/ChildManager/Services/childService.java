package tn.esb.bi.ChildManager.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import tn.esb.bi.ChildManager.Domains.Child;
import tn.esb.bi.ChildManager.Domains.Parent;
import tn.esb.bi.ChildManager.Repositories.childRepository;
import tn.esb.bi.ChildManager.Repositories.parentRepository;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class childService {
    @Autowired
    private childRepository childRepos;
    @Autowired
    private parentRepository parentRepos;

    public childService(childRepository childRepos, parentRepository parentRepos) {
        this.childRepos = childRepos;
        this.parentRepos = parentRepos;
    }

    public ResponseEntity<?> getAll()
    {
        List<Child> res=childRepos.findAll();
        if(res.isEmpty())
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body("There isn't any parent");
        return new ResponseEntity<>(res,HttpStatus.OK);
    }
    public ResponseEntity<?> add(Child c, Long idParent)
    {
        try {
            Optional<Parent> pres=parentRepos.findById(idParent);
            if(pres.isEmpty())
                return ResponseEntity
                        .status(HttpStatus.NOT_FOUND)
                        .body("The parent is not found");

            Parent part= pres.get();
            Child child = childRepos.save(c);
            Set<Child> childSet=part.getChildren();
            childSet.add(child);
            part.setChildren(childSet);
            part.setId(part.getId());
            parentRepos.save(part);//update the parent children list
            return new ResponseEntity<>(child, HttpStatus.CREATED);
        }catch (Exception  e)
        {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }
}
