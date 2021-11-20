package tn.esb.bi.ChildManager.Web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.esb.bi.ChildManager.Domains.Parent;
import tn.esb.bi.ChildManager.Services.parentService;

import javax.validation.Valid;

@RestController
@RequestMapping("/parents")
public class parentController {
    @Autowired
    private parentService parentServ;
    @GetMapping("/all")
    public ResponseEntity<?> getParents()
    {
        return parentServ.getAll();
    }
    @PostMapping("/new")
    public ResponseEntity<?> addTeam(@Valid @RequestBody Parent p)
    {
        return parentServ.add(p);
    }
    @GetMapping("children/{id}")
    public ResponseEntity<?> getAllChildren(@PathVariable("id") Long idParent)
    {
        return parentServ.getChildren(idParent);
    }
}
