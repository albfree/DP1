
package acme.features.anonymous.manuelBulletin;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.bulletins.ManuelBulletin;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface AnonymousManuelBulletinRepository extends AbstractRepository {

	@Query("select g from ManuelBulletin g")
	Collection<ManuelBulletin> findMany();
}
