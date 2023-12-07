package org.sirekanyan.github.ui.list

import kotlinx.coroutines.test.runTest
import org.junit.Test
import org.mockito.Mockito.inOrder
import org.mockito.Mockito.mock
import org.mockito.Mockito.verify
import org.mockito.Mockito.`when`
import org.sirekanyan.github.data.GithubApi
import org.sirekanyan.github.data.model.GithubRepo
import org.sirekanyan.github.data.model.GithubReposResponse
import org.sirekanyan.github.ui.list.RepoListPresenter.Router
import org.sirekanyan.github.utils.BaseTest

class RepoListPresenterTest : BaseTest() {

    private val view = mock<RepoListView>()
    private val router = mock<Router>()
    private val api = mock<GithubApi>()
    private val presenter = RepoListPresenterImpl(router, api).also { it.view = view }
    private val repo = GithubRepo(0, "name", "description", 0, 0, "language", "url")

    @Test
    fun `show repos when update list`() {
        testScope.runTest {
            `when`(api.getGithubRepos(1)).then { GithubReposResponse(listOf(repo)) }
            presenter.updateList()
            moveUntilIdle()
            inOrder(view).also {
                it.verify(view).showProgress(true)
                it.verify(view).showRepos(listOf(repo))
                it.verify(view).showProgress(false)
            }
        }
    }

    @Test
    fun `show error when update list`() {
        testScope.runTest {
            `when`(api.getGithubRepos(1)).thenThrow(RuntimeException())
            presenter.updateList()
            moveUntilIdle()
            inOrder(view).also {
                it.verify(view).showProgress(true)
                it.verify(view).showError()
                it.verify(view).showProgress(false)
            }
        }
    }

    @Test
    fun `show details on item click`() {
        presenter.onItemClicked(repo)
        verify(router).showDetailsScreen(repo)
    }

}
