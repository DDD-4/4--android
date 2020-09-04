package com.ddd4.dropit.presentation.ui.detailFolder

import android.content.Intent
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import com.ddd4.dropit.presentation.R
import com.ddd4.dropit.presentation.base.ui.BaseActivity
import com.ddd4.dropit.presentation.databinding.ActivityFolderItemDetailBinding
import com.ddd4.dropit.presentation.ui.folder.FolderViewModel
import com.ddd4.dropit.presentation.util.Constants
import com.ddd4.dropit.presentation.util.toast
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FolderItemDetailActivity : BaseActivity<ActivityFolderItemDetailBinding>(R.layout.activity_folder_item_detail) {

    private val viewModel: FolderItemDetailViewModel by viewModels()
    private var itemId = -1L

    override fun setBind() {
        binding.apply {
            detailItemViewModel = viewModel
        }

        itemId = getId(intent)
        viewModel.start(itemId)
    }

    override fun setObserve() {
        viewModel.testIsEmpty.observe(this, Observer {
            this.toast("1자 이상 입력해주세요.")
        })
    }

    private fun getId(intent: Intent): Long {
        return intent.getLongExtra(Constants.EXTRA_NAME_ITEM_ID, -1)
    }
}
