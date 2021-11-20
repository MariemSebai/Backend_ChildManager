package tn.esb.bi.ChildManager.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esb.bi.ChildManager.Domains.Report;
@Repository
public interface reportRepository extends JpaRepository<Report,Long> {
}
