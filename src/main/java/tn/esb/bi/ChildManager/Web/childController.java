package tn.esb.bi.ChildManager.Web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.esb.bi.ChildManager.Domains.Child;
import tn.esb.bi.ChildManager.Services.childService;

import javax.validation.Valid;

@RestController
@RequestMapping("/children")
public class childController {
    @Autowired
    private childService childServ;
    @GetMapping("/all")
    public ResponseEntity<?> getChildren()
    {
        return childServ.getAll();
    }
    @PostMapping("/new/{id}")
    public ResponseEntity<?> addChild(@PathVariable("id") Long idParent, @Valid @RequestBody Child c)
    {
        return childServ.add(c,idParent);
    }
}
