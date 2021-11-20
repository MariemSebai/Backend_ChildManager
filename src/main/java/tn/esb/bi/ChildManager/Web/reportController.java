package tn.esb.bi.ChildManager.Web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import tn.esb.bi.ChildManager.Services.reportService;

@RestController
public class reportController {
    @Autowired
    private reportService reportServ;
}
