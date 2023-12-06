package org.sirekanyan.github.ui.details

import androidx.core.view.WindowInsetsCompat
import org.sirekanyan.github.arch.BaseView
import org.sirekanyan.github.data.model.GithubRepo
import org.sirekanyan.github.databinding.GhDetailsViewBinding
import org.sirekanyan.github.utils.applyInsets
import org.sirekanyan.github.utils.hide
import org.sirekanyan.github.utils.show
import org.sirekanyan.github.utils.showText

interface RepoDetailsView : BaseView<GhDetailsViewBinding> {

    fun show(repo: GithubRepo)
    fun hide()

    interface Callbacks {
        fun onOpenClick()
    }

}

class RepoDetailsViewImpl(
    override val binding: GhDetailsViewBinding,
    callbacks: RepoDetailsView.Callbacks,
) : RepoDetailsView {

    init {
        binding.toolbar.root.applyInsets(WindowInsetsCompat.Type.statusBars())
        binding.root.applyInsets(WindowInsetsCompat.Type.navigationBars())
        binding.openButton.setOnClickListener { callbacks.onOpenClick() }
    }

    override fun show(repo: GithubRepo) {
        binding.root.show()
        binding.toolbar.title.text = repo.name
        binding.description.text = repo.description
        binding.stars.text = repo.formattedStars()
        binding.forks.text = repo.formattedForks()
        binding.language.showText(repo.language)
    }

    override fun hide() {
        binding.root.hide()
    }

}
