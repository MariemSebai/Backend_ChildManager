package tn.esb.bi.ChildManager.Web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import tn.esb.bi.ChildManager.Services.taskLocationService;

@RestController
public class taskLocationController {
    @Autowired
    private taskLocationService childLocationServ;
}
