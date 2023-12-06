package org.sirekanyan.github

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import org.sirekanyan.github.data.model.GithubRepo
import org.sirekanyan.github.databinding.GhMainActivityBinding
import org.sirekanyan.github.ui.details.RepoDetailsPresenter
import org.sirekanyan.github.ui.list.RepoListPresenter
import org.sirekanyan.github.ui.list.RepoListPresenterImpl
import org.sirekanyan.github.ui.list.RepoListViewImpl

class MainActivity : AppCompatActivity(), RepoListPresenter.Router, RepoDetailsPresenter.Router {

    private val binding by lazy { GhMainActivityBinding.inflate(layoutInflater) }

    private val listPresenter: RepoListPresenter by lazy {
        RepoListPresenterImpl(this, app().githubApi).also {
            it.view = RepoListViewImpl(binding.repoListView, it)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
    }

    override fun onStart() {
        super.onStart()
        listPresenter.updateList()
    }

    override fun onStop() {
        listPresenter.cancel()
        super.onStop()
    }

    override fun showDetailsScreen(repo: GithubRepo) {
    }

}
