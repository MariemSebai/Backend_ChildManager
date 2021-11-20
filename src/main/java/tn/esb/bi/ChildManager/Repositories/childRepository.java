package tn.esb.bi.ChildManager.Repositories;
import org.springframework.stereotype.Repository;
import tn.esb.bi.ChildManager.Domains.Child;

import org.springframework.data.jpa.repository.JpaRepository;
@Repository
public interface childRepository extends JpaRepository<Child,Long> {
    
}
