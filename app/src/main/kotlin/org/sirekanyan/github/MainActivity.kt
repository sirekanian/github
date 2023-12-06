package org.sirekanyan.github

import android.content.ActivityNotFoundException
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.activity.OnBackPressedCallback
import androidx.appcompat.app.AppCompatActivity
import org.sirekanyan.github.data.model.GithubRepo
import org.sirekanyan.github.databinding.GhMainActivityBinding
import org.sirekanyan.github.ui.details.RepoDetailsPresenter
import org.sirekanyan.github.ui.details.RepoDetailsPresenterImpl
import org.sirekanyan.github.ui.details.RepoDetailsViewImpl
import org.sirekanyan.github.ui.list.RepoListPresenter
import org.sirekanyan.github.ui.list.RepoListPresenterImpl
import org.sirekanyan.github.ui.list.RepoListViewImpl
import org.sirekanyan.github.utils.showToast

class MainActivity : AppCompatActivity(), RepoListPresenter.Router, RepoDetailsPresenter.Router {

    private val binding by lazy { GhMainActivityBinding.inflate(layoutInflater) }
    private val listPresenter: RepoListPresenter by lazy {
        RepoListPresenterImpl(this, app().githubApi).also {
            it.view = RepoListViewImpl(binding.repoListView, it)
        }
    }
    private val detailsPresenter: RepoDetailsPresenter by lazy {
        RepoDetailsPresenterImpl(this).also {
            it.view = RepoDetailsViewImpl(binding.repoDetailsView, it)
        }
    }
    private val onBackPressedCallback = object : OnBackPressedCallback(true) {
        override fun handleOnBackPressed() {
            if (detailsPresenter.isShown) {
                detailsPresenter.show(repo = null)
            } else {
                finish()
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        onBackPressedDispatcher.addCallback(onBackPressedCallback)
    }

    override fun onStart() {
        super.onStart()
        listPresenter.updateList()
    }

    override fun onStop() {
        detailsPresenter.cancel()
        listPresenter.cancel()
        super.onStop()
    }

    override fun openWebLink(repo: GithubRepo) {
        try {
            startActivity(Intent(Intent.ACTION_VIEW, Uri.parse(repo.url)))
        } catch (exception: ActivityNotFoundException) {
            showToast(R.string.gh_error_cannot_find_browser)
        } catch (exception: Exception) {
            exception.printStackTrace()
            showToast(R.string.gh_error_cannot_open_link)
        }
    }

    override fun showDetailsScreen(repo: GithubRepo) {
        detailsPresenter.show(repo)
    }

}
