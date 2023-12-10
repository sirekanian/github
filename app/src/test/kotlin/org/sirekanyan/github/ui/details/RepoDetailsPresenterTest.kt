package org.sirekanyan.github.ui.details

import org.junit.Test
import org.mockito.Mockito.mock
import org.mockito.Mockito.verify
import org.sirekanyan.github.ui.details.RepoDetailsPresenter.Router
import org.sirekanyan.github.utils.createGithubRepo

class RepoDetailsPresenterTest {

    private val view = mock<RepoDetailsView>()
    private val router = mock<Router>()
    private val presenter = RepoDetailsPresenterImpl(router).also { it.view = view }
    private val repo = createGithubRepo()

    @Test
    fun `open web link on open click`() {
        presenter.show(repo)
        presenter.onOpenClick()
        verify(router).openWebLink(repo)
    }

}
