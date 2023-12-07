package org.sirekanyan.github.ui.details

import org.junit.Test
import org.mockito.Mockito.mock
import org.mockito.Mockito.verify
import org.sirekanyan.github.data.model.GithubRepo
import org.sirekanyan.github.ui.details.RepoDetailsPresenter.Router

class RepoDetailsPresenterTest {

    private val view = mock<RepoDetailsView>()
    private val router = mock<Router>()
    private val presenter = RepoDetailsPresenterImpl(router).also { it.view = view }
    private val repo = GithubRepo(0, "name", "description", 0, 0, "language", "url")

    @Test
    fun `open web link on open click`() {
        presenter.show(repo)
        presenter.onOpenClick()
        verify(router).openWebLink(repo)
    }

}
