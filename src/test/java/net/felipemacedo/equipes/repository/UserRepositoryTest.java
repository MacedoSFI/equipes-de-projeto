package net.felipemacedo.equipes.repository;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import net.felipemacedo.equipes.model.User;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@ActiveProfiles("test")
public class UserRepositoryTest {

	@Autowired
	private UserRepository repository;
	
	@Autowired
	private TestEntityManager em;
	
	@Test
	public void deveriaBuscarUmUsuarioPeloEmail() {
		User felipe = new User();
		felipe.setEmail("felipebbmacedo@gmail.com");
		felipe.setPassword("1234");
		em.persist(felipe);
		String emailUser = felipe.getEmail();
		User user = repository.findByEmail(emailUser).get();
		Assert.assertNotNull(user);
		Assert.assertEquals(emailUser, user.getEmail());
	}
	

}
