package tn.esb.bi.ChildManager.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esb.bi.ChildManager.Domains.childPlace;
import tn.esb.bi.ChildManager.Domains.childPlaceId;

public interface taskLocationRepository extends JpaRepository<childPlace, childPlaceId> {
}
