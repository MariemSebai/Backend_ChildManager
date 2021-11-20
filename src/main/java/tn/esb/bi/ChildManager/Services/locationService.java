package tn.esb.bi.ChildManager.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esb.bi.ChildManager.Repositories.locationRepository;

@Service
public class locationService {
    @Autowired
    private locationRepository locationRepos;
}
