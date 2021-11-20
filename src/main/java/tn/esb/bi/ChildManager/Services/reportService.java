package tn.esb.bi.ChildManager.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esb.bi.ChildManager.Repositories.reportRepository;

@Service
public class reportService {
    @Autowired
    private reportRepository reportRepos;
}
