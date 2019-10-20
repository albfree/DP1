
package acme.features.anonymous.manuelBulletin;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.bulletins.ManuelBulletin;
import acme.framework.components.Errors;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Anonymous;
import acme.framework.services.AbstractCreateService;

@Service
public class AnonymousManuelBulletinCreateService implements AbstractCreateService<Anonymous, ManuelBulletin> {

	@Autowired
	private AnonymousManuelBulletinRepository repository;


	@Override
	public boolean authorise(final Request<ManuelBulletin> request) {
		assert request != null;

		return true;
	}

	@Override
	public void bind(final Request<ManuelBulletin> request, final ManuelBulletin entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;

		request.bind(entity, errors);
	}

	@Override
	public void unbind(final Request<ManuelBulletin> request, final ManuelBulletin entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "writer", "subject");
	}

	@Override
	public ManuelBulletin instantiate(final Request<ManuelBulletin> request) {
		assert request != null;
		ManuelBulletin bulletin = new ManuelBulletin();
		bulletin.setWriter("");
		bulletin.setSubject("");
		bulletin.setMoment(new Date(System.currentTimeMillis() - 1));

		return bulletin;
	}

	@Override
	public void validate(final Request<ManuelBulletin> request, final ManuelBulletin entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;

	}

	@Override
	public void create(final Request<ManuelBulletin> request, final ManuelBulletin entity) {
		assert request != null;
		assert entity != null;

		entity.setMoment(new Date(System.currentTimeMillis() - 1));

		this.repository.save(entity);
	}

}
