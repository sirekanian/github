package org.sirekanyan.github.ui.details

import org.sirekanyan.github.arch.BaseView
import org.sirekanyan.github.databinding.GhDetailsViewBinding

interface RepoDetailsView : BaseView<GhDetailsViewBinding> {

    interface Callbacks {
    }

}

class RepoDetailsViewImpl(
    override val binding: GhDetailsViewBinding,
    callbacks: RepoDetailsView.Callbacks,
) : RepoDetailsView {
}
