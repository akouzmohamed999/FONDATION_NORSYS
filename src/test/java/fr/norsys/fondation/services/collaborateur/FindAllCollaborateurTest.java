package fr.norsys.fondation.services.collaborateur;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/test/resources/ApplicationContextTest.xml")
@TestExecutionListeners({ DependencyInjectionTestExecutionListener.class, TransactionalTestExecutionListener.class })
public class FindAllCollaborateurTest extends ACollaborateurTest {

	@Test
	public void shouldReturnAll6Collaborateurs() {

		assertThat(this.collaborateurService.findAllCollaborateur().size()).isEqualTo(8);

		assertThat(this.collaborateurService.findAllCollaborateur().get(0)).isEqualTo(this.administrateur);
		assertThat(this.collaborateurService.findAllCollaborateur().get(1)).isEqualTo(this.responsable);
		assertThat(this.collaborateurService.findAllCollaborateur().get(2)).isEqualTo(this.collaborateur1);
		assertThat(this.collaborateurService.findAllCollaborateur().get(3)).isEqualTo(this.collaborateur2);
		assertThat(this.collaborateurService.findAllCollaborateur().get(4)).isEqualTo(this.collaborateur3);
		assertThat(this.collaborateurService.findAllCollaborateur().get(5)).isEqualTo(this.collaborateur4);
		assertThat(this.collaborateurService.findAllCollaborateur().get(6)).isEqualTo(this.collaborateur5);
		assertThat(this.collaborateurService.findAllCollaborateur().get(7)).isEqualTo(this.collaborateur6);
	}
}
