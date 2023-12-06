package org.sirekanyan.github.ui.list

import org.sirekanyan.github.arch.BaseView
import org.sirekanyan.github.databinding.GhListViewBinding

interface RepoListView : BaseView<GhListViewBinding> {

    interface Callbacks {
    }

}

class RepoListViewImpl(
    override val binding: GhListViewBinding,
    callbacks: RepoListView.Callbacks,
) : RepoListView {
}
