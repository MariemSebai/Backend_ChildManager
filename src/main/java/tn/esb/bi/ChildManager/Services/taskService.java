package tn.esb.bi.ChildManager.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import tn.esb.bi.ChildManager.Domains.Child;
import tn.esb.bi.ChildManager.Domains.Parent;
import tn.esb.bi.ChildManager.Domains.Task;
import tn.esb.bi.ChildManager.Repositories.childRepository;
import tn.esb.bi.ChildManager.Repositories.parentRepository;
import tn.esb.bi.ChildManager.Repositories.taskRepository;

import java.util.List;
import java.util.Optional;

@Service
public class taskService {
    @Autowired
    private taskRepository taskRepos;
    @Autowired
    private parentRepository parentRepos;
    @Autowired
    private childRepository childRepos;

    public taskService(taskRepository taskRepos, parentRepository parentRepos, childRepository childRepos) {
        this.taskRepos = taskRepos;
        this.parentRepos = parentRepos;
        this.childRepos = childRepos;
    }

    public ResponseEntity<?> getAll()
    {
        List<Task> res=taskRepos.findAll();
        if(res.isEmpty())
            return new ResponseEntity(null, HttpStatus.NO_CONTENT);
        return new ResponseEntity<>(res,HttpStatus.OK);
    }
    public ResponseEntity<?> add(Task t, Long idParent, Long idChild)
    {
        //verifier si le parent p existe ou nom
        Optional<Parent> pres=parentRepos.findById(idParent);
        if(pres.isEmpty())
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body("The parent is not found");

        Parent part= pres.get();
        //verifier si l'enfant "c" figure dans la liste des enfants du parent "part"
        //si l'enfant n'existe pas alors on l'ajoute

        Optional<Child> cres=childRepos.findById(idChild);
        if(cres.isEmpty())
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body("The child is not found");
        Optional<Child> child1=part.getChildren().stream().filter(c->c.getId()==idChild).findFirst();
        if(child1.isEmpty())
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body("The child is not in given parent child list");

        Child child=child1.get();
        Task savedTask=taskRepos.save(t);
        child.getChildTasks().add(savedTask);

        return new ResponseEntity<>(savedTask,HttpStatus.OK);
    }
}
