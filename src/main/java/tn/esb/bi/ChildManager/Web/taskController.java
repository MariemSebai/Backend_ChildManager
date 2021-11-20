package tn.esb.bi.ChildManager.Web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.esb.bi.ChildManager.Domains.Task;
import tn.esb.bi.ChildManager.Services.taskService;

import javax.validation.Valid;

@RestController
@RequestMapping("/tasks")
public class taskController {
    @Autowired
    private taskService taskServ;
    @GetMapping("/")
    public ResponseEntity<?> getTasks()
    {
        return taskServ.getAll();
    }
    @PostMapping("/new")
    public ResponseEntity<?> addTask(@RequestParam(name = "p") String idParent, @RequestParam(name = "c") String idChild, @Valid @RequestBody Task t)
    {
        return taskServ.add(t,Long.parseLong(idParent),Long.parseLong(idChild));
    }
}
