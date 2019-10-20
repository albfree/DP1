
package acme.features.anonymous.manuelBulletin;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.bulletins.ManuelBulletin;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Anonymous;
import acme.framework.services.AbstractListService;

@Service
public class AnonymousManuelBulletinListService implements AbstractListService<Anonymous, ManuelBulletin> {

	@Autowired
	private AnonymousManuelBulletinRepository repository;


	@Override
	public boolean authorise(final Request<ManuelBulletin> request) {
		assert request != null;

		return true;
	}

	@Override
	public void unbind(final Request<ManuelBulletin> request, final ManuelBulletin entity, final Model model) {

		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "moment", "writer", "subject");
	}

	@Override
	public Collection<ManuelBulletin> findMany(final Request<ManuelBulletin> request) {
		assert request != null;

		//Another option for this findMany is findAll
		return this.repository.findMany();
		//return null;
	}

}
