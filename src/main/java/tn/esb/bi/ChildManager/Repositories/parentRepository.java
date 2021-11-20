package tn.esb.bi.ChildManager.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esb.bi.ChildManager.Domains.Parent;
@Repository
public interface parentRepository extends JpaRepository<Parent,Long> {
}
